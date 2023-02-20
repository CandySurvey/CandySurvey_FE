package com.flatwater.candysurvey.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.databinding.ActivityIntroBinding


class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

    }
}