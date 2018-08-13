/*
 * Copyright 2016-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.coroutines.experimental.channels

import kotlinx.atomicfu.atomic

public class Trace(size: Int) {
    private val mask = size - 1
    private val a = arrayOfNulls<String>(size)
    private val index = atomic(0)

    init {
        check(size and mask == 0) { "size must be power of 2: $size"}
    }

    public fun append(text: String) {
        val i = index.getAndIncrement()
        val thread = Thread.currentThread().name
        a[i and mask] = "$i [$thread] $text"
    }

    public inline operator fun invoke(text: () -> String) {
        append(text())
    }
}
