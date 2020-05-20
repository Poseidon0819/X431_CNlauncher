package com.cnlaunch.diagnosemodule.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MeasureObject implements Serializable {
    private static final long serialVersionUID = -3133106973062599745L;
    private ArrayList<Double> listRatioForChangeUnit;
    private ArrayList<String> listUnitForChangeUnit;
    private double ratio;
    private String type;
    private String unit;

    public String getUnit() {
        return this.unit;
    }

    public String getUnit(int i) {
        return this.listUnitForChangeUnit.get(i);
    }

    public ArrayList<String> getListUnitForChangeUnit() {
        return this.listUnitForChangeUnit;
    }

    public MeasureObject(String str, double d) {
        this.type = "0";
        this.ratio = 1.0d;
        this.unit = str;
        this.type = "0";
        this.ratio = d;
    }

    public MeasureObject(String[] strArr, double... dArr) {
        this.type = "0";
        this.ratio = 1.0d;
        this.listUnitForChangeUnit = new ArrayList<>();
        this.listRatioForChangeUnit = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            this.listUnitForChangeUnit.add(strArr[i]);
            this.listRatioForChangeUnit.add(Double.valueOf(dArr[i]));
        }
        this.type = "0";
    }

    public MeasureObject(String str, String str2) {
        this.type = "0";
        this.ratio = 1.0d;
        this.unit = str;
        this.type = str2;
    }

    public double toValue(String str) {
        return toValue(str, 4);
    }

    public double toValue(String str, int i) {
        if (this.type.equals("0")) {
            return new BigDecimal(Double.parseDouble(str) * this.ratio).setScale(i, 4).doubleValue();
        }
        if (this.type.equals("2")) {
            return new BigDecimal(((Double.parseDouble(str) - 32.0d) * 5.0d) / 9.0d).setScale(2, 4).doubleValue();
        }
        if (this.type.equals("1")) {
            return new BigDecimal((Double.parseDouble(str) * 1.8d) + 32.0d).setScale(2, 4).doubleValue();
        }
        throw new NumberFormatException();
    }

    public double toValueForChangeUnit(String str, int i) {
        if (this.type.equals("0")) {
            return new BigDecimal(Double.parseDouble(str) * this.listRatioForChangeUnit.get(i).doubleValue()).setScale(4, 4).doubleValue();
        }
        throw new NumberFormatException();
    }

    public double toValue(double d) {
        if (this.type.equals("0")) {
            return new BigDecimal(d * this.ratio).setScale(2, 4).doubleValue();
        }
        if (this.type.equals("2")) {
            return new BigDecimal(((d - 32.0d) * 5.0d) / 9.0d).setScale(2, 4).doubleValue();
        }
        if (this.type.equals("1")) {
            return new BigDecimal((d * 1.8d) + 32.0d).setScale(2, 4).doubleValue();
        }
        throw new NumberFormatException();
    }

    public double toValue(double d, int i) {
        if (this.type.equals("0")) {
            return new BigDecimal(d * this.listRatioForChangeUnit.get(i).doubleValue()).setScale(2, 4).doubleValue();
        }
        throw new NumberFormatException();
    }
}
