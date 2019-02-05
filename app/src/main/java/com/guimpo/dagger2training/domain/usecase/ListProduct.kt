package com.guimpo.dagger2training.domain.usecase

import com.guimpo.dagger2training.domain.entity.Product

class ListProduct(private val repository: IProductRepository) {
    fun list(): List<Product> {
        return repository.list()
    }
}
