package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityPwCheckBinding

class PwCheckActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPwCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pw_check)

        // 로그인하러 가기 버튼 구현 (완료)
        binding.goToLoginBtn.setOnClickListener {
            val intent = Intent(this, LocalLoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}

// 추가 기능 구현
// 1. 서버에서 사용자가 입력한 아이디 값과 함께 있는 비밀번호를 다시 프론트로 전송하여 화면에 랜더링 시켜주는 기능