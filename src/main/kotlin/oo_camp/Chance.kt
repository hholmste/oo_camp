package oo_camp

import kotlin.math.abs

/**
 * Understands the probability of something occurring.
 */
class Chance(fraction: Number) {
    private val fraction = fraction.toDouble()

    init {
        require(this.fraction in 0.0..1.0)
    }

    operator fun not(): Chance = Chance(1.0 - fraction)

    infix fun and(that: Chance) = Chance(this.fraction * that.fraction)

    override fun equals(other: Any?) =
        when (other) {
            null -> false
            is Chance -> abs(this.fraction - other.fraction) < marginOfError
            else -> false
        }

    override fun hashCode() = fraction.hashCode()

    override fun toString() = "Chance(p=$fraction)"

    companion object {
        const val marginOfError = 0.00001;
    }
}

internal fun Number.chance() = Chance(this)
