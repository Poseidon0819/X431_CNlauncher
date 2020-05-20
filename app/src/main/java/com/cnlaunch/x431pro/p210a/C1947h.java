package com.cnlaunch.x431pro.p210a;

import android.os.Environment;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.Constants;
import com.cnlaunch.x431pro.utils.C2778n;
import java.util.ArrayList;

/* compiled from: Constants.java */
/* renamed from: com.cnlaunch.x431pro.a.h */
/* loaded from: classes.dex */
public final class C1947h extends Constants {

    /* renamed from: j */
    public static ArrayList<BasicSelectMenuBean> f10558j;

    /* renamed from: b */
    public static String f10550b = Environment.getExternalStorageDirectory() + "/cnlaunch/x431pro/images/";

    /* renamed from: c */
    public static boolean f10551c = false;

    /* renamed from: d */
    public static boolean f10552d = false;

    /* renamed from: e */
    public static boolean f10553e = true;

    /* renamed from: f */
    public static String f10554f = "printer_ip";

    /* renamed from: g */
    public static String f10555g = "is_Show_Printer_set";

    /* renamed from: h */
    public static String f10556h = "lastest_Version_Number";

    /* renamed from: i */
    public static String f10557i = "luancher_name";

    /* renamed from: k */
    public static int f10559k = -1;

    /* renamed from: l */
    public static String f10560l = "8";

    /* renamed from: m */
    public static String f10561m = "7";

    /* renamed from: n */
    public static String f10562n = "6";

    /* renamed from: o */
    public static String f10563o = DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_SUBMODEL;

    /* renamed from: p */
    public static String f10564p = "4";

    /* renamed from: q */
    public static String f10565q = "3";

    /* renamed from: r */
    public static String f10566r = "2";

    /* renamed from: s */
    public static String f10567s = "1";

    /* renamed from: t */
    public static String f10568t = "0";

    /* renamed from: u */
    public static boolean f10569u = false;

    /* compiled from: Constants.java */
    /* renamed from: com.cnlaunch.x431pro.a.h$a */
    /* loaded from: classes.dex */
    public static final class C1948a {

        /* renamed from: a */
        public static final C2778n.C2783c.C2784a f10570a = new C2778n.C2783c.C2784a("changyiHome", "http://www.car388.com/system-yuanzheng/anzhuo.php");

        /* renamed from: b */
        public static final C2778n.C2783c.C2784a f10571b = new C2778n.C2783c.C2784a("alipayQrCodeCy", "https://mycar.x431.com/alipay/qrCode/alipayQrCodeCy.action");

        /* renamed from: c */
        public static final C2778n.C2783c.C2784a f10572c = new C2778n.C2783c.C2784a("getCyUserInfo", "https://mycar.x431.com/rest/inner/cyUser/getCyUserInfo.json");

        /* renamed from: d */
        public static final C2778n.C2783c.C2784a f10573d = new C2778n.C2783c.C2784a("getCyOrderInfoList", "https://mycar.x431.com/rest/inner/cyUser/getCyOrderInfoList.json");

        /* renamed from: e */
        public static final C2778n.C2783c.C2784a f10574e = new C2778n.C2783c.C2784a("getCreateCyUserOrder", "https://mycar.x431.com/rest/inner/cyUser/createCyUserOrder.json");
    }
}
