package com.example.data.networking.model

import com.example.data.database.model.ProductEntity
import com.example.data.networking.base.RoomMapper

data class ProductInfoResponse(val fragrances: List<Product>) : RoomMapper<ProductEntity> {

    override fun mapToRoomEntity() = ProductEntity(
        id = null, products = fragrances
    )
}

data class Product(
    val productName: String = "",
    val productDescription: String = "",
    val productImageUrl: String = "",
    val productPrice: String = "",
    val userRating: Int = 0
)

