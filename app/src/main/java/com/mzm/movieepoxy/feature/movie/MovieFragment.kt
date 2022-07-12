package com.mzm.movieepoxy.feature.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mzm.movieepoxy.R
import com.mzm.movieepoxy.databinding.FragmentMovieBinding
import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private val binding by viewBinding(FragmentMovieBinding::bind)
    private val viewModel: MovieViewModel by viewModels()
    private val movieController: MovieController by lazy { MovieController(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvMovie.layoutManager = LinearLayoutManager(requireContext())
            rvMovie.setItemSpacingDp(8)
            rvMovie.setController(movieController)
        }

        viewModel.setTrendingMovie()
        viewModel.setPopularMovie()
        observePopularMovie()
    }

    private fun observePopularMovie() {
        lifecycleScope.launchWhenCreated {
            viewModel.getTrendingMovie().observe(viewLifecycleOwner) { data ->
                when (data) {
                    is Resource.Loading -> Timber.tag("MovieFragment").d("loading....")
                    is Resource.Success -> {
                        if (data.data.isNullOrEmpty()) {
                            Timber.tag("MovieFragment").d("popularmovie : null....")
                        } else {
                            movieController.setTrendingMovie(data.data!!.toMutableList())
                        }
                    }
                    is Resource.Error -> {
                        showError(data)
                    }
                }
            }

            viewModel.getPopularMovie().observe(viewLifecycleOwner) { data ->
                when (data) {
                    is Resource.Loading -> Timber.tag("MovieFragment").d("loading....")
                    is Resource.Success -> {
                        if (data.data.isNullOrEmpty()) {
                            Timber.tag("MovieFragment").d("popularmovie : null....")
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