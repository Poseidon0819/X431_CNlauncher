package com.cnlaunch.mycar.jni;

import android.util.Log;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamWithSubItemBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class JniX431FileTest {
    private static final int DS_TYPE_1 = 256;
    private static final int DS_TYPE_2 = 257;
    private static final int DS_TYPE_3 = 512;
    private static final int DS_TYPE_4 = 515;
    private static final int DS_TYPE_5 = 517;
    private static final int DS_TYPE_6 = 768;
    private static final int DS_TYPE_7 = 769;
    private static final int DS_TYPE_8 = 787;
    private static final int DS_TYPE_9 = 771;
    private static final String TAG = "JniX431FileTest";
    private static JniX431File mJxf = new JniX431File();

    boolean Write_Userinfo(long j) {
        LSX_USERINFO lsx_userinfo = new LSX_USERINFO();
        lsx_userinfo.name = "customer A";
        lsx_userinfo.phone = "77777777";
        lsx_userinfo.license = "123456";
        return mJxf.lsx_write_userinfo(j, lsx_userinfo) == 0;
    }

    boolean Write_Baseinfo(long j) {
        LSX_BASEINFO lsx_baseinfo = new LSX_BASEINFO();
        lsx_baseinfo.productid = (short) 22;
        lsx_baseinfo.codepage = 65001;
        lsx_baseinfo.langname = "";
        lsx_baseinfo.langcode = "cn";
        lsx_baseinfo.langcode_en = "en";
        lsx_baseinfo.diagversion = "";
        lsx_baseinfo.serialno = "";
        return mJxf.lsx_write_baseinfo(j, lsx_baseinfo) == 0;
    }

    boolean Write_Spinfo(long j) {
        LSX_SPINFO lsx_spinfo = new LSX_SPINFO();
        lsx_spinfo.name = "经销商A";
        lsx_spinfo.phone = "88888888";
        return mJxf.lsx_write_spinfo(j, lsx_spinfo) == 0;
    }

    boolean Write_Autoinfo(long j) {
        LSX_AUTOINFO lsx_autoinfo = new LSX_AUTOINFO();
        lsx_autoinfo.model = "奥迪";
        lsx_autoinfo.make = "Volkswagen";
        lsx_autoinfo.year = "2006";
        lsx_autoinfo.madein = "China";
        lsx_autoinfo.chassis = "chassis";
        lsx_autoinfo.enginemodel = "engine model";
        lsx_autoinfo.displacement = "2.0L";
        lsx_autoinfo.vin = "12345678901234567";
        return mJxf.lsx_write_autoinfo(j, lsx_autoinfo) == 0;
    }

    boolean Write_Baseinfo_langexttest(long j, String str, String str2) {
        LSX_BASEINFO lsx_baseinfo = new LSX_BASEINFO();
        lsx_baseinfo.productid = (short) 21;
        lsx_baseinfo.codepage = -13604;
        lsx_baseinfo.langname = str2;
        lsx_baseinfo.langcode = str;
        lsx_baseinfo.langcode_en = "en";
        lsx_baseinfo.diagversion = "Audi V13.00";
        lsx_baseinfo.serialno = "980241111111";
        return mJxf.lsx_write_baseinfo(j, lsx_baseinfo) == 0;
    }

    boolean Write_Baseinfo_itemtest(long j) {
        LSX_BASEINFO lsx_baseinfo = new LSX_BASEINFO();
        lsx_baseinfo.productid = (short) 21;
        lsx_baseinfo.codepage = 936;
        lsx_baseinfo.langname = "Chinese Simplified";
        lsx_baseinfo.langcode = "cn";
        lsx_baseinfo.langcode_en = "en";
        lsx_baseinfo.diagversion = "Audi V13.00";
        lsx_baseinfo.serialno = "980241111111";
        return mJxf.lsx_write_baseinfo(j, lsx_baseinfo) == 0;
    }

    boolean Write_Rdn(long j) {
        LSX_STRING[] lsx_stringArr = new LSX_STRING[10];
        LSX_STRING[] lsx_stringArr2 = new LSX_STRING[10];
        for (int i = 0; i < 10; i++) {
            lsx_stringArr[i] = new LSX_STRING();
            lsx_stringArr2[i] = new LSX_STRING();
        }
        lsx_stringArr[0].str = "RDN 名称1";
        lsx_stringArr[0].str_en = "rdn name1";
        lsx_stringArr[1].str = "RDN 名称2";
        lsx_stringArr[1].str_en = "rdn name2";
        lsx_stringArr[2].str = "RDN 名称3";
        lsx_stringArr[2].str_en = "rdn name3";
        lsx_stringArr[3].str = "RDN 名称4";
        lsx_stringArr[3].str_en = "rdn name4";
        lsx_stringArr[4].str = "RDN 名称5";
        lsx_stringArr[4].str_en = "rdn name5";
        lsx_stringArr[5].str = "RDN 名称6";
        lsx_stringArr[5].str_en = "rdn name6";
        lsx_stringArr[6].str = "RDN 名称7";
        lsx_stringArr[6].str_en = "rdn name7";
        lsx_stringArr2[0].str = "RDN 数值1";
        lsx_stringArr2[0].str_en = "rdn item1";
        lsx_stringArr2[1].str = "RDN 数值2";
        lsx_stringArr2[1].str_en = "rdn item2";
        lsx_stringArr2[2].str = "RDN 数值3";
        lsx_stringArr2[2].str_en = "rdn item3";
        lsx_stringArr2[3].str = "RDN 数值4";
        lsx_stringArr2[3].str_en = "rdn item4";
        lsx_stringArr2[4].str = "RDN 数值5";
        lsx_stringArr2[4].str_en = "rdn item5";
        lsx_stringArr2[5].str = "RDN 数值6";
        lsx_stringArr2[5].str_en = "rdn item6";
        lsx_stringArr2[6].str = "RDN 数值7";
        lsx_stringArr2[6].str_en = "rdn item7";
        return mJxf.lsx_rec_writereadiness(j, lsx_stringArr, lsx_stringArr2, 7) == 0;
    }

    boolean Write_DsBasics(long j) {
        LSX_STRING[] lsx_stringArr = new LSX_STRING[10];
        LSX_STRING[] lsx_stringArr2 = new LSX_STRING[10];
        for (int i = 0; i < 10; i++) {
            lsx_stringArr[i] = new LSX_STRING();
            lsx_stringArr2[i] = new LSX_STRING();
        }
        lsx_stringArr[0].str = "数据流 名称1";
        lsx_stringArr[0].str_en = "ds name1";
        lsx_stringArr[1].str = "数据流 名称2";
        lsx_stringArr[1].str_en = "ds name2";
        lsx_stringArr[2].str = "数据流 名称3";
        lsx_stringArr[2].str_en = "ds name3";
        lsx_stringArr[3].str = "数据流 名称4";
        lsx_stringArr[3].str_en = "ds name4";
        lsx_stringArr[4].str = "数据流 名称5";
        lsx_stringArr[4].str_en = "ds name5";
        lsx_stringArr[5].str = "数据流 名称6";
        lsx_stringArr[5].str_en = "ds name6";
        lsx_stringArr[6].str = "数据流 名称7";
        lsx_stringArr[6].str_en = "ds name7";
        lsx_stringArr[7].str = "数据流 名称8";
        lsx_stringArr[7].str_en = "ds name8";
        lsx_stringArr[8].str = "数据流 名称9";
        lsx_stringArr[8].str_en = "ds name9";
        lsx_stringArr2[0].str = "数据流 单位1";
        lsx_stringArr2[0].str_en = "ds unit1";
        lsx_stringArr2[1].str = "数据流 单位2";
        lsx_stringArr2[1].str_en = "ds unit2";
        lsx_stringArr2[2].str = "数据流 单位3";
        lsx_stringArr2[2].str_en = "ds unit3";
        lsx_stringArr2[3].str = "数据流 单位4";
        lsx_stringArr2[3].str_en = "ds unit4";
        lsx_stringArr2[4].str = "数据流 单位5";
        lsx_stringArr2[4].str_en = "ds unit5";
        lsx_stringArr2[5].str = "数据流 单位6";
        lsx_stringArr2[5].str_en = "ds unit6";
        lsx_stringArr2[6].str = "数据流 单位7";
        lsx_stringArr2[6].str_en = "ds unit7";
        lsx_stringArr2[7].str = "数据流 单位8";
        lsx_stringArr2[7].str_en = "ds unit8";
        lsx_stringArr2[8].str = "数据流 单位9";
        lsx_stringArr2[8].str_en = "ds unit9";
        return mJxf.lsx_rec_writedsbasics(j, lsx_stringArr, lsx_stringArr2, new int[]{256, 0, 512, 0, 517, 768, 0, DS_TYPE_8}, 9) == 0;
    }

    boolean Write_Ds(long j, int i, int i2) {
        LSX_STRING[] lsx_stringArr = new LSX_STRING[10];
        for (int i3 = 0; i3 < 10; i3++) {
            lsx_stringArr[i3] = new LSX_STRING();
        }
        int i4 = i;
        int i5 = 0;
        do {
            i5++;
            if (i5 > i2) {
                break;
            }
            for (int i6 = 0; i6 < 18; i6 += 2) {
                int i7 = i6 / 2;
                LSX_STRING lsx_string = lsx_stringArr[i7];
                StringBuilder sb = new StringBuilder("数据流 数值");
                sb.append(i4);
                sb.append(",");
                int i8 = i7 + 1;
                sb.append(i8);
                lsx_string.str = sb.toString();
                LSX_STRING lsx_string2 = lsx_stringArr[i7];
                lsx_string2.str_en = "ds item" + i4 + "," + i8;
            }
            i4++;
        } while (mJxf.lsx_rec_writeds(j, lsx_stringArr, 9) == 0);
        return i5 == i2 + 1;
    }

    public void TEST_GroupItemWriteTest() {
        X431Integer x431Integer;
        String str = FileUtils.sdCardGetDirectoryPath() + File.separator + "itemtest.x431";
        long lsx_init = mJxf.lsx_init();
        if (FileUtils.isFileExist(str)) {
            FileUtils.DeleFile(str);
        }
        long lsx_open = mJxf.lsx_open(lsx_init, new X431String(str), 2, new X431Integer(10));
        if (lsx_open == 0) {
            Log.e(TAG, "error =" + x431Integer.mValue);
        }
        Log.e(TAG, "file =".concat(String.valueOf(lsx_open)));
        Write_Baseinfo_itemtest(lsx_open);
        long lsx_rec_writenewgroup = mJxf.lsx_rec_writenewgroup(lsx_open, "Audi", "Canbus", "12345678976543210", "2008/09/26 21:30:31", 2);
        Log.e(TAG, "grp =".concat(String.valueOf(lsx_rec_writenewgroup)));
        Write_DsBasics(lsx_rec_writenewgroup);
        Write_Ds(lsx_rec_writenewgroup, 1, 13);
        mJxf.lsx_rec_finishnewgroup(lsx_rec_writenewgroup, "2008/09/26/23:01:03");
        mJxf.lsx_close(lsx_open);
        mJxf.lsx_deinit(lsx_init);
    }

    public long init() {
        return mJxf.lsx_init();
    }

    public long creatFile(String str, String str2, String str3, String str4, long j, String str5) {
        String replaceAll = str5.replaceAll("//", "/");
        String str6 = replaceAll + str;
        File file = new File(replaceAll);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (FileUtils.isFileExist(str6)) {
            return -1L;
        }
        long lsx_open = mJxf.lsx_open(j, new X431String(str6), 2, new X431Integer(10));
        if (lsx_open != 0) {
            Boolean.valueOf(Write_File_Baseinfo(lsx_open, str2, str3, str4));
            return lsx_open;
        }
        return lsx_open;
    }

    private boolean Write_File_Baseinfo(long j, String str, String str2, String str3) {
        LSX_BASEINFO lsx_baseinfo = new LSX_BASEINFO();
        lsx_baseinfo.productid = (short) 22;
        lsx_baseinfo.codepage = 65001;
        lsx_baseinfo.langname = str;
        lsx_baseinfo.langcode = str;
        lsx_baseinfo.langcode_en = "en";
        lsx_baseinfo.diagversion = str2;
        lsx_baseinfo.serialno = str3;
        return mJxf.lsx_write_baseinfo(j, lsx_baseinfo) == 0;
    }

    public long writeNewGroup(long j, String str, String str2) {
        return mJxf.lsx_rec_writenewgroup(j, str, "Canbus", "12345678976543210", str2, 2);
    }

    private int getDsRealCount(ArrayList<BasicDataStreamBean> arrayList) {
        Iterator<BasicDataStreamBean> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            BasicDataStreamBean next = it.next();
            i = next instanceof BasicDataStreamWithSubItemBean ? i + ((BasicDataStreamWithSubItemBean) next).getArrSubItemDataStream().size() : i + 1;
        }
        return i;
    }

    public boolean writeDsBasics(long j, ArrayList<BasicDataStreamBean> arrayList) {
        if (j != 0) {
            int dsRealCount = getDsRealCount(arrayList);
            int i = dsRealCount + 1;
            LSX_STRING[] lsx_stringArr = new LSX_STRING[i];
            LSX_STRING[] lsx_stringArr2 = new LSX_STRING[i];
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3) instanceof BasicDataStreamWithSubItemBean) {
                    BasicDataStreamWithSubItemBean basicDataStreamWithSubItemBean = (BasicDataStreamWithSubItemBean) arrayList.get(i3);
                    int size = basicDataStreamWithSubItemBean.getArrSubItemDataStream().size();
                    String str = basicDataStreamWithSubItemBean.getTitle() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                    int i4 = i2;
                    for (int i5 = 0; i5 < size; i5++) {
                        BasicDataStreamBean basicDataStreamBean = basicDataStreamWithSubItemBean.getArrSubItemDataStream().get(i5);
                        lsx_stringArr[i4] = new LSX_STRING();
                        lsx_stringArr2[i4] = new LSX_STRING();
                        lsx_stringArr[i4].str = str + basicDataStreamBean.getTitle();
                        lsx_stringArr[i4].str_en = str + basicDataStreamBean.getTitle();
                        lsx_stringArr2[i4].str = basicDataStreamBean.getSrcUnit();
                        lsx_stringArr2[i4].str_en = basicDataStreamBean.getSrcUnit();
                        i4++;
                    }
                    i2 = i4;
                } else {
                    lsx_stringArr[i2] = new LSX_STRING();
                    lsx_stringArr2[i2] = new LSX_STRING();
                    lsx_stringArr[i2].str = arrayList.get(i2).getTitle();
                    lsx_stringArr[i2].str_en = arrayList.get(i2).getTitle();
                    lsx_stringArr2[i2].str = arrayList.get(i2).getSrcUnit();
                    lsx_stringArr2[i2].str_en = arrayList.get(i2).getSrcUnit();
                    i2++;
                }
            }
            return mJxf.lsx_rec_writedsbasics(j, lsx_stringArr, lsx_stringArr2, new int[i], dsRealCount) == 0;
        }
        return false;
    }

    public boolean writeDsBasics(long j, ArrayList<BasicDataStreamBean> arrayList, ArrayList<RANGE_STRING> arrayList2, int[] iArr) {
        if (0 == j) {
            return false;
        }
        int size = arrayList.size();
        LSX_STRING[] lsx_stringArr = new LSX_STRING[size];
        LSX_STRING[] lsx_stringArr2 = new LSX_STRING[size];
        for (int i = 0; i < size; i++) {
            lsx_stringArr[i] = new LSX_STRING();
            lsx_stringArr2[i] = new LSX_STRING();
            lsx_stringArr[i].str = arrayList.get(i).getTitle();
            lsx_stringArr[i].str_en = arrayList.get(i).getTitle();
            lsx_stringArr2[i].str = arrayList.get(i).getSrcUnit();
            lsx_stringArr2[i].str_en = arrayList.get(i).getSrcUnit();
        }
        int size2 = arrayList2.size();
        RANGE_STRING[] range_stringArr = new RANGE_STRING[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            range_stringArr[i2] = new RANGE_STRING();
            range_stringArr[i2] = arrayList2.get(i2);
        }
        return mJxf.lsx_rec_writedsbasicsex(j, lsx_stringArr, lsx_stringArr2, range_stringArr, iArr, size) == 0;
    }

    public boolean writeTag(long j, int i) {
        return j != 0 && mJxf.lsx_write_taginfo(j, i) == 0;
    }

    public boolean readTag(long j, X431Integer x431Integer) {
        return j != 0 && mJxf.lsx_read_taginfo(j, x431Integer) == 0;
    }

    public ArrayList<RANGE_STRING> readDSRange(long j, int i) {
        if (0 == j || i == 0) {
            return null;
        }
        String[] strArr = new String[i];
        String[] strArr2 = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = new String();
            strArr2[i2] = new String();
        }
        if (mJxf.lsx_rec_readdsrange(j, strArr, strArr2, i) == 0) {
            ArrayList<RANGE_STRING> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < i; i3++) {
                RANGE_STRING range_string = new RANGE_STRING();
                range_string.max = strArr[i3];
                range_string.min = strArr2[i3];
                arrayList.add(range_string);
            }
            return arrayList;
        }
        return null;
    }

    public int[] readDSType(long j, int i) {
        if (0 == j || i == 0) {
            return null;
        }
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = 0;
        }
        if (mJxf.lsx_rec_readdstype(j, iArr, i) == 0) {
            return iArr;
        }
        return null;
    }

    public void writeDSDate(long j, ArrayList<BasicDataStreamBean> arrayList) {
        int dsRealCount = getDsRealCount(arrayList);
        LSX_STRING[] lsx_stringArr = new LSX_STRING[dsRealCount];
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2) instanceof BasicDataStreamWithSubItemBean) {
                BasicDataStreamWithSubItemBean basicDataStreamWithSubItemBean = (BasicDataStreamWithSubItemBean) arrayList.get(i2);
                int size = basicDataStreamWithSubItemBean.getArrSubItemDataStream().size();
                int i3 = i;
                for (int i4 = 0; i4 < size; i4++) {
                    lsx_stringArr[i3] = new LSX_STRING();
                    lsx_stringArr[i3].str = basicDataStreamWithSubItemBean.getArrSubItemDataStream().get(i4).getSrcValue();
                    i3++;
                }
                i = i3;
            } else {
                lsx_stringArr[i] = new LSX_STRING();
                lsx_stringArr[i].str = arrayList.get(i).getSrcValue();
                i++;
            }
        }
        mJxf.lsx_rec_writeds(j, lsx_stringArr, dsRealCount);
    }

    public void writeEndCloseFile(long j, String str, long j2, long j3, String str2) {
        if (mJxf.lsx_rec_finishnewgroup(j, str) == 0) {
            mJxf.lsx_close(j2);
            mJxf.lsx_deinit(j3);
        }
    }

    public long openFile(String str, long j) {
        if (FileUtils.isFileExist(str)) {
            long lsx_open = mJxf.lsx_open(j, new X431String(str), 1, new X431Integer(10));
            return lsx_open != 0 ? lsx_open : lsx_open;
        }
        return -1L;
    }

    public long readGroupId(long j) {
        return mJxf.lsx_rec_readgroupid(j, 1);
    }

    public int readGroupItemCount(long j) {
        return mJxf.lsx_rec_readdsitemcount(j);
    }

    public int readGroupItemColCount(long j) {
        return mJxf.lsx_rec_readdscolcount(j);
    }

    public String[] readDsNames(long j, int i) {
        if (j != 0) {
            String[] strArr = new String[i];
            return mJxf.lsx_rec_readdsname(j, strArr, i) == 0 ? strArr : new String[0];
        }
        return new String[0];
    }

    public String[] readDsunitstrs(long j, int i) {
        if (j != 0) {
            String[] strArr = new String[i];
            return mJxf.lsx_rec_readdsunit(j, strArr, i) == 0 ? strArr : new String[0];
        }
        return new String[0];
    }

    public long readDsDataFirstItemCount(long j) {
        return mJxf.lsx_rec_readfirstdsitem(j);
    }

    public String[] readDsDataFirstItemData(long j, int i, long j2) {
        String[] strArr = new String[i];
        return (j2 == 0 || mJxf.lsx_rec_readds(j2, strArr, i) != 0) ? new String[0] : strArr;
    }

    public String[] readDsDataNextItemData(long j, int i, long j2) {
        String[] strArr = new String[i];
        long lsx_rec_readrelndsitem = mJxf.lsx_rec_readrelndsitem(j2, 1);
        return (lsx_rec_readrelndsitem == 0 || mJxf.lsx_rec_readds(lsx_rec_readrelndsitem, strArr, i) != 0) ? new String[0] : strArr;
    }

    public void readEndCloseFile(long j, long j2) {
        mJxf.lsx_close(j);
        mJxf.lsx_deinit(j2);
    }
}
