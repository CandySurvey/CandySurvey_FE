package com.flatwater.candysurvey.produce

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import com.flatwater.candysurvey.R

class MenuDialog(context: Context) {

    private val menuDialog = Dialog(context)

    fun showDialog(){

        menuDialog.setContentView(R.layout.template_menu_dialog)

        menuDialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        menuDialog.setCanceledOnTouchOutside(false)
        menuDialog.setCancelable(true)

        menuDialog.show()

    }

}