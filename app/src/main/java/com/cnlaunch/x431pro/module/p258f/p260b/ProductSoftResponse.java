package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/* renamed from: com.cnlaunch.x431pro.module.f.b.r */
/* loaded from: classes.dex */
public final class ProductSoftResponse extends BaseResponse {
    @JsonProperty("curCode")
    private String curcode;
    @JsonProperty("curId")
    private int curid;
    @JsonProperty("curName")
    private String curname;
    @JsonProperty("lanCode")
    private String lancode;
    @JsonProperty("lanId")
    private int lanid;
    @JsonProperty("lanName")
    private String lanname;
    @JsonProperty("proMonthNum")
    private int promonthnum;
    @JsonProperty("proName")
    private String proname;
    @JsonProperty("proPrice")
    private double proprice;
    @JsonProperty("softInfoList")
    List<Object> softinfolist;

    public final String getCurcode() {
        return this.curcode;
    }

    public final void setCurcode(String str) {
        this.curcode = str;
    }

    public final int getCurid() {
        return this.curid;
    }

    public final void setCurid(int i) {
        this.curid = i;
    }

    public final String getCurname() {
        return this.curname;
    }

    public final void setCurname(String str) {
        this.curname = str;
    }

    public final String getLancode() {
        return this.lancode;
    }

    public final void setLancode(String str) {
        this.lancode = str;
    }

    public final int getLanid() {
        return this.lanid;
    }

    public final void setLanid(int i) {
        this.lanid = i;
    }

    public final String getLanname() {
        return this.lanname;
    }

    public final void setLanname(String str) {
        this.lanname = str;
    }

    public final int getPromonthnum() {
        return this.promonthnum;
    }

    public final void setPromonthnum(int i) {
        this.promonthnum = i;
    }

    public final double getProprice() {
        return this.proprice;
    }

    public final void setProprice(double d) {
        this.proprice = d;
    }

    public final String getProname() {
        return this.proname;
    }

    public final void setProname(String str) {
        this.proname = str;
    }

    public final List<Object> getSoftinfoList() {
        return this.softinfolist;
    }

    public final void setSoftinfoList(List<Object> list) {
        this.softinfolist = list;
    }
}
