package com.flatwater.candysurvey.produce

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.WindowManager
import android.widget.LinearLayout
import com.flatwater.candysurvey.R

class MenuDialog(context: Context) {

    private val menuDialog = Dialog(context)

    fun showDialog(){

        menuDialog.setContentView(R.layout.template_menu_dialog)

        menuDialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        menuDialog.setCanceledOnTouchOutside(false)
        menuDialog.setCancelable(true)

        menuDialog.show()

        // template button
        val titleBtn = menuDialog.findViewById<LinearLayout>(R.id.titleBtn)
        titleBtn.setOnClickListener {
            var templateType = "TITLE"
            onClickedListener.onClicked(templateType)
            menuDialog.dismiss()
        }

        val contourBtn = menuDialog.findViewById<LinearLayout>(R.id.contourBtn)
        contourBtn.setOnClickListener {
            var templateType = "CONTOUR"
            onClickedListener.onClicked(templateType)
            menuDialog.dismiss()
        }

        val shortAnswerBtn = menuDialog.findViewById<LinearLayout>(R.id.shortAnswerBtn)
        shortAnswerBtn.setOnClickListener {
            var templateType = "SHORT_ANS"
            onClickedListener.onClicked(templateType)
            menuDialog.dismiss()
        }

        val longAnswerBtn = menuDialog.findViewById<LinearLayout>(R.id.longAnswerBtn)
        longAnswerBtn.setOnClickListener {
            var templateType = "LONG_ANS"
            onClickedListener.onClicked(templateType)
            menuDialog.dismiss()
        }

        val multipleChoiceBtn = menuDialog.findViewById<LinearLayout>(R.id.multipleChoiceBtn)
        multipleChoiceBtn.setOnClickListener {
            var templateType = "OPTIONAL"
            onClickedListener.onClicked(templateType)
            menuDialog.dismiss()
        }

        val dropdownBtn = menuDialog.findViewById<LinearLayout>(R.id.dropDownBtn)
        dropdownBtn.setOnClickListener {
            var templateType = "DROPDOWN"
            onClickedListener.onClicked(templateType)
            menuDialog.dismiss()
        }

        // 나머지 템플릿들은 XML에서 구현하고 연결시켜줄 예정임!
        val starBtn = menuDialog.findViewById<LinearLayout>(R.id.starBtn)
        val linearMagnificationBtn = menuDialog.findViewById<LinearLayout>(R.id.linearMagnificationBtn)
        val timeBtn = menuDialog.findViewById<LinearLayout>(R.id.timeBtn)
        val dateBtn = menuDialog.findViewById<LinearLayout>(R.id.dateBtn)
        val emailBtn = menuDialog.findViewById<LinearLayout>(R.id.emailBtn)
        val phoneNumberBtn = menuDialog.findViewById<LinearLayout>(R.id.phoneNumberBtn)
        val numericBtn = menuDialog.findViewById<LinearLayout>(R.id.numericBtn)
        val insertImageBtn = menuDialog.findViewById<LinearLayout>(R.id.insertImageBtn)
        val insertVideoBtn = menuDialog.findViewById<LinearLayout>(R.id.insertVideoBtn)
        val fileBtn = menuDialog.findViewById<LinearLayout>(R.id.fileBtn)


    }

    interface ButtonClickListener {
        fun onClicked(questionType : String)
    }

    private lateinit var onClickedListener: ButtonClickListener

    fun setOnClickedListener(listener: ButtonClickListener){
        onClickedListener = listener
    }

}