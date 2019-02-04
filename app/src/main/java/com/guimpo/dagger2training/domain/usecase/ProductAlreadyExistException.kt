package com.guimpo.dagger2training.domain.usecase

import java.lang.Exception

class ProductAlreadyExistException : Exception() {
    override val message: String?
        get() = "Product already exist"
}