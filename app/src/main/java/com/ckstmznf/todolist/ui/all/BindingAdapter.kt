package com.ckstmznf.todolist.ui.all

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ckstmznf.todolist.data.model.TodoItem
import com.ckstmznf.todolist.ui.main.MainTodoListAdapter

@BindingAdapter("bindTodo")
fun bindTodo(recycler : RecyclerView, todoList : ObservableArrayList<TodoItem>?){
    val adapter = (recycler.adapter as MainTodoListAdapter?) ?: return

    if(todoList != null)
        adapter.submitList(todoList.toMutableList())
}


@BindingAdapter("bindSwipeOnRefresh")
fun bindSwipeOnRefresh(swiperRefresh : SwipeRefreshLayout, state : Boolean){
    swiperRefresh.isRefreshing = state
}