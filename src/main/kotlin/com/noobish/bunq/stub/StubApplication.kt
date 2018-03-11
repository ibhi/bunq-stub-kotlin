package com.noobish.bunq.stub

import com.noobish.bunq.stub.utils.generateKeypair
import com.noobish.bunq.stub.utils.saveKeys
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StubApplication: CommandLineRunner {
    override fun run(vararg args: String?) {
        saveKeys(generateKeypair())
    }
}

fun main(args: Array<String>) {
    runApplication<StubApplication>(*args)
}
