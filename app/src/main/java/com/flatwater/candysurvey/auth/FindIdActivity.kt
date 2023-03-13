package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityFindIdBinding

class FindIdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFindIdBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_find_id)

        // 뒤로가기 버튼 구현 (완료)
        binding.closeBtn.setOnClickListener {
            finish()
        }

        // 인증번호 발송 버튼 구현 (임시)
        binding.authBtn.setOnClickListener {
            Toast.makeText(this, "핸드폰으로 인증번호가 날아가야합니다..", Toast.LENGTH_SHORT).show()
        }
        
        // 아이디 확인 버튼 구현
        binding.idCheckBtn.setOnClickListener {
            val intent = Intent(this, IdCheckActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}

// 추가 구현 목록
// 1. 전화번호(SMS)로 인증번호를 전송하는 기능
// 2. 전송받은 인증번호와 실제 인증번호가 같은지 확인하는 기능
// 3. 아이디 확인 버튼 눌렀을 때, 서버에 있는 인증번호와 실제 인증번호가 같다면 확인 페이지로 넘어가고, 그렇지 않다면 경고창을 띄우며 넘어가지 못하게 하는 기능