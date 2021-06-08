package com.example.data.database

import androidx.room.TypeConverter
import com.example.data.networking.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    // Weather list converters

    @TypeConverter
    fun fromWeatherListToJson(list: List<Product>?): String {
        return list?.let { gson.toJson(it) } ?: ""
    }

    @TypeConverter
    fun fromJsonToWeatherList(jsonList: String): List<Product> {
        val listType = object : TypeToken<List<Product>>() {}.type
        return gson.fromJson(jsonList, listType)
    }
}