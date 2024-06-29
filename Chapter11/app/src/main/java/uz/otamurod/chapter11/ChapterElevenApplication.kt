package uz.otamurod.chapter11

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import uz.otamurod.chapter11.di.appModules

class ChapterElevenApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            workManagerFactory()
            modules(appModules)
        }
    }
}