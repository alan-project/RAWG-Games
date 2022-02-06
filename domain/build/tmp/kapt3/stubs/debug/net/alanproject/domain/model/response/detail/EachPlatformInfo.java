package net.alanproject.domain.model.response.detail;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lnet/alanproject/domain/model/response/detail/EachPlatformInfo;", "", "platform", "Lnet/alanproject/domain/model/response/detail/PlatformXXX;", "releasedAt", "", "requirements", "Lnet/alanproject/domain/model/response/detail/Requirements;", "(Lnet/alanproject/domain/model/response/detail/PlatformXXX;Ljava/lang/String;Lnet/alanproject/domain/model/response/detail/Requirements;)V", "getPlatform", "()Lnet/alanproject/domain/model/response/detail/PlatformXXX;", "getReleasedAt", "()Ljava/lang/String;", "getRequirements", "()Lnet/alanproject/domain/model/response/detail/Requirements;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_debug"})
public final class EachPlatformInfo {
    @org.jetbrains.annotations.NotNull()
    private final net.alanproject.domain.model.response.detail.PlatformXXX platform = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "released_at")
    private final java.lang.String releasedAt = null;
    @org.jetbrains.annotations.NotNull()
    private final net.alanproject.domain.model.response.detail.Requirements requirements = null;
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.EachPlatformInfo copy(@org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.detail.PlatformXXX platform, @org.jetbrains.annotations.NotNull()
    java.lang.String releasedAt, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.detail.Requirements requirements) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public EachPlatformInfo() {
        super();
    }
    
    public EachPlatformInfo(@org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.detail.PlatformXXX platform, @org.jetbrains.annotations.NotNull()
    java.lang.String releasedAt, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.detail.Requirements requirements) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.PlatformXXX component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.PlatformXXX getPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleasedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.Requirements component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.Requirements getRequirements() {
        return null;
    }
}