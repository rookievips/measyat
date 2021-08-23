package com.rookievips.measyat.watcher

import android.text.Spannable
import com.rookievips.measyat.span.DirtySpan

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
class DirtySpanWatcher(private val removePredicate: (Any) -> Boolean) : SpanWatcherAdapter() {
    override fun onSpanChanged(
        text: Spannable,
        what: Any,
        ostart: Int,
        oend: Int,
        nstart: Int,
        nend: Int
    ) {
        if (what is DirtySpan && what.isDirty(text)) {
            val spanStart = text.getSpanStart(what)
            val spanEnd = text.getSpanEnd(what)
            text.getSpans(spanStart, spanEnd, Any::class.java).filter {
                removePredicate.invoke(it)
            }.forEach {
                text.removeSpan(it)
            }
        }
    }
}