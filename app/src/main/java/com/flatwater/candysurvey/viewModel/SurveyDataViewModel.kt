package com.flatwater.candysurvey.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flatwater.candysurvey.api.RetrofitInstance
import com.flatwater.candysurvey.api.SurveyApi
import com.flatwater.candysurvey.jsondata.*
import com.flatwater.candysurvey.templatedata.viewobject.TitleViewObject
import kotlinx.coroutines.launch

class SurveyDataViewModel : ViewModel() {

    val retrofitInstance : SurveyApi = RetrofitInstance.getInstance().create(SurveyApi::class.java)

    fun requestPost() = viewModelScope.launch {
        val postData = SurveyDataModel(Survey("test code", "test1", Questions(listOf(Question("title", "first title", "first detail", listOf(Items("test item")))))))
        try {
            val response = retrofitInstance.requestPost(postData)
            if (response.isSuccessful) {
                val responseData = response.body()
                Log.d("Server", "성공!")
            } else {
                Log.d("Server", "실패!")
            }
        } catch (e:Exception) {
            Log.d("Post", "예외처리")
        }
    }

//    fun getAllSurvey() = viewModelScope.launch {
//        Log.d("JSON Data", retrofitInstance.getAllSurveys().toString())
//    }
}