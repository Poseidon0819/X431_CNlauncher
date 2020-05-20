package com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.List;

/* loaded from: classes.dex */
public class DataForGolo365 extends BasicBean {
    private String app_ver;
    private String bin_ver;
    private String diagnose_soft_ver;
    private List<FaultCodeInfoBean> faultCodeInfo;
    private List<FreezeFrameDataBean> freeze_frame_data;
    private List<IuprDataBean> iupr_data;
    private LocationBean location;
    private List<ReadyStateInfoBean> readyStateInfo;
    private int result;
    private String serial_number;
    private long test_time;
    private VehicleInfoBean vehicleInfo;

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public String getSerial_number() {
        return this.serial_number;
    }

    public void setSerial_number(String str) {
        this.serial_number = str;
    }

    public String getDiagnose_soft_ver() {
        return this.diagnose_soft_ver;
    }

    public void setDiagnose_soft_ver(String str) {
        this.diagnose_soft_ver = str;
    }

    public String getApp_ver() {
        return this.app_ver;
    }

    public void setApp_ver(String str) {
        this.app_ver = str;
    }

    public String getBin_ver() {
        return this.bin_ver;
    }

    public void setBin_ver(String str) {
        this.bin_ver = str;
    }

    public long getTest_time() {
        return this.test_time;
    }

    public void setTest_time(long j) {
        this.test_time = j;
    }

    public VehicleInfoBean getVehicleInfo() {
        return this.vehicleInfo;
    }

    public void setVehicleInfo(VehicleInfoBean vehicleInfoBean) {
        this.vehicleInfo = vehicleInfoBean;
    }

    public LocationBean getLocation() {
        return this.location;
    }

    public void setLocation(LocationBean locationBean) {
        this.location = locationBean;
    }

    public List<FaultCodeInfoBean> getFaultCodeInfo() {
        return this.faultCodeInfo;
    }

    public void setFaultCodeInfo(List<FaultCodeInfoBean> list) {
        this.faultCodeInfo = list;
    }

    public List<ReadyStateInfoBean> getReadyStateInfo() {
        return this.readyStateInfo;
    }

    public void setReadyStateInfo(List<ReadyStateInfoBean> list) {
        this.readyStateInfo = list;
    }

    public List<IuprDataBean> getIupr_data() {
        return this.iupr_data;
    }

    public void setIupr_data(List<IuprDataBean> list) {
        this.iupr_data = list;
    }

    public List<FreezeFrameDataBean> getFreeze_frame_data() {
        return this.freeze_frame_data;
    }

    public void setFreeze_frame_data(List<FreezeFrameDataBean> list) {
        this.freeze_frame_data = list;
    }

    /* loaded from: classes.dex */
    public static class VehicleInfoBean {
        private List<ArrECUBean> arrECU;
        private int ignition_type;
        private String mil_odo;
        private int mil_status;
        private String obd;
        private String odo;
        private String protocol;
        private String vin;
        private String year;

        public String getVin() {
            return this.vin;
        }

        public void setVin(String str) {
            this.vin = str;
        }

        public String getYear() {
            return this.year;
        }

        public void setYear(String str) {
            this.year = str;
        }

        public String getProtocol() {
            return this.protocol;
        }

        public void setProtocol(String str) {
            this.protocol = str;
        }

        public String getObd() {
            return this.obd;
        }

        public void setObd(String str) {
            this.obd = str;
        }

        public int getIgnition_type() {
            return this.ignition_type;
        }

        public void setIgnition_type(int i) {
            this.ignition_type = i;
        }

        public String getOdo() {
            return this.odo;
        }

        public void setOdo(String str) {
            this.odo = str;
        }

        public int getMil_status() {
            return this.mil_status;
        }

        public void setMil_status(int i) {
            this.mil_status = i;
        }

        public String getMil_odo() {
            return this.mil_odo;
        }

        public void setMil_odo(String str) {
            this.mil_odo = str;
        }

        public List<ArrECUBean> getArrECU() {
            return this.arrECU;
        }

        public void setArrECU(List<ArrECUBean> list) {
            this.arrECU = list;
        }

        /* loaded from: classes.dex */
        public static class ArrECUBean {
            private List<String> arrCVN;
            private List<String> arrCalID;
            private String name;
            private String vin;

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getVin() {
                return this.vin;
            }

            public void setVin(String str) {
                this.vin = str;
            }

            public List<String> getArrCalID() {
                return this.arrCalID;
            }

            public void setArrCalID(List<String> list) {
                this.arrCalID = list;
            }

            public List<String> getArrCVN() {
                return this.arrCVN;
            }

            public void setArrCVN(List<String> list) {
                this.arrCVN = list;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LocationBean {
        private String address;
        private String city;
        private String gps_type;
        private String lat;
        private String lon;

        public String getLat() {
            return this.lat;
        }

        public void setLat(String str) {
            this.lat = str;
        }

        public String getLon() {
            return this.lon;
        }

        public void setLon(String str) {
            this.lon = str;
        }

        public String getGps_type() {
            return this.gps_type;
        }

        public void setGps_type(String str) {
            this.gps_type = str;
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String str) {
            this.city = str;
        }
    }

    /* loaded from: classes.dex */
    public static class FaultCodeInfoBean {
        private String context;
        private String status;
        private String sysIDForEP;
        private String title;

        public String getSysIDForEP() {
            return this.sysIDForEP;
        }

        public void setSysIDForEP(String str) {
            this.sysIDForEP = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getContext() {
            return this.context;
        }

        public void setContext(String str) {
            this.context = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }
    }

    /* loaded from: classes.dex */
    public static class ReadyStateInfoBean {
        private String abbreviation;
        private String name;
        private String value;

        public String getAbbreviation() {
            return this.abbreviation;
        }

        public void setAbbreviation(String str) {
            this.abbreviation = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes.dex */
    public static class IuprDataBean {
        private String abbreviation;
        private String name;
        private String value;

        public String getAbbreviation() {
            return this.abbreviation;
        }

        public void setAbbreviation(String str) {
            this.abbreviation = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes.dex */
    public static class FreezeFrameDataBean {
        private List<ArrFreezeBean> arrFreeze;
        private String context;
        private String status;
        private String sysID;
        private String title;

        public String getSysID() {
            return this.sysID;
        }

        public void setSysID(String str) {
            this.sysID = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getContext() {
            return this.context;
        }

        public void setContext(String str) {
            this.context = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public List<ArrFreezeBean> getArrFreeze() {
            return this.arrFreeze;
        }

        public void setArrFreeze(List<ArrFreezeBean> list) {
            this.arrFreeze = list;
        }

        /* loaded from: classes.dex */
        public static class ArrFreezeBean {
            private String title;
            private String unit;
            private String value;

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public String getValue() {
                return this.value;
            }

            public void setValue(String str) {
                this.value = str;
            }

            public String getUnit() {
                return this.unit;
            }

            public void setUnit(String str) {
                this.unit = str;
            }
        }
    }
}
