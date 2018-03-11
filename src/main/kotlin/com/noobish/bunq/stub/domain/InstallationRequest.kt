package com.noobish.bunq.stub.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class InstallationRequest(@JsonProperty("client_public_key")
                               val clientPublicKey: String)