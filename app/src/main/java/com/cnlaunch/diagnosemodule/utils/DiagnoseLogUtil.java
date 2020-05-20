package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.C1444R;
import com.cnlaunch.diagnosemodule.service.DiagnoseService;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.p205k.C1856n;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* loaded from: classes.dex */
public class DiagnoseLogUtil {
    private static final byte DATA_TYPE_D4STRING = 2;
    private static final byte DATA_TYPE_DSTRING = 1;
    public static final byte DIAGLOG_TYPE_REAL_TIME_FEEDBACK = 1;
    public static final byte DIAGLOG_TYPE_SPECIAL_FUNCTION = 2;
    public static final int HIS_RECORD_SET_MAKE_ID = 1;
    public static final int HIS_RECORD_SET_MODEL_ID = 2;
    public static final int HIS_RECORD_SET_VIN_ID = 6;
    public static final int HIS_RECORD_SET_YEAR_ID = 5;
    public static final byte INFORMATION_TYPE_DIAGNOSE_BLUETOOTH_EXCEPTION_PACKAGE = 5;
    public static final byte INFORMATION_TYPE_DIAGNOSE_BLUETOOTH_RECEIVE_PACKAGE = 4;
    public static final byte INFORMATION_TYPE_DIAGNOSE_BLUETOOTH_SEND_PACKAGE = 3;
    public static final byte INFORMATION_TYPE_DIAGNOSE_DISPLAY_PACKAGE = 1;
    public static final byte INFORMATION_TYPE_DIAGNOSE_EXCEPTION_PACKAGE = 6;
    public static final byte INFORMATION_TYPE_DIAGNOSE_FEEDBACK_PACKAGE = 2;
    public static final byte INFORMATION_TYPE_DIAGNOSE_RJ45_TCP_RECEIVE_PACKAGE = 10;
    public static final byte INFORMATION_TYPE_DIAGNOSE_RJ45_TCP_SEND_PACKAGE = 9;
    public static final byte INFORMATION_TYPE_DIAGNOSE_RJ45_UDP_RECEIVE_PACKAGE = 12;
    public static final byte INFORMATION_TYPE_DIAGNOSE_RJ45_UDP_SEND_PACKAGE = 11;
    public static final byte INFORMATION_TYPE_DIAGNOSE_SERIALPORT_RECEIVE_PACKAGE = 16;
    public static final byte INFORMATION_TYPE_DIAGNOSE_SERIALPORT_SEND_PACKAGE = 15;
    public static final byte INFORMATION_TYPE_DIAGNOSE_USB_RECEIVE_PACKAGE = 8;
    public static final byte INFORMATION_TYPE_DIAGNOSE_USB_SEND_PACKAGE = 7;
    public static final byte INFORMATION_TYPE_DIAGNOSE_WIFI_RECEIVE_PACKAGE = 14;
    public static final byte INFORMATION_TYPE_DIAGNOSE_WIFI_SEND_PACKAGE = 13;
    static final int LOG_FILE_MAX_LENGTH = 26214400;
    static final int RESERVE_FILE_COUNT = 20;
    public static final int SPT_AUDI_DATASTREAM_ID = 13;
    public static final int SPT_DATASTREAM_ID_EX = 34;
    public static final int SPT_DATASTREAM_ID_EX_STANDARDVALUE = 69;
    public static final int SPT_DATASTREAM_ID_EX_WITH_SYSTEM = 61;
    public static final int SPT_DIAGDATA_RECORD = 63;
    public static final int SPT_EX_DATASTREAM_ID = 18;
    public static final int SPT_HISTORY_RECORD_ID = 105;
    public static final int SPT_VW_DATASTREAM_ID = 19;
    static final String TAG = "DiagnoseLogUtil";
    private static DiagnoseLogUtil instance;
    private ConcurrentLinkedQueue<LogPackage> mSpecialFunctionLogLinkedList;
    private int NO_SCREEN_DIAGNOSELOG_BUFFER_SIZE = 256;
    private LogRecordThread mLogRecordThread = null;
    private boolean isRealFeedBack = false;
    private Context mContext = null;
    private boolean mFeedbackStreamPageFirstFrameFlag = true;
    private boolean mIsSpecialFunctionLogGeneratedState = false;
    private Object mObject = new Object();

    private boolean isPageChanged(int i) {
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            default:
                return false;
        }
    }

    public DiagnoseLogUtil() {
        this.mSpecialFunctionLogLinkedList = null;
        this.mSpecialFunctionLogLinkedList = new ConcurrentLinkedQueue<>();
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public static DiagnoseLogUtil getInstance() {
        if (instance == null) {
            instance = new DiagnoseLogUtil();
        }
        return instance;
    }

    public LogRecordHead getLogRecordHead() {
        return this.mLogRecordThread.getLogRecordHead();
    }

    public void writeBytes(byte[] bArr, byte b) {
        LogRecordThread logRecordThread = this.mLogRecordThread;
        if (logRecordThread == null) {
            return;
        }
        if (logRecordThread.isNoScreenDiagnoseLog() && this.mLogRecordThread.getStopFlag()) {
            C1856n.m8130a(TAG, "ADD No Screen DiagnoseLog product AIT limit，only affect AIT product");
        } else if ((this.mLogRecordThread.isAlive() || isSpecialFunctionLogGeneratedState()) && this.mLogRecordThread.getDiagnoseLogSwitch() && !this.mLogRecordThread.getIsIOException()) {
            if (!this.mLogRecordThread.mIsOnlyCollectUiData || b == 1 || b == 2) {
                if (!this.mLogRecordThread.mIsCollect) {
                    if (b == 1) {
                        if (bArr[3] == 105) {
                            if (bArr[4] == 1) {
                                String byteToWord = ByteHexHelper.byteToWord(Arrays.copyOfRange(bArr, 5, bArr.length - 1));
                                if (!TextUtils.isEmpty(byteToWord)) {
                                    this.mLogRecordThread.setMake(byteToWord.replaceAll("[\\t\\n\\r]", ""));
                                }
                            } else if (bArr[4] == 2) {
                                String byteToWord2 = ByteHexHelper.byteToWord(Arrays.copyOfRange(bArr, 5, bArr.length - 1));
                                if (!TextUtils.isEmpty(byteToWord2)) {
                                    this.mLogRecordThread.setModel(byteToWord2.replaceAll("[\\t\\n\\r]", ""));
                                }
                            } else if (bArr[4] == 5) {
                                String byteToWord3 = ByteHexHelper.byteToWord(Arrays.copyOfRange(bArr, 5, bArr.length - 1));
                                if (!TextUtils.isEmpty(byteToWord3)) {
                                    this.mLogRecordThread.setYear(byteToWord3.replaceAll("[\\t\\n\\r]", ""));
                                }
                            } else if (bArr[4] == 6) {
                                String byteToWord4 = ByteHexHelper.byteToWord(Arrays.copyOfRange(bArr, 5, bArr.length - 1));
                                if (!TextUtils.isEmpty(byteToWord4)) {
                                    this.mLogRecordThread.setVIN(byteToWord4.replaceAll("[\\t\\n\\r]", ""));
                                }
                            }
                        }
                        if ((bArr[3] == 13 || bArr[3] == 18 || bArr[3] == 19 || bArr[3] == 34 || bArr[3] == 61 || bArr[3] == 69) && !this.mFeedbackStreamPageFirstFrameFlag) {
                            return;
                        }
                    } else if (b == 2) {
                        if (bArr[3] == 13 || bArr[3] == 18 || bArr[3] == 19 || bArr[3] == 34 || bArr[3] == 61 || bArr[3] == 69) {
                            if (this.mFeedbackStreamPageFirstFrameFlag) {
                                this.mFeedbackStreamPageFirstFrameFlag = false;
                            } else if (bArr[3] == 34 || bArr[3] == 61 || bArr[3] == 69) {
                                if (isPageChanged(bArr.length >= 9 ? bArr[8] & 255 : 0)) {
                                    this.mFeedbackStreamPageFirstFrameFlag = true;
                                    if (C1856n.f10135a) {
                                        C1856n.m8125d(TAG, "数据流分页已经变化");
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (!this.mFeedbackStreamPageFirstFrameFlag) {
                            this.mFeedbackStreamPageFirstFrameFlag = true;
                        }
                    } else if ((b == 3 || b == 7) && bArr.length > 4096) {
                        return;
                    }
                    if (!this.mFeedbackStreamPageFirstFrameFlag && (b == 3 || b == 4 || b == 7 || b == 8 || b == 13 || b == 14 || b == 15 || b == 16)) {
                        return;
                    }
                }
                try {
                    LogPackage logPackage = new LogPackage(b, Arrays.copyOf(bArr, bArr.length), new Date().getTime());
                    if (isSpecialFunctionLogGeneratedState()) {
                        this.mSpecialFunctionLogLinkedList.offer(logPackage);
                    } else {
                        offerLogPackage(logPackage);
                    }
                    if (!this.mLogRecordThread.mIsCollect && !this.mLogRecordThread.isNoScreenDiagnoseLog() && b == 1 && bArr[3] == 63 && bArr[4] == 1 && bArr[5] == 2) {
                        specialFunctionProcess();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean offerLogPackage(LogPackage logPackage) {
        return this.mLogRecordThread.getLogLinkedList().offer(logPackage);
    }

    public void startRecord() {
        if (this.mLogRecordThread.initLogRecordHead()) {
            this.mLogRecordThread.start();
        }
    }

    public void setIsOnlyUIDataCollect(boolean z) {
        LogRecordThread logRecordThread = this.mLogRecordThread;
        if (logRecordThread != null) {
            logRecordThread.setmIsOnlyCollectUiData(z);
        }
    }

    public void initRecord(boolean z, boolean z2, boolean z3, String str, String str2, boolean z4) {
        LogRecordThread logRecordThread = this.mLogRecordThread;
        if (logRecordThread != null) {
            if (logRecordThread.isAlive()) {
                this.mLogRecordThread.stopThread();
            }
            this.mLogRecordThread = null;
        }
        this.mLogRecordThread = new LogRecordThread(z, z2, z3, str, str2, z4);
        this.mFeedbackStreamPageFirstFrameFlag = true;
    }

    public void stopRecord() {
        LogRecordThread logRecordThread = this.mLogRecordThread;
        if (logRecordThread == null || !logRecordThread.isAlive()) {
            return;
        }
        this.mLogRecordThread.stopThread();
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "等待线程结束");
        }
        synchronized (this) {
            try {
                isSpecialFunctionLogGeneratedState();
                wait(3000L);
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "线程已经结束或等待超时");
                }
            } catch (InterruptedException unused) {
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "线程等待超时被打断");
                }
            }
        }
        try {
            String finalFullFilename = this.mLogRecordThread.getFinalFullFilename();
            String specificLogsPath = this.mLogRecordThread.getSpecificLogsPath();
            if (C1856n.f10135a) {
                C1856n.m8125d(TAG, String.format("处理重卡测试账号特殊逻辑  finalFullFilename=%1$s  specificLogsPath=%2$s", finalFullFilename, specificLogsPath));
            }
            File file = new File(finalFullFilename);
            String name = file.getName();
            if (name.startsWith("98689")) {
                if (name.startsWith("986890001300") || name.startsWith("986890002200") || name.startsWith("986890008800") || name.startsWith("986890003900") || name.startsWith("986891002200") || name.startsWith("986891004700") || name.startsWith("986891004900") || name.startsWith("986891003700") || name.startsWith("986891004600")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
                    int lastIndexOf = name.lastIndexOf("_");
                    String str = specificLogsPath + File.separator + (name.substring(0, lastIndexOf) + "_" + simpleDateFormat.format(new Date()) + ".dat");
                    boolean copyFile = copyFile(file, new File(str), false);
                    if (C1856n.f10135a) {
                        C1856n.m8130a(TAG, String.format("处理重卡测试账号特殊逻辑 复制文件 finalFullFilename=%1$s  newspecificLogsFilename=%2$s isSuccess = %3$s", finalFullFilename, str, Boolean.valueOf(copyFile)));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean copyFile(File file, File file2, boolean z) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        if (file2.exists()) {
            if (!z) {
                return false;
            }
            file2.delete();
        } else if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException unused3) {
            fileInputStream = null;
        } catch (IOException unused4) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    try {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException unused5) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return false;
        } catch (IOException unused6) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return false;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    throw th;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public void realFeedBackProcess() {
        this.isRealFeedBack = true;
        C1856n.m8130a(TAG, "real diagnose log FeedBack start");
        LogRecordThread logRecordThread = this.mLogRecordThread;
        if (logRecordThread != null && logRecordThread.isNoScreenDiagnoseLog()) {
            C1856n.m8130a(TAG, "is No Screen Diagnose Log as ait case");
            stopRecord();
        } else {
            sendRealFeedBackLogMessage(closeCurrentDiagLogAndCreateNewInheritDiagLog((byte) 1));
        }
        C1856n.m8130a(TAG, "real diagnose log FeedBack end");
    }

    public void realFeedbackForIm() {
        closeCurrentDiagLogAndCreateNewInheritDiagLog((byte) 1);
    }

    public void specialFunctionProcess() {
        LogRecordThread logRecordThread = this.mLogRecordThread;
        if (logRecordThread == null || TextUtils.isEmpty(logRecordThread.getSpecificLogsPath())) {
            return;
        }
        C1856n.m8125d(TAG, "特殊功能日志处理开始");
        closeCurrentDiagLogAndCreateNewInheritDiagLog((byte) 2);
        C1856n.m8125d(TAG, "特殊功能日志处理结束");
    }

    private String closeCurrentDiagLogAndCreateNewInheritDiagLog(byte b) {
        byte b2;
        byte b3;
        String name;
        stopRecord();
        String str = "";
        LogRecordThread logRecordThread = this.mLogRecordThread;
        if (logRecordThread != null) {
            String finalFullFilename = logRecordThread.getFinalFullFilename();
            String diagnoseLogPath = this.mLogRecordThread.getDiagnoseLogPath();
            String specificLogsPath = this.mLogRecordThread.getSpecificLogsPath();
            boolean diagnoseLogSwitch = this.mLogRecordThread.getDiagnoseLogSwitch();
            boolean isCollect = this.mLogRecordThread.getIsCollect();
            boolean isNoScreenDiagnoseLog = this.mLogRecordThread.isNoScreenDiagnoseLog();
            int realLogRecordLength = this.mLogRecordThread.getRealLogRecordLength();
            LogRecordHead logRecordHead = this.mLogRecordThread.getLogRecordHead();
            String make = this.mLogRecordThread.getMake();
            String model = this.mLogRecordThread.getModel();
            String year = this.mLogRecordThread.getYear();
            String vin = this.mLogRecordThread.getVIN();
            boolean z = this.mLogRecordThread.isADAS;
            C1856n.m8125d(TAG, String.format("重建日志 finalFullFilename=%1$s  diagnoseLogPath=%2$s diagnoseSwitch=%3$b realFeedbackLogLength=%4$d", finalFullFilename, diagnoseLogPath, Boolean.valueOf(diagnoseLogSwitch), Integer.valueOf(realLogRecordLength)));
            initRecord(diagnoseLogSwitch, isNoScreenDiagnoseLog, isCollect, diagnoseLogPath, specificLogsPath, z);
            LogRecordThread logRecordThread2 = this.mLogRecordThread;
            if (logRecordThread2 != null) {
                logRecordThread2.setMake(make);
                this.mLogRecordThread.setModel(model);
                this.mLogRecordThread.setYear(year);
                this.mLogRecordThread.setVIN(vin);
                b2 = 2;
            } else {
                b2 = 2;
            }
            if (b == b2) {
                setSpecialFunctionLogGeneratedState(true);
            } else {
                setSpecialFunctionLogGeneratedState(false);
            }
            LogRecordHead logRecordHead2 = this.mLogRecordThread.getLogRecordHead();
            if (logRecordHead2 == null || logRecordHead == null) {
                b3 = 2;
            } else {
                logRecordHead2.copyLogRecordHead(logRecordHead);
                logRecordHead2.setCreateDate(new Date(new Date().getTime() + 1000));
                b3 = 2;
            }
            if (b != b3) {
                str = finalFullFilename;
            } else if (TextUtils.isEmpty(specificLogsPath)) {
                str = "";
            } else {
                File file = new File(finalFullFilename);
                int lastIndexOf = file.getName().lastIndexOf(".");
                String str2 = specificLogsPath + File.separator + (name.substring(0, lastIndexOf) + ".tmp");
                if (moveDiagnoseLogToSpecificLogsPathWithTempFile(file, str2)) {
                    str = str2;
                    finalFullFilename = str;
                } else {
                    str = "";
                }
            }
            if (this.mLogRecordThread.initNewInheritDiagLog(b, finalFullFilename, realLogRecordLength)) {
                this.mLogRecordThread.start();
            }
        }
        return str;
    }

    private static boolean moveDiagnoseLogToSpecificLogsPathWithTempFile(File file, String str) {
        boolean renameTo = file.renameTo(new File(str));
        if (renameTo) {
            C1856n.m8125d(TAG, String.format("文件移动成功  原路径：%1$s 移动后路径：%2$s", file.getAbsolutePath(), str));
        } else {
            C1856n.m8125d(TAG, String.format("文件移动失败  原路径：%1$s 移动后路径：%2$s", file.getAbsolutePath(), str));
        }
        return renameTo;
    }

    private static void copyFileUsingFileChannels(String str, String str2) throws IOException {
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(str).getChannel();
            try {
                fileChannel = new FileOutputStream(str2).getChannel();
            } catch (Throwable th) {
                fileChannel2 = channel;
                th = th;
                fileChannel = null;
            }
            try {
                fileChannel.transferFrom(channel, 0L, channel.size());
                channel.close();
                fileChannel.close();
            } catch (Throwable th2) {
                fileChannel2 = channel;
                th = th2;
                fileChannel2.close();
                fileChannel.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendClientMessage(Message message2) {
        Context context = this.mContext;
        if (context != null) {
            DiagnoseService diagnoseService = context instanceof DiagnoseService ? (DiagnoseService) context : null;
            if (diagnoseService != null) {
                C1856n.m8125d(TAG, "get DiagnoseService object");
                diagnoseService.sendClientMessage(message2);
            }
        }
    }

    private void sendRealFeedBackLogMessage(String str) {
        Message obtain = Message.obtain((Handler) null, 53);
        Bundle bundle = new Bundle();
        bundle.putInt(VastExtensionXmlManager.TYPE, 1);
        bundle.putString(DataPacketExtension.ELEMENT_NAME, str);
        obtain.setData(bundle);
        C1856n.m8125d(TAG, "sendRealFeedBackLogMessage ".concat(String.valueOf(str)));
        sendClientMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSpecialFunctionLogMessage(String str) {
        Message obtain = Message.obtain((Handler) null, 53);
        Bundle bundle = new Bundle();
        bundle.putInt(VastExtensionXmlManager.TYPE, 2);
        bundle.putString(DataPacketExtension.ELEMENT_NAME, str);
        obtain.setData(bundle);
        C1856n.m8125d(TAG, "sendSpecialFunctionLogMessage ".concat(String.valueOf(str)));
        sendClientMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendIOExceptionMessage(IOException iOException) {
        Message obtain = Message.obtain((Handler) null, 53);
        Bundle bundle = new Bundle();
        Context context = this.mContext;
        String format = context != null ? String.format("%1$s %2$s", context.getResources().getString(C1444R.string.dialog_log_io_exception), iOException.getMessage()) : "";
        bundle.putInt(VastExtensionXmlManager.TYPE, 0);
        bundle.putString(DataPacketExtension.ELEMENT_NAME, format);
        obtain.setData(bundle);
        C1856n.m8125d(TAG, "sendIOExceptionMessage ".concat(String.valueOf(format)));
        sendClientMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSpecialFunctionLogGeneratedState() {
        boolean z;
        synchronized (this.mObject) {
            z = this.mIsSpecialFunctionLogGeneratedState;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setSpecialFunctionLogGeneratedState(boolean z) {
        synchronized (this.mObject) {
            this.mIsSpecialFunctionLogGeneratedState = z;
        }
    }

    public static byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = new Long(255 & j).byteValue();
            j >>= 8;
        }
        return bArr;
    }

    public static long byteToLong(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24) | ((bArr[4] & 255) << 32) | ((bArr[5] & 255) << 40) | ((bArr[6] & 255) << 48) | ((bArr[7] & 255) << 56);
    }

    public static byte[] intToByte(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public static int byteToInt(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static byte[] shortToByte(short s) {
        byte[] bArr = new byte[2];
        int i = 0;
        int i2 = s;
        while (i < 2) {
            bArr[i] = new Integer(i2 & 255).byteValue();
            i++;
            i2 >>= 8;
        }
        return bArr;
    }

    public static short byteToShort(byte[] bArr) {
        return (short) (((short) (((short) (bArr[1] & 255)) << 8)) | ((short) (bArr[0] & 255)));
    }

    /* loaded from: classes.dex */
    public class LogRecordThread extends Thread {
        private int CURRENT_BUFFER_SIZE;
        private DataOutputStream dataOutputStream;
        private boolean isADAS;
        private String mDiagnoseLogPath;
        private boolean mDiagnoseLogSwitch;
        private byte[] mEncDecMatrix;
        private String mFinalFullFilename;
        private String mFullFilename;
        private boolean mIsCollect;
        private boolean mIsIOException;
        private boolean mIsNoScreenDiagnoseLog;
        private boolean mIsOnlyCollectUiData;
        private ConcurrentLinkedQueue<LogPackage> mLogLinkedList;
        private LogRecordHead mLogRecordHead;
        private String mMake;
        private String mModel;
        private int mRealLogRecordLength;
        private String mSpecificLogsPath;
        private byte[] mSrcMatrixBuffer;
        private int mSrcMatrixBufferPosition;
        private boolean mStopFlag;
        private String mVIN;
        private String mYear;

        public boolean ismIsOnlyCollectUiData() {
            return this.mIsOnlyCollectUiData;
        }

        public void setmIsOnlyCollectUiData(boolean z) {
            this.mIsOnlyCollectUiData = z;
        }

        public synchronized String getMake() {
            return this.mMake;
        }

        public synchronized void setMake(String str) {
            this.mMake = str;
        }

        public synchronized String getModel() {
            return this.mModel;
        }

        public synchronized void setModel(String str) {
            this.mModel = str;
        }

        public synchronized String getYear() {
            return this.mYear;
        }

        public synchronized void setYear(String str) {
            this.mYear = str;
        }

        public synchronized String getVIN() {
            return this.mVIN;
        }

        public synchronized void setVIN(String str) {
            this.mVIN = str;
        }

        public LogRecordThread(boolean z, boolean z2, boolean z3, String str, String str2, boolean z4) {
            this.mLogLinkedList = null;
            this.mLogRecordHead = null;
            this.mSrcMatrixBuffer = null;
            this.mEncDecMatrix = null;
            this.mLogLinkedList = new ConcurrentLinkedQueue<>();
            if (z3) {
                this.mLogRecordHead = new LogRecordHead("V03.01");
            } else {
                this.mLogRecordHead = new LogRecordHead("V02.01");
            }
            this.mStopFlag = false;
            this.mIsNoScreenDiagnoseLog = z2;
            if (this.mIsNoScreenDiagnoseLog) {
                this.CURRENT_BUFFER_SIZE = DiagnoseLogUtil.this.NO_SCREEN_DIAGNOSELOG_BUFFER_SIZE;
            } else {
                this.CURRENT_BUFFER_SIZE = 4096;
            }
            C1856n.m8130a(DiagnoseLogUtil.TAG, "mIsNoScreenDiagnoseLog=" + this.mIsNoScreenDiagnoseLog + " CURRENT_BUFFER_SIZE = " + this.CURRENT_BUFFER_SIZE);
            int i = this.CURRENT_BUFFER_SIZE;
            this.mSrcMatrixBuffer = new byte[i];
            this.mEncDecMatrix = new byte[i];
            this.mSrcMatrixBufferPosition = 0;
            this.mDiagnoseLogSwitch = z;
            this.mDiagnoseLogPath = str;
            this.mIsIOException = false;
            this.mFullFilename = "";
            this.mFinalFullFilename = "";
            this.mRealLogRecordLength = 0;
            this.mSpecificLogsPath = str2;
            this.mIsCollect = z3;
            this.isADAS = z4;
        }

        public boolean renameDiagnoseLog() {
            Exception e;
            boolean z;
            String str;
            C1856n.m8125d(DiagnoseLogUtil.TAG, "执行更名操作");
            if (this.mFullFilename.isEmpty() || !this.mFullFilename.contains(".tmp")) {
                return false;
            }
            try {
                File file = new File(this.mFullFilename);
                int lastIndexOf = this.mFullFilename.lastIndexOf(".");
                String str2 = str.substring(0, lastIndexOf) + ".dat";
                z = file.renameTo(new File(str2));
                try {
                    if (z) {
                        if (getIsCollect()) {
                            sendLogFileName(str2);
                        }
                        if (isADAS()) {
                            String str3 = getSpecificLogsPath() + new File(str2).getName().replace(".dat", "_adas.dat");
                            C1856n.m8125d(DiagnoseLogUtil.TAG, "adasSuccess: " + DiagnoseLogUtil.this.copyFile(new File(str2), new File(str3), true) + " adas  日志文件路径：" + str3);
                        }
                        C1856n.m8125d(DiagnoseLogUtil.TAG, String.format("文件名变更成功  原名：%1$s 更改后文件名：%2$s", this.mFullFilename, str2));
                    } else {
                        C1856n.m8125d(DiagnoseLogUtil.TAG, String.format("文件名变更失败  原名：%1$s 更改后文件名：%2$s", this.mFullFilename, str2));
                    }
                    if (z) {
                        this.mFinalFullFilename = str2;
                        return z;
                    }
                    this.mFinalFullFilename = "";
                    return z;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return z;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
        }

        private void sendLogFileName(String str) {
            if (DiagnoseLogUtil.this.isRealFeedBack) {
                DiagnoseLogUtil.this.isRealFeedBack = false;
                return;
            }
            Intent intent = new Intent("data_collect_log_created");
            intent.putExtra("data_collect_file_name", str);
            intent.putExtra("collect_type", this.mIsOnlyCollectUiData ? 1 : 0);
            DiagnoseLogUtil.this.mContext.sendBroadcast(intent);
        }

        public boolean getDiagnoseLogSwitch() {
            return this.mDiagnoseLogSwitch;
        }

        public boolean isNoScreenDiagnoseLog() {
            return this.mIsNoScreenDiagnoseLog;
        }

        public String getDiagnoseLogPath() {
            return this.mDiagnoseLogPath;
        }

        public String getSpecificLogsPath() {
            return this.mSpecificLogsPath;
        }

        public String getFinalFullFilename() {
            return this.mFinalFullFilename;
        }

        public int getRealLogRecordLength() {
            return this.mRealLogRecordLength;
        }

        public synchronized boolean getIsIOException() {
            return this.mIsIOException;
        }

        public synchronized void setIsIOException(boolean z) {
            this.mIsIOException = z;
        }

        public boolean getIsCollect() {
            return this.mIsCollect;
        }

        public void setIsCollect(boolean z) {
            this.mIsCollect = z;
        }

        public boolean isADAS() {
            return this.isADAS;
        }

        public void setADAS(boolean z) {
            this.isADAS = z;
        }

        public boolean initLogRecordHead() {
            if (this.mDiagnoseLogSwitch) {
                try {
                    createDataOutputStream(this.mLogRecordHead.getDeviceSN(), this.mLogRecordHead.getVehicleSoftname(), new Date());
                    writeLogRecordHead(this.mLogRecordHead);
                    return true;
                } catch (FileNotFoundException e) {
                    DiagnoseLogUtil.this.sendIOExceptionMessage(e);
                    return false;
                } catch (IOException e2) {
                    doAfterIOException(e2);
                    return false;
                }
            }
            return false;
        }

        public boolean initNewInheritDiagLog(byte b, String str, int i) {
            this.mRealLogRecordLength = i;
            this.mFinalFullFilename = str;
            if (b == 1) {
                return generateNewInheritDiagLog(b, str, i);
            }
            return true;
        }

        private boolean generateNewInheritDiagLog(byte b, String str, int i) {
            FileInputStream fileInputStream;
            IOException e;
            int i2;
            if (this.mDiagnoseLogSwitch) {
                try {
                    createDataOutputStream(this.mLogRecordHead.getDeviceSN(), this.mLogRecordHead.getVehicleSoftname(), new Date(this.mLogRecordHead.getCreateDate()));
                    if (TextUtils.isEmpty(str)) {
                        try {
                            writeLogRecordHead(this.mLogRecordHead);
                            return true;
                        } catch (IOException e2) {
                            doAfterIOException(e2);
                            return false;
                        }
                    }
                    FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            try {
                                fileInputStream = new FileInputStream(str);
                            } catch (IOException e3) {
                                fileInputStream = null;
                                e = e3;
                            } catch (Exception unused) {
                            }
                            try {
                                try {
                                    byte[] bArr = {76, 65, 85, 78, 67, 72};
                                    byte[] bArr2 = new byte[6];
                                    if (fileInputStream.read(bArr2) != 6 || !Arrays.equals(bArr2, bArr)) {
                                        fileInputStream.close();
                                        throw new IOException("");
                                    }
                                    this.dataOutputStream.write(bArr2);
                                    byte[] bArr3 = new byte[4];
                                    fileInputStream.read(bArr3);
                                    this.dataOutputStream.write(bArr3);
                                    int byteToInt = DiagnoseLogUtil.byteToInt(bArr3);
                                    byte[] bArr4 = new byte[byteToInt];
                                    fileInputStream.read(bArr4);
                                    modifyHeadBufferWithNewInheritDiagLog(byteToInt, bArr4);
                                    this.dataOutputStream.write(bArr4);
                                    int i3 = (i - 10) - byteToInt;
                                    do {
                                        if (i3 >= this.CURRENT_BUFFER_SIZE) {
                                            i2 = fileInputStream.read(this.mSrcMatrixBuffer, 0, this.CURRENT_BUFFER_SIZE);
                                            if (i2 != this.CURRENT_BUFFER_SIZE) {
                                                fileInputStream.close();
                                                throw new IOException("");
                                            }
                                            this.dataOutputStream.write(this.mSrcMatrixBuffer, 0, i2);
                                            i3 -= i2;
                                        } else {
                                            int i4 = i3 % 8;
                                            int i5 = i4 != 0 ? (8 - i4) + i3 : i3;
                                            if (fileInputStream.read(this.mSrcMatrixBuffer, 0, i5) != i5) {
                                                fileInputStream.close();
                                                throw new IOException("");
                                            }
                                            SafeMatrix.decryptionContent(this.mSrcMatrixBuffer, this.mEncDecMatrix, i5);
                                            for (int i6 = 0; i6 < i3; i6++) {
                                                this.mSrcMatrixBuffer[i6] = this.mEncDecMatrix[i6];
                                            }
                                            this.mSrcMatrixBufferPosition = i3;
                                            i2 = i3;
                                        }
                                    } while (i2 == this.CURRENT_BUFFER_SIZE);
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                    return true;
                                } catch (Exception unused2) {
                                    fileInputStream2 = fileInputStream;
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                    doAfterIOException(new IOException(""));
                                    return false;
                                }
                            } catch (IOException e6) {
                                e = e6;
                                try {
                                    fileInputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                                doAfterIOException(e);
                                return false;
                            }
                        } catch (IOException e8) {
                            doAfterIOException(e8);
                            return false;
                        }
                    } catch (FileNotFoundException unused3) {
                        writeLogRecordHead(this.mLogRecordHead);
                        return true;
                    }
                } catch (FileNotFoundException e9) {
                    DiagnoseLogUtil.this.sendIOExceptionMessage(e9);
                    return false;
                }
            }
            return false;
        }

        private void modifyHeadBufferWithNewInheritDiagLog(int i, byte[] bArr) {
            byte[] bArr2 = new byte[i];
            SafeMatrix.decryptionContent(bArr, bArr2, i);
            byte[] longToByte = DiagnoseLogUtil.longToByte(this.mLogRecordHead.getCreateDate());
            for (int i2 = 0; i2 < 8; i2++) {
                bArr2[i2 + 2] = longToByte[i2];
            }
            SafeMatrix.encryptionContent(bArr2, bArr, i);
        }

        private void createDataOutputStream(String str, String str2, Date date) throws FileNotFoundException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
            String str3 = str + "_" + str2 + "_" + simpleDateFormat.format(date) + ".tmp";
            File CreateFile = CreateFile(this.mDiagnoseLogPath, str3);
            if (CreateFile != null) {
                this.dataOutputStream = new DataOutputStream(new FileOutputStream(CreateFile));
                return;
            }
            throw new FileNotFoundException(this.mDiagnoseLogPath + "/" + str3);
        }

        public ConcurrentLinkedQueue<LogPackage> getLogLinkedList() {
            return this.mLogLinkedList;
        }

        public LogRecordHead getLogRecordHead() {
            return this.mLogRecordHead;
        }

        public synchronized void stopThread() {
            this.mStopFlag = true;
        }

        public synchronized boolean getStopFlag() {
            return this.mStopFlag;
        }

        private void writeToOutputStream() throws IOException {
            writeToOutputStream(this.CURRENT_BUFFER_SIZE);
        }

        private void writeToOutputStream(int i) throws IOException {
            int encryptionContent = SafeMatrix.encryptionContent(this.mSrcMatrixBuffer, this.mEncDecMatrix, i);
            if (encryptionContent >= 0) {
                this.dataOutputStream.write(this.mEncDecMatrix, 0, encryptionContent);
            }
            this.mSrcMatrixBufferPosition = 0;
        }

        private int writeD4String(byte[] bArr, boolean z) throws IOException {
            int length = bArr.length;
            if (this.mSrcMatrixBufferPosition == this.CURRENT_BUFFER_SIZE) {
                writeToOutputStream();
            }
            writeBytes(DiagnoseLogUtil.intToByte(length), z);
            writeBytes(bArr, z);
            return length + 4;
        }

        private int writeDString(byte[] bArr, boolean z) throws IOException {
            int length = bArr.length;
            if (this.mSrcMatrixBufferPosition == this.CURRENT_BUFFER_SIZE) {
                writeToOutputStream();
            }
            byte[] bArr2 = this.mSrcMatrixBuffer;
            int i = this.mSrcMatrixBufferPosition;
            this.mSrcMatrixBufferPosition = i + 1;
            bArr2[i] = (byte) ((length >> 8) & 255);
            if (this.mSrcMatrixBufferPosition == this.CURRENT_BUFFER_SIZE) {
                writeToOutputStream();
            }
            byte[] bArr3 = this.mSrcMatrixBuffer;
            int i2 = this.mSrcMatrixBufferPosition;
            this.mSrcMatrixBufferPosition = i2 + 1;
            bArr3[i2] = (byte) (length & 255);
            writeBytes(bArr, z);
            return length + 2;
        }

        private void writeBytes(byte[] bArr, boolean z) throws IOException {
            int length = bArr.length;
            int i = this.mSrcMatrixBufferPosition;
            int i2 = i + length;
            int i3 = this.CURRENT_BUFFER_SIZE;
            int i4 = 0;
            if (i2 >= i3) {
                int i5 = i3 - i;
                for (int i6 = 0; i6 < i5; i6++) {
                    this.mSrcMatrixBuffer[this.mSrcMatrixBufferPosition + i6] = bArr[i6];
                }
                writeToOutputStream();
                int i7 = length - i5;
                while (i7 >= this.CURRENT_BUFFER_SIZE) {
                    for (int i8 = 0; i8 < this.CURRENT_BUFFER_SIZE; i8++) {
                        this.mSrcMatrixBuffer[i8] = bArr[i5 + i8];
                    }
                    writeToOutputStream();
                    int i9 = this.CURRENT_BUFFER_SIZE;
                    i5 += i9;
                    i7 -= i9;
                }
                if (i7 > 0) {
                    while (i4 < i7) {
                        this.mSrcMatrixBuffer[i4] = bArr[i5 + i4];
                        i4++;
                    }
                    this.mSrcMatrixBufferPosition += i7;
                    return;
                }
                return;
            }
            while (i4 < length) {
                this.mSrcMatrixBuffer[this.mSrcMatrixBufferPosition + i4] = bArr[i4];
                i4++;
            }
            this.mSrcMatrixBufferPosition += length;
        }

        private void writeContent(LogPackage logPackage, boolean z) throws IOException {
            if (this.mSrcMatrixBufferPosition == this.CURRENT_BUFFER_SIZE) {
                writeToOutputStream();
            }
            byte[] bArr = this.mSrcMatrixBuffer;
            int i = this.mSrcMatrixBufferPosition;
            this.mSrcMatrixBufferPosition = i + 1;
            bArr[i] = logPackage.getPackageType();
            this.mRealLogRecordLength++;
            if (this.mSrcMatrixBufferPosition == this.CURRENT_BUFFER_SIZE) {
                writeToOutputStream();
            }
            byte[] bArr2 = this.mSrcMatrixBuffer;
            int i2 = this.mSrcMatrixBufferPosition;
            this.mSrcMatrixBufferPosition = i2 + 1;
            bArr2[i2] = 1;
            this.mRealLogRecordLength++;
            if (this.mSrcMatrixBufferPosition == this.CURRENT_BUFFER_SIZE) {
                writeToOutputStream();
            }
            this.mRealLogRecordLength += writeDString(logPackage.getContent(), z);
            byte[] longToByte = DiagnoseLogUtil.longToByte(logPackage.getRecordTime());
            this.mRealLogRecordLength += longToByte.length;
            writeBytes(longToByte, z);
            if (z && this.dataOutputStream.size() > DiagnoseLogUtil.LOG_FILE_MAX_LENGTH) {
                throw new FileSizeOverflowException("Diagnose Log is overflow");
            }
        }

        private int copyDString(byte[] bArr, byte[] bArr2, int i) {
            int length = bArr.length;
            int i2 = i + 1;
            bArr2[i] = (byte) ((length >> 8) & 255);
            bArr2[i2] = (byte) (length & 255);
            System.arraycopy(bArr, 0, bArr2, i2 + 1, length);
            return length + 2;
        }

        private void writeLogRecordHead(LogRecordHead logRecordHead) throws IOException {
            byte[] bArr;
            byte[] bArr2;
            byte[] bArr3;
            byte[] bArr4;
            byte[] bArr5;
            byte[] bytes;
            byte[] bytes2;
            byte[] bytes3;
            byte[] bytes4;
            byte[] bytes5;
            this.dataOutputStream.write(new byte[]{76, 65, 85, 78, 67, 72});
            this.mRealLogRecordLength += 6;
            byte[] fileVersion = logRecordHead.getFileVersion();
            byte[] longToByte = DiagnoseLogUtil.longToByte(logRecordHead.getCreateDate());
            byte[] bytes6 = logRecordHead.getVehicleSoftname().getBytes("UTF-8");
            byte[] bytes7 = logRecordHead.getVehicleSoftVersion().getBytes("UTF-8");
            byte[] bytes8 = logRecordHead.getVehicleSoftLanguage().getBytes("UTF-8");
            byte[] bytes9 = logRecordHead.getDeviceSN().getBytes("UTF-8");
            byte[] bytes10 = logRecordHead.getDeviceVersion().getBytes("UTF-8");
            byte[] bytes11 = logRecordHead.getSoftVersion().getBytes("UTF-8");
            if (this.mIsCollect) {
                byte[] bytes12 = TextUtils.isEmpty(logRecordHead.getPadInformation()) ? new byte[0] : logRecordHead.getPadInformation().getBytes("UTF-8");
                byte[] bytes13 = TextUtils.isEmpty(logRecordHead.getCollecterUsername()) ? new byte[0] : logRecordHead.getCollecterUsername().getBytes("UTF-8");
                byte[] bytes14 = TextUtils.isEmpty(logRecordHead.getCollecterPhone()) ? new byte[0] : logRecordHead.getCollecterPhone().getBytes("UTF-8");
                byte[] bytes15 = TextUtils.isEmpty(logRecordHead.getCollectPlacesLongitude()) ? new byte[0] : logRecordHead.getCollectPlacesLongitude().getBytes("UTF-8");
                byte[] bytes16 = TextUtils.isEmpty(logRecordHead.getCollectPlacesLatitude()) ? new byte[0] : logRecordHead.getCollectPlacesLatitude().getBytes("UTF-8");
                byte[] bytes17 = TextUtils.isEmpty(logRecordHead.getCollectPlacesLatitudeType()) ? new byte[0] : logRecordHead.getCollectPlacesLatitudeType().getBytes("UTF-8");
                if (TextUtils.isEmpty(logRecordHead.getVehicleVin())) {
                    bArr5 = bytes11;
                    bytes2 = new byte[0];
                } else {
                    bArr5 = bytes11;
                    bytes2 = logRecordHead.getVehicleVin().getBytes("UTF-8");
                }
                if (TextUtils.isEmpty(logRecordHead.getVehicleMake())) {
                    bArr4 = bytes10;
                    bytes3 = new byte[0];
                } else {
                    bArr4 = bytes10;
                    bytes3 = logRecordHead.getVehicleMake().getBytes("UTF-8");
                }
                if (TextUtils.isEmpty(logRecordHead.getVehicleModel())) {
                    bArr3 = bytes9;
                    bytes4 = new byte[0];
                } else {
                    bArr3 = bytes9;
                    bytes4 = logRecordHead.getVehicleModel().getBytes("UTF-8");
                }
                if (TextUtils.isEmpty(logRecordHead.getVehicleYear())) {
                    bArr2 = bytes8;
                    bytes5 = new byte[0];
                } else {
                    bArr2 = bytes8;
                    bytes5 = logRecordHead.getVehicleYear().getBytes("UTF-8");
                }
                bArr = bytes7;
                bytes = new byte[bytes12.length + 2 + bytes13.length + 2 + bytes14.length + 2 + bytes15.length + 2 + bytes16.length + 2 + bytes17.length + 2 + bytes2.length + 2 + bytes3.length + 2 + bytes4.length + 2 + bytes5.length + 2];
                int copyDString = copyDString(bytes12, bytes, 0) + 0;
                int copyDString2 = copyDString + copyDString(bytes13, bytes, copyDString);
                int copyDString3 = copyDString2 + copyDString(bytes14, bytes, copyDString2);
                int copyDString4 = copyDString3 + copyDString(bytes15, bytes, copyDString3);
                int copyDString5 = copyDString4 + copyDString(bytes16, bytes, copyDString4);
                int copyDString6 = copyDString5 + copyDString(bytes17, bytes, copyDString5);
                int copyDString7 = copyDString6 + copyDString(bytes2, bytes, copyDString6);
                int copyDString8 = copyDString7 + copyDString(bytes3, bytes, copyDString7);
                copyDString(bytes5, bytes, copyDString8 + copyDString(bytes4, bytes, copyDString8));
            } else {
                bArr = bytes7;
                bArr2 = bytes8;
                bArr3 = bytes9;
                bArr4 = bytes10;
                bArr5 = bytes11;
                bytes = logRecordHead.getPadInformation().getBytes("UTF-8");
            }
            byte[] bArr6 = bArr;
            byte[] bArr7 = bArr2;
            byte[] bArr8 = bArr3;
            byte[] bArr9 = bArr4;
            byte[] bArr10 = bArr5;
            int length = fileVersion.length + longToByte.length + bytes6.length + 2 + bArr6.length + 2 + bArr7.length + 2 + bArr8.length + 2 + bArr9.length + 2 + bArr10.length + 2 + bytes.length + 2;
            int i = length % 8;
            if (i != 0) {
                length += 8 - i;
            }
            this.mRealLogRecordLength += length;
            byte[] intToByte = DiagnoseLogUtil.intToByte(length);
            this.mRealLogRecordLength += intToByte.length;
            this.dataOutputStream.write(intToByte);
            writeBytes(fileVersion, false);
            writeBytes(longToByte, false);
            writeDString(bytes6, false);
            writeDString(bArr6, false);
            writeDString(bArr7, false);
            writeDString(bArr8, false);
            writeDString(bArr9, false);
            writeDString(bArr10, false);
            writeDString(bytes, false);
            int i2 = this.mSrcMatrixBufferPosition;
            if (i2 == this.CURRENT_BUFFER_SIZE) {
                writeToOutputStream();
            } else if (i2 != 0) {
                if (i != 0) {
                    for (int i3 = 0; i3 < 8 - i; i3++) {
                        this.mSrcMatrixBuffer[this.mSrcMatrixBufferPosition + i3] = 0;
                    }
                    writeToOutputStream((this.mSrcMatrixBufferPosition + 8) - i);
                    return;
                }
                writeToOutputStream(i2);
            }
        }

        private Vector<File> scanFiles(String str) {
            Vector<File> vector = new Vector<>();
            File[] listFiles = new File(str).listFiles();
            if (listFiles == null) {
                return vector;
            }
            int i = 0;
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().endsWith(".tmp")) {
                        file.delete();
                    } else {
                        vector.add(file);
                    }
                }
            }
            while (i < vector.size() - 1) {
                int i2 = i + 1;
                File elementAt = vector.elementAt(i);
                for (int i3 = i2; i3 < vector.size(); i3++) {
                    if (elementAt.lastModified() > vector.elementAt(i3).lastModified()) {
                        vector.setElementAt(vector.elementAt(i3), i);
                        vector.setElementAt(elementAt, i3);
                        elementAt = vector.elementAt(i);
                    }
                }
                i = i2;
            }
            return vector;
        }

        private File CreateFile(String str, String str2) {
            boolean z;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.isDirectory()) {
                Vector<File> scanFiles = scanFiles(str);
                int m9585b = PreferencesManager.m9595a(DiagnoseLogUtil.this.mContext).m9585b("save_feedback_log_size", 20);
                m9585b = (m9585b < 20 || m9585b > 1000) ? 20 : 20;
                if (scanFiles.size() >= m9585b) {
                    int size = (scanFiles.size() + 1) - m9585b;
                    for (int i = 0; i < size; i++) {
                        File elementAt = scanFiles.elementAt(i);
                        if (elementAt != null) {
                            String name = elementAt.getName();
                            String absolutePath = elementAt.getAbsolutePath();
                            C1856n.m8125d(DiagnoseLogUtil.TAG, String.format("需要删除文件原名：原名：%1$s 全名：%2$s", name, absolutePath));
                            if (name.startsWith("98689") && (name.startsWith("986890001300") || name.startsWith("986890002200") || name.startsWith("986890008800") || name.startsWith("986890003900") || name.startsWith("986891002200") || name.startsWith("986891004700") || name.startsWith("986891004900") || name.startsWith("986891003700") || name.startsWith("986891003700") || name.startsWith("986891004600"))) {
                                z = false;
                            } else if (name.startsWith("98454") || name.startsWith("98524") || name.startsWith("98689")) {
                                C1856n.m8130a(DiagnoseLogUtil.TAG, String.format("需要保留文件原名：原名：%1$s 全名：%2$s", name, absolutePath));
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                String str3 = this.mSpecificLogsPath + File.separator + name;
                                if (elementAt.renameTo(new File(str3))) {
                                    if (getIsCollect()) {
                                        sendLogFileName(str3);
                                    }
                                    C1856n.m8125d(DiagnoseLogUtil.TAG, String.format("重卡文件名变更成功  原名：%1$s 更改后文件名：%2$s", absolutePath, str3));
                                } else {
                                    C1856n.m8125d(DiagnoseLogUtil.TAG, String.format("重卡文件名变更失败  原名：%1$s 更改后文件名：%2$s", absolutePath, str3));
                                }
                            } else {
                                elementAt.delete();
                            }
                        }
                    }
                }
                this.mFullFilename = str + File.separator + str2;
                File file2 = new File(this.mFullFilename);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (Exception unused) {
                        C1856n.m8125d(DiagnoseLogUtil.TAG, this.mFullFilename);
                        return null;
                    }
                }
                return file2;
            }
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            if (this.mDiagnoseLogSwitch) {
                if (DiagnoseLogUtil.this.isSpecialFunctionLogGeneratedState()) {
                    C1856n.m8125d(DiagnoseLogUtil.TAG, String.format("特殊诊断日志生成后重建日志 finalFullFilename=%1$s  realFeedbackLogLength=%2$d", this.mFinalFullFilename, Integer.valueOf(this.mRealLogRecordLength)));
                    boolean generateNewInheritDiagLog = generateNewInheritDiagLog((byte) 2, this.mFinalFullFilename, this.mRealLogRecordLength);
                    if (!this.mFinalFullFilename.isEmpty()) {
                        File file = new File(this.mFinalFullFilename);
                        int lastIndexOf = this.mFinalFullFilename.lastIndexOf(".");
                        String str2 = str.substring(0, lastIndexOf) + ".dat";
                        if (file.renameTo(new File(str2))) {
                            DiagnoseLogUtil.this.sendSpecialFunctionLogMessage(str2);
                            C1856n.m8125d(DiagnoseLogUtil.TAG, String.format("文件名变更成功  原名：%1$s 更改后文件名：%2$s", this.mFullFilename, str2));
                        } else {
                            C1856n.m8125d(DiagnoseLogUtil.TAG, String.format("文件名变更失败  原名：%1$s 更改后文件名：%2$s", this.mFullFilename, str2));
                        }
                    }
                    if (generateNewInheritDiagLog) {
                        synchronized (DiagnoseLogUtil.this.mObject) {
                            while (!DiagnoseLogUtil.this.mSpecialFunctionLogLinkedList.isEmpty()) {
                                C1856n.m8125d(DiagnoseLogUtil.TAG, "加入特殊诊断日志生成后重建日志期间的操作日志");
                                this.mLogLinkedList.offer((LogPackage) DiagnoseLogUtil.this.mSpecialFunctionLogLinkedList.poll());
                            }
                            DiagnoseLogUtil.this.mIsSpecialFunctionLogGeneratedState = false;
                        }
                    } else {
                        DiagnoseLogUtil.this.setSpecialFunctionLogGeneratedState(false);
                        return;
                    }
                }
                while (!getStopFlag()) {
                    if (!this.mLogLinkedList.isEmpty()) {
                        LogPackage poll = this.mLogLinkedList.poll();
                        if (poll != null) {
                            try {
                                writeContent(poll, true);
                            } catch (FileSizeOverflowException e) {
                                doAfterFileSizeOverflowException(e);
                            } catch (IOException e2) {
                                doAfterIOException(e2);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        try {
                            sleep(100L);
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                while (!this.mLogLinkedList.isEmpty()) {
                    LogPackage poll2 = this.mLogLinkedList.poll();
                    if (poll2 != null) {
                        try {
                            writeContent(poll2, false);
                        } catch (FileSizeOverflowException e4) {
                            doAfterFileSizeOverflowException(e4);
                        } catch (IOException e5) {
                            doAfterIOException(e5);
                            return;
                        }
                    }
                }
                int i = this.mRealLogRecordLength + 1;
                try {
                    writeBytes(new byte[]{0}, false);
                    int i2 = (i - 10) % 8;
                    if (i2 != 0) {
                        byte[] bArr = new byte[8 - i2];
                        Arrays.fill(bArr, (byte) 0);
                        writeBytes(bArr, false);
                    }
                    byte[] bytes = TextUtils.isEmpty(this.mMake) ? new byte[0] : this.mMake.getBytes(Charset.forName("UTF-8"));
                    byte[] bytes2 = TextUtils.isEmpty(this.mModel) ? new byte[0] : this.mModel.getBytes(Charset.forName("UTF-8"));
                    byte[] bytes3 = TextUtils.isEmpty(this.mYear) ? new byte[0] : this.mYear.getBytes(Charset.forName("UTF-8"));
                    byte[] bytes4 = TextUtils.isEmpty(this.mVIN) ? new byte[0] : this.mVIN.getBytes(Charset.forName("UTF-8"));
                    int length = bytes.length + 2 + bytes2.length + 2 + bytes3.length + 2 + bytes4.length + 2;
                    if (C1856n.f10135a) {
                        C1856n.m8130a(DiagnoseLogUtil.TAG, "tailLength =".concat(String.valueOf(length)));
                    }
                    int i3 = (length + 4) % 8;
                    if (C1856n.f10135a) {
                        C1856n.m8130a(DiagnoseLogUtil.TAG, "taillengthMod =".concat(String.valueOf(i3)));
                    }
                    if (i3 != 0) {
                        byte[] bArr2 = new byte[8 - i3];
                        Arrays.fill(bArr2, (byte) 0);
                        writeBytes(bArr2, false);
                    }
                    writeDString(bytes, false);
                    writeDString(bytes2, false);
                    writeDString(bytes3, false);
                    writeDString(bytes4, false);
                    writeBytes(DiagnoseLogUtil.intToByte(length), false);
                    if (this.mSrcMatrixBufferPosition == this.CURRENT_BUFFER_SIZE) {
                        writeToOutputStream();
                    } else {
                        writeToOutputStream(this.mSrcMatrixBufferPosition);
                    }
                    this.dataOutputStream.close();
                    if (this.mIsNoScreenDiagnoseLog) {
                        renameDiagnoseLog();
                    } else {
                        renameDiagnoseLog();
                    }
                    synchronized (DiagnoseLogUtil.this) {
                        DiagnoseLogUtil.this.notify();
                    }
                    C1856n.m8125d(DiagnoseLogUtil.TAG, "LogRecordThread has stoped");
                } catch (IOException e6) {
                    doAfterIOException(e6);
                }
            }
        }

        private void doAfterFileSizeOverflowException(FileSizeOverflowException fileSizeOverflowException) {
            setIsIOException(true);
            Message obtain = Message.obtain((Handler) null, 53);
            Bundle bundle = new Bundle();
            String string = DiagnoseLogUtil.this.mContext != null ? DiagnoseLogUtil.this.mContext.getResources().getString(C1444R.string.dialog_log_file_size_overflow) : "";
            bundle.putInt(VastExtensionXmlManager.TYPE, 0);
            bundle.putString(DataPacketExtension.ELEMENT_NAME, string);
            obtain.setData(bundle);
            C1856n.m8125d(DiagnoseLogUtil.TAG, "File Size Overflow Exception");
            DiagnoseLogUtil.this.sendClientMessage(obtain);
        }

        private void doAfterIOException(IOException iOException) {
            iOException.printStackTrace();
            setIsIOException(true);
            DiagnoseLogUtil.this.sendIOExceptionMessage(iOException);
            try {
                this.dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!this.mFullFilename.isEmpty()) {
                new File(this.mFullFilename).delete();
            }
            synchronized (DiagnoseLogUtil.this) {
                DiagnoseLogUtil.this.notify();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LogPackage {
        private byte[] mContent;
        private byte mPackageType;
        private long mRecordTime;

        public LogPackage(byte b, byte[] bArr, long j) {
            this.mPackageType = b;
            this.mContent = bArr;
            this.mRecordTime = j;
        }

        public byte getPackageType() {
            return this.mPackageType;
        }

        public byte[] getContent() {
            return this.mContent;
        }

        public long getRecordTime() {
            return this.mRecordTime;
        }
    }

    /* loaded from: classes.dex */
    public static class LogRecordHead {
        String collectPlacesLatitude;
        String collectPlacesLatitudeType;
        String collectPlacesLongitude;
        String collecterPhone;
        String collecterUsername;
        long mCreateDate;
        String mDeviceSN;
        String mDeviceVersion;
        byte[] mFileFlag;
        byte[] mFileVersion;
        String mFileVersionWithStringFormat;
        int mLength;
        String mSoftVersion;
        String mVehicleSoftLanguage;
        String mVehicleSoftVersion;
        String mVehicleSoftname;
        String padInformation;
        String vehicleMake;
        String vehicleModel;
        String vehicleVin;
        String vehicleYear;

        public LogRecordHead() {
            this("V02.01");
        }

        public LogRecordHead(String str) {
            this.mFileFlag = new byte[6];
            this.mFileVersion = new byte[2];
            setFileVersion(str);
            this.mLength = 0;
            this.mVehicleSoftname = "";
            this.mVehicleSoftVersion = "";
            this.mVehicleSoftLanguage = "";
            this.mDeviceSN = "";
            this.mDeviceVersion = "";
            this.mSoftVersion = "";
            this.collecterUsername = "";
            this.collecterPhone = "";
            this.collectPlacesLongitude = "";
            this.collectPlacesLatitude = "";
            this.collectPlacesLatitudeType = "";
            this.vehicleVin = "";
            this.vehicleMake = "";
            this.vehicleModel = "";
            this.vehicleYear = "";
            this.padInformation = "";
        }

        private void setFileVersion(String str) {
            byte parseByte = Byte.parseByte(str.substring(1, 3));
            byte parseByte2 = Byte.parseByte(str.substring(4));
            byte[] bArr = this.mFileVersion;
            bArr[0] = parseByte;
            bArr[1] = parseByte2;
            this.mFileVersionWithStringFormat = str;
        }

        public void setCreateDate(Date date) {
            this.mCreateDate = date.getTime();
        }

        public void setVehicleSoftname(String str) {
            this.mVehicleSoftname = str;
        }

        public void setVehicleSoftVersion(String str) {
            this.mVehicleSoftVersion = str;
        }

        public void setVehicleSoftLanguage(String str) {
            this.mVehicleSoftLanguage = str;
        }

        public void setDeviceSN(String str) {
            this.mDeviceSN = str;
        }

        public void setDeviceVersion(String str) {
            this.mDeviceVersion = str;
        }

        public void setSoftVersion(String str) {
            this.mSoftVersion = str;
        }

        public byte[] getFileVersion() {
            return this.mFileVersion;
        }

        public String getFileVersionWithStringFormat() {
            return this.mFileVersionWithStringFormat;
        }

        public long getCreateDate() {
            return this.mCreateDate;
        }

        public String getVehicleSoftname() {
            return this.mVehicleSoftname;
        }

        public String getVehicleSoftVersion() {
            return this.mVehicleSoftVersion;
        }

        public String getVehicleSoftLanguage() {
            return this.mVehicleSoftLanguage;
        }

        public String getDeviceSN() {
            return this.mDeviceSN;
        }

        public String getDeviceVersion() {
            return this.mDeviceVersion;
        }

        public String getSoftVersion() {
            return this.mSoftVersion;
        }

        public String getCollecterUsername() {
            return this.collecterUsername;
        }

        public void setCollecterUsername(String str) {
            this.collecterUsername = str;
        }

        public String getCollecterPhone() {
            return this.collecterPhone;
        }

        public void setCollecterPhone(String str) {
            this.collecterPhone = str;
        }

        public String getCollectPlacesLongitude() {
            return this.collectPlacesLongitude;
        }

        public void setCollectPlacesLongitude(String str) {
            this.collectPlacesLongitude = str;
        }

        public String getCollectPlacesLatitude() {
            return this.collectPlacesLatitude;
        }

        public void setCollectPlacesLatitude(String str) {
            this.collectPlacesLatitude = str;
        }

        public String getCollectPlacesLatitudeType() {
            return this.collectPlacesLatitudeType;
        }

        public void setCollectPlacesLatitudeType(String str) {
            this.collectPlacesLatitudeType = str;
        }

        public String getVehicleVin() {
            return this.vehicleVin;
        }

        public void setVehicleVin(String str) {
            this.vehicleVin = str;
        }

        public String getVehicleMake() {
            return this.vehicleMake;
        }

        public void setVehicleMake(String str) {
            this.vehicleMake = str;
        }

        public String getVehicleModel() {
            return this.vehicleModel;
        }

        public void setVehicleModel(String str) {
            this.vehicleModel = str;
        }

        public String getVehicleYear() {
            return this.vehicleYear;
        }

        public void setVehicleYear(String str) {
            this.vehicleYear = str;
        }

        public String getPadInformation() {
            return this.padInformation;
        }

        public void setPadInformation(String str) {
            this.padInformation = str;
        }

        public void copyLogRecordHead(LogRecordHead logRecordHead) {
            setVehicleSoftname(logRecordHead.getVehicleSoftname());
            setVehicleSoftVersion(logRecordHead.getVehicleSoftVersion());
            setVehicleSoftLanguage(logRecordHead.getVehicleSoftLanguage());
            setDeviceSN(logRecordHead.getDeviceSN());
            setDeviceVersion(logRecordHead.getDeviceVersion());
            setSoftVersion(logRecordHead.getSoftVersion());
            setCollecterUsername(logRecordHead.getCollecterUsername());
            setCollecterPhone(logRecordHead.getCollecterPhone());
            setCollectPlacesLongitude(logRecordHead.getCollectPlacesLongitude());
            setCollectPlacesLatitude(logRecordHead.getCollectPlacesLatitude());
            setCollectPlacesLatitudeType(logRecordHead.getCollectPlacesLatitudeType());
            setVehicleVin(logRecordHead.getVehicleVin());
            setVehicleMake(logRecordHead.getVehicleMake());
            setVehicleModel(logRecordHead.getVehicleModel());
            setVehicleYear(logRecordHead.getVehicleYear());
            setPadInformation(logRecordHead.getPadInformation());
        }
    }

    /* loaded from: classes.dex */
    public static class SafeMatrix {
        public static final int BUFFER_SIZE = 4096;
        public static final int MAX = 8;
        private byte[] mEncDecMatrix;
        private byte[] mSrcMatrixBuffer;
        private static byte[][] mEncryptionMatrix = {new byte[]{1, 2, 27, 4, 15, 8, 11, 14}, new byte[]{0, 2, 15, 2, 6, 6, 7, 6}, new byte[]{0, 3, 25, 3, 9, 9, 12, 11}, new byte[]{0, 0, 19, 2, 9, 7, 7, 10}, new byte[]{0, 2, 21, 3, 10, 8, 9, 10}, new byte[]{0, 0, 30, 3, 14, 11, 11, 16}, new byte[]{0, 1, 22, 4, 13, 8, 9, 13}, new byte[]{0, 2, 23, 4, 12, 9, 10, 11}};
        private static byte[][] mDecryptionMatrix = {new byte[]{1, 4, -1, -31, -9, 20, -1, 6}, new byte[]{0, -2, 0, -7, 2, 4, -1, 1}, new byte[]{0, -6, 1, -8, 2, 5, -3, 4}, new byte[]{0, -11, 2, -32, -1, 20, -6, 12}, new byte[]{0, 5, -1, 19, 1, -12, 3, -6}, new byte[]{0, 4, -1, -6, -3, 4, 1, 0}, new byte[]{0, 9, -1, 24, -2, -15, 5, -8}, new byte[]{0, 0, 0, -8, -1, 5, 0, 1}};

        public SafeMatrix() {
            this.mSrcMatrixBuffer = null;
            this.mEncDecMatrix = null;
            this.mSrcMatrixBuffer = new byte[4096];
            this.mEncDecMatrix = new byte[4096];
        }

        public static int encryptionContent(byte[] bArr, byte[] bArr2, int i) {
            return safeContent(bArr, bArr2, i, true);
        }

        public static int decryptionContent(byte[] bArr, byte[] bArr2, int i) {
            return safeContent(bArr, bArr2, i, false);
        }

        private static int safeContent(byte[] bArr, byte[] bArr2, int i, boolean z) {
            byte[][] bArr3;
            int i2;
            if (z) {
                bArr3 = mEncryptionMatrix;
            } else {
                bArr3 = mDecryptionMatrix;
            }
            if (i == 4096) {
                for (int i3 = 0; i3 < 512; i3++) {
                    int i4 = i3 * 8;
                    multiMatrix(bArr, bArr3, bArr2, i4, 8, 8, i4);
                }
            } else if (i > 0 && i < 4096) {
                int i5 = i % 8;
                if (i5 != 0) {
                    int i6 = 0;
                    while (true) {
                        i2 = 8 - i5;
                        if (i6 >= i2) {
                            break;
                        }
                        bArr[i + i6] = 0;
                        i6++;
                    }
                    i += i2;
                }
                for (int i7 = 0; i7 < i / 8; i7++) {
                    int i8 = i7 * 8;
                    multiMatrix(bArr, bArr3, bArr2, i8, 8, 8, i8);
                }
            }
            return i;
        }

        private void safeFile(String str, String str2, boolean z) throws IOException {
            byte[][] bArr;
            int i;
            int i2;
            int i3;
            if (z) {
                bArr = mEncryptionMatrix;
            } else {
                bArr = mDecryptionMatrix;
            }
            File file = new File(str);
            if (file.exists()) {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(str2)));
                int read = dataInputStream.read(this.mSrcMatrixBuffer);
                while (true) {
                    if (read != 4096) {
                        break;
                    }
                    for (int i4 = 0; i4 < 512; i4++) {
                        int i5 = i4 * 8;
                        multiMatrix(this.mSrcMatrixBuffer, bArr, this.mEncDecMatrix, i5, 8, 8, i5);
                    }
                    dataOutputStream.write(this.mEncDecMatrix);
                    read = dataInputStream.read(this.mSrcMatrixBuffer);
                }
                if (read > 0 && read < 4096) {
                    int i6 = read % 8;
                    if (i6 != 0) {
                        int i7 = 0;
                        while (true) {
                            i3 = 8 - i6;
                            if (i7 >= i3) {
                                break;
                            }
                            this.mSrcMatrixBuffer[read + i7] = 0;
                            i7++;
                        }
                        i = i3;
                    } else {
                        i = 0;
                    }
                    int i8 = 0;
                    while (true) {
                        i2 = read + i;
                        if (i8 >= i2 / 8) {
                            break;
                        }
                        int i9 = i8 * 8;
                        multiMatrix(this.mSrcMatrixBuffer, bArr, this.mEncDecMatrix, i9, 8, 8, i9);
                        i8++;
                    }
                    dataOutputStream.write(this.mEncDecMatrix, 0, i2);
                }
                dataOutputStream.close();
                dataInputStream.close();
                return;
            }
            throw new FileNotFoundException(str + " not Found");
        }

        public void encryptionFile(String str, String str2) throws IOException {
            safeFile(str, str2, true);
        }

        public void decryptionFile(String str, String str2) throws IOException {
            safeFile(str, str2, false);
        }

        private static void multiMatrix(byte[] bArr, byte[][] bArr2, byte[] bArr3, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < i3; i5++) {
                byte b = 0;
                for (int i6 = 0; i6 < i2; i6++) {
                    b = (byte) (b + (bArr[i6 + i] * bArr2[i6][i5]));
                }
                bArr3[i5 + i4] = b;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FileSizeOverflowException extends IOException {
        private static final long serialVersionUID = -6850861552283337336L;

        public FileSizeOverflowException(String str) {
            super(str);
        }
    }
}
