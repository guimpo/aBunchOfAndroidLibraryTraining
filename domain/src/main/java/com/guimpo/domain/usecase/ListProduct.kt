package com.guimpo.domain.usecase

import com.guimpo.domain.entity.Product

class ListProduct(private val repository: IProductRepository) {
    fun list(): List<Product> {
        return repository.list()
    }
}
