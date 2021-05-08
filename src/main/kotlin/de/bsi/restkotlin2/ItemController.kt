package de.bsi.restkotlin2

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ItemController {

    val items = mutableListOf<Item>();

    @GetMapping
    fun getItemByName(@RequestParam(required = true) itemName: String): ResponseEntity<Item> =
        items.stream().filter { it.name.equals(itemName, true) }.findFirst()
            .map { ok(it) }.orElse(notFound().build())

    @PostMapping
    fun addItem(@RequestBody item : Item): ResponseEntity<Unit> {
        items.add(item)
        return status(HttpStatus.CREATED).build()
    }

    @DeleteMapping("/{itemId}")
    fun deleteItemById(@PathVariable itemId: String?): ResponseEntity<Unit> =
        if (items.removeIf{it.id == itemId}) noContent().build() else notFound().build()

}