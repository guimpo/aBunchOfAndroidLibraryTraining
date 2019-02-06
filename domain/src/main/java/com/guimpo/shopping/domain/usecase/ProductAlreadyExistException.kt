package com.guimpo.shopping.domain.usecase

import java.lang.Exception

class ProductAlreadyExistException : Exception() {
    override val message: String?
        get() = "Product already exist"
}