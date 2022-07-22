package com.mzm.movieepoxy.feature.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.domain.usecase.MovieUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val movieUsecase: MovieUsecase
) : ViewModel() {

    private val trendingSeries = MutableLiveData<Resource<List<PopularMovie>>>()
    private val popularSeries = MutableLiveData<Resource<List<PopularMovie>>>()

    fun setTrendingSeries() {
        viewModelScope.launch {
            movieUsecase.getTrendingTv().collectLatest {
                trendingSeries.postValue(it)
            }
        }
    }

    fun getTrendeingSeries(): LiveData<Resource<List<PopularMovie>>> = trendingSeries

    fun setPopularSeries() {
        viewModelScope.launch {
            movieUsecase.getPopularTv().collectLatest {
                popularSeries.postValue(it)
            }
        }
    }

    fun getPopularSeries(): LiveData<Resource<List<PopularMovie>>> = popularSeries
}