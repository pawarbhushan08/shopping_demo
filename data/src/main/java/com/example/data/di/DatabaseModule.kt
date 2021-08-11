package com.example.data.di

import androidx.room.Room
import com.example.data.database.ProductDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val PRODUCTS_DB = "products-database"

val databaseModule = module {
    single {
        //TODO remove fallbackToDestructiveMigration when this goes to production
        Room.databaseBuilder(androidContext(), ProductDatabase::class.java, PRODUCTS_DB).fallbackToDestructiveMigration().build()
    }
    factory { get<ProductDatabase>().weatherDao() }
}