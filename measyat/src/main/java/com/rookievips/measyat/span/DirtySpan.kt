package com.rookievips.measyat.span

import android.text.Spannable

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
interface DirtySpan {
    fun isDirty(text: Spannable): Boolean
}