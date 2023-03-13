package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        // 다음 버튼 클릭했을 때 이벤트 핸들링 (약관동의 페이지로 넘어가야 함)
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, TermsOfServiceActivity::class.java)
            startActivity(intent)
        }

        binding.closeBtn.setOnClickListener {
            // 이전 페이지로 되돌아가는 기능 구현 예정
            Toast.makeText(this, "되돌아갑니다.", Toast.LENGTH_SHORT).show()
        }

        // 뒤로가기 버튼
        binding.closeBtn.setOnClickListener {
            finish()
        }

    }
}

// 닉네임 겹치는 경우, 아이디, 비밀번호 겹치거나 양식 맞추지 않았을 때 경고창 띄워주는 기능 추가 예정
// 닉네임/아이디/비밀번호 입력 안했을 때 경고 메세지 띄워주는 기능 추가해야 함
