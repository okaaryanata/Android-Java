package com.example.cobatwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button btnLogin;
    TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        password.setTransformationMethod(new PasswordTransformationMethod());
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        tvSignUp = findViewById(R.id.link_signup);
        tvSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent moveIntentToCardView = new Intent(Login.this,CardViewTweet.class);
                startActivity(moveIntentToCardView);
                break;
            case R.id.link_signup:
                Intent moveIntentToSignUp = new Intent(Login.this,SignUp.class);
                startActivity(moveIntentToSignUp);
                break;
        }
    }
}
