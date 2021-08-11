package com.example.data.database

import androidx.room.TypeConverter
import com.example.data.database.model.DbProduct
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    // Weather list converters

    @TypeConverter
    fun fromProductListToJson(list: List<DbProduct>?): String {
        return list?.let { gson.toJson(it) } ?: ""
    }

    @TypeConverter
    fun fromJsonToProductList(jsonList: String): List<DbProduct> {
        val listType = object : TypeToken<List<DbProduct>>() {}.type
        return gson.fromJson(jsonList, listType)
    }
}