package com.rookievips.measyat.method

import android.text.Spannable
import com.rookievips.measyat.SecurityEditText
import com.rookievips.measyat.User

/**
 * Function:
 * Author Name: rookievips
 * Date: 2021/7/8
 * Copyright © 2006-2021,All Rights Reserved.
 */
interface Method {
    fun init(editText: SecurityEditText)
    fun newSpannable(user: User): Spannable
}