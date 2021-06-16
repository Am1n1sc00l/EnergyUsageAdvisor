package com.example.energyusageadvisor

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


class MainActivity : AppCompatActivity() {

    var name: String? = null
    var electricityNum = 0.0
    var costNum = 0.0
    var calculation = 0.0

    var editTextTextPersonName2: EditText? = null
    var editTextTextPersonName3: EditText? = null
    var editTextTextPersonName4: EditText? = null

    var button: Button? = null

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

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
        }

        calculation = electricityNum * costNum // Fix this.

        val textView = findViewById<View>(R.id.calculationText) as TextView
        textView.text = "Monthly electricity cost of appliance(kilojoules): $$calculation"

    }

    private fun showToast(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
    }
}