package com.cnlaunch.x431pro.activity.diagnose.p220c;

import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.i */
/* loaded from: classes.dex */
public abstract class DataStreamManager implements DataStreamPageObserver {

    /* renamed from: b */
    public static DataStreamManager f11739b;

    /* renamed from: c */
    protected long f11741c;

    /* renamed from: d */
    protected List<BasicDataStreamBean> f11742d;

    /* renamed from: f */
    protected List<ArrayList<BasicDataStreamBean>> f11744f;

    /* renamed from: h */
    public int f11746h;

    /* renamed from: i */
    public int f11747i;

    /* renamed from: j */
    public int f11748j;

    /* renamed from: k */
    public String f11749k;

    /* renamed from: l */
    protected SerializableMap f11750l;

    /* renamed from: a */
    public boolean f11740a = false;

    /* renamed from: e */
    protected List<BasicDataStreamBean> f11743e = null;

    /* renamed from: g */
    protected List<DataStreamObserver> f11745g = new ArrayList(3);

    /* renamed from: m */
    private String f11751m = "";

    /* renamed from: n */
    private boolean f11752n = false;

    /* renamed from: a */
    abstract void mo7330a();

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamPageObserver
    /* renamed from: a */
    public final void mo7357a(int i, int i2) {
        this.f11748j = i2;
        this.f11747i = i;
    }

    /* renamed from: a */
    public final void m7388a(SerializableMap serializableMap) {
        this.f11750l = serializableMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DataStreamManager(List<ArrayList<BasicDataStreamBean>> list) {
        this.f11741c = 0L;
        f11739b = this;
        this.f11744f = list;
        this.f11741c = 0L;
    }

    /* renamed from: a */
    public final synchronized boolean m7389a(DataStreamObserver dataStreamObserver) {
        if (this.f11745g.contains(dataStreamObserver)) {
            return false;
        }
        if (this.f11744f.size() > 0) {
            dataStreamObserver.mo6296a(this.f11741c, this.f11744f, this.f11742d, this.f11750l);
        }
        return this.f11745g.add(dataStreamObserver);
    }

    /* renamed from: b */
    public final synchronized boolean m7384b(DataStreamObserver dataStreamObserver) {
        return this.f11745g.remove(dataStreamObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m7385b() {
        synchronized (this.f11744f) {
            for (DataStreamObserver dataStreamObserver : this.f11745g) {
                dataStreamObserver.mo6296a(this.f11741c, this.f11744f, this.f11742d, this.f11750l);
                if (this.f11740a && this.f11743e != null && this.f11743e.size() > 0) {
                    dataStreamObserver.mo6301a(this.f11743e);
                }
            }
            if (BaseDataStreamShowingFragment.m7128b()) {
                BaseDataStreamShowingFragment.m7127b(false);
            }
        }
    }

    /* renamed from: a */
    public final void m7387a(List<BasicDataStreamBean> list) {
        synchronized (this.f11744f) {
            if (m7383b(list)) {
                this.f11742d = list;
                m7381c(list);
                for (int i = 0; i < list.size(); i++) {
                    ArrayList<BasicDataStreamBean> arrayList = this.f11744f.get(i);
                    arrayList.add(list.get(i));
                    while (arrayList.size() > GraphConfiguration.m5383b()) {
                        arrayList.remove(0);
                    }
                }
                mo7330a();
                this.f11741c++;
            }
        }
    }

    /* renamed from: a */
    public final void m7386a(List<BasicDataStreamBean> list, List<BasicDataStreamBean> list2) {
        synchronized (this.f11744f) {
            if (list != null && list2 != null) {
                if (list.size() > 0 && list2.size() > 0) {
                    if (this.f11744f == null) {
                        this.f11744f = new ArrayList();
                    }
                    if (m7383b(list)) {
                        if (this.f11744f.size() <= 0) {
                            this.f11744f.add((ArrayList) list);
                        }
                        this.f11742d = list;
                        if (this.f11740a) {
                            this.f11743e = list2;
                        } else {
                            m7381c(list);
                            for (int i = 0; i < list.size(); i++) {
                                ArrayList<BasicDataStreamBean> arrayList = this.f11744f.get(i);
                                arrayList.add(list.get(i));
                                if (arrayList.size() > GraphConfiguration.m5385a()) {
                                    arrayList.remove(0);
                                }
                            }
                        }
                        mo7330a();
                        this.f11741c++;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m7383b(List<BasicDataStreamBean> list) {
        if (this.f11752n) {
            String str = this.f11751m;
            if (str != null && str.equals(list.get(0).getTitle())) {
                NLog.m9456a("DataStreamManager", "Change DS Page title is the same");
                return false;
            }
            this.f11751m = "";
            this.f11752n = false;
            return true;
        }
        return true;
    }

    /* renamed from: c */
    private void m7381c(List<BasicDataStreamBean> list) {
        if (m7379d(list)) {
            this.f11744f.clear();
            BasicDataStreamBean.clearHelpMapInfo();
            this.f11741c = 0L;
            for (int i = 0; i < list.size(); i++) {
                this.f11744f.add(new ArrayList<>());
            }
        }
    }

    /* renamed from: d */
    private boolean m7379d(List<BasicDataStreamBean> list) {
        List<ArrayList<BasicDataStreamBean>> list2;
        if (list == null || list.size() <= 0 || list.get(0) == null || (list2 = this.f11744f) == null || list2.size() <= 0 || this.f11744f.get(0) == null) {
            return true;
        }
        if (this.f11744f.size() == 0) {
            NLog.m9451c("DataStreamManager", "The mDataStream data size is 0 !!!");
            return true;
        } else if (list.size() != this.f11744f.size()) {
            NLog.m9451c("DataStreamManager", "The data size is not the same!!!");
            return true;
        } else if (this.f11744f.get(0).size() == 0) {
            NLog.m9451c("DataStreamManager", "The mDataStream.get(0) size is 0!!!");
            return true;
        } else {
            if (list.size() <= DiagnoseConstants.DATASTREAM_PAGE && this.f11749k.equals("DATASTREAM")) {
                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).getTitle().equals(this.f11744f.get(i).get(0).getTitle()) || !list.get(i).getHelp().equals(this.f11744f.get(i).get(0).getHelp())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: c */
    public final void m7382c() {
        synchronized (this.f11744f) {
            for (ArrayList<BasicDataStreamBean> arrayList : this.f11744f) {
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            this.f11745g.clear();
            this.f11744f.clear();
            BasicDataStreamBean.clearHelpMapInfo();
            this.f11741c = 0L;
            this.f11742d = null;
        }
    }

    /* renamed from: d */
    public final void m7380d() {
        if (this.f11752n) {
            return;
        }
        this.f11752n = true;
        m7378e();
        NLog.m9456a("DataStreamManager", "Change DS Page resetData --->");
    }

    /* renamed from: e */
    public final void m7378e() {
        synchronized (this.f11744f) {
            if (this.f11744f != null && !this.f11744f.isEmpty()) {
                if (this.f11744f.size() > 0 && this.f11744f.get(0) != null && this.f11744f.get(0).size() > 0) {
                    this.f11751m = this.f11744f.get(0).get(0).getTitle();
                }
                for (ArrayList<BasicDataStreamBean> arrayList : this.f11744f) {
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                this.f11741c = 0L;
                this.f11742d = null;
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamPageObserver
    /* renamed from: a */
    public final void mo7358a(int i) {
        this.f11746h = i;
    }
}
