package com.example.taller_1_navegabilidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Datos extends AppCompatActivity {

    TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        tvDatos = findViewById(R.id.textViewDatos);

        Bundle recibirDatos = getIntent().getExtras();
        String info = recibirDatos.getString("KeyDatos");

        tvDatos.setText("Nombre: "+info
                        +"\n\nApellido:"
                        +"\n\n Email: ");
    }

    public void MainPage(View M){
        Intent ir = new Intent(this,MainPage.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);
    }
}