package it.fabiocati.thegamedb.utils

import java.security.Key
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

private const val IV_SIZE = 16
private const val TAG_BIT_LENGTH = 128
private const val ALGORITHM = "AES/GCM/NoPadding"

class SimpleCipher {

    private val key: Key = SecretKeySpec(getSecrets().aesKey.toByteArray(), "AES")

    fun encrypt(value: String): String {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, key)

        val base64Iv = cipher.iv.toBase64String()
        val encryptedString = cipher.doFinal(value.toByteArray()).toBase64String()
        return "$encryptedString$base64Iv"
    }

    fun decrypt(value: String): String {
        val base64String = value.dropLast(IV_SIZE)
        val base64Iv = value.takeLast(IV_SIZE).base64ToByteArray()
        val gcmParameterSpec = GCMParameterSpec(TAG_BIT_LENGTH, base64Iv)

        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, key, gcmParameterSpec)
        val plaintext = cipher.doFinal(base64String.base64ToByteArray())
        val decryptedString = String(plaintext, Charsets.UTF_8)
        return decryptedString
    }
}

private fun String.base64ToByteArray(): ByteArray {
    return Base64.getDecoder().decode(this)
}

private fun ByteArray.toBase64String(): String {
    return Base64.getEncoder().encodeToString(this)
}