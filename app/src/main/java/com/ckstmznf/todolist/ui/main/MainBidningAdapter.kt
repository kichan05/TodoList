package com.ckstmznf.todolist.ui.main

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ckstmznf.todolist.data.model.Degree

@BindingAdapter("bindDegree")
fun bindDegree(textView: TextView, degree : Int){
    textView.text = when(degree){
        Degree.HIGH -> "상"
        Degree.MIDDLE -> "중"
        Degree.LOW -> "하"
        else -> "null"
    }
}