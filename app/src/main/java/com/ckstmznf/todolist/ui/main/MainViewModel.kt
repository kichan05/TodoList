package com.ckstmznf.todolist.ui.main

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ckstmznf.todolist.data.model.TodoItem
import com.ckstmznf.todolist.data.repository.TodoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repo : TodoRepositoryImpl = TodoRepositoryImpl()

    val todoList = ObservableArrayList<TodoItem>()

    fun readTodo(){
        todoList.clear()

        viewModelScope.launch(Dispatchers.IO) {
            val a = repo.readTodo()
            todoList.addAll(a)
            Log.d("todoList", a.toString())
        }
    }


    init {
        readTodo()
    }
}