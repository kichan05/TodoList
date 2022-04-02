package com.ckstmznf.todolist.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ckstmznf.todolist.R
import com.ckstmznf.todolist.base.BaseActivity
import com.ckstmznf.todolist.databinding.ActivityMainBinding
import com.ckstmznf.todolist.ui.add.AddActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnMainAddTodo.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }
}