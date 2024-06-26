package uz.otamurod.chapter05.di

import uz.otamurod.chapter05.viewmodel.PetsViewModel
import org.koin.dsl.module
import uz.otamurod.chapter05.data.PetsRepository
import uz.otamurod.chapter05.data.PetsRepositoryImpl

val appModules = module {
    single<PetsRepository> { PetsRepositoryImpl() }
    single { PetsViewModel(get()) }
}