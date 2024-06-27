package uz.otamurod.chapter07

import android.app.Application
import org.koin.core.context.startKoin
import uz.otamurod.chapter07.di.appModules

class Chapter07Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}