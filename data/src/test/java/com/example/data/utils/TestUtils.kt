package com.example.data.utils

import com.example.data.database.model.ProductEntity
import com.example.data.networking.model.ProductInfoResponse
import okhttp3.MediaType
import okhttp3.ResponseBody

const val OSIJEK_CITY_NAME = "Osijek"
const val FAKE_FAILURE_ERROR_CODE = 400

val successProductInfoResponse = ProductInfoResponse(fragrances = listOf())
val failureResponseBody = ResponseBody.create(MediaType.parse("text"), "network error")
val fakeProductEntity = ProductEntity(id = null, products = listOf())
