package net.alanproject.domain.model.response.list;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bG\b\u0086\b\u0018\u00002\u00020\u0001B\u00c3\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000f\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000f\u0012\b\b\u0002\u0010$\u001a\u00020\u0001\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000f\u0012\b\b\u0002\u0010\'\u001a\u00020(\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000f\u00a2\u0006\u0002\u0010+J\t\u0010P\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u0015H\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\t\u0010X\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0001H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010[\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0005H\u00c6\u0003J\t\u0010]\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u00c6\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020!0\u000fH\u00c6\u0003J\u000f\u0010`\u001a\b\u0012\u0004\u0012\u00020#0\u000fH\u00c6\u0003J\t\u0010a\u001a\u00020\u0001H\u00c6\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020&0\u000fH\u00c6\u0003J\t\u0010c\u001a\u00020(H\u00c6\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020*0\u000fH\u00c6\u0003J\t\u0010e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010g\u001a\u00020\tH\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010i\u001a\u00020\fH\u00c6\u0003J\t\u0010j\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u00c6\u0003J\u00c7\u0002\u0010l\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000f2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\b\b\u0002\u0010$\u001a\u00020\u00012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000f2\b\b\u0002\u0010\'\u001a\u00020(2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000fH\u00c6\u0001J\u0013\u0010m\u001a\u00020\t2\b\u0010n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010o\u001a\u00020\u0003H\u00d6\u0001J\t\u0010p\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010$\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u001d\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0016\u0010\'\u001a\u00020(8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010-R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00108R\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010-R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00108R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00101R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u0016\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00101R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00108R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u00108R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010-R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u00108R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u00101R\u0016\u0010\u001a\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u00103\u00a8\u0006q"}, d2 = {"Lnet/alanproject/domain/model/response/list/Game;", "", "id", "", "slug", "", "name", "released", "tba", "", "backgroundImage", "rating", "", "ratingTop", "ratings", "", "Lnet/alanproject/domain/model/response/list/Rating;", "ratingsCount", "reviewsTextCount", "added", "addedByStatus", "Lnet/alanproject/domain/model/response/list/AddedByStatus;", "metacritic", "playtime", "suggestionsCount", "updated", "userGame", "reviewsCount", "saturatedColor", "dominantColor", "platforms", "Lnet/alanproject/domain/model/response/list/EachPlatform;", "genres", "Lnet/alanproject/domain/model/response/list/Genre;", "stores", "Lnet/alanproject/domain/model/response/list/EachStore;", "clip", "tags", "Lnet/alanproject/domain/model/response/list/Tag;", "esrbRating", "Lnet/alanproject/domain/model/response/list/EsrbRating;", "shortScreenshots", "Lnet/alanproject/domain/model/response/list/ShortScreenshot;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;DILjava/util/List;IIILnet/alanproject/domain/model/response/list/AddedByStatus;IIILjava/lang/String;Ljava/lang/Object;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/util/List;Lnet/alanproject/domain/model/response/list/EsrbRating;Ljava/util/List;)V", "getAdded", "()I", "getAddedByStatus", "()Lnet/alanproject/domain/model/response/list/AddedByStatus;", "getBackgroundImage", "()Ljava/lang/String;", "getClip", "()Ljava/lang/Object;", "getDominantColor", "getEsrbRating", "()Lnet/alanproject/domain/model/response/list/EsrbRating;", "getGenres", "()Ljava/util/List;", "getId", "getMetacritic", "getName", "getPlatforms", "getPlaytime", "getRating", "()D", "getRatingTop", "getRatings", "getRatingsCount", "getReleased", "getReviewsCount", "getReviewsTextCount", "getSaturatedColor", "getShortScreenshots", "getSlug", "getStores", "getSuggestionsCount", "getTags", "getTba", "()Z", "getUpdated", "getUserGame", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "domain_debug"})
public final class Game {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String slug = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String released = null;
    private final boolean tba = false;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "background_image")
    private final java.lang.String backgroundImage = null;
    private final double rating = 0.0;
    @com.google.gson.annotations.SerializedName(value = "rating_top")
    private final int ratingTop = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.list.Rating> ratings = null;
    @com.google.gson.annotations.SerializedName(value = "ratings_count")
    private final int ratingsCount = 0;
    @com.google.gson.annotations.SerializedName(value = "reviews_text_count")
    private final int reviewsTextCount = 0;
    private final int added = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "added_by_status")
    private final net.alanproject.domain.model.response.list.AddedByStatus addedByStatus = null;
    private final int metacritic = 0;
    private final int playtime = 0;
    @com.google.gson.annotations.SerializedName(value = "suggestions_count")
    private final int suggestionsCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String updated = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "user_game")
    private final java.lang.Object userGame = null;
    @com.google.gson.annotations.SerializedName(value = "reviews_count")
    private final int reviewsCount = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "saturated_color")
    private final java.lang.String saturatedColor = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "dominant_color")
    private final java.lang.String dominantColor = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.list.EachPlatform> platforms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.list.Genre> genres = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.list.EachStore> stores = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object clip = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.list.Tag> tags = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "esrb_rating")
    private final net.alanproject.domain.model.response.list.EsrbRating esrbRating = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "short_screenshots")
    private final java.util.List<net.alanproject.domain.model.response.list.ShortScreenshot> shortScreenshots = null;
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.list.Game copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String released, boolean tba, @org.jetbrains.annotations.Nullable()
    java.lang.String backgroundImage, double rating, int ratingTop, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.Rating> ratings, int ratingsCount, int reviewsTextCount, int added, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.list.AddedByStatus addedByStatus, int metacritic, int playtime, int suggestionsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String updated, @org.jetbrains.annotations.NotNull()
    java.lang.Object userGame, int reviewsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String saturatedColor, @org.jetbrains.annotations.NotNull()
    java.lang.String dominantColor, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.EachPlatform> platforms, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.Genre> genres, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.EachStore> stores, @org.jetbrains.annotations.NotNull()
    java.lang.Object clip, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.Tag> tags, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.list.EsrbRating esrbRating, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.ShortScreenshot> shortScreenshots) {
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
    
    public Game() {
        super();
    }
    
    public Game(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String released, boolean tba, @org.jetbrains.annotations.Nullable()
    java.lang.String backgroundImage, double rating, int ratingTop, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.Rating> ratings, int ratingsCount, int reviewsTextCount, int added, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.list.AddedByStatus addedByStatus, int metacritic, int playtime, int suggestionsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String updated, @org.jetbrains.annotations.NotNull()
    java.lang.Object userGame, int reviewsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String saturatedColor, @org.jetbrains.annotations.NotNull()
    java.lang.String dominantColor, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.EachPlatform> platforms, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.Genre> genres, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.EachStore> stores, @org.jetbrains.annotations.NotNull()
    java.lang.Object clip, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.Tag> tags, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.list.EsrbRating esrbRating, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.list.ShortScreenshot> shortScreenshots) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSlug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleased() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getTba() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBackgroundImage() {
        return null;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double getRating() {
        return 0.0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getRatingTop() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.Rating> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.Rating> getRatings() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int getRatingsCount() {
        return 0;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getReviewsTextCount() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int getAdded() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.list.AddedByStatus component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.list.AddedByStatus getAddedByStatus() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int getMetacritic() {
        return 0;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int getPlaytime() {
        return 0;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int getSuggestionsCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getUserGame() {
        return null;
    }
    
    public final int component19() {
        return 0;
    }
    
    public final int getReviewsCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSaturatedColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDominantColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.EachPlatform> component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.EachPlatform> getPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.Genre> component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.Genre> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.EachStore> component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.EachStore> getStores() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getClip() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.Tag> component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.Tag> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.list.EsrbRating component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.list.EsrbRating getEsrbRating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.ShortScreenshot> component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.list.ShortScreenshot> getShortScreenshots() {
        return null;
    }
}