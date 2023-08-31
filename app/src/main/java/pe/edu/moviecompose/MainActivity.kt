package pe.edu.moviecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.moviecompose.data.model.Movie
import pe.edu.moviecompose.ui.movies.MovieList
import pe.edu.moviecompose.ui.theme.MovieComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList(
                        listOf(
                            Movie(
                                1,
                                "Batman",
                                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRrmuWJLypZIsZC7yKIMPxxF45UYkJLv5Kg2i5AFcsWuGJnlMPR"
                            )
                        )
                    )
                }
            }
        }
    }
}



