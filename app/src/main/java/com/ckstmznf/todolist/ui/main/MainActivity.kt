package com.ckstmznf.todolist.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckstmznf.todolist.R
import com.ckstmznf.todolist.base.BaseActivity
import com.ckstmznf.todolist.databinding.ActivityMainBinding
import com.ckstmznf.todolist.ui.add.AddActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel



        binding.btnMainAddTodo.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerMainTodoList.adapter = MainTodoListAdapter()
        binding.recyclerMainTodoList.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager(this).orientation))


        binding.swipeMain.setOnRefreshListener{
            viewModel.readTodo()
        }
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.readTodo()
    }
}