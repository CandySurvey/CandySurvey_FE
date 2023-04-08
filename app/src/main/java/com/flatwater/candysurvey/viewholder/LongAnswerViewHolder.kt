package com.flatwater.candysurvey.viewholder

import com.flatwater.candysurvey.databinding.TemplateLongAnswerBinding
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.templatedata.viewobject.LongAnswerViewObject

class LongAnswerViewHolder(
    private val binding: TemplateLongAnswerBinding
) : CommonViewHolder(binding) {
    override fun bind(item: CommonItem) {
        val viewObject = item.questionObject as LongAnswerViewObject
        binding.longAnswer.text = viewObject.questionTitle
    }
}