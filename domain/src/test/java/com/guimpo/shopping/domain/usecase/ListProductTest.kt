package com.guimpo.shopping.domain.usecase

import com.guimpo.shopping.domain.entity.Product
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

class ListProductTest {

    @Mock lateinit var mockRepository: IProductRepository
    @Mock lateinit var mockProduct1: Product
    @Mock lateinit var mockProduct2: Product
    lateinit var listProduct: ListProduct

    @Before
    fun runBeforeEachTest() {
        MockitoAnnotations.initMocks(this)
        listProduct = ListProduct(mockRepository)
    }

    @Test
    fun listProducts() {
        `when`(mockRepository.list()).thenReturn(listOf(mockProduct1, mockProduct2))
        assertEquals(2, listProduct.list().size)
    }

    @Test
    fun emptyListOfProducts() {
        `when`(mockRepository.list()).thenReturn(emptyList())
        assertEquals(0, listProduct.list().size)
    }
}