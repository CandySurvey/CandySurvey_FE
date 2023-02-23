package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityLocalLoginBinding

class LocalLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLocalLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_local_login)

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

        binding.closeBtn.setOnClickListener {
            // 되돌아가기 기능 구현예정
            Toast.makeText(this, "되돌아가기 기능 구현 예정", Toast.LENGTH_SHORT).show()

        }
    }
}

// 아이디/비밀번호 입력할 때 소셜로그인 부분 스크롤 기능 구현 (키패드가 가리니까)
// 아이디 찾기/비밀번호 찾기 버튼 태그로 바꾸고 클릭 이벤트 구현해야함


