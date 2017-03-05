package com.example.weslley.calculodeimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CalcularIMC(View view) {
        EditText edPeso = (EditText)findViewById(R.id.edPeso);
        EditText edAltura = (EditText)findViewById(R.id.edAltura);
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        Button btCalcular = (Button)findViewById(R.id.btCalcular);

        int peso = Integer.parseInt(edPeso.getText().toString());
        float altura = Float.parseFloat(edAltura.getText().toString());

        float resultado = peso/(altura*altura);

        tvResultado.setText((int) resultado);
    }


}
