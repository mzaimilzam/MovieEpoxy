package com.mzm.movieepoxy.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.domain.model.Film
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.domain.usecase.MovieUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieUsecase: MovieUsecase) : ViewModel() {

    private val trendingFilm = MutableLiveData<Resource<List<Film>>>()
    private val trendingMovie = MutableLiveData<Resource<List<PopularMovie>>>()
    private val trendingSeries = MutableLiveData<Resource<List<PopularMovie>>>()
    private val popularMovie = MutableLiveData<Resource<List<PopularMovie>>>()
    private val popularSeries = MutableLiveData<Resource<List<PopularMovie>>>()

    fun setTrendingFilm() {
        viewModelScope.launch {
            movieUsecase.getTrendingAll().collectLatest {
                trendingFilm.postValue(it)
            }
        }

    }

    fun getTrendingFilm(): LiveData<Resource<List<Film>>> = trendingFilm

    fun setTrendingMovie() {
        viewModelScope.launch {
            movieUsecase.getTrendingMovie().collectLatest {
                trendingMovie.postValue(it)
            }
        }
    }

    fun getTrendingMovie(): LiveData<Resource<List<PopularMovie>>> = trendingMovie

    fun setTrendingSeries() {
        viewModelScope.launch {
            movieUsecase.getTrendingTv().collectLatest {
                trendingSeries.postValue(it)
            }
        }
    }

    fun getTrendingSeries(): LiveData<Resource<List<PopularMovie>>> = trendingSeries

    fun setPopularMovie() {
        viewModelScope.launch {
            movieUsecase.getPopularMovie().collectLatest {
                popularMovie.postValue(it)
            }
        }
    }

    fun getPopularMovie(): LiveData<Resource<List<PopularMovie>>> = popularMovie

    fun setPopularSeries() {
        viewModelScope.launch {
            movieUsecase.getPopularTv().collectLatest {
                popularSeries.postValue(it)
            }
        }
    }

    fun getPopularSeries(): LiveData<Resource<List<PopularMovie>>> = popularSeries


}