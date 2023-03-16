package com.flatwater.candysurvey.produce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.MainActivity
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityProduceBinding
import com.flatwater.candysurvey.setting.MyPageActivity

class ProduceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProduceBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_produce)

        // 뒤로가기 버튼 연결
        binding.closeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 메인페이지 네비게이션 연결
        binding.navigateMainPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 마이페이지 네비게이션 연결
        binding.navigateMyPage.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 메뉴 버튼 dialog 연결
        val menuDialog = MenuDialog(this)
        binding.plusBtn.setOnClickListener {
            menuDialog.showDialog()
        }

        // 공유하기 버튼 연결
        binding.shareBtn.setOnClickListener {
            // 공유하기 템플릿 만드는 로직이 들어가야 합니다.
            Toast.makeText(this, "공유하기 템플릿 띄워야함..", Toast.LENGTH_SHORT).show()
        }

    }
}