package com.example.mysubmission2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewMovieAdapter extends RecyclerView.Adapter<CardViewMovieAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Movie> listMoviePlaying;

    public ArrayList<Movie> getListMoviePlaying(){
        return listMoviePlaying;
    }

    public void setListMoviePlaying(ArrayList<Movie> listMoviePlaying){
        this.listMoviePlaying = listMoviePlaying;
    }

    public CardViewMovieAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie,viewGroup,false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, final int i) {
        Movie m = getListMoviePlaying().get(i);
        Glide.with(context).load(m.getImage()).apply(new RequestOptions().override(70,100)).into(cardViewViewHolder.imgView);
        cardViewViewHolder.tvTitle.setText(m.getTitle());
        cardViewViewHolder.tvDescription.setText(m.getDescription());
        cardViewViewHolder.rlItemMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = getListMoviePlaying().get(i);
                Intent intent = new Intent(context,DetailMovie.class);
                intent.putExtra(DetailMovie.EXTRA_MOVIE,movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMoviePlaying().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView tvTitle, tvDescription;
        RelativeLayout rlItemMovie;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.img_photo);
            tvDescription = itemView.findViewById(R.id.txt_description);
            tvTitle = itemView.findViewById(R.id.txt_title);
            rlItemMovie = itemView.findViewById(R.id.item_movie);
        }
    }
}
