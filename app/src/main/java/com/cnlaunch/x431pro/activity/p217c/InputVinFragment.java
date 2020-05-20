package com.cnlaunch.x431pro.activity.p217c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.ReplacementTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.CarIconFragmentForAll;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.activity.login.LoginActivity;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.VinDropdownEditText;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.Barcode128;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.c.a */
/* loaded from: classes.dex */
public final class InputVinFragment extends BaseFragment implements View.OnClickListener, OnKeyDownListenter {

    /* renamed from: c */
    private Button f10993c;

    /* renamed from: d */
    private Button f10994d;

    /* renamed from: e */
    private PreferencesManager f10995e;

    /* renamed from: f */
    private CarIconUtils f10996f;

    /* renamed from: g */
    private String f10997g;

    /* renamed from: i */
    private VinDropdownEditText f10999i;

    /* renamed from: j */
    private KeyboardUtil f11000j;

    /* renamed from: h */
    private IFragmentCallback f10998h = null;

    /* renamed from: a */
    String f10991a = "vin_list";

    /* renamed from: b */
    ArrayList<String> f10992b = new ArrayList<>();

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter
    /* renamed from: i_ */
    public final void mo6838i_() {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.vin_input);
        this.f10995e = PreferencesManager.m9595a(this.mContext);
        this.f10996f = new CarIconUtils(this.mContext);
        this.f10997g = PreferencesManager.m9595a((Context) getActivity()).m9591a("serialNo");
        this.f10999i = (VinDropdownEditText) getActivity().findViewById(R.id.input_vin);
        VinDropdownEditText vinDropdownEditText = this.f10999i;
        vinDropdownEditText.setView(vinDropdownEditText);
        this.f11000j = new KeyboardUtil(this.f10999i);
        this.f10999i.setOnTouchListener(new View$OnTouchListenerC2006b(this));
        this.f10993c = (Button) getActivity().findViewById(R.id.input_vin_btn);
        this.f10993c.setOnClickListener(this);
        this.f10994d = (Button) getActivity().findViewById(R.id.clear_input_vin_btn);
        this.f10994d.setOnClickListener(this);
        this.f10999i.setTransformationMethod(new C2005a());
        IFragmentCallback iFragmentCallback = this.f10998h;
        if (iFragmentCallback != null) {
            iFragmentCallback.mo7096a(this);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.input_vin, viewGroup, false);
    }

    /* compiled from: InputVinFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.c.a$a */
    /* loaded from: classes.dex */
    public class C2005a extends ReplacementTransformationMethod {
        public C2005a() {
        }

        @Override // android.text.method.ReplacementTransformationMethod
        protected final char[] getOriginal() {
            return new char[]{'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX, Barcode128.START_A, Barcode128.START_B, Barcode128.START_C, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        }

        @Override // android.text.method.ReplacementTransformationMethod
        protected final char[] getReplacement() {
            return new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.clear_input_vin_btn) {
            this.f10999i.setText("");
        } else if (id != R.id.input_vin_btn) {
        } else {
            String upperCase = this.f10999i.getText().toString().toUpperCase();
            C2744aa.m5172b(getActivity(), upperCase);
            if (!this.f10992b.contains(upperCase)) {
                this.f10992b.add(upperCase);
                try {
                    this.f10995e.m9588a(this.f10991a, LoginActivity.m6763a(this.f10992b));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.f10995e.m9588a("last_vin_in", upperCase);
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        String m9591a = this.f10995e.m9591a(this.f10991a);
        if (m9591a != null && !m9591a.equals("")) {
            try {
                this.f10992b = (ArrayList) LoginActivity.m6764a(m9591a);
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
            }
        }
        this.f10999i.setList(this.f10992b);
        String m9591a2 = this.f10995e.m9591a("vin_scan");
        if (m9591a2 != null && "" != m9591a2) {
            this.f10999i.setText(m9591a2.toUpperCase());
            this.f10995e.m9588a("vin_scan", "");
        }
        this.f10999i.clearFocus();
        this.f11000j.m7727a();
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f10998h = (IFragmentCallback) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement FragmentCallback.OnMenuOnClickListener");
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.f11000j = null;
        this.f11000j = new KeyboardUtil(this.f10999i);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            replaceFragment(CarIconFragmentForAll.class.getName(), new Bundle(), 1, false);
            return true;
        }
        return false;
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        IFragmentCallback iFragmentCallback = this.f10998h;
        if (iFragmentCallback != null) {
            iFragmentCallback.mo7084h();
        }
    }
}
