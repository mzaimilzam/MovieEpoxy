package com.mzm.moviegoplay.core.di

import android.content.Context
import androidx.room.Room
import com.mzm.moviegoplay.core.data.source.local.room.Database
import com.mzm.moviegoplay.core.data.source.local.room.dao.FilmDao
import com.mzm.moviegoplay.core.data.source.local.room.dao.FilmRemoteKeyDao
import com.mzm.moviegoplay.core.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            Constants.DATABASE_NAME,
        ).fallbackToDestructiveMigration().build()

    }

    @Provides
    fun providesFilmDao(database: Database): FilmDao = database.filmDao()

    @Provides
    fun provideFilmRemoteKeysDao(database: Database): FilmRemoteKeyDao = database.filmRemoteKeyDao()
}