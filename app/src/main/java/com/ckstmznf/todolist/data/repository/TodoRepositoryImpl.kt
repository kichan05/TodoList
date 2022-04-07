package com.ckstmznf.todolist.data.repository

import android.util.Log
import com.ckstmznf.todolist.data.model.TodoItem
import com.ckstmznf.todolist.util.Result
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firestore.v1.FirestoreGrpc
import kotlinx.coroutines.tasks.await

class TodoRepositoryImpl : TodoRepository {

    val db = Firebase.firestore

    override suspend fun createTodo(todoData: TodoItem) : Result {
        db.collection("todo").add(todoData).await()

        return Result.SUCCESS
    }

    override suspend fun readTodo(): List<TodoItem> {
        val result = mutableListOf<TodoItem>()

        val documents = db.collection("todo").get().await()

        for(i in documents){
            result.add(i.toObject(TodoItem::class.java))
        }

        return result
    }
}
