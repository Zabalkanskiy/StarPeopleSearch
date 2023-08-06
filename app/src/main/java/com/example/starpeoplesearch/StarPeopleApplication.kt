package com.example.starpeoplesearch

import android.app.Application
import android.content.Context

class StarPeopleApplication : Application(){
    init {
        app = this
    }

    companion object {
        private lateinit var app : StarPeopleApplication

        fun getAppContext(): Context = app.applicationContext
    }
}