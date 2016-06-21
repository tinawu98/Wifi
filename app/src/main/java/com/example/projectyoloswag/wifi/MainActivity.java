package com.example.projectyoloswag.wifi;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Updated", Snackbar.LENGTH_LONG).show();
                update();
            }
        });
        update();

    }

    public void update(){

                WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
                WifiInfo wifi = wifiManager.getConnectionInfo();
                String bssid = wifi.getBSSID();
                String mac = wifi.getMacAddress();
                int rssi = wifi.getRssi(); //signal strength in dBm
                Log.e("updated","up");
                int freq = wifi.getFrequency(); //frequency in MHz
                TextView bssidView = (TextView) findViewById(R.id.bssid);
                TextView rssiView = (TextView) findViewById(R.id.rssi);
                TextView freqView = (TextView) findViewById(R.id.frequency);
                TextView macView = (TextView) findViewById(R.id.mac);
                macView.setText(mac);
                bssidView.setText(bssid);
                rssiView.setText(rssi + " ");
                freqView.setText(freq + " ");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
