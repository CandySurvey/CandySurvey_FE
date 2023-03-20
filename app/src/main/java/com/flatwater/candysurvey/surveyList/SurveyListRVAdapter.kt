package com.flatwater.candysurvey.surveyList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flatwater.candysurvey.R

class SurveyListRVAdapter(val surveyList: ArrayList<SurveyModel>) :
    RecyclerView.Adapter<SurveyListRVAdapter.SurveyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mainpage_survey_rv_item, parent, false)
        return SurveyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurveyViewHolder, position: Int) {
        holder.sv_title.text = surveyList[position].title
        holder.sv_time.text = surveyList[position].time
        holder.sv_participants.text = surveyList[position].participants
    }

    override fun getItemCount(): Int {
        return surveyList.size
    }

    inner class SurveyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sv_title = itemView.findViewById<TextView>(R.id.surveyTitle)
        val sv_time = itemView.findViewById<TextView>(R.id.makeSurveyTime)
        val sv_participants = itemView.findViewById<TextView>(R.id.surveyParticipants)
    }
}