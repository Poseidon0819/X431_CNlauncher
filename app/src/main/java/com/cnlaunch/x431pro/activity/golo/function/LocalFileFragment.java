package com.cnlaunch.x431pro.activity.golo.function;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p224a.FileListAdapter;
import com.cnlaunch.x431pro.module.golo.FileInfo;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.activity.golo.function.d */
/* loaded from: classes.dex */
public final class LocalFileFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private String f12614a;

    /* renamed from: c */
    private ListView f12616c;

    /* renamed from: e */
    private TextView f12618e;

    /* renamed from: b */
    private List<FileInfo> f12615b = null;

    /* renamed from: d */
    private FileListAdapter f12617d = null;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12618e = (TextView) getActivity().findViewById(R.id.title_path);
        this.f12614a = m6992a();
        this.f12616c = (ListView) getActivity().findViewById(R.id.list_report_file);
        this.f12616c.setOnItemClickListener(this);
        this.f12617d = new FileListAdapter(getActivity(), this.f12615b);
        this.f12616c.setAdapter((ListAdapter) this.f12617d);
        m6991a(this.f12614a);
        setTitle(R.string.sendFile);
    }

    /* renamed from: a */
    private void m6991a(String str) {
        try {
            this.f12618e.setText(str);
            this.f12615b = new ArrayList();
            File file = new File(str);
            File[] listFiles = file.listFiles();
            if (!str.equals(this.f12614a)) {
                this.f12615b.add(new FileInfo("root", this.f12614a, 0L));
                this.f12615b.add(new FileInfo("back", file.getParent(), 0L));
            }
            for (File file2 : listFiles) {
                if (!file2.getName().equals(".android_secure") && !file2.getName().equals(".thumbnails")) {
                    this.f12615b.add(new FileInfo(file2.getName(), file2.getPath(), file2.lastModified()));
                }
            }
            this.f12617d.m7039a(this.f12615b);
        } catch (Exception e) {
            Log.e("Sanda", "File Error:" + e.toString());
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            File file = new File(this.f12615b.get(i).getPath());
            if (file.isDirectory()) {
                m6991a(this.f12615b.get(i).getPath());
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(Annotation.FILE, file.getPath());
            intent.putExtras(bundle);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        } catch (Exception e) {
            Log.e("Sanda", "File e:" + e.toString());
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m6992a() {
        Log.i("FolderActivity", "getSDDir");
        if (!Environment.getExternalStorageState().equals("mounted")) {
            NToast.m9449a(getActivity(), "no sdcard");
            return "";
        }
        try {
            return Environment.getExternalStorageDirectory().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.golo_report_file, (ViewGroup) null);
    }
}
