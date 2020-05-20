package com.cnlaunch.mycar.jni;

/* loaded from: classes.dex */
public class JniX431File {
    public static final String DSUNIT_DTCS = "dtcs";
    public static final String DSUNIT_TIME = "dstime";
    public static final int DS_TYPE_ENGINEPOWERBALANCE = 1;
    public static final int DS_TYPE_ENGINEPOWERBALANCE_ADDITION = 3;
    public static final int DS_TYPE_ENGINESPEED = 2;
    public static final int DS_TYPE_UNKNOWN = 0;
    public static final int DS_TYPE_VEHICHLE_VOLTAGE = 4;
    public static final int LSX_ERR_ALLOC_MEMORY = -6;
    public static final int LSX_ERR_FILE_NOTFOUND = -3;
    public static final int LSX_ERR_HIGH_FILEVERSION = -2;
    public static final int LSX_ERR_INCORRECT_FORMAT = -4;
    public static final int LSX_ERR_INVALID_PARAMETER = -5;
    public static final int LSX_ERR_LOW_FILEVERSION = -1;
    public static final int LSX_ERR_OK = 0;
    public static final int LSX_FILE_READABLE = 1;
    public static final int LSX_FILE_V2 = 4096;
    public static final int LSX_FILE_V3 = 8192;
    public static final int LSX_FILE_WRITABLE = 2;
    public static final int MAX_DS_COLNUMBER = 300;
    public static final int MODE_READ = 1;
    public static final int MODE_WRITE = 2;
    public static final int PRODUCT_ADM = 19;
    public static final int PRODUCT_ANDROIDSERIES = 22;
    public static final int PRODUCT_CRECORDER = 21;
    public static final int PRODUCT_PCCENTER = 18;
    public static final int PRODUCT_PCLINK = 17;
    public static final int PRODUCT_RECORDER = 20;
    public static final int PRODUCT_UNKNOWN = 0;
    public static final int PRODUCT_X431 = 1;
    public static final int PRODUCT_X4313G = 7;
    public static final int PRODUCT_X431GDS = 8;
    public static final int PRODUCT_X431INFINITE = 2;
    public static final int PRODUCT_X431NCP = 6;
    public static final int PRODUCT_X431PC = 5;
    public static final int PRODUCT_X431TOOL = 4;
    public static final int PRODUCT_X431TOP = 3;
    public static final int RECORD_DATASTREAM = 2;
    public static final int RECORD_DSBASICS = 32;
    public static final int RECORD_DTC = 1;
    public static final int RECORD_FREEZEFRAME = 8;
    public static final int RECORD_READINESS = 16;
    public static final int RECORD_VERSIONINFO = 4;

    public native int lsx_checkfile(X431String x431String);

    public native int lsx_close(long j);

    public native int lsx_deinit(long j);

    public native long lsx_init();

    public native long lsx_open(long j, X431String x431String, int i, X431Integer x431Integer);

    public native int lsx_read_autoinfo(long j, LSX_AUTOINFO lsx_autoinfo);

    public native int lsx_read_baseinfo(long j, LSX_BASEINFO lsx_baseinfo);

    public native int lsx_read_fileversion(long j);

    public native int lsx_read_langcode(long j, X431String x431String, X431String x431String2);

    public native int lsx_read_spinfo(long j, LSX_SPINFO lsx_spinfo);

    public native int lsx_read_taginfo(long j, X431Integer x431Integer);

    public native int lsx_read_userinfo(long j, LSX_USERINFO lsx_userinfo);

    public native int lsx_rec_finishnewgroup(long j, String str);

    public native int lsx_rec_readalltype(long j);

    public native int lsx_rec_readds(long j, String[] strArr, int i);

    public native int lsx_rec_readdscolcount(long j);

    public native int lsx_rec_readdsitemcount(long j);

    public native int lsx_rec_readdsname(long j, String[] strArr, int i);

    public native int lsx_rec_readdsrange(long j, String[] strArr, String[] strArr2, int i);

    public native int lsx_rec_readdstype(long j, int[] iArr, int i);

    public native int lsx_rec_readdsunit(long j, String[] strArr, int i);

    public native int lsx_rec_readdtc(long j, X431String x431String, X431String x431String2, X431String x431String3, X431String x431String4);

    public native int lsx_rec_readdtccount(long j);

    public native int lsx_rec_readdtcinfo(long j, String str, X431String x431String, X431String x431String2, X431String x431String3);

    public native int lsx_rec_readffcolcount(long j);

    public native int lsx_rec_readffitemcount(long j);

    public native long lsx_rec_readfirstdsitem(long j);

    public native long lsx_rec_readfirstdtcitem(long j);

    public native long lsx_rec_readfirstffitem(long j);

    public native long lsx_rec_readfirstitem(long j);

    public native int lsx_rec_readfreezeframe(long j, X431String x431String, String[] strArr, int i);

    public native int lsx_rec_readgroupcount(long j);

    public native long lsx_rec_readgroupid(long j, int i);

    public native int lsx_rec_readgroupinfo(long j, X431String x431String, X431String x431String2, X431String x431String3, X431String x431String4, X431String x431String5, X431Integer x431Integer);

    public native int lsx_rec_readitemtype(long j);

    public native long lsx_rec_readlastdsitem(long j);

    public native long lsx_rec_readlastdtcitem(long j);

    public native long lsx_rec_readlastffitem(long j);

    public native long lsx_rec_readlastitem(long j);

    public native long lsx_rec_readnextdtcitem(long j);

    public native long lsx_rec_readnextffitem(long j);

    public native long lsx_rec_readnextitem(long j);

    public native long lsx_rec_readprevdtcitem(long j);

    public native long lsx_rec_readprevffitem(long j);

    public native long lsx_rec_readprevitem(long j);

    public native long lsx_rec_readrelndsitem(long j, int i);

    public native int lsx_rec_writeds(long j, LSX_STRING[] lsx_stringArr, int i);

    public native int lsx_rec_writedsbasics(long j, LSX_STRING[] lsx_stringArr, LSX_STRING[] lsx_stringArr2, int[] iArr, int i);

    public native int lsx_rec_writedsbasicsex(long j, LSX_STRING[] lsx_stringArr, LSX_STRING[] lsx_stringArr2, RANGE_STRING[] range_stringArr, int[] iArr, int i);

    public native int lsx_rec_writedtc(long j, String str, LSX_STRING lsx_string, LSX_STRING lsx_string2, String str2);

    public native int lsx_rec_writefreezeframe(long j, String str, LSX_STRING[] lsx_stringArr, LSX_STRING[] lsx_stringArr2, int[] iArr, LSX_STRING[] lsx_stringArr3, int i);

    public native long lsx_rec_writenewgroup(long j, String str, String str2, String str3, String str4, int i);

    public native int lsx_rec_writereadiness(long j, LSX_STRING[] lsx_stringArr, LSX_STRING[] lsx_stringArr2, int i);

    public native int lsx_rec_writevi(long j, LSX_STRING lsx_string);

    public native int lsx_selectreadtextlang(long j, String str);

    public native int lsx_write_autoinfo(long j, LSX_AUTOINFO lsx_autoinfo);

    public native int lsx_write_baseinfo(long j, LSX_BASEINFO lsx_baseinfo);

    public native int lsx_write_spinfo(long j, LSX_SPINFO lsx_spinfo);

    public native int lsx_write_taginfo(long j, int i);

    public native int lsx_write_userinfo(long j, LSX_USERINFO lsx_userinfo);

    static {
        System.loadLibrary("x431file");
    }
}
