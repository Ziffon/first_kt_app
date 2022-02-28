package ru.otus.okb.first


import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class NewDsl{
    @Test
    fun NewDsl() {
        val VehicleType = IVehicle {
            Mark = "Toyota"
            Model = ""
            Type = ""
            HorsePower = 1
            TypicVehicle{
                Mark = "Toyota"
                Type = "Car"
                Model = "Camry"
                HorsePower = 140

                TypicCar{
                    Mark = "Toyota"
                    Type = "Sport Car"
                    Model = "Supra"
                    HorsePower = 600
                }
                TypicCar{
                    Mark = "Toyota"
                    Type = "PremiumCar"
                    Model = "Crown"
                    HorsePower = 220
                }
            }
            TypicVehicle{
                Mark = "Toyota"
                Type = "Truck"
                Model = "Tundra"
                HorsePower = 360
            }
            TypicVehicle{
                Mark = "Toyota"
                Type = "Bus"
                Model = "Alphard"
                HorsePower = 150

                TypicCar{
                    Mark = "Toyota"
                    Type = "MiniBus"
                    Model = "Hiace"
                    HorsePower = 120
                }
            }

        }

        assertEquals("Toyota", VehicleType.Mark)

        //assertTrue("Toyota must contain Bus") {
        //VehicleType.Transporting.first{ it.Type == "Bus"} != null
        //}


    }


}

private fun IVehicle(function: VehicleTypeDsl.() -> Unit): Vehicle = VehicleTypeDsl().apply (function).build()