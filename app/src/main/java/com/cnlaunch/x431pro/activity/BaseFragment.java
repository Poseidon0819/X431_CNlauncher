package com.cnlaunch.x431pro.activity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.ActivityPageManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.BaseAsyncTask;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.ifoer.expedition.pro.R;
import java.lang.ref.WeakReference;
import java.util.Map;

@SuppressLint({"NewApi"})
/* renamed from: com.cnlaunch.x431pro.activity.j */
/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment implements OnDataListener {
    public TextView btn_left;
    protected TextView btn_right;
    public Bundle bundle;
    public FragmentManager fragmentManager;
    private AsyncTaskManager mAsyncTaskManager;
    public View mContentView;
    public Context mContext;
    public MainActivity mainActivity;
    protected TextView menuUpdateTip;
    protected RadioGroup radioGroup_head;
    public ClearEditText searchInputCars;
    protected TextView textVinScan;
    protected TextView tv_title;

    public Object doInBackground(int i) throws C1425f {
        return null;
    }

    public boolean isSuccess(int i) {
        return i == 0;
    }

    public abstract View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onSelectReportFormatBack() {
    }

    public void onSelectReportFormatBack(String str) {
    }

    public void onSuccess(int i, Object obj) {
    }

    public void showInputReportDialog(int i) {
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mContentView = onCreateFragmentView(layoutInflater, viewGroup, bundle);
        return this.mContentView;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ActivityPageManager.m9631a(this.mContentView);
        this.mContentView = null;
    }

    public void request(int i) {
        request(i, true);
    }

    public void request(int i, boolean z) {
        this.mAsyncTaskManager.m9575a(i, z, this);
    }

    public void cancelRequest(int i) {
        AsyncTaskManager.m9576a(i);
    }

    public void onFailure(int i, int i2, Object obj) {
        Context context;
        if (i2 == -999) {
            Context context2 = this.mContext;
            if (context2 != null) {
                NToast.m9450a(context2, (int) R.string.common_network_error);
            }
        } else if (i2 != -400) {
            if (i2 == -200 && (context = this.mContext) != null) {
                NToast.m9450a(context, (int) R.string.common_network_error);
            }
        } else {
            Context context3 = this.mContext;
            if (context3 != null) {
                NToast.m9450a(context3, (int) R.string.common_network_unavailable);
            }
        }
    }

    public void setTitle(int i) {
        this.tv_title.setText(i);
    }

    public void setTitle(String str) {
        this.tv_title.setText(str);
    }

    public void setLeftImage(Drawable drawable) {
        if (LangManager.m9466b().equalsIgnoreCase("CN")) {
            return;
        }
        this.btn_left.setBackgroundDrawable(drawable);
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void replaceFragment(String str) {
        replaceFragment(str, new Bundle());
    }

    public void replaceFragment(String str, Bundle bundle) {
        Fragment findFragmentByTag = this.fragmentManager.findFragmentByTag(str);
        NLog.m9452b("BaseFragment", "Fragment Tag=".concat(String.valueOf(str)));
        if (findFragmentByTag == null) {
            findFragmentByTag = Fragment.instantiate(this.mContext, str);
            NLog.m9452b("BaseFragment", "Fragment is not find");
        } else {
            NLog.m9452b("BaseFragment", "Fragment is  find");
        }
        ((BaseFragment) findFragmentByTag).setBundle(bundle);
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, findFragmentByTag, str);
        beginTransaction.addToBackStack(str);
        beginTransaction.commitAllowingStateLoss();
    }

    public void deleteAndAddFragment(String str, Bundle bundle) {
        Fragment instantiate;
        Fragment findFragmentByTag = this.fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag == null) {
            instantiate = Fragment.instantiate(this.mContext, str);
        } else {
            getFragmentManager().beginTransaction().detach(findFragmentByTag).commitAllowingStateLoss();
            instantiate = Fragment.instantiate(this.mContext, str);
        }
        ((BaseFragment) instantiate).setBundle(bundle);
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, instantiate, str);
        beginTransaction.commitAllowingStateLoss();
    }

    public void replaceFragment(String str, Bundle bundle, int i) {
        Fragment findFragmentByTag = this.fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag == null) {
            findFragmentByTag = Fragment.instantiate(this.mContext, str);
        }
        ((BaseFragment) findFragmentByTag).setBundle(bundle);
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, findFragmentByTag, str);
        beginTransaction.addToBackStack(str);
        beginTransaction.commit();
    }

    public void replaceFragment(String str, int i) {
        replaceFragment(str, new Bundle(), i);
    }

    public void replaceFragment(String str, Bundle bundle, boolean z) {
        Fragment findFragmentByTag = this.fragmentManager.findFragmentByTag(str);
        NLog.m9452b("BaseFragment", "Fragment Tag=".concat(String.valueOf(str)));
        if (findFragmentByTag == null) {
            findFragmentByTag = Fragment.instantiate(this.mContext, str);
            NLog.m9452b("BaseFragment", "Fragment is not find");
        } else {
            NLog.m9452b("BaseFragment", "Fragment is  find");
        }
        ((BaseFragment) findFragmentByTag).setBundle(bundle);
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, findFragmentByTag, str);
        if (z) {
            beginTransaction.addToBackStack(str);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void replaceFragment(String str, int i, boolean z) {
        replaceFragment(str, new Bundle(), i, z);
    }

    public void addFragment(String str) {
        addFragment(str, new Bundle());
    }

    public void addFragment(String str, Bundle bundle) {
        Fragment instantiate = Fragment.instantiate(this.mContext, str);
        ((BaseFragment) instantiate).setBundle(bundle);
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, instantiate, str);
        beginTransaction.addToBackStack(str);
        beginTransaction.commit();
    }

    public void popBackStack() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            try {
                fragmentManager.popBackStackImmediate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void replaceFragment(String str, Bundle bundle, int i, boolean z) {
        Fragment findFragmentByTag = this.fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag == null) {
            findFragmentByTag = Fragment.instantiate(this.mContext, str);
        }
        ((BaseFragment) findFragmentByTag).setBundle(bundle);
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, findFragmentByTag, str);
        if (z) {
            beginTransaction.addToBackStack(str);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.mContext = getActivity();
        this.mainActivity = (MainActivity) getActivity().getParent();
        this.radioGroup_head = (RadioGroup) getActivity().findViewById(R.id.radioGroup_head);
        this.btn_left = (TextView) getActivity().findViewById(R.id.btn_left);
        this.menuUpdateTip = (TextView) getActivity().findViewById(R.id.menu_update_tip);
        this.btn_right = (TextView) getActivity().findViewById(R.id.btn_right);
        this.tv_title = (TextView) getActivity().findViewById(R.id.tv_title);
        this.mAsyncTaskManager = AsyncTaskManager.m9574a(this.mContext);
        this.fragmentManager = getActivity().getFragmentManager();
        this.textVinScan = (TextView) getActivity().findViewById(R.id.vinscan_list);
        TextView textView = this.textVinScan;
        if (textView != null) {
            textView.setVisibility(8);
            if (LangManager.m9466b().equalsIgnoreCase("CN")) {
                this.textVinScan.getPaint().setFlags(8);
            }
        }
        this.searchInputCars = (ClearEditText) getActivity().findViewById(R.id.edit_search_cars);
        super.onActivityCreated(bundle);
    }

    public void setMenuUpdateVisibility(int i) {
        ((ActivityC2004c) getActivity()).m7735e(i);
    }

    public void cancelRequest() {
        if (AsyncTaskManager.f7035b != null) {
            for (Map.Entry<Integer, WeakReference<BaseAsyncTask>> entry : AsyncTaskManager.f7035b.entrySet()) {
                AsyncTaskManager.m9576a(entry.getKey().intValue());
            }
            AsyncTaskManager.f7035b.clear();
        }
    }
}
