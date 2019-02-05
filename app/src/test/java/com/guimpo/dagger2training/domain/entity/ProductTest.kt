package com.guimpo.dagger2training.domain.entity

import com.guimpo.dagger2training.domain.entity.Category
import com.guimpo.dagger2training.domain.entity.Product
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ProductTest {

    @Test
    fun testSameNameDifferentCategory() {
        val foodCategory = Category.FOOD
        val cleaningCategory = Category.CLEANING

        val foodProduct1 = Product("vinegar", foodCategory)
        val foodProduct2 = Product("vinegar", foodCategory)
        val cleaningProduct = Product("vinegar", cleaningCategory)

        assertFalse {
            foodProduct1 == cleaningProduct
        }

        assertTrue {
            foodProduct1 == foodProduct2
        }
    }

    @Test
    fun testDifferentNameSameCategory() {
        val foodCategory = Category.FOOD

        val foodProduct1 = Product("vinegar", foodCategory)
        val foodProduct2 = Product("coke", foodCategory)

        assertFalse {
            foodProduct1 == foodProduct2
        }
    }
}