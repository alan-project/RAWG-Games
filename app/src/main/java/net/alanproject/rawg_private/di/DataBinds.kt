package net.alanproject.rawg_private.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.data.source.RemoteSource
import net.alanproject.data.source.remote.RawgApi
import net.alanproject.data.source.remote.RemoteSourceImpl
import net.alanproject.rawg_private.common.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class Source {

    @Binds
    abstract fun bindRemoteSource(remoteSource: RemoteSourceImpl): RemoteSource
}


@Module
@InstallIn(SingletonComponent::class)
object DomainProvides {

    @Provides
    fun provideApi(): RawgApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RawgApi::class.java)
    }
}