package net.alanproject.domain.usecases;

import net.alanproject.domain.model.response.detail.GameDetail;
import net.alanproject.domain.util.Resource;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lnet/alanproject/domain/usecases/GetGame;", "", "get", "Lnet/alanproject/domain/util/Resource;", "Lnet/alanproject/domain/model/response/detail/GameDetail;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public abstract interface GetGame {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object get(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super net.alanproject.domain.util.Resource<net.alanproject.domain.model.response.detail.GameDetail>> continuation);
}