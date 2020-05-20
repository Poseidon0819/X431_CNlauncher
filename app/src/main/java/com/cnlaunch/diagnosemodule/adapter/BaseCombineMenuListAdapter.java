package com.cnlaunch.diagnosemodule.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cnlaunch.diagnosemodule.bean.BasicCombineMenuBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BaseCombineMenuListAdapter extends BaseAdapter {
    private int firtItem;
    private ArrayList<BasicCombineMenuBean> list;
    private Context mContext;

    public String getFeedbackType() {
        return DiagnoseConstants.FEEDBACK_COMBINATION_MENU;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return view;
    }

    public BaseCombineMenuListAdapter(ArrayList<BasicCombineMenuBean> arrayList, Context context, int i) {
        this.list = arrayList;
        this.mContext = context;
        this.firtItem = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.list.get(i);
    }

    public String getFeedbackCmd(int i) {
        Object valueOf;
        StringBuilder sb = new StringBuilder("008");
        sb.append(String.valueOf(i));
        int i2 = this.firtItem;
        if (i2 < 10) {
            valueOf = "0" + this.firtItem;
        } else {
            valueOf = Integer.valueOf(i2);
        }
        sb.append(valueOf);
        return sb.toString();
    }
}
