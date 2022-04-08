package com.ckstmznf.todolist.ui.main

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ckstmznf.todolist.data.model.TodoItem
import com.ckstmznf.todolist.data.repository.TodoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repo : TodoRepositoryImpl = TodoRepositoryImpl()

    val todoList = ObservableArrayList<TodoItem>()
    val refreshState = MutableLiveData(true)

    fun readTodo(){
        refreshState.value = true
        todoList.clear()

        viewModelScope.launch(Dispatchers.IO) {
            val a = repo.readTodo().sortedBy {
                it.priority
            }
            todoList.addAll(a)

            refreshState.postValue(false)
        }
    }


    init {
        readTodo()
    }
}