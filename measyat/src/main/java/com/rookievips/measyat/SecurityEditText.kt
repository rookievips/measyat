package com.rookievips.measyat

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputConnectionWrapper
import androidx.appcompat.widget.AppCompatEditText

/**
 * Function: 解决英文键盘不响应del键的问题
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
class SecurityEditText : AppCompatEditText {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onCreateInputConnection(outAttrs: EditorInfo?): InputConnection {
        return ZanyInputConnection(super.onCreateInputConnection(outAttrs), true)
    }

    class ZanyInputConnection(target: InputConnection, mutable: Boolean) : InputConnectionWrapper(target, mutable) {

        override fun deleteSurroundingText(beforeLength: Int, afterLength: Int): Boolean {
            return if (beforeLength == 1 && afterLength == 0) {
                sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL)) && sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL))
            } else super.deleteSurroundingText(beforeLength, afterLength)
        }
    }
}

