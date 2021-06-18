package com.example.energyusageadvisor

// This code was made with the help of this video: https://youtu.be/V0AETAjxqLI

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.energyusageadvisor.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * The main class of the program. It initializes the android, and runs all of the code required to
 * make the app function.
 *
 * @author Jimmy Le, Askari Abbas, Amin Khatatbeh
 * @since 1.0
 */
class MainActivity : AppCompatActivity() {

    /**
     * name is a String variable which is used to store the value of the specified appliance's brand name.
     * It is initially set to a null value, to be later redefined by the user through user input.
     */
    var name: String? = null

    /**
     * electricityNum is a double variable that is used to store the amount of kilojoules that the user's specified appliance uses.
     * It is initially set to 0.0 kJ, but is later redefined in the program through user input.
     */
    var electricityNum = 0.0

    /**
     * costNum is a double variable that is used to store the cost, in dollars per kilojoule, that the user's specified appliance
     * takes to run over the time span of a month. The value is initially set to 0.0 dollars/kJ, but is later redefined in the program
     * through user input.
     */
    var costNum = 0.0

    /**
     * calculation is a double variable that is used to store the final monthly electrical cost of the user's specified appliance.
     * It is initially set to a value of 0.0, but is then updated with a new value after calculations are done within the code regarding
     * various other inputs the user has made.
     */
    var calculation = 0.0

    /**
     * This variable has the exact same purpose and function as the electricityNum variable. Though this new one had to be created in order
     * to fix a bug that was making it so our calculations were not being completed properly.
     */
    var eNumVal = 0.0

    /**
     * This variable has the exact same purpose and function as the costNum variable. Though this new one had to be created in order
     * to fix a bug that was making it so our calculations were not being completed properly.
     */
    var costNumVal = 0.0

    /**
     * These three variables are used to initialize the three text boxes that users will input information relating to their appliance.
     */
    var editTextTextPersonName2: EditText? = null
    var editTextTextPersonName3: EditText? = null
    var editTextTextPersonName4: EditText? = null

    /**
     * This variable initialized the "Submit" button that users must press after inputting the relevant data in the previously mentioned text boxes.
     */
    var button: Button? = null

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        editTextTextPersonName2 = findViewById<View>(R.id.editTextTextPersonName2) as EditText
        editTextTextPersonName3 = findViewById<View>(R.id.editTextTextPersonName3) as EditText
        editTextTextPersonName4 = findViewById<View>(R.id.editTextTextPersonName4) as EditText

        button = findViewById<View>(R.id.button) as Button
        button!!.setOnClickListener {
            name = editTextTextPersonName2!!.text.toString()
            electricityNum = java.lang.Double.valueOf(editTextTextPersonName3!!.text.toString())
            costNum = java.lang.Double.valueOf(editTextTextPersonName4!!.text.toString())
            showToast(name!!)
            showToast(electricityNum.toString())
            showToast(costNum.toString())
            eNumVal = electricityNum
            costNumVal = costNum

            calculation = eNumVal * costNumVal

            val textView = findViewById<View>(R.id.calculationText) as TextView
            textView.text = "Monthly electricity cost of appliance(dollars): $$calculation"

        }

    }

    /**
     * This function creates a toast/visual pop-up of each String file inputted into it.
     *
     * @param text String variable containing user input data.
     * @return Toast/display based on the text variable.
     */
    private fun showToast(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
    }
}