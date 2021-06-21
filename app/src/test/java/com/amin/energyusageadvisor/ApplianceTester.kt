package com.amin.energyusageadvisor

//This program will be used to run the project.

/**
 * @author  Amin Khatatbeh, Askari Abbas, Jimmy Le
 * @version 1.0
 * @since   1.0
 */
object ApplianceTester {
    @JvmStatic
    fun main(args: Array<String>) {
        //"appliance1" is a test object for the program, it has been given placeholder values for variables that will be implemented later in the project.
        val appliance1 = Appliance("LG", 0, 0.0)
        appliance1.addElectricityUsed()
        println("")
        appliance1.findRate()
        println("")
        appliance1.findElectricityCost()
    }
}