package com.rookievips.measyat.method

import android.text.Spannable
import android.view.KeyEvent
import android.widget.EditText
import com.rookievips.measyat.*
import com.rookievips.measyat.span.DirtySpan
import com.rookievips.measyat.watcher.DirtySpanWatcher

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
object TypeTwo : Method {
    override fun init(editText: SecurityEditText) {
        editText.text = null
        editText.setEditableFactory(
            NoCopySpanEditableFactory(DirtySpanWatcher { it is DirtySpan })
        )
        editText.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                KeyCodeDeleteHelper.onDelDown((v as EditText).text)
            }
            return@setOnKeyListener false
        }
    }

    override fun newSpannable(user: User): Spannable {
        return SpanFactory.newSpannable("@${user.name} ", user)
    }
}