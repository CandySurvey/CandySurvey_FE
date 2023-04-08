package com.flatwater.candysurvey.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.utility.CommonViewHolderFactory
import com.flatwater.candysurvey.utility.ViewType
import com.flatwater.candysurvey.viewholder.CommonViewHolder

class CommonAdapter(
    private val dataSet : Array<CommonItem>
) : RecyclerView.Adapter<CommonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return CommonViewHolderFactory.createViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return ViewType.valueOf(dataSet[position].questionType).ordinal
    }
}