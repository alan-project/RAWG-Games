package net.alanproject.domain.repository;

import net.alanproject.domain.model.response.detail.GameDetail;
import net.alanproject.domain.model.response.list.Response;
import net.alanproject.domain.model.response.screenshots.Screenshots;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006JC\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lnet/alanproject/domain/repository/RawgRepository;", "", "getGame", "Lnet/alanproject/domain/model/response/detail/GameDetail;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGames", "Lnet/alanproject/domain/model/response/list/Response;", "page", "order", "", "dates", "platforms", "genres", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenshots", "Lnet/alanproject/domain/model/response/screenshots/Screenshots;", "domain_debug"})
public abstract interface RawgRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGames(@org.jetbrains.annotations.Nullable()
    java.lang.Integer page, @org.jetbrains.annotations.Nullable()
    java.lang.String order, @org.jetbrains.annotations.Nullable()
    java.lang.String dates, @org.jetbrains.annotations.Nullable()
    java.lang.String platforms, @org.jetbrains.annotations.Nullable()
    java.lang.String genres, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.list.Response> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGame(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.detail.GameDetail> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getScreenshots(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.screenshots.Screenshots> continuation);
}