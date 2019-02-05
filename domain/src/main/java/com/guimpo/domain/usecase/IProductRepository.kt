package com.guimpo.domain.usecase

import com.guimpo.domain.entity.Product

interface IProductRepository {

    fun create(product: Product): Long
    fun list(): List<Product>
    fun update(product: Product): Long
    fun delete(product: Product)
    fun find(product: Product): Product
}