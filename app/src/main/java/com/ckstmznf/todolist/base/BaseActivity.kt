package com.ckstmznf.todolist.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.ckstmznf.todolist.R

abstract class BaseActivity<D : ViewDataBinding>(
    @LayoutRes
    private val layoutResID : Int
) : AppCompatActivity() {

    protected lateinit var binding : D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResID)
        binding.lifecycleOwner = this
    }
}