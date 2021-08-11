package com.example.shoppingdemo.common.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ProductInfo
import com.example.shoppingdemo.R
import com.example.shoppingdemo.common.adapter.ProductListAction
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_product.view.*

const val IMAGE_SIDE_PX = 400

class ProductAdapter(val products: ArrayList<ProductInfo> = arrayListOf(), val actions: ProductListAction) : RecyclerView.Adapter<ProductAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_product,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val layout = itemView.postLayout
        private val productTitle = itemView.fragranceName
        private val productQuantity = itemView.userRating
        private val productPrice = itemView.price
        fun bind(productInfo: ProductInfo) {
            productTitle.text = productInfo.productName
            productQuantity.text = productInfo.userRating.toString()
            productPrice.text = productInfo.productPrice
            Picasso.get().
            load(productInfo.productImageUrl)
                .resize(IMAGE_SIDE_PX, IMAGE_SIDE_PX)
                .centerCrop()
                .into(itemView.imageView)
            layout.setOnClickListener { actions.onClick(productInfo.productId) }

        }
    }
}