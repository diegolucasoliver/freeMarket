package com.dmlo.freemarket.data.di

import com.dmlo.freemarket.data.RetrofitClient
import com.dmlo.freemarket.data.datasource.DescriptionDataSource
import com.dmlo.freemarket.data.datasource.ItemsDataSource
import org.koin.dsl.module

val dataModule = module {
    single<ItemsDataSource> { ItemsDataSource(RetrofitClient.service) }
    single<DescriptionDataSource> { DescriptionDataSource(RetrofitClient.service) }
}