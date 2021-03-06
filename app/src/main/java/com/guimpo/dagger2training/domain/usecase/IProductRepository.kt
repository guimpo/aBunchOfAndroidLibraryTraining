package com.guimpo.dagger2training.domain.usecase

import com.guimpo.dagger2training.domain.entity.Product

interface IProductRepository {

    fun create(product: Product): Long
    fun list(): List<Product>
    fun update(product: Product): Long
    fun delete(product: Product)
    fun find(product: Product): Product
}