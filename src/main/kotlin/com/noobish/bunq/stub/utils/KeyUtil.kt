package com.noobish.bunq.stub.utils

import java.io.File
import java.security.*
import java.security.spec.PKCS8EncodedKeySpec
import java.security.PublicKey
import java.security.spec.X509EncodedKeySpec
import java.util.*


const val KEY_PAIR_ALGORITHM = "RSA"
const val PUBLIC_KEY_FILE_NAME = "public_key"
const val PRIVATE_KEY_FILE_NAME = "private_key"


private const val PRIVATE_KEY_START = "-----BEGIN RSA PRIVATE KEY-----\n"
private const val PRIVATE_KEY_END = "\n-----END RSA PRIVATE KEY-----\n"
private const val PUBLIC_KEY_START = "-----BEGIN RSA PUBLIC KEY-----\n"
private const val PUBLIC_KEY_END = "\n-----END RSA PUBLIC KEY-----\n"
private const val EMPTY_STRING = ""
private const val NEWLINE = "\n"

val encoder: Base64.Encoder = Base64.getEncoder()
val decoder: Base64.Decoder = Base64.getDecoder()

fun generateKeypair(): KeyPair {
    val kpg: KeyPairGenerator = KeyPairGenerator.getInstance(KEY_PAIR_ALGORITHM)
    kpg.initialize(2048)
    return kpg.generateKeyPair()
}

fun saveKeys(keyPair: KeyPair) {
    File("public_key").writeBytes(keyPair.public.encoded)
    File("private_key").writeBytes(keyPair.private.encoded)
}

fun retrievePrivateKey(): PrivateKey = generatePrivateKeyFromByteArray(File(PRIVATE_KEY_FILE_NAME).readBytes())

fun retrievePublicKey(): PublicKey = generatePublicKeyFromByteArray(File(PUBLIC_KEY_FILE_NAME).readBytes())

fun privateKeyToFormattedString(privateKey: PrivateKey): String = "$PRIVATE_KEY_START${encoder.encodeToString(privateKey.encoded)}$PRIVATE_KEY_END"

fun publicKeyToFormattedString(publicKey: PublicKey): String = "$PUBLIC_KEY_START${encoder.encodeToString(publicKey.encoded)}$PUBLIC_KEY_END"

fun privateKeyFromFormattedString(privateKeyFormattedString: String): PrivateKey {
    val privateKeyString = privateKeyFormattedString
            .replace(PRIVATE_KEY_START, EMPTY_STRING)
            .replace(PRIVATE_KEY_END, EMPTY_STRING)
            .replace(NEWLINE, EMPTY_STRING)

    return generatePrivateKeyFromByteArray(decoder.decode(privateKeyString))
}

fun publicKeyFromFormattedString(publicKeyFormattedString: String): PublicKey {
    val publicKeyString = publicKeyFormattedString
            .replace(PUBLIC_KEY_START, EMPTY_STRING)
            .replace(PUBLIC_KEY_END, EMPTY_STRING)
            .replace(NEWLINE, EMPTY_STRING)
    return generatePublicKeyFromByteArray(decoder.decode(publicKeyString))
}

private fun generatePublicKeyFromByteArray(byteArray: ByteArray): PublicKey {
    val ks = X509EncodedKeySpec(byteArray)
    val kf = KeyFactory.getInstance(KEY_PAIR_ALGORITHM)
    return kf.generatePublic(ks)
}

private fun generatePrivateKeyFromByteArray(byteArray: ByteArray): PrivateKey {
    val ks = PKCS8EncodedKeySpec(byteArray)
    val kf = KeyFactory.getInstance(KEY_PAIR_ALGORITHM)
    return kf.generatePrivate(ks)
}