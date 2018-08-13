import org.junit.Test
import kotlin.test.*

class CounterTest {
    @Test
    fun test() {
        val c = Counter()
        assertEquals(0, c.get())
        c.inc()
        assertEquals(1, c.get())
    }

    @Test
    fun testMore() {
        val n = 1000
        val c = Counter()
        repeat(n) {
            c.inc()
        }
        assertEquals(n, c.get())
    }
}
