package com.cnlaunch.diagnosemodule.newinterface;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.diagnosemodule.JsonConstText;
import com.cnlaunch.diagnosemodule.service.DiagnoseService;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.LocalSocketClient;
import com.cnlaunch.diagnosemodule.utils.NewFrameData2JsonUtil;
import com.cnlaunch.diagnosemodule.utils.OrderMontage;
import com.cnlaunch.physics.p205k.C1856n;
import com.ifoer.expedition.cto.CToJavaImplements;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DiagnoseDataSrc implements ApkInterface {
    private static final String TAG = "DiagnoseDataSrc";
    private static DiagnoseDataSrc instance;
    private int[] mArrByteRet;
    private Context mContext;
    private DiagnoseBusiness mDiagBusiness;
    private String mRetString;
    private Object mLock = new Object();
    private int mRetId = 0;
    private Hashtable<String, SQLiteDatabase> mDbs = new Hashtable<>();
    private Object mDataStreamLock = new Object();

    public static DiagnoseDataSrc getInstance(Context context) {
        if (instance == null) {
            synchronized (DiagnoseDataSrc.class) {
                if (instance == null) {
                    DiagnoseDataSrc diagnoseDataSrc = new DiagnoseDataSrc(context);
                    instance = diagnoseDataSrc;
                    diagnoseDataSrc.setmDiagBusiness(DiagnoseBusiness.getInstance(context));
                }
            }
        }
        return instance;
    }

    public void setmDiagBusiness(DiagnoseBusiness diagnoseBusiness) {
        this.mDiagBusiness = diagnoseBusiness;
    }

    private DiagnoseDataSrc(Context context) {
        this.mContext = context;
    }

    public String byteToStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public int showView(int i, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return 0;
        }
        String format = String.format("viewType = %04X", Integer.valueOf(i));
        C1856n.m8125d(TAG, format + " data=" + byteToStr(bArr));
        if (i != 16384) {
            switch (i) {
                case 0:
                    return showMessageBox(bArr, true);
                case 1:
                    return showMessageBox(bArr, false);
                case 2:
                    break;
                default:
                    switch (i) {
                        case 256:
                            return showChannel(bArr);
                        case 257:
                            return showRichView(bArr);
                        default:
                            switch (i) {
                                case 512:
                                case 513:
                                    return showSystemScan(bArr, true);
                                case 514:
                                    return showFuncMessage(bArr, true);
                                case 515:
                                    return showFuncMenu(bArr, true);
                                case UIMsg.m_AppUI.MSG_CHINA_SUP_ITS /* 516 */:
                                    return showLableSubFunc(bArr);
                                case 517:
                                    return showSubdtc(bArr);
                                default:
                                    switch (i) {
                                        case 768:
                                            return showFuncHtml(bArr);
                                        case 769:
                                            return showFuncMessage(bArr, false);
                                        case 770:
                                            return showFuncMenu(bArr, false);
                                        case 771:
                                            return showFuncVersion(bArr);
                                        case 772:
                                            return showReadDtc(bArr);
                                        case 773:
                                            return showFuncDataSelect(bArr);
                                        case 774:
                                            return showReadStream(bArr);
                                        case 775:
                                            return showFuncActionStream(bArr);
                                        case 776:
                                            return showFunCustom(bArr);
                                    }
                            }
                    }
            }
            return 0;
        }
        return showAddress(bArr);
    }

    public void notifyUnLock(int[] iArr) {
        C1856n.m8125d(TAG, "notifyUnLock arrByteRet");
        this.mArrByteRet = iArr;
        synchronized (this.mDataStreamLock) {
            this.mDataStreamLock.notifyAll();
        }
    }

    public void notifyUnLock(int i, String str) {
        C1856n.m8125d(TAG, "notifyUnLock retid=".concat(String.valueOf(i)));
        this.mRetId = i;
        this.mRetString = str;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public List<Integer> getDataVisibleRows() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_DATASTREAM);
            NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_DATASTREAM_SHOW_POS);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            synchronized (this.mDataStreamLock) {
                this.mDataStreamLock.wait();
            }
            C1856n.m8125d(TAG, "getDataVisibleRows lock end");
            if (this.mArrByteRet != null) {
                for (int i = 0; i < this.mArrByteRet.length; i++) {
                    arrayList.add(Integer.valueOf(this.mArrByteRet[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public int removeMessageBox() {
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_REMOVE_DIAGLOG);
            NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_DIALOG);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public byte[] sendReceiveOnly(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        if (!DiagnoseConstants.driviceConnStatus) {
            return new byte[0];
        }
        byte[] packingFullCommand = OrderMontage.packingFullCommand(bArr, new byte[0]);
        byte b = packingFullCommand[6];
        LocalSocketClient.setMaxWaitTime(i);
        LocalSocketClient.commandWaitLock.lock();
        LocalSocketClient.offerLogPackage(new LocalSocketClient.DiagnoseRequestCommand(packingFullCommand, (byte) 1));
        CToJavaImplements.recordSendDataDiagnoseLog(packingFullCommand);
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "sendReceiveOnly maxWaitTime = ".concat(String.valueOf(i)));
        }
        try {
            LocalSocketClient.notReceiverCommand.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String bluetoothCommand = LocalSocketClient.getBluetoothCommand();
        LocalSocketClient.commandWaitLock.unlock();
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "backOrder=".concat(String.valueOf(bluetoothCommand)));
        }
        if (bluetoothCommand == null || bluetoothCommand.length() <= 0) {
            byte[] bArr2 = new byte[0];
            OrderMontage.resumeLasttimeCounter();
            return bArr2;
        }
        byte[] hexStringToBytes = ByteHexHelper.hexStringToBytes(bluetoothCommand);
        if (b == hexStringToBytes[6]) {
            int i2 = (((hexStringToBytes[4] & 255) * 256) + (hexStringToBytes[5] & 255)) - 1;
            if (DiagnoseConstants.isVoltageShow) {
                Message obtain = Message.obtain((Handler) null, 108);
                int i3 = (i2 + 5) * 2;
                obtain.arg1 = Integer.parseInt(bluetoothCommand.substring(i3, i3 + 4), 16);
                DiagnoseService.sendClientMessage(this.mContext, obtain);
                i2 -= 2;
            }
            byte[] bArr3 = new byte[i2];
            int i4 = 0;
            for (int i5 = 7; i5 < i2 + 7; i5++) {
                bArr3[i4] = hexStringToBytes[i5];
                i4++;
            }
            CToJavaImplements.recordReciveDataDiagnoseLog(hexStringToBytes);
            return bArr3;
        }
        byte[] bArr4 = new byte[0];
        OrderMontage.resumeLasttimeCounter();
        return bArr4;
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public byte[] sendReceive(byte[] bArr, int i) {
        byte[] bArr2 = null;
        if (bArr == null || bArr.length <= 0 || !DiagnoseConstants.driviceConnStatus) {
            return null;
        }
        byte[] packingFullCommand = OrderMontage.packingFullCommand(bArr, new byte[]{39, 1});
        byte b = packingFullCommand[6];
        LocalSocketClient.setMaxWaitTime(i);
        LocalSocketClient.commandWaitLock.lock();
        LocalSocketClient.offerLogPackage(new LocalSocketClient.DiagnoseRequestCommand(packingFullCommand, (byte) 1));
        CToJavaImplements.recordSendDataDiagnoseLog(packingFullCommand);
        try {
            LocalSocketClient.notReceiverCommand.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String bluetoothCommand = LocalSocketClient.getBluetoothCommand();
        LocalSocketClient.commandWaitLock.unlock();
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "backOrder=".concat(String.valueOf(bluetoothCommand)));
        }
        if (bluetoothCommand == null || bluetoothCommand.length() <= 0) {
            OrderMontage.resumeLasttimeCounter();
        } else {
            byte[] hexStringToBytes = ByteHexHelper.hexStringToBytes(bluetoothCommand);
            if (b == hexStringToBytes[6]) {
                int i2 = (((hexStringToBytes[4] & 255) * 256) + (hexStringToBytes[5] & 255)) - 3;
                if (DiagnoseConstants.isVoltageShow) {
                    Message obtain = Message.obtain((Handler) null, 108);
                    int i3 = (i2 + 7) * 2;
                    obtain.arg1 = Integer.parseInt(bluetoothCommand.substring(i3, i3 + 4), 16);
                    DiagnoseService.sendClientMessage(this.mContext, obtain);
                    i2 -= 2;
                }
                bArr2 = new byte[i2];
                int i4 = 0;
                for (int i5 = 9; i5 < i2 + 9; i5++) {
                    bArr2[i4] = hexStringToBytes[i5];
                    i4++;
                }
                CToJavaImplements.recordReciveDataDiagnoseLog(hexStringToBytes);
            } else {
                OrderMontage.resumeLasttimeCounter();
            }
        }
        return bArr2;
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public byte[] comReceive(int i) {
        if (DiagnoseConstants.driviceConnStatus) {
            LocalSocketClient.setMaxWaitTime(100);
            LocalSocketClient.setFlashCode(true);
            LocalSocketClient.commandWaitLock.lock();
            try {
                LocalSocketClient.notReceiverCommand.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String bluetoothCommand = LocalSocketClient.getBluetoothCommand();
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "comReceive backOrder=".concat(String.valueOf(bluetoothCommand)));
            }
            LocalSocketClient.commandWaitLock.unlock();
            if (bluetoothCommand == null || bluetoothCommand.length() <= 0) {
                return null;
            }
            byte[] hexStringToBytes = ByteHexHelper.hexStringToBytes(bluetoothCommand);
            int i2 = (((hexStringToBytes[4] & 255) * 256) + (hexStringToBytes[5] & 255)) - 3;
            byte[] bArr = new byte[i2];
            int i3 = 0;
            for (int i4 = 9; i4 < i2 + 9; i4++) {
                bArr[i3] = hexStringToBytes[i4];
                i3++;
            }
            CToJavaImplements.recordReciveDataDiagnoseLog(hexStringToBytes);
            return bArr;
        }
        return null;
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public int appendLog(String str) {
        Log.w("MiddleDiag", str);
        return 0;
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public int onDiagExit() {
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_DIALOG);
            NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_DIALOG_EXIT);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public int openDbase(String str, String str2) {
        C1856n.m8125d(TAG, "openDbase ".concat(String.valueOf(str)));
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(str, null, 1);
        if (openDatabase != null) {
            if (this.mDbs.containsKey(str2)) {
                this.mDbs.remove(str2).close();
            }
            this.mDbs.put(str2, openDatabase);
            return 1;
        }
        return 0;
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public int closeDbase(String str) {
        if (this.mDbs.get(str) != null) {
            this.mDbs.get(str).close();
            this.mDbs.remove(str);
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.database.Cursor] */
    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] searchTextById(java.lang.String r8, java.lang.String r9, long r10, int r12) {
        /*
            r7 = this;
            java.util.Hashtable<java.lang.String, android.database.sqlite.SQLiteDatabase> r0 = r7.mDbs
            java.lang.Object r8 = r0.get(r8)
            android.database.sqlite.SQLiteDatabase r8 = (android.database.sqlite.SQLiteDatabase) r8
            r0 = 0
            if (r8 != 0) goto Lc
            return r0
        Lc:
            r1 = 1
            r12 = r12 & r1
            r2 = 2
            r3 = 0
            if (r12 != 0) goto L19
            java.lang.String[] r4 = new java.lang.String[r1]
            java.lang.String r5 = ""
            r4[r3] = r5
            goto L23
        L19:
            java.lang.String[] r4 = new java.lang.String[r2]
            java.lang.String r5 = ""
            r4[r3] = r5
            java.lang.String r5 = ""
            r4[r1] = r5
        L23:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "select * from "
            r5.<init>(r6)
            r5.append(r9)
            java.lang.String r9 = " where id="
            r5.append(r9)
            r5.append(r10)
            java.lang.String r9 = r5.toString()
            android.database.Cursor r8 = r8.rawQuery(r9, r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            if (r8 == 0) goto L5e
            int r9 = r8.getCount()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L72
            if (r9 <= 0) goto L5e
            r8.moveToFirst()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L72
            java.lang.String r9 = r8.getString(r1)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L72
            r4[r3] = r9     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L72
            if (r12 != r1) goto L56
            java.lang.String r9 = r8.getString(r2)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L72
            r4[r1] = r9     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L72
        L56:
            if (r8 == 0) goto L5b
            r8.close()
        L5b:
            return r4
        L5c:
            r9 = move-exception
            goto L69
        L5e:
            if (r8 == 0) goto L63
            r8.close()
        L63:
            return r0
        L64:
            r9 = move-exception
            r8 = r0
            goto L73
        L67:
            r9 = move-exception
            r8 = r0
        L69:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L72
            if (r8 == 0) goto L71
            r8.close()
        L71:
            return r0
        L72:
            r9 = move-exception
        L73:
            if (r8 == 0) goto L78
            r8.close()
        L78:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.newinterface.DiagnoseDataSrc.searchTextById(java.lang.String, java.lang.String, long, int):java.lang.String[]");
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public boolean getConnectorReady() {
        return CToJavaImplements.GetConnectorReady(this.mContext);
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public void notifyConnector(int i) {
        CToJavaImplements.NotifyConnector(i, this.mContext);
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public int getConnectorLinkMode() {
        return CToJavaImplements.GetConnectorLinkMode(this.mContext);
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public byte[] stdCallApk(byte[] bArr) {
        C1856n.m8125d(TAG, "stdCallApk");
        return this.mDiagBusiness.analysisDiagnoseData(bArr);
    }

    public String getText(byte[] bArr, int[] iArr) {
        int i = iArr[0];
        iArr[0] = i + 1;
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        int i3 = ((bArr[i] & 255) << 8) + (bArr[i2] & 255);
        String str = "";
        try {
            str = new String(bArr, iArr[0], i3, "UTF-8");
        } catch (Exception unused) {
        }
        iArr[0] = iArr[0] + i3;
        return str;
    }

    public int showAddress(byte[] bArr) {
        int[] iArr = {0};
        int i = bArr[iArr[0]] & 255;
        iArr[0] = iArr[0] + 1;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_ADDRESS);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_ADDRESS);
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < i; i2++) {
                String text = getText(bArr, iArr);
                boolean z = bArr[iArr[0]] != 0;
                iArr[0] = iArr[0] + 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Value, text);
                jSONObject.put(JsonConstText.Const_Text_Status, z);
                jSONArray.put(jSONObject);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showFuncHtml(byte[] bArr) {
        byte b = bArr[0];
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_Type_ShowTransDiagInfo);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_Type_ShowTransDiagInfo);
            JSONArray jSONArray = new JSONArray();
            String text = getText(bArr, new int[]{1});
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JsonConstText.Const_Text_Context, text);
            jSONArray.put(jSONObject);
            if (b == 1) {
                jSONObject.put(JsonConstText.Const_Text_Label, 2);
            } else {
                jSONObject.put(JsonConstText.Const_Text_Label, -1);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Title, "");
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Data, jSONArray);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Type, DiagnoseConstants.FEEDBACK_SPT_CUSTOM_USE_ID);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.cnlaunch.diagnosemodule.newinterface.ApkInterface
    public String showInputBox(byte[] bArr) {
        JSONObject AddDataJsonObjToNewJson;
        int[] iArr = {0};
        String text = getText(bArr, iArr);
        String text2 = getText(bArr, iArr);
        String text3 = getText(bArr, iArr);
        int i = iArr[0];
        iArr[0] = i + 1;
        byte b = bArr[i];
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        int i3 = bArr[i2] & 255;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson("200");
            if (b == 1) {
                AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_DIALOG_INPUT_NUMERIC);
            } else {
                AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_DIALOG_INPUTSTRING_EX);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Title, text);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Content, text2);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_CtrolLength, i3);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_default, text3);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            synchronized (this.mLock) {
                this.mLock.wait();
            }
            return this.mRetString;
        } catch (Exception unused) {
            return null;
        }
    }

    private int showFunCustom(byte[] bArr) {
        int[] iArr = {0};
        Object text = getText(bArr, iArr);
        int i = iArr[0];
        iArr[0] = i + 1;
        int i2 = bArr[i];
        int i3 = iArr[0];
        iArr[0] = i3 + 1;
        int i4 = bArr[i3] & 255;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_SPECIAL_CUSTOM_ROW_COL);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_SPECIAL_CUSTOM_ROW_COL);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Title, text);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Model, i2);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Colums, i4);
            JSONArray jSONArray = new JSONArray();
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = iArr[0];
                iArr[0] = i6 + 1;
                byte b = bArr[i6];
                String text2 = getText(bArr, iArr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Title, text2);
                jSONObject.put(JsonConstText.Const_Text_Scale, (int) b);
                jSONArray.put(jSONObject);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menutitle, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int i7 = iArr[0];
            iArr[0] = i7 + 1;
            int i8 = iArr[0];
            iArr[0] = i8 + 1;
            int i9 = ((bArr[i7] & 255) << 8) + (bArr[i8] & 255);
            for (int i10 = 0; i10 < i9; i10++) {
                for (int i11 = 0; i11 < i4; i11++) {
                    String text3 = getText(bArr, iArr);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(JsonConstText.Const_Text_Value, text3);
                    jSONArray2.put(jSONObject2);
                }
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray2);
            int i12 = iArr[0];
            iArr[0] = i12 + 1;
            int i13 = iArr[0];
            iArr[0] = i13 + 1;
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Status, (short) (((bArr[i12] & 255) << 8) + (bArr[i13] & 255)));
            JSONArray jSONArray3 = new JSONArray();
            int i14 = iArr[0];
            iArr[0] = i14 + 1;
            int i15 = bArr[i14] & 255;
            for (int i16 = 0; i16 < i15; i16++) {
                String text4 = getText(bArr, iArr);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(JsonConstText.Const_Text_Title, text4);
                jSONArray3.put(jSONObject3);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray3);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showFuncActionStream(byte[] bArr) {
        int[] iArr = {0};
        int i = iArr[0];
        iArr[0] = i + 1;
        boolean z = bArr[i] != 0;
        Object text = getText(bArr, iArr);
        Object text2 = getText(bArr, iArr);
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        int i3 = iArr[0];
        iArr[0] = i3 + 1;
        int i4 = ((bArr[i2] & 255) << 8) + (bArr[i3] & 255);
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_ACTIVE_TEST);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_ACTIVE_TEST);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Status, z ? 1 : 0);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Title, text);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Value, text2);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JsonConstText.Const_Text_Title, text);
            jSONObject.put(JsonConstText.Const_Text_Value, text2);
            jSONObject.put(JsonConstText.Const_Text_Unit, "");
            jSONObject.put(JsonConstText.Const_Text_Item, 0);
            jSONArray.put(jSONObject);
            if (i4 > 0) {
                int i5 = iArr[0];
                iArr[0] = i5 + 1;
                boolean z2 = bArr[i5] != 0;
                int i6 = iArr[0];
                iArr[0] = i6 + 1;
                int i7 = iArr[0];
                iArr[0] = i7 + 1;
                int i8 = ((bArr[i6] & 255) << 8) + (bArr[i7] & 255);
                for (int i9 = 0; i9 < i8; i9++) {
                    int i10 = iArr[0];
                    iArr[0] = i10 + 1;
                    int i11 = iArr[0];
                    iArr[0] = i11 + 1;
                    int i12 = ((bArr[i10] & 255) << 8) + (bArr[i11] & 255);
                    String text3 = getText(bArr, iArr);
                    String text4 = getText(bArr, iArr);
                    if (z2) {
                        getText(bArr, iArr);
                    }
                    String text5 = getText(bArr, iArr);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(JsonConstText.Const_Text_Title, text3);
                    jSONObject2.put(JsonConstText.Const_Text_Value, text4);
                    jSONObject2.put(JsonConstText.Const_Text_Unit, text5);
                    jSONObject2.put(JsonConstText.Const_Text_Item, i12);
                    jSONArray.put(jSONObject2);
                }
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int i13 = iArr[0];
            iArr[0] = i13 + 1;
            int i14 = bArr[i13] & 255;
            for (int i15 = 0; i15 < i14; i15++) {
                String text6 = getText(bArr, iArr);
                String text7 = getText(bArr, iArr);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(JsonConstText.Const_Text_Title, text6);
                jSONObject3.put(JsonConstText.Const_Text_Cmd, text7);
                jSONArray2.put(jSONObject3);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray2);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Arguments, true);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showSubdtc(byte[] bArr) {
        byte[] bArr2 = bArr;
        char c = 0;
        int[] iArr = {0};
        int i = iArr[0];
        iArr[0] = i + 1;
        boolean z = bArr2[i] != 0;
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        boolean z2 = bArr2[i2] != 0;
        int i3 = iArr[0];
        iArr[0] = i3 + 1;
        boolean z3 = bArr2[i3] != 0;
        int i4 = iArr[0];
        iArr[0] = i4 + 1;
        int i5 = iArr[0];
        iArr[0] = i5 + 1;
        int i6 = ((bArr2[i4] & 255) << 8) + (bArr2[i5] & 255);
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_Type_ShowTransDiagInfo);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_Type_ShowTransDiagInfo);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Type, DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_IsHasContinue, z2);
            JSONArray jSONArray = new JSONArray();
            int i7 = 0;
            while (i7 < i6) {
                Object text = getText(bArr2, iArr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Context, text);
                JSONArray jSONArray2 = new JSONArray();
                int i8 = iArr[c];
                iArr[c] = i8 + 1;
                int i9 = iArr[c];
                iArr[c] = i9 + 1;
                int i10 = ((bArr2[i8] & 255) << 8) + (bArr2[i9] & 255);
                int i11 = 0;
                while (i11 < i10) {
                    String text2 = getText(bArr2, iArr);
                    String text3 = getText(bArr2, iArr);
                    int i12 = i6;
                    String text4 = getText(bArr2, iArr);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(JsonConstText.Const_Text_Title, text2);
                    jSONObject2.put(JsonConstText.Const_Text_Context, text3);
                    jSONObject2.put(JsonConstText.Const_Text_Status, text4);
                    jSONArray2.put(jSONObject2);
                    i11++;
                    i6 = i12;
                    iArr = iArr;
                    bArr2 = bArr;
                }
                int[] iArr2 = iArr;
                int i13 = i6;
                jSONObject.put(JsonConstText.Const_Text_Data, jSONArray2);
                jSONArray.put(jSONObject);
                if (i7 == 0) {
                    jSONObject.put(JsonConstText.Const_Text_Help, z);
                    jSONObject.put(JsonConstText.Const_Text_ClearDtcCmd, z3);
                }
                i7++;
                i6 = i13;
                iArr = iArr2;
                bArr2 = bArr;
                c = 0;
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showReadStream(byte[] bArr) {
        char c = 0;
        int[] iArr = {0};
        int i = iArr[0];
        iArr[0] = i + 1;
        boolean z = bArr[i] != 0;
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        int i3 = iArr[0];
        iArr[0] = i3 + 1;
        int i4 = ((bArr[i2] & 255) << 8) + (bArr[i3] & 255);
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_DATASTREAM);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_DATASTREAM);
            JSONArray jSONArray = new JSONArray();
            int i5 = 0;
            while (i5 < i4) {
                int i6 = iArr[c];
                iArr[c] = i6 + 1;
                int i7 = iArr[c];
                iArr[c] = i7 + 1;
                int i8 = ((bArr[i6] & 255) << 8) + (bArr[i7] & 255);
                String text = getText(bArr, iArr);
                String text2 = getText(bArr, iArr);
                if (z) {
                    getText(bArr, iArr);
                }
                String text3 = getText(bArr, iArr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Title, text);
                jSONObject.put(JsonConstText.Const_Text_Value, text2);
                jSONObject.put(JsonConstText.Const_Text_Unit, text3);
                jSONObject.put(JsonConstText.Const_Text_Item, i8);
                jSONArray.put(jSONObject);
                i5++;
                c = 0;
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showFuncDataSelect(byte[] bArr) {
        int[] iArr = {0};
        Object text = getText(bArr, iArr);
        int i = iArr[0];
        iArr[0] = i + 1;
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        int i3 = ((bArr[i] & 255) << 8) + (bArr[i2] & 255);
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_DATASTREAM_SELECT);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_DATASTREAM_SELECT);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Title, text);
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < i3; i4++) {
                String text2 = getText(bArr, iArr);
                int i5 = iArr[0];
                iArr[0] = i5 + 1;
                boolean z = bArr[i5] != 0;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Check, z);
                jSONObject.put(JsonConstText.Const_Text_Title, text2);
                jSONArray.put(jSONObject);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int showFuncMenu(byte[] bArr, boolean z) {
        int[] iArr = {0};
        Object text = getText(bArr, iArr);
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson("300");
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_TOPOLOGY_MENU_AND_HELP_BTN_ID);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Label, z);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Title, text);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Item, 0);
            JSONArray jSONArray = new JSONArray();
            int i = iArr[0];
            iArr[0] = i + 1;
            int i2 = bArr[i] & 255;
            for (int i3 = 0; i3 < i2; i3++) {
                String text2 = getText(bArr, iArr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Title, text2);
                jSONArray.put(jSONObject);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showReadDtc(byte[] bArr) {
        int[] iArr = {0};
        int i = iArr[0];
        iArr[0] = i + 1;
        String str = bArr[i] == 1 ? "1" : "";
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        boolean z = bArr[i2] == 1;
        int i3 = iArr[0];
        iArr[0] = i3 + 1;
        int i4 = iArr[0];
        iArr[0] = i4 + 1;
        int i5 = ((bArr[i3] & 255) << 8) + (bArr[i4] & 255);
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_FAULTCODE);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_FAULTCODE);
            JSONArray jSONArray = new JSONArray();
            for (int i6 = 0; i6 < i5; i6++) {
                String text = getText(bArr, iArr);
                String text2 = getText(bArr, iArr);
                String text3 = getText(bArr, iArr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Title, text);
                jSONObject.put(JsonConstText.Const_Text_Context, text2);
                jSONObject.put(JsonConstText.Const_Text_Status, text3);
                jSONObject.put(JsonConstText.Const_Text_Help, str);
                jSONObject.put(JsonConstText.Const_Text_IsExitFreeze, z);
                jSONArray.put(jSONObject);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int i7 = iArr[0];
            iArr[0] = i7 + 1;
            int i8 = bArr[i7] & 255;
            for (int i9 = 0; i9 < i8; i9++) {
                String text4 = getText(bArr, iArr);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(JsonConstText.Const_Text_Title, text4);
                jSONArray2.put(jSONObject2);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray2);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showFuncVersion(byte[] bArr) {
        int[] iArr = {0};
        int i = iArr[0];
        iArr[0] = i + 1;
        int i2 = bArr[i] & 255;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_VERSION_INFORMATION);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_VERSION_INFORMATION);
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < i2; i3++) {
                String text = getText(bArr, iArr);
                String text2 = getText(bArr, iArr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Label, text);
                jSONObject.put(JsonConstText.Const_Text_Content, text2);
                jSONArray.put(jSONObject);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showFuncMessage(byte[] bArr, boolean z) {
        int[] iArr = {0};
        Object text = getText(bArr, iArr);
        int i = iArr[0];
        iArr[0] = i + 1;
        int i2 = bArr[i] & 255;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_INFORMATION_SHOW);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_INFORMATION_SHOW);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Content, text);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Label, z);
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < i2; i3++) {
                String text2 = getText(bArr, iArr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Value, text2);
                jSONArray.put(jSONObject);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showLableSubFunc(byte[] bArr) {
        int[] iArr = {0};
        int i = iArr[0];
        iArr[0] = i + 1;
        byte b = bArr[i];
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        int i3 = bArr[i2] & 255;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_SUB_LABEL);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_SUB_LABEL);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Status, b == 1);
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < i3; i4++) {
                String text = getText(bArr, iArr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Value, text);
                jSONArray.put(jSONObject);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Type, bArr[iArr[0]]);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showSystemScan(byte[] bArr, boolean z) {
        int[] iArr = {0};
        Object text = getText(bArr, iArr);
        int i = iArr[0];
        iArr[0] = i + 1;
        byte b = bArr[i];
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        int i3 = bArr[i2] & 255;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_SPECIAL_FUNCTION);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_SPECIAL_FUNCTION);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Title, text);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Colums, "2");
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Funtype, z);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JsonConstText.Const_Text_Title, "");
            jSONObject.put(JsonConstText.Const_Text_Model, "1");
            jSONObject.put(JsonConstText.Const_Text_Scale, DiagnoseConstants.FEEDBACK_SPT_VERYDY_MAINTENANCE);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(JsonConstText.Const_Text_Title, "");
            jSONObject2.put(JsonConstText.Const_Text_Model, "2");
            jSONObject2.put(JsonConstText.Const_Text_Scale, "20");
            jSONArray.put(jSONObject2);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menutitle, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(JsonConstText.Const_Text_Value, "process");
            JSONObject jSONObject4 = new JSONObject();
            String str = JsonConstText.Const_Text_Value;
            jSONObject4.put(str, ((int) b) + "%");
            jSONArray2.put(jSONObject3);
            jSONArray2.put(jSONObject4);
            for (int i4 = 0; i4 < i3; i4++) {
                String text2 = getText(bArr, iArr);
                String text3 = getText(bArr, iArr);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(JsonConstText.Const_Text_Value, text2);
                jSONArray2.put(jSONObject5);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(JsonConstText.Const_Text_Value, text3);
                jSONArray2.put(jSONObject6);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            int i5 = iArr[0];
            iArr[0] = i5 + 1;
            int i6 = bArr[i5] & 255;
            for (int i7 = 0; i7 < i6; i7++) {
                String text4 = getText(bArr, iArr);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(JsonConstText.Const_Text_Title, text4);
                jSONObject7.put(JsonConstText.Const_Text_Cmd, "0");
                jSONArray3.put(jSONObject7);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray3);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showMessageBox(byte[] bArr, boolean z) {
        int[] iArr = {0};
        int i = iArr[0];
        iArr[0] = i + 1;
        int i2 = bArr[i];
        Object text = getText(bArr, iArr);
        Object text2 = getText(bArr, iArr);
        int i3 = iArr[0];
        iArr[0] = i3 + 1;
        int i4 = bArr[i3] & 255;
        ArrayList arrayList = new ArrayList();
        if (i4 > 0) {
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(getText(bArr, iArr));
            }
        }
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_DIALOG);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_DIALOG_BUTTONS);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Title, text);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Type, i2);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Content, text2);
            if (z) {
                AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Diag_Lock, true);
            }
            if (i4 > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i6 = 0; i6 < i4; i6++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(JsonConstText.Const_Text_Value, arrayList.get(i6));
                    jSONArray.put(jSONObject);
                }
                AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray);
            }
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            if (z) {
                synchronized (this.mLock) {
                    this.mLock.wait();
                }
                return this.mRetId;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showChannel(byte[] bArr) {
        int[] iArr = {0};
        Object text = getText(bArr, iArr);
        int i = iArr[0];
        iArr[0] = i + 1;
        boolean z = bArr[i] != 0;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_CHANEL_SELECT);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_CHANEL_SELECT);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Status, z);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Value, text);
            JSONArray jSONArray = new JSONArray();
            int i2 = iArr[0];
            iArr[0] = i2 + 1;
            byte b = bArr[i2];
            for (int i3 = 0; i3 < b; i3++) {
                Object text2 = getText(bArr, iArr);
                int i4 = iArr[0];
                iArr[0] = i4 + 1;
                int i5 = iArr[0];
                iArr[0] = i5 + 1;
                int i6 = ((bArr[i4] & 255) << 8) + (bArr[i5] & 255);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Label, text2);
                jSONArray.put(jSONObject);
                JSONArray jSONArray2 = new JSONArray();
                for (int i7 = 0; i7 < i6; i7++) {
                    String text3 = getText(bArr, iArr);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(JsonConstText.Const_Text_Value, text3);
                    jSONArray2.put(jSONObject2);
                }
                jSONObject.put(JsonConstText.Const_Text_Buttondata, jSONArray2);
                int i8 = iArr[0];
                iArr[0] = i8 + 1;
                jSONObject.put(JsonConstText.Const_Text_Item, bArr[i8]);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            int i9 = iArr[0];
            iArr[0] = i9 + 1;
            int i10 = bArr[i9] & 255;
            JSONArray jSONArray3 = new JSONArray();
            for (int i11 = 0; i11 < i10; i11++) {
                String text4 = getText(bArr, iArr);
                int i12 = iArr[0];
                iArr[0] = i12 + 1;
                byte b2 = bArr[i12];
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(JsonConstText.Const_Text_Value, text4);
                jSONObject3.put(JsonConstText.Const_Text_Status, b2 == 1);
                jSONArray3.put(jSONObject3);
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Buttondata, jSONArray3);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int showRichView(byte[] bArr) {
        int i = 1;
        char c = 0;
        int[] iArr = {0};
        Object text = getText(bArr, iArr);
        int i2 = iArr[0];
        iArr[0] = i2 + 1;
        boolean z = bArr[i2] != 0;
        int i3 = iArr[0];
        iArr[0] = i3 + 1;
        int i4 = bArr[i3] & 255;
        try {
            JSONObject createBaseNewJson = NewFrameData2JsonUtil.createBaseNewJson(DiagnoseConstants.UI_TYPE_LEFT_VIEW);
            JSONObject AddDataJsonObjToNewJson = NewFrameData2JsonUtil.AddDataJsonObjToNewJson(createBaseNewJson, DiagnoseConstants.UI_TYPE_LEFT_VIEW);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Status, z);
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Value, text);
            JSONArray jSONArray = new JSONArray();
            int i5 = 0;
            while (i5 < i4) {
                Object text2 = getText(bArr, iArr);
                int i6 = iArr[c];
                iArr[c] = i6 + 1;
                int i7 = bArr[i6];
                iArr[c] = iArr[c] + i;
                iArr[c] = iArr[c] + i;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Value, text2);
                jSONObject.put(JsonConstText.Const_Text_CurrNum, i7);
                jSONArray.put(jSONObject);
                JSONArray jSONArray2 = new JSONArray();
                int i8 = 0;
                while (i8 < i7) {
                    String text3 = getText(bArr, iArr);
                    String text4 = getText(bArr, iArr);
                    String text5 = getText(bArr, iArr);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(JsonConstText.Const_Text_Content, text4);
                    jSONObject2.put(JsonConstText.Const_Text_Value, text3);
                    jSONObject2.put(JsonConstText.Const_Text_Status, text5);
                    jSONArray2.put(jSONObject2);
                    i8++;
                    i4 = i4;
                }
                jSONObject.put(JsonConstText.Const_Text_Buttondata, jSONArray2);
                i5++;
                i4 = i4;
                i = 1;
                c = 0;
            }
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Menudata, jSONArray);
            int i9 = iArr[0];
            iArr[0] = i9 + 1;
            AddDataJsonObjToNewJson.put(JsonConstText.Const_Text_Type, bArr[i9]);
            this.mDiagBusiness.sendUIData(createBaseNewJson);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
