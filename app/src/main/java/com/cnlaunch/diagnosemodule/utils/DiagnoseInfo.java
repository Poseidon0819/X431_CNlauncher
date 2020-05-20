package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.listener.IGetVehiclesInfoCallBack;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DiagnoseInfo {
    public static DiagnoseInfo instance;
    private int FT_SYSSCAN = 1;
    private int FT_QUICKTEST = 2;
    private int FT_VERINFO = 4;
    private int FT_RDS = 7;
    private int STA_START = 7;
    private int STA_FEND = 8;
    private int STA_SUCCESS = 6;
    private int STA_FAILED = 5;
    private int STA_UNSORT = 9;
    private int FT_SWPID = 23;
    private int FT_SRSCAN = 24;
    private int FT_SRCDTC = 25;
    private int FT_SYSREP = 26;
    private int FT_INPUT_VIN = 43;
    private int FT_HEXINPUT = 44;
    private int FT_CODEUND = 45;
    private int FT_DEFITEM = 46;
    private int FT_ADASRES = 47;
    private int FT_OBDIM = 48;
    private int FT_PROTOCAL = 52;
    private int FT_GWMSET = 54;
    private String FunctionName = "";
    private int FunctionType = 0;
    private int FunctionStatus = 0;
    private ArrayList<FuncItem> funcList = new ArrayList<>();
    private String Make = "";
    private String Model = "";
    private String SubMoel = "";
    private String Engine = "";
    private String Year = "";
    private String Vin = "";
    private String SysId = "";
    private String SysNameID = "";
    private String SystemUID = "";
    private String SysNum = "";
    private String DsItem = "";
    private String AtItem = "";
    private String VehInfo = "";
    private String MenuPath = "";
    private String EnableRecord = "";
    private String AtResult = "";
    private IGetVehiclesInfoCallBack iGetVehiclesInfoCallBack = null;

    /* loaded from: classes.dex */
    public class FuncItem {
        public String funcName;
        public int funcStatus;
        public int funcType;
        public String path;

        FuncItem(String str, int i, int i2, String str2) {
            this.funcName = str;
            this.funcType = i;
            this.funcStatus = i2;
            this.path = str2;
        }
    }

    public void setFunInfo(Context context, String str, JSONObject jSONObject) throws JSONException {
        try {
            String string = jSONObject.getString("funnameid");
            int i = jSONObject.getInt("funtype");
            int i2 = jSONObject.getInt("funstatus");
            setFunctionName(string);
            setFunctionType(i);
            setFunctionStatus(i2);
            Log.e("bcf", "functionName: " + string + "  functionType: " + i + "  functionStatus: " + i2);
            if (i != this.FT_CODEUND || i != this.FT_DEFITEM) {
                this.funcList.add(new FuncItem(string, i, i2, DiagnoseConstants.DIAGNOSE_CURRENT_PATH));
            }
            if (i2 == this.STA_START && (i == this.FT_QUICKTEST || i == this.FT_SYSSCAN)) {
                Log.i("haizhi", "全车扫描开始");
            }
            if (i2 == this.STA_FEND && (i == this.FT_QUICKTEST || i == this.FT_SYSSCAN)) {
                Log.i("haizhi", "全车扫描结束");
            }
            if (i == this.FT_ADASRES) {
                string.substring(1).split("@");
            } else if (i == this.FT_CODEUND) {
                if (i2 == this.STA_START) {
                    DiagnoseConstants.STR_DiagUndefineDTC = string;
                } else {
                    DiagnoseConstants.STR_DiagUndefineDTC = "";
                }
            } else if (i == this.FT_DEFITEM) {
                if (i2 == this.STA_START) {
                    DiagnoseConstants.MulitInputSelection = Integer.valueOf(string).intValue();
                } else {
                    DiagnoseConstants.MulitInputSelection = 0;
                }
            } else if (i == this.FT_OBDIM) {
                if (i2 == this.STA_START) {
                    DiagnoseConstants.IS_IMDATA_DIAG_SET = true;
                } else {
                    DiagnoseConstants.IS_IMDATA_DIAG_SET = false;
                }
            }
            if (i2 == this.STA_UNSORT) {
                DiagnoseConstants.IS_SORT = false;
            } else {
                DiagnoseConstants.IS_SORT = true;
            }
            if (i == this.FT_HEXINPUT) {
                if (i2 == this.STA_START) {
                    DiagnoseConstants.isDiagInputHEX = true;
                } else if (this.STA_FEND == i2) {
                    DiagnoseConstants.isDiagInputHEX = false;
                }
            } else if (i == this.FT_INPUT_VIN) {
                if (i2 == this.STA_START) {
                    DiagnoseConstants.isDiagInputVIN = true;
                } else if (this.STA_FEND == i2) {
                    DiagnoseConstants.isDiagInputVIN = false;
                }
            } else if (i == 22) {
                DiagnoseConstants.STA_DIAGMODE = i2;
            } else if (i == 20) {
                DiagnoseConstants.DIAG_ODO_DATA = string;
                if (this.iGetVehiclesInfoCallBack != null) {
                    this.iGetVehiclesInfoCallBack.setODOData(DiagnoseConstants.DIAG_ODO_DATA);
                    return;
                }
                Intent intent = new Intent("GET_OTO");
                intent.putExtra("OTO", DiagnoseConstants.DIAG_ODO_DATA);
                context.sendBroadcast(intent);
            } else if (i == 21) {
                DiagnoseConstants.DIAG_SHOW_DATA_STREAM_TYPE = i2;
            } else {
                if (i != 19 && i != 5) {
                    if (i == this.FT_VERINFO) {
                        if (i2 == this.STA_START) {
                            DiagnoseConstants.IS_RECORD_VERINFO = true;
                            DiagnoseConstants.IS_Need_RECORD = true;
                            return;
                        } else if (i2 == this.STA_FEND) {
                            DiagnoseConstants.IS_RECORD_VERINFO = false;
                            return;
                        } else {
                            return;
                        }
                    } else if (i == this.FT_RDS) {
                        if (i2 != this.STA_START && i2 != this.STA_UNSORT) {
                            if (i2 == this.STA_FEND) {
                                DiagnoseConstants.IS_RECORD_DATASTREAM = false;
                                return;
                            }
                            return;
                        }
                        DiagnoseConstants.IS_RECORD_DATASTREAM = true;
                        DiagnoseConstants.IS_Need_RECORD = true;
                        return;
                    } else if (i == this.FT_SWPID) {
                        DiagnoseConstants.SWPID_SOFT_ID = string;
                        return;
                    } else {
                        if (i != this.FT_SRSCAN && i != this.FT_SRCDTC) {
                            if (i == this.FT_PROTOCAL) {
                                DiagnoseConstants.obdCheckProtocal = string;
                                return;
                            } else if (this.FT_GWMSET == i) {
                                if (i2 == this.STA_START) {
                                    DiagnoseConstants.IS_FT_GWMSET = true;
                                    return;
                                } else if (i2 == this.STA_FEND) {
                                    DiagnoseConstants.IS_FT_GWMSET = false;
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (i2 == this.STA_START) {
                            DiagnoseConstants.IS_SYS_QUICKTEST_SHOW_PROCESS = true;
                            return;
                        } else if (i2 == this.STA_FEND) {
                            DiagnoseConstants.IS_SYS_QUICKTEST_SHOW_PROCESS = false;
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (i2 != 7 && i2 != 4) {
                    if (i2 == 8) {
                        DiagnoseConstants.SF_IS_SHOW_REPORT = false;
                        DiagnoseConstants.IS_SET_NO_DTC = false;
                        return;
                    }
                    return;
                }
                DiagnoseConstants.SF_IS_SHOW_REPORT = true;
                if (i2 == this.STA_START) {
                    DiagnoseConstants.IS_Need_RECORD = true;
                } else {
                    DiagnoseConstants.IS_SET_NO_DTC = true;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<FuncItem> getFuncRecord() {
        return this.funcList;
    }

    public void clearFunInfo() {
        setFunctionName("");
        setFunctionType(0);
        setFunctionStatus(0);
        this.funcList.clear();
    }

    public String getFunctionName() {
        return this.FunctionName;
    }

    public void setFunctionName(String str) {
        this.FunctionName = str;
    }

    public int getFunctionType() {
        return this.FunctionType;
    }

    public void setFunctionType(int i) {
        this.FunctionType = i;
    }

    public int getFunctionStatus() {
        return this.FunctionStatus;
    }

    public void setFunctionStatus(int i) {
        this.FunctionStatus = i;
    }

    public static DiagnoseInfo getInstance() {
        if (instance == null) {
            instance = new DiagnoseInfo();
        }
        return instance;
    }

    public void setiGetVehiclesInfoCallBack(IGetVehiclesInfoCallBack iGetVehiclesInfoCallBack) {
        this.iGetVehiclesInfoCallBack = iGetVehiclesInfoCallBack;
    }

    public void clear() {
        this.Make = "";
        this.Model = "";
        this.SubMoel = "";
        this.Engine = "";
        this.Year = "";
        this.Vin = "";
        this.SysId = "";
        this.SysNum = "";
        this.DsItem = "";
        this.AtItem = "";
        this.VehInfo = "";
        this.MenuPath = "";
        this.EnableRecord = "";
        this.AtResult = "";
        this.SysNameID = "";
        this.SystemUID = "";
        clearFunInfo();
        this.iGetVehiclesInfoCallBack = null;
    }

    public void setInfo(Context context, String str, JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("value");
        if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_VEHINFO)) {
            setVehInfo(string);
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_MENUPATH)) {
            setMenuPath(string);
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_VIN)) {
            setVin(string);
            IGetVehiclesInfoCallBack iGetVehiclesInfoCallBack = this.iGetVehiclesInfoCallBack;
            if (iGetVehiclesInfoCallBack != null) {
                iGetVehiclesInfoCallBack.setVin(string);
                return;
            }
            Intent intent = new Intent("SPT_SET_VIN");
            intent.putExtra("SPT_SET_VIN", string);
            context.sendBroadcast(intent);
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_YEAR)) {
            setYear(string);
            IGetVehiclesInfoCallBack iGetVehiclesInfoCallBack2 = this.iGetVehiclesInfoCallBack;
            if (iGetVehiclesInfoCallBack2 != null) {
                iGetVehiclesInfoCallBack2.setYear(string);
            }
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_ENGINE)) {
            setEngine(string);
            IGetVehiclesInfoCallBack iGetVehiclesInfoCallBack3 = this.iGetVehiclesInfoCallBack;
            if (iGetVehiclesInfoCallBack3 != null) {
                iGetVehiclesInfoCallBack3.setEngine(string);
            }
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_MODEL)) {
            setModel(string);
            IGetVehiclesInfoCallBack iGetVehiclesInfoCallBack4 = this.iGetVehiclesInfoCallBack;
            if (iGetVehiclesInfoCallBack4 != null) {
                iGetVehiclesInfoCallBack4.setModel(string);
            }
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_SUBMODEL)) {
            setSubMoel(string);
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_MAKE)) {
            setMake(string);
            IGetVehiclesInfoCallBack iGetVehiclesInfoCallBack5 = this.iGetVehiclesInfoCallBack;
            if (iGetVehiclesInfoCallBack5 != null) {
                iGetVehiclesInfoCallBack5.setMake(string);
            }
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_SYSID)) {
            setSysId(string);
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_ATITEM)) {
            setAtItem(string);
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_DSITEM)) {
            setDsItem(string);
        } else if (str.equals("1900")) {
            setEnableRecord(string);
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_AT_RESULT)) {
            setAtResult(string);
        }
    }

    public String getMake() {
        return this.Make;
    }

    public void setMake(String str) {
        this.Make = str;
    }

    public String getModel() {
        return this.Model;
    }

    public void setModel(String str) {
        this.Model = str;
    }

    public String getSubMoel() {
        return this.SubMoel;
    }

    public void setSubMoel(String str) {
        this.SubMoel = str;
    }

    public String getEngine() {
        return this.Engine;
    }

    public void setEngine(String str) {
        this.Engine = str;
    }

    public String getYear() {
        return this.Year;
    }

    public void setYear(String str) {
        this.Year = str;
    }

    public String getVin() {
        return this.Vin;
    }

    public void setVin(String str) {
        this.Vin = str;
    }

    public String getSystemUID() {
        return this.SystemUID;
    }

    public void setSystemUID(String str) {
        this.SystemUID = str;
    }

    public String getSysNameId() {
        return this.SysNameID;
    }

    public void setSysNameId(String str) {
        this.SysNameID = str;
    }

    public String getSysId() {
        return this.SysId;
    }

    public void setSysId(String str) {
        if (str.contains("{name=")) {
            String substring = str.substring(str.indexOf("{name=") + 6, str.indexOf("}"));
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            IGetVehiclesInfoCallBack iGetVehiclesInfoCallBack = this.iGetVehiclesInfoCallBack;
            if (iGetVehiclesInfoCallBack != null) {
                iGetVehiclesInfoCallBack.setSysName(substring);
            }
            this.SysId = substring;
            if (str.contains("{nameID=")) {
                setSysNameId(str.substring(str.indexOf("{nameID=") + 8, str.indexOf("}", str.indexOf("{nameID=") + 8)));
            }
            if (str.contains("{systemUID=")) {
                setSystemUID(str.substring(str.indexOf("{systemUID=") + 11, str.indexOf("}", str.indexOf("{systemUID=") + 11)));
            }
            DiagnoseProcessInfoUtil.getInstance().addSysBasicInf(this.SysId, getSysNameId(), getSystemUID());
            return;
        }
        this.SysId = str;
    }

    public String getSysNum() {
        return this.SysNum;
    }

    public void setSysNum(String str) {
        this.SysNum = str;
    }

    public String getDsItem() {
        return this.DsItem;
    }

    public void setDsItem(String str) {
        this.DsItem = str;
    }

    public String getAtItem() {
        return this.AtItem;
    }

    public void setAtItem(String str) {
        this.AtItem = str;
    }

    public String getVehInfo() {
        return this.VehInfo;
    }

    public void setVehInfo(String str) {
        this.VehInfo = str;
    }

    public String getMenuPath() {
        return this.MenuPath;
    }

    public void setMenuPath(String str) {
        this.MenuPath = str;
    }

    public String getEnableRecord() {
        return this.EnableRecord;
    }

    public void setEnableRecord(String str) {
        this.EnableRecord = str;
    }

    public String getAtResult() {
        return this.AtResult;
    }

    public void setAtResult(String str) {
        this.AtResult = str;
    }

    public String toString() {
        return "Make=" + this.Make + " Model=" + this.Model + " SubMoel=" + this.SubMoel + " Engine=" + this.Engine + " Year=" + this.Year + " Vin=" + this.Vin + " SysId=" + this.SysId + " SysNameID=" + this.SysNameID + " SysUUID=" + this.SystemUID + " SysNum=" + this.SysNum + " DsItem=" + this.DsItem + " AtItem=" + this.AtItem + " VehInfo=" + this.VehInfo + " MenuPath=" + this.MenuPath + " EnableRecord=" + this.EnableRecord + " AtResult=" + this.AtResult;
    }
}
