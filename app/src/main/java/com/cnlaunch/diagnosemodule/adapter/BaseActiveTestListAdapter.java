package com.cnlaunch.diagnosemodule.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cnlaunch.diagnosemodule.C1444R;
import com.cnlaunch.diagnosemodule.bean.BasicActiveTestBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.util.ArrayList;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class BaseActiveTestListAdapter extends BaseAdapter {
    View.OnClickListener clickListener = new View.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.adapter.BaseActiveTestListAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActiveTestListAdapter.this.mDialog.setIcon(17301659);
            BaseActiveTestListAdapter.this.mDialog.setTitle(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActiveTestListAdapter.this.mDialog.setMessage(BaseActiveTestListAdapter.this.list.get(view.getId()).getTitle());
            BaseActiveTestListAdapter.this.mDialog.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            BaseActiveTestListAdapter.this.mDialog.setCancelable(true);
            BaseActiveTestListAdapter.this.mDialog.show();
        }
    };
    ArrayList<BasicActiveTestBean> list;
    private Context mContext;
    AlertDialog.Builder mDialog;

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

    public BaseActiveTestListAdapter(ArrayList<BasicActiveTestBean> arrayList, Context context) {
        this.list = arrayList;
        this.mContext = context;
        this.mDialog = new AlertDialog.Builder(context, C1444R.style.DiagnoseMessageDialogTheme);
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
        return String.valueOf(i);
    }
}
