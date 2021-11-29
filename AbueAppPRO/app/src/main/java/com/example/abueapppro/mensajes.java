package com.example.abueapppro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mensajes extends AppCompatActivity {
    private EditText msj;
    Button enviar_sms;
    String nombre = "Israel";
    String numero = "4274274445";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);
        msj=(EditText) findViewById(R.id.mensaje);
        enviar_sms = findViewById(R.id.enviar);

        if(ActivityCompat.checkSelfPermission(mensajes.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(mensajes.this, new String[]{Manifest.permission.SEND_SMS},1);
        }


        enviar_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = msj.getText().toString();
                try {
                    SmsManager Sms = SmsManager.getDefault();
                    Sms.sendTextMessage(numero, null, mensaje, null, null);
                    Toast.makeText(getApplicationContext(), "Mensaje enviado", Toast.LENGTH_LONG).show();
                    //Sms.sendDataMessage(numero.toString(),null, msj.getText().toString(), null, null);
                }
                catch (Exception e ){
                    Toast.makeText(getApplicationContext(),"Mensaje no enviado",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }


            }
        });
    }



    public void regr(View view) {
        Intent con = new Intent(this, MainActivity.class);
        startActivity(con);
    }

    public void mensj(View view){
        /*String message = msj.getText().toString();
        String phoneNo = "4274274294";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, message, null, null);*/

        String mensaje = msj.getText().toString();
        Uri uri = Uri.parse("sms "+numero);
        Intent pantalla = new Intent(Intent.ACTION_SENDTO, uri);
        pantalla.putExtra("sms_cuerpo", mensaje);
        startActivity(pantalla);
    }

}