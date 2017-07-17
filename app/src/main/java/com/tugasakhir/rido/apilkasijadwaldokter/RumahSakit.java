package com.tugasakhir.rido.apilkasijadwaldokter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RumahSakit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah_sakit);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainerpendonor);

        if (fragment == null) {
            fragment = new RumahSakitFragment();
            fm.beginTransaction().add(R.id.fragmentContainerpendonor, fragment).commit();
        }

    }
}
