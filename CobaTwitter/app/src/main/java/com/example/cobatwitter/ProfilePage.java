package com.example.cobatwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener {
    Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        btnSignOut = findViewById(R.id.btn_signout);
        btnSignOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signout:
                Intent moveToLogin = new Intent(ProfilePage.this, Login.class);
                startActivity(moveToLogin);
        }
    }
}
