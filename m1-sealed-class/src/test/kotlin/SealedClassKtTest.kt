package ru.otus.okb.first

import org.junit.Test
import kotlin.test.assertEquals

class SealedClassKtTest {

    @Test

    fun Display(vehicle:Vehicles)
    {
        val HorsePower:Int = 310
        val MaxWeight:Int = 25
        val WhoCanSeat:String = "children"
        when(vehicle)
        {
            is Vehicles.Car -> println("${vehicle.TransportName} have ${HorsePower} horse power")
            is Vehicles.Truck -> println("${vehicle.TransportName} have capacity ${MaxWeight} tons")
            is Bus -> println("${vehicle.TransportName} can carry ${WhoCanSeat} from school")
        }
        assertEquals(expected = 310, HorsePower)

    }


}