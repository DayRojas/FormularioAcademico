package com.example.formularioacadmico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupGender;
    EditText editTextNombre;
    TextView textViewPrograma,textViewFacultad,textViewGenero,textViewNombre;
    private CheckBox checkBoxEngineering, checkBoxLaw, checkBoxMedicine, checkBoxAdministration;

    private Spinner spinnerProgram;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Recuperar referencias de los elementos de la interfaz de usuario

        textViewFacultad=findViewById(R.id.textViewFacultad);
        textViewGenero=findViewById(R.id.textViewGenero);
        textViewNombre=findViewById(R.id.textViewGenero);
        textViewPrograma=findViewById(R.id.textViewNombre);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        editTextNombre = findViewById(R.id.editTextNombre);
        checkBoxEngineering = findViewById(R.id.checkBoxEngineering);
        checkBoxLaw = findViewById(R.id.checkBoxLaw);
        checkBoxMedicine = findViewById(R.id.checkBoxMedicine);
        checkBoxAdministration = findViewById(R.id.checkBoxAdministration);
        spinnerProgram = findViewById(R.id.spinnerProgram);

        // Configurar opciones del Spinner de programa

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(

                this, R.array.programs_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerProgram.setAdapter(adapter);

        // Manejar el evento de clic en un botón para obtener los valores seleccionados

        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                String name = editTextNombre.getText().toString();
                String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
                boolean isEngineering = checkBoxEngineering.isChecked();
                boolean isLaw = checkBoxLaw.isChecked();
                boolean isMedicine = checkBoxMedicine.isChecked();
                boolean isAdministration = checkBoxAdministration.isChecked();
                String program = spinnerProgram.getSelectedItem().toString();

                // Crear un Intent para iniciar la nueva actividad
                Intent intent = new Intent(MainActivity.this, MostrarDatos.class);
                intent.putExtra("name",name);
                intent.putExtra("gender", gender);
                intent.putExtra("isEngineering", isEngineering);
                intent.putExtra("isLaw", isLaw);
                intent.putExtra("isMedicine", isMedicine);
                intent.putExtra("isAdministration", isAdministration);
                intent.putExtra("program", program);
                startActivity(intent);
            }
        });
    }
}