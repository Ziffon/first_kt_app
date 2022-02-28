package ru.otus.okb.first

abstract class VehicleDsl {
    var Mark: String = ""
    var Model: String = ""
    var Type: String = ""
    var HorsePower: Int = 0
    var Transporting: MutableList<Vehicles> = mutableListOf()


   infix fun add(veh:Vehicles){
        Transporting.add(veh)
    }
    fun add(vehd: VehicleDsl){
        add(vehd.build())

    }

    abstract fun build():Vehicles



}

class VehicleTypeDsl: VehicleDsl() {
    override fun build(): Vehicle = Vehicle(Mark, Model, Type, HorsePower, Transporting.toList())
    infix fun TypicVehicle(veh: Vehicles) = add(veh)
    infix fun TypicVehicle (block: TypicVehicleDsl.() -> Unit ) = add(TypicVehicleDsl().apply{block})




}

class TypicVehicleDsl: VehicleDsl() {
    override fun build(): TypicCars = TypicCars(Mark, Model, Type, HorsePower, Transporting.toList())
    infix fun TypicCar(veh: Vehicles) = add(veh)
    infix fun TypicCar (block: TypicVehicleDsl.() -> Unit) = add(TypicCarDsl().apply {block})

}

class TypicCarDsl: VehicleDsl() {
    override fun build(): Car = Car(Mark, Model, Type, HorsePower, Transporting.toList())

}

fun main (){

}