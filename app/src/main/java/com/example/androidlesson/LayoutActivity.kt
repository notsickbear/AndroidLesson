package com.example.androidlesson

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.androidlesson.databinding.ActivityLayoutBinding

class LayoutActivity : FragmentActivity() {

    private lateinit var binding: ActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 以根视图作为活动视图
        binding = ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 事先添加第一个线性Fragment作为初始画面，注意每个事务（Transaction）只能commit一次
/*        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container_view_tag, LinearFragment())
        fragmentTransaction.commit()*/
        // 按下按钮，切换Fragment，这是未完全使用视图绑定的版本
        binding.radioGroup.setOnCheckedChangeListener() { _, checkId ->
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.apply {
                var fragment = MyFragmentFactory().getInstanceByIndex(checkId)
                if (fragment != null) {
                    replace(binding.fragmentContainerViewTag.id, fragment)
                }
                addToBackStack(null)
            }
            fragmentTransaction.commit()
        }
    }
}