package com.example.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.database.PRODUCT_TABLE_NAME
import com.example.data.networking.base.DomainMapper
import com.example.domain.model.ProductInfo

@Entity(tableName = PRODUCT_TABLE_NAME)
data class DbProduct(
    @PrimaryKey
    val id: Long = 0L,
    val name: String,
    val description: String,
    val url: String,
    val price: String,
    val rating: Int = 0,
    val addedToCart: Boolean,
    val addedToWishList: Boolean
): DomainMapper<ProductInfo>{
    override fun mapToDomainModel() = ProductInfo(
        productId = id,
        productName = name,
        productDescription = description,
        productImageUrl = url,
        productPrice = price,
        userRating = rating,
        addedToCart = addedToCart,
        addedToWishList = addedToWishList
    )
}