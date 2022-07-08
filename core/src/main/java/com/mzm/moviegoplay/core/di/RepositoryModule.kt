package com.mzm.moviegoplay.core.di

import com.mzm.moviegoplay.core.data.source.Repository
import com.mzm.moviegoplay.core.domain.repository.DataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: Repository): DataSource
}