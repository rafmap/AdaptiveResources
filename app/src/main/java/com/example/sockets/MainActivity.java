package com.example.sockets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    TextView tvEnderPorta, tvStatus;
    final int PORTA_SERVER = 9090;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnv=(BottomNavigationView) findViewById(R.id.bnv);
        tvEnderPorta = (TextView) findViewById(R.id.tvEnderPorta);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
    }

    //Uso do método onConfigurationChanges
    @Override
    public void onConfigurationChanged(Configuration _novaConfig) {
        super.onConfigurationChanged(_novaConfig);
        Log.v("PDM", "Mudou a Configuração");
        if (_novaConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast t = Toast.makeText(this, "Deitado!", Toast.LENGTH_LONG);
            t.show();
        }
        if (_novaConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast t = Toast.makeText(this, "Em pé!", Toast.LENGTH_LONG);
            t.show();
        }
    }

    public void clicarBTServer(View v) {
        Toast t = Toast.makeText(this, R.string.al_mundo, Toast.LENGTH_LONG);
        t.show();
        PackageManager pm = getPackageManager();
        if (pm.hasSystemFeature(PackageManager.FEATURE_NFC)) {
            Log.v("PDMv", "Tem NFC");
        } else {
            Log.v("PDMv", "Não tem NFC");
        }

        if (pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE)) {
            Log.v("PDMv", "Tem Giroscópio");
        } else {
            Log.v("PDMv", "Não tem Giroscópio");
        }

        if (pm.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Log.v("PDMv", "Tem BLE");
        } else {
            Log.v("PDMv", "Não tem BLE");
        }

        if (pm.hasSystemFeature(PackageManager.FEATURE_WATCH)) {
            Log.v("PDMv", "É relógio");
        } else {
            Log.v("PDMv", "Não é relógio");
        }
    }
}