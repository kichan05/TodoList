package com.ckstmznf.todolist.data

import java.sql.Timestamp
import java.util.*

data class TodoItem(
    val title : String = "",
    val importance : Int = Importance.MIDDLE,
    val deadLine : Date? = null,
)
