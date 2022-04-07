package com.ckstmznf.todolist.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ckstmznf.todolist.data.model.TodoItem
import com.ckstmznf.todolist.databinding.RowTodoListItemBinding

class MainTodoListHolder(private val binding : RowTodoListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
//        binding.roo
    }

    constructor(parent : ViewGroup) : this(
        RowTodoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun bind(todoData : TodoItem, priority : Int){
        binding.todoData = todoData
        binding.priority = priority
    }
}