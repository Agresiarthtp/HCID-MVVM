package com.kotlin.homecreditindonesia.apitest

import com.kotlin.homecreditindonesia.network.RestApi
import org.junit.Test
import org.mockito.Mockito

class ApiRepositoryTest {
    @Test
    fun testDoRequest() {
        val apiRepositoryTest = Mockito.mock(RestApi::class.java)
        apiRepositoryTest.getDataProduct()
        Mockito.verify(apiRepositoryTest).getDataProduct()
    }
}