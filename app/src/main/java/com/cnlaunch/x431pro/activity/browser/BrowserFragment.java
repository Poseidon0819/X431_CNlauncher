package com.cnlaunch.x431pro.activity.browser;

import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.browser.p216a.BrowserAdapter;
import com.cnlaunch.x431pro.module.p243b.p244a.BrowserWebSitesList;
import com.ifoer.expedition.pro.R;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.browser.a */
/* loaded from: classes.dex */
public class BrowserFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: c */
    static String f10959c = "";

    /* renamed from: a */
    BrowserAdapter f10960a;

    /* renamed from: b */
    Button f10961b;

    /* renamed from: d */
    private GridView f10962d;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.tool_item_name_browser);
        this.f10962d = (GridView) getActivity().findViewById(R.id.gridView1);
        this.f10962d.setOnItemClickListener(this);
        this.f10960a = new BrowserAdapter(getActivity(), new BrowserWebSitesList().getList());
        this.f10962d.setAdapter((ListAdapter) this.f10960a);
        this.f10961b = (Button) getActivity().findViewById(R.id.button1);
        this.f10961b.setText("blank");
        this.f10961b.setOnClickListener(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.browser_fragment, viewGroup, false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BrowserAdapter.C2003a c2003a = (BrowserAdapter.C2003a) view.getTag();
        Uri parse = Uri.parse(c2003a.f10968b);
        Intent intent = new Intent();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getActivity().getSystemService("activity")).getRunningAppProcesses();
        if (!f10959c.equals(c2003a.f10968b)) {
            intent.setData(parse);
        } else {
            boolean z = false;
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if ("com.android.chrome".equals(it.next().processName)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                intent.setData(parse);
            }
        }
        intent.setClassName("com.android.chrome", "com.google.android.apps.chrome.Main");
        f10959c = c2003a.f10968b;
        startActivity(intent);
    }
}
