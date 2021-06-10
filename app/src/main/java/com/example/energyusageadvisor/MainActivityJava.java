package com.example.energyusageadvisor;

// This code was made with the help of this video: https://youtu.be/V0AETAjxqLI
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.energyusageadvisor.databinding.ActivityMainBinding;

public class MainActivityJava extends AppCompatActivity {

    String name;
    int electricityNum;
    double costNum;

    EditText editTextTextPersonName2;
    EditText editTextTextPersonName3;
    EditText editTextTextPersonName4;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void showToast(String text){
        Toast.makeText(MainActivityJava.this, text, Toast.LENGTH_SHORT).show();
    }
}
