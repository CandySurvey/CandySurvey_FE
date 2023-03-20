package com.flatwater.candysurvey

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.flatwater.candysurvey.databinding.ActivityMainBinding
import com.flatwater.candysurvey.produce.ProduceActivity
import com.flatwater.candysurvey.setting.MyPageActivity
import com.flatwater.candysurvey.setting.SettingActivity
import com.flatwater.candysurvey.surveyList.SurveyListRVAdapter
import com.flatwater.candysurvey.surveyList.SurveyModel
import com.google.android.material.navigation.NavigationView
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    var backPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 리사이클러뷰 어댑터와 연결해서 설문 아이템 메인페이지에 랜더링
        val rv_surveyItem = findViewById<RecyclerView>(R.id.rv_surveyItemArea)
        val itemList = ArrayList<SurveyModel>()

        itemList.add(SurveyModel("짜장","2023-03-20", "78명"))
        itemList.add(SurveyModel("짬뽕","2023-03-20", "89명"))
        itemList.add(SurveyModel("탕수육","2023-03-20", "110명"))
        itemList.add(SurveyModel("탕수육","2023-03-20", "110명"))
        itemList.add(SurveyModel("탕수육","2023-03-20", "110명"))
        itemList.add(SurveyModel("탕수육","2023-03-20", "110명"))

        val surveyAdapter = SurveyListRVAdapter(itemList)
        surveyAdapter.notifyDataSetChanged()

        rv_surveyItem.adapter = surveyAdapter
        rv_surveyItem.layoutManager = GridLayoutManager(applicationContext, 2)

        // 설문지 제작하기 버튼 클릭 이벤트 연결
        val makeSurveyDialog = MakeSurveyDialog(this)
        binding.makeSurveyBtn.setOnClickListener{

            makeSurveyDialog.showMakeSurveyDialog()

            makeSurveyDialog.setOnClickedListener(object : MakeSurveyDialog.ButtonClickListener {
                override fun onClicked(surveyTitle: String) {
                    // 제목을 입력했을 경우에는 ProduceActivity로 넘어가고, 그렇지 않을 경우에는 Dialog 닫아주는 코드
                    if(surveyTitle.length > 0){

                        val intent = Intent(baseContext, ProduceActivity::class.java)

                        // ProduceActivity로 데이터 넘겨주는 코드
                        intent.putExtra("surveyTitle", surveyTitle)

                        startActivity(intent)
                        finish()
                        // 받아온 제목을 ProduceActivity의 상단 제목에 넣어주어야 함 (미완)
                    } else {
                        Toast.makeText(baseContext, "제목을 입력해주세요..", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

        // 메뉴 버튼에 클릭 이벤트 연결
        binding.menuBtn.setOnClickListener{
            if(!binding.drawerLayout.isDrawerOpen(GravityCompat.START))
                binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        // 네비게이션 아이템을 이벤트 처리 함수와 연결
        val drawerNav = binding.drawerNav
        drawerNav.setNavigationItemSelectedListener(this)

        // 네비게이션 뒤로가기 버튼 기능 구현
        // 네비게이션 헤더 접근 (유저 닉네임 받아올 때 사용해야함)
        val headerView = drawerNav.getHeaderView(0)
        val closeBtn = headerView.findViewById<ImageButton>(R.id.closeBtn)
        closeBtn.setOnClickListener{
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    // 네비게이션 아이템 선택할 때 발행하는 이벤트 처리 함수
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mypage -> {
                val intent = Intent(this, MyPageActivity::class.java)
                startActivity(intent)
            }
            R.id.setting -> {
                val intent = Intent(this, SettingActivity::class.java)
                startActivity(intent)
            }
        }
        return false
    }

    // 두번 터치 앱 종료 기능 구현
    override fun onBackPressed() {
        if(backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finishAffinity()
        } else {
            Toast.makeText(this, "정말 종료하시겠습니까?", Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }

}