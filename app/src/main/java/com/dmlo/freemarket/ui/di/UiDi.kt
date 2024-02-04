package com.dmlo.freemarket.ui.di

import com.dmlo.freemarket.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel<MainViewModel> { MainViewModel(get(), get()) }
}