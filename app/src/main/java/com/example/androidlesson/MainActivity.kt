package com.example.androidlesson

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.androidlesson.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* 不使用视图绑定的做法
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_loop_layoutA).setOnClickListener(){_->
            startActivity(Intent(this, LayoutActivity::class.java))
        }*/
        // 使用视图绑定的做法
        // 调用生成的绑定类中包含的静态inflate()方法。此操作会创建该绑定类的实例以供 Activity 使用。
        binding = ActivityMainBinding.inflate(layoutInflater)
        // 通过调用getRoot()方法或使用Kotlin 属性语法获取对根视图的引用。
        // 将根视图传递到setContentView()，使其成为屏幕上的活动视图
        setContentView(binding.root)
        // 使用该绑定类的实例来引用视图
        binding.btnLoopLayoutA.setOnClickListener() { _ ->
            startActivity(Intent(this, LayoutActivity::class.java))
        }
        binding.btnLoopMenuA.setOnClickListener() { _ ->
            startActivity(Intent(this, MenuActivity::class.java))
        }
        // 测试用
        /*startActivity(Intent(this, LayoutActivity::class.java))*/
    }
}

