package com.cnlaunch.p188n.p191c;

import android.text.TextUtils;
import android.util.Log;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.n.c.c */
/* loaded from: classes.dex */
public final class DiagCarInfo extends BaseModel {
    private static final long serialVersionUID = 1;
    private long diag_end_time;
    private long diag_start_time;
    private long diagnose_no;
    private String email;
    private int full_scan;
    private String gpsType;
    private String netInfo_type;
    private String remote_report_name;
    private String stream;
    private String system_time;
    private String car_series = "";
    private String carName = "";
    private String path = "";
    private String serialNo = "";
    private String packageId = "";
    private String language = "";
    private String country = "";
    private String vin = "";
    private String areaID = "";
    private String softVersion = "";
    private String apkVersion = "";
    private String lat = "";
    private String lon = "";
    private String address = "";
    private String cvn = "";
    private String mileage = "";
    private String libPath = "";
    private String appDataPath = "";
    private String model = "";
    private String diag_car_mode = "";
    private String year = "";
    private String engine = "";
    private String cylinders = "";
    private String camshaft = "";
    private String bin_ver = "";
    private String metric = "";
    private String product_url = "";
    private String engineNum = "";
    private String displacement = "";
    private String transmission = "";
    private String sysNum = "";
    private String endFlag = "";
    private String plate = "";
    private String plate_url = "";
    private String pro_serial_no = "";
    private String technician_lon = "";
    private String technician_lat = "";
    private String report_type = "";
    private String remote_tech_id = "";
    private String remote_tech_advise = "";
    private boolean isUpdata = false;
    private int flag_customized = 0;
    private String im_data = "";
    private String system_ver = "";
    private int remote_ver = 0;
    private String carVender = "";
    private String remote_type = "";
    private String remote_tech_name = "";
    private String diagnosis_path = "";
    private String report_tester = "";
    private String report_customer = "";
    private String service_fee = "";
    private String report_remark = "";
    private String report_repair_type = "";
    private int remote_report_repair_type = 0;
    private String input_mobile = "";
    private String input_drive = "";
    private String input_level = "";
    private String input_country = "";
    private String input_month = "";
    private String input_tester = "";
    private String input_brand = "";
    private String input_model = "";
    private String input_year = "";
    private String input_gearbox = "";
    private String input_temperature = "";

    public final int getRemote_report_repair_type() {
        return this.remote_report_repair_type;
    }

    public final void setRemote_report_repair_type(int i) {
        this.remote_report_repair_type = i;
    }

    public final String getRemote_report_name() {
        return this.remote_report_name;
    }

    public final void setRemote_report_name(String str) {
        this.remote_report_name = str;
    }

    public final String getSystem_time() {
        return this.system_time;
    }

    public final void setSystem_time(String str) {
        this.system_time = str;
    }

    public final long getDiagnose_no() {
        return this.diagnose_no;
    }

    public final void setDiagnose_no(long j) {
        this.diagnose_no = j;
    }

    public final String getCarVender() {
        return this.carVender;
    }

    public final void setCarVender(String str) {
        this.carVender = str;
    }

    public final int getRemote_ver() {
        return this.remote_ver;
    }

    public final void setRemote_ver(int i) {
        this.remote_ver = i;
    }

    public final String getSystem_ver() {
        return this.system_ver;
    }

    public final void setSystem_ver(String str) {
        this.system_ver = str;
    }

    public final String getIm_data() {
        return this.im_data;
    }

    public final void setIm_data(String str) {
        this.im_data = str;
    }

    public final int getFlag_customized() {
        return this.flag_customized;
    }

    public final void setFlag_customized(int i) {
        this.flag_customized = i;
    }

    public final String getNetInfo_type() {
        return this.netInfo_type;
    }

    public final void setNetInfo_type(String str) {
        this.netInfo_type = str;
    }

    public final boolean isUpdata() {
        return this.isUpdata;
    }

    public final void setUpdata(boolean z) {
        this.isUpdata = z;
    }

    public final String getReport_type() {
        return this.report_type;
    }

    public final void setReport_type(String str) {
        this.report_type = str;
    }

    public final String getRemote_tech_id() {
        return this.remote_tech_id;
    }

    public final void setRemote_tech_id(String str) {
        this.remote_tech_id = str;
    }

    public final String getRemote_tech_advise() {
        return this.remote_tech_advise;
    }

    public final void setRemote_tech_advise(String str) {
        this.remote_tech_advise = str;
    }

    public final int getFull_scan() {
        return this.full_scan;
    }

    public final void setFull_scan(int i) {
        this.full_scan = i;
    }

    public final String getStream() {
        return this.stream;
    }

    public final void setStream(String str) {
        this.stream = new String(str);
    }

    public final String getPlate_url() {
        return this.plate_url;
    }

    public final void setPlate_url(String str) {
        this.plate_url = str;
    }

    public final String getPro_serial_no() {
        return this.pro_serial_no;
    }

    public final void setPro_serial_no(String str) {
        this.pro_serial_no = str;
    }

    public final String getTechnician_lon() {
        return this.technician_lon;
    }

    public final void setTechnician_lon(String str) {
        this.technician_lon = str;
    }

    public final String getTechnician_lat() {
        return this.technician_lat;
    }

    public final void setTechnician_lat(String str) {
        this.technician_lat = str;
    }

    public final String getPlate() {
        return this.plate;
    }

    public final void setPlate(String str) {
        this.plate = str;
    }

    public final void clean() {
        this.cvn = "";
        this.carName = "";
        this.path = "";
        this.packageId = "";
        this.vin = "";
        this.softVersion = "";
        this.mileage = "";
        this.libPath = "";
        this.appDataPath = "";
        this.model = "";
        this.year = "";
        this.engine = "";
        this.cylinders = "";
        this.camshaft = "";
        this.metric = "";
        this.product_url = "";
        this.engineNum = "";
        this.displacement = "";
        this.transmission = "";
        this.sysNum = "";
        this.endFlag = "";
        this.full_scan = 0;
        this.car_series = "";
        this.email = "";
        this.diagnosis_path = "";
        this.report_customer = "";
        this.report_tester = "";
        this.report_remark = "";
        this.report_repair_type = "";
        this.service_fee = "";
    }

    public final String getDiag_car_mode() {
        return this.diag_car_mode;
    }

    public final void setDiag_car_mode(String str) {
        this.diag_car_mode = str;
    }

    public final String getCar_series() {
        if (TextUtils.isEmpty(this.car_series)) {
            this.car_series = "";
        }
        return this.car_series;
    }

    public final void setCar_series(String str) {
        this.car_series = str;
    }

    public final String getEngineNum() {
        return this.engineNum;
    }

    public final void setEngineNum(String str) {
        this.engineNum = str;
    }

    public final String getDisplacement() {
        return this.displacement;
    }

    public final void setDisplacement(String str) {
        this.displacement = str;
    }

    public final String getTransmission() {
        return this.transmission;
    }

    public final void setTransmission(String str) {
        this.transmission = str;
    }

    public final String getSysNum() {
        return this.sysNum;
    }

    public final void setSysNum(String str) {
        this.sysNum = str;
    }

    public final String getEndFlag() {
        return this.endFlag;
    }

    public final void setEndFlag(String str) {
        this.endFlag = str;
    }

    public final String getBin_ver() {
        return this.bin_ver;
    }

    public final void setBin_ver(String str) {
        this.bin_ver = str;
    }

    public final String getMetric() {
        return this.metric;
    }

    public final void setMetric(String str) {
        this.metric = str;
    }

    public final String getProduct_url() {
        return this.product_url;
    }

    public final void setProduct_url(String str) {
        this.product_url = str;
    }

    public final String getDiagnosis_path() {
        return this.diagnosis_path;
    }

    public final void setDiagnosis_path(String str) {
        this.diagnosis_path = str;
    }

    public final long getDiag_start_time() {
        return this.diag_start_time;
    }

    public final void setDiag_start_time(long j) {
        this.diag_start_time = j;
    }

    public final long getDiag_end_time() {
        return this.diag_end_time;
    }

    public final void setDiag_end_time(long j) {
        this.diag_end_time = j;
    }

    public final String getModel() {
        if (TextUtils.isEmpty(this.model)) {
            this.model = "";
        }
        return this.model;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final String getYear() {
        if (TextUtils.isEmpty(this.year)) {
            this.year = "";
        }
        return this.year;
    }

    public final void setYear(String str) {
        this.year = str;
    }

    public final String getEngine() {
        return this.engine;
    }

    public final void setEngine(String str) {
        this.engine = str;
    }

    public final String getCylinders() {
        return this.cylinders;
    }

    public final void setCylinders(String str) {
        this.cylinders = str;
    }

    public final String getCamshaft() {
        return this.camshaft;
    }

    public final void setCamshaft(String str) {
        this.camshaft = str;
    }

    public final String getMileage() {
        return this.mileage;
    }

    public final void setMileage(String str) {
        this.mileage = str;
    }

    public final String getCvn() {
        return this.cvn;
    }

    public final void setCvn(String str) {
        this.cvn = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getCarName() {
        return this.carName;
    }

    public final void setCarName(String str) {
        this.carName = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final void setPackageId(String str) {
        this.packageId = str;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final String getVin() {
        return !TextUtils.isEmpty(this.vin) ? this.vin.toUpperCase() : "";
    }

    public final void setVin(String str) {
        this.vin = str;
    }

    public final String getAreaID() {
        return this.areaID;
    }

    public final void setAreaID(String str) {
        this.areaID = str;
    }

    public final String getSoftVersion() {
        return this.softVersion;
    }

    public final void setSoftVersion(String str) {
        this.softVersion = str;
    }

    public final String getApkVersion() {
        return this.apkVersion;
    }

    public final void setApkVersion(String str) {
        this.apkVersion = str;
    }

    public final String getLat() {
        return this.lat;
    }

    public final void setLat(String str) {
        this.lat = str;
    }

    public final String getLon() {
        return this.lon;
    }

    public final void setLon(String str) {
        this.lon = str;
    }

    public final String getGpsType() {
        return this.gpsType;
    }

    public final void setGpsType(String str) {
        this.gpsType = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final String getLibPath() {
        return this.libPath;
    }

    public final void setLibPath(String str) {
        this.libPath = str;
    }

    public final String getAppDataPath() {
        return this.appDataPath;
    }

    public final void setAppDataPath(String str) {
        this.appDataPath = str;
    }

    public final String toString() {
        return "DiagCarInfo{car_series='" + this.car_series + "', carName='" + this.carName + "', path='" + this.path + "', serialNo='" + this.serialNo + "', packageId='" + this.packageId + "', language='" + this.language + "', country='" + this.country + "', vin='" + this.vin + "', areaID='" + this.areaID + "', softVersion='" + this.softVersion + "', apkVersion='" + this.apkVersion + "', lat='" + this.lat + "', lon='" + this.lon + "', gpsType='" + this.gpsType + "', address='" + this.address + "', cvn='" + this.cvn + "', mileage='" + this.mileage + "', libPath='" + this.libPath + "', appDataPath='" + this.appDataPath + "', model='" + this.model + "', diag_car_mode='" + this.diag_car_mode + "', year='" + this.year + "', diag_start_time=" + this.diag_start_time + ", diag_end_time=" + this.diag_end_time + ", bin_ver='" + this.bin_ver + "', metric='" + this.metric + "', product_url='" + this.product_url + "', engineNum='" + this.engineNum + "', displacement='" + this.displacement + "', transmission='" + this.transmission + "', sysNum='" + this.sysNum + "', endFlag='" + this.endFlag + "', full_scan=" + this.full_scan + ", plate='" + this.plate + "', plate_url='" + this.plate_url + "', pro_serial_no='" + this.pro_serial_no + "', technician_lon='" + this.technician_lon + "', technician_lat='" + this.technician_lat + "', stream='" + this.stream + "', email='" + this.email + "', diagnosis_path='" + this.diagnosis_path + "', report_customer='" + this.report_customer + "', report_tester='" + this.report_tester + "', report_repair_type='" + this.report_repair_type + "', report_remark='" + this.report_remark + "', service_fee='" + this.service_fee + "'}";
    }

    public final JSONObject getJSONObject(DiagCarInfo diagCarInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageid", diagCarInfo.getPackageId());
            jSONObject.put("car_series", diagCarInfo.getCar_series());
            jSONObject.put("vin", diagCarInfo.getVin());
            jSONObject.put("year", diagCarInfo.getYear());
            jSONObject.put("engine", diagCarInfo.getEngine());
            jSONObject.put("cylinders", diagCarInfo.getCylinders());
            jSONObject.put("camshaft", diagCarInfo.getCamshaft());
            jSONObject.put("soft_version", diagCarInfo.getSoftVersion());
            jSONObject.put("model", diagCarInfo.getModel());
            jSONObject.put("language", diagCarInfo.getLanguage());
            jSONObject.put("serialNo", diagCarInfo.getSerialNo());
            jSONObject.put("apkVersion", diagCarInfo.getApkVersion());
            jSONObject.put("bin_ver", diagCarInfo.getBin_ver());
            jSONObject.put("user_lat", diagCarInfo.getLat());
            jSONObject.put("user_lon", diagCarInfo.getLon());
            jSONObject.put("gpstype", diagCarInfo.getGpsType());
            jSONObject.put("netInfo_type", diagCarInfo.getNetInfo_type());
            jSONObject.put("system_ver", diagCarInfo.getSystem_ver());
            jSONObject.put("remote_tech_id", diagCarInfo.getRemote_tech_id());
            jSONObject.put("flag_customized", diagCarInfo.getFlag_customized());
            jSONObject.put("cvn", diagCarInfo.getCvn());
            jSONObject.put("plate", diagCarInfo.getPlate());
            jSONObject.put("plate_url", diagCarInfo.getPlate_url());
            jSONObject.put("diag_car_mode", diagCarInfo.getDiag_car_mode());
            jSONObject.put("engineNum", diagCarInfo.getEngineNum());
            jSONObject.put("displacement", diagCarInfo.getDisplacement());
            jSONObject.put("transmission", diagCarInfo.getTransmission());
            jSONObject.put("sys_num", diagCarInfo.getSysNum());
            jSONObject.put("mileage", diagCarInfo.getMileage());
            jSONObject.put("diag_start_time", diagCarInfo.getDiag_start_time());
            jSONObject.put("diag_end_time", diagCarInfo.getDiag_end_time());
            jSONObject.put("is_full_scan", diagCarInfo.getFull_scan());
            jSONObject.put("end_flag", diagCarInfo.getEndFlag());
            jSONObject.put("remote_ver", 1);
            jSONObject.put("car_vender", diagCarInfo.getCarVender());
            jSONObject.put("diagnosis_path", diagCarInfo.getDiagnosis_path());
            jSONObject.put("customer", diagCarInfo.getReport_customer());
            jSONObject.put("tester", diagCarInfo.getReport_tester());
            jSONObject.put("remark", diagCarInfo.getReport_remark());
            jSONObject.put("repair_type", diagCarInfo.getReport_repair_type());
            jSONObject.put("metric", diagCarInfo.getMetric());
            jSONObject.put("service_fee", diagCarInfo.getService_fee());
            MLog.m8520c("XEE", "发送车辆信息 vehicle_info=" + jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("XEE", "getJsonConfig=" + e.toString());
        }
        return jSONObject;
    }

    public final DiagCarInfo getWebTechDiagCarInfo(String str, String str2) {
        DiagCarInfo m8525a = m8525a(str, true);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            m8525a.setRemote_report_repair_type(jSONObject.getInt("diagnoseStatus"));
            m8525a.setReport_customer(jSONObject.getString("client"));
            m8525a.setReport_tester(jSONObject.getString("detector"));
            m8525a.setReport_remark(jSONObject.getString("addition"));
            m8525a.setRemote_report_name(jSONObject.getString("reportTitle"));
            m8525a.setPlate(jSONObject.getString("plate"));
            m8525a.setMileage(jSONObject.getString("miles"));
            if (TextUtils.isEmpty(m8525a.getCar_series())) {
                m8525a.setCar_series(jSONObject.getString("series"));
            }
            if (TextUtils.isEmpty(m8525a.getCar_series())) {
                m8525a.setCar_series(jSONObject.getString("series"));
            }
            if (TextUtils.isEmpty(m8525a.getModel())) {
                m8525a.setModel(jSONObject.getString("model"));
            }
            if (TextUtils.isEmpty(m8525a.getYear())) {
                m8525a.setYear(jSONObject.getString("year"));
            }
            if (TextUtils.isEmpty(m8525a.getVin())) {
                m8525a.setVin(jSONObject.getString("vin"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return m8525a;
    }

    public final DiagCarInfo getDiagCarInfoFromJSon(String str) {
        return m8525a(str, false);
    }

    /* renamed from: a */
    private static DiagCarInfo m8525a(String str, boolean z) {
        DiagCarInfo diagCarInfo = new DiagCarInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!z) {
                jSONObject = jSONObject.getJSONObject(DataPacketExtension.ELEMENT_NAME);
            }
            diagCarInfo.setVin(jSONObject.getString("vin"));
            diagCarInfo.setPackageId(jSONObject.getString("packageid"));
            diagCarInfo.setCar_series(jSONObject.getString("car_series"));
            diagCarInfo.setYear(jSONObject.getString("year"));
            diagCarInfo.setModel(jSONObject.getString("model"));
            diagCarInfo.setSoftVersion(jSONObject.getString("soft_version"));
            if (jSONObject.has("remote_ver")) {
                diagCarInfo.setRemote_ver(jSONObject.getInt("remote_ver"));
                diagCarInfo.setLanguage(jSONObject.getString("language"));
                diagCarInfo.setSerialNo(jSONObject.getString("serialNo"));
                diagCarInfo.setApkVersion(jSONObject.getString("apkVersion"));
                diagCarInfo.setBin_ver(jSONObject.getString("bin_ver"));
                diagCarInfo.setLat(jSONObject.getString("user_lat"));
                diagCarInfo.setLon(jSONObject.getString("user_lon"));
                diagCarInfo.setGpsType(jSONObject.getString("gpstype"));
                diagCarInfo.setNetInfo_type(jSONObject.getString("netInfo_type"));
                diagCarInfo.setSystem_ver(jSONObject.getString("system_ver"));
                diagCarInfo.setRemote_tech_id(jSONObject.getString("remote_tech_id"));
                diagCarInfo.setFlag_customized(jSONObject.getInt("flag_customized"));
                diagCarInfo.setCvn(jSONObject.getString("cvn"));
                diagCarInfo.setPlate(jSONObject.getString("plate"));
                diagCarInfo.setPlate_url(jSONObject.getString("plate_url"));
                diagCarInfo.setDiag_car_mode(jSONObject.getString("diag_car_mode"));
                diagCarInfo.setEngineNum(jSONObject.getString("engineNum"));
                diagCarInfo.setDisplacement(jSONObject.getString("displacement"));
                diagCarInfo.setTransmission(jSONObject.getString("transmission"));
                diagCarInfo.setSysNum(jSONObject.getString("sys_num"));
                diagCarInfo.setMileage(jSONObject.getString("mileage"));
                diagCarInfo.setDiag_end_time(jSONObject.getLong("diag_end_time"));
                diagCarInfo.setFull_scan(jSONObject.getInt("is_full_scan"));
                diagCarInfo.setEndFlag(jSONObject.getString("end_flag"));
                diagCarInfo.setCarVender(jSONObject.getString("car_vender"));
            }
            if (jSONObject.has("engine")) {
                diagCarInfo.setEngine(jSONObject.getString("engine"));
            }
            if (jSONObject.has("diagnosis_path")) {
                diagCarInfo.setDiagnosis_path(jSONObject.getString("diagnosis_path"));
            }
            if (jSONObject.has("customer")) {
                diagCarInfo.setReport_customer(jSONObject.getString("customer"));
            }
            if (jSONObject.has("tester")) {
                diagCarInfo.setReport_tester(jSONObject.getString("tester"));
            }
            if (jSONObject.has("remark")) {
                diagCarInfo.setReport_remark(jSONObject.getString("remark"));
            }
            if (jSONObject.has("repair_type")) {
                diagCarInfo.setReport_repair_type(jSONObject.getString("repair_type"));
            }
            if (jSONObject.has("metric")) {
                diagCarInfo.setMetric(jSONObject.getString("metric"));
            }
            if (jSONObject.has("cylinders")) {
                diagCarInfo.setCylinders(jSONObject.getString("cylinders"));
            }
            if (jSONObject.has("camshaft")) {
                diagCarInfo.setCamshaft(jSONObject.getString("camshaft"));
            }
            if (jSONObject.has("service_fee")) {
                diagCarInfo.setService_fee(jSONObject.getString("service_fee"));
            }
        } catch (JSONException e) {
            Log.e("XEE", "远程车辆信息 err:" + e.toString());
            e.printStackTrace();
        }
        return diagCarInfo;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getRemote_type() {
        return this.remote_type;
    }

    public final void setRemote_type(String str) {
        this.remote_type = str;
    }

    public final String getRemote_tech_name() {
        return this.remote_tech_name;
    }

    public final void setRemote_tech_name(String str) {
        this.remote_tech_name = str;
    }

    public final String getReport_tester() {
        return this.report_tester;
    }

    public final void setReport_tester(String str) {
        this.report_tester = str;
    }

    public final String getReport_customer() {
        return this.report_customer;
    }

    public final void setReport_customer(String str) {
        this.report_customer = str;
    }

    public final void setService_fee(String str) {
        this.service_fee = str;
    }

    public final String getService_fee() {
        return this.service_fee;
    }

    public final String getReport_remark() {
        return this.report_remark;
    }

    public final void setReport_remark(String str) {
        this.report_remark = str;
    }

    public final String getReport_repair_type() {
        return this.report_repair_type;
    }

    public final void setReport_repair_type(String str) {
        this.report_repair_type = str;
    }

    public final String getInput_drive() {
        return this.input_drive;
    }

    public final void setInput_drive(String str) {
        this.input_drive = str;
    }

    public final String getInput_level() {
        return this.input_level;
    }

    public final void setInput_level(String str) {
        this.input_level = str;
    }

    public final String getInput_country() {
        return this.input_country;
    }

    public final void setInput_country(String str) {
        this.input_country = str;
    }

    public final String getInput_month() {
        return this.input_month;
    }

    public final void setInput_month(String str) {
        this.input_month = str;
    }

    public final String getInput_tester() {
        return this.input_tester;
    }

    public final void setInput_tester(String str) {
        this.input_tester = str;
    }

    public final String getInput_brand() {
        return this.input_brand;
    }

    public final void setInput_brand(String str) {
        this.input_brand = str;
    }

    public final String getInput_model() {
        return this.input_model;
    }

    public final void setInput_model(String str) {
        this.input_model = str;
    }

    public final String getInput_year() {
        return this.input_year;
    }

    public final void setInput_year(String str) {
        this.input_year = str;
    }

    public final String getInput_gearbox() {
        return this.input_gearbox;
    }

    public final void setInput_gearbox(String str) {
        this.input_gearbox = str;
    }

    public final String getInput_temperature() {
        return this.input_temperature;
    }

    public final void setInput_temperature(String str) {
        this.input_temperature = str;
    }

    public final String getInput_mobile() {
        return this.input_mobile;
    }

    public final void setInput_mobile(String str) {
        this.input_mobile = str;
    }
}
