package com.tugasakhir.rido.apilkasijadwaldokter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Rumah_sakit = (Button) findViewById(R.id.btn_rumahsakit);
        btn_Rumah_sakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RumahSakit.class);
                startActivity(intent);
            }
        });

        Button btn_bantuan = (Button) findViewById(R.id.btn_bantuan);
        btn_bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bantuan.class);
                startActivity(intent);
            }
        });
    }
}
