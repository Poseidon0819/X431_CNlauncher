package com.cnlaunch.x431pro.activity.mine;

import android.annotation.SuppressLint;
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
import com.cnlaunch.x431pro.module.p272k.p274b.Province;
import com.cnlaunch.x431pro.module.p272k.p274b.ProvinceListResponse;
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

@SuppressLint({"DefaultLocale"})
/* renamed from: com.cnlaunch.x431pro.activity.mine.cf */
/* loaded from: classes.dex */
public class ProvinceFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: b */
    private UserAction f14033b;

    /* renamed from: c */
    private ListView f14034c;

    /* renamed from: d */
    private SideBar f14035d;

    /* renamed from: e */
    private ClearEditText f14036e;

    /* renamed from: f */
    private Button f14037f;

    /* renamed from: g */
    private ArrayList<Province> f14038g;

    /* renamed from: h */
    private PinyinComparator f14039h;

    /* renamed from: i */
    private CharacterParser f14040i;

    /* renamed from: j */
    private AreaAdapter f14041j;

    /* renamed from: k */
    private List<SortModel> f14042k;

    /* renamed from: l */
    private String f14043l;

    /* renamed from: m */
    private String f14044m;

    /* renamed from: a */
    private final int f14032a = 2108;

    /* renamed from: n */
    private SideBar.InterfaceC2960a f14045n = new C2457cg(this);

    /* renamed from: o */
    private TextWatcher f14046o = new C2458ch(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f14033b = new UserAction(this.mContext);
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f14043l = (String) bundle2.get("ncode");
        }
        setTitle(R.string.mine_tv_province);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14040i = CharacterParser.m4391a();
        this.f14039h = new PinyinComparator();
        this.f14034c = (ListView) getActivity().findViewById(R.id.lv_area);
        this.f14034c.setOnItemClickListener(this);
        this.f14036e = (ClearEditText) getActivity().findViewById(R.id.edit_search_country);
        this.f14036e.addTextChangedListener(this.f14046o);
        this.f14035d = (SideBar) getActivity().findViewById(R.id.sidebar);
        this.f14035d.setOnTouchingLetterChangedListener(this.f14045n);
        this.f14037f = (Button) getActivity().findViewById(R.id.btn_cancel);
        this.f14037f.setOnClickListener(this);
        LoadDialog.m4686a(this.mContext);
        request(2108);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_arealist, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 2108) {
            return this.f14033b.m5252e(LangManager.m9469a(), this.f14043l);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        if (i != 2108) {
            return;
        }
        LoadDialog.m4681b(this.mContext);
        if (obj != null) {
            ProvinceListResponse provinceListResponse = (ProvinceListResponse) obj;
            if (isSuccess(provinceListResponse.getCode())) {
                this.f14038g = (ArrayList) provinceListResponse.getData();
                ArrayList<Province> arrayList = this.f14038g;
                ArrayList arrayList2 = new ArrayList();
                if (arrayList != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList2.add(arrayList.get(i2).getDisplay());
                    }
                }
                this.f14042k = m6252a(arrayList2);
                Collections.sort(this.f14042k, this.f14039h);
                this.f14041j = new AreaAdapter(this.mContext, this.f14042k);
                this.f14034c.setAdapter((ListAdapter) this.f14041j);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i != 2108) {
            return;
        }
        LoadDialog.m4681b(this.mContext);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView.getId() != R.id.lv_area) {
            return;
        }
        String charSequence = ((TextView) view.findViewById(R.id.tv_area_name)).getText().toString();
        Iterator<Province> it = this.f14038g.iterator();
        while (it.hasNext()) {
            Province next = it.next();
            if (next.getDisplay().equals(charSequence)) {
                this.f14044m = next.getPcode();
                Bundle bundle = new Bundle();
                bundle.putString("ncode", this.f14043l);
                bundle.putString("pcode", this.f14044m);
                replaceFragment(CityFragment.class.getName(), bundle);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    private List<SortModel> m6252a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SortModel sortModel = new SortModel();
            sortModel.f16811a = list.get(i);
            String m4390a = this.f14040i.m4390a(list.get(i));
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
        ClearEditText clearEditText = this.f14036e;
        if (clearEditText == null || (textWatcher = this.f14046o) == null) {
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
        this.f14036e.setText("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6253a(ProvinceFragment provinceFragment, String str) {
        List<SortModel> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            arrayList = provinceFragment.f14042k;
        } else {
            arrayList.clear();
            List<SortModel> list = provinceFragment.f14042k;
            if (list != null && list.size() != 0) {
                for (SortModel sortModel : provinceFragment.f14042k) {
                    String str2 = sortModel.f16811a;
                    if (str2.indexOf(str.toString()) != -1 || provinceFragment.f14040i.m4390a(str2).toLowerCase().startsWith(str.toString())) {
                        arrayList.add(sortModel);
                    }
                }
            }
        }
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Collections.sort(arrayList, provinceFragment.f14039h);
        AreaAdapter areaAdapter = provinceFragment.f14041j;
        if (areaAdapter != null) {
            areaAdapter.m6515a(arrayList);
        }
    }
}
