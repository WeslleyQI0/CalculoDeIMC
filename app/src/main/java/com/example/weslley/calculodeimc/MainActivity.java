package com.example.weslley.calculodeimc;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
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

        Button btCalcular = (Button) findViewById(R.id.btCalcular);
        Button btToast = (Button) findViewById(R.id.btToast);
        Button btAlert = (Button) findViewById(R.id.btAlert);
        Button btNotificacao = (Button) findViewById(R.id.btNotificacao);

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
                Toast.makeText(MainActivity.this, "Seu IMC é: " + resultado, Toast.LENGTH_SHORT).show();
            }
        });

        btAlert.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                calcularImc();
                String resultado = String.format("%.2f", calcularImc());

                AlertDialog.Builder builderAlerta;
                builderAlerta = new AlertDialog.Builder(MainActivity.this);
                builderAlerta.setTitle("Seu IMC é");
                builderAlerta.setMessage(resultado);

                builderAlerta.setPositiveButton("Aceitar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this, "Aceitar=" + arg1, Toast.LENGTH_SHORT).show();
                    }
                });
                //define um botão como negativo.
                builderAlerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this, "Cancelar=" + arg1, Toast.LENGTH_SHORT).show();
                    }
                });
                builderAlerta.create();
                builderAlerta.show();

            }
        });
        btNotificacao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Texto que aparecerá na barra de status (chamada para a notificação)
                String tickerText = "Você recebeu uma mensagem.";

                // Detalhes da notificação
                CharSequence titulo = "André";
                CharSequence mensagem = "Exemplo de notificação";

                // Exibe a notificação
                criarNotificacao(MainActivity.this, tickerText, titulo, mensagem, ResultActivity.class);
            }
        });


    }
    protected void criarNotificacao(Context context, CharSequence mensagemBarraStatus,
                                    CharSequence titulo, CharSequence mensagem, Class activity) {
        // Recupera o serviço do NotificationManager
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification n = new Notification(R.drawable.notification, mensagemBarraStatus, System.currentTimeMillis());

        // PendingIntent para executar a Activity se o usuário selecionar a notificação
        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, activity), 0);

        // Flag utilizada para remover a notificação da barra de status
        // quando o usuário clicar nela
        n.flags |= Notification.FLAG_AUTO_CANCEL;

        // Informações
        n.setLatestEventInfo(this, titulo, mensagem, p);

        // Espera 100ms e vibra por 250ms, espera por mais 100ms e vibra por 500ms
        n.vibrate = new long[] { 100, 250, 100, 500 };

        // id da notificacao
        nm.notify(R.string.app_name, n);
    }


    @TargetApi(Build.VERSION_CODES.N)
    public double calcularImc() {

        EditText edPeso = (EditText) findViewById(R.id.edPeso);
        EditText edAltura = (EditText) findViewById(R.id.edAltura);

        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());

        double imc = peso / (altura * altura);

        return imc;
    }
}
