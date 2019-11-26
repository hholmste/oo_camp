package oo_camp

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import kotlin.test.assertFailsWith

internal class ChanceTest {

    @Test
    internal fun `not should inverse the probability`() {
        assertThat(Chance(0.25).not()).isEqualTo(Chance(0.75))
        assertThat(Chance(0.5).not()).isEqualTo(Chance(0.5))
        assertThat(Chance(0.0).not()).isEqualTo(Chance(1.0))
        assertThat(Chance(1.0).not()).isEqualTo(Chance(0.0))
        assertThat(!Chance(1.0)).isEqualTo(Chance(0.0))
        assertThat(!Chance(1)).isEqualTo(Chance(0.0))
        assertThat(!!Chance(1)).isEqualTo(Chance(1.0))
    }

    @Test
    internal fun `constructor should fail on illegal probabilities`() {
        assertFailsWith<IllegalArgumentException> {
            Chance(-0.00001)
        }
        assertFailsWith<IllegalArgumentException> {
            Chance(1.00001)
        }
    }

}