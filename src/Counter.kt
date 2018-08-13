import kotlinx.atomicfu.*
import kotlinx.coroutines.experimental.channels.*

class Counter {
    private val a = atomic(0)

    private val trace = Trace(64)

    fun inc(): Int {
        trace { "inc() invoked" }
        val x = a.incrementAndGet()
        trace { "inc() = $x" }
        return x
    }

    internal fun get() = a.value
}