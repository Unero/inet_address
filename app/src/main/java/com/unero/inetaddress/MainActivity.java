package com.unero.inetaddress;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void inet(View view){
        TextView alamat = findViewById(R.id.textAddress);
        TextView IP = findViewById(R.id.textIP);
        TextView hasil = findViewById(R.id.textHasil);
        try {
            InetAddress inet1 = InetAddress.getByName("psmi.poltek-malang.ac.id");
            alamat.setText(inet1.getHostAddress());
            InetAddress inet2 = InetAddress.getByName("192.168.134.134");
            IP.setText(inet2.getHostName());
            if (inet1.equals(inet2))
                hasil.setText("Alamat Sama!");
            else
                hasil.setText("Alamat Tidak Sama!");
        } catch (UnknownHostException uhe){
            uhe.printStackTrace();
        }
    }
}