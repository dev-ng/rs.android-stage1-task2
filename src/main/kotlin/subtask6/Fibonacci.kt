package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val seq = generateSequence(Pair(0, 1)) {
            if (it.first * it.second >= n)
                null
            else
                Pair(it.second, it.first + it.second)
        }
        val (min, max) = seq.last()
        return intArrayOf(min, max, if (n == min * max) 1 else 0)
    }
}
