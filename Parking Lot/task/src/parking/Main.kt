package parking

import java.util.Scanner

fun main() {
    val spots = arrayOfNulls<String>(2)
    spots[0] = "LS-!@-JJ-2345"

    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine().split(" ")

    when (input[0]) {
        "park" -> {
            for (i in 1..2) {
                if (spots[i - 1] == null) {
                    spots[i - 1] = input[1]
                    println("${input[2]} car parked on the spot $i.")
                    break
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
            }
        }
    }
}
