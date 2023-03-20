package com.flatwater.candysurvey.template

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.flatwater.candysurvey.R

class TitleTemplateRVAdapter(val titleTemplateItem: ArrayList<TitleTemplateModel>) :
    RecyclerView.Adapter<TitleTemplateRVAdapter.TitleTemplateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleTemplateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_title_template, parent, false)
        return TitleTemplateViewHolder(view)
    }

    override fun onBindViewHolder(holder: TitleTemplateViewHolder, position: Int) {
        holder.rv_primaryTitle.hint = titleTemplateItem[position].primaryTitle
        holder.rv_secondaryTitle.hint = titleTemplateItem[position].secondaryTitle
    }

    override fun getItemCount(): Int {
        return titleTemplateItem.size
    }

    inner class TitleTemplateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rv_primaryTitle = itemView.findViewById<EditText>(R.id.primaryTitle)
        val rv_secondaryTitle = itemView.findViewById<EditText>(R.id.secondaryTitle)
    }
}