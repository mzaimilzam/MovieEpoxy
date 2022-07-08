package com.mzm.movieepoxy.feature.home

import androidx.lifecycle.ViewModel
import com.mzm.moviegoplay.core.domain.usecase.MovieUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieUsecase: MovieUsecase) : ViewModel() {


}