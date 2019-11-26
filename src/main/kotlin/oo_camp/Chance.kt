package oo_camp

import kotlin.math.abs
import kotlin.math.absoluteValue

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
            is Chance -> (this.fraction - other.fraction).absoluteValue < marginOfError
            else -> false
        }

    override fun hashCode() = fraction.hashCode()

    override fun toString() = "Chance(p=$fraction)"

    companion object {
        const val marginOfError = 0.000000000001;
    }
}

internal fun Number.chance() = Chance(this)
