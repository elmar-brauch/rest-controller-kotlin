package de.bsi.mix

import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct

@Component
class PrefixGenerator {
    private var prefix: Int? = null
    @PostConstruct
    private fun initPrefixAfterConstruction() {
        prefix = Random().nextInt(100)
    }

    fun generateId(): String {
        val uuid = UUID.randomUUID().toString()
        return String.format("%d_%s", prefix, uuid)
    }
}