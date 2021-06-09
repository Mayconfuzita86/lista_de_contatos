package com.dioinnovation.listadecontatos.bases

import android.icu.text.CaseMap
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.dioinnovation.listadecontatos.R

open class BaseActivity : AppCompatActivity(){
    protected fun setupToolBar(toolBar: androidx.appcompat.widget.Toolbar, title: String, navgationBack: Boolean) {
        toolBar.title = title
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(navgationBack)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
