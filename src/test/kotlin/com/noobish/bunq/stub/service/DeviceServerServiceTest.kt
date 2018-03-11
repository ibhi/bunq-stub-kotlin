package com.noobish.bunq.stub.service

import org.junit.Test

import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
class DeviceServerServiceTest {
    private val deviceServerService = DeviceServerService()

    @Test
    fun buildResponse() {
        val response = deviceServerService.buildResponse().response

        assertThat(response).isNotEmpty
        assertThat(response?.size).isEqualTo(1)
        assertThat(response?.get(0)?.id?.id).isNotNull
    }
}