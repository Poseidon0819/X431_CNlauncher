package com.cnlaunch.golo3.view.selectimg.p166a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.p012v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cnlaunch.golo3.p154a.C1551a;
import com.cnlaunch.p132e.p133a.C1464a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.cnlaunch.golo3.view.selectimg.a.d */
/* loaded from: classes.dex */
public final class PhotoFolderFragment extends Fragment {

    /* renamed from: a */
    C1551a f8587a;

    /* renamed from: b */
    private InterfaceC1628b f8588b;

    /* renamed from: c */
    private ListView f8589c;

    /* renamed from: d */
    private ContentResolver f8590d;

    /* renamed from: e */
    private List<AlbumInfo> f8591e = new ArrayList();

    /* renamed from: f */
    private PhotoFolderAdapter f8592f;

    /* renamed from: g */
    private LinearLayout f8593g;

    /* renamed from: h */
    private Context f8594h;

    /* compiled from: PhotoFolderFragment.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.a.d$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1628b {
        /* renamed from: a */
        void mo9068a(List<PhotoInfo> list);
    }

    @Override // android.support.p012v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.f8588b == null) {
            this.f8588b = (InterfaceC1628b) activity;
        }
    }

    @Override // android.support.p012v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.p012v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C1464a.C1469e.fragment_photofolder, viewGroup, false);
    }

    @Override // android.support.p012v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f8589c = (ListView) getView().findViewById(C1464a.C1468d.listView);
        this.f8593g = (LinearLayout) getView().findViewById(C1464a.C1468d.loadingLay);
        this.f8594h = getActivity().getApplicationContext();
        this.f8590d = this.f8594h.getContentResolver();
        this.f8591e.clear();
        new AsyncTaskC1627a(this, (byte) 0).execute(new Void[0]);
        this.f8589c.setOnItemClickListener(new C1629e(this));
    }

    /* compiled from: PhotoFolderFragment.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.a.d$a */
    /* loaded from: classes.dex */
    class AsyncTaskC1627a extends AsyncTask<Void, Void, Object> {
        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
        }

        private AsyncTaskC1627a() {
        }

        /* synthetic */ AsyncTaskC1627a(PhotoFolderFragment photoFolderFragment, byte b) {
            this();
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            PhotoFolderFragment.this.f8593g.setVisibility(8);
            if (PhotoFolderFragment.this.getActivity() != null) {
                PhotoFolderFragment photoFolderFragment = PhotoFolderFragment.this;
                photoFolderFragment.f8587a = new C1551a(photoFolderFragment.getActivity());
                PhotoFolderFragment photoFolderFragment2 = PhotoFolderFragment.this;
                photoFolderFragment2.f8592f = new PhotoFolderAdapter(photoFolderFragment2.getActivity(), PhotoFolderFragment.this.f8591e, PhotoFolderFragment.this.f8587a);
                PhotoFolderFragment.this.f8589c.setAdapter((ListAdapter) PhotoFolderFragment.this.f8592f);
            }
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Object doInBackground(Void[] voidArr) {
            Cursor query;
            ThumbnailsUtil.m9063a();
            Cursor query2 = PhotoFolderFragment.this.f8590d.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"image_id", "_data"}, null, null, null);
            if (query2 == null || !query2.moveToFirst()) {
                query = PhotoFolderFragment.this.f8590d.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_modified DESC");
                HashMap hashMap = new HashMap();
                if (query == null && query.moveToFirst()) {
                    do {
                        int i = query.getInt(query.getColumnIndex("_id"));
                        String string = query.getString(query.getColumnIndex("_data"));
                        String string2 = query.getString(query.getColumnIndex("bucket_display_name"));
                        ArrayList arrayList = new ArrayList();
                        PhotoInfo photoInfo = new PhotoInfo();
                        if (hashMap.containsKey(string2)) {
                            AlbumInfo albumInfo = (AlbumInfo) hashMap.remove(string2);
                            int indexOf = PhotoFolderFragment.this.f8591e.contains(albumInfo) ? PhotoFolderFragment.this.f8591e.indexOf(albumInfo) : 0;
                            photoInfo.setImage_id(i);
                            photoInfo.setPath_file("file://".concat(String.valueOf(string)));
                            photoInfo.setPath_absolute(string);
                            albumInfo.getList().add(photoInfo);
                            PhotoFolderFragment.this.f8591e.set(indexOf, albumInfo);
                            hashMap.put(string2, albumInfo);
                        } else {
                            AlbumInfo albumInfo2 = new AlbumInfo();
                            arrayList.clear();
                            photoInfo.setImage_id(i);
                            photoInfo.setPath_file("file://".concat(String.valueOf(string)));
                            photoInfo.setPath_absolute(string);
                            arrayList.add(photoInfo);
                            albumInfo2.setImage_id(i);
                            albumInfo2.setPath_file("file://".concat(String.valueOf(string)));
                            albumInfo2.setPath_absolute(string);
                            albumInfo2.setName_album(string2);
                            albumInfo2.setList(arrayList);
                            PhotoFolderFragment.this.f8591e.add(albumInfo2);
                            hashMap.put(string2, albumInfo2);
                        }
                    } while (query.moveToNext());
                    return null;
                }
            }
            int columnIndex = query2.getColumnIndex("image_id");
            int columnIndex2 = query2.getColumnIndex("_data");
            do {
                ThumbnailsUtil.m9061a(Integer.valueOf(query2.getInt(columnIndex)), "file://".concat(String.valueOf(query2.getString(columnIndex2))));
            } while (query2.moveToNext());
            query = PhotoFolderFragment.this.f8590d.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_modified DESC");
            HashMap hashMap2 = new HashMap();
            return query == null ? null : null;
        }
    }

    @Override // android.support.p012v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        List<AlbumInfo> list = this.f8591e;
        if (list != null) {
            list.clear();
        }
        C1551a c1551a = this.f8587a;
        if (c1551a != null) {
            c1551a.m9257a();
            this.f8587a.m9253b();
            this.f8587a = null;
        }
    }
}
