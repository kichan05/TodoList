package com.ckstmznf.todolist.ui.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ckstmznf.todolist.R
import com.ckstmznf.todolist.data.model.Degree
import com.ckstmznf.todolist.data.model.TodoItem
import com.ckstmznf.todolist.data.repository.TodoRepositoryImpl
import com.ckstmznf.todolist.util.State
import com.ckstmznf.todolist.util.toState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class AddViewModel : ViewModel() {
    val state = MutableLiveData<State>()
    private val repo = TodoRepositoryImpl()

    val todoTitle = MutableLiveData("")

    val _importance = MutableLiveData(R.id.radioBtn_add_high)

    val importance : Int
        get() {
            return when(_importance.value){
                R.id.radioBtn_add_high -> Degree.HIGH
                R.id.radioBtn_add_middle -> Degree.MIDDLE
                R.id.radioBtn_add_low -> Degree.LOW
                else -> Degree.HIGH
            }
        }

    val deadLineYear = MutableLiveData(LocalDate.now().year)
    val deadLineMonth = MutableLiveData(LocalDate.now().monthValue - 1)
    val deadLineDay = MutableLiveData(LocalDate.now().dayOfMonth)

    fun onDateChange(year : Int, month : Int, day : Int){
        deadLineYear.value = year
        deadLineMonth.value = month
        deadLineDay.value = day
    }

    fun createTodo() {
        viewModelScope.launch(Dispatchers.IO) {
            state.postValue(State.LOADING)

            val todoData = TodoItem(
                title = todoTitle.value!!,
                importance = importance,
                deadLine = Date(deadLineYear.value!! - 1900, deadLineMonth.value!!, deadLineDay.value!!, 0, 0, 0),
            )

            state.postValue(repo.createTodo(todoData).toState())
        }
    }
}