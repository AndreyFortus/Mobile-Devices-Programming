package com.example.lab_3

// String? - nullable тип
class Category(private val name: String?) {
    fun isValid(): Boolean {
        return name != null
    }
}

fun main() {
    val category1 = Category("Cars")
    val category2 = Category(null)

    println("category1 is valid: ${category1.isValid()}")
    println("category2 is valid: ${category2.isValid()}")
}
