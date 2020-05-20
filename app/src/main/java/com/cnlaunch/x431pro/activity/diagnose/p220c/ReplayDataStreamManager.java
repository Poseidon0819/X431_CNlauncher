package com.cnlaunch.x431pro.activity.diagnose.p220c;

import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.s */
/* loaded from: classes.dex */
public abstract class ReplayDataStreamManager implements DataStreamPageObserver {

    /* renamed from: b */
    public static ReplayDataStreamManager f11779b;

    /* renamed from: c */
    protected long f11781c;

    /* renamed from: d */
    protected List<BasicDataStreamBean> f11782d;

    /* renamed from: f */
    protected List<ArrayList<BasicDataStreamBean>> f11784f;

    /* renamed from: h */
    private int f11786h;

    /* renamed from: i */
    private int f11787i;

    /* renamed from: j */
    private int f11788j;

    /* renamed from: a */
    public boolean f11780a = false;

    /* renamed from: e */
    protected List<BasicDataStreamBean> f11783e = null;

    /* renamed from: g */
    protected List<DataStreamObserver> f11785g = new ArrayList(3);

    /* renamed from: k */
    private String f11789k = "";

    /* renamed from: l */
    private boolean f11790l = false;

    /* renamed from: a */
    abstract void mo7329a();

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamPageObserver
    /* renamed from: a */
    public final void mo7357a(int i, int i2) {
        this.f11788j = i2;
        this.f11787i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReplayDataStreamManager(List<ArrayList<BasicDataStreamBean>> list) {
        this.f11781c = 0L;
        f11779b = this;
        this.f11784f = list;
        this.f11781c = 0L;
    }

    /* renamed from: a */
    public final synchronized boolean m7356a(DataStreamObserver dataStreamObserver) {
        if (this.f11785g.contains(dataStreamObserver)) {
            return false;
        }
        if (this.f11784f.size() > 0) {
            dataStreamObserver.mo6296a(this.f11781c, this.f11784f, this.f11782d, null);
        }
        return this.f11785g.add(dataStreamObserver);
    }

    /* renamed from: b */
    public final synchronized boolean m7351b(DataStreamObserver dataStreamObserver) {
        return this.f11785g.remove(dataStreamObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m7352b() {
        synchronized (this.f11784f) {
            for (DataStreamObserver dataStreamObserver : this.f11785g) {
                dataStreamObserver.mo6296a(this.f11781c, this.f11784f, this.f11782d, null);
                if (this.f11780a && this.f11783e != null && this.f11783e.size() > 0) {
                    dataStreamObserver.mo6301a(this.f11783e);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m7354a(List<ArrayList<BasicDataStreamBean>> list, long j) {
        this.f11784f.clear();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<BasicDataStreamBean> arrayList = list.get(i);
            synchronized (this.f11784f) {
                if (m7350b(arrayList)) {
                    m7348c(arrayList);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ArrayList<BasicDataStreamBean> arrayList2 = this.f11784f.get(i2);
                        arrayList2.add(arrayList.get(i2));
                        if (arrayList2.size() > GraphConfiguration.m5385a()) {
                            arrayList2.remove(0);
                        }
                    }
                }
            }
        }
        if (list.size() > 0) {
            this.f11782d = list.get(list.size() - 1);
        }
        this.f11781c = j;
        mo7329a();
    }

    /* renamed from: a */
    public final void m7355a(List<BasicDataStreamBean> list) {
        synchronized (this.f11784f) {
            NLog.m9456a("DataStreamManager", "Change DS Page addDataStreamItem <---");
            if (m7350b(list)) {
                this.f11782d = list;
                m7348c(list);
                for (int i = 0; i < list.size(); i++) {
                    ArrayList<BasicDataStreamBean> arrayList = this.f11784f.get(i);
                    arrayList.add(list.get(i));
                    if (arrayList.size() > GraphConfiguration.m5385a()) {
                        arrayList.remove(0);
                    }
                }
                mo7329a();
                this.f11781c++;
            }
        }
    }

    /* renamed from: a */
    public final void m7353a(List<BasicDataStreamBean> list, List<BasicDataStreamBean> list2) {
        synchronized (this.f11784f) {
            if (list != null && list2 != null) {
                if (list.size() > 0 && list2.size() > 0) {
                    if (this.f11784f == null) {
                        this.f11784f = new ArrayList();
                    }
                    if (m7350b(list)) {
                        if (this.f11784f.size() <= 0) {
                            this.f11784f.add((ArrayList) list);
                        }
                        this.f11782d = list;
                        if (this.f11780a) {
                            this.f11783e = list2;
                        } else {
                            m7348c(list);
                            for (int i = 0; i < list.size(); i++) {
                                ArrayList<BasicDataStreamBean> arrayList = this.f11784f.get(i);
                                arrayList.add(list.get(i));
                                if (arrayList.size() > GraphConfiguration.m5385a()) {
                                    arrayList.remove(0);
                                }
                            }
                        }
                        mo7329a();
                        this.f11781c++;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m7350b(List<BasicDataStreamBean> list) {
        if (this.f11790l) {
            String str = this.f11789k;
            if (str != null && str.equals(list.get(0).getTitle())) {
                NLog.m9456a("DataStreamManager", "Change DS Page title is the same");
                return false;
            }
            this.f11789k = "";
            this.f11790l = false;
            return true;
        }
        return true;
    }

    /* renamed from: c */
    private void m7348c(List<BasicDataStreamBean> list) {
        if (m7346d(list)) {
            this.f11784f.clear();
            this.f11781c = 0L;
            for (int i = 0; i < list.size(); i++) {
                this.f11784f.add(new ArrayList<>());
            }
        }
    }

    /* renamed from: d */
    private boolean m7346d(List<BasicDataStreamBean> list) {
        if (this.f11784f.size() == 0) {
            NLog.m9451c("DataStreamManager", "The mDataStream data size is 0 !!!");
            return true;
        } else if (list.size() != this.f11784f.size()) {
            NLog.m9451c("DataStreamManager", "The data size is not the same!!!");
            return true;
        } else if (this.f11784f.get(0).size() == 0) {
            NLog.m9451c("DataStreamManager", "The mDataStream.get(0) size is 0!!!");
            return true;
        } else if (list.get(0).getTitle().equals(this.f11784f.get(0).get(0).getTitle())) {
            return false;
        } else {
            NLog.m9451c("DataStreamManager", "The data title is not the same of the old data!!!");
            NLog.m9451c("DataStreamManager", "dsItem.get(0).getTitle() = " + list.get(0).getTitle() + ", mDataStream.get(0).get(0).getTitle()" + this.f11784f.get(0).get(0).getTitle());
            return true;
        }
    }

    /* renamed from: c */
    public final void m7349c() {
        synchronized (this.f11784f) {
            this.f11785g.clear();
            this.f11784f.clear();
            this.f11781c = 0L;
            this.f11782d = null;
        }
    }

    /* renamed from: d */
    public final void m7347d() {
        synchronized (this.f11784f) {
            if (this.f11784f.size() > 0 && this.f11784f.get(0).size() > 0) {
                this.f11789k = this.f11784f.get(0).get(0).getTitle();
            }
            for (ArrayList<BasicDataStreamBean> arrayList : this.f11784f) {
                arrayList.clear();
            }
            this.f11781c = 0L;
            this.f11782d = null;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamPageObserver
    /* renamed from: a */
    public final void mo7358a(int i) {
        this.f11786h = i;
    }
}
