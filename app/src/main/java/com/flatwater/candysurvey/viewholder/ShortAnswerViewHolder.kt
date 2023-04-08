package com.flatwater.candysurvey.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.flatwater.candysurvey.databinding.TemplateShortAnswerBinding
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.templatedata.viewobject.ShortAnswerViewObject

class ShortAnswerViewHolder (
    private val binding: TemplateShortAnswerBinding
) : CommonViewHolder(binding) {
    override fun bind(item: CommonItem) {
        val viewObject = item.questionObject as ShortAnswerViewObject
        binding.shortAnswer.text = viewObject.questionTitle
    }
}