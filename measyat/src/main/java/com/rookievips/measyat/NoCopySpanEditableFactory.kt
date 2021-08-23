package com.rookievips.measyat

import android.text.Editable
import android.text.NoCopySpan
import android.text.SpannableStringBuilder
import android.text.Spanned

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
class NoCopySpanEditableFactory(private vararg val spans: NoCopySpan) : Editable.Factory() {
    override fun newEditable(source: CharSequence): Editable {
        return SpannableStringBuilder.valueOf(source).apply {
            spans.forEach {
                setSpan(it, 0, source.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
            }
        }
    }
}