package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.C1154a;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.route.BaiduMapRoutePlan;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.pano.C1325a;
import com.baidu.platform.comapi.pano.C1328b;
import com.baidu.platform.comapi.pano.PanoStateError;
import java.util.List;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class BaiduMapPoiSearch {

    /* renamed from: a */
    private static boolean f5785a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapapi.utils.poi.BaiduMapPoiSearch$2 */
    /* loaded from: classes.dex */
    public /* synthetic */ class C11602 {

        /* renamed from: a */
        static final /* synthetic */ int[] f5787a;

        /* renamed from: b */
        static final /* synthetic */ int[] f5788b = new int[HttpClient.HttpStateError.values().length];

        static {
            try {
                f5788b[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5788b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5787a = new int[PanoStateError.values().length];
            try {
                f5787a[PanoStateError.PANO_UID_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5787a[PanoStateError.PANO_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5787a[PanoStateError.PANO_NO_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5787a[PanoStateError.PANO_NO_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: a */
    private static void m10892a(PoiParaOption poiParaOption, Context context) {
        Uri parse = Uri.parse("http://api.map.baidu.com/place/detail?uid=" + poiParaOption.f5790a + "&output=html&src=" + context.getPackageName());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        intent.setData(parse);
        context.startActivity(intent);
    }

    /* renamed from: b */
    private static void m10890b(PoiParaOption poiParaOption, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("http://api.map.baidu.com/place/search?");
        sb.append("query=");
        sb.append(poiParaOption.f5791b);
        sb.append("&location=");
        LatLng latLng = poiParaOption.f5792c;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            latLng = CoordTrans.gcjToBaidu(latLng);
        }
        sb.append(latLng.latitude);
        sb.append(",");
        sb.append(latLng.longitude);
        sb.append("&radius=");
        sb.append(poiParaOption.f5793d);
        sb.append("&output=html");
        sb.append("&src=");
        sb.append(context.getPackageName());
        Uri parse = Uri.parse(sb.toString());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        intent.setData(parse);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m10889b(String str, Context context) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("pano id can not be null.");
        }
        if (context == null) {
            throw new RuntimeException("context cannot be null.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/streetscape?");
        sb.append("panoid=");
        sb.append(str);
        sb.append("&pid=");
        sb.append(str);
        sb.append("&panotype=street");
        sb.append("&src=");
        sb.append("sdk_[" + context.getPackageName() + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            throw new RuntimeException("BaiduMap app is not installed.");
        }
        context.startActivity(intent);
    }

    public static boolean dispatchPoiToBaiduMap(List<DispathcPoiData> list, Context context) throws Exception {
        String str;
        String str2;
        if (list.isEmpty() || list.size() <= 0) {
            throw new NullPointerException("dispatch poidata is null");
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            str = "baidumapsdk";
            str2 = "BaiduMap app is not installed.";
        } else if (baiduMapVersion >= 840) {
            return C1154a.m10919a(list, context, 6);
        } else {
            str = "baidumapsdk";
            str2 = "Baidumap app version is too lowl.Version is greater than 8.4";
        }
        Log.e(str, str2);
        return false;
    }

    public static void finish(Context context) {
        if (context != null) {
            C1154a.m10927a(context);
        }
    }

    public static void openBaiduMapPanoShow(String str, final Context context) {
        new C1325a().m9927a(str, new C1325a.InterfaceC1327a<C1328b>() { // from class: com.baidu.mapapi.utils.poi.BaiduMapPoiSearch.1
            @Override // com.baidu.platform.comapi.pano.C1325a.InterfaceC1327a
            /* renamed from: a */
            public final void mo9926a(HttpClient.HttpStateError httpStateError) {
                switch (C11602.f5788b[httpStateError.ordinal()]) {
                    case 1:
                        Log.d("baidumapsdk", "current network is not available");
                        return;
                    case 2:
                        Log.d("baidumapsdk", "network inner error, please check network");
                        return;
                    default:
                        return;
                }
            }

            @Override // com.baidu.platform.comapi.pano.C1325a.InterfaceC1327a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public final void mo9925a(C1328b c1328b) {
                String str2;
                String str3;
                if (c1328b == null) {
                    str2 = "baidumapsdk";
                    str3 = "pano info is null";
                } else {
                    switch (C11602.f5787a[c1328b.m9924a().ordinal()]) {
                        case 1:
                            str2 = "baidumapsdk";
                            str3 = "pano uid is error, please check param poi uid";
                            break;
                        case 2:
                            str2 = "baidumapsdk";
                            str3 = "pano id not found for this poi point";
                            break;
                        case 3:
                            str2 = "baidumapsdk";
                            str3 = "please check ak for permission";
                            break;
                        case 4:
                            if (c1328b.m9920c() != 1) {
                                Log.d("baidumapsdk", "this point do not support for pano show");
                                return;
                            }
                            try {
                                BaiduMapPoiSearch.m10889b(c1328b.m9921b(), context);
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        default:
                            return;
                    }
                }
                Log.d(str2, str3);
            }
        });
    }

    public static boolean openBaiduMapPoiDetialsPage(PoiParaOption poiParaOption, Context context) {
        if (poiParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        }
        if (poiParaOption.f5790a != null) {
            if (poiParaOption.f5790a.equals("")) {
                Log.e(BaiduMapRoutePlan.class.getName(), "poi uid can not be empty string");
                return false;
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (f5785a) {
                    m10892a(poiParaOption, context);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return C1154a.m10924a(poiParaOption, context, 3);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (f5785a) {
                    m10892a(poiParaOption, context);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
        throw new IllegalPoiSearchArgumentException("poi uid can not be null.");
    }

    public static boolean openBaiduMapPoiNearbySearch(PoiParaOption poiParaOption, Context context) {
        if (poiParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        }
        if (poiParaOption.f5791b != null) {
            if (poiParaOption.f5792c != null) {
                if (poiParaOption.f5792c.longitude == 0.0d || poiParaOption.f5792c.latitude == 0.0d) {
                    throw new IllegalPoiSearchArgumentException("poi search center longitude or latitude can not be 0.");
                }
                if (poiParaOption.f5793d != 0) {
                    if (poiParaOption.f5791b.equals("")) {
                        Log.e(BaiduMapRoutePlan.class.getName(), "poi key can not be empty string");
                        return false;
                    }
                    int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                    if (baiduMapVersion == 0) {
                        Log.e("baidumapsdk", "BaiduMap app is not installed.");
                        if (f5785a) {
                            m10890b(poiParaOption, context);
                            return true;
                        }
                        throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
                    } else if (baiduMapVersion >= 810) {
                        return C1154a.m10924a(poiParaOption, context, 4);
                    } else {
                        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                        if (f5785a) {
                            m10890b(poiParaOption, context);
                            return true;
                        }
                        throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
                    }
                }
                throw new IllegalPoiSearchArgumentException("poi search radius larger than 0.");
            }
            throw new IllegalPoiSearchArgumentException("poi search center can not be null.");
        }
        throw new IllegalPoiSearchArgumentException("poi search key can not be null.");
    }

    public static void setSupportWebPoi(boolean z) {
        f5785a = z;
    }
}
