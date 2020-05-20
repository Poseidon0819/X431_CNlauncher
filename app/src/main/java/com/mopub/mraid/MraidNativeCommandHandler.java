package com.mopub.mraid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.cnlaunch.p181j.ExplainResult;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Intents;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class MraidNativeCommandHandler {
    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";

    /* renamed from: a */
    private static final String[] f20694a = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$c */
    /* loaded from: classes.dex */
    public interface InterfaceC3811c {
        void onFailure(MraidCommandException mraidCommandException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2219a(Context context, Map<String, String> map) throws MraidCommandException {
        if (!m2215c(context)) {
            MoPubLog.m2498d("unsupported action createCalendarEvent for devices pre-ICS");
            throw new MraidCommandException("Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
        }
        try {
            HashMap hashMap = new HashMap();
            if (!map.containsKey("description") || !map.containsKey(ExplainResult.START)) {
                throw new IllegalArgumentException("Missing start and description fields");
            }
            hashMap.put("title", map.get("description"));
            if (map.containsKey(ExplainResult.START) && map.get(ExplainResult.START) != null) {
                Date m2218a = m2218a(map.get(ExplainResult.START));
                if (m2218a != null) {
                    hashMap.put("beginTime", Long.valueOf(m2218a.getTime()));
                    if (map.containsKey("end") && map.get("end") != null) {
                        Date m2218a2 = m2218a(map.get("end"));
                        if (m2218a2 != null) {
                            hashMap.put("endTime", Long.valueOf(m2218a2.getTime()));
                        } else {
                            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                        }
                    }
                    if (map.containsKey("location")) {
                        hashMap.put("eventLocation", map.get("location"));
                    }
                    if (map.containsKey("summary")) {
                        hashMap.put("description", map.get("summary"));
                    }
                    if (map.containsKey("transparency")) {
                        hashMap.put("availability", Integer.valueOf(map.get("transparency").equals("transparent") ? 1 : 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    if (map.containsKey("frequency")) {
                        String str = map.get("frequency");
                        int parseInt = map.containsKey("interval") ? Integer.parseInt(map.get("interval")) : -1;
                        if ("daily".equals(str)) {
                            sb.append("FREQ=DAILY;");
                            if (parseInt != -1) {
                                sb.append("INTERVAL=" + parseInt + ";");
                            }
                        } else if ("weekly".equals(str)) {
                            sb.append("FREQ=WEEKLY;");
                            if (parseInt != -1) {
                                sb.append("INTERVAL=" + parseInt + ";");
                            }
                            if (map.containsKey("daysInWeek")) {
                                String m2216b = m2216b(map.get("daysInWeek"));
                                if (m2216b == null) {
                                    throw new IllegalArgumentException("invalid ");
                                }
                                sb.append("BYDAY=" + m2216b + ";");
                            }
                        } else if ("monthly".equals(str)) {
                            sb.append("FREQ=MONTHLY;");
                            if (parseInt != -1) {
                                sb.append("INTERVAL=" + parseInt + ";");
                            }
                            if (map.containsKey("daysInMonth")) {
                                String m2214c = m2214c(map.get("daysInMonth"));
                                if (m2214c == null) {
                                    throw new IllegalArgumentException();
                                }
                                sb.append("BYMONTHDAY=" + m2214c + ";");
                            }
                        } else {
                            throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                        }
                    }
                    hashMap.put("rrule", sb.toString());
                    Intent type = new Intent("android.intent.action.INSERT").setType(ANDROID_CALENDAR_CONTENT_TYPE);
                    for (String str2 : hashMap.keySet()) {
                        Object obj = hashMap.get(str2);
                        if (obj instanceof Long) {
                            type.putExtra(str2, ((Long) obj).longValue());
                        } else if (obj instanceof Integer) {
                            type.putExtra(str2, ((Integer) obj).intValue());
                        } else {
                            type.putExtra(str2, (String) obj);
                        }
                    }
                    type.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                    context.startActivity(type);
                    return;
                }
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        } catch (ActivityNotFoundException unused) {
            MoPubLog.m2498d("no calendar app installed");
            throw new MraidCommandException("Action is unsupported on this device - no calendar app installed");
        } catch (IllegalArgumentException e) {
            MoPubLog.m2498d("create calendar: invalid parameters " + e.getMessage());
            throw new MraidCommandException(e);
        } catch (Exception e2) {
            MoPubLog.m2498d("could not create calendar event");
            throw new MraidCommandException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m2221a(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return Intents.deviceCanHandleIntent(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m2217b(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return Intents.deviceCanHandleIntent(context, intent);
    }

    public static boolean isStorePictureSupported(Context context) {
        return "mounted".equals(Environment.getExternalStorageState()) && DeviceUtils.isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static boolean m2215c(Context context) {
        return VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH) && Intents.deviceCanHandleIntent(context, new Intent("android.intent.action.INSERT").setType(ANDROID_CALENDAR_CONTENT_TYPE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    /* renamed from: a */
    public static boolean m2222a(Activity activity, View view) {
        if (VersionCode.currentApiLevel().isBelow(VersionCode.HONEYCOMB_MR1)) {
            return false;
        }
        while (view.isHardwareAccelerated() && !Utils.bitMaskContainsFlag(view.getLayerType(), 1)) {
            if (view.getParent() instanceof View) {
                view = (View) view.getParent();
            } else {
                Window window = activity.getWindow();
                return window != null && Utils.bitMaskContainsFlag(window.getAttributes().flags, 16777216);
            }
        }
        return false;
    }

    /* renamed from: a */
    private static Date m2218a(String str) {
        Date date = null;
        for (String str2 : f20694a) {
            try {
                date = new SimpleDateFormat(str2, Locale.US).parse(str);
            } catch (ParseException unused) {
            }
            if (date != null) {
                break;
            }
        }
        return date;
    }

    /* renamed from: b */
    private static String m2216b(String str) throws IllegalArgumentException {
        String str2;
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] split = str.split(",");
        for (String str3 : split) {
            int parseInt = Integer.parseInt(str3);
            if (parseInt == 7) {
                parseInt = 0;
            }
            if (!zArr[parseInt]) {
                StringBuilder sb2 = new StringBuilder();
                switch (parseInt) {
                    case 0:
                        str2 = "SU";
                        break;
                    case 1:
                        str2 = "MO";
                        break;
                    case 2:
                        str2 = "TU";
                        break;
                    case 3:
                        str2 = "WE";
                        break;
                    case 4:
                        str2 = "TH";
                        break;
                    case 5:
                        str2 = "FR";
                        break;
                    case 6:
                        str2 = "SA";
                        break;
                    default:
                        throw new IllegalArgumentException("invalid day of week ".concat(String.valueOf(parseInt)));
                }
                sb2.append(str2);
                sb2.append(",");
                sb.append(sb2.toString());
                zArr[parseInt] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* renamed from: c */
    private static String m2214c(String str) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] split = str.split(",");
        for (String str2 : split) {
            int parseInt = Integer.parseInt(str2);
            int i = parseInt + 31;
            if (!zArr[i]) {
                StringBuilder sb2 = new StringBuilder();
                if (parseInt != 0 && parseInt >= -31 && parseInt <= 31) {
                    sb2.append(String.valueOf(parseInt));
                    sb2.append(",");
                    sb.append(sb2.toString());
                    zArr[i] = true;
                } else {
                    throw new IllegalArgumentException("invalid day of month ".concat(String.valueOf(parseInt)));
                }
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2220a(Context context, String str, InterfaceC3811c interfaceC3811c) {
        AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC3808a(context, new C3836w(this, context, interfaceC3811c)), str);
    }

    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$a */
    /* loaded from: classes.dex */
    static class AsyncTaskC3808a extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a */
        private final Context f20695a;

        /* renamed from: b */
        private final InterfaceC3809a f20696b;

        /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$a$a */
        /* loaded from: classes.dex */
        interface InterfaceC3809a {
            void onFailure();

            void onSuccess();
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Boolean bool) {
            Boolean bool2 = bool;
            if (bool2 != null && bool2.booleanValue()) {
                this.f20696b.onSuccess();
            } else {
                this.f20696b.onFailure();
            }
        }

        public AsyncTaskC3808a(Context context, InterfaceC3809a interfaceC3809a) {
            this.f20695a = context.getApplicationContext();
            this.f20696b = interfaceC3809a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v16, types: [java.io.OutputStream, java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r8v19 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v8 */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(String[] strArr) {
            BufferedInputStream bufferedInputStream;
            ?? r8;
            Throwable th;
            Boolean bool;
            Closeable closeable;
            File file;
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                return Boolean.FALSE;
            }
            File file2 = new File(Environment.getExternalStorageDirectory(), "Pictures");
            file2.mkdirs();
            String str = strArr[0];
            URI create = URI.create(str);
            BufferedInputStream bufferedInputStream2 = null;
            try {
                HttpURLConnection httpUrlConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
                bufferedInputStream = new BufferedInputStream(httpUrlConnection.getInputStream());
                try {
                    String headerField = httpUrlConnection.getHeaderField(ResponseHeader.LOCATION.getKey());
                    if (!TextUtils.isEmpty(headerField)) {
                        create = URI.create(headerField);
                    }
                    file = new File(file2, m2213a(create, httpUrlConnection.getHeaderFields()));
                    r8 = new FileOutputStream(file);
                } catch (Exception unused) {
                    r8 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(bufferedInputStream2);
                    throw th;
                }
                try {
                    Streams.copyContent(bufferedInputStream, r8);
                    C3810b c3810b = new C3810b(file.toString(), (byte) 0);
                    MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(this.f20695a, c3810b);
                    c3810b.f20699c = mediaScannerConnection;
                    mediaScannerConnection.connect();
                    bool = Boolean.TRUE;
                    Streams.closeStream(bufferedInputStream);
                    closeable = r8;
                } catch (Exception unused2) {
                    bufferedInputStream2 = bufferedInputStream;
                    r8 = r8;
                    try {
                        bool = Boolean.FALSE;
                        Streams.closeStream(bufferedInputStream2);
                        closeable = r8;
                        Streams.closeStream(closeable);
                        return bool;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = bufferedInputStream2;
                        bufferedInputStream2 = r8;
                        th = th;
                        Streams.closeStream(bufferedInputStream);
                        Streams.closeStream(bufferedInputStream2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream2 = r8;
                    th = th;
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(bufferedInputStream2);
                    throw th;
                }
            } catch (Exception unused3) {
                r8 = 0;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
            }
            Streams.closeStream(closeable);
            return bool;
        }

        /* renamed from: a */
        private static String m2213a(URI uri, Map<String, List<String>> map) {
            Preconditions.checkNotNull(uri);
            String path = uri.getPath();
            if (path == null || map == null) {
                return null;
            }
            String name = new File(path).getName();
            List<String> list = map.get(HttpHeaders.CONTENT_TYPE);
            if (list != null && !list.isEmpty()) {
                if (list.get(0) != null) {
                    for (String str : list.get(0).split(";")) {
                        if (str.contains("image/")) {
                            String str2 = "." + str.split("/")[1];
                            if (name.endsWith(str2)) {
                                return name;
                            }
                            return name + str2;
                        }
                    }
                    return name;
                }
            }
            return name;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mraid.MraidNativeCommandHandler$b */
    /* loaded from: classes.dex */
    public static class C3810b implements MediaScannerConnection.MediaScannerConnectionClient {

        /* renamed from: a */
        private final String f20697a;

        /* renamed from: b */
        private final String f20698b;

        /* renamed from: c */
        private MediaScannerConnection f20699c;

        /* synthetic */ C3810b(String str, byte b) {
            this(str);
        }

        private C3810b(String str) {
            this.f20697a = str;
            this.f20698b = null;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public final void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.f20699c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.f20697a, this.f20698b);
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public final void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.f20699c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }
}
