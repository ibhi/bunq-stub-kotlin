package com.noobish.bunq.stub.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import java.io.File
import java.security.KeyPair
import java.security.PrivateKey
import java.security.PublicKey

@RunWith(SpringRunner::class)
class KeyUtilTest {

    @Test
    fun testGenerateKeys() {
        val keyPair: KeyPair = generateKeypair()

        assertThat(keyPair.public).isNotNull
        assertThat(keyPair.private).isNotNull

        assertThat(keyPair.public.format).contains("X.509")
        assertThat(keyPair.private.format).contains("PKCS#8")
    }

    @Test
    fun testSaveKeys() {
        generateAndSaveKeyPair()

        val publicKeyFile = File(PUBLIC_KEY_FILE_NAME)
        val privateKeyFile = File(PRIVATE_KEY_FILE_NAME)

        assertThat(publicKeyFile.exists()).isEqualTo(true)
        assertThat(privateKeyFile.exists()).isEqualTo(true)

//      To make tests idempotent clear the files
        deleteKeyPair()
    }

    @Test
    fun testRetrievePrivateKey() {
        generateAndSaveKeyPair()

        assertThat(retrievePrivateKey()).isNotNull

//      To make tests idempotent clear the files
        deleteKeyPair()
    }

    @Test
    fun testRetrievePublicKey() {
        generateAndSaveKeyPair()

        assertThat(retrievePublicKey()).isNotNull

//      To make tests idempotent clear the files
        deleteKeyPair()
    }

    @Test
    fun testPrivateKeyToFormattedString() {
        val privateKeyString = privateKeyToFormattedString(generateKeypair().private)

        assertThat(privateKeyString).contains("-----BEGIN RSA PRIVATE KEY-----\n")
        assertThat(privateKeyString).contains("-----END RSA PRIVATE KEY-----\n")
    }

    @Test
    fun testPublicKeyToFormattedString() {
        val publicKeyString = publicKeyToFormattedString(generateKeypair().public)

        assertThat(publicKeyString).contains("-----BEGIN RSA PUBLIC KEY-----\n")
        assertThat(publicKeyString).contains("-----END RSA PUBLIC KEY-----\n")
    }

    @Test
    fun testPrivateKeyFromFormattedString() {
        val privateKeyString: String = privateKeyToFormattedString(generateKeypair().private)
        val privateKey: PrivateKey = privateKeyFromFormattedString(privateKeyString)

        assertThat(privateKey).isNotNull
    }

    @Test
    fun testPublicKeyFromFormattedString() {
        val publicKeyString: String = publicKeyToFormattedString(generateKeypair().public)
        val publicKey: PublicKey = publicKeyFromFormattedString(publicKeyString)

        assertThat(publicKey).isNotNull
    }

    private fun deleteKeyPair() {
        val publicKeyFile = File(PUBLIC_KEY_FILE_NAME)
        val privateKeyFile = File(PRIVATE_KEY_FILE_NAME)
        publicKeyFile.delete()
        privateKeyFile.delete()
    }

    private fun generateAndSaveKeyPair() {
        saveKeys(generateKeypair())
    }

}