package com.example.cobatwitter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AddTweet extends AppCompatActivity implements View.OnClickListener {
    Button btnCreate;
    BottomNavigationView btnBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tweet);
        btnCreate = findViewById(R.id.btn_new_tweet);
        btnCreate.setOnClickListener(this);
        btnBottom = (BottomNavigationView) findViewById(R.id.navigationAddTweet);
        btnBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent moveToHome = new Intent(AddTweet.this, CardViewTweet.class);
                        startActivity(moveToHome);
                        break;
                    case R.id.nav_profile:
                        Intent moveToProfilePage = new Intent(AddTweet.this, ProfilePage.class);
                        startActivity(moveToProfilePage);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_new_tweet:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_refresh:
                Intent moveToCardView= new Intent(AddTweet.this, CardViewTweet.class);
                startActivity(moveToCardView);
                break;
            case R.id.icon_addTweet:
                Intent moveToAddTweet= new Intent(AddTweet.this, AddTweet.class);
                startActivity(moveToAddTweet);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_atas, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
