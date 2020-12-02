package ru.adventOfCode
class ExpenseReport {
    private fun  sum(current: Int, next: Int): Int {
        return  current + next
    }

    private fun  sum(base: Int, current: Int, next: Int): Int {
        return  current + next+base
    }

    fun twoNumbersEqual2020(list: List<String>) {
        val expenseReport = ExpenseReport()
        val registerSize = list.size
        var index = 0
        while (index < registerSize) {
            val base = Integer.parseInt(list[index])
            for (item in list) {
                val is2020 = expenseReport.sum(base, Integer.parseInt(item))
                if (is2020 == 2020) {
                    println("index $index base $base + current item $item = $is2020")
                    println("base * parseInt(item)--------------------------------------------------------------------------")
                    println(base * Integer.parseInt(item))
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
            val base = Integer.parseInt(list[index])
            for (item in list) {
                val currentItem = Integer.parseInt(item)

                for (next in list) {
                    val is2020 = expenseReport.sum(base, currentItem, Integer.parseInt(next))
                    if (is2020 == 2020) {
                        println("index $index base $base + current $currentItem  item $item = $is2020")
                        println(base * currentItem * Integer.parseInt(item))
                    }
                }
            }
            index++
        }
    }

}