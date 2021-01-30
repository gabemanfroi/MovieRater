package com.gabrielmanfroi.movierater.Movie;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabrielmanfroi.movierater.ItemClickListener;
import com.gabrielmanfroi.movierater.R;

public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView mImageView;
    TextView mTitle, mDes;

    ItemClickListener itemClickListener;


    public MovieHolder(@NonNull View itemView){
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.imageIV);
        this.mTitle = itemView.findViewById(R.id.titleTv);
        this.mDes = itemView.findViewById(R.id.descriptionTv);

        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        this.itemClickListener.onItemClickListener(v, getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }


}