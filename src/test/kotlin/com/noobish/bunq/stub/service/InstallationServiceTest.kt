package com.noobish.bunq.stub.service

import com.noobish.bunq.stub.domain.InstallationResponse
import com.noobish.bunq.stub.utils.generateKeypair
import com.noobish.bunq.stub.utils.saveKeys
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
class InstallationServiceTest {
    private val installationService = InstallationService()

    @Test
    fun testBuildResponse() {
        saveKeys(generateKeypair())
        val installationResponse = installationService.buildResponse()
        val response = installationResponse.response

        assertThat(response.size).isEqualTo(1)
        assertThat(response[0].id).isNotNull
        assertThat(response[0].id.token.token).contains("a4f9d888eea84f52722b9baf2f17c289d549edf6e0eccdbf868eb922be306fb6")
        assertThat(response[0].id.serverPublicKey.serverPublicKey).containsOnlyOnce("-----BEGIN RSA PUBLIC KEY-----")
        assertThat(response[0].id.id).isNotNull()
    }
}