package com.rookievips.measyat

import android.text.Spannable
import android.text.SpannableString

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
object SpanFactory {
    fun newSpannable(source: CharSequence, vararg spans: Any): Spannable {
        return SpannableString.valueOf(source).apply {
            spans.forEach {
                setSpan(it, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }
}