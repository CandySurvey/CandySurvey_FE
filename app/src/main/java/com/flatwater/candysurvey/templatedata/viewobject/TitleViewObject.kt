package com.flatwater.candysurvey.templatedata.viewobject

import android.text.Editable

data class TitleViewObject (
    val surveyTitle : Editable?,
    val surveyDetail : Editable?,
) : ViewObject()