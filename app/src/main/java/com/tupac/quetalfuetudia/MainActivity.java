package com.tupac.quetalfuetudia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    // Instancias de botones
    private Button btn_enviar;
    private RadioGroup rg_respuestas;
    // Listener para el botón Enviar
    private View.OnClickListener enviarListener = new View.OnClickListener() {

        @Override
        public void onClick (View v) {
            // Recupero el valor del radiogroup
            int radioButtonID = rg_respuestas.getCheckedRadioButtonId();
            View radioButton = rg_respuestas.findViewById(radioButtonID);
            // Indice del radiobtn seleccionado
            int idx = rg_respuestas.indexOfChild(radioButton);

            // Abro la otra Activity
            Intent intent = new Intent(MainActivity.this, MensajeActivity.class);
            //Bundle b = new Bundle();
            //b.putInt("opcion", idx);
            intent.putExtra("opcion" , idx); // Paso el parámetro
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asocio las instancias a la interfaz
        btn_enviar = (Button)findViewById(R.id.btn_enviar);
        rg_respuestas = (RadioGroup)findViewById(R.id.rg_respuestas);
        // Registro un listener para el botón
        btn_enviar.setOnClickListener(enviarListener);


    }
}