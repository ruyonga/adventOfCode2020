package ru.adventOfCode

import ru.adventOfCode.dayTwo.PasswordPolicy
import java.io.File
import java.lang.Integer.parseInt

fun main() {
    val content = File("./src/main/kotlin/register.txt").readText()
    val list = content.split("\n").map { it.trim() }
//    val expenseReport = ExpenseReport()
//    expenseReport.twoNumbersEqual2020(list)
//    expenseReport.threeNumbersEqual2020(list)
    val passwordPolicy = PasswordPolicy()
    val validPasswordSize = passwordPolicy.checkForValidPasswords("./src/main/kotlin/daytwo.txt")
     println(validPasswordSize)

}


