package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var start = 0
        a.forEach { aLetter ->
            if (start < b.length) {
                val bLetter = b[start]
                if (aLetter.toUpperCase() == bLetter) {
                    start += 1
                } else if (aLetter == aLetter.toUpperCase()) {
                    return "NO"
                }
            } else if (aLetter == aLetter.toUpperCase()) {
                return "NO"
            }
        }
        if (start < b.length) {
            return "NO"
        }
        return "YES"
    }
}
