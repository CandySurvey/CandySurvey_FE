package com.flatwater.candysurvey.viewholder

import com.flatwater.candysurvey.databinding.TemplateMultipleChoiceBinding
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.templatedata.viewobject.OptionalViewObject

class OptionalViewHolder(
    private val binding: TemplateMultipleChoiceBinding
) : CommonViewHolder(binding) {
    override fun bind(item: CommonItem) {
        val viewObject = item.questionObject as OptionalViewObject
        binding.optionalTitle.text = viewObject.questionTitle
        // 하위 데이터 구조 적용시켜 보아야 함! (questionItem -> item1, item2, ...)
    }
}