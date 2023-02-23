package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityTermsOfServiceBinding

class TermsOfServiceActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTermsOfServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_terms_of_service)

        binding.termsOfServiceBtn.setOnClickListener{
            // 약관 내용 담은 프레그먼트 애니메이션 추가 예정
            // 약관 내용 마크업 해야함
        }

        // 약관 동의 버튼 이벤트 핸들링 (메인 페이지로 이동하는 스플래시 화면으로 이동)
        binding.startBtn.setOnClickListener {
            val intent = Intent(this, LoginCompleteSplashActivity::class.java)
            startActivity(intent)
        }

    }
}