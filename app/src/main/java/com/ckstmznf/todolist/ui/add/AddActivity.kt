package com.ckstmznf.todolist.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ckstmznf.todolist.R
import com.ckstmznf.todolist.base.BaseActivity
import com.ckstmznf.todolist.databinding.ActivityAddBinding

class AddActivity : BaseActivity<ActivityAddBinding>(R.layout.activity_add) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "에드 액티비티 실행")
    }
}