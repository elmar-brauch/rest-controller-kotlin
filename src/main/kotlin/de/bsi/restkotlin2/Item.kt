package de.bsi.restkotlin2

import java.util.*

data class Item @JvmOverloads constructor(val name: String, val id: String, val date: Date = Date())