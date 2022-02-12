package net.alanproject.domain.usecases.impl;

import net.alanproject.domain.model.response.list.Response;
import net.alanproject.domain.model.response.screenshots.Screenshots;
import net.alanproject.domain.repository.RawgRepository;
import net.alanproject.domain.usecases.GetScreenshots;
import net.alanproject.domain.util.Resource;
import timber.log.Timber;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lnet/alanproject/domain/usecases/impl/GetScreenshotsUsecase;", "Lnet/alanproject/domain/usecases/GetScreenshots;", "rawgRepository", "Lnet/alanproject/domain/repository/RawgRepository;", "(Lnet/alanproject/domain/repository/RawgRepository;)V", "get", "Lnet/alanproject/domain/util/Resource;", "Lnet/alanproject/domain/model/response/screenshots/Screenshots;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public final class GetScreenshotsUsecase implements net.alanproject.domain.usecases.GetScreenshots {
    private final net.alanproject.domain.repository.RawgRepository rawgRepository = null;
    
    @javax.inject.Inject()
    public GetScreenshotsUsecase(@org.jetbrains.annotations.NotNull()
    net.alanproject.domain.repository.RawgRepository rawgRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object get(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.util.Resource<net.alanproject.domain.model.response.screenshots.Screenshots>> continuation) {
        return null;
    }
}