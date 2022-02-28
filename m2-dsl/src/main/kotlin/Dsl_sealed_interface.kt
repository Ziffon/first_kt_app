package ru.otus.okb.first


interface IVehicles{
    val nameMark : String
    val nameModel: String
    val HorsePwr: Int
    val TypeModel: String
}
open class Vehicles(
    val Mark: String,
    val Model: String,
    val Type: String,
    val HorsePower: Int,
    val Transporting: List<Vehicles> = emptyList()
)
class Vehicle (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class Car (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class TypicCars (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)


data class Facture(
    override val nameMark: String,
    override val nameModel: String,
    override val HorsePwr: Int,
    override val TypeModel: String
    ) :IVehicles
data class Filial(
    override val nameMark: String,
    override val nameModel: String,
    override val HorsePwr: Int,
    override val TypeModel: String
    ):IVehicles

class factory< T> {
    private val Transport = mutableListOf<T>()
    infix fun addName(pet: T) = Transport.add(pet)
    fun getAll(): List<T> = Transport.toList()

    inline fun <reified D: IVehicles> getOnlyOneTyped(): List<D> {
        return getAll().filter { it is D }.map { it as  D }
    }
}


fun main(){
    val works = factory<IVehicles>()
    val Toyota = Facture("Toyota", "Highlander", 250, "Crossover")
    val Lexus = Filial("Lexus","RX-300",230,"Crossover")
    val Honda = Facture("Honda", "CR-V",230,"Crossover")
    val Mazda = Facture("Mazda","CX-9",220,"Crossover")
    val Nissan = Facture("Nissan","X-trail",120,"Crossover")
    val Infiniti = Filial("Infiniti","QX-55",170,"Crossover")
    works addName Nissan
    works addName Infiniti
    works addName Lexus
    works addName Honda
    works addName Toyota
    works addName Mazda

    val work: List<Filial> = works.getOnlyOneTyped()
    println(work)
    println(works.getAll())
}