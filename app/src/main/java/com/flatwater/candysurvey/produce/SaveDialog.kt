package com.flatwater.candysurvey.produce

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button
import com.flatwater.candysurvey.R

class SaveDialog(context: Context) {

    private val saveDialog = Dialog(context)

    fun showSaveDialog(){

        saveDialog.setContentView(R.layout.save_check_dialog)

        saveDialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)

        saveDialog.setCanceledOnTouchOutside(false)
        saveDialog.setCancelable(true)

        saveDialog.show()

        val yesBtn = saveDialog.findViewById<Button>(R.id.yesBtn)
        val noBtn = saveDialog.findViewById<Button>(R.id.noBtn)

        noBtn.setOnClickListener {
            saveDialog.dismiss()
        }

        yesBtn.setOnClickListener {
            // 저장 버튼 누르면 ProduceActivity의 설문이 Fragment로 MainPage에 저장되게 하는 코드 작성해야함
            saveDialog.dismiss()
        }

    }

}