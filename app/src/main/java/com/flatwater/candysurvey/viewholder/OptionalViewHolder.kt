package com.flatwater.candysurvey.viewholder

import com.flatwater.candysurvey.databinding.TemplateMultipleChoiceBinding
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.templatedata.viewobject.ModelItem
import com.flatwater.candysurvey.templatedata.viewobject.OptionalViewObject

class OptionalViewHolder(
    private val binding: TemplateMultipleChoiceBinding
) : CommonViewHolder(binding) {

    override fun bind(item: CommonItem) {
        val viewObject = item.questionObject as OptionalViewObject

        binding.optionalTitle.setText(viewObject.questionTitle)

        binding.optionPlusBtn.setOnClickListener {
            // 추가 버튼 클릭하면 modelItem 생성되면서 하나 클릭할 때마다 하나씩 생성되게 만들어주어야함!
            println(viewObject.modelItems)
        }
    }

    // addItem 함수가 적용되지 않음
//    private fun addItem(viewObject : OptionalViewObject, newItem : ModelItem) : List<ModelItem> {
//        val addedItemList = viewObject.modelItems.toMutableList().apply {
//            add(newItem)
//        }
//        return addedItemList
//    }
}