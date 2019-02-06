package com.guimpo.shopping.domain.usecase

import com.guimpo.shopping.domain.entity.Product

class ListProduct(private val repository: IProductRepository) {
    fun list(): List<Product> {
        return repository.list()
    }
}
