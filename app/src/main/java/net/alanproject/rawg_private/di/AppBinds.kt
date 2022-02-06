package net.alanproject.rawg_private.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.domain.usecases.GetGame
import net.alanproject.domain.usecases.GetGames
import net.alanproject.domain.usecases.GetScreenshots
import net.alanproject.domain.usecases.impl.GetGameUsecase
import net.alanproject.domain.usecases.impl.GetGamesUsecase
import net.alanproject.domain.usecases.impl.GetScreenshotsUsecase

@Module
@InstallIn(SingletonComponent::class)
abstract class Usecases{

    @Binds
    abstract fun bindGetGames(getGames: GetGamesUsecase):GetGames

    @Binds
    abstract fun bindGetGame(getGame: GetGameUsecase):GetGame

    @Binds
    abstract fun bindGetScreenshots(getScreenshots: GetScreenshotsUsecase):GetScreenshots
}