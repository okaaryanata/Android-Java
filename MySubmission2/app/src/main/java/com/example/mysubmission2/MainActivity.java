package com.example.mysubmission2;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> dataMoviePlaying;
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPlaying = findViewById(R.id.rv_movie);
        rvPlaying.setHasFixedSize(true);

        dataMoviePlaying = new ArrayList<>();
        dataMoviePlaying.addAll(MoviesData.getListMoivePlaying());
        showRecyclerCardView();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_playing:
                        break;
                    case R.id.nav_coming:
                        break;
                }
                return false;
            }
        });

    }

    private void showRecyclerCardView() {
        rvPlaying.setLayoutManager(new LinearLayoutManager(this));
        CardViewMovieAdapter cardViewMovieAdapter = new CardViewMovieAdapter(this);
        cardViewMovieAdapter.setListMoviePlaying(dataMoviePlaying);
        rvPlaying.setAdapter(cardViewMovieAdapter);


    }

}
