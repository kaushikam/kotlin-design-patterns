package com.kaushikam.design.patterns.delegation

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.test.assertEquals


interface Producer {
    fun produce(): String
}

class ProducerImpl: Producer {
    override fun produce() = "ProducerImpl"
}

class EnhancedProducer(private val delegate: Producer): Producer by delegate {
    override fun produce() = "${delegate.produce()} and EnhancedProducer"
}

class SynchronizedProducer(private val delegate: Producer): Producer by delegate {
    private val lock = ReentrantLock()

    override fun produce(): String {
        lock.withLock {
            return delegate.produce()
        }
    }
}

fun main() {
    val producer = EnhancedProducer(ProducerImpl())
    assertEquals("ProducerImpl and EnhancedProducer", producer.produce())
}