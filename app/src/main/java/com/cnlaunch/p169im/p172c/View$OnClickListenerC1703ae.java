package com.cnlaunch.p169im.p172c;

import android.content.Context;
import android.view.View;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p174db.VerificationInfoDao;
import com.cnlaunch.x431pro.module.golo.model.VerificationInfo;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.List;

/* compiled from: VerificationFragment.java */
/* renamed from: com.cnlaunch.im.c.ae */
/* loaded from: classes.dex */
final class View$OnClickListenerC1703ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VerificationFragment f9079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1703ae(VerificationFragment verificationFragment) {
        this.f9079a = verificationFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        context = this.f9079a.mContext;
        String m9591a = PreferencesManager.m9595a(context).m9591a("user_id");
        GoloDBManager m8756a = GoloDBManager.m8756a(this.f9079a.getActivity());
        QueryBuilder<VerificationInfo> queryBuilder = m8756a.f9220b.f9227d.queryBuilder();
        queryBuilder.where(VerificationInfoDao.Properties.Bind_ID.m321eq(m9591a), new WhereCondition[0]);
        List<VerificationInfo> list = queryBuilder.list();
        if (list != null && list.size() > 0) {
            m8756a.f9220b.f9227d.deleteInTx(list);
        }
        this.f9079a.request(40026);
        context2 = this.f9079a.mContext;
        NoticeMessageHandler.m8784a(context2).m8779a("-999");
    }
}
