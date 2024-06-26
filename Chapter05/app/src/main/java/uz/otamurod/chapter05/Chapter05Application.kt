package uz.otamurod.chapter05

import android.app.Application
import org.koin.core.context.startKoin
import uz.otamurod.chapter05.di.appModules

class Chapter05Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}