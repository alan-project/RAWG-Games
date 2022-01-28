package net.alanproject.rawg_private.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.domain.usecases.GetList
import net.alanproject.domain.usecases.impl.GetListUsecase

@Module
@InstallIn(SingletonComponent::class)
abstract class Usecases{

    @Binds
    abstract fun bindGetTopList(getTopList: GetListUsecase):GetList
}