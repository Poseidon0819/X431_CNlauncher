package com.cnlaunch.diagnosemodule.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class BasicStudyUIDataBean implements Serializable {
    private int CmdCount;
    private String backProcessUIId;
    private int frameCount;
    private List<String> inputData;
    boolean isRep;
    private HashMap<Integer, String> mapItemPos2Pid = new HashMap<>();
    private HashMap<Integer, String> mapbtnPos2Pid = new HashMap<>();
    private String nextProcessUIID;
    private String processUIId;

    public int getFrameCount() {
        return this.frameCount;
    }

    public void setFrameCount(int i) {
        this.frameCount = i;
    }

    public int getCmdCount() {
        return this.CmdCount;
    }

    public void setCmdCount(int i) {
        this.CmdCount = i;
    }

    public boolean isRep() {
        return this.isRep;
    }

    public void setRep(boolean z) {
        this.isRep = z;
    }

    public String getNextProcessUIID() {
        return this.nextProcessUIID;
    }

    public void setNextProcessUIID(String str) {
        this.nextProcessUIID = str;
    }

    public String getProcessUIId() {
        return this.processUIId;
    }

    public void setProcessUIId(String str) {
        this.processUIId = str;
    }

    public String getBackProcessUIId() {
        return this.backProcessUIId;
    }

    public void setBackProcessUIId(String str) {
        this.backProcessUIId = str;
    }

    public HashMap<Integer, String> getMapItemPos2Pid() {
        return this.mapItemPos2Pid;
    }

    public HashMap<Integer, String> getMapbtnPos2Pid() {
        return this.mapbtnPos2Pid;
    }

    public void setInputData(List<String> list) {
        this.inputData = list;
    }

    public List<String> getInputData() {
        return this.inputData;
    }
}
