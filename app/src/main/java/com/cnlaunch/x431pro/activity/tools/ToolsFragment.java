package com.cnlaunch.x431pro.activity.tools;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.tools.p237a.ToolsAdapter;
import com.cnlaunch.x431pro.module.p267i.ToolDataInfoList;
import com.cnlaunch.x431pro.module.p267i.p268a.ToolBaseDataInfo;
import com.ifoer.expedition.pro.R;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.cnlaunch.x431pro.activity.tools.a */
/* loaded from: classes.dex */
public class ToolsFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private GridView f14960a;

    /* renamed from: b */
    private ToolsAdapter f14961b;

    /* renamed from: c */
    private ToolDataInfoList f14962c = null;

    /* renamed from: d */
    private LinearLayout f14963d = null;

    /* renamed from: e */
    private Handler f14964e = null;

    /* renamed from: f */
    private C2597a f14965f = null;

    /* renamed from: g */
    private String[] f14966g = {"com.cnlaunch.uvccamera"};

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.tab_menu_tools);
        m5823a();
        if (this.f14965f == null) {
            this.f14965f = new C2597a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            getActivity().registerReceiver(this.f14965f, intentFilter);
        }
        this.f14964e = new HandlerC2599b(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.tools_fragment, viewGroup, false);
    }

    /* renamed from: a */
    private void m5823a() {
        this.f14960a = (GridView) getActivity().getLayoutInflater().inflate(R.layout.layout_tool_gridview, (ViewGroup) null);
        this.f14960a.setOnItemClickListener(this);
        this.f14962c = new ToolDataInfoList(getActivity().getBaseContext());
        this.f14961b = new ToolsAdapter(getActivity(), this.f14962c.getList());
        this.f14960a.setAdapter((ListAdapter) this.f14961b);
        this.f14963d = (LinearLayout) getActivity().findViewById(R.id.tool_main_view);
        this.f14963d.removeAllViews();
        this.f14963d.addView(this.f14960a);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f14964e.sendEmptyMessage(0);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ToolBaseDataInfo toolBaseDataInfo = new ToolDataInfoList(getActivity().getBaseContext()).getList().get(i);
        Intent intent = new Intent();
        if ("browser".equals(toolBaseDataInfo.getPkgeName())) {
            try {
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse("http://www.google.com/"));
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("com.android.gallery3d".equals(toolBaseDataInfo.getPkgeName())) {
            try {
                startActivity(new Intent("android.media.action.STILL_IMAGE_CAMERA"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                intent.setComponent(new ComponentName(toolBaseDataInfo.getPkgeName(), toolBaseDataInfo.getClsName()));
                intent.setAction("android.intent.action.MAIN");
                intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                view.getContext().startActivity(intent);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m5823a();
    }

    /* compiled from: ToolsFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.tools.a$a */
    /* loaded from: classes.dex */
    public class C2597a extends BroadcastReceiver {
        public C2597a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                String dataString = intent.getDataString();
                if (dataString.startsWith("package:")) {
                    dataString = dataString.replace("package:", "");
                }
                String[] strArr = ToolsFragment.this.f14966g;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (dataString.equals(strArr[i])) {
                        ToolsFragment.this.f14964e.sendEmptyMessage(0);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                String dataString2 = intent.getDataString();
                if (dataString2.startsWith("package:")) {
                    dataString2 = dataString2.replace("package:", "");
                }
                for (String str : ToolsFragment.this.f14966g) {
                    if (dataString2.equals(str)) {
                        ToolsFragment.this.f14964e.sendEmptyMessage(0);
                        return;
                    }
                }
            }
        }
    }
}
