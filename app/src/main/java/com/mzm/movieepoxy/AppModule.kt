package com.mzm.movieepoxy

import com.mzm.moviegoplay.core.domain.usecase.MovieInteractor
import com.mzm.moviegoplay.core.domain.usecase.MovieUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Muhammad Zaim Milzam on 23/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUsecase
}