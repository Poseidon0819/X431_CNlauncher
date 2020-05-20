package com.cnlaunch.diagnosemodule.bean;

import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.JsonConstText;
import com.cnlaunch.diagnosemodule.utils.MeasureConversionBean;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BasicDataStreamBean extends BasicBean {
    private static final long serialVersionUID = 8999573854089107801L;
    ArrayList<String> arrImperial;
    ArrayList<String> arrMetric;
    boolean bGrapValidDataFor94Type;
    boolean bHaveHelpFor94Type;
    boolean[] canChangeUnit;
    private int conversionType;
    Double[] dbValue;
    ArrayList<Double> dbValueForImperial;
    ArrayList<Double> dbValueForMetric;
    String[] dosStandardValue;
    ArrayList<String> dosStandardValueForImperial;
    ArrayList<String> dosStandardValueForMetric;
    String[] dosUnit;
    ArrayList<String> dosUnitForImperial;
    ArrayList<String> dosUnitForMetric;
    String[] dosValue;
    ArrayList<String> dosValueForImperial;
    ArrayList<String> dosValueForMetric;
    String help;

    /* renamed from: id */
    String f7269id;

    /* renamed from: sn */
    private int f7270sn;
    String standardvalue;
    String time;
    String title;
    String translation_title;
    String unit;
    String value;
    String valuestatus;
    public static HashMap<HashMap<String, Integer>, Integer> mapDataStreamID2ChoiceUnit = new HashMap<>();
    private static Map<String, String> mapHelpId2Value = new LinkedHashMap();
    public static int currconversionType = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;

    public void setHelp(String str) {
    }

    public int getSn() {
        return this.f7270sn;
    }

    public void setSn(int i) {
        this.f7270sn = i;
    }

    public boolean isbHaveHelpFor94Type() {
        return this.bHaveHelpFor94Type;
    }

    public void setbHaveHelpFor94Type(boolean z) {
        this.bHaveHelpFor94Type = z;
    }

    public static void clearMapDataStreamID2ChoicePos() {
        mapDataStreamID2ChoiceUnit.clear();
    }

    public boolean isCanChangeUnit() {
        return this.canChangeUnit[currconversionType];
    }

    public ArrayList<String> getUnitList() {
        boolean[] zArr = this.canChangeUnit;
        int i = currconversionType;
        if (zArr[i]) {
            if (i == 1) {
                return getArrImperial();
            }
            return getArrMetric();
        }
        return null;
    }

    public void setCanChangeUnit(boolean z, int i) {
        this.canChangeUnit[i] = z;
        if (z) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put(this.f7269id, Integer.valueOf(i));
            if (mapDataStreamID2ChoiceUnit.containsKey(hashMap)) {
                return;
            }
            mapDataStreamID2ChoiceUnit.put(hashMap, 0);
        }
    }

    public ArrayList<String> getArrImperial() {
        return this.arrImperial;
    }

    public void setArrImperial(ArrayList<String> arrayList) {
        this.arrImperial = arrayList;
        this.dosUnitForImperial = arrayList;
    }

    public ArrayList<String> getArrMetric() {
        return this.arrMetric;
    }

    public void setArrMetric(ArrayList<String> arrayList) {
        this.arrMetric = arrayList;
        this.dosUnitForMetric = arrayList;
    }

    public boolean isbGrapValidDataFor94Type() {
        return this.bGrapValidDataFor94Type;
    }

    public void setbGrapValidDataFor94Type(boolean z) {
        this.bGrapValidDataFor94Type = z;
    }

    public void setConversionStandardValue(String str, int i) {
        if (!this.canChangeUnit[i]) {
            this.dosStandardValue[i] = str;
        } else if (i == 0) {
            this.dosStandardValueForMetric.add(str);
        } else {
            this.dosStandardValueForImperial.add(str);
        }
    }

    private int getChangeUnitPos() {
        HashMap hashMap = new HashMap();
        hashMap.put(this.f7269id, Integer.valueOf(currconversionType));
        if (mapDataStreamID2ChoiceUnit.size() == 0) {
            return 0;
        }
        return mapDataStreamID2ChoiceUnit.get(hashMap).intValue();
    }

    public String getStandardvalue() {
        boolean[] zArr = this.canChangeUnit;
        int i = currconversionType;
        if (zArr[i]) {
            int changeUnitPos = getChangeUnitPos();
            if (currconversionType == 1) {
                return this.dosStandardValueForImperial.get(changeUnitPos);
            }
            return this.dosStandardValueForMetric.get(changeUnitPos);
        } else if (i < 2) {
            return this.dosStandardValue[i];
        } else {
            int i2 = this.conversionType;
            if (i2 < 2) {
                return this.dosStandardValue[i2];
            }
            return this.standardvalue;
        }
    }

    public String getTime() {
        return this.time;
    }

    public void SetTime(String str) {
        this.time = str;
    }

    public String getSrcStandardValue() {
        return this.standardvalue;
    }

    public static void clearHelpMapInfo() {
        mapHelpId2Value.clear();
    }

    public BasicDataStreamBean() {
        this.f7269id = "";
        this.dosValue = new String[2];
        this.dosUnit = new String[2];
        this.dbValue = new Double[2];
        this.dosStandardValue = new String[2];
        this.bGrapValidDataFor94Type = false;
        this.bHaveHelpFor94Type = false;
        this.canChangeUnit = new boolean[2];
        this.arrImperial = new ArrayList<>();
        this.arrMetric = new ArrayList<>();
        this.dosValueForImperial = new ArrayList<>();
        this.dosUnitForImperial = new ArrayList<>();
        this.dbValueForImperial = new ArrayList<>();
        this.dosStandardValueForImperial = new ArrayList<>();
        this.dosValueForMetric = new ArrayList<>();
        this.dosUnitForMetric = new ArrayList<>();
        this.dbValueForMetric = new ArrayList<>();
        this.dosStandardValueForMetric = new ArrayList<>();
        this.conversionType = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
    }

    private void addHelpMapInfo(String str, String str2) {
        if (mapHelpId2Value.containsKey(str)) {
            return;
        }
        mapHelpId2Value.put(str, str2);
    }

    public BasicDataStreamBean(JSONObject jSONObject) {
        this.f7269id = "";
        this.dosValue = new String[2];
        this.dosUnit = new String[2];
        this.dbValue = new Double[2];
        this.dosStandardValue = new String[2];
        this.bGrapValidDataFor94Type = false;
        this.bHaveHelpFor94Type = false;
        this.canChangeUnit = new boolean[2];
        this.arrImperial = new ArrayList<>();
        this.arrMetric = new ArrayList<>();
        this.dosValueForImperial = new ArrayList<>();
        this.dosUnitForImperial = new ArrayList<>();
        this.dbValueForImperial = new ArrayList<>();
        this.dosStandardValueForImperial = new ArrayList<>();
        this.dosValueForMetric = new ArrayList<>();
        this.dosUnitForMetric = new ArrayList<>();
        this.dbValueForMetric = new ArrayList<>();
        this.dosStandardValueForMetric = new ArrayList<>();
        this.conversionType = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        try {
            setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            setValue(jSONObject.getString(JsonConstText.Const_Text_Value));
            setUnit(jSONObject.getString(JsonConstText.Const_Text_Unit));
            if (jSONObject.has(JsonConstText.Const_Text_Item)) {
                setSn(jSONObject.getInt(JsonConstText.Const_Text_Item));
            }
            if (jSONObject.has(JsonConstText.Const_Text_Id)) {
                setId(jSONObject.getString(JsonConstText.Const_Text_Id));
                if (jSONObject.has(JsonConstText.Const_Text_Help)) {
                    addHelpMapInfo(jSONObject.getString(JsonConstText.Const_Text_Id), jSONObject.getString(JsonConstText.Const_Text_Help));
                } else {
                    addHelpMapInfo(jSONObject.getString(JsonConstText.Const_Text_Id), "");
                }
            } else {
                setId("");
            }
            if (jSONObject.has(JsonConstText.Const_Text_Valuestatus)) {
                setValuestatus(jSONObject.getString(JsonConstText.Const_Text_Valuestatus));
            } else {
                setValuestatus("");
            }
            if (jSONObject.has(JsonConstText.Const_Text_Standardvalue)) {
                setStandardvalue(jSONObject.getString(JsonConstText.Const_Text_Standardvalue));
            } else {
                setStandardvalue("");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return this.f7269id;
    }

    public void setId(String str) {
        this.f7269id = str;
    }

    public void setStandardvalue(String str) {
        this.standardvalue = str;
    }

    public String getValuestatus() {
        return this.valuestatus;
    }

    public void setValuestatus(String str) {
        this.valuestatus = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTranslation_title() {
        return this.translation_title;
    }

    public void setTranslation_title(String str) {
        this.translation_title = str;
    }

    public Double getDbValue() {
        boolean[] zArr = this.canChangeUnit;
        int i = currconversionType;
        if (zArr[i]) {
            int changeUnitPos = getChangeUnitPos();
            if (currconversionType == 1) {
                return this.dbValueForImperial.get(changeUnitPos);
            }
            return this.dbValueForMetric.get(changeUnitPos);
        } else if (i < 2) {
            return this.dbValue[i];
        } else {
            int i2 = this.conversionType;
            if (i2 < 2) {
                return this.dbValue[i2];
            }
            return Double.valueOf(Double.NaN);
        }
    }

    public String getValue() {
        boolean[] zArr = this.canChangeUnit;
        int i = currconversionType;
        if (zArr[i]) {
            int changeUnitPos = getChangeUnitPos();
            if (currconversionType == 1) {
                return this.dosValueForImperial.get(changeUnitPos);
            }
            return this.dosValueForMetric.get(changeUnitPos);
        } else if (i < 2) {
            return this.dosValue[i];
        } else {
            int i2 = this.conversionType;
            if (i2 < 2) {
                return this.dosValue[i2];
            }
            return this.value;
        }
    }

    public String getSrcValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getValueByType(int i) {
        if (i < 2) {
            return this.dosValue[i];
        }
        return this.value;
    }

    public String getUnitByType(int i) {
        if (i < 2) {
            return this.dosUnit[i];
        }
        return this.unit;
    }

    public void setConversionDoubleValue(Double d, int i) {
        if (!this.canChangeUnit[i]) {
            this.dbValue[i] = d;
        } else if (i == 0) {
            this.dbValueForMetric.add(d);
        } else {
            this.dbValueForImperial.add(d);
        }
    }

    public void setConversionValue(String str, int i) {
        if (!this.canChangeUnit[i]) {
            this.dosValue[i] = str;
        } else if (i == 0) {
            this.dosValueForMetric.add(str);
        } else {
            this.dosValueForImperial.add(str);
        }
    }

    public void setConversionUnit(String str, int i) {
        if (!this.canChangeUnit[i]) {
            this.dosUnit[i] = str;
        } else if (i == 0) {
            this.dosUnitForMetric.add(str);
        } else {
            this.dosUnitForImperial.add(str);
        }
    }

    public String getUnit() {
        boolean[] zArr = this.canChangeUnit;
        int i = currconversionType;
        if (zArr[i]) {
            int changeUnitPos = getChangeUnitPos();
            if (currconversionType == 1) {
                return this.dosUnitForImperial.get(changeUnitPos);
            }
            return this.dosUnitForMetric.get(changeUnitPos);
        } else if (i < 2) {
            return this.dosUnit[i];
        } else {
            int i2 = this.conversionType;
            if (i2 < 2) {
                return this.dosUnit[i2];
            }
            return this.unit;
        }
    }

    public String getSrcUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = MeasureConversionBean.changeSomeLongUnit(str);
    }

    public String getHelp() {
        return (!TextUtils.isEmpty(this.f7269id) && mapHelpId2Value.containsKey(this.f7269id)) ? mapHelpId2Value.get(this.f7269id) : "";
    }

    public boolean equalsByIDAndTitle(Object obj) {
        try {
            if ((obj instanceof BasicDataStreamBean) && this.f7269id.equals(((BasicDataStreamBean) obj).getId()) && this.title.equals(((BasicDataStreamBean) obj).getTitle())) {
                return this.unit.equals(((BasicDataStreamBean) obj).getSrcUnit());
            }
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if ((obj instanceof BasicDataStreamBean) && ((BasicDataStreamBean) obj).getId() != null && this.f7269id != null && this.f7269id.equals(((BasicDataStreamBean) obj).getId()) && ((BasicDataStreamBean) obj).getTitle() != null && this.title != null && this.title.equals(((BasicDataStreamBean) obj).getTitle()) && ((BasicDataStreamBean) obj).getSrcValue() != null && this.value != null && this.value.equals(((BasicDataStreamBean) obj).getSrcValue()) && ((BasicDataStreamBean) obj).getSrcUnit() != null && this.unit != null && this.unit.equals(((BasicDataStreamBean) obj).getSrcUnit()) && ((BasicDataStreamBean) obj).getHelp() != null && this.help != null && this.help.equals(((BasicDataStreamBean) obj).getHelp()) && ((BasicDataStreamBean) obj).getStandardvalue() != null && this.standardvalue != null && this.standardvalue.equals(((BasicDataStreamBean) obj).getStandardvalue()) && ((BasicDataStreamBean) obj).getValuestatus() != null && this.valuestatus != null) {
                if (this.valuestatus.equals(((BasicDataStreamBean) obj).getValuestatus())) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setConversion(int i) {
        this.conversionType = i;
    }

    public void doConversion() {
        MeasureConversionBean.convertImperialToMetric(this);
        MeasureConversionBean.convertMetricToImperial(this);
    }
}
