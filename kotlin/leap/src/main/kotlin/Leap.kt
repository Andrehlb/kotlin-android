data class Year(private val year: Int) {

    // TODO: Implement proper constructor

    val isLeap: Boolean
        get() = when {
            year % 400 == 0 -> true
            year % 100 == 0 -> false
            year % 4 == 0 -> true
            else -> false
        }
}
