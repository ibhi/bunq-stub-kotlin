package com.noobish.bunq.stub.service

import com.noobish.bunq.stub.domain.*
import com.noobish.bunq.stub.utils.formatDate
import com.noobish.bunq.stub.utils.publicKeyToFormattedString
import com.noobish.bunq.stub.utils.retrievePublicKey
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class InstallationService {
    fun buildResponse(): InstallationResponse {
        val innerId = InnerId(Random().nextInt())

        val token = Token(
                id = Random().nextInt(),
                created = formatDate(LocalDateTime.now()),
                updated = formatDate(LocalDateTime.now()),
                token = "a4f9d888eea84f52722b9baf2f17c289d549edf6e0eccdbf868eb922be306fb6"
        )

        val serverPublicKey = ServerPublicKey(publicKeyToFormattedString(retrievePublicKey()))

        val id = Id(innerId = innerId, token = token, serverPublicKey = serverPublicKey, id = Random().nextInt())

        val installationId = InstallationId(id)

        return InstallationResponse(Arrays.asList(installationId))
    }

}