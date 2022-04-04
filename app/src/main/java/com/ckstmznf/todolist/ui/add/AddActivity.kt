package com.ckstmznf.todolist.ui.add

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.ckstmznf.todolist.R
import com.ckstmznf.todolist.base.BaseActivity
import com.ckstmznf.todolist.databinding.ActivityAddBinding
import com.ckstmznf.todolist.util.State
import com.ckstmznf.todolist.util.State.*

class AddActivity : BaseActivity<ActivityAddBinding>(R.layout.activity_add) {

    val viewModel : AddViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        binding.btnAddSubmit.setOnClickListener {
            viewModel.createTodo()
        }

        viewModel.state.observe(this){
            when (it) {
                SUCCESS -> {
                    Toast.makeText(this, "등록에 성공했습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                }
                ERROR -> {
                    Toast.makeText(this, "등록에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
                LOADING -> {

                }
            }
        }
    }
}