package com.example.data.networking.model

import com.example.data.database.model.DbProduct
import com.example.data.database.model.ProductEntity
import com.example.data.networking.base.RoomMapper
import com.example.domain.model.ProductInfo
import kotlin.random.Random

data class ProductInfoResponse(val fragrances: List<ProductInfo>) : RoomMapper<ProductEntity> {

    override fun mapToRoomEntity() =
        ProductEntity(
            product = fragrances.map {
                DbProduct(
                    id = it.productId,
                    name = it.productName,
                    description = it.productDescription,
                    url = it.productImageUrl,
                    price = it.productPrice,
                    rating = it.userRating,
                    addedToCart = it.addedToCart,
                    addedToWishList = it.addedToWishList
                )
            }
        )
}

data class ProductDetailResponse(val fragrance: ProductInfo) : RoomMapper<DbProduct> {

    override fun mapToRoomEntity() =
        DbProduct(
            id = fragrance.productId,
            name = fragrance.productName,
            description = fragrance.productDescription,
            url = fragrance.productImageUrl,
            price = fragrance.productPrice,
            rating = fragrance.userRating,
            addedToCart = fragrance.addedToCart,
            addedToWishList = fragrance.addedToWishList,

        )
}

