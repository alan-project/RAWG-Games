package net.alanproject.data.source.remote;

import net.alanproject.data.BuildConfig;
import net.alanproject.domain.model.response.detail.GameDetail;
import net.alanproject.domain.model.response.list.Response;
import net.alanproject.domain.model.response.screenshots.Screenshots;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJW\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lnet/alanproject/data/source/remote/RawgApi;", "", "getGame", "Lnet/alanproject/domain/model/response/detail/GameDetail;", "id", "", "key", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGames", "Lnet/alanproject/domain/model/response/list/Response;", "page", "order", "dates", "platforms", "genres", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenshots", "Lnet/alanproject/domain/model/response/screenshots/Screenshots;", "data_debug"})
public abstract interface RawgApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "games")
    public abstract java.lang.Object getGames(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "key")
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "page")
    java.lang.Integer page, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "ordering")
    java.lang.String order, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "dates")
    java.lang.String dates, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "platforms")
    java.lang.String platforms, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "genres")
    java.lang.String genres, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.list.Response> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "games/{id}")
    public abstract java.lang.Object getGame(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.detail.GameDetail> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "games/{id}/screenshots")
    public abstract java.lang.Object getScreenshots(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.model.response.screenshots.Screenshots> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}