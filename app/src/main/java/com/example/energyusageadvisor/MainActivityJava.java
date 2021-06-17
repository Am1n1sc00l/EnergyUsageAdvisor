package com.example.energyusageadvisor;

// This code was made with the help of this video: https://youtu.be/V0AETAjxqLI
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityJava extends AppCompatActivity {

    String name;
    double electricityNum;
    double costNum;

    EditText editTextTextPersonName2;
    EditText editTextTextPersonName3;
    EditText editTextTextPersonName4;

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

    private void showToast(String text){
        Toast.makeText(MainActivityJava.this, text, Toast.LENGTH_SHORT).show();
    }




}
