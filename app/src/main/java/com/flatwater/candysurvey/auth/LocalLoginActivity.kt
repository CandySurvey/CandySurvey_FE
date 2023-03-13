package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.MainActivity
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityLocalLoginBinding

class LocalLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLocalLoginBinding

    var backPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_local_login)

        binding.closeBtn.setOnClickListener {
            // 되돌아가기 기능 구현예정
            Toast.makeText(this, "되돌아가기 기능 구현 예정", Toast.LENGTH_SHORT).show()
        }

        // 아이디 찾기 버튼 클릭 이벤트 구현 (완성)
        binding.findId.setOnClickListener {
            val intent = Intent(this, FindIdActivity::class.java)
            startActivity(intent)
        }

        // 비밀번호 찾기 버튼 클릭 이벤트 구현 (완성)
        binding.findPw.setOnClickListener {
            val intent = Intent(this, FindPasswordActivity::class.java)
            startActivity(intent)
        }

        // 뒤로가기 버튼 구현(완성)
        binding.closeBtn.setOnClickListener {
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish()
        }
        
        // 로그인 버튼 구현 (완성)
        binding.localLoginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        if(backPressedTime + 3000 > System.currentTimeMillis()){
            super.onBackPressed()
            finishAffinity()
        } else {
            Toast.makeText(this, "정말 종료하시겠습니까?", Toast.LENGTH_SHORT).show()
        }

        backPressedTime = System.currentTimeMillis()
    }
}

// 아이디 찾기/비밀번호 찾기 버튼 태그로 바꾸고 클릭 이벤트 구현해야함


