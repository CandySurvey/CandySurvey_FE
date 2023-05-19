package com.flatwater.candysurvey.templatedata.viewobject

data class OptionalViewObject (
    val questionTitle : String?,
    val modelItems : List<ModelItem>
) : ViewObject()