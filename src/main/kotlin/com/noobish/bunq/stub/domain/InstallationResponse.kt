package com.noobish.bunq.stub.domain


import com.fasterxml.jackson.annotation.JsonProperty

data class Token(@JsonProperty("created")
                 val created: String = "",
                 @JsonProperty("id")
                 val id: Int = 0,
                 @JsonProperty("updated")
                 val updated: String = "",
                 @JsonProperty("token")
                 val token: String = "")


data class Id(@JsonProperty("Token")
              val token: Token,
              @JsonProperty("id")
              val id: Int = 0,
              @JsonProperty("Id")
              val innerId: InnerId,
              @JsonProperty("ServerPublicKey")
              val serverPublicKey: ServerPublicKey)

data class InnerId(@JsonProperty("id") val id: Number)


data class InstallationId(@JsonProperty("Id")
                                val id: Id)


data class ServerPublicKey(@JsonProperty("server_public_key")
                           val serverPublicKey: String = "")


data class InstallationResponse(@JsonProperty("Response") val response: List<InstallationId>)