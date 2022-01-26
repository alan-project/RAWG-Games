package net.alanproject.rawg_private.ui.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.domain.usecases.GetTopList
import net.alanproject.domain.usecases.impl.GetTopListUsecase

@Module
@InstallIn(SingletonComponent::class)
abstract class Usecases{

    @Binds
    abstract fun bindGetTopList(getTopList: GetTopListUsecase):GetTopList
}