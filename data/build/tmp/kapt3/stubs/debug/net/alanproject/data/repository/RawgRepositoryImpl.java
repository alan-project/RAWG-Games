package net.alanproject.data.repository;

import net.alanproject.data.source.RemoteSource;
import net.alanproject.domain.model.response.detail.GameDetail;
import net.alanproject.domain.model.response.list.Response;
import net.alanproject.domain.model.response.screenshots.Screenshots;
import net.alanproject.domain.repository.RawgRepository;
import timber.log.Timber;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJC\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lnet/alanproject/data/repository/RawgRepositoryImpl;", "Lnet/alanproject/domain/repository/RawgRepository;", "remoteSource", "Lnet/alanproject/data/source/RemoteSource;", "(Lnet/alanproject/data/source/RemoteSource;)V", "getGame", "Lnet/alanproject/domain/model/response/detail/GameDetail;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGames", "Lnet/alanproject/domain/model/response/list/Response;", "page", "order", "", "dates", "platforms", "genres", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenshots", "Lnet/alanproject/domain/model/response/screenshots/Screenshots;", "data_debug"})
public final class RawgRepositoryImpl implements net.alanproject.domain.repository.RawgRepository {
    private final net.alanproject.data.source.RemoteSource remoteSource = null;
    
    @javax.inject.Inject()
    public RawgRepositoryImpl(@org.jetbrains.annotations.NotNull()
    net.alanproject.data.source.RemoteSource remoteSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getGames(@org.jetbrains.annotations.Nullable()
    java.lang.Integer page, @org.jetbrains.annotations.Nullable()
    java.lang.String order, @org.jetbrains.annotations.Nullable()
    java.lang.String dates, @org.jetbrains.annotations.Nullable()
    java.lang.String platforms, @org.jetbrains.annotations.Nullable()
    java.lang.String genres, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.list.Response> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getGame(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.detail.GameDetail> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getScreenshots(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.screenshots.Screenshots> continuation) {
        return null;
    }
}