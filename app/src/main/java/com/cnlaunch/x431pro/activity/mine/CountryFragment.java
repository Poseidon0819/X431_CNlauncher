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
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.Country;
import com.cnlaunch.x431pro.module.p272k.p274b.CountryListResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
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

/* renamed from: com.cnlaunch.x431pro.activity.mine.w */
/* loaded from: classes.dex */
public class CountryFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: c */
    private UserAction f14318c;

    /* renamed from: d */
    private ListView f14319d;

    /* renamed from: e */
    private SideBar f14320e;

    /* renamed from: f */
    private ClearEditText f14321f;

    /* renamed from: g */
    private Button f14322g;

    /* renamed from: i */
    private PinyinComparator f14324i;

    /* renamed from: j */
    private CharacterParser f14325j;

    /* renamed from: k */
    private AreaAdapter f14326k;

    /* renamed from: l */
    private List<SortModel> f14327l;

    /* renamed from: m */
    private String f14328m;

    /* renamed from: n */
    private String f14329n;

    /* renamed from: o */
    private String f14330o;

    /* renamed from: a */
    private final int f14316a = 2106;

    /* renamed from: b */
    private final int f14317b = 2107;

    /* renamed from: h */
    private ArrayList<Country> f14323h = new ArrayList<>();

    /* renamed from: p */
    private SideBar.InterfaceC2960a f14331p = new C2497x(this);

    /* renamed from: q */
    private TextWatcher f14332q = new C2498y(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f14318c = new UserAction(this.mContext);
        setTitle(R.string.mine_tv_country);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14325j = CharacterParser.m4391a();
        this.f14324i = new PinyinComparator();
        this.f14319d = (ListView) getActivity().findViewById(R.id.lv_area);
        this.f14319d.setOnItemClickListener(this);
        this.f14321f = (ClearEditText) getActivity().findViewById(R.id.edit_search_country);
        this.f14321f.addTextChangedListener(this.f14332q);
        this.f14320e = (SideBar) getActivity().findViewById(R.id.sidebar);
        this.f14320e.setOnTouchingLetterChangedListener(this.f14331p);
        this.f14322g = (Button) getActivity().findViewById(R.id.btn_cancel);
        this.f14322g.setOnClickListener(this);
        LoadDialog.m4686a(this.mContext);
        request(2106);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_arealist, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2106:
                return this.f14318c.m5250g(LangManager.m9469a());
            case 2107:
                return this.f14318c.m5260b(this.f14328m, this.f14329n, this.f14330o);
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        switch (i) {
            case 2106:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    CountryListResponse countryListResponse = (CountryListResponse) obj;
                    if (isSuccess(countryListResponse.getCode())) {
                        ArrayList arrayList = (ArrayList) countryListResponse.getData();
                        if (C2744aa.m5166c()) {
                            this.f14323h.clear();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Country country = (Country) it.next();
                                if (country.getNcode().equals("137") | country.getNcode().equals("235") | country.getNcode().equals("325")) {
                                    this.f14323h.add(country);
                                }
                            }
                        } else {
                            this.f14323h.clear();
                            this.f14323h.addAll(arrayList);
                        }
                        ArrayList<Country> arrayList2 = this.f14323h;
                        ArrayList arrayList3 = new ArrayList();
                        if (arrayList2 != null) {
                            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                                arrayList3.add(arrayList2.get(i2).getDisplay());
                            }
                        }
                        this.f14327l = m6087a(arrayList3);
                        Collections.sort(this.f14327l, this.f14324i);
                        this.f14326k = new AreaAdapter(this.mContext, this.f14327l);
                        this.f14319d.setAdapter((ListAdapter) this.f14326k);
                        return;
                    }
                    return;
                }
                return;
            case 2107:
                LoadDialog.m4681b(this.mContext);
                if (obj == null || !isSuccess(((CommonResponse) obj).getCode())) {
                    return;
                }
                getFragmentManager().popBackStack();
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case 2106:
                LoadDialog.m4681b(this.mContext);
                return;
            case 2107:
                LoadDialog.m4681b(this.mContext);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private List<SortModel> m6087a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SortModel sortModel = new SortModel();
            sortModel.f16811a = list.get(i);
            String m4390a = this.f14325j.m4390a(list.get(i));
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

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String charSequence = ((TextView) view.findViewById(R.id.tv_area_name)).getText().toString();
        Iterator<Country> it = this.f14323h.iterator();
        while (it.hasNext()) {
            Country next = it.next();
            if (next.getDisplay().equals(charSequence)) {
                this.f14328m = next.getNcode();
                if (this.f14328m.equals("143")) {
                    Bundle bundle = new Bundle();
                    bundle.putString("ncode", this.f14328m);
                    replaceFragment(ProvinceFragment.class.getName(), bundle);
                } else {
                    this.f14329n = "0";
                    this.f14330o = "0";
                    LoadDialog.m4686a(this.mContext);
                    request(2107);
                }
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        TextWatcher textWatcher;
        super.onDestroyView();
        ClearEditText clearEditText = this.f14321f;
        if (clearEditText == null || (textWatcher = this.f14332q) == null) {
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
        this.f14321f.setText("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6088a(CountryFragment countryFragment, String str) {
        List<SortModel> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            arrayList = countryFragment.f14327l;
        } else {
            arrayList.clear();
            for (SortModel sortModel : countryFragment.f14327l) {
                String str2 = sortModel.f16811a;
                if (str2.indexOf(str.toString()) != -1 || countryFragment.f14325j.m4390a(str2).toLowerCase().startsWith(str.toString())) {
                    arrayList.add(sortModel);
                }
            }
        }
        Collections.sort(arrayList, countryFragment.f14324i);
        AreaAdapter areaAdapter = countryFragment.f14326k;
        if (areaAdapter != null) {
            areaAdapter.m6515a(arrayList);
        }
    }
}
