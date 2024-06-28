package uz.otamurod.chapter08

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import uz.otamurod.chapter08.di.appModules
import org.koin.core.context.startKoin

class ChapterEightApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            workManagerFactory()
            modules(appModules)
        }
    }
}