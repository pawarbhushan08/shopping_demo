package com.example.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.database.WEATHER_TABLE_NAME
import com.example.data.networking.base.DomainMapper
import com.example.data.networking.model.Product
import com.example.domain.model.ProductInfo

@Entity(tableName = WEATHER_TABLE_NAME)
data class ProductEntity(
    @PrimaryKey val id: Int? = 0,
    val products: List<Product>?
) : DomainMapper<List<ProductInfo>> {

    override fun mapToDomainModel(): List<ProductInfo> {
        return products?.map {
            ProductInfo(
                productName = it.productName,
                productDescription = it.productDescription,
                productImageUrl = it.productImageUrl,
                productPrice = it.productPrice,
                userRating = it.userRating
            )
        } ?: emptyList<ProductInfo>()
    }
}