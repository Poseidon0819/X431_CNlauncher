package com.cnlaunch.p169im.p174db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.itextpdf.text.Annotation;
import com.mopub.common.MoPubBrowser;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.im.db.UserBaseInfoDao */
/* loaded from: classes.dex */
public class UserBaseInfoDao extends AbstractDao<UserBaseInfo, Long> {
    public static final String TABLENAME = "USER_BASE_INFO";

    /* renamed from: com.cnlaunch.im.db.UserBaseInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f9212Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Is_bind_mobile = new Property(1, Integer.class, "is_bind_mobile", false, "IS_BIND_MOBILE");
        public static final Property Mobile = new Property(2, String.class, "mobile", false, "MOBILE");
        public static final Property Is_bind_email = new Property(3, Integer.class, "is_bind_email", false, "IS_BIND_EMAIL");
        public static final Property Email = new Property(4, String.class, "email", false, "EMAIL");
        public static final Property Sex = new Property(5, Integer.class, "sex", false, "SEX");
        public static final Property User_id = new Property(6, String.class, "user_id", false, "USER_ID");
        public static final Property Nick_name = new Property(7, String.class, "nick_name", false, "NICK_NAME");
        public static final Property Signature = new Property(8, String.class, "signature", false, "SIGNATURE");
        public static final Property Url = new Property(9, String.class, Annotation.URL, false, MoPubBrowser.DESTINATION_URL_KEY);
        public static final Property Country = new Property(10, String.class, "country", false, "COUNTRY");
        public static final Property Province = new Property(11, String.class, "province", false, "PROVINCE");
        public static final Property City = new Property(12, String.class, "city", false, "CITY");
        public static final Property User_name = new Property(13, String.class, "user_name", false, "USER_NAME");
        public static final Property Identity_tag = new Property(14, String.class, "identity_tag", false, "IDENTITY_TAG");
        public static final Property Company_name = new Property(15, String.class, "company_name", false, "COMPANY_NAME");
        public static final Property Company_logo = new Property(16, String.class, "company_logo", false, "COMPANY_LOGO");
        public static final Property Company_fax = new Property(17, String.class, "company_fax", false, "COMPANY_FAX");
        public static final Property Company_address = new Property(18, String.class, "company_address", false, "COMPANY_ADDRESS");
        public static final Property Company = new Property(19, String.class, "company", false, "COMPANY");
        public static final Property Contact = new Property(20, String.class, "contact", false, "CONTACT");
        public static final Property Address = new Property(21, String.class, "address", false, "ADDRESS");

        /* renamed from: Qq */
        public static final Property f9213Qq = new Property(22, String.class, "qq", false, "QQ");
        public static final Property Weixin = new Property(23, String.class, "weixin", false, "WEIXIN");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, UserBaseInfo userBaseInfo) {
        UserBaseInfo userBaseInfo2 = userBaseInfo;
        sQLiteStatement.clearBindings();
        Long id = userBaseInfo2.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        Integer is_bind_mobile = userBaseInfo2.getIs_bind_mobile();
        if (is_bind_mobile != null) {
            sQLiteStatement.bindLong(2, is_bind_mobile.intValue());
        }
        String mobile = userBaseInfo2.getMobile();
        if (mobile != null) {
            sQLiteStatement.bindString(3, mobile);
        }
        Integer is_bind_email = userBaseInfo2.getIs_bind_email();
        if (is_bind_email != null) {
            sQLiteStatement.bindLong(4, is_bind_email.intValue());
        }
        String email = userBaseInfo2.getEmail();
        if (email != null) {
            sQLiteStatement.bindString(5, email);
        }
        Integer sex = userBaseInfo2.getSex();
        if (sex != null) {
            sQLiteStatement.bindLong(6, sex.intValue());
        }
        String user_id = userBaseInfo2.getUser_id();
        if (user_id != null) {
            sQLiteStatement.bindString(7, user_id);
        }
        String nick_name = userBaseInfo2.getNick_name();
        if (nick_name != null) {
            sQLiteStatement.bindString(8, nick_name);
        }
        String signature = userBaseInfo2.getSignature();
        if (signature != null) {
            sQLiteStatement.bindString(9, signature);
        }
        String url = userBaseInfo2.getUrl();
        if (url != null) {
            sQLiteStatement.bindString(10, url);
        }
        String country = userBaseInfo2.getCountry();
        if (country != null) {
            sQLiteStatement.bindString(11, country);
        }
        String province = userBaseInfo2.getProvince();
        if (province != null) {
            sQLiteStatement.bindString(12, province);
        }
        String city = userBaseInfo2.getCity();
        if (city != null) {
            sQLiteStatement.bindString(13, city);
        }
        String user_name = userBaseInfo2.getUser_name();
        if (user_name != null) {
            sQLiteStatement.bindString(14, user_name);
        }
        String identity_tag = userBaseInfo2.getIdentity_tag();
        if (identity_tag != null) {
            sQLiteStatement.bindString(15, identity_tag);
        }
        String company_name = userBaseInfo2.getCompany_name();
        if (company_name != null) {
            sQLiteStatement.bindString(16, company_name);
        }
        String company_logo = userBaseInfo2.getCompany_logo();
        if (company_logo != null) {
            sQLiteStatement.bindString(17, company_logo);
        }
        String company_fax = userBaseInfo2.getCompany_fax();
        if (company_fax != null) {
            sQLiteStatement.bindString(18, company_fax);
        }
        String company_address = userBaseInfo2.getCompany_address();
        if (company_address != null) {
            sQLiteStatement.bindString(19, company_address);
        }
        String company = userBaseInfo2.getCompany();
        if (company != null) {
            sQLiteStatement.bindString(20, company);
        }
        String contact = userBaseInfo2.getContact();
        if (contact != null) {
            sQLiteStatement.bindString(21, contact);
        }
        String address = userBaseInfo2.getAddress();
        if (address != null) {
            sQLiteStatement.bindString(22, address);
        }
        String qq = userBaseInfo2.getQq();
        if (qq != null) {
            sQLiteStatement.bindString(23, qq);
        }
        String weixin = userBaseInfo2.getWeixin();
        if (weixin != null) {
            sQLiteStatement.bindString(24, weixin);
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long getKey(UserBaseInfo userBaseInfo) {
        UserBaseInfo userBaseInfo2 = userBaseInfo;
        if (userBaseInfo2 != null) {
            return userBaseInfo2.getId();
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, UserBaseInfo userBaseInfo, int i) {
        UserBaseInfo userBaseInfo2 = userBaseInfo;
        int i2 = i + 0;
        userBaseInfo2.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        userBaseInfo2.setIs_bind_mobile(cursor.isNull(i3) ? null : Integer.valueOf(cursor.getInt(i3)));
        int i4 = i + 2;
        userBaseInfo2.setMobile(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        userBaseInfo2.setIs_bind_email(cursor.isNull(i5) ? null : Integer.valueOf(cursor.getInt(i5)));
        int i6 = i + 4;
        userBaseInfo2.setEmail(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        userBaseInfo2.setSex(cursor.isNull(i7) ? null : Integer.valueOf(cursor.getInt(i7)));
        int i8 = i + 6;
        userBaseInfo2.setUser_id(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 7;
        userBaseInfo2.setNick_name(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 8;
        userBaseInfo2.setSignature(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 9;
        userBaseInfo2.setUrl(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 10;
        userBaseInfo2.setCountry(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 11;
        userBaseInfo2.setProvince(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 12;
        userBaseInfo2.setCity(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i + 13;
        userBaseInfo2.setUser_name(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i + 14;
        userBaseInfo2.setIdentity_tag(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i + 15;
        userBaseInfo2.setCompany_name(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i + 16;
        userBaseInfo2.setCompany_logo(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i + 17;
        userBaseInfo2.setCompany_fax(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i20 = i + 18;
        userBaseInfo2.setCompany_address(cursor.isNull(i20) ? null : cursor.getString(i20));
        int i21 = i + 19;
        userBaseInfo2.setCompany(cursor.isNull(i21) ? null : cursor.getString(i21));
        int i22 = i + 20;
        userBaseInfo2.setContact(cursor.isNull(i22) ? null : cursor.getString(i22));
        int i23 = i + 21;
        userBaseInfo2.setAddress(cursor.isNull(i23) ? null : cursor.getString(i23));
        int i24 = i + 22;
        userBaseInfo2.setQq(cursor.isNull(i24) ? null : cursor.getString(i24));
        int i25 = i + 23;
        userBaseInfo2.setWeixin(cursor.isNull(i25) ? null : cursor.getString(i25));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(UserBaseInfo userBaseInfo, long j) {
        userBaseInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public UserBaseInfoDao(DaoConfig daoConfig, GoloDaoSession goloDaoSession) {
        super(daoConfig, goloDaoSession);
    }

    /* renamed from: a */
    public static void m8762a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE 'USER_BASE_INFO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'IS_BIND_MOBILE' INTEGER,'MOBILE' TEXT,'IS_BIND_EMAIL' INTEGER,'EMAIL' TEXT,'SEX' INTEGER,'USER_ID' TEXT,'NICK_NAME' TEXT,'SIGNATURE' TEXT,'URL' TEXT,'COUNTRY' TEXT,'PROVINCE' TEXT,'CITY' TEXT,'USER_NAME' TEXT,'IDENTITY_TAG' TEXT,'COMPANY_NAME' TEXT,'COMPANY_LOGO' TEXT,'COMPANY_FAX' TEXT,'COMPANY_ADDRESS' TEXT,'COMPANY' TEXT,'CONTACT' TEXT,'ADDRESS' TEXT,'QQ' TEXT,'WEIXIN' TEXT);");
    }

    /* renamed from: b */
    public static void m8761b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'USER_BASE_INFO'");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ UserBaseInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        Integer valueOf2 = cursor.isNull(i3) ? null : Integer.valueOf(cursor.getInt(i3));
        int i4 = i + 2;
        String string = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        Integer valueOf3 = cursor.isNull(i5) ? null : Integer.valueOf(cursor.getInt(i5));
        int i6 = i + 4;
        String string2 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 5;
        Integer valueOf4 = cursor.isNull(i7) ? null : Integer.valueOf(cursor.getInt(i7));
        int i8 = i + 6;
        String string3 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 7;
        String string4 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 8;
        String string5 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 9;
        String string6 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = i + 10;
        String string7 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i + 11;
        String string8 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i + 12;
        String string9 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 13;
        String string10 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 14;
        String string11 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 15;
        String string12 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i + 16;
        String string13 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i + 17;
        String string14 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = i + 18;
        String string15 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 19;
        String string16 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = i + 20;
        String string17 = cursor.isNull(i22) ? null : cursor.getString(i22);
        int i23 = i + 21;
        String string18 = cursor.isNull(i23) ? null : cursor.getString(i23);
        int i24 = i + 22;
        String string19 = cursor.isNull(i24) ? null : cursor.getString(i24);
        int i25 = i + 23;
        return new UserBaseInfo(valueOf, valueOf2, string, valueOf3, string2, valueOf4, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, cursor.isNull(i25) ? null : cursor.getString(i25));
    }
}
