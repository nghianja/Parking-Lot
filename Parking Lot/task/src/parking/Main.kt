package parking

import java.util.Scanner

fun main() {
    val size = 20
    val spots = arrayOfNulls<String>(size)
    val scanner = Scanner(System.`in`)
    var available = size
        loop@ while (true) {
        val input = scanner.nextLine().split(" ")
        when (input[0]) {
            "park" -> {
                if (available == 0) {
                    println("Sorry, parking lot is full.")
                } else {
                    for (i in 1..size) {
                        if (spots[i - 1] == null) {
                            spots[i - 1] = input[1]
                            println("${input[2]} car parked on the spot $i.")
                            available--
                            break
                        }
                    }
                }
            }
            "leave" -> {
                val i = input[1].toInt()
                if (spots[i - 1] == null) {
                    println("There is no car in the spot $i.")
                } else {
                    spots[i - 1] = null
                    println("Spot $i is free.")
                    available++
                }
            }
            "exit" -> break@loop
        }
    }
}
