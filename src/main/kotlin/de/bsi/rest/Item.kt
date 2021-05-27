package de.bsi.rest

import java.util.*

data class Item @JvmOverloads constructor(val name: String, val id: String, val date: Date = Date())