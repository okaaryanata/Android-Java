package com.example.mysubmission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataRating;
    private String[] dataLanguage;
    private String[] dataDuration;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        listview = findViewById(R.id.lv_list);
        listview.setAdapter(adapter);

        prepare();
        addItem();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,dataTitle[position], Toast.LENGTH_SHORT).show();
                Movie movie = new Movie();
                movie.setPhoto(dataPhoto.getResourceId(position,-1));
                movie.setDescription(dataDescription[position]);
                movie.setTitle(dataTitle[position]);
                movie.setLanguage(dataLanguage[position]);
                movie.setDuration(dataDuration[position]);
                movie.setRating(dataRating[position]);

                Intent moveMovie = new Intent(MainActivity.this, MovieActivity.class);
                moveMovie.putExtra(MovieActivity.EXTRA_MOVIE,movie);
                startActivity(moveMovie);

            }
        });

    }

    private void prepare(){
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataDuration = getResources().getStringArray(R.array.data_duration);
        dataLanguage = getResources().getStringArray(R.array.data_language);
    }

    private void addItem(){
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++){
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setPhoto(dataPhoto.getResourceId(i,-1));
            movie.setRating(dataRating[i]);
            movie.setDuration(dataDuration[i]);
            movie.setLanguage(dataLanguage[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}
