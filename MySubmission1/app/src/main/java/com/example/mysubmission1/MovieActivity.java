package com.example.mysubmission1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    CircleImageView ciPhoto;
    TextView tvRating,tvLanguage,tvDuration,tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        tvDuration = findViewById(R.id.tv_duration);
        tvLanguage = findViewById(R.id.tv_language);
        tvRating = findViewById(R.id.tv_rating);
        ciPhoto = findViewById(R.id.ma_photo);
        tvDescription = findViewById(R.id.ma_description);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tvDuration.setText(movie.getDuration());
        tvRating.setText(movie.getRating());
        tvLanguage.setText(movie.getLanguage());
        tvDescription.setText(movie.getDescription());
        ciPhoto.setImageResource(movie.getPhoto());
        setTitle(movie.getTitle());


    }
}
