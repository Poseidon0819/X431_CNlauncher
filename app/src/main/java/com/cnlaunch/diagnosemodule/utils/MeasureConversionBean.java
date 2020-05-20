package com.cnlaunch.diagnosemodule.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicSampleDataStreamBean;
import com.cnlaunch.physics.PAD3DHCPForDoIP;
import com.itextpdf.text.html.HtmlTags;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class MeasureConversionBean {
    static DecimalFormat decimalFormat = new DecimalFormat("0.##");
    static boolean bSetAttTodecimalFormat = false;
    public static boolean bCanChangeUnit = false;
    public static HashMap<String, MeasureObject> ImperialMap = null;
    public static HashMap<String, MeasureObject> MetricMap = null;
    public static HashMap<String, MeasureObject> ImperialMapForChangeUnit = null;
    public static HashMap<String, MeasureObject> MetricMapForChangeUnit = null;
    static String[] splitChar = {"-", "~"};

    private static void setAttTodecimalFormat() {
        if (bSetAttTodecimalFormat) {
            return;
        }
        decimalFormat.setGroupingUsed(false);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        bSetAttTodecimalFormat = true;
    }

    public static void convertImperialToMetric(BasicDataStreamBean basicDataStreamBean) {
        setAttTodecimalFormat();
        String srcUnit = basicDataStreamBean.getSrcUnit();
        try {
            HashMap<String, MeasureObject> metricMap = getMetricMap();
            if (srcUnit != null) {
                String lowerCase = srcUnit.trim().toLowerCase(DiagnoseConstants.LOCAL_LANGUAGE);
                if (MetricMapForChangeUnit.containsKey(lowerCase) && !basicDataStreamBean.getId().equals("")) {
                    basicDataStreamBean.setCanChangeUnit(true, 0);
                    ArrayList<String> listUnitForChangeUnit = MetricMapForChangeUnit.get(lowerCase).getListUnitForChangeUnit();
                    basicDataStreamBean.setArrMetric(listUnitForChangeUnit);
                    for (int i = 0; i < listUnitForChangeUnit.size(); i++) {
                        MeasureObject measureObject = MetricMapForChangeUnit.get(lowerCase);
                        double valueForChangeUnit = measureObject.toValueForChangeUnit(basicDataStreamBean.getSrcValue(), i);
                        basicDataStreamBean.setConversionDoubleValue(Double.valueOf(valueForChangeUnit), 0);
                        basicDataStreamBean.setConversionValue(valueForChangeUnit == 0.0d ? "0" : decimalFormat.format(valueForChangeUnit), 0);
                        String srcStandardValue = basicDataStreamBean.getSrcStandardValue();
                        if (!TextUtils.isEmpty(srcStandardValue)) {
                            basicDataStreamBean.setConversionStandardValue(splitValueForChangeUnit(srcStandardValue, i, measureObject), 0);
                        } else {
                            basicDataStreamBean.setConversionStandardValue("", 0);
                        }
                    }
                    return;
                } else if (metricMap.containsKey(lowerCase)) {
                    double value = metricMap.get(lowerCase).toValue(basicDataStreamBean.getSrcValue());
                    basicDataStreamBean.setConversionDoubleValue(Double.valueOf(value), 0);
                    basicDataStreamBean.setConversionValue(value == 0.0d ? "0" : decimalFormat.format(value), 0);
                    basicDataStreamBean.setConversionUnit(metricMap.get(lowerCase).getUnit(), 0);
                    String srcStandardValue2 = basicDataStreamBean.getSrcStandardValue();
                    if (!TextUtils.isEmpty(srcStandardValue2)) {
                        basicDataStreamBean.setConversionStandardValue(splitValue(srcStandardValue2, lowerCase, metricMap), 0);
                        return;
                    } else {
                        basicDataStreamBean.setConversionStandardValue("", 0);
                        return;
                    }
                }
            }
        } catch (Exception unused) {
            basicDataStreamBean.setCanChangeUnit(false, 0);
        }
        try {
            basicDataStreamBean.setConversionDoubleValue(Double.valueOf(basicDataStreamBean.getSrcValue()), 0);
        } catch (Exception unused2) {
            basicDataStreamBean.setConversionDoubleValue(Double.valueOf(Double.NaN), 0);
        }
        basicDataStreamBean.setConversionUnit(basicDataStreamBean.getSrcUnit(), 0);
        basicDataStreamBean.setConversionValue(basicDataStreamBean.getSrcValue(), 0);
        basicDataStreamBean.setConversionStandardValue(basicDataStreamBean.getSrcStandardValue(), 0);
    }

    public static void convertMetricToImperial(BasicDataStreamBean basicDataStreamBean) {
        setAttTodecimalFormat();
        String srcUnit = basicDataStreamBean.getSrcUnit();
        try {
            HashMap<String, MeasureObject> imperialMap = getImperialMap();
            if (srcUnit != null && !srcUnit.equals("nm")) {
                String lowerCase = srcUnit.trim().toLowerCase(DiagnoseConstants.LOCAL_LANGUAGE);
                if (ImperialMapForChangeUnit.containsKey(lowerCase) && !basicDataStreamBean.getId().equals("")) {
                    basicDataStreamBean.setCanChangeUnit(true, 1);
                    ArrayList<String> listUnitForChangeUnit = ImperialMapForChangeUnit.get(lowerCase).getListUnitForChangeUnit();
                    basicDataStreamBean.setArrImperial(listUnitForChangeUnit);
                    for (int i = 0; i < listUnitForChangeUnit.size(); i++) {
                        MeasureObject measureObject = ImperialMapForChangeUnit.get(lowerCase);
                        double valueForChangeUnit = measureObject.toValueForChangeUnit(basicDataStreamBean.getSrcValue(), i);
                        basicDataStreamBean.setConversionDoubleValue(Double.valueOf(valueForChangeUnit), 1);
                        basicDataStreamBean.setConversionValue(valueForChangeUnit == 0.0d ? "0" : decimalFormat.format(valueForChangeUnit), 1);
                        String srcStandardValue = basicDataStreamBean.getSrcStandardValue();
                        if (!TextUtils.isEmpty(srcStandardValue)) {
                            basicDataStreamBean.setConversionStandardValue(splitValueForChangeUnit(srcStandardValue, i, measureObject), 1);
                        } else {
                            basicDataStreamBean.setConversionStandardValue("", 1);
                        }
                    }
                    return;
                } else if (imperialMap.containsKey(lowerCase)) {
                    double value = imperialMap.get(lowerCase).toValue(basicDataStreamBean.getSrcValue());
                    basicDataStreamBean.setConversionDoubleValue(Double.valueOf(value), 1);
                    basicDataStreamBean.setConversionValue(value == 0.0d ? "0" : decimalFormat.format(value), 1);
                    basicDataStreamBean.setConversionUnit(imperialMap.get(lowerCase).getUnit(), 1);
                    String srcStandardValue2 = basicDataStreamBean.getSrcStandardValue();
                    if (!TextUtils.isEmpty(srcStandardValue2)) {
                        basicDataStreamBean.setConversionStandardValue(splitValue(srcStandardValue2, lowerCase, imperialMap), 1);
                        return;
                    } else {
                        basicDataStreamBean.setConversionStandardValue("", 1);
                        return;
                    }
                }
            }
        } catch (Exception unused) {
            basicDataStreamBean.setCanChangeUnit(false, 1);
        }
        try {
            basicDataStreamBean.setConversionDoubleValue(Double.valueOf(basicDataStreamBean.getSrcValue()), 1);
        } catch (Exception unused2) {
            basicDataStreamBean.setConversionDoubleValue(Double.valueOf(Double.NaN), 1);
        }
        basicDataStreamBean.setConversionUnit(basicDataStreamBean.getSrcUnit(), 1);
        basicDataStreamBean.setConversionValue(basicDataStreamBean.getSrcValue(), 1);
        basicDataStreamBean.setConversionStandardValue(basicDataStreamBean.getSrcStandardValue(), 1);
    }

    public static String changeSomeLongUnit(String str) {
        return TextUtils.isEmpty(str) ? "" : (str.equals("英里每小时") || str.equals("英里/小时")) ? "英里/时" : (str.equals("千米每小时") || str.equals("千米/小时")) ? "千米/时" : str.equals("磅每平方英寸") ? "磅/(吋)²" : (str.equals("千克每小时") || str.equals("千克/小时")) ? "千克/时" : str;
    }

    public static HashMap<String, MeasureObject> getMetricMap() {
        getMetricMapForChangeUnit();
        if (MetricMap == null) {
            HashMap<String, MeasureObject> hashMap = new HashMap<>();
            MetricMap = hashMap;
            hashMap.put("磅", new MeasureObject("千克", 0.4535d));
            MetricMap.put("lb", new MeasureObject("kg", 0.4535d));
            MetricMap.put("英里", new MeasureObject("千米", 1.6093d));
            MetricMap.put("mile", new MeasureObject("km", 1.6093d));
            MetricMap.put("码", new MeasureObject("米", 0.9144d));
            MetricMap.put("yd", new MeasureObject("m", 0.9144d));
            MetricMap.put("英尺", new MeasureObject("分米", 3.0488d));
            MetricMap.put("ft", new MeasureObject("dm", 3.0488d));
            MetricMap.put("吋", new MeasureObject("毫米", 25.3807d));
            MetricMap.put("inch", new MeasureObject("mm", 25.3807d));
            MetricMap.put("平方英里", new MeasureObject("平方千米", 2.59d));
            MetricMap.put("mi^2", new MeasureObject("km^2", 2.59d));
            MetricMap.put("平方码", new MeasureObject("平方米", 0.8361d));
            MetricMap.put("sq yd", new MeasureObject("m^2", 0.8361d));
            MetricMap.put("平方英尺", new MeasureObject("平方分米", 9.2937d));
            MetricMap.put("sq ft", new MeasureObject("dm^2", 9.2937d));
            MetricMap.put("立方英里", new MeasureObject("立方千米", 4.1684d));
            MetricMap.put("mi^3", new MeasureObject("km^3", 4.1684d));
            MetricMap.put("立方码", new MeasureObject("立方米", 0.7645d));
            MetricMap.put("yd^3", new MeasureObject("m^3", 0.7645d));
            MetricMap.put("立方英尺", new MeasureObject("立方分米", 28.3286d));
            MetricMap.put("ft^3", new MeasureObject("dm^3", 28.3286d));
            MetricMap.put("立方英寸", new MeasureObject("立方厘米", 16.387d));
            MetricMap.put("in^3", new MeasureObject("cm^3", 16.387d));
            MetricMap.put("加仑", new MeasureObject("升", 4.5461d));
            MetricMap.put("gal.", new MeasureObject("L", 4.5461d));
            MetricMap.put("加仑(美制)", new MeasureObject("升", 3.7854d));
            MetricMap.put("加仑(英制)", new MeasureObject("升", 4.5461d));
            MetricMap.put("us gal.", new MeasureObject("L", 3.7854d));
            MetricMap.put("uk gal.", new MeasureObject("L", 4.5461d));
            MetricMap.put("液体盎司(美制)", new MeasureObject("毫升", 29.57d));
            MetricMap.put("液体盎司(英制)", new MeasureObject("毫升", 28.41d));
            MetricMap.put("us fl.oz", new MeasureObject("mL", 29.57d));
            MetricMap.put("uk fl.oz", new MeasureObject("mL", 28.41d));
            MetricMap.put("英尺水柱", new MeasureObject("毫米汞柱", 1.868d));
            MetricMap.put("inH2O", new MeasureObject("mmHg", 1.868d));
            MetricMap.put("液盎司", new MeasureObject("毫升", 28.3286d));
            MetricMap.put("fl oz", new MeasureObject("mL", 28.3286d));
            MetricMap.put("英里/时", new MeasureObject("千米/时", 1.6093d));
            MetricMap.put("英里每小时", new MeasureObject("千米每小时", 1.6093d));
            MetricMap.put("英里/小时", new MeasureObject("千米/小时", 1.6093d));
            MetricMap.put("mph", new MeasureObject("km/h", 1.6093d));
            MetricMap.put("英里每秒", new MeasureObject("千米/秒", 1.6093d));
            MetricMap.put("mps", new MeasureObject("km/s", 1.6093d));
            MetricMap.put("码每秒", new MeasureObject("米/秒", 0.9144d));
            MetricMap.put("ydps", new MeasureObject("m/s", 0.9144d));
            MetricMap.put("磅英尺", new MeasureObject("牛米", 1.3546d));
            MetricMap.put("lb-ft", new MeasureObject("Nm", 1.3546d));
            MetricMap.put("磅/(吋)²", new MeasureObject("千帕", 6.895d));
            MetricMap.put("psi", new MeasureObject("Kpa", 6.895d));
            MetricMap.put("英尺每平方秒", new MeasureObject("米每平方秒", 0.3048d));
            MetricMap.put("ft/s^2", new MeasureObject("m/s^2", 0.3048d));
            MetricMap.put("磅/秒", new MeasureObject("克/秒", 453.59d));
            MetricMap.put("lb/s", new MeasureObject("g/s", 453.59d));
            MetricMap.put("英里/加仑(美制)", new MeasureObject("升/百公里", 235.21d));
            MetricMap.put("us mpg", new MeasureObject("L/100km", 235.21d));
            MetricMap.put("英里/加仑(英制)", new MeasureObject("升/百公里", 282.48d));
            MetricMap.put("uk mpg", new MeasureObject("L/100km", 282.48d));
            MetricMap.put("华氏度", new MeasureObject("摄氏度", "2"));
            MetricMap.put("degree f", new MeasureObject("degree C", "2"));
            MetricMap.put("grados f", new MeasureObject("grados C", "2"));
            MetricMap.put("deg f", new MeasureObject("deg C", "2"));
            MetricMap.put("degf", new MeasureObject("degC", "2"));
            MetricMap.put("°f", new MeasureObject("°C", "2"));
        }
        return MetricMap;
    }

    public static HashMap<String, MeasureObject> getImperialMap() {
        getImperialMapForChangeUnit();
        if (ImperialMap == null) {
            HashMap<String, MeasureObject> hashMap = new HashMap<>();
            ImperialMap = hashMap;
            hashMap.put("毫克/升", new MeasureObject("百万分率", 1.0d));
            ImperialMap.put("mg/l", new MeasureObject("ppm", 1.0d));
            ImperialMap.put("米每平方秒", new MeasureObject("英尺每平方秒", 3.28d));
            ImperialMap.put("m/s^2", new MeasureObject("ft/s^2", 3.28d));
            ImperialMap.put("毫克", new MeasureObject("盎司", 0.0353d));
            ImperialMap.put("mg", new MeasureObject("oz", 0.0353d));
            ImperialMap.put("克", new MeasureObject("磅", 0.0022d));
            ImperialMap.put("g", new MeasureObject("lb", 0.0022d));
            ImperialMap.put("千克", new MeasureObject("磅", 2.205d));
            ImperialMap.put("kg", new MeasureObject("lb", 2.205d));
            ImperialMap.put("千米", new MeasureObject("英里", 0.6214d));
            ImperialMap.put("km", new MeasureObject("mile", 0.6214d));
            ImperialMap.put("米", new MeasureObject("码", 1.0936d));
            ImperialMap.put("m", new MeasureObject("yd", 1.0936d));
            ImperialMap.put("分米", new MeasureObject("英尺", 0.328d));
            ImperialMap.put("dm", new MeasureObject("ft", 0.328d));
            ImperialMap.put("厘米", new MeasureObject("吋", 0.3937d));
            ImperialMap.put("cm", new MeasureObject("inch", 0.3937d));
            ImperialMap.put("毫米", new MeasureObject("吋", 0.0394d));
            ImperialMap.put("mm", new MeasureObject("inch", 0.0394d));
            ImperialMap.put("平方千米", new MeasureObject("平方英里", 0.3861d));
            ImperialMap.put("km^2", new MeasureObject("mi^2", 0.3861d));
            ImperialMap.put("平方米", new MeasureObject("平方码", 1.196d));
            ImperialMap.put("m^2", new MeasureObject("sq yd", 1.196d));
            ImperialMap.put("平方分米", new MeasureObject("平方英尺", 0.1076d));
            ImperialMap.put("dm^2", new MeasureObject("sq ft", 0.1076d));
            ImperialMap.put("平方厘米", new MeasureObject("平方英寸", 0.155d));
            ImperialMap.put("cm^2", new MeasureObject("sq inch", 0.155d));
            ImperialMap.put("立方千米", new MeasureObject("立方英里", 0.2399d));
            ImperialMap.put("km^3", new MeasureObject("mi^3", 0.2399d));
            ImperialMap.put("立方米", new MeasureObject("立方码", 1.308d));
            ImperialMap.put("m^3", new MeasureObject("yd^3", 1.308d));
            ImperialMap.put("立方分米", new MeasureObject("立方英尺", 0.0353d));
            ImperialMap.put("dm^3", new MeasureObject("ft^3", 0.0353d));
            ImperialMap.put("立方厘米", new MeasureObject("立方英寸", 0.061d));
            ImperialMap.put("cm^3", new MeasureObject("in^3", 0.061d));
            ImperialMap.put("升", new MeasureObject("加仑", 0.22d));
            ImperialMap.put(PAD3DHCPForDoIP.f10141a, new MeasureObject("gal.", 0.22d));
            ImperialMap.put("毫米汞柱", new MeasureObject("英尺水柱", 0.535d));
            ImperialMap.put("mmHg", new MeasureObject("inH2O", 0.535d));
            ImperialMap.put("毫升", new MeasureObject("液盎司", 0.0353d));
            ImperialMap.put("ml", new MeasureObject("fl oz", 0.0353d));
            ImperialMap.put("千米/时", new MeasureObject("英里/时", 0.6214d));
            ImperialMap.put("千米每小时", new MeasureObject("英里每小时", 0.6214d));
            ImperialMap.put("千米/小时", new MeasureObject("英里/小时", 0.6214d));
            ImperialMap.put("km/h", new MeasureObject("mph", 0.6214d));
            ImperialMap.put("千米/秒", new MeasureObject("英里每秒", 0.6214d));
            ImperialMap.put("km/s", new MeasureObject("mps", 0.6214d));
            ImperialMap.put("米/秒", new MeasureObject("码每秒", 1.0936d));
            ImperialMap.put("m/s", new MeasureObject("ydps", 1.0936d));
            ImperialMap.put("牛米", new MeasureObject("磅英尺", 0.7382d));
            ImperialMap.put("nm", new MeasureObject("lb-ft", 0.7382d));
            ImperialMap.put("千帕", new MeasureObject("磅/(吋)²", 0.145d));
            ImperialMap.put("kpa", new MeasureObject("psi", 0.145d));
            ImperialMap.put("兆帕", new MeasureObject("磅/(吋)²", 145.04d));
            ImperialMap.put("mpa", new MeasureObject("psi", 145.04d));
            ImperialMap.put("摄氏度", new MeasureObject("华氏度", "1"));
            ImperialMap.put("degree C".toLowerCase(), new MeasureObject("degree F", "1"));
            ImperialMap.put("deg C".toLowerCase(), new MeasureObject("deg F", "1"));
            ImperialMap.put("degC".toLowerCase(), new MeasureObject("degF", "1"));
            ImperialMap.put("°C".toLowerCase(), new MeasureObject("°F", "1"));
            ImperialMap.put("℃".toLowerCase(), new MeasureObject("°F", "1"));
            ImperialMap.put("ºC".toLowerCase(), new MeasureObject("°F", "1"));
            ImperialMap.put("grados C".toLowerCase(), new MeasureObject("grados F", "1"));
        }
        return ImperialMap;
    }

    public static String splitValue(String str, String str2, HashMap<String, MeasureObject> hashMap) {
        boolean z;
        try {
            String trim = str.trim();
            boolean startsWith = trim.startsWith("-");
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= splitChar.length) {
                    z = false;
                    i = 0;
                    break;
                }
                i2 = trim.indexOf(splitChar[i], startsWith ? 1 : 0);
                if (i2 != -1) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                String substring = trim.substring(0, i2);
                String substring2 = trim.substring(i2 + splitChar[i].length(), trim.length());
                String format = hashMap.get(str2).toValue(substring) == 0.0d ? "0" : decimalFormat.format(hashMap.get(str2).toValue(substring));
                String format2 = hashMap.get(str2).toValue(substring2) == 0.0d ? "0" : decimalFormat.format(hashMap.get(str2).toValue(substring2));
                return format + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + splitChar[i] + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + format2;
            }
            return trim;
        } catch (Exception e) {
            Log.e("MeasureConversionBean", "splitValue :unit = " + str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + e.toString());
            return str;
        }
    }

    public static String splitValueForChangeUnit(String str, int i, MeasureObject measureObject) {
        boolean z;
        try {
            String trim = str.trim();
            boolean startsWith = trim.startsWith("-");
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= splitChar.length) {
                    z = false;
                    i2 = 0;
                    break;
                }
                i3 = trim.indexOf(splitChar[i2], startsWith ? 1 : 0);
                if (i3 != -1) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (z) {
                String substring = trim.substring(0, i3);
                String substring2 = trim.substring(i3 + splitChar[i2].length(), trim.length());
                double valueForChangeUnit = measureObject.toValueForChangeUnit(substring, i);
                double valueForChangeUnit2 = measureObject.toValueForChangeUnit(substring2, i);
                String format = valueForChangeUnit == 0.0d ? "0" : decimalFormat.format(valueForChangeUnit);
                String format2 = valueForChangeUnit2 == 0.0d ? "0" : decimalFormat.format(valueForChangeUnit2);
                return format + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + splitChar[i2] + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + format2;
            }
            return trim;
        } catch (Exception e) {
            Log.e("MeasureConversionBean", "splitValueForChangeUnit :pos = " + i + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + e.toString());
            return str;
        }
    }

    public static void convertSampleDataImperialToMetric(BasicSampleDataStreamBean basicSampleDataStreamBean) {
        HashMap<String, MeasureObject> metricMap = getMetricMap();
        try {
            String srcUnit = basicSampleDataStreamBean.getSrcUnit();
            if (srcUnit != null && !srcUnit.equals("nm")) {
                String lowerCase = srcUnit.trim().toLowerCase(DiagnoseConstants.LOCAL_LANGUAGE);
                if (MetricMapForChangeUnit.containsKey(lowerCase) && !basicSampleDataStreamBean.getId().equals("")) {
                    basicSampleDataStreamBean.setCanChangeUnit(true, 0);
                    ArrayList<String> listUnitForChangeUnit = MetricMapForChangeUnit.get(lowerCase).getListUnitForChangeUnit();
                    for (int i = 0; i < listUnitForChangeUnit.size(); i++) {
                        basicSampleDataStreamBean.setConversionLeastValueInit(Double.valueOf(MetricMapForChangeUnit.get(lowerCase).toValue(basicSampleDataStreamBean.getLeast_value(), i)), 0);
                        basicSampleDataStreamBean.setConversionUnit(listUnitForChangeUnit.get(i), 0);
                        basicSampleDataStreamBean.setConversionMaximalValueInit(Double.valueOf(MetricMapForChangeUnit.get(lowerCase).toValue(basicSampleDataStreamBean.getMaximal_value(), i)), 0);
                    }
                    return;
                } else if (metricMap.containsKey(lowerCase)) {
                    basicSampleDataStreamBean.setConversionLeastValueInit(Double.valueOf(metricMap.get(lowerCase).toValue(basicSampleDataStreamBean.getLeast_value())), 0);
                    basicSampleDataStreamBean.setConversionUnit(metricMap.get(lowerCase).getUnit(), 0);
                    basicSampleDataStreamBean.setConversionMaximalValueInit(Double.valueOf(metricMap.get(lowerCase).toValue(basicSampleDataStreamBean.getMaximal_value())), 0);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("convertSampleData", e.toString());
        }
        basicSampleDataStreamBean.setConversionUnit(basicSampleDataStreamBean.getSrcUnit(), 0);
        basicSampleDataStreamBean.setConversionLeastValueInit(Double.valueOf(new BigDecimal(basicSampleDataStreamBean.getLeast_value()).setScale(2, 4).doubleValue()), 0);
        basicSampleDataStreamBean.setConversionMaximalValueInit(Double.valueOf(new BigDecimal(basicSampleDataStreamBean.getMaximal_value()).setScale(2, 4).doubleValue()), 0);
    }

    public static void convertSampleDataMetricToImperial(BasicSampleDataStreamBean basicSampleDataStreamBean) {
        HashMap<String, MeasureObject> imperialMap = getImperialMap();
        try {
            String srcUnit = basicSampleDataStreamBean.getSrcUnit();
            if (srcUnit != null && !srcUnit.equals("nm")) {
                String lowerCase = srcUnit.trim().toLowerCase(DiagnoseConstants.LOCAL_LANGUAGE);
                if (ImperialMapForChangeUnit.containsKey(lowerCase) && !basicSampleDataStreamBean.getId().equals("")) {
                    basicSampleDataStreamBean.setCanChangeUnit(true, 1);
                    ArrayList<String> listUnitForChangeUnit = ImperialMapForChangeUnit.get(lowerCase).getListUnitForChangeUnit();
                    for (int i = 0; i < listUnitForChangeUnit.size(); i++) {
                        basicSampleDataStreamBean.setConversionLeastValueInit(Double.valueOf(ImperialMapForChangeUnit.get(lowerCase).toValue(basicSampleDataStreamBean.getLeast_value(), i)), 1);
                        basicSampleDataStreamBean.setConversionUnit(listUnitForChangeUnit.get(i), 1);
                        basicSampleDataStreamBean.setConversionMaximalValueInit(Double.valueOf(ImperialMapForChangeUnit.get(lowerCase).toValue(basicSampleDataStreamBean.getMaximal_value(), i)), 1);
                    }
                    return;
                } else if (imperialMap.containsKey(lowerCase)) {
                    basicSampleDataStreamBean.setConversionLeastValueInit(Double.valueOf(imperialMap.get(lowerCase).toValue(basicSampleDataStreamBean.getLeast_value())), 1);
                    basicSampleDataStreamBean.setConversionUnit(imperialMap.get(lowerCase).getUnit(), 1);
                    basicSampleDataStreamBean.setConversionMaximalValueInit(Double.valueOf(imperialMap.get(lowerCase).toValue(basicSampleDataStreamBean.getMaximal_value())), 1);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("convertSampleData", e.toString());
        }
        basicSampleDataStreamBean.setConversionUnit(basicSampleDataStreamBean.getSrcUnit(), 1);
        basicSampleDataStreamBean.setConversionLeastValueInit(Double.valueOf(new BigDecimal(basicSampleDataStreamBean.getLeast_value()).setScale(2, 4).doubleValue()), 1);
        basicSampleDataStreamBean.setConversionMaximalValueInit(Double.valueOf(new BigDecimal(basicSampleDataStreamBean.getMaximal_value()).setScale(2, 4).doubleValue()), 1);
    }

    public static HashMap<String, MeasureObject> getMetricMapForChangeUnit() {
        if (MetricMapForChangeUnit == null) {
            MetricMapForChangeUnit = new HashMap<>();
            if (!bCanChangeUnit) {
                return ImperialMapForChangeUnit;
            }
            MetricMapForChangeUnit.put("千克", new MeasureObject(new String[]{"千克", "克"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("kg", new MeasureObject(new String[]{"kg", "g"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("克", new MeasureObject(new String[]{"克", "千克", "毫克"}, 1.0d, 0.001d, 1000.0d));
            MetricMapForChangeUnit.put("g", new MeasureObject(new String[]{"g", "kg", "mg"}, 1.0d, 0.001d, 1000.0d));
            MetricMapForChangeUnit.put("毫克", new MeasureObject(new String[]{"毫克", "克"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("mg", new MeasureObject(new String[]{"mg", "g"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("磅", new MeasureObject(new String[]{"千克", "克"}, 0.4535d, 453.5d));
            MetricMapForChangeUnit.put("lb", new MeasureObject(new String[]{"kg", "g"}, 0.4535d, 453.5d));
            MetricMapForChangeUnit.put("千米", new MeasureObject(new String[]{"千米", "米"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("km", new MeasureObject(new String[]{"km", "m"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("米", new MeasureObject(new String[]{"米", "千米"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("m", new MeasureObject(new String[]{"m", "km"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("厘米", new MeasureObject(new String[]{"厘米", "毫米"}, 1.0d, 10.0d));
            MetricMapForChangeUnit.put("cm", new MeasureObject(new String[]{"cm", "mm"}, 1.0d, 10.0d));
            MetricMapForChangeUnit.put("毫米", new MeasureObject(new String[]{"毫米", "厘米"}, 1.0d, 0.1d));
            MetricMapForChangeUnit.put("mm", new MeasureObject(new String[]{"mm", "cm"}, 1.0d, 0.1d));
            MetricMapForChangeUnit.put("yd", new MeasureObject(new String[]{"m", "cm"}, 0.9144d, 91.44d));
            MetricMapForChangeUnit.put("码", new MeasureObject(new String[]{"米", "厘米"}, 0.9144d, 91.44d));
            MetricMapForChangeUnit.put("英尺", new MeasureObject(new String[]{"米", "厘米"}, 0.3048d, 30.48d));
            MetricMapForChangeUnit.put("ft", new MeasureObject(new String[]{"m", "cm"}, 0.3048d, 30.48d));
            MetricMapForChangeUnit.put("英寸", new MeasureObject(new String[]{"厘米", "毫米"}, 2.54d, 25.4d));
            MetricMapForChangeUnit.put("inch", new MeasureObject(new String[]{"cm", "mm"}, 2.54d, 25.4d));
            MetricMapForChangeUnit.put("升", new MeasureObject(new String[]{"升", "毫升"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put(PAD3DHCPForDoIP.f10141a, new MeasureObject(new String[]{"L", "mL"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("毫升", new MeasureObject(new String[]{"毫升", "升"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("ml", new MeasureObject(new String[]{"mL", "L"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("千米/时", new MeasureObject(new String[]{"千米/时", "米/秒"}, 1.0d, 0.2778d));
            MetricMapForChangeUnit.put("km/h", new MeasureObject(new String[]{"km/h", "m/s"}, 1.0d, 0.2778d));
            MetricMapForChangeUnit.put("米/秒", new MeasureObject(new String[]{"米/秒", "千米/时"}, 1.0d, 3.6d));
            MetricMapForChangeUnit.put("m/s", new MeasureObject(new String[]{"m/s", "km/h"}, 1.0d, 3.6d));
            MetricMapForChangeUnit.put("英里/时", new MeasureObject(new String[]{"千米/时", "米/秒"}, 1.6093d, 0.447d));
            MetricMapForChangeUnit.put("mph", new MeasureObject(new String[]{"km/h", "m/s"}, 1.6093d, 0.447d));
            MetricMapForChangeUnit.put("千磅平方英寸", new MeasureObject(new String[]{"兆帕", "巴"}, 6.8948d, 68.95d));
            MetricMapForChangeUnit.put("ksi", new MeasureObject(new String[]{"MPa", "bar"}, 6.8948d, 68.95d));
            MetricMapForChangeUnit.put("磅平方英寸", new MeasureObject(new String[]{"千帕", "百帕", "毫巴"}, 6.8948d, 68.95d, 68.95d));
            MetricMapForChangeUnit.put("psi", new MeasureObject(new String[]{"kPa", "hPa", "mbar"}, 6.8948d, 68.95d, 68.95d));
            MetricMapForChangeUnit.put("kw", new MeasureObject(new String[]{"kW", "W", "ps"}, 1.0d, 1000.0d, 1.3596d));
            MetricMapForChangeUnit.put("千瓦", new MeasureObject(new String[]{"千瓦", "瓦", "马力(公制)"}, 1.0d, 1000.0d, 1.3596d));
            MetricMapForChangeUnit.put("w", new MeasureObject(new String[]{"W", "kW", "ps"}, 1.0d, 0.001d, 0.0014d));
            MetricMapForChangeUnit.put("瓦", new MeasureObject(new String[]{"瓦", "千瓦", "马力(公制)"}, 1.0d, 0.001d, 0.0014d));
            MetricMapForChangeUnit.put("马力(公制)", new MeasureObject(new String[]{"马力(公制)", "瓦", "千瓦"}, 1.0d, 735.5d, 0.7355d));
            MetricMapForChangeUnit.put("ps", new MeasureObject(new String[]{"ps", "W", "kW"}, 1.0d, 735.5d, 0.7355d));
            MetricMapForChangeUnit.put("马力(英制)", new MeasureObject(new String[]{"马力(公制)", "瓦", "千瓦"}, 1.0139d, 745.7d, 0.7457d));
            MetricMapForChangeUnit.put("hp", new MeasureObject(new String[]{"ps", "W", "kW"}, 1.0139d, 745.7d, 0.7457d));
            MetricMapForChangeUnit.put("磅/小时", new MeasureObject(new String[]{"千克/小时", "克/秒"}, 0.4536d, 0.126d));
            MetricMapForChangeUnit.put("lb/h", new MeasureObject(new String[]{"kg/h", "g/s"}, 0.4536d, 0.126d));
            MetricMapForChangeUnit.put("百万分率", new MeasureObject(new String[]{"百万分率", "毫克/千克", "毫克/升", "克/立方厘米"}, 1.0d, 1.0d, 1.0d, 1.0d));
            MetricMapForChangeUnit.put("ppm", new MeasureObject(new String[]{"ppm", "mg/kg", "mg/L", "g/cm^3"}, 1.0d, 1.0d, 1.0d, 1.0d));
            MetricMapForChangeUnit.put("毫克/升", new MeasureObject(new String[]{"毫克/升", "毫克/千克", "百万分率", "克/立方厘米"}, 1.0d, 1.0d, 1.0d, 1.0d));
            MetricMapForChangeUnit.put("mg/l", new MeasureObject(new String[]{"mg/L", "mg/kg", "ppm", "g/cm^3"}, 1.0d, 1.0d, 1.0d, 1.0d));
            MetricMapForChangeUnit.put("升/小时", new MeasureObject(new String[]{"升/小时", "毫升/秒"}, 1.0d, 0.2778d));
            MetricMapForChangeUnit.put("l/h", new MeasureObject(new String[]{"L/h", "mL/s"}, 1.0d, 0.2778d));
            MetricMapForChangeUnit.put("升/分钟", new MeasureObject(new String[]{"升/分钟", "升/小时", "毫升/分钟"}, 1.0d, 0.0167d, 1000.0d));
            MetricMapForChangeUnit.put("l/min", new MeasureObject(new String[]{"L/min", "L/h", "mL/min"}, 1.0d, 0.0167d, 1000.0d));
            MetricMapForChangeUnit.put("毫升/分钟", new MeasureObject(new String[]{"毫升/分钟", "升/分钟", "毫升/秒"}, 1.0d, 0.001d, 0.0167d));
            MetricMapForChangeUnit.put("ml/min", new MeasureObject(new String[]{"mL/min", "L/min", "mL/s"}, 1.0d, 0.001d, 0.0167d));
            MetricMapForChangeUnit.put("毫升/秒", new MeasureObject(new String[]{"毫升/秒", "毫升/分钟"}, 1.0d, 60.0d));
            MetricMapForChangeUnit.put("ml/s", new MeasureObject(new String[]{"mL/s", "mL/min"}, 1.0d, 60.0d));
            MetricMapForChangeUnit.put("毫米汞柱", new MeasureObject(new String[]{"毫米汞柱", "千帕", "帕"}, 1.0d, 0.1333d, 133.32d));
            MetricMapForChangeUnit.put("mmhg", new MeasureObject(new String[]{"mmHg", "kPa", "Pa"}, 1.0d, 0.1333d, 133.32d));
            MetricMapForChangeUnit.put("兆帕", new MeasureObject(new String[]{"兆帕", "千帕", "巴"}, 1.0d, 1000.0d, 10.0d));
            MetricMapForChangeUnit.put("mpa", new MeasureObject(new String[]{"MPa", "kPa", "bar"}, 1.0d, 1000.0d, 10.0d));
            MetricMapForChangeUnit.put("千帕", new MeasureObject(new String[]{"千帕", "兆帕", "百帕", "帕", "巴"}, 1.0d, 0.001d, 10.0d, 1000.0d, 0.01d));
            MetricMapForChangeUnit.put("kpa", new MeasureObject(new String[]{"kPa", "MPa", "hPa", "Pa", "bar"}, 1.0d, 0.001d, 10.0d, 1000.0d, 0.01d));
            MetricMapForChangeUnit.put("百帕", new MeasureObject(new String[]{"百帕", "千帕", "帕", "巴", "毫巴"}, 1.0d, 0.1d, 100.0d, 0.001d, 1.0d));
            MetricMapForChangeUnit.put("hpa", new MeasureObject(new String[]{"hPa", "kPa", "Pa", "bar", "mbar"}, 1.0d, 0.1d, 100.0d, 0.001d, 1.0d));
            MetricMapForChangeUnit.put("帕", new MeasureObject(new String[]{"帕", "百帕", "千帕", "毫巴"}, 1.0d, 0.01d, 0.001d, 0.01d));
            MetricMapForChangeUnit.put("pa", new MeasureObject(new String[]{"Pa", "hPa", "kPa", "mbar"}, 1.0d, 0.01d, 0.001d, 0.01d));
            MetricMapForChangeUnit.put("巴", new MeasureObject(new String[]{"巴", "兆帕", "百帕", "千帕", "毫巴"}, 1.0d, 0.1d, 1000.0d, 100.0d, 1000.0d));
            MetricMapForChangeUnit.put("bar", new MeasureObject(new String[]{"bar", "MPa", "hPa", "kPa", "mbar"}, 1.0d, 0.1d, 1000.0d, 100.0d, 1000.0d));
            MetricMapForChangeUnit.put("毫巴", new MeasureObject(new String[]{"毫巴", "千帕", "百帕", "帕"}, 1.0d, 0.1d, 1.0d, 100.0d));
            MetricMapForChangeUnit.put("mbar", new MeasureObject(new String[]{"mbar", "kPa", "hPa", "Pa"}, 1.0d, 0.1d, 1.0d, 100.0d));
            MetricMapForChangeUnit.put("千欧", new MeasureObject(new String[]{"千欧", "欧"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("欧", new MeasureObject(new String[]{"欧", "千欧"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("kohm", new MeasureObject(new String[]{"Kohm", "ohm"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("ohm", new MeasureObject(new String[]{"ohm", "Kohm"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("安时", new MeasureObject(new String[]{"安时", "毫安时"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("毫安时", new MeasureObject(new String[]{"毫安时", "安时"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("ah", new MeasureObject(new String[]{"Ah", "mAh"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("mah", new MeasureObject(new String[]{"mAh", "Ah"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("千克/小时", new MeasureObject(new String[]{"千克/小时", "克/秒"}, 1.0d, 0.28d));
            MetricMapForChangeUnit.put("kg/h", new MeasureObject(new String[]{"kg/h", "g/s"}, 1.0d, 0.28d));
            MetricMapForChangeUnit.put("克/秒", new MeasureObject(new String[]{"克/秒", "千克/小时"}, 1.0d, 3.6d));
            MetricMapForChangeUnit.put("g/s", new MeasureObject(new String[]{"g/s", "kg/h"}, 1.0d, 3.6d));
            MetricMapForChangeUnit.put("伏特", new MeasureObject(new String[]{"伏", "毫伏"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("安培", new MeasureObject(new String[]{"安", "毫安"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("欧姆", new MeasureObject(new String[]{"欧", "千欧"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("瓦特", new MeasureObject(new String[]{"瓦", "千瓦", "马力(公制)"}, 1.0d, 0.001d, 0.0014d));
            MetricMapForChangeUnit.put("伏", new MeasureObject(new String[]{"伏", "毫伏"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("v", new MeasureObject(new String[]{"V", "mV"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("毫伏", new MeasureObject(new String[]{"毫伏", "伏"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("mv", new MeasureObject(new String[]{"mV", "V"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put(HtmlTags.f19618A, new MeasureObject(new String[]{"A", "mA"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("ma", new MeasureObject(new String[]{"mA", "A"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("安", new MeasureObject(new String[]{"安", "毫安"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("毫安", new MeasureObject(new String[]{"毫安", "安"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("米每平方秒", new MeasureObject(new String[]{"米每平方秒", "重力加速度"}, 1.0d, 0.102d));
            MetricMapForChangeUnit.put("重力加速度", new MeasureObject(new String[]{"重力加速度", "米每平方秒"}, 1.0d, 9.8066d));
            MetricMapForChangeUnit.put("m/s^2", new MeasureObject(new String[]{"m/s^2", "G(Gravity)"}, 1.0d, 0.102d));
            MetricMapForChangeUnit.put("g(gravity)", new MeasureObject(new String[]{"G(Gravity)", "m/s^2"}, 1.0d, 9.8066d));
            MetricMapForChangeUnit.put("英尺每平方秒", new MeasureObject(new String[]{"米每平方秒", "重力加速度"}, 0.3048d, 0.0311d));
            MetricMapForChangeUnit.put("ft/s^2", new MeasureObject(new String[]{"m/s^2", "G(Gravity)"}, 0.3048d, 0.0311d));
            MetricMapForChangeUnit.put("rad", new MeasureObject(new String[]{"rad", "mRad"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("弧度", new MeasureObject(new String[]{"弧度", "豪弧度"}, 1.0d, 1000.0d));
            MetricMapForChangeUnit.put("豪弧度", new MeasureObject(new String[]{"豪弧度", "弧度"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("mrad", new MeasureObject(new String[]{"mRad", "rad"}, 1.0d, 0.001d));
            MetricMapForChangeUnit.put("转/分", new MeasureObject(new String[]{"转/分", "转/秒", "弧度/秒", "弧度/分", "度/秒", "度/分"}, 1.0d, 0.0167d, 0.1047d, 6.2832d, 6.0d, 360.0d));
            MetricMapForChangeUnit.put("rpm", new MeasureObject(new String[]{"rpm", "rps", "rad/s", "rad/m", "deg/s", "deg/m"}, 1.0d, 0.0167d, 0.1047d, 6.2832d, 6.0d, 360.0d));
            MetricMapForChangeUnit.put("转/秒", new MeasureObject(new String[]{"转/秒", "转/分", "弧度/秒", "度/秒"}, 1.0d, 60.0d, 6.2832d, 360.0d));
            MetricMapForChangeUnit.put("rad/s", new MeasureObject(new String[]{"rad/s", "rpm", "rad/s", "deg/s"}, 1.0d, 60.0d, 6.2832d, 360.0d));
            MetricMapForChangeUnit.put("度/秒", new MeasureObject(new String[]{"度/秒", "转/分", "弧度/秒", "弧度/分"}, 1.0d, 0.167d, 0.0175d, 1.0472d));
            MetricMapForChangeUnit.put("deg/s", new MeasureObject(new String[]{"deg/s", "rpm", "rad/s", "rad/m"}, 1.0d, 0.167d, 0.0175d, 1.0472d));
            MetricMapForChangeUnit.put("弧度/秒", new MeasureObject(new String[]{"弧度/秒", "度/秒", "转/分", "弧度/分"}, 1.0d, 57.3d, 9.5493d, 60.0d));
            MetricMapForChangeUnit.put("rad/s", new MeasureObject(new String[]{"rad/s", "deg/s", "rpm", "rad/m"}, 1.0d, 57.3d, 9.5493d, 60.0d));
        }
        return MetricMapForChangeUnit;
    }

    public static HashMap<String, MeasureObject> getImperialMapForChangeUnit() {
        if (ImperialMapForChangeUnit == null) {
            ImperialMapForChangeUnit = new HashMap<>();
            if (!bCanChangeUnit) {
                return ImperialMapForChangeUnit;
            }
            ImperialMapForChangeUnit.put("磅", new MeasureObject(new String[]{"磅", "盎司"}, 1.0d, 16.0d));
            ImperialMapForChangeUnit.put("lb", new MeasureObject(new String[]{"lb", "oz"}, 1.0d, 16.0d));
            ImperialMapForChangeUnit.put("oz", new MeasureObject(new String[]{"oz", "lb"}, 1.0d, 0.0625d));
            ImperialMapForChangeUnit.put("盎司", new MeasureObject(new String[]{"盎司", "磅"}, 1.0d, 0.0625d));
            ImperialMapForChangeUnit.put("米", new MeasureObject(new String[]{"码", "英里"}, 1.0936d, 6.0E-4d));
            ImperialMapForChangeUnit.put("m", new MeasureObject(new String[]{"yd", "mile"}, 1.0936d, 6.0E-4d));
            ImperialMapForChangeUnit.put("厘米", new MeasureObject(new String[]{"英尺", "英寸"}, 0.0328d, 0.3937d));
            ImperialMapForChangeUnit.put("cm", new MeasureObject(new String[]{"ft", "inch"}, 0.0328d, 0.3937d));
            ImperialMapForChangeUnit.put("毫米", new MeasureObject(new String[]{"英尺", "英寸"}, 0.0033d, 0.0394d));
            ImperialMapForChangeUnit.put("mm", new MeasureObject(new String[]{"ft", "inch"}, 0.0033d, 0.0394d));
            ImperialMapForChangeUnit.put("英里", new MeasureObject(new String[]{"英里", "码"}, 1.0d, 1760.0d));
            ImperialMapForChangeUnit.put("mile", new MeasureObject(new String[]{"mile", "yd"}, 1.0d, 1760.0d));
            ImperialMapForChangeUnit.put("码", new MeasureObject(new String[]{"码", "英尺", "英寸"}, 1.0d, 3.0d, 36.0d));
            ImperialMapForChangeUnit.put("yd", new MeasureObject(new String[]{"yd", "ft", "inch"}, 1.0d, 3.0d, 36.0d));
            ImperialMapForChangeUnit.put("英尺", new MeasureObject(new String[]{"英尺", "码", "英寸"}, 1.0d, 0.3333d, 12.0d));
            ImperialMapForChangeUnit.put("ft", new MeasureObject(new String[]{"ft", "yd", "inch"}, 1.0d, 0.3333d, 12.0d));
            ImperialMapForChangeUnit.put("英寸", new MeasureObject(new String[]{"英寸", "英尺"}, 1.0d, 0.083d));
            ImperialMapForChangeUnit.put("inch", new MeasureObject(new String[]{"inch", "ft"}, 1.0d, 0.083d));
            ImperialMapForChangeUnit.put("克", new MeasureObject(new String[]{"磅", "盎司"}, 0.0022d, 0.04d));
            ImperialMapForChangeUnit.put("g", new MeasureObject(new String[]{"lb", "oz"}, 0.0022d, 0.04d));
            ImperialMapForChangeUnit.put("升", new MeasureObject(new String[]{"加仑(美制)", "加仑(英制)"}, 0.2642d, 0.22d));
            ImperialMapForChangeUnit.put(PAD3DHCPForDoIP.f10141a, new MeasureObject(new String[]{"us gal.", "uk gal."}, 0.2642d, 0.22d));
            ImperialMapForChangeUnit.put("毫升", new MeasureObject(new String[]{"液体盎司(美制)", "液体盎司(英制)"}, 0.0338d, 0.0352d));
            ImperialMapForChangeUnit.put("ml", new MeasureObject(new String[]{"us fl.oz", "uk fl.oz"}, 0.0338d, 0.0352d));
            ImperialMapForChangeUnit.put("加仑(美制)", new MeasureObject(new String[]{"加仑(美制)", "加仑(英制)", "液体盎司(美制)", "液体盎司(英制)"}, 1.0d, 0.8327d, 128.02d, 133.24d));
            ImperialMapForChangeUnit.put("us gal.", new MeasureObject(new String[]{"us gal.", "uk gal.", "us fl.oz", "uk fl.oz"}, 1.0d, 0.8327d, 128.02d, 133.24d));
            ImperialMapForChangeUnit.put("加仑(英制)", new MeasureObject(new String[]{"加仑(英制)", "加仑(美制)", "液体盎司(美制)", "液体盎司(英制)"}, 1.0d, 1.201d, 153.74d, 160.02d));
            ImperialMapForChangeUnit.put("uk gal.", new MeasureObject(new String[]{"uk gal.", "us gal.", "us fl.oz", "uk fl.oz"}, 1.0d, 1.201d, 153.74d, 160.02d));
            ImperialMapForChangeUnit.put("液体盎司(美制)", new MeasureObject(new String[]{"液体盎司(美制)", "加仑(英制)", "加仑(美制)", "液体盎司(英制)"}, 1.0d, 0.0065d, 0.0078d, 1.0408d));
            ImperialMapForChangeUnit.put("us fl.oz", new MeasureObject(new String[]{"us fl.oz", "uk gal.", "us gal.", "uk fl.oz"}, 1.0d, 0.0065d, 0.0078d, 1.0408d));
            ImperialMapForChangeUnit.put("液体盎司(英制)", new MeasureObject(new String[]{"液体盎司(英制)", "加仑(英制)", "加仑(美制)", "液体盎司(美制)"}, 1.0d, 0.0062d, 0.0075d, 0.9608d));
            ImperialMapForChangeUnit.put("uk fl.oz", new MeasureObject(new String[]{"uk fl.oz", "uk gal.", "us gal.", "us fl.oz"}, 1.0d, 0.0062d, 0.0075d, 0.9608d));
            ImperialMapForChangeUnit.put("兆帕", new MeasureObject(new String[]{"磅平方英寸", "千帕", "巴", "千磅平方英寸", "兆帕"}, 145.04d, 1000.0d, 10.0d, 0.15d, 1.0d));
            ImperialMapForChangeUnit.put("mpa", new MeasureObject(new String[]{"psi", "kPa", "bar", "ksi", "MPa"}, 145.04d, 1000.0d, 10.0d, 0.15d, 1.0d));
            ImperialMapForChangeUnit.put("千帕", new MeasureObject(new String[]{"磅平方英寸", "兆帕", "百帕", "帕", "巴", "千帕"}, 0.15d, 0.001d, 10.0d, 1000.0d, 0.01d, 1.0d));
            ImperialMapForChangeUnit.put("kpa", new MeasureObject(new String[]{"psi", "MPa", "hPa", "Pa", "bar", "kPa"}, 0.15d, 0.001d, 10.0d, 1000.0d, 0.01d, 1.0d));
            ImperialMapForChangeUnit.put("百帕", new MeasureObject(new String[]{"磅平方英寸", "百帕", "千帕", "帕", "巴", "毫巴"}, 0.01d, 1.0d, 0.1d, 100.0d, 0.001d, 1.0d));
            ImperialMapForChangeUnit.put("hpa", new MeasureObject(new String[]{"psi", "hPa", "kPa", "Pa", "bar", "mbar"}, 0.01d, 1.0d, 0.1d, 100.0d, 0.001d, 1.0d));
            ImperialMapForChangeUnit.put("帕", new MeasureObject(new String[]{"帕", "百帕", "千帕", "毫巴"}, 1.0d, 0.01d, 0.001d, 0.01d));
            ImperialMapForChangeUnit.put("pa", new MeasureObject(new String[]{"Pa", "hPa", "kPa", "mbar"}, 1.0d, 0.01d, 0.001d, 0.01d));
            ImperialMapForChangeUnit.put("巴", new MeasureObject(new String[]{"巴", "兆帕", "百帕", "千帕", "毫巴", "千磅平方英寸", "磅平方英寸"}, 1.0d, 0.1d, 1000.0d, 100.0d, 1000.0d, 0.01d, 14.5d));
            ImperialMapForChangeUnit.put("bar", new MeasureObject(new String[]{"bar", "MPa", "hPa", "kPa", "mbar", "ksi", "psi"}, 1.0d, 0.1d, 1000.0d, 100.0d, 1000.0d, 0.01d, 14.5d));
            ImperialMapForChangeUnit.put("毫巴", new MeasureObject(new String[]{"毫巴", "千帕", "百帕", "帕", "磅平方英寸"}, 1.0d, 0.1d, 1.0d, 100.0d, 0.01d));
            ImperialMapForChangeUnit.put("mbar", new MeasureObject(new String[]{"mbar", "kPa", "hPa", "Pa", "psi"}, 1.0d, 0.1d, 1.0d, 100.0d, 0.01d));
            ImperialMapForChangeUnit.put("千磅平方英寸", new MeasureObject(new String[]{"千磅平方英寸", "兆帕", "巴", "磅平方英寸"}, 1.0d, 6.8948d, 68.95d, 1000.0d));
            ImperialMapForChangeUnit.put("ksi", new MeasureObject(new String[]{"ksi", "MPa", "bar", "psi"}, 1.0d, 6.8948d, 68.95d, 1000.0d));
            ImperialMapForChangeUnit.put("磅平方英寸", new MeasureObject(new String[]{"磅平方英寸", "千帕", "百帕", "毫巴", "千磅平方英寸"}, 1.0d, 6.8948d, 68.95d, 68.95d, 0.001d));
            ImperialMapForChangeUnit.put("psi", new MeasureObject(new String[]{"psi", "kPa", "hPa", "mbar", "ksi"}, 1.0d, 6.8948d, 68.95d, 68.95d, 0.001d));
            ImperialMapForChangeUnit.put("毫米汞柱", new MeasureObject(new String[]{"千帕", "帕"}, 0.1333d, 133.32d));
            ImperialMapForChangeUnit.put("mmHg", new MeasureObject(new String[]{"kPa", "Pa"}, 0.1333d, 133.32d));
            ImperialMapForChangeUnit.put("v", new MeasureObject(new String[]{"V", "mV"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("mv", new MeasureObject(new String[]{"mV", "V"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put(HtmlTags.f19618A, new MeasureObject(new String[]{"A", "mA"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("ma", new MeasureObject(new String[]{"mA", "A"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("伏", new MeasureObject(new String[]{"伏", "毫伏"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("毫伏", new MeasureObject(new String[]{"毫伏", "伏"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("安", new MeasureObject(new String[]{"安", "毫安"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("毫安", new MeasureObject(new String[]{"毫安", "安"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("伏特", new MeasureObject(new String[]{"伏", "毫伏"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("安培", new MeasureObject(new String[]{"安", "毫安"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("欧姆", new MeasureObject(new String[]{"欧", "千欧"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("瓦特", new MeasureObject(new String[]{"瓦", "千瓦", "马力(英制)"}, 1.0d, 0.001d, 0.0013d));
            ImperialMapForChangeUnit.put("米每平方秒", new MeasureObject(new String[]{"英尺每平方秒", "重力加速度"}, 3.28d, 0.102d));
            ImperialMapForChangeUnit.put("重力加速度", new MeasureObject(new String[]{"英尺每平方秒", "重力加速度"}, 32.17d, 1.0d));
            ImperialMapForChangeUnit.put("英尺每平方秒", new MeasureObject(new String[]{"英尺每平方秒", "重力加速度"}, 1.0d, 0.0311d));
            ImperialMapForChangeUnit.put("m/s^2", new MeasureObject(new String[]{"ft/s^2", "G(Gravity)"}, 3.28d, 0.102d));
            ImperialMapForChangeUnit.put("g(gravity)", new MeasureObject(new String[]{"ft/s^2", "G(Gravity)"}, 32.17d, 1.0d));
            ImperialMapForChangeUnit.put("ft/s^2", new MeasureObject(new String[]{"ft/s^2", "G(Gravity)"}, 1.0d, 0.0311d));
            ImperialMapForChangeUnit.put("千欧", new MeasureObject(new String[]{"千欧", "欧"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("欧", new MeasureObject(new String[]{"欧", "千欧"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("kohm", new MeasureObject(new String[]{"Kohm", "ohm"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("ohm", new MeasureObject(new String[]{"ohm", "Kohm"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("安时", new MeasureObject(new String[]{"安时", "毫安时"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("毫安时", new MeasureObject(new String[]{"毫安时", "安时"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("ah", new MeasureObject(new String[]{"Ah", "mAh"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("mah", new MeasureObject(new String[]{"mAh", "Ah"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("kw", new MeasureObject(new String[]{"kW", "W", "hp"}, 1.0d, 1000.0d, 1.341d));
            ImperialMapForChangeUnit.put("千瓦", new MeasureObject(new String[]{"千瓦", "瓦", "马力(英制)"}, 1.0d, 1000.0d, 1.341d));
            ImperialMapForChangeUnit.put("w", new MeasureObject(new String[]{"W", "kW", "hp"}, 1.0d, 0.001d, 0.0013d));
            ImperialMapForChangeUnit.put("瓦", new MeasureObject(new String[]{"瓦", "千瓦", "马力(英制)"}, 1.0d, 0.001d, 0.0013d));
            ImperialMapForChangeUnit.put("马力(公制)", new MeasureObject(new String[]{"马力(英制)", "瓦", "千瓦"}, 0.9863d, 735.5d, 0.7355d));
            ImperialMapForChangeUnit.put("ps", new MeasureObject(new String[]{"hp", "W", "kW"}, 0.9863d, 735.5d, 0.7355d));
            ImperialMapForChangeUnit.put("马力(英制)", new MeasureObject(new String[]{"马力(英制)", "瓦", "千瓦"}, 1.0d, 745.7d, 0.7457d));
            ImperialMapForChangeUnit.put("hp", new MeasureObject(new String[]{"hp", "W", "kW"}, 1.0d, 745.7d, 0.7457d));
            ImperialMapForChangeUnit.put("克/秒", new MeasureObject(new String[]{"磅/小时", "磅/秒"}, 7.9366d, 0.0022d));
            ImperialMapForChangeUnit.put("g/s", new MeasureObject(new String[]{"lb/h", "lb/s"}, 7.9366d, 0.0022d));
            ImperialMapForChangeUnit.put("米/秒", new MeasureObject(new String[]{"码每秒", "英里/小时"}, 1.0936d, 2.237d));
            ImperialMapForChangeUnit.put("m/s", new MeasureObject(new String[]{"ydps", "mph"}, 1.0936d, 2.237d));
            ImperialMapForChangeUnit.put("升/小时", new MeasureObject(new String[]{"加仑(美制)/小时", "加仑(英制)/小时"}, 0.2642d, 0.22d));
            ImperialMapForChangeUnit.put("l/h", new MeasureObject(new String[]{"us gph", "uk gph"}, 0.2642d, 0.22d));
            ImperialMapForChangeUnit.put("升/分钟", new MeasureObject(new String[]{"加仑(美制)/分钟", "加仑(英制)/分钟"}, 0.2642d, 0.22d));
            ImperialMapForChangeUnit.put("l/min", new MeasureObject(new String[]{"us gpm", "uk gpm"}, 0.2642d, 0.22d));
            ImperialMapForChangeUnit.put("毫升/分钟", new MeasureObject(new String[]{"液体盎司(美制)/分钟", "液体盎司(英制)/分钟"}, 0.0338d, 0.0352d));
            ImperialMapForChangeUnit.put("ml/min", new MeasureObject(new String[]{"us fl.oz/min", "uk fl.oz/min"}, 0.0338d, 0.0352d));
            ImperialMapForChangeUnit.put("毫升/秒", new MeasureObject(new String[]{"液体盎司(美制)/秒", "液体盎司(英制)/秒"}, 0.0338d, 0.0352d));
            ImperialMapForChangeUnit.put("ml/s", new MeasureObject(new String[]{"us fl.oz/s", "uk fl.oz/s"}, 0.0338d, 0.0352d));
            ImperialMapForChangeUnit.put("升/百公里", new MeasureObject(new String[]{"英里/加仑(美制)", "英里/加仑(英制)"}, 235.21d, 282.48d));
            ImperialMapForChangeUnit.put("l/100km", new MeasureObject(new String[]{"us mpg", "uk mpg"}, 235.21d, 282.48d));
            ImperialMapForChangeUnit.put("英里/加仑(美制)", new MeasureObject(new String[]{"英里/加仑(美制)", "英里/加仑(英制)"}, 1.0d, 1.201d));
            ImperialMapForChangeUnit.put("us mpg", new MeasureObject(new String[]{"us mpg", "uk mpg"}, 1.0d, 1.201d));
            ImperialMapForChangeUnit.put("英里/加仑(英制)", new MeasureObject(new String[]{"英里/加仑(英制)", "英里/加仑(美制)"}, 1.0d, 0.8327d));
            ImperialMapForChangeUnit.put("us mpg", new MeasureObject(new String[]{"us mpg", "uk mpg"}, 1.0d, 0.8327d));
            ImperialMapForChangeUnit.put("rad", new MeasureObject(new String[]{"rad", "mRad"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("弧度", new MeasureObject(new String[]{"弧度", "豪弧度"}, 1.0d, 1000.0d));
            ImperialMapForChangeUnit.put("豪弧度", new MeasureObject(new String[]{"豪弧度", "弧度"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("mrad", new MeasureObject(new String[]{"mRad", "rad"}, 1.0d, 0.001d));
            ImperialMapForChangeUnit.put("转/分", new MeasureObject(new String[]{"转/分", "转/秒", "弧度/秒", "弧度/分", "度/秒", "度/分"}, 1.0d, 0.0167d, 0.1047d, 6.2832d, 6.0d, 360.0d));
            ImperialMapForChangeUnit.put("rpm", new MeasureObject(new String[]{"rpm", "rps", "rad/s", "rad/m", "deg/s", "deg/m"}, 1.0d, 0.0167d, 0.1047d, 6.2832d, 6.0d, 360.0d));
            ImperialMapForChangeUnit.put("转/秒", new MeasureObject(new String[]{"转/秒", "转/分", "弧度/秒", "度/秒"}, 1.0d, 60.0d, 6.2832d, 360.0d));
            ImperialMapForChangeUnit.put("rad/s", new MeasureObject(new String[]{"rad/s", "rpm", "rad/s", "deg/s"}, 1.0d, 60.0d, 6.2832d, 360.0d));
            ImperialMapForChangeUnit.put("度/秒", new MeasureObject(new String[]{"度/秒", "转/分", "弧度/秒", "弧度/分"}, 1.0d, 0.0167d, 0.0175d, 1.0472d));
            ImperialMapForChangeUnit.put("deg/s", new MeasureObject(new String[]{"deg/s", "rpm", "rad/s", "rad/m"}, 1.0d, 0.0167d, 0.0175d, 1.0472d));
            ImperialMapForChangeUnit.put("弧度/秒", new MeasureObject(new String[]{"弧度/秒", "度/秒", "转/分", "弧度/分"}, 1.0d, 57.3d, 9.5493d, 60.0d));
            ImperialMapForChangeUnit.put("rad/s", new MeasureObject(new String[]{"rad/s", "deg/s", "rpm", "rad/m"}, 1.0d, 57.3d, 9.5493d, 60.0d));
        }
        return ImperialMapForChangeUnit;
    }
}
