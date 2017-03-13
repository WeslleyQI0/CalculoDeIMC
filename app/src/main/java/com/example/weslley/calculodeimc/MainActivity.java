package com.example.weslley.calculodeimc;

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


    private String imcTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciar o Botão Calcular
        Button btCalcular = (Button)findViewById(R.id.btCalcular);
        Button btAlert = (Button)findViewById(R.id.btAlert);
        //Adiciona o Onclick no Botão
        btCalcular.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                //Instanciar o EditText Peso e Altura
                EditText edPeso = (EditText)findViewById(R.id.edPeso);
                EditText edAltura = (EditText)findViewById(R.id.edAltura);

                //Cria Variaveis que Guarda os Valores dos EditText
                double peso = Double.parseDouble(edPeso.getText().toString());
                double altura = Double.parseDouble(edAltura.getText().toString());

                //Faz o calculo do IMC
                double imc = peso/(altura*altura);
                //Pasa para o valor para decimal
                DecimalFormat df = new DecimalFormat("0.##");
                //Converte para ima string
                String imcTotal = df.format(imc);
                //Seta o valor no Textview
                TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                tvResultado.setText(imcTotal);
                //Exibindo Valor em um Toast
                Toast.makeText(MainActivity.this, "Seu IMC é: "+imcTotal, Toast.LENGTH_SHORT).show();
            }
        });

        btAlert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Seu IMC é: "+imcTotal, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
