package net.alanproject.rawg_private.ui.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.data.repository.RawgRepositoryImpl
import net.alanproject.domain.repository.RawgRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class Repositories {

    @Binds
    abstract fun bindRepository(rawgRepository: RawgRepositoryImpl): RawgRepository
}