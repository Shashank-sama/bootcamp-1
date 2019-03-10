package com.dsc.android.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        btnLogin.setOnClickListener(this);
    }

    private void initView() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                getInfo();
                login();
                break;
        }
    }


    private void getInfo() {
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString();
    }

    private void login(){
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "One or more fields is empty", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, RecyclerViewActivity.class);
            startActivity(i);
            finish();
        }


    }
}

