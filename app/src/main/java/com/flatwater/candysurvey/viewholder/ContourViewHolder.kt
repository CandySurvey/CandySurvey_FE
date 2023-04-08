package com.flatwater.candysurvey.viewholder

import com.flatwater.candysurvey.databinding.TemplateContourBinding
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.templatedata.viewobject.ContourViewObject
import com.flatwater.candysurvey.templatedata.viewobject.ViewObject

class ContourViewHolder(
    private val binding: TemplateContourBinding
) : CommonViewHolder(binding) {
    override fun bind(item: CommonItem) {
        val viewObject = item.questionObject as ContourViewObject
    }
}