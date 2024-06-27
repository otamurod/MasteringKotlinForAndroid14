package uz.otamurod.chapter07

import android.app.Application
import uz.otamurod.chapter07.di.appModules
import org.koin.core.context.startKoin

class ChapterSevenApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}