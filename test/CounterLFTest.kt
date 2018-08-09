import kotlinx.atomicfu.*
import org.junit.*

class CounterLFTest : LockFreedomTestEnvironment("CounterLFTest") {
    val a = Counter()

    @Test
    fun testLockFreedom() {
        repeat(2) { id ->
            testThread("Inc-$id") {
                a.inc()
            }
        }
        repeat(2) { id ->
            testThread("Get-$id") {
                a.get()
            }
        }
        performTest(3)
    }
}