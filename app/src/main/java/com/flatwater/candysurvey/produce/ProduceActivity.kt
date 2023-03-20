package com.flatwater.candysurvey.produce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.flatwater.candysurvey.MainActivity
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityProduceBinding
import com.flatwater.candysurvey.setting.MyPageActivity
import com.flatwater.candysurvey.template.TitleTemplateModel
import com.flatwater.candysurvey.template.TitleTemplateRVAdapter

class ProduceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProduceBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_produce)

        // MainActivity에서 SurveyTitle Data 받아오는 코드
        val surveyTitle = intent.getStringExtra("surveyTitle")
        binding.surveyTitle.text = surveyTitle

        // 뒤로가기 버튼 연결
        binding.closeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 저장 버튼 연결
        val saveDialog = SaveDialog(this)
        binding.saveBtn.setOnClickListener {
            saveDialog.showSaveDialog()
            // SaveDialog에서 yesBtn을 클릭하면 true값 -> ProduceActivity에서 데이터 메인 액티비티로 전달해서 블록 생성
            // SaveDialog에서 noBtn을 클릭하면 false값 -> ProduceActivity에서 작업하던 상태 그대로 유지
        }

        // 초기 제목 템플릿 자동으로 연결
        val rv_default = findViewById<RecyclerView>(R.id.surveyArea)
        val itemList = ArrayList<TitleTemplateModel>()

        itemList.add(TitleTemplateModel("candy", ""))

        val templateTitleAdapter = TitleTemplateRVAdapter(itemList)
        templateTitleAdapter.notifyDataSetChanged()

        rv_default.adapter = templateTitleAdapter
        rv_default.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // 메인페이지 네비게이션 연결
        binding.navigateMainPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 마이페이지 네비게이션 연결
        binding.navigateMyPage.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 메뉴 버튼 dialog 연결
        val menuDialog = MenuDialog(this)
        binding.plusBtn.setOnClickListener {
            menuDialog.showDialog()
        }

        // 공유하기 버튼 연결
        binding.shareBtn.setOnClickListener {
            // 공유하기 템플릿 만드는 로직이 들어가야 합니다.
            Toast.makeText(this, "공유하기 템플릿 띄워야함..", Toast.LENGTH_SHORT).show()
        }

    }
}