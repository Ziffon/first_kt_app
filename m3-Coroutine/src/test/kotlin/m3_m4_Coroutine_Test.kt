package ru.otus.okb.first.coroutine.practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import org.junit.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds


class CoroutineTest {
    @Test
    fun CoroutineTest (){
        val setWrapper = SetWrapper()
        val ToyotaCar = Car("Toyota", "Camry", 150)
        setWrapper.add(ToyotaCar)
        assertEquals("Toyota", setWrapper.Transport.first().Mark)
        assertEquals(150, setWrapper.Transport.last().HorsePower)

    }
    @Test
    fun ICoroutineTest (){
        val setWrapper = SetWrapper()
        val MitsubishiTruck = Truck("Mitsubishi", "L200", 140)
        setWrapper.add(MitsubishiTruck)
        assertEquals("Mitsubishi", setWrapper.Transport.first().Mark)
        assertEquals(140, setWrapper.Transport.last().HorsePower)

    }
    @Test
    fun IICoroutineTest (){
        val setWrapper = SetWrapper()
        val HondaBus = Bus("Honda", "Freed Spike", 118)
        setWrapper.add(HondaBus)
        assertEquals("Honda", setWrapper.Transport.first().Mark)
        assertEquals(118, setWrapper.Transport.last().HorsePower)

    }
    @Test
    fun SequenceTest(){
        val setWrapper = SetWrapper()
        val sequence = (1..25000)
            .asSequence()
            .filter { it %3 == 0 }
            .map { Car("Toyota - $it","Camry", 150) }
            .filter { it.Mark.contains("2") }
            .drop(30)
            .take(5)
        setWrapper.addAll(sequence)
        assertEquals(5, setWrapper.Transport.size)
    }

    @Test
    fun FlowDelayTest() = runTest{
        val setWrapper = SetWrapper()
        val flow = (1..25000)
            .asFlow()
            .filter { it %3 == 0 }
            .map {
                async {
                    delay(3_000)
                    Car("Toyota - $it","Camry", 150)
                }
            }

            .drop(30)
            .take(5)
            .map { it.await() }
        setWrapper.addAll(flow)
        assertEquals(5, setWrapper.Transport.size)
    }
    @Test
    fun FlowSleepTest() = runTest{
        val setWrapper = SetWrapper()
        val flow = (1..25000)
            .asFlow()
            .filter { it %3 == 0 }
            .map {
                println("map: ${Thread.currentThread().name}")
                async(Dispatchers.IO) {
                    println("async: ${Thread.currentThread().name}")
                    Thread.sleep(3000)
                    Car("Toyota - $it", "Camry", 150)
                }
            }

            .drop(30)
            .take(5)
            .map { it.await()}
            .buffer(5)
        setWrapper.addAll(flow)
        assertEquals(5, setWrapper.Transport.size)
    }




}
