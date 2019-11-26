package oo_camp

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class ChanceTest {

    @Test
    internal fun `not should inverse the probability`() {
        assertEquals(0.75.chance(), 0.25.chance().not())
        assertEquals(0.5.chance(), 0.5.chance().not())
        assertEquals(1.0.chance(), 0.0.chance().not())
        assertEquals(0.0.chance(), 1.0.chance().not())
        assertEquals(0.0.chance(), !1.0.chance())
        assertEquals(0.0.chance(), !1.chance())
        assertEquals(1.0.chance(), !!1.chance())
    }

    @Test
    internal fun `constructor should fail on illegal probabilities`() {
        assertFailsWith<IllegalArgumentException> {
            (-0.00001).chance()
        }
        assertFailsWith<IllegalArgumentException> {
            1.00001.chance()
        }
    }

    @Test
    internal fun `and multiplies the chance-fractions`() {
        assertEquals(0.25.chance(), 0.5.chance() and 0.5.chance())
        assertEquals(0.0.chance(), 0.5.chance() and 0.chance())
        assertEquals(0.0.chance(), 0.0.chance() and 1.chance())
        assertEquals(1.chance(), 1.chance() and 1.chance())
    }

}