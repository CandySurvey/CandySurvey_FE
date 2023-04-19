package com.flatwater.candysurvey.templatedata.viewobject

import android.text.Editable

data class OptionalViewObject (
    val questionTitle : Editable?,
    // questionItem의 하위 속성도 선언해주어야 하는데, 방법 찾아주어야 함!
) : ViewObject()