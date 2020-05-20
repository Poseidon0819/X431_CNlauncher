package com.cnlaunch.p169im;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.gmap.map.p151c.LanguageUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.p174db.FriendInfoDao;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p174db.GoloRemoteOrderInfoDao;
import com.cnlaunch.p169im.p174db.MessageInfoDao;
import com.cnlaunch.p169im.p174db.UserBaseInfoDao;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.p169im.p179i.UserInfoCache;
import com.cnlaunch.x431pro.activity.golo.others.AsyLock;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderInfo;
import com.cnlaunch.x431pro.module.golo.p262a.FriendAction;
import com.cnlaunch.x431pro.module.golo.p262a.GoloAction;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfoResponse;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.List;

/* renamed from: com.cnlaunch.im.f */
/* loaded from: classes.dex */
public final class NetWorkDataModel {

    /* renamed from: a */
    Context f9237a;

    /* renamed from: c */
    FriendAction f9239c;

    /* renamed from: d */
    GoloAction f9240d;

    /* renamed from: e */
    UserAction f9241e;

    /* renamed from: f */
    String f9242f;

    /* renamed from: b */
    InterfaceC1737a f9238b = null;

    /* renamed from: g */
    private OnDataListener f9243g = new C1742g(this);

    /* compiled from: NetWorkDataModel.java */
    /* renamed from: com.cnlaunch.im.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1737a {
        /* renamed from: b */
        void mo8737b(int i);

        /* renamed from: c */
        void mo8735c(int i);
    }

    /* renamed from: a */
    public final void m8744a(int i) {
        if (AsyLock.m6968a(i)) {
            return;
        }
        AsyncTaskManager.m9574a(this.f9237a).m9575a(i, true, this.f9243g);
    }

    public NetWorkDataModel(Context context) {
        this.f9237a = null;
        this.f9239c = null;
        this.f9240d = null;
        this.f9241e = null;
        this.f9242f = "CN";
        this.f9237a = context;
        this.f9239c = new FriendAction(context);
        this.f9240d = new GoloAction(context);
        this.f9241e = new UserAction(context);
        this.f9242f = PreferencesManager.m9595a(context).m9584b("current_country", "US");
    }

    /* renamed from: a */
    public final void m8743a(String str) {
        new AsyncTaskC1739c().execute(str);
    }

    /* compiled from: NetWorkDataModel.java */
    /* renamed from: com.cnlaunch.im.f$b */
    /* loaded from: classes.dex */
    public class AsyncTaskC1738b extends AsyncTask<String, String, BaseResponse> {
        public AsyncTaskC1738b() {
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(BaseResponse baseResponse) {
            BaseResponse baseResponse2 = baseResponse;
            super.onPostExecute(baseResponse2);
            if (baseResponse2 != null) {
                if (baseResponse2.getCode() == 0) {
                    NetWorkDataModel.this.m8744a(40021);
                    return;
                }
                Context context = NetWorkDataModel.this.f9237a;
                NToast.m9449a(context, "Failed[" + baseResponse2.getCode() + "]:" + baseResponse2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public BaseResponse doInBackground(String... strArr) {
            try {
                return NetWorkDataModel.this.f9239c.m5320i(strArr[0]);
            } catch (C1425f e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetWorkDataModel.java */
    /* renamed from: com.cnlaunch.im.f$d */
    /* loaded from: classes.dex */
    public class AsyncTaskC1740d extends AsyncTask<String, String, UserBaseInfoResponse> {

        /* renamed from: b */
        private String f9247b = "";

        /* JADX INFO: Access modifiers changed from: package-private */
        public AsyncTaskC1740d() {
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(UserBaseInfoResponse userBaseInfoResponse) {
            UserBaseInfoResponse userBaseInfoResponse2 = userBaseInfoResponse;
            super.onPostExecute(userBaseInfoResponse2);
            if (userBaseInfoResponse2 == null || userBaseInfoResponse2.getCode() != 0) {
                return;
            }
            UserBaseInfo data = userBaseInfoResponse2.getData();
            data.setUser_id(this.f9247b);
            String user_name = TextUtils.isEmpty(data.getNick_name()) ? data.getUser_name() : data.getNick_name();
            UserInfoCache.m8711a(NetWorkDataModel.this.f9237a, false).m8709a(data.getUser_id(), user_name);
            if (data != null && data.getCountry().equalsIgnoreCase("China")) {
                if (LanguageUtils.m9283b().equalsIgnoreCase("zh")) {
                    data.setCountry("中国");
                } else if (LanguageUtils.m9283b().equalsIgnoreCase("zh_tw")) {
                    data.setCountry("中國");
                }
            }
            GoloDBManager m8756a = GoloDBManager.m8756a(NetWorkDataModel.this.f9237a);
            Context context = NetWorkDataModel.this.f9237a;
            QueryBuilder<UserBaseInfo> queryBuilder = m8756a.f9220b.f9229f.queryBuilder();
            queryBuilder.where(UserBaseInfoDao.Properties.User_id.m321eq(data.getUser_id()), new WhereCondition[0]);
            List<UserBaseInfo> list = queryBuilder.list();
            if (list != null && list.size() > 0) {
                data.setId(Long.valueOf(list.get(0).getId().longValue()));
                m8756a.f9220b.f9229f.update(data);
            } else {
                m8756a.f9220b.f9229f.insert(data);
            }
            QueryBuilder<MessageInfo> queryBuilder2 = m8756a.f9220b.f9228e.queryBuilder();
            queryBuilder2.where(MessageInfoDao.Properties.User_id.m321eq(data.getUser_id()), new WhereCondition[0]);
            List<MessageInfo> list2 = queryBuilder2.list();
            if (list2 != null) {
                QueryBuilder<FriendInfo> queryBuilder3 = m8756a.f9220b.f9226c.queryBuilder();
                queryBuilder3.where(FriendInfoDao.Properties.User_id.m321eq(data.getUser_id()), new WhereCondition[0]);
                List<FriendInfo> list3 = queryBuilder3.list();
                if (list3 != null && list3.size() > 0) {
                    String rename = list3.get(0).getRename();
                    if (!TextUtils.isEmpty(rename)) {
                        user_name = rename;
                    }
                }
                for (int i = 0; i < list2.size(); i++) {
                    list2.get(i).f9271c = user_name;
                    UserInfoCache.m8711a(context, false).m8709a(data.getUser_id(), user_name);
                }
                m8756a.f9220b.f9228e.updateInTx(list2);
            }
            IMPresenter.m8804a(context).m8790e(40029);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public UserBaseInfoResponse doInBackground(String... strArr) {
            try {
                this.f9247b = strArr[0];
                return NetWorkDataModel.this.f9241e.m5256c(NetWorkDataModel.this.f9242f, this.f9247b);
            } catch (C1425f e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetWorkDataModel.java */
    /* renamed from: com.cnlaunch.im.f$c */
    /* loaded from: classes.dex */
    public class AsyncTaskC1739c extends AsyncTask<String, String, String> {
        AsyncTaskC1739c() {
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(String str) {
            String str2 = str;
            super.onPostExecute(str2);
            if (str2 != null) {
                Log.i("Sanda", "onPostExecute");
                GoloDBManager m8756a = GoloDBManager.m8756a(NetWorkDataModel.this.f9237a);
                QueryBuilder<GoloRemoteOrderInfo> queryBuilder = m8756a.f9220b.f9225b.queryBuilder();
                queryBuilder.where(GoloRemoteOrderInfoDao.Properties.User_id.m321eq(str2), new WhereCondition[0]);
                List<GoloRemoteOrderInfo> list = queryBuilder.list();
                if (list == null || list.size() <= 0) {
                    return;
                }
                m8756a.f9220b.f9225b.deleteInTx(list);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            try {
                String str = strArr[0];
                String m8749b = GoloDBManager.m8756a(NetWorkDataModel.this.f9237a).m8749b(str);
                if (TextUtils.isEmpty(m8749b)) {
                    return null;
                }
                NetWorkDataModel.this.f9240d.m5311i(m8749b);
                return str;
            } catch (C1425f e) {
                Log.e("Sanda", "getUserInfoAsy:" + e.toString());
                e.printStackTrace();
                return null;
            }
        }
    }
}
