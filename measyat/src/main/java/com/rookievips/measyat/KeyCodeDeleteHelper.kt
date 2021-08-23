package com.rookievips.measyat

import android.text.Selection
import android.text.Spannable
import com.rookievips.measyat.span.DataBindingSpan

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
object KeyCodeDeleteHelper {
    fun onDelDown(text: Spannable): Boolean {
        val selectionStart = Selection.getSelectionStart(text)
        val selectionEnd = Selection.getSelectionEnd(text)
        text.getSpans(selectionStart, selectionEnd, DataBindingSpan::class.java)
            .firstOrNull { text.getSpanEnd(it) == selectionStart }?.run {
                return (selectionStart == selectionEnd).also {
                    val spanStart = text.getSpanStart(this)
                    val spanEnd = text.getSpanEnd(this)
                    Selection.setSelection(text, spanStart, spanEnd)
                }
            }
        return false
    }
}