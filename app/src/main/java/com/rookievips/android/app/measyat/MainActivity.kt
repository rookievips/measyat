package com.rookievips.android.app.measyat

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rookievips.measyat.SecurityEditText
import com.rookievips.measyat.User
import com.rookievips.measyat.method.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val methods = arrayOf(TypeOne, TypeThree, TypeTwo)
    private var iterator: Iterator<Method> = methods.iterator()
    private val methodContext = MethodContext()

    private lateinit var btnAppend: Button
    private lateinit var btnPrint: Button
    private lateinit var btnSwitch: Button
    private lateinit var normalEdit: SecurityEditText
    private lateinit var txtLogs: TextView

    private val users = arrayListOf(
        User("1", "超甜的布丁", Color.parseColor("#FFBB86FC")),
        User("2", "你能哥", Color.parseColor("#FFBB86FC")),
        User("3", "听梦的风尘女", Color.parseColor("#FFBB86FC")),
        User("4", "陪你演戏", Color.parseColor("#FFBB86FC")),
        User("5", "清风徐来", Color.parseColor("#FFBB86FC")),
        User("6", "英雄无双风流婿", Color.parseColor("#FFBB86FC")),
        User("7", "源清流洁", Color.parseColor("#FFBB86FC")),
        User("8", "占断人间天上福", Color.parseColor("#FFBB86FC")),
        User("9", "清音幽韵"),
        User("10", "碧箫声里双鸣凤"),
        User("11", "你四哥"),
        User("12", "天教艳质为眷属"),
        User("13", "独清独醒"),
        User("14", "千金一刻庆良宵"),
        User("15", "必须要长长长长长长长长长长长长，不然不够长")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAppend = findViewById(R.id.btnAppend)
        btnPrint = findViewById(R.id.btnPrint)
        btnSwitch = findViewById(R.id.btnSwitch)
        normalEdit = findViewById(R.id.normalEdit)
        txtLogs = findViewById(R.id.txtLogs)

        normalEdit.post {
            normalEdit.requestFocus()
        }

        btnAppend.setOnClickListener {
            if (methodContext.method == null) {
                switch()
            }
            val user = users[Random().nextInt(15)].copy()
            (normalEdit.text as SpannableStringBuilder)
                .append(methodContext.newSpannable(user))
//                .append(" ")
            normalEdit.setSelection(normalEdit.length())
        }
        btnSwitch.setOnClickListener {
            switch()
        }
        btnPrint.setOnClickListener { _ ->
            val editable = normalEdit.text
            txtLogs.text =
                editable?.getSpans(0, normalEdit.length(), User::class.java)?.joinToString("\n") {
                    "$it, ${editable.getSpanStart(it)}, ${editable.getSpanEnd(it)}"
                }
            txtLogs.scrollTo(0, 0)
        }
        txtLogs.movementMethod = ScrollingMovementMethod.getInstance()
    }

    private fun switch() {
        val method = circularMethod()
        methodContext.method = method
        btnSwitch.text = method.javaClass.simpleName
        methodContext.init(normalEdit)
    }

    private tailrec fun circularMethod(): Method {
        return if (iterator.hasNext()) {
            iterator.next()
        } else {
            iterator = methods.iterator()
            circularMethod()
        }
    }
}