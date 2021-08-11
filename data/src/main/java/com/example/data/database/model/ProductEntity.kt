package com.example.data.database.model

import androidx.room.*
import com.example.data.database.Converters
import com.example.data.database.PRODUCT_LIST_TABLE_NAME
import com.example.data.networking.base.DomainMapper
import com.example.domain.model.ProductInfo

@Entity(tableName = PRODUCT_LIST_TABLE_NAME)
data class ProductEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Long = 0L,
    @TypeConverters(Converters::class)
    val product: List<DbProduct>? = listOf()
) : DomainMapper<List<ProductInfo>> {

    override fun mapToDomainModel(): List<ProductInfo> {
        return product?.map {
            ProductInfo(
                productId = it.id,
                productName = it.name,
                productDescription = it.description,
                productImageUrl = it.url,
                productPrice = it.price,
                userRating = it.rating,
                addedToCart = it.addedToCart,
                addedToWishList = it.addedToWishList,

            )
        } ?: emptyList<ProductInfo>()
    }
}