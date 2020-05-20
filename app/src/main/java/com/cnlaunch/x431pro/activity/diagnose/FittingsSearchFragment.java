package com.cnlaunch.x431pro.activity.diagnose;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p223f.CanRemoveEdit;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bm */
/* loaded from: classes.dex */
public final class FittingsSearchFragment extends BaseFragment {

    /* renamed from: b */
    private LinearLayout f11556b;

    /* renamed from: c */
    private Button f11557c;

    /* renamed from: d */
    private Drawable f11558d;

    /* renamed from: e */
    private Handler f11559e;

    /* renamed from: a */
    private List<String> f11555a = new ArrayList();

    /* renamed from: f */
    private final int f11560f = 123123;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_fittingssearch, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.fittings_search);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f11555a = arguments.getStringArrayList("fittingsearchkey");
        }
        this.f11556b = (LinearLayout) getActivity().findViewById(R.id.keys_layout);
        this.f11557c = (Button) getActivity().findViewById(R.id.fitting_search_ok);
        this.f11558d = getResources().getDrawable(R.drawable.fittingsearch_edit_clear);
        this.f11559e = new HandlerC2079bn(this);
        this.f11557c.setOnClickListener(new View$OnClickListenerC2080bo(this));
        m7467a();
    }

    /* renamed from: a */
    public final void m7467a() {
        this.f11556b.removeAllViews();
        for (int i = 0; i < this.f11555a.size(); i++) {
            CanRemoveEdit canRemoveEdit = new CanRemoveEdit(getActivity());
            canRemoveEdit.setText(this.f11555a.get(i).toString() + "  ");
            canRemoveEdit.clearFocus();
            canRemoveEdit.setTextSize(18.0f);
            canRemoveEdit.f12437a = this.f11559e;
            canRemoveEdit.setTag(Integer.valueOf(i));
            canRemoveEdit.setCursorVisible(true);
            canRemoveEdit.setInputType(524288);
            canRemoveEdit.setBackgroundResource(0);
            Drawable drawable = this.f11558d;
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.f11558d.getMinimumHeight());
            canRemoveEdit.setCompoundDrawables(null, null, this.f11558d, null);
            this.f11556b.addView(canRemoveEdit);
        }
    }
}
