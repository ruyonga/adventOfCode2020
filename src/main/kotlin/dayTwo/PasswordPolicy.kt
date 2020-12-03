package ru.adventOfCode.dayTwo

import java.io.File
import java.lang.Integer.parseInt

class PasswordPolicy {
    private var validPasswordList: MutableList<String> = mutableListOf()
    private var validPasswordListTwo: MutableList<String> = mutableListOf()

    fun checkForValidPasswords(db: String): Int {
        val entries = readFile(db)
        for (entry in entries) {

            val dbEntry = listEntry(entry)

            val isValid = isPasswordValid(policy(dbEntry), key(dbEntry), password(dbEntry))
            if (isValid) {
                addValidPassword(entry)
            }
        }
        return validPasswords()
    }

//    fun checkForValidPasswordPartTwo(db: String): Int {
//        val entries = readFile(db)
//        for (entry in entries) {
//            val dbEntry = listEntry(entry)
//            validatePassword(policy(dbEntry), key(dbEntry), password(dbEntry))
//        }
//        return validPasswordListTwo.size
//    }
//
//    private fun validatePassword(policy: List<Int>, key: String, password: String) {
//        password.forEachIndexed { index, element ->
//            println("$index == ${policy[0]} $index == ${policy[1]}")
//             if((key == element.toString() && index == policy[0]) || (key == element.toString()  && index == policy[1])){
//                 validPasswordListTwo.add(password)
//
//             }
//
//        }
//
//    }


    private fun isPasswordValid(policy: List<Int>, key: String, password: String): Boolean {
        val keyInString = password.filter { it.toString() == key }.length
        return keyInString >= policy[0] && keyInString <= policy[1]
    }

    private fun addValidPassword(password: String) = validPasswordList.add(password)
    private fun validPasswords() = validPasswordList.size

    private fun policy(row: List<String>): List<Int> {
        return row[0].split("-").map { parseInt(it.trim()) }

    }

    private fun key(row: List<String>): String {
        return row[1][0].toString()
    }

    private fun password(row: List<String>): String {
        return row[2]
    }

    private fun listEntry(entry: String): List<String> {
        return entry.split(" ").map { it.trim() }
    }

    private fun readFile(path: String): List<String> {
        val content = File(path).readText()
        return content.split("\n").map { it.trim() }

    }


}
