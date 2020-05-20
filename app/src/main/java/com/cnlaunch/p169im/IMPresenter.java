package com.cnlaunch.p169im;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p168i.InterfaceViewController;
import com.cnlaunch.p169im.NetWorkDataModel;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p174db.GoloRemoteOrderInfoDao;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.p169im.p174db.MessageInfoDao;
import com.cnlaunch.p169im.p174db.UserBaseInfoDao;
import com.cnlaunch.p169im.p175e.OnIMDataListener;
import com.cnlaunch.p169im.p175e.OnIMViewListener;
import com.cnlaunch.p169im.p176f.ChatManager;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;
import com.cnlaunch.x431pro.widget.p291b.RunnableC2886b;
import com.cnlaunch.x431pro.widget.p291b.TimerView;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import message.p378a.UnReadMsg;

/* renamed from: com.cnlaunch.im.d */
/* loaded from: classes.dex */
public class IMPresenter implements NetWorkDataModel.InterfaceC1737a {

    /* renamed from: d */
    public static IMPresenter f9179d;

    /* renamed from: a */
    public List<OnIMDataListener> f9180a;

    /* renamed from: b */
    public NetWorkDataModel f9181b;

    /* renamed from: e */
    public Context f9183e;

    /* renamed from: f */
    public List<FriendInfo> f9184f;

    /* renamed from: h */
    private TimerView f9186h;

    /* renamed from: c */
    OnIMViewListener f9182c = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: i */
    private Handler f9187i = new HandlerC1736e(this);

    /* renamed from: g */
    public InterfaceViewController f9185g = null;

    /* renamed from: a */
    public final void m8803a(OnIMDataListener onIMDataListener) {
        if (this.f9180a.contains(onIMDataListener)) {
            return;
        }
        this.f9180a.add(onIMDataListener);
    }

    /* renamed from: b */
    public final void m8796b(OnIMDataListener onIMDataListener) {
        this.f9180a.remove(onIMDataListener);
    }

    private IMPresenter(Context context) {
        this.f9180a = null;
        this.f9181b = null;
        this.f9183e = null;
        this.f9183e = context;
        this.f9180a = new ArrayList();
        this.f9181b = new NetWorkDataModel(context);
        this.f9181b.f9238b = this;
    }

    /* renamed from: a */
    public static IMPresenter m8804a(Context context) {
        if (f9179d == null) {
            synchronized (IMPresenter.class) {
                if (f9179d == null) {
                    f9179d = new IMPresenter(context);
                }
            }
        }
        return f9179d;
    }

    /* renamed from: a */
    public final void m8806a() {
        TimerView timerView = this.f9186h;
        if (timerView == null || timerView.f16491a == null) {
            return;
        }
        FixedThreadPool.m4928a().m4927a(new RunnableC2886b(timerView));
    }

    /* renamed from: a */
    public final List<FriendInfo> m8798a(boolean z) {
        if (z) {
            m8805a(40021);
        }
        return GoloDBManager.m8756a(this.f9183e).m8757a();
    }

    /* renamed from: b */
    public final List<MessageInfo> m8797b() {
        List<MessageInfo> m8751b = GoloDBManager.m8756a(this.f9183e).m8751b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < m8751b.size(); i++) {
            arrayList2.add(i, m8751b.get(i).f9270b);
        }
        for (int i2 = 0; i2 < m8751b.size(); i2++) {
            if (!arrayList3.contains(arrayList2.get(i2))) {
                arrayList3.add(arrayList2.get(i2));
                arrayList.add(m8751b.get(i2));
            } else {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (((MessageInfo) arrayList.get(i3)).f9270b.equals(m8751b.get(i2).f9270b)) {
                        MessageInfo messageInfo = (MessageInfo) arrayList.get(i3);
                        messageInfo.f9272d = Integer.valueOf(((MessageInfo) arrayList.get(i3)).f9272d.intValue() + m8751b.get(i2).f9272d.intValue());
                        arrayList.set(i3, messageInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m8805a(int i) {
        this.f9181b.m8744a(i);
    }

    @Override // com.cnlaunch.p169im.NetWorkDataModel.InterfaceC1737a
    /* renamed from: b */
    public final void mo8737b(int i) {
        m8792d(i);
    }

    @Override // com.cnlaunch.p169im.NetWorkDataModel.InterfaceC1737a
    /* renamed from: c */
    public final void mo8735c(int i) {
        m8792d(i);
    }

    /* renamed from: d */
    public final void m8792d(int i) {
        Log.i("Sanda", "notifyViewDataChanged  ");
        synchronized (this.f9180a) {
            for (OnIMDataListener onIMDataListener : this.f9180a) {
                onIMDataListener.mo6461a(i);
            }
        }
    }

    /* renamed from: e */
    public final void m8790e(int i) {
        this.f9187i.obtainMessage(0, i, 0).sendToTarget();
    }

    /* renamed from: a */
    public final void m8800a(String str, Bundle bundle) {
        OnIMViewListener onIMViewListener = this.f9182c;
        if (onIMViewListener != null) {
            onIMViewListener.mo8745a(str, bundle);
        }
    }

    /* renamed from: a */
    public final void m8801a(String str) {
        List<MessageInfo> m8751b = GoloDBManager.m8756a(this.f9183e).m8751b();
        if (m8751b == null) {
            return;
        }
        MessageInfo messageInfo = null;
        for (MessageInfo messageInfo2 : m8751b) {
            if (messageInfo2.f9270b.equalsIgnoreCase(str)) {
                GoloDBManager m8756a = GoloDBManager.m8756a(this.f9183e);
                m8756a.f9220b.f9228e.delete(messageInfo2);
                m8804a(m8756a.f9221c).m8790e(40028);
                messageInfo = messageInfo2;
            }
        }
        if (messageInfo != null && messageInfo.f9273e.intValue() == 1) {
            this.f9181b.m8743a(messageInfo.f9270b);
        }
    }

    /* renamed from: b */
    public final void m8795b(String str) {
        if (str.equalsIgnoreCase("666666") || str.equalsIgnoreCase("friend_verification")) {
            return;
        }
        new NetWorkDataModel.AsyncTaskC1740d().execute(str);
    }

    /* renamed from: a */
    public final UserBaseInfo m8799a(String str, boolean z) {
        if (z) {
            m8795b(str);
        }
        QueryBuilder<UserBaseInfo> queryBuilder = GoloDBManager.m8756a(this.f9183e).f9220b.f9229f.queryBuilder();
        queryBuilder.where(UserBaseInfoDao.Properties.User_id.m321eq(str), new WhereCondition[0]);
        List<UserBaseInfo> list = queryBuilder.list();
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    /* renamed from: c */
    public final void m8793c(String str) {
        GoloDBManager m8756a = GoloDBManager.m8756a(this.f9183e);
        QueryBuilder<MessageInfo> queryBuilder = m8756a.f9220b.f9228e.queryBuilder();
        queryBuilder.where(MessageInfoDao.Properties.User_id.m321eq(str), new WhereCondition[0]);
        queryBuilder.where(MessageInfoDao.Properties.Type.m321eq(0), new WhereCondition[0]);
        List<MessageInfo> list = queryBuilder.list();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).f9272d = 0;
            }
            m8756a.f9220b.f9228e.updateInTx(list);
        }
        ChatManager m8741a = ChatManager.m8741a(this.f9183e);
        String name = MessageParameters.EnumC4721a.single.name();
        QueryBuilder<ChatMessage> queryBuilder2 = m8741a.f9249a.queryBuilder();
        queryBuilder2.where(MessageDao.Properties.roomId.m321eq(str), new WhereCondition[0]);
        queryBuilder2.where(MessageDao.Properties.roomType.m321eq(name), new WhereCondition[0]);
        queryBuilder2.where(MessageDao.Properties.flag.m321eq(ChatMessage.EnumC4747a.unread), new WhereCondition[0]);
        for (ChatMessage chatMessage : queryBuilder2.list()) {
            chatMessage.f24059d = ChatMessage.EnumC4747a.read.name();
            m8741a.f9249a.update(chatMessage);
        }
        ((UnReadMsg) Singlton.m9123a(UnReadMsg.class)).m302a(str);
        m8790e(40031);
    }

    /* renamed from: a */
    public final void m8802a(MessageInfo messageInfo) {
        messageInfo.f9272d = 0;
        GoloDBManager.m8756a(this.f9183e).f9220b.f9228e.update(messageInfo);
        if (messageInfo.f9273e.intValue() == 1) {
            GoloDBManager m8756a = GoloDBManager.m8756a(this.f9183e);
            String str = messageInfo.f9270b;
            QueryBuilder<GoloRemoteOrderInfo> queryBuilder = m8756a.f9220b.f9225b.queryBuilder();
            queryBuilder.where(GoloRemoteOrderInfoDao.Properties.User_id.m321eq(str), new WhereCondition[0]);
            List<GoloRemoteOrderInfo> list = queryBuilder.list();
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setIsRead(Boolean.TRUE);
                }
                m8756a.f9220b.f9225b.updateInTx(list);
            }
        }
        m8790e(40031);
    }

    /* renamed from: d */
    public final boolean m8791d(String str) {
        if (str.equalsIgnoreCase(IMActivity.class.getName())) {
            m8790e(40032);
        }
        InterfaceViewController interfaceViewController = this.f9185g;
        if (interfaceViewController != null) {
            interfaceViewController.mo7897a(str);
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final int m8794c() {
        List<MessageInfo> loadAll = GoloDBManager.m8756a(this.f9183e).f9220b.f9228e.loadAll();
        int i = 0;
        if (loadAll != null) {
            for (MessageInfo messageInfo : loadAll) {
                i += messageInfo.f9272d.intValue();
            }
        }
        return i;
    }
}
