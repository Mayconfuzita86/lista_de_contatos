package com.dioinnovation.listadecontatos.application

import android.app.Application
import com.dioinnovation.listadecontatos.helpers.HelperDB

class ContatoApplication : Application() {

    var helperDB: HelperDB? = null
    private set //protecao para sets externos

    override fun onCreate() {
        super.onCreate()
        helperDB = HelperDB(this)
    }
}