package com.example.mysubmission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        }
        Movie movie = (Movie) getItem(position);
        TextView txtTitle = convertView.findViewById(R.id.txt_title);
        TextView txtDescription = convertView.findViewById(R.id.txt_description);
        ImageView imgPhoto = convertView.findViewById(R.id.img_photo);
        txtTitle.setText(movie.getTitle());
        txtDescription.setText(movie.getDescription());
        imgPhoto.setImageResource(movie.getPhoto());
        return convertView;
    }
}
