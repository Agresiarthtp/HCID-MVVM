package com.kotlin.homecreditindonesia.apitest

import com.kotlin.homecreditindonesia.network.RestApi
import org.junit.Test
import org.mockito.Mockito

class ApiRespositoryTest {
    @Test
    fun testDoRequest() {
        val apiRespositoryTest = Mockito.mock(RestApi::class.java)
        apiRespositoryTest.getDataProduct()
        Mockito.verify(apiRespositoryTest).getDataProduct()
    }
}