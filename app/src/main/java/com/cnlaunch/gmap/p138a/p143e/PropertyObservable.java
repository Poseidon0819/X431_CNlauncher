package com.cnlaunch.gmap.p138a.p143e;

import com.cnlaunch.x431pro.activity.GDApplication;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.cnlaunch.gmap.a.e.c */
/* loaded from: classes.dex */
public class PropertyObservable {

    /* renamed from: a */
    public MultiHashMap<Integer, PropertyListener> f7451a = new MultiHashMap<>();

    /* renamed from: a */
    public final synchronized void m9352a(PropertyListener propertyListener) {
        if (propertyListener == null) {
            return;
        }
        MultiHashMap<Integer, PropertyListener> multiHashMap = this.f7451a;
        ArrayList<PropertyListener> arrayList = multiHashMap.f7450a.get(21);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            multiHashMap.f7450a.put(21, arrayList);
        }
        if (!arrayList.contains(propertyListener)) {
            arrayList.add(propertyListener);
        }
    }

    /* renamed from: b */
    public final synchronized void m9349b(PropertyListener propertyListener) {
        if (propertyListener == null) {
            return;
        }
        for (Map.Entry<Integer, ArrayList<PropertyListener>> entry : this.f7451a.f7450a.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().remove(propertyListener);
            }
        }
    }

    /* renamed from: a */
    private void m9351a(Object obj, Object... objArr) {
        synchronized (this) {
            ArrayList<PropertyListener> m9353a = this.f7451a.m9353a(21);
            if (m9353a == null) {
                return;
            }
            int size = m9353a.size();
            PropertyListener[] propertyListenerArr = new PropertyListener[size];
            m9353a.toArray(propertyListenerArr);
            for (int i = 0; i < size; i++) {
                PropertyListener propertyListener = propertyListenerArr[i];
                if (propertyListener != null) {
                    try {
                        GDApplication.f10695c.post(new RunnableC1511d(this, propertyListener, obj, objArr));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m9350a(Object... objArr) {
        if (objArr.length > 0) {
            m9351a(this, objArr);
        } else {
            m9351a(this, new Object[0]);
        }
    }
}
