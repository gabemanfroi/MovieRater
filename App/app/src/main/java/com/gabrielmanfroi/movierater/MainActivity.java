package com.gabrielmanfroi.movierater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("News Feed");
        m.setDescription("This is newsfeed description...");
        m.setImg(R.drawable.newspaper);
        models.add(m);

        m = new Model();
        m.setTitle("News Feed");
        m.setDescription("This is newsfeed description...");
        m.setImg(R.drawable.newspaper);
        models.add(m);

        m = new Model();
        m.setTitle("News Feed");
        m.setDescription("This is newsfeed description...");
        m.setImg(R.drawable.newspaper);
        models.add(m);

        m = new Model();
        m.setTitle("News Feed");
        m.setDescription("This is newsfeed description...");
        m.setImg(R.drawable.newspaper);
        models.add(m);

        m = new Model();
        m.setTitle("News Feed");
        m.setDescription("This is newsfeed description...");
        m.setImg(R.drawable.newspaper);
        models.add(m);

        m = new Model();
        m.setTitle("News Feed");
        m.setDescription("This is newsfeed description...");
        m.setImg(R.drawable.newspaper);
        models.add(m);

        return models;

    }
}

