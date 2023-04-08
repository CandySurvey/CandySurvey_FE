package com.flatwater.candysurvey.utility

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.viewholder.*

object CommonViewHolderFactory {
    fun createViewHolder(parent: ViewGroup, viewType: Int) : CommonViewHolder {
        return when(viewType) {
            ViewType.TITLE.ordinal -> TitleViewHolder(getViewDataBinding(parent, R.layout.template_title))
            ViewType.CONTOUR.ordinal -> ContourViewHolder(getViewDataBinding(parent, R.layout.template_contour))
            ViewType.SHORT_ANS.ordinal -> ShortAnswerViewHolder(getViewDataBinding(parent, R.layout.template_short_answer))
            ViewType.LONG_ANS.ordinal -> LongAnswerViewHolder(getViewDataBinding(parent, R.layout.template_long_answer))
            ViewType.OPTIONAL.ordinal -> OptionalViewHolder(getViewDataBinding(parent, R.layout.template_multiple_choice))
            else -> DropdownViewHolder(getViewDataBinding(parent, R.layout.template_dropdown))
        }
    }

    private fun <T: ViewDataBinding> getViewDataBinding(parent: ViewGroup, layoutRes: Int) : T {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    }
}