// Bob: adolescente desleixado que se acha muito descolado
//
// Bob responde apenas de 5 formas:
// "Sure." - Se você fizer uma pergunta (termina com "?")
// "Whoa, chill out!" - Se você GRITAR com ele (TODAS MAIÚSCULAS)
// "Calm down, I know what I'm doing!" - Se você gritar uma pergunta
// "Fine. Be that way!" - Se for silêncio (vazio ou só espaços)
// "Whatever." - Para qualquer outra coisa

object Bob {
    fun response(input: String): String {
        val trimmed = input.trim()

        // Verifica se é silêncio
        if (trimmed.isEmpty()) {
            return "Fine. Be that way!"
        }

        val isQuestion = trimmed.endsWith('?')
        val isYelling = trimmed.any { it.isLetter() } && trimmed.all { !it.isLetter() || it.isUpperCase() }

        return when {
            isYelling && isQuestion -> "Calm down, I know what I'm doing!"
            isYelling -> "Whoa, chill out!"
            isQuestion -> "Sure."
            else -> "Whatever."
        }
    }
}