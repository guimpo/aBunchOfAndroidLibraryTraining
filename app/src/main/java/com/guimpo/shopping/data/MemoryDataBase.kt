package com.guimpo.shopping.data

import com.guimpo.shopping.domain.entity.Category
import com.guimpo.shopping.domain.entity.Product
import com.guimpo.shopping.domain.usecase.IProductRepository

class MemoryDataBase : IProductRepository {

    private var products: MutableList<Product> = mutableListOf(
        Product("onion", Category.FOOD),
        Product("vinegar", Category.FOOD),
        Product("soap", Category.CLEANING),
        Product("broom", Category.CLEANING)
    )

    override fun create(product: Product): Long {
        when (products.contains(product)) {
            true -> return 0
            false -> with(products) {
                add(product)
                return indexOf(product).toLong()
            }
        }
    }

    override fun list(): List<Product> {
        return products
    }

    override fun update(product: Product): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(product: Product) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(product: Product): Product {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}