package com.rookievips.measyat.watcher

import android.text.SpanWatcher
import android.text.Spannable

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
open class SpanWatcherAdapter: SpanWatcher {
    override fun onSpanChanged(text: Spannable, what: Any, ostart: Int, oend: Int, nstart: Int, nend: Int) {}

    override fun onSpanRemoved(text: Spannable, what: Any, start: Int, end: Int) {}

    override fun onSpanAdded(text: Spannable, what: Any, start: Int, end: Int) {}
}