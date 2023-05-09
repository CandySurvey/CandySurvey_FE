package com.flatwater.candysurvey.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flatwater.candysurvey.template.TitleTemplateModel
import com.flatwater.candysurvey.templatedata.viewobject.TitleViewObject
import kotlinx.coroutines.launch

class SurveyDataViewModel : ViewModel() {

    private val _titleTemplateData = MutableLiveData<TitleViewObject>()

    val resultTitleTemplateData : LiveData<TitleViewObject>
        get() = _titleTemplateData

    fun printData() {
        Log.d("LiveData", "$resultTitleTemplateData")
    }

}