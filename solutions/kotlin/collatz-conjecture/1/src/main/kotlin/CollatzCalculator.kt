object CollatzCalculator {

    fun computeStepCount(n: Int): Int {
        // Verifica se o número é positivo
        require(n > 0) { "Only positive integers are allowed" }

        var current = n
        var steps = 0

        // Continua até chegar ao 1
        while (current != 1) {
            current = if (current % 2 == 0) {
                // Se for par, divide por 2
                current / 2
            } else {
                // Se for ímpar, multiplica por 3 e soma 1
                current * 3 + 1
            }
            steps++
        }

        return steps
    }
}