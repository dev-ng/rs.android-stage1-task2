package subtask4

class Pangram {
    private val vowels = listOf<Char>( 'a', 'e', 'i', 'o', 'u', 'y' )
    private val consonants = ('a'..'z').filterNot { it in vowels }

    fun getResult(inputString: String): String {
        if (isPangram(inputString)) {
            return fromPangram(inputString, vowels)
        }
        return fromNonPangram(inputString, consonants)
    }

    private fun isPangram(s: String): Boolean {
        val lowercase = s.toLowerCase()
        return ('a'..'z').all { lowercase.contains(it) }
    }

    private fun fromPangram(inputString: String, vocab: List<Char>): String {
        var words: List<String> = inputString.split(" ")
        words = words.filterNot { "" == it }
        val pairs = mutableListOf<Pair<Int, String>>()
        words.forEach {word: String ->
            var newWord = ""
            var i = 0
            word.forEach { char: Char ->
                if (char.toLowerCase() in vocab) {
                    i += 1
                    newWord = newWord + char.toUpperCase()
                } else {
                    newWord = newWord + char
                }
            }
            pairs.add(pairs.filter { it.first <= i }.size, Pair(i, i.toString() + newWord))
        }
        val result = mutableListOf<String>()
        pairs.forEach {pair ->
            result.add(pair.second)
        }
        return result.joinToString(" ")
    }

    private fun fromNonPangram(inputString: String, vocab: List<Char>): String {
        return fromPangram(inputString.replace("\n", " ").replace("\r", " "),
            vocab)
    }
}
