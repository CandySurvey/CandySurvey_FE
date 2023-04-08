package com.flatwater.candysurvey.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.flatwater.candysurvey.templatedata.CommonItem

// 새로운 뷰타입이 생길때마다 자식 뷰홀더를 생성해야 함!
abstract class CommonViewHolder(
    binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: CommonItem)
}