package com.cnlaunch.x431pro.activity.help;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cnlaunch.diagnosemodule.utils.SystemAppTools;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.info.PdfViewFragment;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.help.h */
/* loaded from: classes.dex */
public class HelpFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: c */
    Button f12782c;

    /* renamed from: d */
    Button f12783d;

    /* renamed from: e */
    ListView f12784e;

    /* renamed from: g */
    Button f12786g;

    /* renamed from: h */
    Button f12787h;

    /* renamed from: i */
    private HelpDocManger f12788i;

    /* renamed from: j */
    private HandlerC2258a f12789j;

    /* renamed from: a */
    FunctionListAdapter f12780a = null;

    /* renamed from: b */
    FAQlistAdapter f12781b = null;

    /* renamed from: f */
    String f12785f = "";

    /* renamed from: k */
    private boolean f12790k = false;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_quick_smart) {
            try {
                String m6911b = m6911b(HelpStringConstant.f12808i);
                if (m6911b.equals("")) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("file_path", m6911b);
                replaceFragment(PdfViewFragment.class.getName(), bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (id != R.id.btn_user_manual) {
            if (id == R.id.common_question_answer) {
                m6913a(HelpStringConstant.f12811l);
            } else if (id != R.id.function_display) {
            } else {
                m6913a(HelpStringConstant.f12812m);
            }
        } else {
            try {
                String m6911b2 = m6911b(HelpStringConstant.f12809j);
                if (m6911b2.equals("")) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("file_path", m6911b2);
                replaceFragment(PdfViewFragment.class.getName(), bundle2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.tab_menu_help);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f12782c = (Button) getActivity().findViewById(R.id.function_display);
        this.f12782c.setOnClickListener(this);
        this.f12783d = (Button) getActivity().findViewById(R.id.common_question_answer);
        this.f12783d.setOnClickListener(this);
        this.f12786g = (Button) getActivity().findViewById(R.id.btn_quick_smart);
        this.f12786g.setOnClickListener(this);
        this.f12787h = (Button) getActivity().findViewById(R.id.btn_user_manual);
        this.f12787h.setOnClickListener(this);
        this.f12784e = (ListView) getActivity().findViewById(R.id.help_module_list);
        this.f12784e.setDivider(null);
        ArrayList arrayList = new ArrayList();
        if (!SystemAppTools.getAppsIsExist(getActivity(), "com.cnlaunch.batterytest")) {
            arrayList.add("batterytest");
        } else {
            this.f12790k = true;
        }
        if (!SystemAppTools.getAppsIsExist(getActivity(), "com.cnlaunch.sensor")) {
            arrayList.add("sensor");
            arrayList.add("multimeter");
        } else {
            this.f12790k = true;
        }
        if (!SystemAppTools.getAppsIsExist(getActivity(), "com.cnlaunch.oscilloscope")) {
            arrayList.add("oscilloscope");
        } else {
            this.f12790k = true;
        }
        if (!SystemAppTools.getAppsIsExist(getActivity(), "com.cnlaunch.ignition")) {
            arrayList.add("ignition");
        } else {
            this.f12790k = true;
        }
        this.f12790k = false;
        this.f12789j = new HandlerC2258a(this, (byte) 0);
        if (this.f12790k) {
            this.f12788i = new HelpDocManger(getActivity().getAssets(), HelpStringConstant.f12806g, Locale.getDefault().getLanguage(), arrayList);
            this.f12788i.m6924a(this.f12789j);
            this.f12788i.m6922a(HelpStringConstant.f12807h);
            this.f12780a = new FunctionListAdapter(getActivity().getApplicationContext(), getActivity().getAssets(), getActivity().getLayoutInflater());
            this.f12780a.f12751h = this.f12789j;
        } else {
            this.f12788i = new HelpDocManger(getActivity().getAssets(), HelpStringConstant.f12807h, Locale.getDefault().getLanguage());
            this.f12788i.m6924a(this.f12789j);
        }
        this.f12781b = new FAQlistAdapter(getActivity().getApplicationContext(), getActivity().getAssets(), getActivity().getLayoutInflater());
        this.f12781b.f12736h = this.f12789j;
        if (this.f12790k) {
            getActivity().findViewById(R.id.helpTableLayout);
            this.f12782c.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) this.f12783d.getLayoutParams()).setMargins(5, 0, 0, 0);
            this.f12783d.requestLayout();
            m6913a(HelpStringConstant.f12812m);
            return;
        }
        m6913a(HelpStringConstant.f12811l);
    }

    /* renamed from: a */
    private void m6913a(String str) {
        if (str.equals(HelpStringConstant.f12812m)) {
            this.f12785f = HelpOperatInfo.m6910a(HelpStringConstant.f12812m);
            FunctionListAdapter functionListAdapter = this.f12780a;
            functionListAdapter.f12750g = this.f12785f;
            this.f12784e.setAdapter((ListAdapter) functionListAdapter);
            m6912b();
        } else if (str.equals(HelpStringConstant.f12811l)) {
            this.f12785f = HelpOperatInfo.m6910a(HelpStringConstant.f12811l);
            FAQlistAdapter fAQlistAdapter = this.f12781b;
            fAQlistAdapter.f12735g = this.f12785f;
            this.f12784e.setAdapter((ListAdapter) fAQlistAdapter);
            m6914a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.help_fragment, viewGroup, false);
    }

    /* compiled from: HelpFragment.java */
    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.cnlaunch.x431pro.activity.help.h$a */
    /* loaded from: classes.dex */
    class HandlerC2258a extends Handler {
        private HandlerC2258a() {
        }

        /* synthetic */ HandlerC2258a(HelpFragment helpFragment, byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            super.handleMessage(message2);
            if (message2.what == 0) {
                ArrayList parcelableArrayList = message2.getData().getParcelableArrayList(HelpStringConstant.f12803d);
                HelpFragment helpFragment = HelpFragment.this;
                FunctionListAdapter functionListAdapter = helpFragment.f12780a;
                for (int i = 0; i < parcelableArrayList.size(); i++) {
                    String str = ((HelpFileInfo) parcelableArrayList.get(i)).f12718a;
                    if (!functionListAdapter.f12752i.containsKey(str)) {
                        ArrayList<HelpFileInfo> arrayList = new ArrayList<>();
                        arrayList.add((HelpFileInfo) parcelableArrayList.get(i));
                        functionListAdapter.f12752i.put(str, arrayList);
                    } else {
                        functionListAdapter.f12752i.get(str).add((HelpFileInfo) parcelableArrayList.get(i));
                    }
                }
                functionListAdapter.f12744a = functionListAdapter.f12752i.size();
                helpFragment.f12780a.notifyDataSetChanged();
            } else if (message2.what == 3) {
                HelpFragment helpFragment2 = HelpFragment.this;
                Bundle data = message2.getData();
                Intent intent = new Intent();
                intent.putExtras(data);
                intent.setClass(helpFragment2.getActivity(), HelpShowFileActivity.class);
                helpFragment2.startActivity(intent);
            } else if (message2.what == 2) {
                ArrayList<? extends Parcelable> parcelableArrayList2 = message2.getData().getParcelableArrayList(HelpStringConstant.f12805f);
                HelpFragment helpFragment3 = HelpFragment.this;
                FAQlistAdapter fAQlistAdapter = helpFragment3.f12781b;
                fAQlistAdapter.f12739k = parcelableArrayList2;
                fAQlistAdapter.f12729a = 1;
                helpFragment3.f12781b.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: a */
    private void m6914a() {
        this.f12782c.setBackgroundResource(R.drawable.help_btn_common);
        this.f12782c.setTextColor(-16777216);
        this.f12783d.setBackgroundResource(R.drawable.help_btn_choiced);
        this.f12783d.setTextColor(-1);
        this.f12786g.setBackgroundResource(R.drawable.help_btn_common);
        this.f12787h.setBackgroundResource(R.drawable.help_btn_common);
    }

    /* renamed from: b */
    private void m6912b() {
        this.f12782c.setBackgroundResource(R.drawable.help_btn_choiced);
        this.f12782c.setTextColor(-1);
        this.f12783d.setBackgroundResource(R.drawable.help_btn_common);
        this.f12783d.setTextColor(-16777216);
        this.f12786g.setBackgroundResource(R.drawable.help_btn_common);
        this.f12787h.setBackgroundResource(R.drawable.help_btn_common);
    }

    /* renamed from: b */
    private String m6911b(String str) {
        String language = Locale.getDefault().getLanguage();
        if (language.equals("zh")) {
            language = "cn";
        }
        String str2 = PathUtils.m4870a(getActivity()) + (str + language + ".pdf");
        if (new File(str2).exists()) {
            return str2;
        }
        String str3 = PathUtils.m4870a(getActivity()) + str + "en.pdf";
        return new File(str3).exists() ? str3 : "";
    }
}
