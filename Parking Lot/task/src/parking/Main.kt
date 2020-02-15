package parking

import java.util.Scanner

data class Car(val registration: String, val colour: String)

fun main() {
    val scanner = Scanner(System.`in`)
    var size = 0
    var available = size
    var spots = arrayOfNulls<Car>(size)
    loop@ while (true) {
        val input = scanner.nextLine().split(" ")
        when (input[0]) {
            "create" -> {
                size = input[1].toInt()
                available = size
                spots = arrayOfNulls(size)
                println("Created a parking lot with $size spots.")
            }
            "park" -> {
                if (size == 0) {
                    println("Sorry, parking lot is not created.")
                } else if (available == 0) {
                    println("Sorry, parking lot is full.")
                } else {
                    for (i in 1..size) {
                        if (spots[i - 1] == null) {
                            spots[i - 1] = Car(input[1], input[2])
                            println("${input[2]} car parked on the spot $i.")
                            available--
                            break
                        }
                    }
                }
            }
            "leave" -> {
                if (size == 0) {
                    println("Sorry, parking lot is not created.")
                } else {
                    val i = input[1].toInt()
                    if (spots[i - 1] == null) {
                        println("There is no car in the spot $i.")
                    } else {
                        spots[i - 1] = null
                        println("Spot $i is free.")
                        available++
                    }
                }
            }
            "status" -> {
                if (size == 0) {
                    println("Sorry, parking lot is not created.")
                } else if (available == size) {
                    println("Parking lot is empty.")
                } else {
                    for (i in 1..size) {
                        val car = spots[i - 1]
                        if (car != null) {
                            println("$i ${car.registration} ${car.colour}")
                        }
                    }
                }
            }
            "exit" -> break@loop
        }
    }
}
