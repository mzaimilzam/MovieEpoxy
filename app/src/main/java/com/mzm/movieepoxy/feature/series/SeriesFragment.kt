package com.mzm.movieepoxy.feature.series

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mzm.movieepoxy.R
import com.mzm.movieepoxy.databinding.FragmentSeriesBinding
import com.mzm.movieepoxy.feature.movie.MovieController
import com.mzm.movieepoxy.feature.movie.MovieFragment
import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SeriesFragment : Fragment(R.layout.fragment_series) {


    private val binding by viewBinding(FragmentSeriesBinding::bind)
    private val viewmodels: SeriesViewModel by viewModels()
    private val movieController: MovieController by lazy { MovieController(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvSeries.layoutManager = LinearLayoutManager(requireContext())
            rvSeries.setItemSpacingDp(8)
            rvSeries.setController(movieController)
        }

        viewmodels.setPopularSeries()
        viewmodels.setTrendingSeries()

        obserever()
    }

    private fun obserever() {
        lifecycleScope.launchWhenCreated {
            viewmodels.getTrendeingSeries().observe(viewLifecycleOwner) { data ->
                when (data) {
                    is Resource.Loading -> Timber.tag("SeriesFragment").d("loading....")
                    is Resource.Success -> {
                        if (data.data.isNullOrEmpty()) {
                            Timber.tag("SeriesFragment").d("popularmovie : null....")
                        } else {
                            movieController.setTrendingMovie(data.data!!.toMutableList())
                        }
                    }
                    is Resource.Error -> {
                        showError(data)
                    }
                }
            }

            viewmodels.getPopularSeries().observe(viewLifecycleOwner) { data ->
                when (data) {
                    is Resource.Loading -> Timber.tag("SeriesFragment").d("loading....")
                    is Resource.Success -> {
                        if (data.data.isNullOrEmpty()) {
                            Timber.tag("SeriesFragment").d("popularmovie : null....")
                        } else {
                            movieController.setPopularMovie(data.data!!.toMutableList())
                        }
                    }
                    is Resource.Error -> {
                        showError(data)
                    }
                }
            }
        }

    }

    private fun showError(data: Resource.Error<List<PopularMovie>>) {
        Timber.tag(MovieFragment::class.java.simpleName).e("error : ${data.message}")
    }

}