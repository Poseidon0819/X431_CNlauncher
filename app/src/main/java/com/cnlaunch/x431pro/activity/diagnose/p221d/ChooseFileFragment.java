package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.golo.p224a.FileListAdapter;
import com.cnlaunch.x431pro.module.golo.FileInfo;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.p */
/* loaded from: classes.dex */
public final class ChooseFileFragment extends BaseDiagnoseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private String f12366a;

    /* renamed from: b */
    private String f12367b;

    /* renamed from: k */
    private ListView f12369k;

    /* renamed from: m */
    private TextView f12371m;

    /* renamed from: n */
    private Button f12372n;

    /* renamed from: o */
    private Button f12373o;

    /* renamed from: j */
    private List<FileInfo> f12368j = null;

    /* renamed from: l */
    private FileListAdapter f12370l = null;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT >= 28) {
            this.f12366a = Environment.getExternalStorageDirectory().getPath();
        } else {
            this.f12366a = "/";
        }
        this.f12367b = "/";
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("defPath") && !TextUtils.isEmpty(arguments.getString("defPath"))) {
            this.f12367b = arguments.getString("defPath");
        }
        if (TextUtils.isEmpty(this.f12367b)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f12367b = Environment.getExternalStorageDirectory().getPath();
            } else {
                this.f12367b = "/";
            }
        }
        if (Build.VERSION.SDK_INT < 28 || !this.f12367b.equals("/")) {
            return;
        }
        this.f12367b = Environment.getExternalStorageDirectory().getPath();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12371m = (TextView) getActivity().findViewById(R.id.title_path);
        this.f12372n = (Button) getActivity().findViewById(R.id.btn_confirm);
        this.f12373o = (Button) getActivity().findViewById(R.id.btn_cancel);
        setTitle(R.string.selectLocalFile);
        this.f12372n.setOnClickListener(new View$OnClickListenerC2178q(this));
        this.f12373o.setOnClickListener(new View$OnClickListenerC2179r(this));
        this.f12369k = (ListView) getActivity().findViewById(R.id.list_report_file);
        this.f12369k.setOnItemClickListener(this);
        this.f12370l = new FileListAdapter(getActivity(), this.f12368j);
        this.f12369k.setAdapter((ListAdapter) this.f12370l);
        m7114b(this.f12367b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7114b(String str) {
        try {
            this.f12371m.setText(str);
            this.f12368j = new ArrayList();
            File file = new File(str);
            File[] listFiles = file.listFiles();
            if (!str.equals(this.f12366a)) {
                this.f12368j.add(new FileInfo("root", this.f12366a, 0L));
                this.f12368j.add(new FileInfo("back", file.getParent(), 0L));
            }
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    this.f12368j.add(new FileInfo(file2.getName(), file2.getPath(), file2.lastModified()));
                }
            }
            this.f12370l.m7039a(this.f12368j);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            Log.e("Sanda", "File Error:" + e2.toString());
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            File file = new File(this.f12368j.get(i).getPath());
            if (file.isDirectory()) {
                if (file.getName().equals(".android_secure")) {
                    return;
                }
                m7114b(this.f12368j.get(i).getPath());
                return;
            }
            this.f12371m.setText(file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            String charSequence = this.f12371m.getText().toString();
            if (charSequence.equals(this.f12366a)) {
                new C2180s(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.exit_choose_file, true);
            } else {
                m7114b(new File(charSequence).getParent());
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.choose_file, (ViewGroup) null);
    }
}
