package com.cnlaunch.x431pro.module.p272k.p273a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.CacheManager;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.MD5Utils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.CityListResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.Country;
import com.cnlaunch.x431pro.module.p272k.p274b.CountryListResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.ExtParam;
import com.cnlaunch.x431pro.module.p272k.p274b.FaceSettingRespone;
import com.cnlaunch.x431pro.module.p272k.p274b.LoginResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.ProvinceListResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.RegistResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.SendClientVersionResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.ShopInfoResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.SimImeiInfoResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.UserAccountCheckedInfoResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfoResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.UserParam;
import com.cnlaunch.x431pro.module.p272k.p274b.UserSettingInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.X431UserDTO_ja;
import com.cnlaunch.x431pro.module.p272k.p274b.ZipcodeInfoResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.p388a.p389a.SoapObject;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.cnlaunch.x431pro.module.k.a.a */
/* loaded from: classes.dex */
public final class UserAction extends BaseAction {
    public UserAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final CommonResponse m5267a(String str, String str2, String str3) throws C1425f {
        String b = m5451b(KeyConstant.f6961r);
        this.f15440b = m5452b();
        this.f15440b.m9506a("req_info", str);
        this.f15440b.m9506a("lan", str2);
        this.f15440b.m9506a("isres", str3);
        return m5433e(b, this.f15440b);
    }

    /* renamed from: a */
    public final CommonResponse m5266a(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b(KeyConstant.f6961r);
        this.f15440b = m5452b();
        this.f15440b.m9506a("req_info", str);
        this.f15440b.m9506a("lan", str2);
        this.f15440b.m9506a("isres", str3);
        if (str4 != null) {
            this.f15440b.m9506a("is_check", str4);
        }
        return m5433e(b, this.f15440b);
    }

    /* renamed from: a */
    public final UserAccountCheckedInfoResponse m5269a(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6962s);
        this.f15440b = m5452b();
        this.f15440b.m9506a("keyword", str);
        String m9475b = this.f15446f.m9475b(b, this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (UserAccountCheckedInfoResponse) m5438a(m9475b, UserAccountCheckedInfoResponse.class);
    }

    /* renamed from: a */
    public final CommonResponse m5268a(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6963t);
        this.f15440b = m5452b();
        this.f15440b.m9506a("req_info", str);
        this.f15440b.m9506a("verify_code", str2);
        return m5433e(b, this.f15440b);
    }

    /* renamed from: a */
    public final LoginResponse m5265a(String str, String str2, String str3, String str4, String str5) throws C1425f {
        String b = m5451b(KeyConstant.f6968y);
        if (C2787z.m4821a(b)) {
            b = C2744aa.m5144h(this.f15439a) ? "https://cnglbase.dbscar.com/?action=passport_service.login" : "https://usglbase.dbscar.com/?action=passport_service.login";
        }
        this.f15440b = m5452b();
        this.f15440b.m9506a("login_key", str);
        this.f15440b.m9506a("password", str2);
        this.f15440b.m9506a("time", str3);
        this.f15440b.m9506a(VastExtensionXmlManager.TYPE, str4);
        this.f15440b.m9506a("device_token", str5);
        String m9475b = this.f15446f.m9475b(b, this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (LoginResponse) m5438a(m9475b, LoginResponse.class);
    }

    /* renamed from: a */
    public final RegistResponse m5263a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) throws C1425f {
        String b = m5451b(KeyConstant.f6969z);
        this.f15440b = m5452b();
        if (!C2787z.m4821a(str2)) {
            this.f15440b.m9506a("loginKey", str2);
        }
        if (!C2787z.m4821a(str3)) {
            this.f15440b.m9506a("login_name", str3);
        }
        if (!C2787z.m4821a(str4)) {
            this.f15440b.m9506a("login_mobile", str4);
        }
        if (!C2787z.m4821a(str5)) {
            this.f15440b.m9506a("login_email", str5);
        }
        this.f15440b.m9506a("nation_id", str);
        this.f15440b.m9506a("verify_code", str6);
        this.f15440b.m9506a("password", str7);
        this.f15440b.m9506a("app_id", str8);
        this.f15440b.m9506a("nick_name", str9);
        this.f15440b.m9506a("email", str10);
        this.f15440b.m9507a("reg_source", (Object) 11);
        this.f15440b.m9506a("zipcode", str11);
        this.f15440b.m9506a("company", str12);
        this.f15440b.m9506a("address", str13);
        this.f15440b.m9506a("contact", str14);
        this.f15440b.m9506a("mobile", str15);
        this.f15440b.m9506a("qq", str16);
        this.f15440b.m9506a("weixin", str17);
        String m9475b = this.f15446f.m9475b(b, this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (RegistResponse) m5438a(m9475b, RegistResponse.class);
    }

    /* renamed from: a */
    public final RegistResponse m5264a(String str, String str2, String str3, String str4, String str5, X431UserDTO_ja x431UserDTO_ja) throws C1425f {
        String b = m5451b(KeyConstant.f6969z);
        this.f15440b = m5452b();
        this.f15440b.m9506a("nation_id", str);
        this.f15440b.m9506a("loginKey", x431UserDTO_ja.f15615a);
        this.f15440b.m9506a("verify_code", str2);
        this.f15440b.m9506a("password", str3);
        this.f15440b.m9506a("app_id", str4);
        this.f15440b.m9506a("nick_name", str5);
        this.f15440b.m9506a("email", x431UserDTO_ja.f15616b);
        this.f15440b.m9507a("reg_source", (Object) 11);
        this.f15440b.m9506a("zipcode", x431UserDTO_ja.f15623i);
        this.f15440b.m9506a("family_phone", x431UserDTO_ja.f15618d);
        this.f15440b.m9506a("office_phone", x431UserDTO_ja.f15619e);
        this.f15440b.m9506a("fax", x431UserDTO_ja.f15620f);
        this.f15440b.m9506a("company", x431UserDTO_ja.f15621g);
        this.f15440b.m9506a("address", x431UserDTO_ja.f15622h);
        this.f15440b.m9507a("birthdays", Long.valueOf(x431UserDTO_ja.f15617c));
        String m9475b = this.f15446f.m9475b(b, this.f15440b);
        NLog.m9452b("anqi", "register params=" + this.f15440b.toString());
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (RegistResponse) m5438a(m9475b, RegistResponse.class);
    }

    /* renamed from: b */
    public final CommonResponse m5259b(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b(KeyConstant.f6964u);
        this.f15440b = m5452b();
        this.f15440b.m9506a("req", str);
        this.f15440b.m9506a("pass", str2);
        this.f15440b.m9506a("confirm_pass", str3);
        this.f15440b.m9506a("verify_code", str4);
        return m5433e(b, this.f15440b);
    }

    /* renamed from: b */
    public final CommonResponse m5261b(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6960q);
        this.f15440b = m5452b();
        this.f15440b.m9506a("pw", str);
        this.f15440b.m9506a("chpw", str2);
        return m5433e(m5455a(b, this.f15440b), this.f15440b);
    }

    /* renamed from: g */
    public final CountryListResponse m5250g(String str) throws C1425f {
        CountryListResponse countryListResponse;
        List<Country> data;
        List<Country> data2;
        String b = m5451b(KeyConstant.f6965v);
        this.f15440b = m5452b();
        this.f15440b.m9506a("lan", str);
        C1426i c1426i = this.f15440b;
        StringBuilder sb = new StringBuilder(b);
        if (c1426i != null) {
            sb.append(c1426i.toString());
        }
        String valueOf = String.valueOf(sb.hashCode());
        if (CacheManager.m9601c(valueOf)) {
            countryListResponse = (CountryListResponse) CacheManager.m9602b(valueOf);
            if (countryListResponse != null && countryListResponse.getCode() == 0 && (data2 = countryListResponse.getData()) != null && data2.size() > 0) {
                return countryListResponse;
            }
        } else {
            countryListResponse = null;
        }
        String m9475b = this.f15446f.m9475b(b, this.f15440b);
        if (!TextUtils.isEmpty(m9475b) && (countryListResponse = (CountryListResponse) m5438a(m9475b, CountryListResponse.class)) != null && countryListResponse.getCode() == 0 && (data = countryListResponse.getData()) != null && data.size() > 0) {
            CacheManager.m9605a(countryListResponse, valueOf);
        }
        return countryListResponse;
    }

    /* renamed from: c */
    public final UserBaseInfoResponse m5256c(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6853b);
        this.f15440b = m5452b();
        this.f15440b.m9506a("lan", str);
        if (str2 != null) {
            this.f15440b.m9506a("target_id", str2);
        }
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (UserBaseInfoResponse) m5438a(m9475b, UserBaseInfoResponse.class);
    }

    /* renamed from: d */
    public final UserBaseInfoResponse m5253d(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6853b);
        this.f15440b = m5452b();
        this.f15440b.m9506a("lan", str);
        if (str2 != null) {
            this.f15440b.m9506a("target_id", str2);
        }
        String m9475b = this.f15446f.m9475b(b, this.f15440b);
        UserBaseInfoResponse userBaseInfoResponse = TextUtils.isEmpty(m9475b) ? null : (UserBaseInfoResponse) m5438a(m9475b, UserBaseInfoResponse.class);
        NLog.m9456a("getBaseInfoEx", "getBaseInfo=".concat(String.valueOf(m9475b)));
        return userBaseInfoResponse;
    }

    /* renamed from: a */
    public final CommonResponse m5271a(UserParam userParam) throws C1425f {
        String b = m5451b(KeyConstant.f6947d);
        this.f15440b = m5452b();
        this.f15440b.m9506a("email", userParam.f15609e);
        this.f15440b.m9506a("mobile", userParam.f15610f);
        this.f15440b.m9506a("vcode", userParam.f15611g);
        this.f15440b.m9506a("name", userParam.f15605a);
        this.f15440b.m9506a("sex", userParam.f15606b);
        this.f15440b.m9506a("signature", userParam.f15607c);
        this.f15440b.m9506a("uname", userParam.f15608d);
        this.f15440b.m9506a("identity_tag", userParam.f15613i);
        this.f15440b.m9506a("lang", userParam.f15612h);
        return m5433e(m5455a(b, this.f15440b), this.f15440b);
    }

    /* renamed from: b */
    public final CommonResponse m5260b(String str, String str2, String str3) throws C1425f {
        String b = m5451b(KeyConstant.f6948e);
        this.f15440b = m5452b();
        this.f15440b.m9506a("ncode", str);
        this.f15440b.m9506a("pcode", str2);
        this.f15440b.m9506a("ccode", str3);
        return m5433e(m5455a(b, this.f15440b), this.f15440b);
    }

    /* renamed from: a */
    public final CommonResponse m5273a() throws C1425f {
        String b = m5451b(KeyConstant.f6950g);
        this.f15440b = m5452b();
        return m5433e(m5455a(b, this.f15440b), this.f15440b);
    }

    /* renamed from: a */
    public final CommonResponse m5272a(ExtParam extParam) throws C1425f {
        String b = m5451b(KeyConstant.f6953j);
        this.f15440b = new C1426i();
        this.f15440b.m9506a("user_id", PreferencesManager.m9595a(this.f15439a).m9591a("user_id"));
        this.f15440b.m9506a("companyName", extParam.f15594a);
        this.f15440b.m9506a("address", extParam.f15595b);
        this.f15440b.m9506a("officePhone", extParam.f15596c);
        this.f15440b.m9506a("zipCode", extParam.f15597d);
        C1426i c1426i = this.f15440b;
        StringBuilder sb = new StringBuilder(b);
        C1426i c1426i2 = new C1426i();
        c1426i.m9506a("action", super.m5449c(b));
        c1426i.m9506a("communicate_id", "ucenter_id");
        c1426i.m9506a("version", "5.3.0");
        c1426i2.m9506a("sign", MD5Utils.m9460a(c1426i.m9505b() + "24327a6a10c533262a148f52e6d43fae"));
        c1426i2.m9506a("version", "5.3.0");
        c1426i2.m9506a("communicate_id", "ucenter_id");
        sb.append("&");
        sb.append(c1426i2.m9505b());
        c1426i.m9504b("action");
        c1426i.m9504b("ver");
        c1426i.m9504b("communicate_id");
        String sb2 = sb.toString();
        NLog.m9456a("Action", "Url=".concat(String.valueOf(sb2)));
        return m5433e(sb2, this.f15440b);
    }

    /* renamed from: h */
    public final CommonResponse m5248h(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6947d);
        this.f15440b = m5452b();
        this.f15440b.m9506a("sex", str);
        return m5433e(m5455a(b, this.f15440b), this.f15440b);
    }

    /* renamed from: e */
    public final ProvinceListResponse m5252e(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6966w);
        this.f15440b = m5452b();
        this.f15440b.m9506a("lan", str);
        this.f15440b.m9506a("ncode", str2);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (ProvinceListResponse) m5438a(m9475b, ProvinceListResponse.class);
    }

    /* renamed from: f */
    public final CityListResponse m5251f(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6967x);
        this.f15440b = m5452b();
        this.f15440b.m9506a("lan", str);
        this.f15440b.m9506a("pcode", str2);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (CityListResponse) m5438a(m9475b, CityListResponse.class);
    }

    /* renamed from: c */
    public final SendClientVersionResponse m5254c(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b(KeyConstant.f6812aL);
        this.f15442d = m5447d("sendClientVersion");
        this.f15442d.mo169a("serialNo", str);
        this.f15442d.mo169a("softType", str2);
        this.f15442d.mo169a("softName", str3);
        this.f15442d.mo169a("verson", str4);
        try {
            this.f15447g = m5436f(b);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (SendClientVersionResponse) m5444a((Class<Object>) SendClientVersionResponse.class);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: c */
    public final ZipcodeInfoResponse m5257c() throws C1425f {
        String b = m5451b(KeyConstant.f6954k);
        this.f15440b = m5452b();
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (ZipcodeInfoResponse) m5438a(m9475b, ZipcodeInfoResponse.class);
    }

    /* renamed from: i */
    public final CommonResponse m5247i(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6952i);
        this.f15440b = m5452b();
        this.f15440b.m9506a("zipcode", str);
        return m5433e(m5455a(b, this.f15440b), this.f15440b);
    }

    /* renamed from: a */
    public final CommonResponse m5270a(UserSettingInfo userSettingInfo) throws C1425f {
        String b = m5451b(KeyConstant.f6947d);
        this.f15440b = m5452b();
        if (userSettingInfo.getNickname() != null) {
            this.f15440b.m9506a("name", userSettingInfo.getNickname());
        }
        if (userSettingInfo.getSex() != -1) {
            C1426i c1426i = this.f15440b;
            StringBuilder sb = new StringBuilder();
            sb.append(userSettingInfo.getSex());
            c1426i.m9506a("sex", sb.toString());
        }
        if (userSettingInfo.getSignature() != null) {
            this.f15440b.m9506a("signature", userSettingInfo.getSignature());
        }
        if (userSettingInfo.getTag() != null) {
            this.f15440b.m9506a("identity_tag", userSettingInfo.getTag());
        }
        if (userSettingInfo.getCompany() != null) {
            this.f15440b.m9506a("company", userSettingInfo.getCompany());
        }
        if (userSettingInfo.getAddress() != null) {
            this.f15440b.m9506a("address", userSettingInfo.getAddress());
        }
        if (userSettingInfo.getContact() != null) {
            this.f15440b.m9506a("contact", userSettingInfo.getContact());
        }
        if (!C2787z.m4821a(userSettingInfo.getQq())) {
            this.f15440b.m9506a("qq", userSettingInfo.getQq());
        }
        if (!C2787z.m4821a(userSettingInfo.getWeixin())) {
            this.f15440b.m9506a("weixin", userSettingInfo.getWeixin());
        }
        if (!C2787z.m4821a(userSettingInfo.getVcode())) {
            this.f15440b.m9506a("vcode", userSettingInfo.getVcode());
        }
        if (!C2787z.m4821a(userSettingInfo.getEmail())) {
            this.f15440b.m9506a("email", userSettingInfo.getEmail());
        }
        if (!C2787z.m4821a(userSettingInfo.getMobile())) {
            this.f15440b.m9506a("mobile", userSettingInfo.getMobile());
        }
        if (!C2787z.m4821a(userSettingInfo.getCompany_phone())) {
            this.f15440b.m9506a("company_phone", userSettingInfo.getCompany_phone());
        }
        if (!C2787z.m4821a(userSettingInfo.getZipcode())) {
            this.f15440b.m9506a("zipcode", userSettingInfo.getZipcode());
        }
        return m5433e(m5455a(b, this.f15440b), this.f15440b);
    }

    /* renamed from: b */
    public final FaceSettingRespone m5262b(UserSettingInfo userSettingInfo) throws C1425f {
        String b = m5451b(KeyConstant.f6775B);
        this.f15440b = m5452b();
        if (userSettingInfo.getPic() != null) {
            try {
                NLog.m9452b("Sanda", "info.getPic()=" + userSettingInfo.getPic());
                this.f15440b.m9509a("pic", new File(userSettingInfo.getPic()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                NLog.m9451c("Sanda", "Pic " + e.toString());
            }
        }
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        FaceSettingRespone faceSettingRespone = TextUtils.isEmpty(m9475b) ? null : (FaceSettingRespone) m5438a(m9475b, FaceSettingRespone.class);
        NLog.m9452b("Sanda", "user_set_face:".concat(String.valueOf(m9475b)));
        return faceSettingRespone;
    }

    /* renamed from: b */
    public final BaseResponse m5258b(String str, String str2, String str3, String str4, String str5) throws C1425f {
        String b = m5451b("addRepairShop");
        if (TextUtils.isEmpty(b)) {
            b = "http://ait.golo365.com/Home/HttApi/addRepairShop";
        }
        this.f15440b = new C1426i();
        this.f15440b.m9506a("serial_number", str);
        this.f15440b.m9506a("company_fullname", str2);
        this.f15440b.m9506a("company_address", str3);
        if (!C2787z.m4821a(str4)) {
            this.f15440b.m9506a("telephone", str4);
        }
        this.f15440b.m9506a("email", str5);
        String m9475b = this.f15446f.m9475b(b, this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (BaseResponse) m5438a(m9475b, BaseResponse.class);
    }

    /* renamed from: g */
    public final BaseResponse m5249g(String str, String str2) throws C1425f {
        NLog.m9452b("sarah", "sendICCID  serial_number:" + str + "  iccid:" + str2);
        String b = m5451b("addIccidSerialNumberRelation");
        if (TextUtils.isEmpty(b)) {
            b = "http://ait.golo365.com/Home/HttApi/addIccidSerialNumberRelation?";
        }
        this.f15440b = m5452b();
        this.f15440b.m9506a("serial_number", str);
        this.f15440b.m9506a("iccid", str2);
        NLog.m9452b("sarah", "sendICCID  url:" + m5455a(b, this.f15440b));
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        NLog.m9452b("sarah", "sendICCID  json:".concat(String.valueOf(m9475b)));
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (BaseResponse) m5438a(m9475b, BaseResponse.class);
    }

    /* renamed from: j */
    public final ShopInfoResponse m5246j(String str) throws C1425f {
        String b = m5451b("addRepairShop");
        if (TextUtils.isEmpty(b)) {
            b = "http://ait.golo365.com/Home/HttApi/addRepairShop";
        }
        this.f15440b = new C1426i();
        this.f15440b.m9506a("serial_number", str);
        String m9475b = this.f15446f.m9475b(b, this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (ShopInfoResponse) m5438a(m9475b, ShopInfoResponse.class);
    }

    /* renamed from: c */
    public final SimImeiInfoResponse m5255c(String str, String str2, String str3) throws C1425f {
        NLog.m9452b("sarah", "sendICCID  serial_number:" + str + "  iccid:" + str2 + " imei: " + str3);
        this.f15440b = m5452b();
        this.f15440b.m9506a("serialNo", str);
        this.f15440b.m9506a("sim", str2);
        this.f15440b.m9506a("imei", str3);
        NLog.m9452b("sarah", "sendICCID  url:".concat(String.valueOf("http://mycar.x431.com/rest/sim/putSystemSnSim.json")));
        String m9477a = this.f15446f.m9477a("http://mycar.x431.com/rest/sim/putSystemSnSim.json", this.f15440b);
        NLog.m9452b("sarah", "sendICCID  json:".concat(String.valueOf(m9477a)));
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        return (SimImeiInfoResponse) m5438a(m9477a, SimImeiInfoResponse.class);
    }
}
