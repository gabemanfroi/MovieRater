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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gabrielmanfroi.movierater.Movie.Movie;
import com.gabrielmanfroi.movierater.Movie.MovieAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRequest = (Button) findViewById(R.id.btnRequest);

        btnRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String key = "api_key=c8c657e0ef32df94781f02aa086b611f";

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api.themoviedb.org/3/trending/movie/day?"+key;

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    JSONArray results = response.getJSONArray("results");
                                    JSONObject firstMovie = results.getJSONObject(0);

                                    Toast.makeText(MainActivity.this, firstMovie.getString("title"), Toast.LENGTH_SHORT).show();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                                System.out.println("2");


                            }
                        });
                queue.add(jsonObjectRequest);

            }
        });

        //mRecyclerView = findViewById(R.id.recyclerView);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //movieAdapter = new MovieAdapter(this, getMyList());
        //mRecyclerView.setAdapter(movieAdapter);
    }

    private ArrayList<Movie> getMyList(){

        ArrayList<Movie> movies = new ArrayList<>();

        Movie movie = new Movie();
        for (int i =0; i< 10; i++){
            movie.setTitle("Movie"+i);
            movie.setGenre("Genre"+i);;
            movie.setImg(R.drawable.newspaper);
            movies.add(movie);
        }

        return movies;

    }
}

