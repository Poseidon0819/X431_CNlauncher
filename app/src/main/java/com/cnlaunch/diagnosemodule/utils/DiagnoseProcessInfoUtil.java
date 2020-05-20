package com.cnlaunch.diagnosemodule.utils;

import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamWithSubItemBean;
import com.cnlaunch.diagnosemodule.bean.BasicECUInfoBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSampleDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.AbbreviationBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.DataForGolo365;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_DataStreamBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_FreezeBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_VehicleInfo;
import com.cnlaunch.diagnosemodule.bean.SDefDSData.BasicDefDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.SDefDSData.BasicDefDataStreamInfoBean;
import com.cnlaunch.diagnosemodule.bean.SDefDSData.BasicDefDataStreamValueBean;
import com.cnlaunch.diagnosemodule.bean.SDefDSData.BasicDefSubItemDataStreamBean;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class DiagnoseProcessInfoUtil {
    private static DiagnoseProcessInfoUtil instance = null;
    public static int typeGrapDataStreamFor94_GrapGrid = 1;
    public static int typeGrapDataStreamFor94_GrapGrid_Custom = 2;
    public static int typeGrapDataStreamFor94_TextList;
    private BasicDefDataStreamInfoBean defDataStreamInfoBean;
    private EP_VehicleInfo ep_VehicleInfo;
    private ArrayList<Integer> indexDataStream;
    private DiagnoseDataChangeCallBack mcallBack;
    private byte[] refDsRet;
    private byte[] refDsRetForGrapGrid;
    private byte[] refDsRetForGrapGrid_Custom;
    private byte[] refDsRetForGrapShow;
    private byte[] refDsRetForRecord;
    private byte[] refHelpRet;
    private boolean IsRecordState = false;
    private boolean IsRecordSampleDSState = false;
    private ArrayList<BasicSystemStatusBean> arSysData = new ArrayList<>();
    private ArrayList<BasicSampleDataStreamBean> arSampleDataStreamData = new ArrayList<>();
    private ArrayList<Integer> arrDefaultSelected = new ArrayList<>();
    private HashMap<Integer, BasicDefDataStreamBean> mapDataStreamSN2Info = new HashMap<>();
    public ArrayList<Integer> listAllReqDataStreamSN = new ArrayList<>();
    private int iStartPos = 0;
    private int iEndPos = 0;
    private boolean isGraphGrid = false;
    private boolean bHelpClicked = false;
    private int typeGrapDataStreamFor94 = typeGrapDataStreamFor94_TextList;
    private ArrayList<Integer> arrCollectedDataStreamNo = new ArrayList<>();
    private boolean bShowSubItemFor94Type = false;
    private ArrayList<AbbreviationBean> arEP_ReadyData = new ArrayList<>();
    private ArrayList<BasicFaultCodeBean> arEP_DTC = new ArrayList<>();
    private ArrayList<AbbreviationBean> arEP_IUPR = new ArrayList<>();
    private ArrayList<EP_FreezeBean> arEP_Freeze = new ArrayList<>();
    private ArrayList<EP_DataStreamBean> arEP_DataStream = new ArrayList<>();
    private boolean IsColloct_EP_Data = true;
    private DataForGolo365 dataForGolo365 = new DataForGolo365();

    /* loaded from: classes.dex */
    interface DiagnoseDataChangeCallBack {
        void notifyDataChange(int i);
    }

    /* loaded from: classes.dex */
    public enum DiagnoseDataType {
        VIN_CODE,
        ODO,
        LOCAL
    }

    public void setbShowSubItemFor94Type(boolean z) {
        this.bShowSubItemFor94Type = z;
    }

    public void AddDataStreamNoToCollected(int i) {
        this.arrCollectedDataStreamNo.add(Integer.valueOf(i));
    }

    public boolean isInCollectedByDataStreamNo(int i) {
        return this.arrCollectedDataStreamNo.contains(Integer.valueOf(i));
    }

    public void clearDefaultSelected() {
        this.arrDefaultSelected.clear();
    }

    public void clearRefDsRetData() {
        this.refDsRet = null;
        this.refDsRetForGrapGrid = null;
    }

    public void clearCollectedDataStreamNo() {
        this.arrCollectedDataStreamNo.clear();
        for (BasicDefDataStreamBean basicDefDataStreamBean : this.mapDataStreamSN2Info.values()) {
            basicDefDataStreamBean.setbGrapValidDataFor94Type(false);
        }
    }

    public ArrayList<Integer> getArrDefaultSelected() {
        return this.arrDefaultSelected;
    }

    public void setiStartPos(int i) {
        this.iStartPos = i;
    }

    public int getiStartPos() {
        return this.iStartPos;
    }

    public int getiEndPos() {
        return this.iEndPos;
    }

    public void setRefForGrapShow(byte[] bArr) {
        this.refDsRetForGrapShow = bArr;
    }

    public void setRefDsRet(byte[] bArr) {
        this.refDsRet = bArr;
    }

    public void setRefDsHelpRet(byte[] bArr) {
        this.bHelpClicked = true;
        this.refHelpRet = bArr;
    }

    public void setRefDsRetForGrapGrid(byte[] bArr) {
        this.refDsRetForGrapGrid = bArr;
    }

    public int getType94AllDSAtt() {
        return this.defDataStreamInfoBean.getAllDsAttr();
    }

    public int getTypeGrapDataStreamFor94() {
        return this.typeGrapDataStreamFor94;
    }

    public void setTypeGrapDataStreamFor94(int i) {
        this.typeGrapDataStreamFor94 = i;
    }

    public void setListAllReqDataStreamSN(ArrayList<Integer> arrayList) {
        this.listAllReqDataStreamSN.clear();
        this.listAllReqDataStreamSN.addAll(arrayList);
        setReturnForDSAllInforInRecording();
    }

    public int getPosFromlistAllReqDataStreamSN(Integer num) {
        for (int i = 0; i < this.listAllReqDataStreamSN.size(); i++) {
            if (this.listAllReqDataStreamSN.get(i) == num) {
                return i;
            }
        }
        return -1;
    }

    public void updateIndexDataStream(ArrayList<Integer> arrayList) {
        synchronized (DiagnoseProcessInfoUtil.class) {
            this.indexDataStream = arrayList;
        }
    }

    public int[] getShowIndexDataStream() {
        synchronized (DiagnoseProcessInfoUtil.class) {
            if (this.indexDataStream == null) {
                return null;
            }
            int i = this.iStartPos;
            int i2 = this.iEndPos;
            int i3 = i2 - i;
            if (!this.isGraphGrid) {
                int i4 = i3 / 2;
                i2 += i4;
                i -= i4;
            }
            int i5 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 > this.indexDataStream.size()) {
                i2 = this.indexDataStream.size();
            }
            int i6 = i2 - i;
            if (i6 < 0) {
                i6 = 0;
            }
            int[] iArr = new int[i6];
            while (i < i2) {
                iArr[i5] = this.indexDataStream.get(i).intValue();
                i++;
                i5++;
            }
            return iArr;
        }
    }

    public void setVisiblePosition(int i, int i2, boolean z) {
        this.iStartPos = i;
        this.iEndPos = i2;
        this.isGraphGrid = z;
    }

    public void setFirstPos2Ref(int i, int i2, ArrayList<Integer> arrayList) {
        this.iStartPos = i;
        setReturnForSetTop(i2, arrayList);
    }

    public byte[] getRefDsRet(boolean z, boolean z2) {
        if (this.bHelpClicked) {
            this.bHelpClicked = false;
            return this.refHelpRet;
        } else if (z) {
            return this.refDsRetForRecord;
        } else {
            if (z2) {
                int i = this.typeGrapDataStreamFor94;
                if (i == typeGrapDataStreamFor94_GrapGrid) {
                    byte[] bArr = this.refDsRetForGrapGrid;
                    return bArr == null ? this.refDsRet : bArr;
                } else if (i == typeGrapDataStreamFor94_GrapGrid_Custom) {
                    return this.refDsRetForGrapGrid_Custom;
                } else {
                    return this.refDsRetForGrapShow;
                }
            }
            return this.refDsRet;
        }
    }

    public BasicDefDataStreamInfoBean getDefDataStreamInfoBean() {
        return this.defDataStreamInfoBean;
    }

    public ArrayList<BasicDataStreamBean> setValueInfoForNewDataStream(ArrayList<BasicDefDataStreamValueBean> arrayList) {
        ArrayList<BasicDataStreamBean> arrayList2;
        synchronized (this.mapDataStreamSN2Info) {
            arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                int sn = arrayList.get(i).getSn();
                if (this.mapDataStreamSN2Info.containsKey(Integer.valueOf(sn))) {
                    BasicDefDataStreamBean basicDefDataStreamBean = this.mapDataStreamSN2Info.get(Integer.valueOf(sn));
                    if ((basicDefDataStreamBean.getDsAtt() & 4) == 4) {
                        for (int i2 = 0; i2 < arrayList.get(i).getArrValue().size(); i2++) {
                            BasicDefSubItemDataStreamBean basicDefSubItemDataStreamBean = basicDefDataStreamBean.getArrSubItemDS().get(i2);
                            basicDefSubItemDataStreamBean.setStandardvalueStatus(arrayList.get(i).getArrValueStatus().get(i2).booleanValue() ? "1" : "0");
                            basicDefSubItemDataStreamBean.setValue(arrayList.get(i).getArrValue().get(i2));
                        }
                    } else {
                        if ((getInstance().getType94AllDSAtt() & 4) == 4) {
                            basicDefDataStreamBean.setStandardvalueStatus(arrayList.get(i).getArrValueStatus().get(0).booleanValue() ? "1" : "0");
                        }
                        basicDefDataStreamBean.setValue(arrayList.get(i).getArrValue().get(0));
                    }
                    if (!getInstance().isInCollectedByDataStreamNo(sn)) {
                        getInstance().AddDataStreamNoToCollected(sn);
                        basicDefDataStreamBean.setbGrapValidDataFor94Type(true);
                    }
                }
            }
            for (int i3 = 0; i3 < this.listAllReqDataStreamSN.size(); i3++) {
                arrayList2.add(this.mapDataStreamSN2Info.get(this.listAllReqDataStreamSN.get(i3)).toDataStreamBean());
            }
            if (IsRecordSampleDS()) {
                addDataStreamBean2Sample(arrayList2);
            }
        }
        return arrayList2;
    }

    public ArrayList<BasicDataStreamBean> getAllDataStreamCurrentArrBean() {
        ArrayList<BasicDataStreamBean> arrayList = new ArrayList<>();
        for (int i = 0; i < this.listAllReqDataStreamSN.size(); i++) {
            arrayList.add(this.mapDataStreamSN2Info.get(this.listAllReqDataStreamSN.get(i)).toDataStreamBean());
        }
        return arrayList;
    }

    public void setDefDataStreamInfoBean(BasicDefDataStreamInfoBean basicDefDataStreamInfoBean) {
        this.defDataStreamInfoBean = basicDefDataStreamInfoBean;
        this.mapDataStreamSN2Info.clear();
        ArrayList<BasicDefDataStreamBean> arrDs = basicDefDataStreamInfoBean.getArrDs();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arrDs.size(); i++) {
            arrayList.add(Integer.valueOf(arrDs.get(i).getSn()));
        }
        setListAllReqDataStreamSN(arrayList);
        for (int i2 = 0; i2 < arrDs.size(); i2++) {
            this.mapDataStreamSN2Info.put(Integer.valueOf(arrDs.get(i2).getSn()), arrDs.get(i2));
        }
    }

    public void setRefForGrapShow(ArrayList<Integer> arrayList) {
        int size = arrayList.size();
        int i = (size * 2) + 2;
        byte[] bArr = new byte[i + 3];
        bArr[0] = 0;
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((size >> 8) & 255);
        bArr[4] = (byte) (size & 255);
        int i2 = 5;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = (this.bShowSubItemFor94Type ? arrayList.get(i3) : this.listAllReqDataStreamSN.get(arrayList.get(i3).intValue())).intValue();
            int i4 = i2 + 1;
            bArr[i2] = (byte) ((intValue >> 8) & 255);
            i2 = i4 + 1;
            bArr[i4] = (byte) (intValue & 255);
        }
        int i5 = this.typeGrapDataStreamFor94;
        if (i5 == typeGrapDataStreamFor94_TextList) {
            this.refDsRetForGrapShow = bArr;
        } else if (i5 == typeGrapDataStreamFor94_GrapGrid) {
            this.refDsRetForGrapGrid = bArr;
        } else if (i5 == typeGrapDataStreamFor94_GrapGrid_Custom) {
            this.refDsRetForGrapGrid_Custom = bArr;
        }
    }

    public void setReturnForDSAllInforInRecording() {
        ArrayList<Integer> arrayList = this.listAllReqDataStreamSN;
        int size = arrayList.size();
        int i = (size * 2) + 2;
        byte[] bArr = new byte[i + 3];
        bArr[0] = 0;
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((size >> 8) & 255);
        bArr[4] = (byte) (size & 255);
        int i2 = 5;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = arrayList.get(i3).intValue();
            int i4 = i2 + 1;
            bArr[i2] = (byte) ((intValue >> 8) & 255);
            i2 = i4 + 1;
            bArr[i4] = (byte) (intValue & 255);
        }
        this.refDsRetForRecord = bArr;
    }

    public byte[] setReturnForSetTop(int i, ArrayList<Integer> arrayList) {
        ArrayList<Integer> reqDSNoWithArrTop = getReqDSNoWithArrTop(this.iStartPos, i, arrayList);
        int size = reqDSNoWithArrTop.size();
        int i2 = (size * 2) + 2;
        byte[] bArr = new byte[i2 + 3];
        bArr[0] = 0;
        bArr[1] = (byte) ((i2 >> 8) & 255);
        bArr[2] = (byte) (i2 & 255);
        bArr[3] = (byte) ((size >> 8) & 255);
        bArr[4] = (byte) (size & 255);
        int i3 = 5;
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = reqDSNoWithArrTop.get(i4).intValue();
            int i5 = i3 + 1;
            bArr[i3] = (byte) ((intValue >> 8) & 255);
            i3 = i5 + 1;
            bArr[i5] = (byte) (intValue & 255);
        }
        this.refDsRet = bArr;
        return bArr;
    }

    public byte[] getReturnForDSAllInfor(int i, int i2) {
        ArrayList<Integer> reqDSNo = getReqDSNo(i, i2);
        int size = reqDSNo.size();
        int i3 = (size * 2) + 2;
        byte[] bArr = new byte[i3 + 3];
        bArr[0] = 0;
        bArr[1] = (byte) ((i3 >> 8) & 255);
        bArr[2] = (byte) (i3 & 255);
        bArr[3] = (byte) ((size >> 8) & 255);
        bArr[4] = (byte) (size & 255);
        int i4 = 5;
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = reqDSNo.get(i5).intValue();
            int i6 = i4 + 1;
            bArr[i4] = (byte) ((intValue >> 8) & 255);
            i4 = i6 + 1;
            bArr[i6] = (byte) (intValue & 255);
        }
        this.refDsRet = bArr;
        return bArr;
    }

    public ArrayList<Integer> getReqDSNo(int i, int i2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (i2 == 0) {
            return arrayList;
        }
        int size = this.listAllReqDataStreamSN.size();
        if (size < i2) {
            i2 = size;
        } else if (i + i2 > size) {
            i = size - i2;
        }
        int i3 = 0;
        while (i < size) {
            arrayList.add(this.listAllReqDataStreamSN.get(i));
            i3++;
            if (i3 == i2) {
                break;
            }
            i++;
        }
        return arrayList;
    }

    public ArrayList<Integer> getReqDSNoWithArrTop(int i, int i2, ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (i2 == 0) {
            return arrayList2;
        }
        int size = this.listAllReqDataStreamSN.size();
        if (size < i2) {
            i2 = size;
        }
        int size2 = arrayList.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList2.add(arrayList.get(i4));
            i3++;
        }
        for (int i5 = 0; i5 < size; i5++) {
            if (!arrayList.contains(this.listAllReqDataStreamSN.get(i5))) {
                if (i == 0) {
                    arrayList2.add(this.listAllReqDataStreamSN.get(i5));
                    i3++;
                    if (i3 == i2) {
                        break;
                    }
                } else {
                    i--;
                }
            }
        }
        return arrayList2;
    }

    public DataForGolo365 getDataForGolo365() {
        return this.dataForGolo365;
    }

    public boolean isColloct_EP_Data() {
        return this.IsColloct_EP_Data;
    }

    public void setColloct_EP_Data(boolean z) {
        this.IsColloct_EP_Data = z;
    }

    public EP_VehicleInfo getEp_VehicleInfo() {
        return this.ep_VehicleInfo;
    }

    public void setEp_VehicleInfo(EP_VehicleInfo eP_VehicleInfo) {
        this.ep_VehicleInfo = eP_VehicleInfo;
    }

    public ArrayList<AbbreviationBean> getArEP_ReadyData() {
        return this.arEP_ReadyData;
    }

    public ArrayList<BasicFaultCodeBean> getArEP_DTC() {
        return this.arEP_DTC;
    }

    public ArrayList<AbbreviationBean> getArEP_IUPR() {
        return this.arEP_IUPR;
    }

    public ArrayList<EP_FreezeBean> getArEP_Freeze() {
        return this.arEP_Freeze;
    }

    public ArrayList<EP_DataStreamBean> getArEP_DataStream() {
        return this.arEP_DataStream;
    }

    public void clearEPData() {
        this.ep_VehicleInfo = null;
        ArrayList<AbbreviationBean> arrayList = this.arEP_ReadyData;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<BasicFaultCodeBean> arrayList2 = this.arEP_DTC;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList<AbbreviationBean> arrayList3 = this.arEP_IUPR;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        ArrayList<EP_FreezeBean> arrayList4 = this.arEP_Freeze;
        if (arrayList4 != null) {
            arrayList4.clear();
        }
        ArrayList<EP_DataStreamBean> arrayList5 = this.arEP_DataStream;
        if (arrayList5 != null) {
            arrayList5.clear();
        }
    }

    public static DiagnoseProcessInfoUtil getInstance() {
        if (instance == null) {
            instance = new DiagnoseProcessInfoUtil();
        }
        return instance;
    }

    public void hasDataBeSet(DiagnoseDataType diagnoseDataType) {
        DiagnoseDataChangeCallBack diagnoseDataChangeCallBack = this.mcallBack;
        if (diagnoseDataChangeCallBack != null) {
            diagnoseDataChangeCallBack.notifyDataChange(diagnoseDataType.ordinal());
        }
    }

    public void clearAllSystemData() {
        this.arSysData.clear();
    }

    public void clearAllSampleDataStreamData() {
        this.arSampleDataStreamData.clear();
    }

    public void setDiagnoseDataChangeCallBack(DiagnoseDataChangeCallBack diagnoseDataChangeCallBack) {
        this.mcallBack = diagnoseDataChangeCallBack;
    }

    public void removeDiagnoseDataChangeCallBack(DiagnoseDataChangeCallBack diagnoseDataChangeCallBack) {
        if (this.mcallBack == diagnoseDataChangeCallBack) {
            this.mcallBack = null;
        }
    }

    public ArrayList<BasicSampleDataStreamBean> getArSampleDataStreamData() {
        return this.arSampleDataStreamData;
    }

    public ArrayList<BasicSystemStatusBean> getArSysData() {
        return this.arSysData;
    }

    private BasicSystemStatusBean getSystemStatusBeanBySystemID(String str) {
        if (!this.IsRecordState || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.arSysData.size(); i++) {
            BasicSystemStatusBean basicSystemStatusBean = this.arSysData.get(i);
            if (basicSystemStatusBean.getSystemID().equals(str)) {
                return basicSystemStatusBean;
            }
        }
        return null;
    }

    private BasicSystemStatusBean getSystemStatusBeanBySystemName(String str) {
        if (!this.IsRecordState || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.arSysData.size(); i++) {
            BasicSystemStatusBean basicSystemStatusBean = this.arSysData.get(i);
            if (basicSystemStatusBean.getSystemName().equals(str)) {
                return basicSystemStatusBean;
            }
        }
        return null;
    }

    private boolean IsNeedAddSysBySysID(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.arSysData.size(); i++) {
            if (this.arSysData.get(i).getSystemID().equals(str)) {
                return false;
            }
        }
        return true;
    }

    public void addSysBasicInf(String str, String str2, String str3) {
        if (this.IsRecordState && IsNeedAddSysBySysID(str2)) {
            BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
            basicSystemStatusBean.setSystemID(str2);
            basicSystemStatusBean.setSystemUUID(str3);
            basicSystemStatusBean.setSystemName(str);
            this.arSysData.add(basicSystemStatusBean);
        }
    }

    private void addFaultCodeBeanToArrNoSame(ArrayList<BasicFaultCodeBean> arrayList, BasicFaultCodeBean basicFaultCodeBean) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (basicFaultCodeBean.equals(arrayList.get(i))) {
                return;
            }
        }
        arrayList.add(basicFaultCodeBean);
    }

    private void addECUArrNoSame(ArrayList<BasicECUInfoBean> arrayList, BasicECUInfoBean basicECUInfoBean) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (basicECUInfoBean.equals(arrayList.get(i))) {
                return;
            }
        }
        arrayList.add(basicECUInfoBean);
    }

    public void addSysFaultCodeBeanInfoFromSpecilFunction(ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList, String str) {
        ArrayList<BasicFaultCodeBean> faultColde;
        if (!this.IsRecordState || TextUtils.isEmpty(str) || (faultColde = getFaultColde(arrayList)) == null) {
            return;
        }
        addSysFaultCodeBeanInfo(faultColde, str);
    }

    public void addSysDataStreamInfoFromSpecilFunction(ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList, String str) {
        ArrayList<BasicDataStreamBean> dataStreamFromSF;
        if (!this.IsRecordState || TextUtils.isEmpty(str) || (dataStreamFromSF = getDataStreamFromSF(arrayList)) == null) {
            return;
        }
        addDataStreamBeanInfo(dataStreamFromSF, str, true);
    }

    public void addSysECUInfoFromSpecilFunction(ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList, String str) {
        ArrayList<BasicECUInfoBean> eCUInfoFromSF;
        if (!this.IsRecordState || TextUtils.isEmpty(str) || (eCUInfoFromSF = getECUInfoFromSF(arrayList)) == null) {
            return;
        }
        addSysECUInfo(eCUInfoFromSF, str);
    }

    public void addSysFaultCodeBeanBySystemName(ArrayList<BasicFaultCodeBean> arrayList, String str) {
        BasicSystemStatusBean systemStatusBeanBySystemName = getSystemStatusBeanBySystemName(str);
        if (systemStatusBeanBySystemName == null) {
            return;
        }
        if (systemStatusBeanBySystemName.getSystemFaultCodeBean().size() == 0) {
            systemStatusBeanBySystemName.setSystemFaultCodeBean(arrayList);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            addFaultCodeBeanToArrNoSame(systemStatusBeanBySystemName.getSystemFaultCodeBean(), arrayList.get(i));
        }
    }

    public void addSysECUInfoFromDialog(String str, String str2, String str3) {
        BasicSystemStatusBean systemStatusBeanBySystemID = getSystemStatusBeanBySystemID(str3);
        if (systemStatusBeanBySystemID == null) {
            return;
        }
        BasicECUInfoBean basicECUInfoBean = new BasicECUInfoBean();
        basicECUInfoBean.setTitle(str);
        basicECUInfoBean.setValue(str2);
        basicECUInfoBean.setId("");
        addECUArrNoSame(systemStatusBeanBySystemID.getSystemECUInfoBean(), basicECUInfoBean);
    }

    public void addSysECUInfo(ArrayList<BasicECUInfoBean> arrayList, String str) {
        BasicSystemStatusBean systemStatusBeanBySystemID = getSystemStatusBeanBySystemID(str);
        if (systemStatusBeanBySystemID == null) {
            return;
        }
        if (systemStatusBeanBySystemID.getSystemECUInfoBean().size() == 0) {
            systemStatusBeanBySystemID.setSystemECUInfoBean(arrayList);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            addECUArrNoSame(systemStatusBeanBySystemID.getSystemECUInfoBean(), arrayList.get(i));
        }
    }

    public void addSysFaultCodeBeanInfo(ArrayList<BasicFaultCodeBean> arrayList, String str) {
        BasicSystemStatusBean systemStatusBeanBySystemID = getSystemStatusBeanBySystemID(str);
        if (systemStatusBeanBySystemID == null) {
            return;
        }
        if (systemStatusBeanBySystemID.getSystemFaultCodeBean().size() == 0) {
            systemStatusBeanBySystemID.setSystemFaultCodeBean(arrayList);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            addFaultCodeBeanToArrNoSame(systemStatusBeanBySystemID.getSystemFaultCodeBean(), arrayList.get(i));
        }
    }

    private void addFaultCodeBeanById(ArrayList<BasicFaultCodeBean> arrayList, BasicFaultCodeBean basicFaultCodeBean) {
        for (int i = 0; i < arrayList.size(); i++) {
            BasicFaultCodeBean basicFaultCodeBean2 = arrayList.get(i);
            if (basicFaultCodeBean.getId() == basicFaultCodeBean2.getId()) {
                basicFaultCodeBean2.setTitle(basicFaultCodeBean.getTitle());
                basicFaultCodeBean2.setContext(basicFaultCodeBean.getContext());
                basicFaultCodeBean2.setStatus(basicFaultCodeBean.getStatus());
                basicFaultCodeBean2.setSamllCode(basicFaultCodeBean.getSamllCode());
                return;
            }
        }
        arrayList.add(basicFaultCodeBean);
    }

    public void addOnlineSysFaultCodeBeanInfo(ArrayList<BasicFaultCodeBean> arrayList, String str) {
        BasicSystemStatusBean systemStatusBeanBySystemID = getSystemStatusBeanBySystemID(str);
        if (systemStatusBeanBySystemID == null) {
            return;
        }
        if (systemStatusBeanBySystemID.getSystemFaultCodeBean().size() == 0) {
            systemStatusBeanBySystemID.setSystemFaultCodeBean(arrayList);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            addFaultCodeBeanById(systemStatusBeanBySystemID.getSystemFaultCodeBean(), arrayList.get(i));
        }
    }

    private void AddDataStreamToArr(ArrayList<BasicDataStreamBean> arrayList, BasicDataStreamBean basicDataStreamBean, boolean z) {
        if (!z) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (basicDataStreamBean.equalsByIDAndTitle(arrayList.get(i))) {
                    return;
                }
            }
        }
        arrayList.add(basicDataStreamBean);
    }

    public void addECUInfoFromDataStreamBean(ArrayList<BasicDataStreamBean> arrayList, String str) {
        if (arrayList == null || getSystemStatusBeanBySystemID(str) == null) {
            return;
        }
        ArrayList<BasicECUInfoBean> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            BasicECUInfoBean basicECUInfoBean = new BasicECUInfoBean();
            basicECUInfoBean.setId(arrayList.get(i).getId());
            basicECUInfoBean.setTitle(arrayList.get(i).getTitle());
            basicECUInfoBean.setValue(arrayList.get(i).getSrcValue() + arrayList.get(i).getSrcUnit());
            arrayList2.add(basicECUInfoBean);
        }
        addSysECUInfo(arrayList2, str);
    }

    public void addDataStreamBeanInfo(ArrayList<BasicDataStreamBean> arrayList, String str, boolean z) {
        BasicSystemStatusBean systemStatusBeanBySystemID = getSystemStatusBeanBySystemID(str);
        if (systemStatusBeanBySystemID == null) {
            return;
        }
        if (systemStatusBeanBySystemID.getDataStreamInfoList().size() == 0) {
            systemStatusBeanBySystemID.setDataStreamInfoList(arrayList);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            AddDataStreamToArr(systemStatusBeanBySystemID.getDataStreamInfoList(), arrayList.get(i), z);
        }
    }

    private ArrayList<BasicECUInfoBean> getECUInfoFromSF(ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<BasicECUInfoBean> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            BasicECUInfoBean basicECUInfoBean = new BasicECUInfoBean();
            int size = arrayList.get(i).size();
            if (size >= 2) {
                if (arrayList.get(i).get(0) != null) {
                    basicECUInfoBean.setTitle(arrayList.get(i).get(0).getTitle());
                } else {
                    basicECUInfoBean.setTitle("");
                }
                basicECUInfoBean.setId("");
                if (arrayList.get(i).get(1) != null) {
                    basicECUInfoBean.setValue(arrayList.get(i).get(1).getTitle());
                } else {
                    basicECUInfoBean.setValue("");
                }
                for (int i2 = 2; i2 < size; i2++) {
                    if (arrayList.get(i).get(i2) != null) {
                        basicECUInfoBean.setValue(basicECUInfoBean.getValue() + arrayList.get(i).get(i2));
                    }
                }
                arrayList2.add(basicECUInfoBean);
            }
        }
        return arrayList2;
    }

    private ArrayList<BasicDataStreamBean> getDataStreamFromSF(ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<BasicDataStreamBean> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).size() >= 3) {
                BasicDataStreamBean basicDataStreamBean = new BasicDataStreamBean();
                if (arrayList.get(i).get(0) != null) {
                    basicDataStreamBean.setTitle(arrayList.get(i).get(0).getTitle());
                } else {
                    basicDataStreamBean.setTitle(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                basicDataStreamBean.setId(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (arrayList.get(i).get(1) != null) {
                    basicDataStreamBean.setValue(arrayList.get(i).get(1).getTitle());
                } else {
                    basicDataStreamBean.setValue(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                if (arrayList.get(i).get(2) != null) {
                    basicDataStreamBean.setUnit(arrayList.get(i).get(2).getTitle());
                } else {
                    basicDataStreamBean.setUnit(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                arrayList2.add(basicDataStreamBean);
            }
        }
        return arrayList2;
    }

    private ArrayList<BasicFaultCodeBean> getFaultColde(ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<BasicFaultCodeBean> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
            if (arrayList.get(i).size() >= 3) {
                if (arrayList.get(i).get(0) != null) {
                    basicFaultCodeBean.setTitle(arrayList.get(i).get(0).getTitle());
                    basicFaultCodeBean.setId(arrayList.get(i).get(0).getTitle());
                } else {
                    basicFaultCodeBean.setTitle(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    basicFaultCodeBean.setId(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                if (arrayList.get(i).get(1) != null) {
                    basicFaultCodeBean.setContext(arrayList.get(i).get(1).getTitle());
                } else {
                    basicFaultCodeBean.setContext(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                if (arrayList.get(i).get(2) != null) {
                    basicFaultCodeBean.setStatus(arrayList.get(i).get(2).getTitle());
                } else {
                    basicFaultCodeBean.setStatus(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                arrayList2.add(basicFaultCodeBean);
            }
        }
        return arrayList2;
    }

    public void startRecordProcess() {
        clearAllSystemData();
        setRecordState(true);
    }

    public void stopRecordProscess() {
        setRecordState(false);
    }

    private void setRecordState(boolean z) {
        this.IsRecordState = z;
    }

    public boolean IsRecordSampleDS() {
        return this.IsRecordSampleDSState;
    }

    private void setRecordSampleDSState(boolean z) {
        this.IsRecordSampleDSState = z;
    }

    public void startRecordSampleDataStream() {
        clearAllSampleDataStreamData();
        setRecordSampleDSState(true);
    }

    private BasicSampleDataStreamBean getSampleDataStreamByDataStream(String str, String str2, BasicDataStreamBean basicDataStreamBean) {
        if (basicDataStreamBean == null) {
            return null;
        }
        if (!TextUtils.isEmpty(basicDataStreamBean.getSrcUnit().trim()) || basicDataStreamBean.getSrcUnit().equals("   ")) {
            String id = basicDataStreamBean.getId();
            for (int i = 0; i < this.arSampleDataStreamData.size(); i++) {
                BasicSampleDataStreamBean basicSampleDataStreamBean = this.arSampleDataStreamData.get(i);
                if (!TextUtils.isEmpty(id)) {
                    if (basicSampleDataStreamBean.getParentID().equals(str) && basicSampleDataStreamBean.getId().equals(id)) {
                        return basicSampleDataStreamBean;
                    }
                } else if (basicSampleDataStreamBean.getParentID().equals(str) && basicSampleDataStreamBean.getTitle().equals(basicDataStreamBean.getTitle()) && basicSampleDataStreamBean.getSrcUnit().equals(basicDataStreamBean.getSrcUnit())) {
                    return basicSampleDataStreamBean;
                }
            }
            BasicSampleDataStreamBean basicSampleDataStreamBean2 = new BasicSampleDataStreamBean();
            basicSampleDataStreamBean2.setId(id);
            basicSampleDataStreamBean2.setParentID(str);
            basicSampleDataStreamBean2.setParentTitle(str2);
            basicSampleDataStreamBean2.setTitle(basicDataStreamBean.getTitle());
            basicSampleDataStreamBean2.setUnit(basicDataStreamBean.getSrcUnit());
            try {
                basicSampleDataStreamBean2.setLeast_value(Double.valueOf(basicDataStreamBean.getSrcValue()).doubleValue());
                basicSampleDataStreamBean2.setMaximal_value(Double.valueOf(basicDataStreamBean.getSrcValue()).doubleValue());
            } catch (Exception unused) {
                basicSampleDataStreamBean2.setLeast_value(Double.NaN);
                basicSampleDataStreamBean2.setMaximal_value(Double.NaN);
            }
            this.arSampleDataStreamData.add(basicSampleDataStreamBean2);
            return basicSampleDataStreamBean2;
        }
        return null;
    }

    public void addDataSubItemStreamBean2Sample(String str, String str2, ArrayList<BasicDataStreamBean> arrayList) {
        if (this.IsRecordSampleDSState && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < arrayList.size(); i++) {
                if ((!TextUtils.isEmpty(arrayList.get(i).getId()) || !DiagnoseConstants.DATASTREAM_HAVE_ID) && !TextUtils.isEmpty(arrayList.get(i).getSrcUnit())) {
                    try {
                        double doubleValue = Double.valueOf(arrayList.get(i).getSrcValue()).doubleValue();
                        BasicSampleDataStreamBean sampleDataStreamByDataStream = getSampleDataStreamByDataStream(str, str2, arrayList.get(i));
                        if (Double.isNaN(sampleDataStreamByDataStream.getLeast_value()) || sampleDataStreamByDataStream.getLeast_value() > doubleValue) {
                            sampleDataStreamByDataStream.setLeast_value(doubleValue);
                        }
                        if (Double.isNaN(sampleDataStreamByDataStream.getMaximal_value()) || sampleDataStreamByDataStream.getMaximal_value() < doubleValue) {
                            sampleDataStreamByDataStream.setMaximal_value(doubleValue);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void addDataStreamBean2Sample(ArrayList<BasicDataStreamBean> arrayList) {
        if (this.IsRecordSampleDSState) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) instanceof BasicDataStreamWithSubItemBean) {
                    addDataSubItemStreamBean2Sample(arrayList.get(i).getId(), arrayList.get(i).getTitle(), ((BasicDataStreamWithSubItemBean) arrayList.get(i)).getArrSubItemDataStream());
                } else if ((!TextUtils.isEmpty(arrayList.get(i).getId()) || !DiagnoseConstants.DATASTREAM_HAVE_ID) && !TextUtils.isEmpty(arrayList.get(i).getSrcUnit())) {
                    try {
                        double doubleValue = Double.valueOf(arrayList.get(i).getSrcValue()).doubleValue();
                        BasicSampleDataStreamBean sampleDataStreamByDataStream = getSampleDataStreamByDataStream("", "", arrayList.get(i));
                        if (Double.isNaN(sampleDataStreamByDataStream.getLeast_value()) || sampleDataStreamByDataStream.getLeast_value() > doubleValue) {
                            sampleDataStreamByDataStream.setLeast_value(doubleValue);
                        }
                        if (Double.isNaN(sampleDataStreamByDataStream.getMaximal_value()) || sampleDataStreamByDataStream.getMaximal_value() < doubleValue) {
                            sampleDataStreamByDataStream.setMaximal_value(doubleValue);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void stopRecordSampleDS() {
        setRecordSampleDSState(false);
    }
}
