package com.example.androidlesson

import androidx.fragment.app.Fragment
import com.example.androidlesson.layoutFra.*

class MyFragmentFactory {
    // 这是未完全使用视图绑定的版本
    fun getInstanceByIndex(index: Int): Fragment? {
        var fragment: Fragment? = null
        when (index) {
            R.id.radioButton -> fragment = LinearFragment()
            R.id.radioButton2 -> fragment = TableFragment()
            R.id.radioButton3 -> fragment = GridFragment()
            R.id.radioButton4 -> fragment = RelativeFragment()
            R.id.radioButton5 -> fragment = AbsoluteFragment()
        }
        return fragment
    }
}