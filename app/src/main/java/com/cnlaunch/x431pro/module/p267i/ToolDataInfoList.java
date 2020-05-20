package com.cnlaunch.x431pro.module.p267i;

import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.SystemAppTools;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import com.cnlaunch.x431pro.module.p267i.p268a.ToolBaseDataInfo;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.module.i.a */
/* loaded from: classes.dex */
public final class ToolDataInfoList extends AbstractC2709c {
    private static final long serialVersionUID = 2688699541675754386L;
    private ArrayList<ToolBaseDataInfo> list = new ArrayList<>();

    public ToolDataInfoList(Context context) {
        refreshData(context);
    }

    public final ArrayList<ToolBaseDataInfo> getList() {
        return this.list;
    }

    public final void refreshData(Context context) {
        if (this.list.size() > 0) {
            this.list.clear();
        }
        if (SystemAppTools.getAppsIsExist(context, "com.cnlaunch.uvccamera")) {
            ToolBaseDataInfo toolBaseDataInfo = new ToolBaseDataInfo();
            toolBaseDataInfo.setImageResid(R.drawable.tools_endoscopy_pressed);
            toolBaseDataInfo.setTitleResid(R.string.tool_item_name_endoscope);
            toolBaseDataInfo.setPkgeName("com.cnlaunch.uvccamera");
            toolBaseDataInfo.setClsName("com.cnlaunch.uvccamera.UvcCameraActivity");
            this.list.add(toolBaseDataInfo);
        }
    }
}
