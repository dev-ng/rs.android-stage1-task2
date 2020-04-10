package subtask2

class TimeConverter {
    val numbers = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
        "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
        "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine")

    fun toTextFormat(hour: String, minute: String): String {
        var hr = hour.toInt()
        var mn = minute.toInt()
        if( hr < 0 || hr > 12 || mn < 0 || mn > 59) return ""
        var relation = ""
        when (mn) {
            0 -> return numbers[hr] + " o' clock"
            15 -> return "quarter past " + numbers[hr]
            30 -> return "half past " + numbers[hr]
            45 -> return "quarter to " + numbers[hr+1]
            else -> {
                if (mn < 30) {
                    relation = " past "
                }else if (mn < 60) {
                    relation = " to "
                    mn = 60 - mn
                    hr = hr % 12 + 1
                }
            }
        }
        if (1 == mn) {
            return numbers[mn] + " minute" + relation + numbers[hr]
        }
        return numbers[mn] + " minutes" + relation + numbers[hr]
    }
}
