package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityFindPasswordBinding

class FindPasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFindPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_find_password)

        // 뒤로가기 버튼 구현
        binding.closeBtn.setOnClickListener {
            finish()
        }

        // 비밀번호 확인 버튼 구현 (완료)
        binding.checkPwBtn.setOnClickListener {
            val intent = Intent(this, PwCheckActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}

// 추가 구현 목록
// 1. 사용자가 입력한 아이디 값을 받아와서 서버에 있는 데이터와 똑같은 아이디가 있는지 찾고, 있을 경우 비밀번호 확인 페이지로 넘어갈 수 있게 해주는 기능
