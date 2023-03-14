package com.flatwater.candysurvey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.databinding.ActivityMainBinding
import com.flatwater.candysurvey.setting.MyPageActivity
import com.flatwater.candysurvey.setting.SettingActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    var backPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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