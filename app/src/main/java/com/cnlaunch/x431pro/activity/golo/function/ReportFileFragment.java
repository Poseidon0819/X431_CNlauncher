package com.cnlaunch.x431pro.activity.golo.function;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.IMActivity;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p224a.FileListAdapter;
import com.cnlaunch.x431pro.module.golo.FileInfo;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.PdfSchema;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.golo.function.e */
/* loaded from: classes.dex */
public final class ReportFileFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private String f12619a;

    /* renamed from: c */
    private ListView f12621c;

    /* renamed from: e */
    private TextView f12623e;

    /* renamed from: b */
    private List<FileInfo> f12620b = null;

    /* renamed from: d */
    private FileListAdapter f12622d = null;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.my_report);
        this.f12623e = (TextView) getActivity().findViewById(R.id.title_path);
        this.f12619a = PathUtils.m4855d().replace("//", "/");
        this.f12621c = (ListView) getActivity().findViewById(R.id.list_report_file);
        this.f12621c.setOnItemClickListener(this);
        this.f12622d = new FileListAdapter(getActivity(), this.f12620b);
        this.f12621c.setAdapter((ListAdapter) this.f12622d);
        m6990a(this.f12619a);
    }

    /* renamed from: a */
    private void m6990a(String str) {
        this.f12623e.setText(str);
        this.f12620b = new ArrayList();
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            Log.e("Sanda", "Report File error:" + e.toString());
        }
        if (file.length() != 0) {
            File[] listFiles = file.listFiles();
            if (!str.equals(this.f12619a)) {
                this.f12620b.add(new FileInfo("root", this.f12619a, 0L));
                this.f12620b.add(new FileInfo("back", file.getParent(), 0L));
            }
            for (File file2 : listFiles) {
                String substring = file2.getName().substring(file2.getName().length() - 3, file2.getName().length());
                if (substring.equalsIgnoreCase("txt") || substring.equalsIgnoreCase("jpg") || substring.equalsIgnoreCase(PdfSchema.DEFAULT_XPATH_ID) || substring.equalsIgnoreCase("431")) {
                    this.f12620b.add(new FileInfo(file2.getName(), file2.getPath(), file2.lastModified()));
                }
            }
            this.f12622d.m7039a(this.f12620b);
            return;
        }
        NToast.m9450a(getActivity(), (int) R.string.no_car_report);
        getActivity().finish();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.golo_report_file, (ViewGroup) null);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        File file = new File(this.f12620b.get(i).getPath());
        if (file.isDirectory()) {
            m6990a(this.f12620b.get(i).getPath());
            return;
        }
        Intent intent = new Intent(getActivity(), IMActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Annotation.FILE, file.getPath());
        intent.putExtras(bundle);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }
}
