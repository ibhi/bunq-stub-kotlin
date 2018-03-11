package com.noobish.bunq.stub.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun formatDate(date: LocalDateTime): String  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").format(date)