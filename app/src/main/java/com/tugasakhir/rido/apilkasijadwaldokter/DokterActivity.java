package com.tugasakhir.rido.apilkasijadwaldokter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DokterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainerdokter);

        if (fragment == null) {
            fragment = new DokterFragment();
            fm.beginTransaction().add(R.id.fragmentContainerdokter, fragment).commit();
        }
    }
}
