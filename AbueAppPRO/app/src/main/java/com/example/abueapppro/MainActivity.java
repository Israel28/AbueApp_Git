package com.example.abueapppro;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

//AbueApp
//
//Objeto: Aplicación movil
//Autores:
//José Israel Chávez Mendoza 		17590496
//Jesús Antonio Domínguez González 	17590090
//José Ángel Reséndiz Monroy 	    17590132
//Flores Vega Martin 		        15590685
//
//Fecha de creación: Agosto-2019
//
//Intituto Tecnologico de San Juan del Rio
//
//Historial de modificación
//
//Versión		Modificador	Fecha		    Cambio				                    Razón
//1.0	        17590496	29/10/21		Corrección de nombre de Variables	    El nombre de las variables resultaban confusas//		        17590090
//
//1.1		    17590496
//		        17590090	03/10/21		Actualización de paqueterias 		    Algunas paquetes no son compatibles con la versión del programa
//
//1.2		    17590496	Pendiente	    Cambio de rutas de almacenmiento	    Al subirse el proyecto a Github se subio con las rutas de almacenmiento
//              17590090                                                            que el proyecto tenía en ese equipo.
//
//1.3	        17590090	Pendiente       Colores y texto de layout               Los colores y texto utilizados no generan una buena apariencia
//              17590132
//1.4
public class MainActivity extends AppCompatActivity {
    private Button lla, men;
    private ImageButton em, emg;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    int RREQUEST_CODE =200;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lla = (Button) findViewById(R.id.llamada);
        men = (Button) findViewById(R.id.SMS);
        //em = (ImageButton) findViewById(R.id.emergenc);
        //emg = (ImageButton) findViewById(R.id.Emergencia);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        Verificar_Permisos();

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0]==1){
                    //llamaem();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener,sensor,0);
    }
    //-------------------------------------iNICIO DE CODIGO DE APLICACION--------------------------------------------------
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void Verificar_Permisos() {
        int permiso_phone = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        int permiso_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permiso_phone == PackageManager.PERMISSION_GRANTED && permiso_SMS == PackageManager.PERMISSION_GRANTED){
            //METODO A UTILIZAR
            //contacto_emergencia();
        }else{
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, RREQUEST_CODE);
        }
    }
    public void conf(View view) {

        Intent con = new Intent(this, configuraciones.class);
        startActivity(con);
    }

    public void cuadro(View view) {
        lla.setEnabled(true);
        lla.setVisibility(View.VISIBLE);
        men.setEnabled(true);
        men.setVisibility(View.VISIBLE);
    }
    public void mensajes(View view) {
        Intent con = new Intent(MainActivity.this, mensajes.class);
        startActivity(con);
    }
    public void contacto_emergencia(View view){
        Intent llamada_principal= new Intent(getIntent().ACTION_CALL, Uri.parse("tel:4274274445"));
        Toast.makeText(getApplicationContext(),"Iniciando llamada a "+llamada_principal,Toast.LENGTH_LONG).show();
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(llamada_principal);
    }

    public void llamada_911(View view){
        Intent llamada_Seguridad= new Intent(getIntent().ACTION_CALL, Uri.parse("tel:911"));
        Toast.makeText(getApplicationContext(),"Iniciando llamada a "+llamada_Seguridad,Toast.LENGTH_LONG).show();
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(llamada_Seguridad);
    }
    public void contacto_1(View view){
        Intent contacto_1 = new Intent(getIntent().ACTION_CALL, Uri.parse("tel:4411085762"));
        Toast.makeText(getApplicationContext(),"Iniciando llamada a "+contacto_1,Toast.LENGTH_LONG).show();
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(contacto_1);
    }
    public void contacto_2(View view){
        Intent contacto_2 = new Intent(getIntent().ACTION_CALL, Uri.parse("tel:5631718279"));
        Toast.makeText(getApplicationContext(),"Iniciando llamada a "+contacto_2,Toast.LENGTH_LONG).show();
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(contacto_2);
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    public void llama(View view) {

        
        /*String dial = "tel:" + "4274274294";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));*/

    }

    /*public void llamaem() {
        String dial = "tel:" + "4274274294";
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

    }*/
}