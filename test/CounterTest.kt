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
}