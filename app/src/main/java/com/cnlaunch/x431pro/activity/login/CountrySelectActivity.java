package com.cnlaunch.x431pro.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.mine.p229a.AreaAdapter;
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

/* loaded from: classes.dex */
public class CountrySelectActivity extends ActivityC2004c implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: C */
    private UserAction f13032C;

    /* renamed from: D */
    private ListView f13033D;

    /* renamed from: E */
    private SideBar f13034E;

    /* renamed from: F */
    private ClearEditText f13035F;

    /* renamed from: G */
    private Button f13036G;

    /* renamed from: I */
    private PinyinComparator f13038I;

    /* renamed from: J */
    private CharacterParser f13039J;

    /* renamed from: K */
    private AreaAdapter f13040K;

    /* renamed from: L */
    private List<SortModel> f13041L;

    /* renamed from: M */
    private String f13042M;

    /* renamed from: n */
    private final int f13045n = 2012;

    /* renamed from: H */
    private ArrayList<Country> f13037H = new ArrayList<>();

    /* renamed from: N */
    private SideBar.InterfaceC2960a f13043N = new C2372o(this);

    /* renamed from: O */
    private TextWatcher f13044O = new C2373p(this);

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.register_countrylist);
        m7743b();
        this.f13032C = new UserAction(this);
        this.f13039J = CharacterParser.m4391a();
        this.f13038I = new PinyinComparator();
        this.f13033D = (ListView) findViewById(R.id.lv_area);
        this.f13033D.setOnItemClickListener(this);
        this.f13035F = (ClearEditText) findViewById(R.id.edit_search_country);
        this.f13035F.addTextChangedListener(this.f13044O);
        this.f13034E = (SideBar) findViewById(R.id.sidebar);
        this.f13034E.setOnTouchingLetterChangedListener(this.f13043N);
        this.f13036G = (Button) findViewById(R.id.btn_cancel);
        this.f13036G.setOnClickListener(this);
        LoadDialog.m4686a(this.f10981q);
        m7739c(2012);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 2012) {
            return this.f13032C.m5250g(LangManager.m9469a());
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        if (i != 2012) {
            return;
        }
        LoadDialog.m4681b(this.f10981q);
        if (obj != null) {
            CountryListResponse countryListResponse = (CountryListResponse) obj;
            if (countryListResponse.getCode() == 0) {
                ArrayList<Country> arrayList = (ArrayList) countryListResponse.getData();
                if (C2744aa.m5145h()) {
                    this.f13037H.clear();
                    Iterator<Country> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Country next = it.next();
                        if (next.getNcode().equals("112") | next.getNcode().equals("251")) {
                            this.f13037H.add(next);
                        }
                    }
                } else if (C2744aa.m5166c()) {
                    this.f13037H.clear();
                    this.f13037H = arrayList;
                } else {
                    this.f13037H.clear();
                    this.f13037H.addAll(arrayList);
                }
                ArrayList<Country> arrayList2 = this.f13037H;
                ArrayList arrayList3 = new ArrayList();
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        arrayList3.add(arrayList2.get(i2).getDisplay());
                    }
                }
                this.f13041L = m6793a(arrayList3);
                Collections.sort(this.f13041L, this.f13038I);
                this.f13040K = new AreaAdapter(this.f10981q, this.f13041L);
                this.f13033D.setAdapter((ListAdapter) this.f13040K);
                String obj2 = this.f13035F.getText().toString();
                if (TextUtils.isEmpty(obj2)) {
                    return;
                }
                m6791c(obj2);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i != 2012) {
            return;
        }
        LoadDialog.m4681b(this.f10981q);
    }

    /* renamed from: a */
    private List<SortModel> m6793a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SortModel sortModel = new SortModel();
            sortModel.f16811a = list.get(i);
            String m4390a = this.f13039J.m4390a(list.get(i));
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
        Iterator<Country> it = this.f13037H.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Country next = it.next();
            if (next.getDisplay().equals(charSequence)) {
                this.f13042M = next.getNcode();
                Intent intent = new Intent();
                intent.putExtra("ncode", next.getNcode());
                intent.putExtra("display", next.getDisplay());
                intent.putExtra("is_sms", Integer.toString(next.getIs_sms()));
                intent.putExtra("pre_code", Integer.toString(next.getPre_code()));
                setResult(1, intent);
                break;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6791c(String str) {
        List<SortModel> arrayList = new ArrayList<>();
        if (this.f13041L != null) {
            if (TextUtils.isEmpty(str)) {
                arrayList = this.f13041L;
            } else {
                arrayList.clear();
                for (SortModel sortModel : this.f13041L) {
                    String str2 = sortModel.f16811a;
                    if (str2.indexOf(str.toString()) != -1 || this.f13039J.m4390a(str2).toLowerCase().startsWith(str.toString())) {
                        arrayList.add(sortModel);
                    }
                }
            }
            PinyinComparator pinyinComparator = this.f13038I;
            if (pinyinComparator == null || arrayList == null) {
                return;
            }
            Collections.sort(arrayList, pinyinComparator);
            AreaAdapter areaAdapter = this.f13040K;
            if (areaAdapter != null) {
                areaAdapter.m6515a(arrayList);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btn_cancel) {
            return;
        }
        C2778n.m4918a((Activity) this);
        this.f13035F.setText("");
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
