package com.noobish.bunq.stub.service

import com.noobish.bunq.stub.domain.DeviceServerResponse
import com.noobish.bunq.stub.domain.InnerId
import com.noobish.bunq.stub.domain.ResponseItem
import org.springframework.stereotype.Service
import java.util.*

@Service
class DeviceServerService {
    fun buildResponse(): DeviceServerResponse {
        val id = InnerId(Random().nextInt())
        val responseItem = ResponseItem(id)
        return DeviceServerResponse(Arrays.asList(responseItem))
    }
}