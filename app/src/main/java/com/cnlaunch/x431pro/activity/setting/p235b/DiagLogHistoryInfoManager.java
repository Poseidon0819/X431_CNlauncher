package com.cnlaunch.x431pro.activity.setting.p235b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p263h.p264a.SettingAction;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryResponse;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.p283db.DiagLogHistoryInfoDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import de.greenrobot.dao.query.WhereCondition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.cnlaunch.x431pro.activity.setting.b.a */
/* loaded from: classes.dex */
public class DiagLogHistoryInfoManager implements OnDataListener {

    /* renamed from: b */
    private static DiagLogHistoryInfoManager f14636b;

    /* renamed from: a */
    public boolean f14637a;

    /* renamed from: c */
    private Context f14638c;

    /* renamed from: d */
    private long f14639d;

    /* renamed from: e */
    private String f14640e;

    /* renamed from: f */
    private AsyncTaskManager f14641f;

    /* renamed from: g */
    private DiagLogHistoryInfoDao f14642g;

    /* renamed from: h */
    private List<DiagLogHistoryInfo> f14643h;

    /* renamed from: i */
    private List<OnQueryHistoryInfoListener> f14644i = new ArrayList();

    /* renamed from: k */
    private BroadcastReceiver f14646k = new C2542b(this);

    /* renamed from: j */
    private Handler f14645j = new Handler();

    /* renamed from: a */
    public static DiagLogHistoryInfoManager m5973a(Context context) {
        if (f14636b == null) {
            synchronized (DiagLogHistoryInfoManager.class) {
                if (f14636b == null) {
                    f14636b = new DiagLogHistoryInfoManager(context);
                }
            }
        }
        return f14636b;
    }

    /* renamed from: b */
    private boolean m5969b() {
        String m9591a = PreferencesManager.m9595a(this.f14638c).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.f14638c).m9591a("token");
        return (C2787z.m4821a(m9591a) || "null".equals(m9591a) || C2787z.m4821a(m9591a2) || "null".equals(m9591a2)) ? false : true;
    }

    /* renamed from: a */
    public final void m5970a(String str) {
        List<DiagLogHistoryInfo> list;
        if (C2787z.m4821a(str)) {
            return;
        }
        this.f14642g.count();
        if (!m5969b()) {
            if (this.f14644i.size() > 0) {
                for (OnQueryHistoryInfoListener onQueryHistoryInfoListener : this.f14644i) {
                    onQueryHistoryInfoListener.mo5966a(-1, 0, "");
                }
            }
        } else if (!str.equals(this.f14640e) || this.f14637a || System.currentTimeMillis() - this.f14639d >= 1800000) {
            m5967c();
            this.f14640e = str;
            this.f14637a = false;
        } else if (str.equals(this.f14640e) && System.currentTimeMillis() - this.f14639d < 1800000 && ((list = this.f14643h) == null || list.size() == 0)) {
            this.f14643h = this.f14642g.queryBuilder().where(DiagLogHistoryInfoDao.Properties.SerialNo.m321eq(str), new WhereCondition[0]).orderDesc(DiagLogHistoryInfoDao.Properties.FeedbackTime).limit(100).list();
            if (this.f14643h == null || this.f14644i.size() <= 0) {
                return;
            }
            for (OnQueryHistoryInfoListener onQueryHistoryInfoListener2 : this.f14644i) {
                onQueryHistoryInfoListener2.mo5964a(this.f14643h);
            }
        } else if (this.f14643h != null && this.f14644i.size() > 0) {
            for (OnQueryHistoryInfoListener onQueryHistoryInfoListener3 : this.f14644i) {
                onQueryHistoryInfoListener3.mo5964a(this.f14643h);
            }
        }
    }

    /* renamed from: a */
    public final void m5974a() {
        if (this.f14644i.size() <= 0 || this.f14643h == null) {
            return;
        }
        for (OnQueryHistoryInfoListener onQueryHistoryInfoListener : this.f14644i) {
            onQueryHistoryInfoListener.mo5964a(this.f14643h);
        }
    }

    /* renamed from: a */
    public final void m5971a(OnQueryHistoryInfoListener onQueryHistoryInfoListener) {
        this.f14644i.add(onQueryHistoryInfoListener);
    }

    /* renamed from: b */
    public final void m5968b(OnQueryHistoryInfoListener onQueryHistoryInfoListener) {
        this.f14644i.remove(onQueryHistoryInfoListener);
    }

    /* renamed from: c */
    private void m5967c() {
        this.f14641f.m9575a(100, true, this);
    }

    private DiagLogHistoryInfoManager(Context context) {
        this.f14638c = context.getApplicationContext();
        this.f14641f = AsyncTaskManager.m9574a(this.f14638c);
        this.f14642g = DBManager.m5036a(this.f14638c).f15794a.f15802e;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("logout");
        this.f14638c.registerReceiver(this.f14646k, intentFilter);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i != 100) {
            return null;
        }
        Log.i("msp", "queryDiagHistory inbackGround");
        SettingAction settingAction = new SettingAction(this.f14638c);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = new Date();
        date.setTime(((date.getTime() / 1000) + 86400) * 1000);
        return settingAction.m5306a(this.f14640e, "2010-08-01", simpleDateFormat.format(date));
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        SimpleDateFormat simpleDateFormat;
        if (i == 100 && obj != null) {
            DiagLogHistoryResponse diagLogHistoryResponse = (DiagLogHistoryResponse) obj;
            if (diagLogHistoryResponse.getCode() == 0) {
                if (TextUtils.isEmpty(diagLogHistoryResponse.getDiagLogBasicDTOList().get(0).getSerialNo())) {
                    this.f14643h = new ArrayList(0);
                } else {
                    this.f14643h = diagLogHistoryResponse.getDiagLogBasicDTOList();
                    String m9584b = PreferencesManager.m9595a(this.f14638c).m9584b("current_country", "");
                    NLog.m9452b("test", "：oldCountryId=".concat(String.valueOf(m9584b)));
                    if (!"CN".equalsIgnoreCase(m9584b)) {
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    } else {
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    }
                    Collections.sort(this.f14643h, new C2543c(this));
                    List<DiagLogHistoryInfo> list = this.f14642g.queryBuilder().where(DiagLogHistoryInfoDao.Properties.SerialNo.m321eq(this.f14640e), new WhereCondition[0]).orderDesc(DiagLogHistoryInfoDao.Properties.FeedbackTime).list();
                    for (int i2 = 0; i2 < this.f14643h.size(); i2++) {
                        DiagLogHistoryInfo diagLogHistoryInfo = this.f14643h.get(i2);
                        try {
                            Date parse = simpleDateFormat.parse(diagLogHistoryInfo.getFeedbackTime());
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
                            diagLogHistoryInfo.setFeedbackTime(simpleDateFormat2.format(parse));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (!list.contains(diagLogHistoryInfo)) {
                            if (list == null || list.isEmpty()) {
                                diagLogHistoryInfo.setReaded(diagLogHistoryInfo.getCurrentState());
                            }
                            this.f14642g.insertOrReplace(diagLogHistoryInfo);
                        } else {
                            int indexOf = list.indexOf(diagLogHistoryInfo);
                            if (indexOf != -1) {
                                DiagLogHistoryInfo diagLogHistoryInfo2 = list.get(indexOf);
                                diagLogHistoryInfo.setReaded(diagLogHistoryInfo2.getReaded());
                                if (diagLogHistoryInfo.getCurrentState() != diagLogHistoryInfo2.getCurrentState()) {
                                    this.f14642g.insertOrReplace(diagLogHistoryInfo);
                                }
                            }
                        }
                    }
                }
                this.f14639d = System.currentTimeMillis();
                this.f14645j.postDelayed(new RunnableC2544d(this), 1800000L);
                if (this.f14644i.size() <= 0 || this.f14643h == null) {
                    return;
                }
                for (OnQueryHistoryInfoListener onQueryHistoryInfoListener : this.f14644i) {
                    onQueryHistoryInfoListener.mo5964a(this.f14643h);
                }
            } else if (this.f14644i.size() > 0) {
                for (OnQueryHistoryInfoListener onQueryHistoryInfoListener2 : this.f14644i) {
                    onQueryHistoryInfoListener2.mo5966a(diagLogHistoryResponse.getCode(), 0, diagLogHistoryResponse.getMessage());
                }
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (this.f14644i.size() > 0) {
            for (OnQueryHistoryInfoListener onQueryHistoryInfoListener : this.f14644i) {
                onQueryHistoryInfoListener.mo5966a(-100, i2, "");
            }
        }
    }
}
