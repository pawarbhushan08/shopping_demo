package com.example.data.networking

import com.example.data.networking.model.ProductDetailResponse
import com.example.data.networking.model.ProductInfoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {
  
  @GET("response")
  suspend fun getProducts(): Response<ProductInfoResponse>

  @GET("product")
  suspend fun getProduct(): Response<ProductDetailResponse>
}