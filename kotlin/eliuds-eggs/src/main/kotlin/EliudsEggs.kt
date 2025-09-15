object EliudsEggs {

    fun eggCount(number: Int): Int {
        var count = 0
        var num = number

        while (num > 0) {
            if (num % 2 == 1) {
                count++
            }
            num /= 2
        }

        return count
    }
}