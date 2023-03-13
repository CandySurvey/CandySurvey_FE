package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding

    var backPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        // 구글 로그인 버튼 클릭 이벤트 (임시)
        binding.googleLoginBtn.setOnClickListener {

            Toast.makeText(this, "구글 소셜 로그인 연동입니다", Toast.LENGTH_SHORT).show()

        }

        // 카카오 로그인 버튼 클릭 이벤트 (임시)
        binding.kakaoLoginBtn.setOnClickListener {

            Toast.makeText(this, "카카오 소셜 로그인 연동입니다", Toast.LENGTH_SHORT).show()

        }

        // 네이버 로그인 버튼 클릭 이벤트 (임시)
        binding.naverLoginBtn.setOnClickListener {

            Toast.makeText(this, "네이버 소셜 로그인 연동입니다", Toast.LENGTH_SHORT).show()

        }

        // 로컬 회원가입하기 버튼 클릭 이벤트 -> 회원가입 페이지로 이동
        binding.localLoginBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // 이미 계정이 있으신가요? "로그인" 버튼 클릭 이벤트 -> 로그인 페이지로 이동
        binding.alreadyLoginBtn.setOnClickListener {
            val intent = Intent(this, LocalLoginActivity::class.java)
            startActivity(intent)
        }

    }

    // 두번 터치 앱 종료 기능 구현
    override fun onBackPressed() {

        if(backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finishAffinity()
        } else {
            Toast.makeText(applicationContext, "한번 더 뒤로가기 버튼을 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }

        backPressedTime = System.currentTimeMillis()

    }
}