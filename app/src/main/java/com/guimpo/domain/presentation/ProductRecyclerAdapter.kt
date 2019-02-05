package com.guimpo.dagger2training.presentation

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guimpo.dagger2training.R
import com.guimpo.domain.entity.Product
import kotlinx.android.synthetic.main.product_item.view.*

class ProductRecyclerAdapter(private val products: ArrayList<Product>)
    : RecyclerView.Adapter<ProductRecyclerAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductRecyclerAdapter.ProductHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductHolder(inflatedView)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(productHolder: ProductRecyclerAdapter.ProductHolder, position: Int) {
        productHolder.bindProduct(products[position])
    }

    class ProductHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var product: Product? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d("RecyclerView", "Click")
        }

        fun bindProduct(product: Product) {
            this.product = product
            view.productName.text = product.name
            view.productCategory.text = product.category.name
        }

    }
}