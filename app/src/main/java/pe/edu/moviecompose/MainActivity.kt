package pe.edu.moviecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import pe.edu.moviecompose.data.model.Movie
import pe.edu.moviecompose.data.model.MovieResponse
import pe.edu.moviecompose.data.remote.ApiClient
import pe.edu.moviecompose.ui.movies.MovieList
import pe.edu.moviecompose.ui.theme.MovieComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MovieComposeTheme {
                // A surface container using the 'background' color from the theme

                val movies = remember { mutableStateOf(listOf<Movie>()) }
                val movieInterface = ApiClient.getMovieInterface()
                val getMovies = movieInterface.getMovies()

                getMovies.enqueue(object: Callback<MovieResponse>{
                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        if (response.isSuccessful){
                            movies.value = response.body()!!.movies
                        }
                    }

                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.d("MainActivity", t.toString())
                    }
                })
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList(movies = movies.value)
                }
            }
        }
    }
}



