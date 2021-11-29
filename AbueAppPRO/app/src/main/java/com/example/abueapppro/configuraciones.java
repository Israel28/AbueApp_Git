package com.example.abueapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class configuraciones extends AppCompatActivity {
    Button Exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuraciones);
    }
    public void regresar(View view) {

        Intent con = new Intent(this, MainActivity.class);
        startActivity(con);
    }

    public void contact(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.contacts");
        startActivity( launchIntent );
    }

    public void letra(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
        startActivity( launchIntent );
    }

    public void localiz(View view) {
        Intent con = new Intent(this, localizacion.class);
        startActivity(con);
    }
}