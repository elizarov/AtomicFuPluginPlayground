import kotlinx.atomicfu.*

class Counter {
    private val a = atomic(0)

    fun inc() = a.incrementAndGet()
    internal fun get() = a.value
}