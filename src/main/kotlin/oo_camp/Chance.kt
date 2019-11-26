package oo_camp

import kotlin.math.absoluteValue

/**
 * Understands the probability of something occurring.
 */
class Chance(fraction: Number) {
    private val fraction = fraction.toDouble()

    init {
        require(this.fraction in 0.0..1.0)
    }

    operator fun not() = Chance(1.0 - fraction)

    infix fun and(other: Chance) = Chance(this.fraction * other.fraction)

    override fun equals(other: Any?) = other is Chance && ((this.fraction - other.fraction).absoluteValue < marginOfError)

    override fun hashCode() = fraction.hashCode()

    override fun toString() = "Chance(p=$fraction)"

    companion object {
        const val marginOfError = 0.000000000001;
    }
}

internal val Number.chance get () = Chance(this)
