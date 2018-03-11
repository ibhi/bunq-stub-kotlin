package com.noobish.bunq.stub.resource

import com.noobish.bunq.stub.domain.DeviceServerRequest
import com.noobish.bunq.stub.domain.DeviceServerResponse
import com.noobish.bunq.stub.service.DeviceServerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DeviceServerController(val deviceServerService: DeviceServerService) {

    @PostMapping("/device-server")
    fun buildResponse(@RequestBody body: DeviceServerRequest): DeviceServerResponse {
        return deviceServerService.buildResponse()
    }
}