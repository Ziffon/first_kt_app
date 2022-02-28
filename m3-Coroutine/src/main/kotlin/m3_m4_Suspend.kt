package ru.otus.okb.first.coroutine.practice

import kotlinx.coroutines.flow.Flow

class SetWrapper(private val mutableAuto: MutableSet<Vehicle> = mutableSetOf()
){
    val Transport: Set<Vehicle>
        get() = mutableAuto.toSet()


    fun add(TypeVehicle: Vehicle) {
        mutableAuto.add(TypeVehicle)

    }

    fun addAll(sequence: Sequence<Vehicle>) {
        mutableAuto.addAll(sequence)

    }

    suspend fun addAll(flow: Flow<Vehicle>) {
        flow.collect{
            mutableAuto.add(it)
        }


    }

}