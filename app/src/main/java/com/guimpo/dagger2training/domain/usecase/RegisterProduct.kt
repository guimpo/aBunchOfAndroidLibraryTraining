package com.guimpo.dagger2training.domain.usecase

import com.guimpo.dagger2training.domain.entity.Product

class RegisterProduct {

    fun register(product: Product, repository: IProductRepository): Long {
        if (isAlreadyBeenRegistered(product, repository)) {
            throw ProductAlreadyExistException()
        } else {
            return repository.create(product)
        }
    }

    private fun isAlreadyBeenRegistered(product: Product, repository: IProductRepository): Boolean {
        return repository.list().contains(product)
    }
}