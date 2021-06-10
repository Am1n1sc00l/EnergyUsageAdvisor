package com.example.energyusageadvisor

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.util.*

//This program is used to obtain electricity data from users regarding their appliances.
//Their input will be saved in a text document named "applianceWatts.txt"
/**
 * @author  Amin Khatatbeh, Askari Abbas, Jimmy Le
 * @version 1.0
 * @since   1.0
 */
open class Electricity {
    /**
     * electricityUsage is an integer variable that represents the amount of electricity, in watts, that the specified
     * appliance uses.
     */
    open var electricityUsage = 0

    /**
     * input is a scanner that is used publically(throughout all classes within this project) to assist with
     * collecting user inputs and storing the value of these inputs within different variables.
     */
    var input = Scanner(System.`in`)

    /**
     * This method finds the amount of electricity, in watts, that a user's specified appliance uses.
     *
     *
     * Within this method, a file writer(out), buffered writer(writeFile), and a public scanner are used to obtain
     * the user's data in regards to the amount of watts their appliance uses. Their response is saved to a text
     * document named "applianceWatts.txt".
     */
    fun addElectricityUsed() {
        try {
            val out = FileWriter("applianceWatts.txt")
            val writeFile = BufferedWriter(out)
            println("Enter the amount of electricity, in watts, that the appliance uses below. Please enter positive whole numbers only. This value will be stored in a file.")
            electricityUsage = input.nextLine().toInt()
            writeFile.write(electricityUsage.toString())
            writeFile.newLine()
            writeFile.close()
            out.close()
            println("Data written to file.")
        } catch (e: IOException) {
            println("Problem writing to file.")
            System.err.println("IOException: " + e.message)
        }
    }
}