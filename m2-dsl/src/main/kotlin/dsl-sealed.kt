package ru.otus.okb.first


sealed interface IVehicles
sealed class Vehicles(
    val Mark: String,
    val Model: String,
    val Type: String,
    val HorsePower: Int,
    val Transporting: List<Vehicles> = emptyList()
)
class Vehicle (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class Car (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class SportCar (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class Truck (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class Bus (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class MiniBus (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class TypicCars (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)
class TypicVehiclles (Mark: String, Model: String, Type: String, HorsePower: Int, Transporting: List<Vehicles> = emptyList()):Vehicles(Mark, Model, Type, HorsePower, Transporting)