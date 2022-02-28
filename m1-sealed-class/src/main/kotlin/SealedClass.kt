package ru.otus.okb.first

/**
 * Домашнее задание №1
 *
 *1)Написать Sealed Class для одной из ниже указанных (либо другой по вашему выбору) сущностей.
 *2)Sealed Class должен включать не менее трех других классов.
 *3)Классы должны содержать по крайней мере один метод и не менее одного свойства.
 *4)Все классы должны быть покрыты автоматическими тестами
 */


sealed class Vehicles
    (val TransportName: String)
{
    class Car: Vehicles("Sport Car")
    {
        private val MaxSpeed:Int = 280
        fun Speed ()
        {
            println("Sport car can develop speed ${MaxSpeed} km/h")
        }
    }

    class Truck: Vehicles("Big dump truck")
    {
        private val TypeMotor :String = "diesel"
        fun Motor ()
        {
            println("Big dump truck have ${TypeMotor} engine")
        }
    }
}

class Bus: Vehicles("School bus")
{
    private val Capacity:Int = 30
    fun Mean()
    {
        println("School bus have ${Capacity} seats")
    }
}


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
}
fun main()
{
    val obj1 = Vehicles.Car()
    val obj2 = Vehicles.Truck()
    val obj3 = Bus()

    obj1.Speed()
    Display(obj1)

    obj2.Motor()
    Display(obj2)

    obj3.Mean()
    Display(obj3)
}