package com.noobish.bunq.stub.resource

import com.noobish.bunq.stub.domain.InstallationRequest
import com.noobish.bunq.stub.domain.InstallationResponse
import com.noobish.bunq.stub.service.InstallationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InstallationController(val installationService: InstallationService) {

    @PostMapping("/installation")
    fun postInstallation(@RequestBody installationRequest: InstallationRequest): InstallationResponse {
        return installationService.buildResponse()
    }
}