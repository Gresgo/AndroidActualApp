package com.gresgo.aaa

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    val router = AppRouter()

}