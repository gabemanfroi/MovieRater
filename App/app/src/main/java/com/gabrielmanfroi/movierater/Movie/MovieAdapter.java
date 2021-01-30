package com.gabrielmanfroi.movierater.Movie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabrielmanfroi.movierater.AnotherActivity;
import com.gabrielmanfroi.movierater.ItemClickListener;
import com.gabrielmanfroi.movierater.Model;
import com.gabrielmanfroi.movierater.MyHolder;
import com.gabrielmanfroi.movierater.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder>{

    Context context;

    ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {

        movieHolder.mTitle.setText(movies.get(i).getTitle());
        movieHolder.mDes.setText(movies.get(i).getGenre());
        movieHolder.mImageView.setImageResource(movies.get(i).getImg());

        movieHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String gTitle = movies.get(position).getTitle();
                String gGenre = movies.get(position).getGenre();
                BitmapDrawable bitmapDrawable = (BitmapDrawable)movieHolder.mImageView.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(context, AnotherActivity.class );
                intent.putExtra("iTitulo", gTitle);
                intent.putExtra("iGenero", gGenre);
                intent.putExtra("iImagem", bytes);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();

    }


}
