package com.example.energyusageadvisor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


/**
 * @author  Amin Khatatbeh, Askari Abbas, Jimmy Le
 * @version 1.0
 * @since   1.0
 */
open class Cost : Electricity() {
    /**
     * wattsToCost is a variable of the double type. It is used when the user inputs the amount of money they are charged monthly
     * per watt on their electricity bill.
     */
    private var wattsToCost = 0.0

    /**
     * wattsAmount is a double value that is read from a text file created within a different class within this project named
     * "applianceWatts.txt". This double value is then used to calculate the monthly electricity
     * cost.
     */
    private var wattsAmount = 0.0

    /**
     * calculation is a double value which is used to store the final calculated decimal number of the monthly electricity cost.
     */
    private var calculation = 0.0

    /**
     * electricityCost is a double that is equal to the final value of the calculation double. Its purpose is to be stored back into the main appliance
     * object that these calculations were made for.
     */
    open var electricityCost = 0.0

    /**
     * This method will take user input needed to find the rate that they are charged for electricity in watts per hour.
     */
    fun findRate() {
        println("At what rate, in dollars, are you charged per watt monthly on your electricity bill?")
        wattsToCost = input.nextLine().toDouble()
    }

    /**
     * This method will calculate the amount of money the user is being charged monthly on their electricity bill based on the values
     * that they have provided.
     */
    fun findElectricityCost() {
        try {
            val `in` = FileReader("applianceWatts.txt")
            val readFile = BufferedReader(`in`)
            wattsAmount = readFile.readLine().toDouble()
            calculation = wattsAmount * wattsToCost
            calculation = Math.round(calculation * 100.0) / 100.0
            //Method for rounding doubles found from: https://www.delftstack.com/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/
            println("Since you are charged at a rate of $wattsToCost dollars per watt each month and this appliance uses $wattsAmount watts of electricity, you will be charged $$calculation on your next bill.")
            return calculation;
            electricityCost = calculation
            readFile.close()
            `in`.close()
            input.close()
        } catch (e: IOException) {
            println("The file 'applianceWatts.txt' could not be read.")
            println("IOException: " + e.message)
        }
    }
}