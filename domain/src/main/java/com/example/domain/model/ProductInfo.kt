package com.example.domain.model

data class ProductInfo(
    var productId: Long,
    var productName: String,
    var productDescription: String,
    var productImageUrl: String,
    var productPrice: String,
    var userRating: Int,
    var addedToCart: Boolean,
    var addedToWishList: Boolean
)