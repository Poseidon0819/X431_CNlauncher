package com.cnlaunch.x431pro.module.golo.p262a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.golo3.p163e.C1609a;
import com.cnlaunch.golo3.p163e.C1610b;
import com.cnlaunch.golo3.p164f.HttpResponseEntityCallBack;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.SyncHttpTransportSE;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.module.golo.model.AddFriendResponse;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.FriendListResponse;
import com.cnlaunch.x431pro.module.golo.model.SearchFriendResponse;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p241a.SoapObjectParams;
import com.cnlaunch.x431pro.module.p255e.p257b.UserInfoResultResponse;
import com.cnlaunch.x431pro.utils.ActionDataUntils;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.p099c.p100a.HttpUtils;
import com.p099c.p100a.p103c.p105b.HttpRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.p388a.p389a.SoapObject;
import org.p388a.p389a.SoapSerializationEnvelope;

/* renamed from: com.cnlaunch.x431pro.module.golo.a.a */
/* loaded from: classes.dex */
public final class FriendAction extends BaseAction {

    /* renamed from: s */
    public HttpUtils f15538s;

    public FriendAction(Context context) {
        super(context);
        this.f15538s = C1609a.m9164a(context).f8435a;
    }

    /* renamed from: a */
    public final FriendListResponse m5328a() throws C1425f {
        String b = m5451b(KeyConstant.f6782I);
        this.f15440b = m5452b();
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        if (ActionDataUntils.m5195a(m9475b)) {
            return (FriendListResponse) m5438a(m9475b, FriendListResponse.class);
        }
        BaseResponse baseResponse = (BaseResponse) m5438a(m9475b, BaseResponse.class);
        FriendListResponse friendListResponse = new FriendListResponse();
        friendListResponse.setCode(baseResponse.getCode());
        friendListResponse.setMessage(baseResponse.getMessage());
        return friendListResponse;
    }

    /* renamed from: a */
    public final SearchFriendResponse m5327a(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6819aS);
        this.f15440b = m5452b();
        this.f15440b.m9507a(VastExtensionXmlManager.TYPE, (Object) 0);
        this.f15440b.m9506a("name", str);
        this.f15440b.m9507a("p_type", (Object) 0);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        Log.i("Sanda", "user_s_search json=".concat(String.valueOf(m9475b)));
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        if (ActionDataUntils.m5195a(m9475b)) {
            return (SearchFriendResponse) m5438a(m9475b, SearchFriendResponse.class);
        }
        BaseResponse baseResponse = (BaseResponse) m5438a(m9475b, BaseResponse.class);
        SearchFriendResponse searchFriendResponse = new SearchFriendResponse();
        searchFriendResponse.setCode(baseResponse.getCode());
        searchFriendResponse.setMessage(baseResponse.getMessage());
        return searchFriendResponse;
    }

    /* renamed from: g */
    public final UserInfoResultResponse m5322g(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6820aT);
        if (TextUtils.isEmpty(b)) {
            b = "https://mycar.x431.com/services/sysUserService?wsdl";
        }
        SoapObjectParams d = m5447d("getUserInfoBySerialNo");
        d.mo169a("serialNo", str);
        try {
            SyncHttpTransportSE f = m5436f(b);
            SoapSerializationEnvelope a = m5437a(m5453a((SoapObject) d), d);
            f.m141a("", a);
            if (a != null) {
                return (UserInfoResultResponse) m5443a(UserInfoResultResponse.class, a);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    public final AddFriendResponse m5321h(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6780G);
        this.f15440b = m5452b();
        this.f15440b.m9506a("target_id", str);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        Log.i("Sanda", "friend_addf json=".concat(String.valueOf(m9475b)));
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (AddFriendResponse) m5438a(m9475b, AddFriendResponse.class);
    }

    /* renamed from: i */
    public final BaseResponse m5320i(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6783J);
        this.f15440b = m5452b();
        this.f15440b.m9506a("target_id", str);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        Log.i("Sanda", "friend_delete json=".concat(String.valueOf(m9475b)));
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (BaseResponse) m5438a(m9475b, BaseResponse.class);
    }

    /* renamed from: a */
    public final BaseResponse m5325a(String str, String str2) throws C1425f {
        String b = m5451b("remote_diagnose.pro_to_tech");
        this.f15440b = m5452b();
        this.f15440b.m9506a("target_id", str);
        if (!TextUtils.isEmpty(str2)) {
            this.f15440b.m9506a("description", str2);
        }
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b) + ("&lan=" + LangManager.m9469a()), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (BaseResponse) m5438a(m9475b, BaseResponse.class);
    }

    /* renamed from: j */
    public final BaseResponse m5319j(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6781H);
        this.f15440b = m5452b();
        this.f15440b.m9506a("target_id", str);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        Log.i("Sanda", "friend_addf json=".concat(String.valueOf(m9475b)));
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (BaseResponse) m5438a(m9475b, BaseResponse.class);
    }

    /* renamed from: a */
    public final void m5326a(String str, HttpResponseEntityCallBack<FriendInfo> httpResponseEntityCallBack) {
        try {
            String b = m5451b("friend.detail");
            HashMap hashMap = new HashMap();
            hashMap.put("target_id", str);
            this.f15538s.m9763a(HttpRequest.EnumC1391a.POST, C1610b.m9162a(1, b, hashMap), C1610b.m9161a(hashMap), new C2732b(this, httpResponseEntityCallBack));
        } catch (Exception e) {
            e.printStackTrace();
            httpResponseEntityCallBack.mo8705a(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m5323b(JSONObject jSONObject, String str) {
        try {
            if (jSONObject.has(str)) {
                String string = jSONObject.getString(str);
                if ("null".equals(string)) {
                    return null;
                }
                if ("".equals(string)) {
                    return null;
                }
                return string;
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
