package com.example.moviesapi.feature.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapi.core.Resource
import com.example.moviesapi.feature.domain.model.Movie
import com.example.moviesapi.feature.domain.use_case.GetMoviesByTitle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesByTitle: GetMoviesByTitle,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var movies = MutableLiveData<List<Movie>>()

    init {
        movies.value = arrayListOf()
        getMovies("titanic")
    }
    fun getMovies(title: String) {
        viewModelScope.launch {
            getMoviesByTitle(title).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                         movies.postValue(result.data?.movies)
                    }

                    is Resource.Error -> {
                        val error = result.data
                    }

                    is Resource.Loading -> {
                       val loading = result.data
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

}