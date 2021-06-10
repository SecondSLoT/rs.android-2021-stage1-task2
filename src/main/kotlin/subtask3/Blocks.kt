package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        return when (blockB) {
            Int::class -> blockA.filterIsInstance<Int>().sum()
            String::class -> blockA.filterIsInstance<String>().joinToString("")
            LocalDate::class -> getClosestDateString(blockA.filterIsInstance<LocalDate>())
            else -> "Incompatible class type"
        }
    }

    private fun getClosestDateString(dateList: List<LocalDate>): String {
        var resultDate: LocalDate = LocalDate.MIN

        dateList.forEach { date ->
            if (date > resultDate) {
                resultDate = date
            }
        }

        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        return resultDate.format(formatter)
    }
}
