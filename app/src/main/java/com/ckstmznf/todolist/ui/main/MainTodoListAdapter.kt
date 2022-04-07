package com.ckstmznf.todolist.ui.main

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ckstmznf.todolist.data.model.TodoItem

class MainTodoListAdapter : ListAdapter<TodoItem, RecyclerView.ViewHolder>(MainDiffUtilCallBack()) {

    class MainDiffUtilCallBack : DiffUtil.ItemCallback<TodoItem>() {
        override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean = oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainTodoListHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("todoItem", getItem(position).toString())
        (holder as MainTodoListHolder).bind(getItem(position), position + 1)
    }

}