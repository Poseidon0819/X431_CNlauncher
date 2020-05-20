package com.mopub.volley;

import com.itextpdf.text.pdf.PdfContentParser;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class NetworkResponse {
    public final byte[] data;
    public final Map<String, String> headers;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.headers = map;
        this.notModified = z;
        this.networkTimeMs = j;
    }

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z) {
        this(i, bArr, map, z, 0L);
    }

    public NetworkResponse(byte[] bArr) {
        this(PdfContentParser.COMMAND_TYPE, bArr, Collections.emptyMap(), false, 0L);
    }

    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this(PdfContentParser.COMMAND_TYPE, bArr, map, false, 0L);
    }
}
