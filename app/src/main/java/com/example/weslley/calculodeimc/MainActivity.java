package com.example.weslley.calculodeimc;

import android.annotation.TargetApi;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalcular = (Button)findViewById(R.id.btCalcular);
        Button btToast = (Button)findViewById(R.id.btToast);

        btCalcular.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularImc();
                String resultado = String.format("%.2f", calcularImc());
                TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                tvResultado.setText(resultado);
            }
        });
        btToast.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularImc();
                String resultado = String.format("%.2f", calcularImc());
                Toast.makeText(MainActivity.this, "Seu IMC é: "+resultado,Toast.LENGTH_SHORT).show();
            }
        });

    }


    @TargetApi(Build.VERSION_CODES.N)
    public double calcularImc() {

        EditText edPeso = (EditText)findViewById(R.id.edPeso);
        EditText edAltura = (EditText)findViewById(R.id.edAltura);

        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());

        double imc = peso/(altura*altura);

        return imc;
    }
}
