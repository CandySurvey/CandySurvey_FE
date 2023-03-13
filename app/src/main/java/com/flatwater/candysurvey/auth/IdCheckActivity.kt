package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityIdCheckBinding

class IdCheckActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIdCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_id_check)

        // 로그인하러 가기 버튼 기능 구현
        binding.goToLoginBtn.setOnClickListener {
            val intent = Intent(this, LocalLoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}