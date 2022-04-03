package com.ckstmznf.todolist.ui.add

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.ckstmznf.todolist.R
import com.ckstmznf.todolist.base.BaseActivity
import com.ckstmznf.todolist.databinding.ActivityAddBinding

class AddActivity : BaseActivity<ActivityAddBinding>(R.layout.activity_add) {

    val viewModel : AddViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        binding.btnAddSubmit.setOnClickListener {
            Log.d("submit", "제목 : ${viewModel.todoTitle.value}")
            Log.d("submit", "중요도 : ${viewModel.importance}, ${viewModel._importance.value}")
            Log.d("submit", "마감일 : ${viewModel.deadLineYear.value} / ${viewModel.deadLineMonth.value} / ${viewModel.deadLineDay.value}")
        }
    }
}