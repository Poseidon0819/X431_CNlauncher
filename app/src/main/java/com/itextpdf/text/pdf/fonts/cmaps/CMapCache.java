package com.itextpdf.text.pdf.fonts.cmaps;

import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class CMapCache {
    private static final HashMap<String, CMapUniCid> cacheUniCid = new HashMap<>();
    private static final HashMap<String, CMapCidUni> cacheCidUni = new HashMap<>();
    private static final HashMap<String, CMapCidByte> cacheCidByte = new HashMap<>();
    private static final HashMap<String, CMapByteCid> cacheByteCid = new HashMap<>();

    public static CMapUniCid getCachedCMapUniCid(String str) throws IOException {
        CMapUniCid cMapUniCid;
        synchronized (cacheUniCid) {
            cMapUniCid = cacheUniCid.get(str);
        }
        if (cMapUniCid == null) {
            cMapUniCid = new CMapUniCid();
            CMapParserEx.parseCid(str, cMapUniCid, new CidResource());
            synchronized (cacheUniCid) {
                cacheUniCid.put(str, cMapUniCid);
            }
        }
        return cMapUniCid;
    }

    public static CMapCidUni getCachedCMapCidUni(String str) throws IOException {
        CMapCidUni cMapCidUni;
        synchronized (cacheCidUni) {
            cMapCidUni = cacheCidUni.get(str);
        }
        if (cMapCidUni == null) {
            cMapCidUni = new CMapCidUni();
            CMapParserEx.parseCid(str, cMapCidUni, new CidResource());
            synchronized (cacheCidUni) {
                cacheCidUni.put(str, cMapCidUni);
            }
        }
        return cMapCidUni;
    }

    public static CMapCidByte getCachedCMapCidByte(String str) throws IOException {
        CMapCidByte cMapCidByte;
        synchronized (cacheCidByte) {
            cMapCidByte = cacheCidByte.get(str);
        }
        if (cMapCidByte == null) {
            cMapCidByte = new CMapCidByte();
            CMapParserEx.parseCid(str, cMapCidByte, new CidResource());
            synchronized (cacheCidByte) {
                cacheCidByte.put(str, cMapCidByte);
            }
        }
        return cMapCidByte;
    }

    public static CMapByteCid getCachedCMapByteCid(String str) throws IOException {
        CMapByteCid cMapByteCid;
        synchronized (cacheByteCid) {
            cMapByteCid = cacheByteCid.get(str);
        }
        if (cMapByteCid == null) {
            cMapByteCid = new CMapByteCid();
            CMapParserEx.parseCid(str, cMapByteCid, new CidResource());
            synchronized (cacheByteCid) {
                cacheByteCid.put(str, cMapByteCid);
            }
        }
        return cMapByteCid;
    }
}
