package ru.adventOfCode

import ru.adventOfCode.dayTwo.PasswordPolicy
import java.io.File
import java.lang.Integer.parseInt

fun main() {
    val content = File("./src/main/kotlin/register.txt").readText()
    val list = content.split("\n").map { it.trim() }

    //twoNumbersEqual2020(list)
    //threeNumbersEqual2020(list)
    val passwordPolicy = PasswordPolicy()
    val validPasswordSize = passwordPolicy.checkForValidPasswords("./src/main/kotlin/daytwo.txt")
    println(validPasswordSize)

}

fun twoNumbersEqual2020(list: List<String>) {
    val expenseReport = ExpenseReport()
    val registerSize = list.size
    var index = 0
    while (index < registerSize) {
        val base = parseInt(list[index])
        for (item in list) {
            val is2020 = expenseReport.sum(base, parseInt(item))
            if (is2020 == 2020) {
                println("index $index base $base + current item $item = $is2020")
                println("base * parseInt(item)--------------------------------------------------------------------------")
                println(base * parseInt(item))
            }
        }
        index++

    }
}

fun threeNumbersEqual2020(list: List<String>) {
    val expenseReport = ExpenseReport()
    val registerSize = list.size
    var index = 0
    var current = 1
    while (index < registerSize && current < registerSize) {
        val base = parseInt(list[index])
        for (item in list) {
            val currentItem = parseInt(item)

            for (next in list) {
                val is2020 = expenseReport.sum(base, currentItem, parseInt(next))
                if (is2020 == 2020) {
                    println("index $index base $base + current $currentItem  item $item = $is2020")
                    println(base * currentItem * parseInt(item))
                }
            }
        }
        index++
    }
}

