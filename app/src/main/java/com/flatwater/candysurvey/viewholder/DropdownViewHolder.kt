package com.flatwater.candysurvey.viewholder

import com.flatwater.candysurvey.databinding.TemplateDropdownBinding
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.templatedata.viewobject.DropdownViewObject

class DropdownViewHolder(
    private val binding : TemplateDropdownBinding
) : CommonViewHolder(binding) {
    override fun bind(item: CommonItem) {
        val viewObject = item.questionObject as DropdownViewObject
        binding.dropdownTitle.setText(viewObject.questionTitle)
        // dropdown 하위 데이터 구조도 적용시켜 주어야 함! (questionItem -> item1, item2 ...)
    }
}