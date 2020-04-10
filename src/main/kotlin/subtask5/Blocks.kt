package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        when (blockB) {
            String::class -> return processString(blockA)
            Int::class -> return processInt(blockA)
            LocalDate::class -> return processDate(blockA)
        }
        return ""
    }

    private fun processString(blockA: Array<Any>): String {
        return blockA.filterIsInstance<String>().joinToString("")
    }

    private fun processInt(blockA: Array<Any>): Int {
        return blockA.filterIsInstance<Int>().sum()
    }

    private fun processDate(blockA: Array<Any>): String {
        return blockA.filterIsInstance<LocalDate>().max()!!.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }
}
