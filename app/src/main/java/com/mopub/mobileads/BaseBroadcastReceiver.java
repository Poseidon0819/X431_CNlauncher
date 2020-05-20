package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p012v4.content.LocalBroadcastManager;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final long f20301a;

    /* renamed from: b */
    private Context f20302b;

    public abstract IntentFilter getIntentFilter();

    public BaseBroadcastReceiver(long j) {
        this.f20301a = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2454a(Context context, long j, String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "action cannot be null");
        Intent intent = new Intent(str);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        LocalBroadcastManager.m14897a(context.getApplicationContext()).m14896a(intent);
    }

    public void register(BroadcastReceiver broadcastReceiver, Context context) {
        this.f20302b = context;
        LocalBroadcastManager m14897a = LocalBroadcastManager.m14897a(this.f20302b);
        IntentFilter intentFilter = getIntentFilter();
        synchronized (m14897a.f488a) {
            LocalBroadcastManager.C0127b c0127b = new LocalBroadcastManager.C0127b(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = m14897a.f488a.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                m14897a.f488a.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<LocalBroadcastManager.C0127b> arrayList2 = m14897a.f489b.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    m14897a.f489b.put(action, arrayList2);
                }
                arrayList2.add(c0127b);
            }
        }
    }

    public void unregister(BroadcastReceiver broadcastReceiver) {
        Context context = this.f20302b;
        if (context == null || broadcastReceiver == null) {
            return;
        }
        LocalBroadcastManager m14897a = LocalBroadcastManager.m14897a(context);
        synchronized (m14897a.f488a) {
            ArrayList<IntentFilter> remove = m14897a.f488a.remove(broadcastReceiver);
            if (remove != null) {
                for (int i = 0; i < remove.size(); i++) {
                    IntentFilter intentFilter = remove.get(i);
                    for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                        String action = intentFilter.getAction(i2);
                        ArrayList<LocalBroadcastManager.C0127b> arrayList = m14897a.f489b.get(action);
                        if (arrayList != null) {
                            int i3 = 0;
                            while (i3 < arrayList.size()) {
                                if (arrayList.get(i3).f496b == broadcastReceiver) {
                                    arrayList.remove(i3);
                                    i3--;
                                }
                                i3++;
                            }
                            if (arrayList.size() <= 0) {
                                m14897a.f489b.remove(action);
                            }
                        }
                    }
                }
            }
        }
        this.f20302b = null;
    }

    public boolean shouldConsumeBroadcast(Intent intent) {
        Preconditions.checkNotNull(intent, "intent cannot be null");
        return this.f20301a == intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1L);
    }
}
