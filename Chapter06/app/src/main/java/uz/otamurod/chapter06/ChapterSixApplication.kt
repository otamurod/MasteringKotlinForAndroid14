package uz.otamurod.chapter06

import android.app.Application
import org.koin.core.context.startKoin
import uz.otamurod.chapter06.di.appModules

class Chapter06Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}