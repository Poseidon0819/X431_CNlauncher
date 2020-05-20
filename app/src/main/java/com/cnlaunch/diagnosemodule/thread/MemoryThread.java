package com.cnlaunch.diagnosemodule.thread;

import android.content.Context;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MemoryThread extends Thread {
    private static boolean isRunning = true;
    private static boolean isWait = false;
    private Context mContext;
    private List<String> commandList = new ArrayList();
    private int sleepTime = 1;

    public int getSleepTime() {
        return this.sleepTime;
    }

    public void setSleepTime(int i) {
        this.sleepTime = i;
    }

    public MemoryThread(Context context) {
        isRunning = true;
        isWait = false;
        this.mContext = context;
    }

    public void addDataInArrary(String str) {
        this.commandList.add(str);
        if (isWait) {
            notifyThread();
        }
    }

    public void addLastDataInArrary(String str) {
        this.commandList.clear();
        this.commandList.add(str);
        if (isWait) {
            notifyThread();
        }
    }

    public void clearCommandList() {
        this.commandList.clear();
    }

    public void stopThread() {
        isRunning = false;
        if (isWait) {
            notifyThread();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (isRunning) {
            try {
                if (this.sleepTime > 1) {
                    sleep(this.sleepTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.commandList.size() > 0) {
                handleData(this.commandList.get(0));
                this.commandList.remove(0);
            } else {
                sleepThread();
            }
        }
    }

    public synchronized void notifyThread() {
        isWait = false;
        notify();
    }

    public synchronized void sleepThread() {
        try {
            isWait = true;
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void resumeThread() {
        isRunning = true;
        notify();
    }

    public void handleData(String str) {
        if (DiagnoseConstants.DIAG_LIB_OLD) {
            return;
        }
        DiagnoseBusiness.getInstance(this.mContext).feedbackPotting(str);
    }

    public List<String> getCommandList() {
        return this.commandList;
    }
}
