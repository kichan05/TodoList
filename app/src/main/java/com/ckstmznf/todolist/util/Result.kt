package com.ckstmznf.todolist.util

enum class Result {
    SUCCESS,
    ERROR,
    LOADING,
}

fun Result.toState() : State = when(this){
    Result.SUCCESS -> State.SUCCESS
    Result.ERROR -> State.ERROR
    Result.LOADING -> State.LOADING
}