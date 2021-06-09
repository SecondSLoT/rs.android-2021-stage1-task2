package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        var i = 0
        var j = 0
        val matchedLetters = StringBuilder("")

        while (i < b.length && j < a.length) {
            if (b[i] == a[j].toUpperCase()) {
                matchedLetters.append(b[i])
                i++
                j++
            } else {
                j++
            }
        }

        return if (matchedLetters.toString() == b) "YES" else "NO"
    }
}
