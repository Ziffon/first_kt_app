package ru.otus.okb.first.coroutine.practice

sealed class Vehicle(val Mark: String, val Model: String, val HorsePower: Int)
open class Car(Mark: String, Model: String, HorsePower: Int):Vehicle(Mark, Model, HorsePower)
open class Truck(Mark: String, Model: String, HorsePower: Int):Vehicle(Mark, Model, HorsePower)
open class Bus(Mark: String, Model: String, HorsePower: Int):Vehicle(Mark, Model, HorsePower)