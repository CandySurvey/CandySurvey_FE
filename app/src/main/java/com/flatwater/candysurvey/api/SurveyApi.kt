package com.flatwater.candysurvey.api

import com.flatwater.candysurvey.jsondata.Survey
import com.flatwater.candysurvey.jsondata.SurveyDataModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface SurveyApi {

    @Headers("accept: application/json", "content-type: application/json")
    @POST("/test")
    suspend fun requestPost(@Body postData: SurveyDataModel): Response<SurveyDataModel>

}