package com.ckstmznf.todolist.ui.add

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ckstmznf.todolist.R
import com.ckstmznf.todolist.data.Importance
import java.time.LocalDate

class AddViewModel : ViewModel() {

    val todoTitle = MutableLiveData("")

    val _importance = MutableLiveData(R.id.radioBtn_add_high)

    val importance : Int
        get() {
            return when(_importance.value){
                R.id.radioBtn_add_high -> Importance.HIGH
                R.id.radioBtn_add_middle -> Importance.MIDDLE
                R.id.radioBtn_add_low -> Importance.LOW
                else -> Importance.HIGH
            }
        }


    val deadLineYear = MutableLiveData(LocalDate.now().year)
    val deadLineMonth = MutableLiveData(LocalDate.now().monthValue + 1)
    val deadLineDay = MutableLiveData(LocalDate.now().dayOfMonth)

    fun onDateChange(year : Int, month : Int, day : Int){
        deadLineYear.value = year
        deadLineMonth.value = month
        deadLineDay.value = day
    }
}