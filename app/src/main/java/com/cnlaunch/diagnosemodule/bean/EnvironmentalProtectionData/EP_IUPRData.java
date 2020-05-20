package com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class EP_IUPRData extends BasicBean {
    private int fireCount;
    private ArrayList<EP_IUPR> listIUPR = new ArrayList<>();
    private int obd_Count;

    public int getObd_Count() {
        return this.obd_Count;
    }

    public void setObd_Count(int i) {
        this.obd_Count = i;
    }

    public int getFireCount() {
        return this.fireCount;
    }

    public void setFireCount(int i) {
        this.fireCount = i;
    }

    public ArrayList<EP_IUPR> getListIUPR() {
        return this.listIUPR;
    }

    /* loaded from: classes.dex */
    public static class EP_IUPR extends BasicBean {
        private String abbreviation;
        private int count;
        private String iuprRate;
        private int successCount;
        private String title;

        public String getAbbreviation() {
            return this.abbreviation;
        }

        public void setAbbreviation(String str) {
            this.abbreviation = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public int getSuccessCount() {
            return this.successCount;
        }

        public void setSuccessCount(int i) {
            this.successCount = i;
        }

        public String getIuprRate() {
            return this.iuprRate;
        }

        public void setIuprRate(String str) {
            this.iuprRate = str;
        }
    }
}
