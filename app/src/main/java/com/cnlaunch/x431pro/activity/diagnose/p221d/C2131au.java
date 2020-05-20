package com.cnlaunch.x431pro.activity.diagnose.p221d;

import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p220c.GridGraphPage;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.SingleLargeGraph;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import java.util.List;

/* compiled from: GraphGridFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.au */
/* loaded from: classes.dex */
final class C2131au implements GridGraphPage.InterfaceC2097a {

    /* renamed from: a */
    final /* synthetic */ GraphGridFragment f12054a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2131au(GraphGridFragment graphGridFragment) {
        this.f12054a = graphGridFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.GridGraphPage.InterfaceC2097a
    /* renamed from: a */
    public final void mo6319a(int i, int i2, List<BasicDataStreamBean> list) {
        String str;
        SingleLargeGraph singleLargeGraph;
        ICallKeyDownFragment iCallKeyDownFragment;
        SingleLargeGraph singleLargeGraph2;
        long j;
        SerializableMap serializableMap;
        SingleLargeGraph singleLargeGraph3;
        ICallKeyDownFragment iCallKeyDownFragment2;
        str = this.f12054a.f12049v;
        int i3 = !str.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) ? i + i2 : i2;
        String trim = list.get(0).getUnit().trim();
        singleLargeGraph = this.f12054a.f12035e;
        singleLargeGraph.m7341a(i3, GraphConfiguration.m5384a(i2), !trim.isEmpty());
        GraphGridFragment.m7231c(this.f12054a);
        int i4 = !trim.isEmpty() ? DataStreamShowFragment.f11880a : DataStreamShowFragment.f11885m;
        iCallKeyDownFragment = this.f12054a.f12047t;
        if (iCallKeyDownFragment != null) {
            iCallKeyDownFragment2 = this.f12054a.f12047t;
            iCallKeyDownFragment2.mo6304a(i4, null);
        }
        singleLargeGraph2 = this.f12054a.f12035e;
        j = this.f12054a.f12027D;
        serializableMap = this.f12054a.f12052y;
        singleLargeGraph2.m7338a(list, j, serializableMap);
        singleLargeGraph3 = this.f12054a.f12035e;
        singleLargeGraph3.m7336b();
        GraphGridFragment.m7232c();
    }
}
