package net.alanproject.domain.model.response.detail;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b~\b\u0086\b\u0018\u00002\u00020\u0001B\u00df\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\b\u0002\u0010\'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\u0003\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010,\u001a\u00020\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\b\b\u0002\u0010/\u001a\u00020\u0005\u0012\b\b\u0002\u00100\u001a\u00020\u0003\u0012\b\b\u0002\u00101\u001a\u00020\u0003\u0012\b\b\u0002\u00102\u001a\u00020\u0003\u0012\b\b\u0002\u00103\u001a\u00020\u0001\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0005\u0012\b\b\u0002\u00106\u001a\u00020\u0005\u0012\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002080\u000b\u0012\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000b\u0012\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u000b\u0012\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u000b\u0012\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u000b\u0012\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u000b\u0012\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u000b\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010G\u001a\u00020\u0001\u0012\b\b\u0002\u0010H\u001a\u00020\u0005\u00a2\u0006\u0002\u0010IJ\n\u0010\u0089\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0015H\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bH\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u001aH\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u001dH\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00a0\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a2\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a5\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u00a6\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u00c6\u0003J\n\u0010\u00a7\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00a8\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a9\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00aa\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00ab\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ac\u0001\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ae\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00af\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u00b0\u0001\u001a\b\u0012\u0004\u0012\u0002080\u000bH\u00c6\u0003J\u0010\u0010\u00b1\u0001\u001a\b\u0012\u0004\u0012\u00020:0\u000bH\u00c6\u0003J\u0010\u0010\u00b2\u0001\u001a\b\u0012\u0004\u0012\u00020<0\u000bH\u00c6\u0003J\u0010\u0010\u00b3\u0001\u001a\b\u0012\u0004\u0012\u00020>0\u000bH\u00c6\u0003J\u0010\u0010\u00b4\u0001\u001a\b\u0012\u0004\u0012\u00020@0\u000bH\u00c6\u0003J\n\u0010\u00b5\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u00b6\u0001\u001a\b\u0012\u0004\u0012\u00020B0\u000bH\u00c6\u0003J\u0010\u0010\u00b7\u0001\u001a\b\u0012\u0004\u0012\u00020D0\u000bH\u00c6\u0003J\f\u0010\u00b8\u0001\u001a\u0004\u0018\u00010FH\u00c6\u0003J\n\u0010\u00b9\u0001\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u00ba\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00bb\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u00bc\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\n\u0010\u00bd\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00be\u0001\u001a\u00020\u000fH\u00c6\u0003J\u00e4\u0004\u0010\u00bf\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010\'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00012\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u00052\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002080\u000b2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000b2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u000b2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u000b2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u000b2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u000b2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u000b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010G\u001a\u00020\u00012\b\b\u0002\u0010H\u001a\u00020\u0005H\u00c6\u0001J\u0015\u0010\u00c0\u0001\u001a\u00020\u000f2\t\u0010\u00c1\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u00c2\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u00c3\u0001\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010KR\u0016\u0010\u001c\u001a\u00020\u001d8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0016\u00101\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010SR\u0011\u0010G\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0016\u0010!\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010KR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010SR\u0016\u0010H\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010SR\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010QR\u0016\u00106\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010SR\u0018\u0010E\u001a\u0004\u0018\u00010F8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0016\u00102\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010KR\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010QR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010KR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010KR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010QR\u0016\u0010/\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010SR\u0016\u0010 \u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010KR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010SR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010SR\u0016\u0010#\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010KR\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002080\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u0010QR\u0016\u00100\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010KR\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u0010QR\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bk\u0010KR\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010QR\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010KR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010QR\u0016\u0010,\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010KR\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0016\u0010(\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bt\u0010KR\u0016\u0010&\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bu\u0010SR\u0016\u0010\'\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bv\u0010SR\u0016\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bw\u0010SR\u0016\u0010$\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bx\u0010SR\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\by\u0010SR\u0016\u00104\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bz\u0010KR\u0016\u0010+\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b{\u0010KR\u0016\u00105\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b|\u0010SR\u0016\u0010\u001f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b}\u0010KR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b~\u0010SR\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010QR\u0017\u0010-\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010KR\u0018\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u000b\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010QR\u0013\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010)\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010KR\u0012\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010SR\u0017\u00103\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010VR\u0012\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010SR\u0017\u0010*\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010K\u00a8\u0006\u00c4\u0001"}, d2 = {"Lnet/alanproject/domain/model/response/detail/GameDetail;", "", "id", "", "slug", "", "name", "nameOriginal", "description", "metacritic", "metacriticPlatforms", "", "Lnet/alanproject/domain/model/response/detail/MetacriticPlatform;", "released", "tba", "", "updated", "backgroundImage", "backgroundImageAdditional", "website", "rating", "", "ratingTop", "ratings", "Lnet/alanproject/domain/model/response/detail/Rating;", "reactions", "Lnet/alanproject/domain/model/response/detail/Reactions;", "added", "addedByStatus", "Lnet/alanproject/domain/model/response/detail/AddedByStatus;", "playtime", "screenshotsCount", "moviesCount", "creatorsCount", "achievementsCount", "parentAchievementsCount", "redditUrl", "redditName", "redditDescription", "redditLogo", "redditCount", "twitchCount", "youtubeCount", "reviewsTextCount", "ratingsCount", "suggestionsCount", "alternativeNames", "metacriticUrl", "parentsCount", "additionsCount", "gameSeriesCount", "userGame", "reviewsCount", "saturatedColor", "dominantColor", "parentPlatforms", "Lnet/alanproject/domain/model/response/detail/ParentPlatform;", "platforms", "Lnet/alanproject/domain/model/response/detail/EachPlatformInfo;", "stores", "Lnet/alanproject/domain/model/response/detail/Store;", "developers", "Lnet/alanproject/domain/model/response/detail/Developer;", "genres", "Lnet/alanproject/domain/model/response/detail/Genre;", "tags", "Lnet/alanproject/domain/model/response/detail/Tag;", "publishers", "Lnet/alanproject/domain/model/response/detail/Publisher;", "esrbRating", "Lnet/alanproject/domain/model/response/detail/EsrbRating;", "clip", "descriptionRaw", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DILjava/util/List;Lnet/alanproject/domain/model/response/detail/Reactions;ILnet/alanproject/domain/model/response/detail/AddedByStatus;IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIILjava/util/List;Ljava/lang/String;IIILjava/lang/Object;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lnet/alanproject/domain/model/response/detail/EsrbRating;Ljava/lang/Object;Ljava/lang/String;)V", "getAchievementsCount", "()I", "getAdded", "getAddedByStatus", "()Lnet/alanproject/domain/model/response/detail/AddedByStatus;", "getAdditionsCount", "getAlternativeNames", "()Ljava/util/List;", "getBackgroundImage", "()Ljava/lang/String;", "getBackgroundImageAdditional", "getClip", "()Ljava/lang/Object;", "getCreatorsCount", "getDescription", "getDescriptionRaw", "getDevelopers", "getDominantColor", "getEsrbRating", "()Lnet/alanproject/domain/model/response/detail/EsrbRating;", "getGameSeriesCount", "getGenres", "getId", "getMetacritic", "getMetacriticPlatforms", "getMetacriticUrl", "getMoviesCount", "getName", "getNameOriginal", "getParentAchievementsCount", "getParentPlatforms", "getParentsCount", "getPlatforms", "getPlaytime", "getPublishers", "getRating", "()D", "getRatingTop", "getRatings", "getRatingsCount", "getReactions", "()Lnet/alanproject/domain/model/response/detail/Reactions;", "getRedditCount", "getRedditDescription", "getRedditLogo", "getRedditName", "getRedditUrl", "getReleased", "getReviewsCount", "getReviewsTextCount", "getSaturatedColor", "getScreenshotsCount", "getSlug", "getStores", "getSuggestionsCount", "getTags", "getTba", "()Z", "getTwitchCount", "getUpdated", "getUserGame", "getWebsite", "getYoutubeCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "domain_debug"})
public final class GameDetail {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String slug = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "name_original")
    private final java.lang.String nameOriginal = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final int metacritic = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "metacritic_platforms")
    private final java.util.List<net.alanproject.domain.model.response.detail.MetacriticPlatform> metacriticPlatforms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String released = null;
    private final boolean tba = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String updated = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "background_image")
    private final java.lang.String backgroundImage = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "background_image_additional")
    private final java.lang.String backgroundImageAdditional = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String website = null;
    private final double rating = 0.0;
    @com.google.gson.annotations.SerializedName(value = "rating_top")
    private final int ratingTop = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.detail.Rating> ratings = null;
    @org.jetbrains.annotations.NotNull()
    private final net.alanproject.domain.model.response.detail.Reactions reactions = null;
    private final int added = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "added_by_status")
    private final net.alanproject.domain.model.response.detail.AddedByStatus addedByStatus = null;
    private final int playtime = 0;
    @com.google.gson.annotations.SerializedName(value = "screenshots_count")
    private final int screenshotsCount = 0;
    @com.google.gson.annotations.SerializedName(value = "movies_count")
    private final int moviesCount = 0;
    @com.google.gson.annotations.SerializedName(value = "creators_count")
    private final int creatorsCount = 0;
    @com.google.gson.annotations.SerializedName(value = "achievements_count")
    private final int achievementsCount = 0;
    @com.google.gson.annotations.SerializedName(value = "parent_achievements_count")
    private final int parentAchievementsCount = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "reddit_url")
    private final java.lang.String redditUrl = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "reddit_name")
    private final java.lang.String redditName = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "reddit_description")
    private final java.lang.String redditDescription = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "reddit_logo")
    private final java.lang.String redditLogo = null;
    @com.google.gson.annotations.SerializedName(value = "reddit_count")
    private final int redditCount = 0;
    @com.google.gson.annotations.SerializedName(value = "twitch_count")
    private final int twitchCount = 0;
    @com.google.gson.annotations.SerializedName(value = "youtube_count")
    private final int youtubeCount = 0;
    @com.google.gson.annotations.SerializedName(value = "reviews_text_count")
    private final int reviewsTextCount = 0;
    @com.google.gson.annotations.SerializedName(value = "ratings_count")
    private final int ratingsCount = 0;
    @com.google.gson.annotations.SerializedName(value = "suggestions_count")
    private final int suggestionsCount = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "alternative_names")
    private final java.util.List<java.lang.Object> alternativeNames = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "metacritic_url")
    private final java.lang.String metacriticUrl = null;
    @com.google.gson.annotations.SerializedName(value = "parents_count")
    private final int parentsCount = 0;
    @com.google.gson.annotations.SerializedName(value = "additions_count")
    private final int additionsCount = 0;
    @com.google.gson.annotations.SerializedName(value = "game_series_count")
    private final int gameSeriesCount = 0;
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
    @com.google.gson.annotations.SerializedName(value = "parent_platforms")
    private final java.util.List<net.alanproject.domain.model.response.detail.ParentPlatform> parentPlatforms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.detail.EachPlatformInfo> platforms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.detail.Store> stores = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.detail.Developer> developers = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.detail.Genre> genres = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.detail.Tag> tags = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.alanproject.domain.model.response.detail.Publisher> publishers = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "esrb_rating")
    private final net.alanproject.domain.model.response.detail.EsrbRating esrbRating = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object clip = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "description_raw")
    private final java.lang.String descriptionRaw = null;
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.GameDetail copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String nameOriginal, @org.jetbrains.annotations.NotNull()
    java.lang.String description, int metacritic, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.MetacriticPlatform> metacriticPlatforms, @org.jetbrains.annotations.NotNull()
    java.lang.String released, boolean tba, @org.jetbrains.annotations.NotNull()
    java.lang.String updated, @org.jetbrains.annotations.NotNull()
    java.lang.String backgroundImage, @org.jetbrains.annotations.NotNull()
    java.lang.String backgroundImageAdditional, @org.jetbrains.annotations.NotNull()
    java.lang.String website, double rating, int ratingTop, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Rating> ratings, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.detail.Reactions reactions, int added, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.detail.AddedByStatus addedByStatus, int playtime, int screenshotsCount, int moviesCount, int creatorsCount, int achievementsCount, int parentAchievementsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String redditUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String redditName, @org.jetbrains.annotations.NotNull()
    java.lang.String redditDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String redditLogo, int redditCount, int twitchCount, int youtubeCount, int reviewsTextCount, int ratingsCount, int suggestionsCount, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> alternativeNames, @org.jetbrains.annotations.NotNull()
    java.lang.String metacriticUrl, int parentsCount, int additionsCount, int gameSeriesCount, @org.jetbrains.annotations.NotNull()
    java.lang.Object userGame, int reviewsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String saturatedColor, @org.jetbrains.annotations.NotNull()
    java.lang.String dominantColor, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.ParentPlatform> parentPlatforms, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.EachPlatformInfo> platforms, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Store> stores, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Developer> developers, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Genre> genres, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Tag> tags, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Publisher> publishers, @org.jetbrains.annotations.Nullable()
    net.alanproject.domain.model.response.detail.EsrbRating esrbRating, @org.jetbrains.annotations.NotNull()
    java.lang.Object clip, @org.jetbrains.annotations.NotNull()
    java.lang.String descriptionRaw) {
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
    
    public GameDetail() {
        super();
    }
    
    public GameDetail(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String nameOriginal, @org.jetbrains.annotations.NotNull()
    java.lang.String description, int metacritic, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.MetacriticPlatform> metacriticPlatforms, @org.jetbrains.annotations.NotNull()
    java.lang.String released, boolean tba, @org.jetbrains.annotations.NotNull()
    java.lang.String updated, @org.jetbrains.annotations.NotNull()
    java.lang.String backgroundImage, @org.jetbrains.annotations.NotNull()
    java.lang.String backgroundImageAdditional, @org.jetbrains.annotations.NotNull()
    java.lang.String website, double rating, int ratingTop, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Rating> ratings, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.detail.Reactions reactions, int added, @org.jetbrains.annotations.NotNull()
    net.alanproject.domain.model.response.detail.AddedByStatus addedByStatus, int playtime, int screenshotsCount, int moviesCount, int creatorsCount, int achievementsCount, int parentAchievementsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String redditUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String redditName, @org.jetbrains.annotations.NotNull()
    java.lang.String redditDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String redditLogo, int redditCount, int twitchCount, int youtubeCount, int reviewsTextCount, int ratingsCount, int suggestionsCount, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> alternativeNames, @org.jetbrains.annotations.NotNull()
    java.lang.String metacriticUrl, int parentsCount, int additionsCount, int gameSeriesCount, @org.jetbrains.annotations.NotNull()
    java.lang.Object userGame, int reviewsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String saturatedColor, @org.jetbrains.annotations.NotNull()
    java.lang.String dominantColor, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.ParentPlatform> parentPlatforms, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.EachPlatformInfo> platforms, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Store> stores, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Developer> developers, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Genre> genres, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Tag> tags, @org.jetbrains.annotations.NotNull()
    java.util.List<net.alanproject.domain.model.response.detail.Publisher> publishers, @org.jetbrains.annotations.Nullable()
    net.alanproject.domain.model.response.detail.EsrbRating esrbRating, @org.jetbrains.annotations.NotNull()
    java.lang.Object clip, @org.jetbrains.annotations.NotNull()
    java.lang.String descriptionRaw) {
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
    public final java.lang.String getNameOriginal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getMetacritic() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.MetacriticPlatform> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.MetacriticPlatform> getMetacriticPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleased() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getTba() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBackgroundImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBackgroundImageAdditional() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWebsite() {
        return null;
    }
    
    public final double component14() {
        return 0.0;
    }
    
    public final double getRating() {
        return 0.0;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int getRatingTop() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Rating> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Rating> getRatings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.Reactions component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.Reactions getReactions() {
        return null;
    }
    
    public final int component18() {
        return 0;
    }
    
    public final int getAdded() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.AddedByStatus component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.alanproject.domain.model.response.detail.AddedByStatus getAddedByStatus() {
        return null;
    }
    
    public final int component20() {
        return 0;
    }
    
    public final int getPlaytime() {
        return 0;
    }
    
    public final int component21() {
        return 0;
    }
    
    public final int getScreenshotsCount() {
        return 0;
    }
    
    public final int component22() {
        return 0;
    }
    
    public final int getMoviesCount() {
        return 0;
    }
    
    public final int component23() {
        return 0;
    }
    
    public final int getCreatorsCount() {
        return 0;
    }
    
    public final int component24() {
        return 0;
    }
    
    public final int getAchievementsCount() {
        return 0;
    }
    
    public final int component25() {
        return 0;
    }
    
    public final int getParentAchievementsCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRedditUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRedditName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRedditDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRedditLogo() {
        return null;
    }
    
    public final int component30() {
        return 0;
    }
    
    public final int getRedditCount() {
        return 0;
    }
    
    public final int component31() {
        return 0;
    }
    
    public final int getTwitchCount() {
        return 0;
    }
    
    public final int component32() {
        return 0;
    }
    
    public final int getYoutubeCount() {
        return 0;
    }
    
    public final int component33() {
        return 0;
    }
    
    public final int getReviewsTextCount() {
        return 0;
    }
    
    public final int component34() {
        return 0;
    }
    
    public final int getRatingsCount() {
        return 0;
    }
    
    public final int component35() {
        return 0;
    }
    
    public final int getSuggestionsCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> component36() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> getAlternativeNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component37() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMetacriticUrl() {
        return null;
    }
    
    public final int component38() {
        return 0;
    }
    
    public final int getParentsCount() {
        return 0;
    }
    
    public final int component39() {
        return 0;
    }
    
    public final int getAdditionsCount() {
        return 0;
    }
    
    public final int component40() {
        return 0;
    }
    
    public final int getGameSeriesCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component41() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getUserGame() {
        return null;
    }
    
    public final int component42() {
        return 0;
    }
    
    public final int getReviewsCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component43() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSaturatedColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component44() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDominantColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.ParentPlatform> component45() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.ParentPlatform> getParentPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.EachPlatformInfo> component46() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.EachPlatformInfo> getPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Store> component47() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Store> getStores() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Developer> component48() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Developer> getDevelopers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Genre> component49() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Genre> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Tag> component50() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Tag> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Publisher> component51() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.alanproject.domain.model.response.detail.Publisher> getPublishers() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final net.alanproject.domain.model.response.detail.EsrbRating component52() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final net.alanproject.domain.model.response.detail.EsrbRating getEsrbRating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component53() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getClip() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component54() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescriptionRaw() {
        return null;
    }
}