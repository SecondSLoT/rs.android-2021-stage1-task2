package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        val filteredArray = blockA.filter {
            blockB.isInstance(it)
        }

        return when (filteredArray[0]) {
            is Int -> (filteredArray as List<Int>).sum()
            is String -> filteredArray.joinToString("")
            is LocalDate -> getClosestDateString(filteredArray as List<LocalDate>)
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
