package com.noobish.bunq.stub.domain


import com.fasterxml.jackson.annotation.JsonProperty

data class PermittedIpsItem(val ip: String?)


data class DeviceServerRequest(@JsonProperty("description")
                               val description: String = "",
                               @JsonProperty("secret")
                               val secret: String = "",
                               @JsonProperty("permitted_ips")
                               val permittedIps: List<PermittedIpsItem>?)


