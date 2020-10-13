package com.example.androidlesson

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.androidlesson.databinding.ActivityMeanBinding
import com.example.androidlesson.layoutFra.*

class MenuActivity : FragmentActivity() {
    private lateinit var binding: ActivityMeanBinding
    private var meanSub = Menu.FIRST + 1
    private var submenuLin = Menu.FIRST + 2
    private var submenuGri = Menu.FIRST + 3
    private var contextAbs = Menu.FIRST + 4
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu?.setHeaderTitle("快捷菜单")
        menu?.add(Menu.NONE, contextAbs, 0, "绝对布局")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mean_mean, menu)
        val sub = menu?.addSubMenu(Menu.NONE, meanSub, 0, "部分布局")
        sub?.add(Menu.NONE, submenuLin, 0, "线性")
        sub?.add(Menu.NONE, submenuGri, 0, "网格")
        return menu != null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerForContextMenu(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val checkId = item.itemId
        // 选择菜单子项，切换Fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            val fragment = getInstanceByIndex(checkId) ?: return false
            replace(binding.frameLayout.id, fragment)
            addToBackStack(null)
        }
        fragmentTransaction.commit()
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return onOptionsItemSelected(item)
    }

    private fun getInstanceByIndex(index: Int): Fragment? {
        var fragment: Fragment? = null
        when (index) {
            /*meanSub -> fragment = LinearFragment()*/
            R.id.item_lin -> fragment = LinearFragment()
            submenuLin -> fragment = LinearFragment()
            R.id.item_tab -> fragment = TableFragment()
            R.id.item_gri -> fragment = GridFragment()
            submenuGri -> fragment = GridFragment()
            R.id.item_rel -> fragment = RelativeFragment()
            R.id.item_abs -> fragment = AbsoluteFragment()
            contextAbs -> fragment = AbsoluteFragment()
        }
        return fragment
    }
}