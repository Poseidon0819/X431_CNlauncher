package com.cnlaunch.x431pro.activity.golo.p224a;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.golo.FileInfo;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.golo.a.a */
/* loaded from: classes.dex */
public final class FileListAdapter extends BaseAdapter {

    /* renamed from: a */
    private LayoutInflater f12499a;

    /* renamed from: b */
    private List<FileInfo> f12500b;

    /* renamed from: c */
    private Context f12501c;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public FileListAdapter(Context context, List<FileInfo> list) {
        this.f12500b = null;
        this.f12500b = list;
        List<FileInfo> list2 = this.f12500b;
        if (list2 != null) {
            Collections.sort(list2, new C2222a());
        }
        this.f12501c = context;
        this.f12499a = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<FileInfo> list = this.f12500b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List<FileInfo> list = this.f12500b;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C2223b c2223b;
        if (view == null) {
            view = this.f12499a.inflate(R.layout.item_list_fileinfo, (ViewGroup) null);
            c2223b = new C2223b();
            c2223b.f12503a = (TextView) view.findViewById(R.id.text);
            c2223b.f12504b = (ImageView) view.findViewById(R.id.icon);
            view.setTag(c2223b);
        } else {
            c2223b = (C2223b) view.getTag();
        }
        File file = new File(this.f12500b.get(i).getPath());
        if (this.f12500b.get(i).getName().equals("root")) {
            c2223b.f12503a.setText(this.f12501c.getString(R.string.back_root));
            c2223b.f12504b.setImageResource(R.drawable.icon_file_root);
        } else if (this.f12500b.get(i).getName().equals("back")) {
            c2223b.f12503a.setText(this.f12501c.getString(R.string.back_upper));
            c2223b.f12504b.setImageResource(R.drawable.icon_file_back);
        } else {
            c2223b.f12503a.setText(file.getName());
            if (file.isDirectory()) {
                c2223b.f12504b.setImageResource(R.drawable.icon_file_directory);
            } else {
                try {
                    String lowerCase = file.getName().toLowerCase(Locale.getDefault());
                    if (!lowerCase.endsWith(".txt") && !lowerCase.endsWith(".doc") && !lowerCase.endsWith(".log")) {
                        if (!lowerCase.endsWith(".jpg") && !lowerCase.endsWith(".png") && !lowerCase.endsWith(".bmp")) {
                            if (lowerCase.endsWith(".x431")) {
                                c2223b.f12504b.setImageResource(R.drawable.icon_file_x431);
                            } else {
                                c2223b.f12504b.setImageResource(R.drawable.icon_file_other);
                            }
                        }
                        c2223b.f12504b.setImageResource(R.drawable.icon_file_img);
                    }
                    c2223b.f12504b.setImageResource(R.drawable.icon_file_txt);
                } catch (Exception e) {
                    Log.e("Sanda", "Error[0124]:" + e.toString());
                    c2223b.f12504b.setImageResource(R.drawable.icon_file_other);
                }
            }
        }
        if (i % 2 == 0) {
            view.setBackgroundColor(-1);
        } else {
            view.setBackgroundColor(Color.parseColor("#F2F2F2"));
        }
        return view;
    }

    /* renamed from: a */
    public final void m7039a(List<FileInfo> list) {
        this.f12500b = list;
        if (list != null) {
            Collections.sort(list, new C2222a());
        }
        notifyDataSetChanged();
    }

    /* compiled from: FileListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.a$b */
    /* loaded from: classes.dex */
    class C2223b {

        /* renamed from: a */
        TextView f12503a;

        /* renamed from: b */
        ImageView f12504b;

        C2223b() {
        }
    }

    /* compiled from: FileListAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.a.a$a */
    /* loaded from: classes.dex */
    class C2222a implements Comparator<FileInfo> {
        C2222a() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(FileInfo fileInfo, FileInfo fileInfo2) {
            FileInfo fileInfo3 = fileInfo;
            FileInfo fileInfo4 = fileInfo2;
            boolean before = new Date(fileInfo3.getCreated()).before(new Date(fileInfo4.getCreated()));
            return ((m7036c(fileInfo3) | (m7037b(fileInfo3) | m7038a(fileInfo3))) | (before ^ 1)) > ((m7036c(fileInfo4) | (m7037b(fileInfo4) | m7038a(fileInfo4))) | before) ? -1 : 1;
        }

        /* renamed from: a */
        private static int m7038a(FileInfo fileInfo) {
            return fileInfo.getName().equalsIgnoreCase("back") ? 8 : 0;
        }

        /* renamed from: b */
        private static int m7037b(FileInfo fileInfo) {
            return fileInfo.getName().equalsIgnoreCase("root") ? 4 : 0;
        }

        /* renamed from: c */
        private static int m7036c(FileInfo fileInfo) {
            return new File(fileInfo.getPath()).isDirectory() ? 2 : 0;
        }
    }
}
