import java.math.BigInteger

object Grains {

    fun square(number: Int): BigInteger {
        require(number in 1..64) { "square must be between 1 and 64" }

        return BigInteger.valueOf(2).pow(number - 1)
    }

    fun total(): BigInteger {
        return BigInteger.valueOf(2).pow(64) - BigInteger.ONE
    }
}