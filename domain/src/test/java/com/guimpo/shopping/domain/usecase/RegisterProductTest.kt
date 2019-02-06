package com.guimpo.shopping.domain.usecase

import com.guimpo.shopping.domain.entity.Product
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RegisterProductTest {

    @Mock private lateinit var mockProduct: Product
    @Mock private lateinit var mockRepository: IProductRepository
    @Mock private lateinit var registerProduct: RegisterProduct

    @Before
    fun runBeforeEachTest() {
        MockitoAnnotations.initMocks(this)
        registerProduct = RegisterProduct()
    // mock object without MockitoAnnotations
    // mockProduct = mock(Product::class.java)
    // mockRepository = mock(IProductRepository::class.java)
    }

    @Test
    fun registerProductAlreadyBeenRegistered() {
        `when`(mockRepository.list()).thenReturn(listOf(mockProduct))

        assertFailsWith<ProductAlreadyExistException> {
            registerProduct.register(mockProduct, mockRepository)
        }
    }

    @Test
    fun registerProductNotBeenRegistered() {
        `when`(mockRepository.list()).thenReturn(emptyList())
        `when`(mockRepository.create(mockProduct)).thenReturn(1)
        assertEquals(1, registerProduct.register(mockProduct, mockRepository))
    }
}