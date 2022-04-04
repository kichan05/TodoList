package com.ckstmznf.todolist.data.repository

import com.ckstmznf.todolist.data.model.TodoItem
import com.ckstmznf.todolist.util.Result

interface TodoRepository {
    suspend fun createTodo(todoData : TodoItem) : Result
}