package com.example.movieapp_akhilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp_akhilla.adapter.MovieAdapter
import com.example.movieapp_akhilla.model.Movie
import com.example.movieapp_akhilla.model.MovieResponse
import com.example.movieapp_akhilla.service.MovieApiInterface
import com.example.movieapp_akhilla.service.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvMovies: RecyclerView =findViewById(R.id.rvmovie)

        rvMovies.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)
        rvMovies.setHasFixedSize(true)
        getMovieData {
            rvMovies.adapter = MovieAdapter(it)
        }
    }

    private fun getMovieData(callback: (List<Movie>)->Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieListNowPlaying().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movie)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Respone Error",
                    Toast.LENGTH_SHORT).show()
            }

        })
    }
}