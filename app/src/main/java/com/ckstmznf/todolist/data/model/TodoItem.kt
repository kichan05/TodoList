package com.ckstmznf.todolist.data.model

import android.util.Log
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

data class TodoItem(
    val title : String = "",
    val importance : Int = Degree.MIDDLE,
    val deadLine : Date? = null,
){
    val urgency : Int //급한 정도를 반환한다.
        get() {
//            val between = Duration.between(LocalDate.now(), deadLine?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate())
            val betweenSecond = deadLine?.time!! - Date().time
            val betweenDay = betweenSecond / 1000 / 60 / 60 / 24 + 1

            return when(betweenDay){
                in 1..3 -> Degree.HIGH
                in 4..10 -> Degree.MIDDLE
                else -> Degree.LOW
            }
        }


    val priority : Int
        get() {
            return if(importance == Degree.HIGH && urgency == Degree.HIGH) 1
            else if (importance == Degree.MIDDLE && urgency == Degree.HIGH) 2
            else if (importance == Degree.LOW && urgency == Degree.HIGH) 3
            else if (importance == Degree.HIGH && urgency == Degree.MIDDLE) 4
            else if (importance == Degree.HIGH && urgency == Degree.LOW) 5
            else if (importance == Degree.MIDDLE && urgency == Degree.MIDDLE) 6
            else if (importance == Degree.LOW && urgency == Degree.MIDDLE) 7
            else if (importance == Degree.MIDDLE && urgency == Degree.LOW) 8
            else 9
        }
}
