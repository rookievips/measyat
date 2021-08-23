package com.rookievips.measyat

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.rookievips.measyat.span.DataBindingSpan
import com.rookievips.measyat.span.DirtySpan

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
data class User(val id: String, var name: String, var color: Int = Color.RED) : DataBindingSpan, DirtySpan {
    fun getSpannedName(): Spannable {
        return SpannableString("@$name ").apply {
            setSpan(ForegroundColorSpan(color), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    override fun isDirty(text: Spannable): Boolean {
        val spanStart = text.getSpanStart(this)
        val spanEnd = text.getSpanEnd(this)
        return spanStart >= 0 && spanEnd >= 0 && text.substring(spanStart, spanEnd) != "@$name "
    }

    override fun equals(other: Any?): Boolean {
        if (other is User) {
            return id == other.id && name == other.name
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
