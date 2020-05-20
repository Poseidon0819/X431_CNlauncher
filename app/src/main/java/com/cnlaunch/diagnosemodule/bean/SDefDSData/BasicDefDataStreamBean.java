package com.cnlaunch.diagnosemodule.bean.SDefDSData;

import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamWithSubItemBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseProcessInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BasicDefDataStreamBean {
    private int dataLabel;
    private int dsAtt;

    /* renamed from: id */
    private String f7279id;

    /* renamed from: sn */
    private int f7280sn;
    private String title;
    private String unit;
    private String standardvalue = "";
    private String standardvalueStatus = "";
    private String value = "";
    private boolean bGrapValidDataFor94Type = false;
    private ArrayList<BasicDefSubItemDataStreamBean> arrSubItemDS = new ArrayList<>();

    public ArrayList<BasicDefSubItemDataStreamBean> getArrSubItemDS() {
        return this.arrSubItemDS;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public int getSn() {
        return this.f7280sn;
    }

    public void setSn(int i) {
        this.f7280sn = i;
    }

    public int getDsAtt() {
        return this.dsAtt;
    }

    public void setDsAtt(int i) {
        this.dsAtt = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getId() {
        return this.f7279id;
    }

    public void setId(String str) {
        this.f7279id = str;
    }

    public String getStandardvalue() {
        return this.standardvalue;
    }

    public void setStandardvalue(String str) {
        this.standardvalue = str;
    }

    public String getStandardvalueStatus() {
        return this.standardvalueStatus;
    }

    public void setStandardvalueStatus(String str) {
        this.standardvalueStatus = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public boolean isbGrapValidDataFor94Type() {
        return this.bGrapValidDataFor94Type;
    }

    public void setbGrapValidDataFor94Type(boolean z) {
        this.bGrapValidDataFor94Type = z;
    }

    public int getDataLabel() {
        return this.dataLabel;
    }

    public void setDataLabel(int i) {
        this.dataLabel = i;
    }

    public BasicDataStreamBean toDataStreamBean() {
        if ((this.dsAtt & 4) != 4) {
            BasicDataStreamBean basicDataStreamBean = new BasicDataStreamBean();
            basicDataStreamBean.setbHaveHelpFor94Type((this.dsAtt & 2) == 2);
            if (TextUtils.isEmpty(this.f7279id)) {
                basicDataStreamBean.setId("");
            } else {
                basicDataStreamBean.setId(this.f7279id);
            }
            basicDataStreamBean.setTitle(this.title);
            basicDataStreamBean.setSn(this.f7280sn);
            basicDataStreamBean.setUnit(this.unit);
            if (this.unit.isEmpty() && (this.dsAtt & 1) != 1) {
                basicDataStreamBean.setUnit("   ");
            }
            basicDataStreamBean.setValue(this.value);
            basicDataStreamBean.setStandardvalue(this.standardvalue);
            basicDataStreamBean.setValuestatus(this.standardvalueStatus);
            basicDataStreamBean.setbGrapValidDataFor94Type(this.bGrapValidDataFor94Type);
            if (this.standardvalueStatus.isEmpty() && (DiagnoseProcessInfoUtil.getInstance().getType94AllDSAtt() & 4) == 4) {
                basicDataStreamBean.setValuestatus("0");
            }
            return basicDataStreamBean;
        }
        BasicDataStreamWithSubItemBean basicDataStreamWithSubItemBean = new BasicDataStreamWithSubItemBean();
        basicDataStreamWithSubItemBean.setbHaveHelpFor94Type((this.dsAtt & 2) == 2);
        basicDataStreamWithSubItemBean.setId(this.f7279id);
        basicDataStreamWithSubItemBean.setTitle(this.title);
        if ((DiagnoseProcessInfoUtil.getInstance().getType94AllDSAtt() & 4) == 4) {
            basicDataStreamWithSubItemBean.setValuestatus("0");
        } else {
            basicDataStreamWithSubItemBean.setValuestatus("");
        }
        basicDataStreamWithSubItemBean.setSn(this.f7280sn);
        Iterator<BasicDefSubItemDataStreamBean> it = this.arrSubItemDS.iterator();
        while (it.hasNext()) {
            BasicDefSubItemDataStreamBean next = it.next();
            BasicDataStreamBean basicDataStreamBean2 = new BasicDataStreamBean();
            if (!TextUtils.isEmpty(next.getId())) {
                basicDataStreamBean2.setId(next.getId());
            }
            basicDataStreamBean2.setTitle(next.getTitle());
            basicDataStreamBean2.setUnit(next.getUnit());
            if (next.getUnit().isEmpty() && (next.getDsAtt() & 1) != 1) {
                basicDataStreamBean2.setUnit("   ");
            }
            basicDataStreamBean2.setValue(next.getValue());
            basicDataStreamBean2.setStandardvalue(next.getStandardvalue());
            basicDataStreamBean2.setValuestatus(next.getStandardvalueStatus());
            basicDataStreamBean2.setbGrapValidDataFor94Type(this.bGrapValidDataFor94Type);
            if (this.standardvalueStatus.isEmpty() && (DiagnoseProcessInfoUtil.getInstance().getType94AllDSAtt() & 4) == 4) {
                basicDataStreamBean2.setValuestatus("0");
            }
            basicDataStreamWithSubItemBean.getArrSubItemDataStream().add(basicDataStreamBean2);
        }
        return basicDataStreamWithSubItemBean;
    }
}
