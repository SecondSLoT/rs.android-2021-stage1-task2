package subtask1

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val calendar = GregorianCalendar(year.toInt(), month.toInt() - 1, day.toInt())
        val df: DateFormat = SimpleDateFormat("dd MMMM, EEEE", Locale("ru"))
        calendar.isLenient = false

        return try {
            df.format(calendar.time)
        } catch (e: IllegalArgumentException) {
            "Такого дня не существует"
        }
    }
}
