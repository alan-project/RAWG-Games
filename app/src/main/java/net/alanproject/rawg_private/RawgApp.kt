package net.alanproject.rawg_private

import android.app.Application
import timber.log.Timber

class RawgApp:Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}