package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.mine.p229a.AreaAdapter;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.City;
import com.cnlaunch.x431pro.module.p272k.p274b.CityListResponse;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.sortlistview.CharacterParser;
import com.cnlaunch.x431pro.widget.sortlistview.PinyinComparator;
import com.cnlaunch.x431pro.widget.sortlistview.SideBar;
import com.cnlaunch.x431pro.widget.sortlistview.SortModel;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.mine.p */
/* loaded from: classes.dex */
public class CityFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: c */
    private UserAction f14266c;

    /* renamed from: d */
    private ListView f14267d;

    /* renamed from: e */
    private SideBar f14268e;

    /* renamed from: f */
    private ClearEditText f14269f;

    /* renamed from: g */
    private Button f14270g;

    /* renamed from: h */
    private ArrayList<City> f14271h;

    /* renamed from: i */
    private PinyinComparator f14272i;

    /* renamed from: j */
    private CharacterParser f14273j;

    /* renamed from: k */
    private AreaAdapter f14274k;

    /* renamed from: l */
    private List<SortModel> f14275l;

    /* renamed from: m */
    private String f14276m;

    /* renamed from: n */
    private String f14277n;

    /* renamed from: o */
    private String f14278o;

    /* renamed from: a */
    private final int f14264a = 2110;

    /* renamed from: b */
    private final int f14265b = 2111;

    /* renamed from: p */
    private SideBar.InterfaceC2960a f14279p = new C2492q(this);

    /* renamed from: q */
    private TextWatcher f14280q = new C2493r(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f14266c = new UserAction(this.mContext);
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f14276m = (String) bundle2.get("ncode");
            this.f14277n = (String) bundle2.get("pcode");
        }
        setTitle(R.string.mine_tv_city);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14273j = CharacterParser.m4391a();
        this.f14272i = new PinyinComparator();
        this.f14267d = (ListView) getActivity().findViewById(R.id.lv_area);
        this.f14267d.setOnItemClickListener(this);
        this.f14269f = (ClearEditText) getActivity().findViewById(R.id.edit_search_country);
        this.f14269f.addTextChangedListener(this.f14280q);
        this.f14268e = (SideBar) getActivity().findViewById(R.id.sidebar);
        this.f14268e.setOnTouchingLetterChangedListener(this.f14279p);
        this.f14270g = (Button) getActivity().findViewById(R.id.btn_cancel);
        this.f14270g.setOnClickListener(this);
        LoadDialog.m4686a(this.mContext);
        request(2110);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_arealist, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2110:
                return this.f14266c.m5251f(LangManager.m9469a(), this.f14277n);
            case 2111:
                return this.f14266c.m5260b(this.f14276m, this.f14277n, this.f14278o);
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        int i2 = 0;
        switch (i) {
            case 2110:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    CityListResponse cityListResponse = (CityListResponse) obj;
                    if (isSuccess(cityListResponse.getCode())) {
                        this.f14271h = (ArrayList) cityListResponse.getData();
                        ArrayList<City> arrayList = this.f14271h;
                        ArrayList arrayList2 = new ArrayList();
                        if (arrayList != null) {
                            while (i2 < arrayList.size()) {
                                arrayList2.add(arrayList.get(i2).getDisplay());
                                i2++;
                            }
                        }
                        this.f14275l = m6109a(arrayList2);
                        Collections.sort(this.f14275l, this.f14272i);
                        this.f14274k = new AreaAdapter(this.mContext, this.f14275l);
                        this.f14267d.setAdapter((ListAdapter) this.f14274k);
                        return;
                    }
                    return;
                }
                return;
            case 2111:
                break;
            default:
                return;
        }
        while (i2 < getFragmentManager().getBackStackEntryCount() - 1) {
            getFragmentManager().popBackStack();
            i2++;
        }
        LoadDialog.m4681b(this.mContext);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case 2110:
                LoadDialog.m4681b(this.mContext);
                return;
            case 2111:
                LoadDialog.m4681b(this.mContext);
                return;
            default:
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView.getId() != R.id.lv_area) {
            return;
        }
        String charSequence = ((TextView) view.findViewById(R.id.tv_area_name)).getText().toString();
        Iterator<City> it = this.f14271h.iterator();
        while (it.hasNext()) {
            City next = it.next();
            if (next.getDisplay().equals(charSequence)) {
                this.f14278o = next.getCcode();
                LoadDialog.m4686a(this.mContext);
                request(2111);
            }
        }
    }

    /* renamed from: a */
    private List<SortModel> m6109a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SortModel sortModel = new SortModel();
            sortModel.f16811a = list.get(i);
            String m4390a = this.f14273j.m4390a(list.get(i));
            if (m4390a != null && !"".equals(m4390a)) {
                String upperCase = m4390a.substring(0, 1).toUpperCase();
                if (upperCase.matches("[A-Z]")) {
                    sortModel.f16812b = upperCase.toUpperCase();
                } else {
                    sortModel.f16812b = "#";
                }
                arrayList.add(sortModel);
            }
        }
        return arrayList;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        TextWatcher textWatcher;
        super.onDestroyView();
        ClearEditText clearEditText = this.f14269f;
        if (clearEditText == null || (textWatcher = this.f14280q) == null) {
            return;
        }
        clearEditText.removeTextChangedListener(textWatcher);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btn_cancel) {
            return;
        }
        C2778n.m4918a(getActivity());
        this.f14269f.setText("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6110a(CityFragment cityFragment, String str) {
        List<SortModel> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            arrayList = cityFragment.f14275l;
        } else {
            arrayList.clear();
            List<SortModel> list = cityFragment.f14275l;
            if (list != null && list.size() != 0) {
                for (SortModel sortModel : cityFragment.f14275l) {
                    String str2 = sortModel.f16811a;
                    if (str2.indexOf(str.toString()) != -1 || cityFragment.f14273j.m4390a(str2).toLowerCase().startsWith(str.toString())) {
                        arrayList.add(sortModel);
                    }
                }
            }
        }
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Collections.sort(arrayList, cityFragment.f14272i);
        AreaAdapter areaAdapter = cityFragment.f14274k;
        if (areaAdapter != null) {
            areaAdapter.m6515a(arrayList);
        }
    }
}
