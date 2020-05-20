package com.cnlaunch.p169im.p170a;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.im.a.x */
/* loaded from: classes.dex */
public final class SelectProvider {
    /* renamed from: a */
    public static ArrayList<Map<String, Integer>> m8879a() {
        int[] iArr = {R.string.add_friends, R.string.chat_select_grid_face, R.string.check_server_file_txt, R.string.chat_select_grid_picture, R.string.dialog_remotediag_handler_title};
        int[] iArr2 = {R.drawable.mode_btn_add_friends, R.drawable.mode_btn_face, R.drawable.mode_btn_file, R.drawable.mode_btn_pic, R.drawable.mode_btn_help};
        int[] iArr3 = {HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_ICON_NULL, 100002, 100004, 100003, HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_NETWORK_ERROR};
        ArrayList<Map<String, Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", Integer.valueOf(iArr[i]));
            hashMap.put("image", Integer.valueOf(iArr2[i]));
            hashMap.put("what", Integer.valueOf(iArr3[i]));
            arrayList.add(hashMap);
        }
        return arrayList;
    }
}
