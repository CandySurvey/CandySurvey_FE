package com.flatwater.candysurvey.viewholder

import com.flatwater.candysurvey.databinding.TemplateTitleBinding
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.templatedata.viewobject.TitleViewObject

class TitleViewHolder(
    private val binding : TemplateTitleBinding
) : CommonViewHolder(binding) {
    override fun bind(item: CommonItem) {
        val viewObject = item.questionObject as TitleViewObject
        binding.surveyTitle.text = viewObject.surveyTitle
        binding.surveyDetail.text = viewObject.surveyDetail
    }
}