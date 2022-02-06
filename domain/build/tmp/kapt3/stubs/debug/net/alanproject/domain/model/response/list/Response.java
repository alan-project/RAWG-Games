package net.alanproject.domain.model.response.list;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u000fH\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0013H\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0001H\u00c6\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u000fH\u00c6\u0003J\u0097\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0001J\u0013\u00107\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020\u0003H\u00d6\u0001J\t\u0010:\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019\u00a8\u0006;"}, d2 = {"Lnet/alanproject/domain/model/response/list/Response;", "", "count", "", "next", "", "previous", "results", "", "Lnet/alanproject/domain/model/response/list/Game;", "seoTitle", "seoDescription", "seoKeywords", "seoH1", "noindex", "", "nofollow", "description", "filters", "Lnet/alanproject/domain/model/response/list/Filters;", "nofollowCollections", "(ILjava/lang/String;Ljava/lang/Object;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lnet/alanproject/domain/model/response/list/Filters;Ljava/util/List;)V", "getCount", "()I", "getDescription", "()Ljava/lang/String;", "getFilters", "()Lnet/alanproject/domain/model/response/list/Filters;", "getNext", "getNofollow", "()Z", "getNofollowCollections", "()Ljava/util/List;", "getNoindex", "getPrevious", "()Ljava/lang/Object;", "getResults", "getSeoDescription", "getSeoH1", "getSeoKeywords", "getSeoTitle", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "domain_debug"})
public final class Response {
    private final int count = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String next = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object previous = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.list.Game> results = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "seo_title")
    private final java.lang.String seoTitle = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "seo_description")
    private final java.lang.String seoDescription = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "seo_keywords")
    private final java.lang.String seoKeywords = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "seo_h1")
    private final java.lang.String seoH1 = null;
    private final boolean noindex = false;
    private final boolean nofollow = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final net.alanproject.domain.model.response.list.Filters filters = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "nofollow_collections")
    private final java.util.List<java.lang.String> nofollowCollections = null;
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.list.Response copy(int count, @org.jetbrains.annotations.NotNull()
    java.lang.String next, @org.jetbrains.annotations.NotNull()
    java.lang.Object previous, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.Game> results, @org.jetbrains.annotations.NotNull()
    java.lang.String seoTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String seoDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String seoKeywords, @org.jetbrains.annotations.NotNull()
    java.lang.String seoH1, boolean noindex, boolean nofollow, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.list.Filters filters, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> nofollowCollections) {
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
    
    public Response() {
        super();
    }
    
    public Response(int count, @org.jetbrains.annotations.NotNull()
    java.lang.String next, @org.jetbrains.annotations.NotNull()
    java.lang.Object previous, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.Game> results, @org.jetbrains.annotations.NotNull()
    java.lang.String seoTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String seoDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String seoKeywords, @org.jetbrains.annotations.NotNull()
    java.lang.String seoH1, boolean noindex, boolean nofollow, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.list.Filters filters, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> nofollowCollections) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getPrevious() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.Game> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.Game> getResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeoTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeoDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeoKeywords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeoH1() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getNoindex() {
        return false;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean getNofollow() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.list.Filters component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.list.Filters getFilters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getNofollowCollections() {
        return null;
    }
}