package com.noobish.bunq.stub.domain


import com.fasterxml.jackson.annotation.JsonProperty

data class DeviceServerResponse(@JsonProperty("Response")
                                val response: List<ResponseItem>?)


data class ResponseItem(@JsonProperty("Id")
                        val id: InnerId)