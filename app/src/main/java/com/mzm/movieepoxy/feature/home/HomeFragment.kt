package com.mzm.movieepoxy.feature.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mzm.movieepoxy.R
import com.mzm.movieepoxy.databinding.FragmentHomeBinding
import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private val homeController: HomeController by lazy { HomeController(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvHome.layoutManager = LinearLayoutManager(requireContext())
            rvHome.setItemSpacingDp(8)
            rvHome.setController(homeController)
        }
        callData()
        observeData()
    }

    private fun callData() {
        viewModel.setPopularMovie()
        viewModel.setPopularSeries()
        viewModel.setTrendingMovie()
        viewModel.setTrendingSeries()
    }

    private fun observeData() {
        lifecycleScope.launchWhenCreated {
            viewModel.getPopularMovie().observe(viewLifecycleOwner) { data ->
                when (data) {
                    is Resource.Loading -> Timber.tag("MovieFragment").d("loading....")
                    is Resource.Success -> {
                        if (data.data.isNullOrEmpty()) {
                            Timber.tag("MovieFragment").d("popularmovie : null....")
                        } else {
                            homeController.setPopularMovie(data.data!!.toMutableList())
                        }
//                        data.data?.let { movieController.setPopularMovie(it.toMutableList()) }
                    }
                    is Resource.Error -> {
                        showError(data)
                    }
                }
            }
            viewModel.getPopularSeries().observe(viewLifecycleOwner) { data ->
                when (data) {
                    is Resource.Loading -> Timber.tag("MovieFragment").d("loading....")
                    is Resource.Success -> {
                        if (data.data.isNullOrEmpty()) {
                            Timber.tag("MovieFragment").d("popularmovie : null....")
                        } else {
                            homeController.setPopularSeries(data.data!!.toMutableList())
                        }
//                        data.data?.let { movieController.setPopularMovie(it.toMutableList()) }
                    }
                    is Resource.Error -> {
                        showError(data)
                    }
                }
            }
            viewModel.getTrendingMovie().observe(viewLifecycleOwner) { data ->
                when (data) {
                    is Resource.Loading -> Timber.tag("MovieFragment").d("loading....")
                    is Resource.Success -> {
                        if (data.data.isNullOrEmpty()) {
                            Timber.tag("MovieFragment").d("popularmovie : null....")
                        } else {
                            homeController.setTrendingMovie(data.data!!.toMutableList())
                        }
//                        data.data?.let { movieController.setPopularMovie(it.toMutableList()) }
                    }
                    is Resource.Error -> {
                        showError(data)
                    }
                }
            }
            viewModel.getTrendingSeries().observe(viewLifecycleOwner) { data ->
                when (data) {
                    is Resource.Loading -> Timber.tag("MovieFragment").d("loading....")
                    is Resource.Success -> {
                        if (data.data.isNullOrEmpty()) {
                            Timber.tag("MovieFragment").d("popularmovie : null....")
                        } else {
                            homeController.setTrendingSeries(data.data!!.toMutableList())
                        }
//                        data.data?.let { movieController.setPopularMovie(it.toMutableList()) }
                    }
                    is Resource.Error -> {
                        showError(data)
                    }
                }
            }


        }
    }

    private fun showError(data: Resource.Error<List<PopularMovie>>) {
        Timber.tag(HomeFragment::class.java.simpleName).e("error : ${data.message}")
    }

}