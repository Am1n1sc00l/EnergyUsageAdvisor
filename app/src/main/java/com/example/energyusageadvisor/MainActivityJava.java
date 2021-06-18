package com.example.energyusageadvisor;

// This code was made with the help of this video: https://youtu.be/V0AETAjxqLI
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The main class of the program. It initializes the android, and runs all of the code required to
 * make the app function.
 *
 * @author Jimmy Le, Askari Abbas, Amin Khatatbeh
 * @since 1.0
 */
public class MainActivityJava extends AppCompatActivity {

    /**
     * name is a String variable which is used to store the value of the specified appliance's brand name.
     * It is initially set to a null value, to be later redefined by the user through user input.
     */
    String name;

    /**
     * electricityNum is a double variable that is used to store the amount of kilojoules that the user's specified appliance uses.
     * It is initially set to 0.0 kJ, but is later redefined in the program through user input.
     */
    double electricityNum;

    /**
     * costNum is a double variable that is used to store the cost, in dollars per kilojoule, that the user's specified appliance
     * takes to run over the time span of a month. The value is initially set to 0.0 dollars/kJ, but is later redefined in the program
     * through user input.
     */
    double costNum;

    /**
     * These three variables are used to initialize the three text boxes that users will input information relating to their appliance.
     */
    EditText editTextTextPersonName2;
    EditText editTextTextPersonName3;
    EditText editTextTextPersonName4;

    /**
     * This variable initialized the "Submit" button that users must press after inputting the relevant data in the previously mentioned text boxes.
     */
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = (EditText) findViewById(R.id.editTextTextPersonName4);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextTextPersonName2.getText().toString();
                electricityNum = Double.valueOf(editTextTextPersonName3.getText().toString());
                costNum = Double.valueOf(editTextTextPersonName4.getText().toString());


                showToast(name);
                showToast(String.valueOf(electricityNum));
                showToast(String.valueOf(costNum));
            }
        });
        TextView textView = (TextView) findViewById(R.id.calculationText);
        textView.setText("Monthly electricity cost of appliance: ");
    }

    /**
     * This function creates a toast/visual pop-up of each String file inputted into it.
     *
     * @param text String variable containing user input data.
     * @return Toast/display based on the text variable.
     */
    private void showToast(String text){
        Toast.makeText(MainActivityJava.this, text, Toast.LENGTH_SHORT).show();
    }




}
