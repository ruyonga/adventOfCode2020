package ru.adventOfCode
class ExpenseReport {
    fun  sum(current: Int, next: Int): Int {

        return  current + next
    }

    fun  sum(base: Int, current: Int, next: Int): Int {

        return  current + next+base
    }
}