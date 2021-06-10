package com.example.energyusageadvisor

import org.junit.Test

import org.junit.Assert.*

//This program will define the Appliance object, as well as its related variables.
/**
 * @author  Amin Khatatbeh, Askari Abbas, Jimmy Le
 * @version 1.0
 * @since   1.0
 */
class Appliance internal constructor(
    /**
     * brandName is a string variable which stores the name of the brand of each specific appliance used in the program.
     */
    var brandName: String,
    /**
     * electricityUsage is an integer value, which is also present in the "Electricity" class. It is used to store the
     * wattage value of each specific appliance used in the program.
     */
    override var electricityUsage: Int, electricityCost: Double
) :
    Cost() {
    /**
     * electricityCost is a double value which is used to store the value of the total cost that a specific appliance
     * incurs onto the user on their monthly electricity bill.
     */
    override var electricityCost: Double = 0.0

    /**
     * This object is used to identify and hold the data of the various appliances that users will input into the program.
     *
     *
     * This object will hold all of the important and significant data required to the appliances that users enter.
     * This includes the appliance's brand, the amount of electricity it uses in watts, and the cost of using it over
     * the timeframe of a month.
     *
     * @param brandName The name of the appliance's brand.
     * @param electricityUsage The amount of electricity, in watts, that the appliance uses.
     * @param electricityCost The total monthly electricity cost, rounded to two decimal places, of the appliance.
     */
    init {
        electricityUsage = electricityUsage
        this.electricityCost = electricityCost
    }
}