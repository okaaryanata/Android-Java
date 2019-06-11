package com.example.cobatwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText inputUsername, inputPass, inputFullname, inputEmail;
    Button btnSignUp;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inputUsername = findViewById(R.id.signup_username);
        inputEmail = findViewById(R.id.signup_email);
        inputPass = findViewById(R.id.signup_password);
        inputPass.setTransformationMethod(new PasswordTransformationMethod());
        inputFullname = findViewById(R.id.signup_fullname);
        btnSignUp = findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(this);
        tvLogin = findViewById(R.id.link_login);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signup:
                Intent moveIntentToLog = new Intent(SignUp.this,Login.class);
                startActivity(moveIntentToLog);
                break;
            case R.id.link_login:
                Intent moveIntentToLogin = new Intent(SignUp.this, Login.class);
                startActivity(moveIntentToLogin);
                break;
        }
    }
}
