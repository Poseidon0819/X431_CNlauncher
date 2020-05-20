package com.cnlaunch.p169im.p172c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p175e.OnIMDataListener;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.others.GoloTools;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.im.c.aa */
/* loaded from: classes.dex */
public class UserDetailFragment extends BaseFragment implements OnIMDataListener {

    /* renamed from: d */
    private Button f9055d;

    /* renamed from: e */
    private Button f9056e;

    /* renamed from: g */
    private ImageView f9058g;

    /* renamed from: h */
    private ImageView f9059h;

    /* renamed from: i */
    private TextView f9060i;

    /* renamed from: j */
    private TextView f9061j;

    /* renamed from: k */
    private TextView f9062k;

    /* renamed from: l */
    private TextView f9063l;

    /* renamed from: m */
    private TextView f9064m;

    /* renamed from: n */
    private TextView f9065n;

    /* renamed from: o */
    private TextView f9066o;

    /* renamed from: p */
    private TextView f9067p;

    /* renamed from: q */
    private View f9068q;

    /* renamed from: a */
    private UserBaseInfo f9052a = null;

    /* renamed from: b */
    private String f9053b = "";

    /* renamed from: c */
    private boolean f9054c = false;

    /* renamed from: f */
    private String f9057f = "";

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f9057f = arguments.getString("target_id");
            this.f9053b = arguments.getString("target_name");
            this.f9054c = arguments.getBoolean("isFriend");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle == null) {
            setTitle(R.string.user_detail);
            if (!this.f9054c || this.f9057f.equalsIgnoreCase("666666") || this.f9057f.equalsIgnoreCase("friend_verification")) {
                this.f9056e.setVisibility(8);
            }
            this.f9052a = IMPresenter.m8804a(getActivity()).m8799a(this.f9057f, true);
            m8871a(this.f9052a);
        }
        IMPresenter.m8804a(getActivity()).m8803a(this);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        IMPresenter.m8804a(getActivity()).m8796b(this);
    }

    /* renamed from: a */
    private void m8871a(UserBaseInfo userBaseInfo) {
        String str;
        String str2;
        if (userBaseInfo != null && isAdded()) {
            DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
            c3010a.f17133q = new RoundedBitmapDisplayer(0);
            c3010a.f17117a = R.drawable.login_default;
            c3010a.f17118b = R.drawable.login_default;
            c3010a.f17119c = R.drawable.login_default;
            c3010a.f17124h = true;
            c3010a.f17125i = true;
            ImageLoader.m4191a().m4188a(GoloTools.m6963a(getActivity(), userBaseInfo.getUser_id()), this.f9058g, c3010a.m4193a());
            String nick_name = userBaseInfo.getNick_name();
            if (!TextUtils.isEmpty(nick_name)) {
                this.f9061j.setText(nick_name);
                this.f9062k.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            } else {
                this.f9061j.setText(this.f9053b);
                this.f9060i.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                this.f9062k.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            this.f9062k.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            String signature = userBaseInfo.getSignature();
            if (!TextUtils.isEmpty(signature)) {
                this.f9068q.setVisibility(0);
                this.f9063l.setText(signature);
            }
            this.f9059h.setImageResource(userBaseInfo.getSex().intValue() == 1 ? R.drawable.sex_boy : R.drawable.sex_gril);
            this.f9065n.setText(userBaseInfo.getMobile());
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(userBaseInfo.getCountry())) {
                str = "";
            } else {
                str = userBaseInfo.getCountry() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            sb.append(str);
            if (TextUtils.isEmpty(userBaseInfo.getProvince())) {
                str2 = "";
            } else {
                str2 = userBaseInfo.getProvince() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            sb.append(str2);
            sb.append(TextUtils.isEmpty(userBaseInfo.getCity()) ? "" : userBaseInfo.getCity());
            this.f9066o.setText(sb.toString());
            this.f9067p.setText(TextUtils.isEmpty(userBaseInfo.getEmail()) ? "" : userBaseInfo.getEmail());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.golo_fragment_user_detail, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.title_carname);
        textView.setText(textView.getText().toString().replace(":", "").replace("：", ""));
        this.f9059h = (ImageView) inflate.findViewById(R.id.img_sex);
        this.f9058g = (ImageView) inflate.findViewById(R.id.detail_usericon);
        this.f9060i = (TextView) inflate.findViewById(R.id.detail_username);
        this.f9062k = (TextView) inflate.findViewById(R.id.detail_nickname);
        this.f9061j = (TextView) inflate.findViewById(R.id.detail_mainname);
        this.f9063l = (TextView) inflate.findViewById(R.id.detail_signature);
        this.f9064m = (TextView) inflate.findViewById(R.id.detail_carname);
        this.f9065n = (TextView) inflate.findViewById(R.id.detail_mobile);
        this.f9066o = (TextView) inflate.findViewById(R.id.detail_regional);
        this.f9067p = (TextView) inflate.findViewById(R.id.detail_email);
        this.f9068q = inflate.findViewById(R.id.layout_signature);
        this.f9056e = (Button) inflate.findViewById(R.id.order_you);
        this.f9056e.setOnClickListener(new View$OnClickListenerC1700ab(this));
        this.f9055d = (Button) inflate.findViewById(R.id.send_msg);
        this.f9055d.setOnClickListener(new View$OnClickListenerC1701ac(this));
        User user = (User) PreferencesManager.m9595a((Context) getActivity()).m9593a(User.class);
        if (!TextUtils.isEmpty(this.f9057f) && user != null && this.f9057f.equals(user.getUser_id())) {
            this.f9055d.setVisibility(4);
        } else {
            this.f9055d.setVisibility(0);
        }
        return inflate;
    }

    @Override // com.cnlaunch.p169im.p175e.OnIMDataListener
    /* renamed from: a */
    public final void mo6461a(int i) {
        if (i == 40029) {
            this.f9052a = IMPresenter.m8804a(getActivity()).m8799a(this.f9057f, false);
            m8871a(this.f9052a);
        }
    }
}
