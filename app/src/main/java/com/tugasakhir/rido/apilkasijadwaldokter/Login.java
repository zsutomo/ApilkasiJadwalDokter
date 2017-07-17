package com.tugasakhir.rido.apilkasijadwaldokter;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lupapasswordOnclik();

        klikBtnMasuk();

    }

    private void klikBtnMasuk() {
        Button btn_masuk = (Button) findViewById(R.id.btn_login);
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void lupapasswordOnclik() {

        TextView lupapasword = (TextView) findViewById(R.id.lupapasword);
        lupapasword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Login.this);
                View mView = getLayoutInflater().inflate(R.layout.lupapassword, null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.email_lengkap_anda);
                Button mButton = (Button) mView.findViewById(R.id.btnsubmit);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(mEmail.getText());

                        if (mEmail.getText().toString().isEmpty()) {
                            Toast.makeText(Login.this, "Email Harus Diisi", Toast.LENGTH_SHORT).show();

                        }else if(!mEmail.getText().toString().isEmpty()){

//                            mAuth.sendPasswordResetEmail(mEmail.getText().toString());
//                            Toast.makeText(Login.this, "Password telah dikirimkan ke email anda silahkan check", Toast.LENGTH_SHORT).show();
//                            dialog.hide();
                        }
                    }
                });
                dialog.show();
                dialog.setCanceledOnTouchOutside(false);

            }
        });

    }
}
