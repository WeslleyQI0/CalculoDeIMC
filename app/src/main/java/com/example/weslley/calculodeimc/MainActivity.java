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

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalcular = (Button)findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                EditText edPeso = (EditText)findViewById(R.id.edPeso);
                EditText edAltura = (EditText)findViewById(R.id.edAltura);


                double peso = Double.parseDouble(edPeso.getText().toString());
                double altura = Double.parseDouble(edAltura.getText().toString());

                double imc = peso/(altura*altura);
                DecimalFormat df = new DecimalFormat("0.##");
                String imcTotal = df.format(imc);

                TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                tvResultado.setText(imcTotal);
            }
        });
    }


}
