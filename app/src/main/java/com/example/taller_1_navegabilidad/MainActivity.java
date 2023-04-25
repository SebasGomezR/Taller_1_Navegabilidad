package com.example.taller_1_navegabilidad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSalir;
    EditText etEnviar;
    Button btnEnviar;

    CheckBox validacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validacion = (CheckBox) findViewById(R.id.terminos);

        etEnviar = findViewById(R.id.nombre);
        btnEnviar = findViewById(R.id.btnIniciar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle enviarDatos = new Bundle();
                enviarDatos.putString("KeyDatos", etEnviar.getText().toString());

                Intent intent = new Intent(MainActivity.this, Datos.class);
                intent.putExtras(enviarDatos);
                startActivity(intent);
            }
        });


        btnSalir = (Button) findViewById(R.id.BtnAlerta);
        btnSalir.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta  = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("¿Desea salir de la App?")
                        .setCancelable(true)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Salida");
                titulo.show();
            }
        });
    }

    public void onclick(View view){
        if(view.getId()==R.id.validar){
            validar();
        }
    }

    private void validar(){
        String cad = "";

        if(validacion.isChecked()==true){
            cad+="Terminos Aceptados";

        }else cad+="Debe aceptar los terminos y condiciones";

        Toast.makeText(getApplicationContext(),cad,Toast.LENGTH_SHORT).show();
    }
    
    public void Iniciar(View B){
        Intent ir = new Intent(this, Datos.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);
    }

}