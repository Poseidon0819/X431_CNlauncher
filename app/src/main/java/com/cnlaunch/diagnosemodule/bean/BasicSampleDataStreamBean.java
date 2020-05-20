package com.cnlaunch.diagnosemodule.bean;

import com.cnlaunch.diagnosemodule.utils.MeasureConversionBean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BasicSampleDataStreamBean extends BasicDataStreamBean {
    double least_value;
    double maximal_value;
    String dataVersion = "1";
    boolean hadBadValue = false;
    private String parentTitle = "";
    private String parentID = "";
    ArrayList<Double> dbLeastForMetric = new ArrayList<>();
    ArrayList<Double> dbMaximalForMetric = new ArrayList<>();
    ArrayList<Double> dbLeastForImperial = new ArrayList<>();
    ArrayList<Double> dbMaximalForImperial = new ArrayList<>();
    Double[] dbLeastValue = new Double[2];
    Double[] dbMaximalValue = new Double[2];

    public String getParentID() {
        return this.parentID;
    }

    public void setParentID(String str) {
        this.parentID = str;
    }

    public String getParentTitle() {
        return this.parentTitle;
    }

    public void setParentTitle(String str) {
        this.parentTitle = str;
    }

    public void setHadBadValue(boolean z) {
        this.hadBadValue = z;
    }

    public boolean getHadBadValue() {
        return this.hadBadValue;
    }

    public void setDataVersion(String str) {
        this.dataVersion = str;
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public void setLeast_value(double d) {
        this.least_value = d;
    }

    public double getLeast_value() {
        return getAfter2Point(this.least_value);
    }

    private double getAfter2Point(double d) {
        if (Double.isNaN(d)) {
            return Double.NaN;
        }
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }

    public void setMaximal_value(double d) {
        this.maximal_value = d;
    }

    public double getMaximal_value() {
        return getAfter2Point(this.maximal_value);
    }

    private int getChangUnitPos() {
        HashMap hashMap = new HashMap();
        hashMap.put(this.f7269id, Integer.valueOf(currconversionType));
        if (mapDataStreamID2ChoiceUnit.size() == 0) {
            return 0;
        }
        return mapDataStreamID2ChoiceUnit.get(hashMap).intValue();
    }

    public Double getDbLeastValue() {
        if (this.canChangeUnit[currconversionType]) {
            try {
                int changUnitPos = getChangUnitPos();
                if (currconversionType == 1) {
                    return this.dbLeastForImperial.get(changUnitPos);
                }
                return this.dbLeastForMetric.get(changUnitPos);
            } catch (Exception unused) {
                if (currconversionType == 1) {
                    return this.dbLeastForImperial.get(0);
                }
                return this.dbLeastForMetric.get(0);
            }
        } else if (currconversionType < 2) {
            return this.dbLeastValue[currconversionType];
        } else {
            return Double.valueOf(this.least_value);
        }
    }

    public Double getDbLeastValueByUnit(String str) {
        if (this.canChangeUnit[currconversionType]) {
            try {
                int changUnitPos = getChangUnitPos();
                if (currconversionType == 1) {
                    return this.dbLeastForImperial.get(changUnitPos);
                }
                return this.dbLeastForMetric.get(changUnitPos);
            } catch (Exception unused) {
                if (currconversionType == 1) {
                    return this.dbLeastForImperial.get(0);
                }
                return this.dbLeastForMetric.get(0);
            }
        } else if (currconversionType < 2) {
            return this.dbLeastValue[currconversionType];
        } else {
            return Double.valueOf(this.least_value);
        }
    }

    public Double getDbMaximalValue() {
        if (this.canChangeUnit[currconversionType]) {
            try {
                int changUnitPos = getChangUnitPos();
                if (currconversionType == 1) {
                    return this.dbMaximalForImperial.get(changUnitPos);
                }
                return this.dbMaximalForMetric.get(changUnitPos);
            } catch (Exception unused) {
                if (currconversionType == 1) {
                    return this.dbMaximalForImperial.get(0);
                }
                return this.dbMaximalForMetric.get(0);
            }
        } else if (currconversionType < 2) {
            return this.dbMaximalValue[currconversionType];
        } else {
            return Double.valueOf(this.maximal_value);
        }
    }

    public void setConversionLeastValueInit(Double d, int i) {
        if (!this.canChangeUnit[i]) {
            this.dbLeastValue[i] = d;
        } else if (i == 0) {
            this.dbLeastForMetric.add(d);
        } else {
            this.dbLeastForImperial.add(d);
        }
    }

    public void setConversionLeastValue(Double d, int i) {
        if (this.canChangeUnit[i]) {
            int changUnitPos = getChangUnitPos();
            if (i == 0) {
                this.dbLeastForMetric.set(changUnitPos, d);
                return;
            } else {
                this.dbLeastForImperial.set(changUnitPos, d);
                return;
            }
        }
        this.dbLeastValue[i] = d;
    }

    public void setConversionMaximalValue(Double d, int i) {
        if (this.canChangeUnit[i]) {
            int changUnitPos = getChangUnitPos();
            if (i == 0) {
                this.dbMaximalForMetric.set(changUnitPos, d);
                return;
            } else {
                this.dbMaximalForImperial.set(changUnitPos, d);
                return;
            }
        }
        this.dbMaximalValue[i] = d;
    }

    public void setConversionMaximalValueInit(Double d, int i) {
        if (!this.canChangeUnit[i]) {
            this.dbMaximalValue[i] = d;
        } else if (i == 0) {
            this.dbMaximalForMetric.add(d);
        } else {
            this.dbMaximalForImperial.add(d);
        }
    }

    @Override // com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean
    public void doConversion() {
        MeasureConversionBean.convertSampleDataImperialToMetric(this);
        MeasureConversionBean.convertSampleDataMetricToImperial(this);
    }
}
