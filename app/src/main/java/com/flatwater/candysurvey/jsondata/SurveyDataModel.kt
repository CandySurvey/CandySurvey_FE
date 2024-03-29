package com.flatwater.candysurvey.jsondata

@kotlinx.serialization.Serializable
data class SurveyDataModel(
    val survey : Survey
)

@kotlinx.serialization.Serializable
data class Survey(
    val surveyTitle : String,
    val surveyDetail : String,
    val questions : Questions
)

@kotlinx.serialization.Serializable
data class Questions (
    val question : List<Question>
)

@kotlinx.serialization.Serializable
data class Question (
    val questionType : String,
    val questionTitle : String,
    val questionDetail : String,
    val items : List<Items>,
)

@kotlinx.serialization.Serializable
data class Items (
    val item : String,
)
