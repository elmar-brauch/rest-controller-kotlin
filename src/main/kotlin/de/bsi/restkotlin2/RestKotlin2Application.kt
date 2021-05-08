package de.bsi.restkotlin2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestKotlin2Application

fun main(args: Array<String>) {
	runApplication<RestKotlin2Application>(*args)
}
