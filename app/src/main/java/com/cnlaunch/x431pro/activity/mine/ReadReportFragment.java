package com.cnlaunch.x431pro.activity.mine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.ReportShowFragment;
import com.cnlaunch.x431pro.activity.share.ShareActivity;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p288h.NetPOSPrinterUtilPro;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.PrinterFailrueDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.mine.ci */
/* loaded from: classes.dex */
public class ReadReportFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: b */
    private TextView f14050b;

    /* renamed from: c */
    private ImageView f14051c;

    /* renamed from: d */
    private IconButton f14052d;

    /* renamed from: e */
    private IconButton f14053e;

    /* renamed from: f */
    private IconRadioButton f14054f;

    /* renamed from: h */
    private Bitmap f14056h;

    /* renamed from: j */
    private Bitmap f14058j;

    /* renamed from: l */
    private View f14060l;

    /* renamed from: g */
    private String f14055g = "";

    /* renamed from: i */
    private String f14057i = "";

    /* renamed from: k */
    private boolean f14059k = false;

    /* renamed from: m */
    private String f14061m = "";

    /* renamed from: a */
    PDFViewFragment f14049a = null;

    /* renamed from: n */
    private Handler f14062n = new HandlerC2460ck(this);

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle bundle = getBundle();
        if (bundle != null) {
            this.f14055g = bundle.getString("report_name");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.mine_title_report_details);
        this.f14054f = (IconRadioButton) getActivity().findViewById(R.id.iv_print_report);
        this.f14054f.setOnClickListener(this);
        this.f14053e = (IconButton) getActivity().findViewById(R.id.iv_delete_report);
        this.f14053e.setOnClickListener(this);
        this.f14052d = (IconButton) getActivity().findViewById(R.id.iv_share_report);
        this.f14052d.setOnClickListener(this);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14050b = (TextView) getActivity().findViewById(R.id.tv_report_texts);
        this.f14051c = (ImageView) getActivity().findViewById(R.id.iv_report_images);
        this.f14050b.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (this.f14055g.endsWith(".txt")) {
            this.f14050b.setVisibility(0);
            this.f14051c.setVisibility(8);
            this.f14057i = FileUtils.m5002c(this.f14055g);
            this.f14050b.setText(this.f14057i);
        } else if (this.f14055g.endsWith(".pdf")) {
            this.f14051c.setVisibility(8);
            this.f14050b.setVisibility(8);
        } else {
            this.f14059k = true;
            this.f14051c.setVisibility(0);
            this.f14050b.setVisibility(8);
            this.f14056h = BitmapFactory.decodeFile(this.f14055g);
            this.f14051c.setImageBitmap(this.f14056h);
            this.f14058j = this.f14056h;
            this.f14058j = NetPOSPrinterUtil.m9437a(this.f14058j);
            this.f14058j = NetPOSPrinterUtil.m9432b(this.f14058j);
        }
        if (TextUtils.isEmpty(this.f14055g)) {
            Log.e("EE", "open pdfPath is  null.");
        } else if (this.f14055g.endsWith(".pdf")) {
            Uri fromFile = Uri.fromFile(new File(this.f14055g));
            Bundle bundle2 = new Bundle();
            bundle2.putString("uri_name", fromFile.toString());
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            PDFViewFragment pDFViewFragment = this.f14049a;
            if (pDFViewFragment == null) {
                this.f14049a = new PDFViewFragment();
                this.f14049a.setArguments(bundle2);
                beginTransaction.add(R.id.fragment_container, this.f14049a).commit();
                return;
            }
            beginTransaction.show(pDFViewFragment).commit();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14060l = layoutInflater.inflate(R.layout.show_files_fragment, viewGroup, false);
        return this.f14060l;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_delete_report) {
            new C2459cj(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.mine_dialog_content_delreport, true);
        } else if (id == R.id.iv_print_report) {
            LoadDialog.m4685a(this.mContext, (int) R.string.printing_progress);
            request(20013);
        } else if (id != R.id.iv_share_report) {
        } else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("FilePath", this.f14055g);
            intent.putExtras(bundle);
            intent.setClass(getActivity(), ShareActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        String str;
        if (i == 20013) {
            int i2 = 0;
            if (!this.f14059k) {
                if (this.f14055g.endsWith(".txt")) {
                    i2 = PrintDataUtils.m4935a(this.mContext, this.f14057i);
                } else if (this.f14055g.endsWith(".pdf")) {
                    str = "";
                    try {
                        PdfReader pdfReader = new PdfReader(this.f14055g);
                        HashMap<String, String> info = pdfReader.getInfo();
                        str = info.containsKey("Subject") ? info.get("Subject") : "";
                        pdfReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (str.equalsIgnoreCase(ReportShowFragment.f11588a)) {
                        this.f14061m = this.f14055g.replace(".pdf", "tmp.pdf");
                        String m4932a = PrintDataUtils.m4932a(this.f14055g);
                        BaseFont baseFont = null;
                        try {
                            baseFont = BaseFont.createFont(this.mContext.getResources().getString(R.raw.cour), BaseFont.IDENTITY_H, false);
                        } catch (DocumentException e2) {
                            e2.printStackTrace();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        Font font = new Font(baseFont, 10.0f, 0);
                        font.setColor(BaseColor.BLACK);
                        Document document = new Document(new Rectangle(PageSize.f19601A4), 50.0f, 50.0f, 50.0f, 50.0f);
                        try {
                            PdfWriter.getInstance(document, new FileOutputStream(this.f14061m));
                            document.open();
                            PdfPTable pdfPTable = new PdfPTable(1);
                            pdfPTable.setWidthPercentage(100.0f);
                            PdfPCell pdfPCell = new PdfPCell(new Paragraph(m4932a, font));
                            pdfPCell.setRunDirection(3);
                            pdfPTable.addCell(pdfPCell);
                            document.add(pdfPTable);
                        } catch (DocumentException e4) {
                            System.err.println(e4.getMessage());
                        } catch (IOException e5) {
                            System.err.println(e5.getMessage());
                        }
                        document.close();
                        try {
                            Thread.sleep(200L);
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                        i2 = PrintDataUtils.m4931b(this.mContext, this.f14061m);
                    } else {
                        i2 = PrintDataUtils.m4931b(this.mContext, this.f14055g);
                    }
                }
            } else {
                Context context = this.mContext;
                Bitmap bitmap = this.f14058j;
                if (PreferencesManager.m9595a(context).m9583b(C1947h.f10555g, false)) {
                    i2 = NetPOSPrinterUtilPro.m9435a(bitmap, PreferencesManager.m9595a(context).m9591a(C1947h.f10554f));
                } else {
                    i2 = NetPOSPrinterUtilPro.m9438a(context, bitmap);
                }
            }
            FileUtils.m5000d(this.f14061m);
            return Integer.valueOf(i2);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 20013) {
            this.f14062n.obtainMessage(0).sendToTarget();
            LoadDialog.m4681b(this.mContext);
            Integer num = (Integer) obj;
            NetPOSPrinterUtil.m9439a(getActivity(), num.intValue());
            if (num.intValue() == 4095) {
                if (PreferencesManager.m9595a(this.mContext).m9583b(C1947h.f10555g, false)) {
                    new PrinterFailrueDialog(this.mContext).show();
                    return;
                } else {
                    NToast.m9447b(this.mContext, (int) R.string.print_connect_printer);
                    return;
                }
            }
            return;
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 20013) {
            this.f14062n.obtainMessage(0).sendToTarget();
            LoadDialog.m4681b(this.mContext);
            NToast.m9450a(getActivity(), (int) R.string.print_error_fail);
            return;
        }
        super.onFailure(i, i2, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        if (this.f14049a != null) {
            new Handler().postDelayed(new RunnableC2461cl(this), 2000L);
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
