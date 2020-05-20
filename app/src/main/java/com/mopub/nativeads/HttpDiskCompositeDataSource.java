package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p181j.ExplainResult;
import com.google.android.p328a.p339e.DataSource;
import com.google.android.p328a.p339e.DataSpec;
import com.google.android.p328a.p339e.DefaultHttpDataSource;
import com.google.android.p328a.p339e.HttpDataSource;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HttpDiskCompositeDataSource implements DataSource {

    /* renamed from: a */
    private final HttpDataSource f20755a;

    /* renamed from: b */
    private byte[] f20756b;

    /* renamed from: c */
    private String f20757c;

    /* renamed from: d */
    private final TreeSet<IntInterval> f20758d;

    /* renamed from: e */
    private int f20759e;

    /* renamed from: f */
    private int f20760f;

    /* renamed from: g */
    private int f20761g;

    /* renamed from: h */
    private int f20762h;

    /* renamed from: i */
    private boolean f20763i;

    /* renamed from: j */
    private Integer f20764j;

    /* renamed from: k */
    private DataSpec f20765k;

    /* renamed from: l */
    private boolean f20766l;

    /* renamed from: m */
    private final EventDetails f20767m;

    /* renamed from: n */
    private boolean f20768n;

    public HttpDiskCompositeDataSource(Context context, String str, EventDetails eventDetails) {
        this(context, eventDetails, new DefaultHttpDataSource(str));
    }

    @VisibleForTesting
    private HttpDiskCompositeDataSource(Context context, EventDetails eventDetails, HttpDataSource httpDataSource) {
        this.f20764j = null;
        this.f20755a = httpDataSource;
        CacheService.initialize(context);
        this.f20758d = new TreeSet<>();
        this.f20767m = eventDetails;
    }

    @Override // com.google.android.p328a.p339e.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        Preconditions.checkNotNull(dataSpec);
        if (dataSpec.f18404a == null) {
            return -1L;
        }
        this.f20766l = false;
        this.f20765k = dataSpec;
        this.f20757c = dataSpec.f18404a.toString();
        if (this.f20757c == null) {
            return -1L;
        }
        this.f20759e = (int) dataSpec.f18406c;
        this.f20761g = this.f20759e / 512000;
        this.f20756b = CacheService.getFromDiskCache(this.f20761g + this.f20757c);
        this.f20762h = this.f20759e % 512000;
        this.f20760f = 0;
        this.f20764j = m2199a(this.f20757c);
        m2198a(this.f20757c, this.f20758d);
        int m2200a = m2200a(this.f20759e, this.f20758d);
        if (this.f20756b == null) {
            this.f20756b = new byte[512000];
            if (m2200a > this.f20759e) {
                MoPubLog.m2498d("Cache segment " + this.f20761g + " was evicted. Invalidating cache");
                this.f20758d.clear();
                m2200a = (int) dataSpec.f18406c;
            }
        }
        Integer num = this.f20764j;
        if (num != null && m2200a == num.intValue()) {
            return dataSpec.f18408e == -1 ? this.f20764j.intValue() - this.f20759e : dataSpec.f18408e;
        }
        long j = this.f20765k.f18408e == -1 ? -1L : this.f20765k.f18408e - (m2200a - this.f20759e);
        try {
            long open = this.f20755a.open(new DataSpec(dataSpec.f18404a, m2200a, j, dataSpec.f18409f, dataSpec.f18410g));
            if (this.f20764j == null && j == -1) {
                this.f20764j = Integer.valueOf((int) (this.f20759e + open));
                CacheService.putToDiskCache("expectedsize-" + this.f20757c, String.valueOf(this.f20764j).getBytes());
            }
            this.f20763i = true;
            if (!this.f20768n) {
                MoPubEvents.log(Event.createEventFromDetails(BaseEvent.Name.DOWNLOAD_START, BaseEvent.Category.NATIVE_VIDEO, BaseEvent.SamplingRate.NATIVE_VIDEO, this.f20767m));
                this.f20768n = true;
            }
            return open;
        } catch (HttpDataSource.C3147c e) {
            if (e.responseCode == 416) {
                Integer num2 = this.f20764j;
                long intValue = num2 == null ? m2200a - this.f20759e : num2.intValue() - this.f20759e;
                this.f20763i = false;
                return intValue;
            }
            throw e;
        }
    }

    /* renamed from: a */
    private static void m2198a(String str, TreeSet<IntInterval> treeSet) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(treeSet);
        treeSet.clear();
        byte[] fromDiskCache = CacheService.getFromDiskCache("intervals-sorted-".concat(String.valueOf(str)));
        if (fromDiskCache != null) {
            try {
                JSONArray jSONArray = new JSONArray(new String(fromDiskCache));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = new JSONObject((String) jSONArray.get(i));
                    treeSet.add(new IntInterval(jSONObject.getInt(ExplainResult.START), jSONObject.getInt("length")));
                }
            } catch (ClassCastException unused) {
                MoPubLog.m2498d("clearing cache since unable to read json data");
                treeSet.clear();
            } catch (JSONException e) {
                MoPubLog.m2497d("clearing cache since invalid json intervals found", e);
                treeSet.clear();
            }
        }
    }

    /* renamed from: a */
    private static Integer m2199a(String str) {
        Preconditions.checkNotNull(str);
        byte[] fromDiskCache = CacheService.getFromDiskCache("expectedsize-".concat(String.valueOf(str)));
        if (fromDiskCache != null) {
            try {
                return Integer.valueOf(Integer.parseInt(new String(fromDiskCache)));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.p328a.p339e.DataSource
    public void close() throws IOException {
        if (!TextUtils.isEmpty(this.f20757c) && this.f20756b != null) {
            CacheService.putToDiskCache(this.f20761g + this.f20757c, this.f20756b);
            m2197a(this.f20758d, this.f20759e, this.f20760f);
            m2196a(this.f20758d, this.f20757c);
            if (this.f20766l && this.f20764j != null && m2200a(0, this.f20758d) == this.f20764j.intValue()) {
                MoPubEvents.log(Event.createEventFromDetails(BaseEvent.Name.DOWNLOAD_FINISHED, BaseEvent.Category.NATIVE_VIDEO, BaseEvent.SamplingRate.NATIVE_VIDEO, this.f20767m));
            }
        }
        this.f20756b = null;
        this.f20755a.close();
        this.f20763i = false;
        this.f20759e = 0;
        this.f20760f = 0;
        this.f20762h = 0;
        this.f20764j = null;
        this.f20766l = false;
    }

    /* renamed from: a */
    private static void m2196a(TreeSet<IntInterval> treeSet, String str) {
        Preconditions.checkNotNull(treeSet);
        Preconditions.checkNotNull(str);
        JSONArray jSONArray = new JSONArray();
        Iterator<IntInterval> it = treeSet.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        CacheService.putToDiskCache("intervals-sorted-".concat(String.valueOf(str)), jSONArray.toString().getBytes());
    }

    @Override // com.google.android.p328a.p339e.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 512000) {
            MoPubLog.m2498d("Reading more than the block size (512000 bytes) at once is not possible. length = ".concat(String.valueOf(i2)));
            return -1;
        } else if (this.f20765k == null) {
            MoPubLog.m2498d("Unable to read from data source when no spec provided");
            return -1;
        } else if (this.f20756b == null) {
            MoPubLog.m2498d("No cache set up. Call open before read.");
            return -1;
        } else {
            int i3 = this.f20760f;
            int i4 = (512000 - this.f20762h) - i3;
            int m2200a = m2200a(this.f20759e + i3, this.f20758d);
            int min = Math.min((m2200a - this.f20759e) - this.f20760f, i2);
            if (!(m2200a > this.f20759e + this.f20760f)) {
                min = 0;
            } else if (min <= i4) {
                System.arraycopy(this.f20756b, this.f20762h + this.f20760f, bArr, i, min);
                this.f20760f += min;
                min += 0;
            } else {
                System.arraycopy(this.f20756b, this.f20762h + this.f20760f, bArr, i, i4);
                this.f20760f += i4;
                int i5 = i4 + 0;
                m2201a();
                this.f20756b = CacheService.getFromDiskCache(this.f20761g + this.f20757c);
                byte[] bArr2 = this.f20756b;
                if (bArr2 == null) {
                    MoPubLog.m2498d("Unexpected cache miss. Invalidating cache");
                    this.f20758d.clear();
                    this.f20756b = new byte[512000];
                    this.f20755a.close();
                    this.f20755a.open(new DataSpec(this.f20765k.f18404a, this.f20759e + this.f20760f, -1L, this.f20765k.f18409f, this.f20765k.f18410g));
                    this.f20763i = true;
                    min = i5;
                } else {
                    int i6 = i + i5;
                    int i7 = min - i5;
                    System.arraycopy(bArr2, this.f20762h + this.f20760f, bArr, i6, i7);
                    this.f20760f += i7;
                }
            }
            int i8 = i2 - min;
            if (i8 <= 0) {
                return min;
            }
            this.f20766l = true;
            if (!this.f20763i) {
                MoPubLog.m2498d("end of cache reached. No http source open");
                return -1;
            }
            int i9 = i + min;
            int read = this.f20755a.read(bArr, i9, i8);
            int i10 = this.f20762h;
            int i11 = this.f20760f;
            int i12 = (512000 - i10) - i11;
            if (i12 < read) {
                System.arraycopy(bArr, i9, this.f20756b, i10 + i11, i12);
                this.f20760f += i12;
                m2201a();
                this.f20756b = CacheService.getFromDiskCache(this.f20761g + this.f20757c);
                if (this.f20756b == null) {
                    this.f20756b = new byte[512000];
                }
                int i13 = read - i12;
                System.arraycopy(bArr, i + i12 + min, this.f20756b, this.f20762h + this.f20760f, i13);
                this.f20760f += i13;
            } else {
                System.arraycopy(bArr, i9, this.f20756b, i10 + i11, read);
                this.f20760f += read;
            }
            return read + min;
        }
    }

    /* renamed from: a */
    private void m2201a() {
        CacheService.putToDiskCache(this.f20761g + this.f20757c, this.f20756b);
        m2197a(this.f20758d, this.f20759e, this.f20760f);
        this.f20762h = 0;
        this.f20759e = this.f20759e + this.f20760f;
        this.f20760f = 0;
        this.f20761g = this.f20759e / 512000;
    }

    @VisibleForTesting
    /* renamed from: a */
    private static int m2200a(int i, TreeSet<IntInterval> treeSet) {
        Preconditions.checkNotNull(treeSet);
        Iterator<IntInterval> it = treeSet.iterator();
        while (it.hasNext()) {
            IntInterval next = it.next();
            if (next.getStart() <= i) {
                i = Math.max(i, next.getStart() + next.getLength());
            }
        }
        return i;
    }

    @VisibleForTesting
    /* renamed from: a */
    private static void m2197a(TreeSet<IntInterval> treeSet, int i, int i2) {
        Preconditions.checkNotNull(treeSet);
        if (m2200a(i, treeSet) >= i + i2) {
            return;
        }
        treeSet.add(new IntInterval(i, i2));
    }
}
