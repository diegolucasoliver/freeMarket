package com.dmlo.freemarket.repository.di

import com.dmlo.freemarket.repository.DescriptionRepository
import com.dmlo.freemarket.repository.ItemsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ItemsRepository> { ItemsRepository(get()) }
    single<DescriptionRepository> { DescriptionRepository(get()) }
}