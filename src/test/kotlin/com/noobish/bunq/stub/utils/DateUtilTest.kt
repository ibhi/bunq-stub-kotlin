package com.noobish.bunq.stub.utils

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RunWith(SpringJUnit4ClassRunner::class)
class DateUtilTest {

    @Test
    fun testDateFormat() {
        val instant : LocalDateTime = LocalDateTime.parse("2015-06-13 23:19:16.215235", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"))
        println(instant)
        println(formatDate(instant))
    }
}