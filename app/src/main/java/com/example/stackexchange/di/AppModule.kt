package com.example.stackexchange.di

import com.example.stackexchange.data.repository.StackExchangeRepository
import com.example.stackexchange.data.repository.UsersRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val networkModule = module {
    factory { RetrofitBuilder.StackExchangeApi }

}

val repo: Module = module {
    single<StackExchangeRepository> { UsersRepository(get()) }
}


//val viewModels = module {
//    viewModel {
//        JokesViewModel(repository = get())
//    }
//}