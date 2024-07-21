package com.example.mytvappcompose.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.mytvappcompose.model.MovieResult
import com.example.mytvappcompose.MovieViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    val viewModel: MovieViewModel = hiltViewModel()

    val movies by viewModel.movies.observeAsState(emptyList())


    val topRatedMovies = movies.getOrNull(1)?.take(5) ?: emptyList()
    val otherCategories = movies.filterIndexed { index, _ -> index != 1 }

      val pagerState = rememberPagerState {
          topRatedMovies.size
      }

    LaunchedEffect(Unit) {
        // Example: Scroll to the first page
        pagerState.scrollToPage(0)
    }

    Column {

        HorizontalPager(state = pagerState) { page ->
            TopRatedMoviePage(movie = topRatedMovies[page])

        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(10),
            modifier = Modifier.fillMaxSize()
        ) {
            otherCategories.forEachIndexed { index, category ->
                item {
                    MovieCategorySection(category, index)
                }
            }
        }
    }
}

@Composable
fun TopRatedMoviePage(movie : MovieResult) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.primary)

    )
    {
        Image(
            painter = rememberImagePainter(data = movie.poster_path),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun MovieCategorySection(categoryMovies:List<MovieResult>, index: Int){
        val categoryTitle = when (index) {
            0 -> "Popular Movies"
            1 -> "Trending Movies"
            2 -> "Now Playing Movies"
            3 -> "Upcoming Movies"
            else -> "Category"
        }
        Column {
            Text(
                text = categoryTitle,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        LazyRow {
            items(categoryMovies){ movie->
                MovieItem(movie)

            }
        }


    }
}

@Composable
fun MovieItem(movie: MovieResult){
    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(100.dp)
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        Image(
            painter = rememberImagePainter(data = movie.poster_path) ,
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
    }
}

