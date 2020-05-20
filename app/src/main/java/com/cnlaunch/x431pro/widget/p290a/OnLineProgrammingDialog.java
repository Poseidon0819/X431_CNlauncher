package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.MD5Utils;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.progress.ProgressBarCircularIndeterminate;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jivesoftware.smackx.packet.MultipleAddresses;

/* renamed from: com.cnlaunch.x431pro.widget.a.bj */
/* loaded from: classes.dex */
public final class OnLineProgrammingDialog extends BaseDialog implements IRemoteDownloadListener {

    /* renamed from: A */
    private boolean f16288A;

    /* renamed from: B */
    private LoginFunction.InterfaceC2302b f16289B;

    /* renamed from: a */
    IFragmentCallback f16290a;

    /* renamed from: b */
    private String f16291b;

    /* renamed from: c */
    private String f16292c;

    /* renamed from: g */
    private String f16293g;

    /* renamed from: h */
    private String f16294h;

    /* renamed from: i */
    private String f16295i;

    /* renamed from: j */
    private AsyncTaskC2828a f16296j;

    /* renamed from: k */
    private Context f16297k;

    /* renamed from: l */
    private Button f16298l;

    /* renamed from: m */
    private Button f16299m;

    /* renamed from: n */
    private TextView f16300n;

    /* renamed from: o */
    private ImageView f16301o;

    /* renamed from: p */
    private ProgressBarCircularIndeterminate f16302p;

    /* renamed from: q */
    private View.OnClickListener f16303q;

    /* renamed from: r */
    private View.OnClickListener f16304r;

    /* renamed from: s */
    private boolean f16305s;

    /* renamed from: t */
    private boolean f16306t;

    /* renamed from: u */
    private int f16307u;

    /* renamed from: v */
    private OnLineProgrammingDialog f16308v;

    /* renamed from: w */
    private Map<String, String> f16309w;

    /* renamed from: x */
    private boolean f16310x;

    /* renamed from: y */
    private File f16311y;

    /* renamed from: z */
    private int f16312z;

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return null;
    }

    /* renamed from: j */
    static /* synthetic */ int m4641j(OnLineProgrammingDialog onLineProgrammingDialog) {
        int i = onLineProgrammingDialog.f16312z;
        onLineProgrammingDialog.f16312z = i + 1;
        return i;
    }

    public OnLineProgrammingDialog(Context context, int i, Map<String, String> map, boolean z, IFragmentCallback iFragmentCallback) {
        super(context);
        this.f16305s = true;
        this.f16306t = true;
        this.f16310x = false;
        this.f16311y = null;
        this.f16312z = 0;
        this.f16288A = false;
        this.f16289B = new C2831bm(this);
        this.f16290a = iFragmentCallback;
        this.f16309w = map;
        this.f16307u = i;
        this.f16288A = z;
        this.f16297k = context;
        this.f16312z = 0;
        try {
            this.f16291b = ConfigDBManager.m5398a(this.f16297k).m5396a(KeyConstant.f6882bc);
            if (TextUtils.isEmpty(this.f16291b)) {
                this.f16291b = "http://dlcenter.x431.com/mycarDownload/downloadProgrammingFile.action";
            }
        } catch (C1425f e) {
            e.printStackTrace();
        }
        this.f16292c = map.get("softId");
        this.f16293g = map.get("versionNo");
        this.f16294h = map.get("filePath");
        this.f16295i = map.get("SerialNum");
        setContentView(R.layout.layout_dialog_download);
        this.f16298l = (Button) findViewById(R.id.buttona);
        this.f16299m = (Button) findViewById(R.id.buttonb);
        this.f16300n = (TextView) findViewById(R.id.f24501message);
        this.f16301o = (ImageView) findViewById(R.id.iv);
        setCanceledOnTouchOutside(false);
        this.f16302p = (ProgressBarCircularIndeterminate) findViewById(R.id.loading_progress);
        if (i == 1) {
            this.f16298l.setText(this.f16297k.getResources().getString(R.string.onlineprograming_Immediately_login));
            this.f16298l.setVisibility(0);
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_downfile_and_login));
            this.f16301o.setVisibility(8);
        } else if (i == 2) {
            this.f16298l.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_down));
            this.f16298l.setVisibility(0);
            this.f16299m.setVisibility(0);
            this.f16305s = false;
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_downfile));
            this.f16301o.setVisibility(8);
        } else if (i == 3) {
            this.f16299m.setVisibility(0);
            this.f16302p.setVisibility(0);
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_downing));
            this.f16301o.setVisibility(8);
        } else if (i == 4) {
            this.f16298l.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_retry));
            this.f16298l.setVisibility(0);
            this.f16299m.setVisibility(0);
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_network_downfail));
            this.f16301o.setBackgroundResource(R.drawable.register_item_no);
            this.f16301o.setVisibility(0);
        } else if (i == 5) {
            this.f16298l.setText(this.f16297k.getResources().getString(R.string.common_confirm));
            this.f16298l.setVisibility(0);
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_downsuccess));
            this.f16301o.setBackgroundResource(R.drawable.register_item_ok);
            this.f16301o.setVisibility(0);
        } else if (i == 6) {
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_opertionsuccess));
            this.f16301o.setBackgroundResource(R.drawable.register_item_ok);
            this.f16301o.setVisibility(0);
            new Timer().schedule(new C2829bk(this, iFragmentCallback), 1000L);
        }
        setCancelable(false);
        if (z) {
            this.f16298l.setEnabled(false);
            this.f16299m.setEnabled(false);
            return;
        }
        this.f16298l.setOnClickListener(this);
        this.f16299m.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m4659a(int i) {
        this.f16307u = i;
        if (i == 1) {
            this.f16298l.setText(this.f16297k.getResources().getString(R.string.onlineprograming_Immediately_login));
            this.f16298l.setVisibility(0);
            this.f16299m.setVisibility(8);
            this.f16302p.setVisibility(8);
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_downfile_and_login));
            this.f16301o.setVisibility(8);
        } else if (i == 2) {
            this.f16298l.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_down));
            this.f16298l.setVisibility(0);
            this.f16299m.setVisibility(0);
            this.f16302p.setVisibility(8);
            this.f16305s = false;
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_downfile));
            this.f16301o.setVisibility(8);
        } else if (i == 3) {
            if (this.f16288A) {
                DiagnoseUtils.m5086a().m5080b("remote_downloading");
            }
            mo4650d();
        } else if (i == 4) {
            if (this.f16288A) {
                DiagnoseUtils.m5086a().m5080b("remote_download_failed");
            }
            mo4652c();
        } else if (i == 5) {
            this.f16298l.setText(this.f16297k.getResources().getString(R.string.common_confirm));
            this.f16298l.setVisibility(0);
            this.f16299m.setVisibility(8);
            this.f16302p.setVisibility(8);
            this.f16301o.setBackgroundResource(R.drawable.register_item_ok);
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_downsuccess));
            this.f16301o.setVisibility(0);
        } else if (i == 6) {
            this.f16298l.setVisibility(8);
            this.f16299m.setVisibility(8);
            this.f16302p.setVisibility(8);
            this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_opertionsuccess));
            this.f16301o.setVisibility(0);
            new Timer().schedule(new C2830bl(this), 1000L);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener
    /* renamed from: j_ */
    public final void mo4640j_() {
        if (CommonTools.m7966b(this.f16297k)) {
            this.f16296j = new AsyncTaskC2828a();
            this.f16296j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            m4659a(3);
            return;
        }
        m4638l();
        NToast.m9447b(this.f16297k, (int) R.string.common_network_unavailable);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener
    /* renamed from: b */
    public final void mo4654b() {
        m4659a(5);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener
    /* renamed from: c */
    public final void mo4652c() {
        this.f16298l.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_retry));
        this.f16298l.setVisibility(0);
        this.f16299m.setVisibility(0);
        this.f16302p.setVisibility(8);
        this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_network_downfail));
        this.f16301o.setBackgroundResource(R.drawable.register_item_no);
        this.f16301o.setVisibility(0);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener
    /* renamed from: d */
    public final void mo4650d() {
        this.f16298l.setVisibility(8);
        this.f16299m.setVisibility(0);
        this.f16302p.setVisibility(0);
        this.f16300n.setText(this.f16297k.getResources().getString(R.string.onlineprograming_tip_downing));
        this.f16301o.setVisibility(8);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener
    /* renamed from: e */
    public final void mo4648e() {
        m4659a(6);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener
    /* renamed from: f */
    public final void mo4646f() {
        onClick(this.f16299m);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttona /* 2131296620 */:
                View.OnClickListener onClickListener = this.f16303q;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                if (this.f16305s) {
                    dismiss();
                }
                int i = this.f16307u;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i == 5) {
                                if (MainActivity.m7895b() && !this.f16288A) {
                                    DiagnoseUtils.m5086a().m5080b("remote_download_finished_confirm");
                                }
                                m4659a(6);
                                break;
                            }
                        } else if (MainActivity.m7895b() && !this.f16288A) {
                            DiagnoseUtils.m5086a().m5080b("remote_start_downloading");
                            m4659a(3);
                            return;
                        } else {
                            mo4640j_();
                            break;
                        }
                    } else if (MainActivity.m7895b() && !this.f16288A) {
                        DiagnoseUtils.m5086a().m5080b("remote_start_downloading");
                        m4659a(3);
                        return;
                    } else {
                        mo4640j_();
                        break;
                    }
                } else {
                    new LoginFunction(this.f16297k).m6574c(this.f16289B).setCancelable(false);
                    LoginFunction.m6590a(this.f16289B);
                    break;
                }
                break;
            case R.id.buttonb /* 2131296621 */:
                if (MainActivity.m7895b() && !this.f16288A) {
                    DiagnoseUtils.m5086a().m5080b("remote_download_cancel");
                }
                View.OnClickListener onClickListener2 = this.f16304r;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                if (this.f16306t) {
                    dismiss();
                }
                m4636m();
                this.f16290a.mo7093a(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
                int i2 = this.f16307u;
                if (i2 != 2 && i2 == 3 && m4636m()) {
                    m4659a(4);
                    break;
                }
                break;
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnLineProgrammingDialog.java */
    /* renamed from: com.cnlaunch.x431pro.widget.a.bj$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC2828a extends AsyncTask<Void, Integer, Object> {

        /* renamed from: b */
        private String[] f16314b = {"405", "402", "401", "771", "614", "615", "406", "616"};

        AsyncTaskC2828a() {
        }

        @Override // android.os.AsyncTask
        protected final /* bridge */ /* synthetic */ void onProgressUpdate(Integer[] numArr) {
            super.onProgressUpdate(numArr);
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Object obj) {
            if (OnLineProgrammingDialog.this.f16308v != null) {
                OnLineProgrammingDialog.this.f16308v.dismiss();
            }
            String str = (String) obj;
            if ("-1".equals(str)) {
                if (OnLineProgrammingDialog.this.f16311y != null && OnLineProgrammingDialog.this.f16311y.exists()) {
                    OnLineProgrammingDialog.this.f16311y.delete();
                }
                if (CommonTools.m7966b(OnLineProgrammingDialog.this.f16297k)) {
                    if (OnLineProgrammingDialog.this.f16312z < 3) {
                        OnLineProgrammingDialog onLineProgrammingDialog = OnLineProgrammingDialog.this;
                        onLineProgrammingDialog.f16296j = new AsyncTaskC2828a();
                        OnLineProgrammingDialog.this.f16296j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        OnLineProgrammingDialog.this.m4659a(3);
                        OnLineProgrammingDialog.m4641j(OnLineProgrammingDialog.this);
                    }
                } else {
                    OnLineProgrammingDialog.this.m4638l();
                    OnLineProgrammingDialog.this.dismiss();
                    new DialogC2832bn(this, OnLineProgrammingDialog.this.f16297k).m4670a(R.string.tab_menu_upgrade, R.string.common_network_error);
                }
            } else if ("0".equals(str)) {
                if (OnLineProgrammingDialog.this.f16288A) {
                    DiagnoseUtils.m5086a().m5080b("remote_download_finished");
                }
                OnLineProgrammingDialog.this.m4659a(5);
            } else if ("405".equals(str)) {
                OnLineProgrammingDialog.this.m4659a(4);
                OnLineProgrammingDialog.this.f16300n.setText(OnLineProgrammingDialog.this.f16297k.getResources().getString(R.string.onlineprograming_tip_filenull_downfail));
            } else if ("2".equals(str)) {
                if (OnLineProgrammingDialog.this.f16311y != null && OnLineProgrammingDialog.this.f16311y.exists()) {
                    OnLineProgrammingDialog.this.f16311y.delete();
                }
            } else if ("402".equals(str)) {
                OnLineProgrammingDialog.this.m4659a(4);
                OnLineProgrammingDialog.this.f16300n.setText(OnLineProgrammingDialog.this.f16297k.getResources().getString(R.string.onlineprograming_tip_network_downfail));
            } else if ("401".equals(str)) {
                OnLineProgrammingDialog.this.m4659a(4);
                OnLineProgrammingDialog.this.f16300n.setText(OnLineProgrammingDialog.this.f16297k.getResources().getString(R.string.onlineprograming_tip_network_downfail));
            } else if ("771".equals(str)) {
                OnLineProgrammingDialog.this.m4659a(4);
                OnLineProgrammingDialog.this.f16300n.setText(OnLineProgrammingDialog.this.f16297k.getResources().getString(R.string.onlineprograming_tip_cc_sn_not_match));
            } else if ("406".equals(str) || "614".equals(str)) {
                OnLineProgrammingDialog.this.m4659a(4);
                OnLineProgrammingDialog.this.f16300n.setText(OnLineProgrammingDialog.this.f16297k.getResources().getString(R.string.onlineprograming_tip_requse_count_over));
            } else if ("615".equals(str)) {
                OnLineProgrammingDialog.this.m4659a(4);
                OnLineProgrammingDialog.this.f16300n.setText(OnLineProgrammingDialog.this.f16297k.getResources().getString(R.string.onlineprograming_tip_clock_count_over));
            } else if ("616".equals(str)) {
                OnLineProgrammingDialog.this.m4659a(4);
                OnLineProgrammingDialog.this.f16300n.setText(OnLineProgrammingDialog.this.f16297k.getResources().getString(R.string.onlineprograming_tip_ctr_ip));
            }
            super.onPostExecute(obj);
        }

        /* renamed from: a */
        private Object m4629a() {
            FileOutputStream fileOutputStream = null;
            try {
                if (TextUtils.isEmpty(OnLineProgrammingDialog.this.f16291b)) {
                    return "-1";
                }
                String m9460a = MD5Utils.m9460a(OnLineProgrammingDialog.this.f16294h + OnLineProgrammingDialog.this.f16295i + OnLineProgrammingDialog.this.f16292c + OnLineProgrammingDialog.this.f16293g + PreferencesManager.m9595a(OnLineProgrammingDialog.this.f16297k).m9591a("token"));
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(OnLineProgrammingDialog.this.f16291b);
                LinkedList linkedList = new LinkedList();
                StringBuilder sb = new StringBuilder();
                sb.append(OnLineProgrammingDialog.this.f16292c);
                linkedList.add(new BasicNameValuePair("softId", sb.toString()));
                linkedList.add(new BasicNameValuePair("versionNo", OnLineProgrammingDialog.this.f16293g));
                linkedList.add(new BasicNameValuePair("filePath", OnLineProgrammingDialog.this.f16294h));
                linkedList.add(new BasicNameValuePair("serialNo", OnLineProgrammingDialog.this.f16295i));
                httpPost.addHeader(MultipleAddresses.f24412CC, PreferencesManager.m9595a(OnLineProgrammingDialog.this.f16297k).m9591a("user_id"));
                httpPost.addHeader("sign", m9460a);
                httpPost.setEntity(new UrlEncodedFormEntity(linkedList, "utf-8"));
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                long contentLength = execute.getEntity().getContentLength();
                if (contentLength == -1) {
                    contentLength = execute.getEntity().getContent().available();
                }
                if (contentLength == 0) {
                    return "405";
                }
                if (execute.getStatusLine().getStatusCode() == 200) {
                    InputStream content = execute.getEntity().getContent();
                    Header[] headers = execute.getHeaders("code");
                    if (headers != null && headers.length > 0) {
                        for (int i = 0; i < this.f16314b.length; i++) {
                            if (this.f16314b[i].equals(headers[0].getValue())) {
                                return this.f16314b[i];
                            }
                        }
                    }
                    String str = Environment.getExternalStorageDirectory() + DiagnoseConstants.DIAGNOSE_LIB_PATH;
                    OnLineProgrammingDialog.this.f16311y = new File(str, OnLineProgrammingDialog.this.f16294h.substring(OnLineProgrammingDialog.this.f16294h.lastIndexOf("/"), OnLineProgrammingDialog.this.f16294h.length()));
                    if (!OnLineProgrammingDialog.this.f16311y.exists()) {
                        FileUtils.m5006b(new File(str));
                        OnLineProgrammingDialog.this.f16311y.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(OnLineProgrammingDialog.this.f16311y);
                        try {
                            byte[] bArr = new byte[10240];
                            do {
                                int read = content.read(bArr);
                                if (read != -1) {
                                    fileOutputStream2.write(bArr, 0, read);
                                } else {
                                    fileOutputStream = fileOutputStream2;
                                }
                            } while (!OnLineProgrammingDialog.this.f16310x);
                            content.close();
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return "2";
                        } catch (Exception unused) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return "-1";
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    content.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return "0";
                }
                return "-1";
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Object doInBackground(Void[] voidArr) {
            return m4629a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m4638l() {
        AsyncTaskC2828a asyncTaskC2828a = this.f16296j;
        if (asyncTaskC2828a != null) {
            asyncTaskC2828a.cancel(true);
        }
    }

    /* renamed from: m */
    private boolean m4636m() {
        this.f16310x = true;
        AsyncTaskC2828a asyncTaskC2828a = this.f16296j;
        if (asyncTaskC2828a == null || asyncTaskC2828a.getStatus() == AsyncTask.Status.FINISHED) {
            return false;
        }
        this.f16296j.cancel(true);
        return true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        LoginFunction.InterfaceC2302b interfaceC2302b = this.f16289B;
        if (interfaceC2302b != null) {
            LoginFunction.m6579b(interfaceC2302b);
        }
        super.dismiss();
    }
}
