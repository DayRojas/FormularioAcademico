package com.example.formularioacadmico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    private TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        // Recuperar referencias de los elementos de la interfaz de usuario
        textViewDisplay = findViewById(R.id.textViewDisplay);

        // Recuperar los valores pasados como parámetros
        Intent intent = getIntent();
        String nombre= intent.getStringExtra("name");
        String gender = intent.getStringExtra("gender");
        boolean isEngineering = intent.getBooleanExtra("isEngineering", false);
        boolean isLaw = intent.getBooleanExtra("isLaw", false);
        boolean isMedicine = intent.getBooleanExtra("isMedicine", false);
        boolean isAdministration = intent.getBooleanExtra("isAdministration", false);
        String program = intent.getStringExtra("program");

        // Mostrar los valores en la pantalla
        String displayText = "Hola"+" "+nombre+ "\n"+"Género: " + gender + "\n" +
                "Facultades: " + getFacultades(isEngineering, isLaw, isMedicine, isAdministration) + "\n"+
                "Programa: " + program;
        textViewDisplay.setText(displayText);
    }

    private String getFacultades(boolean isEngineering, boolean isLaw, boolean isMedicine, boolean isAdministration) {
        StringBuilder facultades = new StringBuilder();
        if (isEngineering) {
            facultades.append("Ingeniería ");
        }
        if (isLaw) {
            facultades.append("Derecho ");
        }
        if (isMedicine) {
            facultades.append("Medicina ");
        }
        if (isAdministration) {
            facultades.append("Administración ");
        }

        return facultades.toString();
    }
}