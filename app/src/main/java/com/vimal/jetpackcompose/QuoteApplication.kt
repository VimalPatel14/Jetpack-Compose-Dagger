package com.vimal.jetpackcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QuoteApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}