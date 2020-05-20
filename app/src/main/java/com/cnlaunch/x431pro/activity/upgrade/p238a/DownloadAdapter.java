package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.DownloadFragment;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.e */
/* loaded from: classes.dex */
public final class DownloadAdapter extends BaseAdapter {

    /* renamed from: f */
    private static String f15004f = "/system/xbin/per-up";

    /* renamed from: a */
    public List<DownloadSoftDto> f15005a;

    /* renamed from: b */
    private Context f15006b;

    /* renamed from: c */
    private LayoutInflater f15007c;

    /* renamed from: d */
    private DownloadFragment f15008d;

    /* renamed from: e */
    private boolean f15009e;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public DownloadAdapter(Context context) {
        this.f15009e = false;
        this.f15006b = context;
        this.f15007c = LayoutInflater.from(this.f15006b);
        this.f15009e = m5811a();
    }

    public DownloadAdapter(Context context, DownloadFragment downloadFragment) {
        this.f15009e = false;
        this.f15006b = context;
        this.f15008d = downloadFragment;
        this.f15007c = LayoutInflater.from(this.f15006b);
        this.f15009e = m5811a();
    }

    /* renamed from: a */
    public static boolean m5811a() {
        Exception e;
        boolean z;
        try {
            z = new File(f15004f).exists();
            try {
                NLog.m9456a("DownloadAdapter", "isRoot = ".concat(String.valueOf(z)));
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        return z;
    }

    /* compiled from: DownloadAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.e$a */
    /* loaded from: classes.dex */
    class C2607a {

        /* renamed from: a */
        TextView f15010a;

        /* renamed from: b */
        TextView f15011b;

        /* renamed from: c */
        ProgressBar f15012c;

        /* renamed from: d */
        TextView f15013d;

        C2607a() {
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<DownloadSoftDto> list = this.f15005a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f15005a.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C2607a c2607a;
        DownloadSoftDto downloadSoftDto = (DownloadSoftDto) getItem(i);
        if (view == null) {
            c2607a = new C2607a();
            view2 = this.f15007c.inflate(R.layout.upgrade_download_item, (ViewGroup) null);
            c2607a.f15010a = (TextView) view2.findViewById(R.id.tv_name_item);
            c2607a.f15011b = (TextView) view2.findViewById(R.id.tv_version_item);
            c2607a.f15012c = (ProgressBar) view2.findViewById(R.id.pb_progress_item);
            c2607a.f15013d = (TextView) view2.findViewById(R.id.tv_state_item);
            view2.setTag(c2607a);
        } else {
            view2 = view;
            c2607a = (C2607a) view.getTag();
        }
        if (C2744aa.m5166c()) {
            c2607a.f15010a.setText(C2744aa.m5170b(this.f15006b, downloadSoftDto.f15575a));
        } else {
            c2607a.f15010a.setText(downloadSoftDto.f15575a);
        }
        c2607a.f15011b.setText(downloadSoftDto.f15576b);
        c2607a.f15012c.setProgress(downloadSoftDto.f15578d);
        if ((1 == downloadSoftDto.f15577c && 2 == downloadSoftDto.f15579e.intValue() && !this.f15009e && !C2744aa.m5132n(this.f15006b)) || (!C1621v.m9121a(downloadSoftDto.f15589o) && C2744aa.m5163c(this.f15006b, downloadSoftDto.f15589o))) {
            NLog.m9456a("DownloadAdapter", "getView, position2: " + i + ", name:" + downloadSoftDto.f15575a);
            c2607a.f15013d.setBackgroundResource(R.drawable.textview_red_bg);
            c2607a.f15013d.setTextColor(Color.rgb(255, 0, 0));
            c2607a.f15013d.setOnClickListener(new View$OnClickListenerC2608f(this, downloadSoftDto));
        } else {
            c2607a.f15013d.setBackgroundResource(0);
            c2607a.f15013d.setPadding(0, 0, 0, 0);
            c2607a.f15013d.setTextColor(this.f15006b.getResources().getColor(R.color.grey_3d3d3d));
            c2607a.f15013d.setOnClickListener(null);
        }
        if (3 == downloadSoftDto.f15579e.intValue() || 5 == downloadSoftDto.f15579e.intValue() || 7 == downloadSoftDto.f15579e.intValue()) {
            if (this.f15006b.getResources().getDrawable(R.drawable.layer_progress_gray) != c2607a.f15012c.getProgressDrawable()) {
                c2607a.f15012c.setProgressDrawable(this.f15006b.getResources().getDrawable(R.drawable.layer_progress_gray));
            }
        } else if (this.f15006b.getResources().getDrawable(R.drawable.layer_progress_yellow) != c2607a.f15012c.getProgressDrawable()) {
            c2607a.f15012c.setProgressDrawable(this.f15006b.getResources().getDrawable(R.drawable.layer_progress_yellow));
        }
        switch (downloadSoftDto.f15579e.intValue()) {
            case 0:
                c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_0));
                break;
            case 1:
                c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_1));
                break;
            case 2:
                if ((1 == downloadSoftDto.f15577c && !this.f15009e && !C2744aa.m5132n(this.f15006b)) || (!C1621v.m9121a(downloadSoftDto.f15589o) && C2744aa.m5163c(this.f15006b, downloadSoftDto.f15589o))) {
                    c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_6));
                    DownloadFragment downloadFragment = this.f15008d;
                    if (downloadFragment != null) {
                        downloadFragment.m5544a(false);
                        break;
                    }
                } else {
                    c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_2));
                    break;
                }
                break;
            case 3:
                c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_3));
                DownloadFragment downloadFragment2 = this.f15008d;
                if (downloadFragment2 != null) {
                    downloadFragment2.m5544a(true);
                    break;
                }
                break;
            case 4:
                c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_4));
                break;
            case 5:
                c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_5));
                DownloadFragment downloadFragment3 = this.f15008d;
                if (downloadFragment3 != null) {
                    downloadFragment3.m5544a(true);
                    break;
                }
                break;
            case 6:
                c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_7));
                break;
            case 7:
                c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_8));
                break;
            case 9:
                c2607a.f15013d.setText(this.f15006b.getString(R.string.down_state_9));
                break;
        }
        return view2;
    }
}
