package com.flatwater.candysurvey

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.flatwater.candysurvey.produce.ProduceActivity

class MakeSurveyDialog(context: Context) {

    private val makeSurveyDialog = Dialog(context)

    fun showMakeSurveyDialog(){

        makeSurveyDialog.setContentView(R.layout.make_survey_dialog)

        makeSurveyDialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)

        makeSurveyDialog.setCanceledOnTouchOutside(false)
        makeSurveyDialog.setCancelable(true)

        makeSurveyDialog.show()

        val surveyTitleText = makeSurveyDialog.findViewById<EditText>(R.id.surveyTitleText)
        val cancelBtn = makeSurveyDialog.findViewById<Button>(R.id.cancelBtn)
        val completeBtn = makeSurveyDialog.findViewById<Button>(R.id.completeBtn)

        cancelBtn.setOnClickListener {
            makeSurveyDialog.dismiss()
        }

        completeBtn.setOnClickListener {
            // Dialog에 입력한 제목 xml 파일에서 받아옴
            onClickedListener.onClicked(surveyTitleText.text.toString())
            makeSurveyDialog.dismiss()
        }
    }

    interface ButtonClickListener {
        fun onClicked(surveyTitle: String)
    }

    private lateinit var onClickedListener: ButtonClickListener

    fun setOnClickedListener(listener: ButtonClickListener){
        onClickedListener = listener
    }

}