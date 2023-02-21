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


    }
}