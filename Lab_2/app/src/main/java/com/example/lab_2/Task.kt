package com.example.lab_2

// Parent class
open class Flower(private val name: String, private val color: String) {
    fun getName(): String {
        return name
    }

    fun getColor(): String {
        return color
    }
}

// Subclasses
class Sunflower(color: String) : Flower("Sunflower", color)

class Rose(color: String) : Flower("Rose", color)

class Lily(color: String) : Flower("Lily", color)

class Jasmine(color: String) : Flower("Jasmine", color)

fun main() {
    val sunflower = Sunflower("Yellow")
    println("Name: ${sunflower.getName()}, Color: ${sunflower.getColor()}")

    val rose = Rose("Pink")
    println("Name: ${rose.getName()}, Color: ${rose.getColor()}")

    val lily = Lily("White")
    println("Name: ${lily.getName()}, Color: ${lily.getColor()}")

    val jasmine = Jasmine("White")
    println("Name: ${jasmine.getName()}, Color: ${jasmine.getColor()}")
}
