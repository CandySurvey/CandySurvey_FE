package com.flatwater.candysurvey.setting

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.core.content.contentValuesOf
import com.flatwater.candysurvey.R

class CustomDialog(context: Context) {

    private val dialog = Dialog(context)

    fun showDialog(){
        // Dialog와 레이아웃 연결
        dialog.setContentView(R.layout.nickname_edit_dialog)

        // Dialog 크기 설정
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)

        // Dialog 영역 밖을 터치했을 때, Dialog가 사라지도록 하는 부분
        dialog.setCanceledOnTouchOutside(true)

        // 취소가 가능하도록 하는 부분
        dialog.setCancelable(true)
        dialog.show()

        // Dialog 버튼 연결
        val yesBtn = dialog.findViewById<Button>(R.id.yesBtn)
        val noBtn = dialog.findViewById<Button>(R.id.noBtn)

        yesBtn.setOnClickListener {
            // 사용자 닉네임 바꾸는 요청 서버로 보내야 함
            dialog.dismiss()
        }

        noBtn.setOnClickListener {
            dialog.dismiss()
        }
    }
}

// Dialog 크기 설정 작업 + Radius 설정 작업