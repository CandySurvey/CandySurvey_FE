package com.flatwater.candysurvey.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.flatwater.candysurvey.MainActivity
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityLoginCompleteSplashBinding

class LoginCompleteSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginCompleteSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_complete_splash)

        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 3000)

    }
}