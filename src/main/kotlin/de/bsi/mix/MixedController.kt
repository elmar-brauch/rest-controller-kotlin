package de.bsi.mix

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class MixedController(@Autowired val javaIdGenerator: IdGenerator,
                      @Autowired val kotlinPrefixGenerator: PrefixGenerator) {

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    fun generateId() =
        "KOTLIN:".plus(kotlinPrefixGenerator.generateId())
            .plus("___JAVA:").plus(javaIdGenerator.generateId())

}