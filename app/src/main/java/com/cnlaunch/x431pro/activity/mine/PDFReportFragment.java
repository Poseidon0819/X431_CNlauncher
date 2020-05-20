package com.cnlaunch.x431pro.activity.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.ReportShowFragment;
import com.cnlaunch.x431pro.activity.share.ShareActivity;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
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
import java.util.concurrent.atomic.AtomicInteger;
import org.vudroid.core.DecodeService;
import org.vudroid.core.DecodeServiceBase;
import org.vudroid.core.DocumentView;
import org.vudroid.core.PDFPreferences;
import org.vudroid.core.events.CurrentPageListener;
import org.vudroid.core.models.CurrentPageModel;
import org.vudroid.core.models.DecodingProgressModel;
import org.vudroid.core.models.ZoomModel;
import org.vudroid.pdfdroid.codec.PdfContext;

/* renamed from: com.cnlaunch.x431pro.activity.mine.be */
/* loaded from: classes.dex */
public class PDFReportFragment extends BaseFragment implements View.OnClickListener, CurrentPageListener {

    /* renamed from: b */
    private FrameLayout f13914b;

    /* renamed from: c */
    private DecodeService f13915c;

    /* renamed from: d */
    private DocumentView f13916d;

    /* renamed from: e */
    private PDFPreferences f13917e;

    /* renamed from: f */
    private CurrentPageModel f13918f;

    /* renamed from: j */
    private LinearLayout f13922j;

    /* renamed from: k */
    private Toast f13923k;

    /* renamed from: m */
    private IconButton f13925m;

    /* renamed from: n */
    private IconButton f13926n;

    /* renamed from: o */
    private IconRadioButton f13927o;

    /* renamed from: a */
    private Uri f13913a = null;

    /* renamed from: g */
    private String f13919g = "";

    /* renamed from: h */
    private AtomicInteger f13920h = new AtomicInteger(0);

    /* renamed from: i */
    private boolean f13921i = true;

    /* renamed from: l */
    private Handler f13924l = new HandlerC2436bg(this);

    /* renamed from: p */
    private String f13928p = "";

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f13919g = bundle2.getString("report_name");
            this.f13921i = bundle2.getBoolean("isShowButton", true);
            if (!this.f13921i) {
                this.f13922j.setVisibility(8);
            } else {
                this.f13922j.setVisibility(0);
            }
            this.f13913a = Uri.fromFile(new File(this.f13919g));
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13919g = arguments.getString("report_name");
                this.f13921i = arguments.getBoolean("isShowButton", true);
                if (!this.f13921i) {
                    this.f13922j.setVisibility(8);
                } else {
                    this.f13922j.setVisibility(0);
                }
                this.f13913a = Uri.fromFile(new File(this.f13919g));
            }
        }
        setTitle(R.string.mine_tv_diagnosis_report);
        if (bundle == null) {
            if (this.f13915c == null) {
                this.f13915c = new DecodeServiceBase(new PdfContext());
            }
            ZoomModel zoomModel = new ZoomModel();
            zoomModel.setMaxZoom(2);
            DecodingProgressModel decodingProgressModel = new DecodingProgressModel();
            decodingProgressModel.addEventListener(new C2435bf(this));
            this.f13918f = new CurrentPageModel();
            this.f13918f.addEventListener(this);
            this.f13916d = new DocumentView(getActivity(), zoomModel, decodingProgressModel, this.f13918f);
            zoomModel.addEventListener(this.f13916d);
            this.f13916d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f13915c.setContentResolver(getActivity().getContentResolver());
            this.f13915c.setContainerView(this.f13916d);
            this.f13916d.setDecodeService(this.f13915c);
            Uri uri = this.f13913a;
            if (uri != null) {
                this.f13915c.open(uri);
            }
            this.f13917e = new PDFPreferences(getActivity());
            this.f13914b.addView(this.f13916d);
            this.f13916d.goToPage(0);
            this.f13916d.showDocument();
            Uri uri2 = this.f13913a;
            if (uri2 != null) {
                this.f13917e.addRecent(uri2);
            }
            this.f13920h.set(0);
            this.f13924l.sendEmptyMessageDelayed(0, 3000L);
        }
    }

    @Override // org.vudroid.core.events.CurrentPageListener
    @SuppressLint({"ShowToast"})
    public void currentPageChanged(int i) {
        String str = (i + 1) + "/" + this.f13915c.getPageCount();
        Toast toast = this.f13923k;
        if (toast != null) {
            toast.setText(str);
        } else {
            this.f13923k = Toast.makeText(getActivity(), str, 0);
        }
        this.f13923k.setGravity(51, 0, 0);
        this.f13923k.show();
        if (this.f13913a == null || getActivity() == null) {
            return;
        }
        SharedPreferences.Editor edit = getActivity().getSharedPreferences("DjvuDocumentViewState", 0).edit();
        edit.putInt(this.f13913a.toString(), this.f13916d.getCurrentPage());
        edit.commit();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_delete_report) {
            new C2438bi(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.mine_dialog_content_delreport, true);
        } else if (id == R.id.iv_print_report) {
            LoadDialog.m4685a(this.mContext, (int) R.string.printing_progress);
            request(20013);
        } else if (id != R.id.iv_share_report) {
        } else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("FilePath", this.f13919g);
            intent.putExtras(bundle);
            intent.setClass(getActivity(), ShareActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.mine_report_pdffragment, viewGroup, false);
        this.f13914b = (FrameLayout) inflate.findViewById(R.id.fragment_container);
        this.f13927o = (IconRadioButton) inflate.findViewById(R.id.iv_print_report);
        this.f13927o.setOnClickListener(this);
        if (MainActivity.m7895b()) {
            this.f13927o.setVisibility(8);
        }
        this.f13926n = (IconButton) inflate.findViewById(R.id.iv_delete_report);
        this.f13926n.setOnClickListener(this);
        this.f13925m = (IconButton) inflate.findViewById(R.id.iv_share_report);
        this.f13925m.setOnClickListener(this);
        this.f13922j = (LinearLayout) inflate.findViewById(R.id.bottom);
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        String str;
        int m4931b;
        if (i == 20013) {
            str = "";
            try {
                PdfReader pdfReader = new PdfReader(this.f13919g);
                HashMap<String, String> info = pdfReader.getInfo();
                str = info.containsKey("Subject") ? info.get("Subject") : "";
                pdfReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (str.equalsIgnoreCase(ReportShowFragment.f11588a)) {
                this.f13928p = this.f13919g.replace(".pdf", "tmp.pdf");
                String m4932a = PrintDataUtils.m4932a(this.f13919g);
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
                    PdfWriter.getInstance(document, new FileOutputStream(this.f13928p));
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
                m4931b = PrintDataUtils.m4931b(this.mContext, this.f13928p);
            } else {
                m4931b = PrintDataUtils.m4931b(this.mContext, this.f13919g);
            }
            FileUtils.m5000d(this.f13928p);
            return Integer.valueOf(m4931b);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (isAdded()) {
            if (i == 20013) {
                this.f13927o.setChecked(false);
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
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 20013) {
            this.f13927o.setChecked(false);
            LoadDialog.m4681b(this.mContext);
            NToast.m9450a(getActivity(), (int) R.string.print_error_fail);
            return;
        }
        super.onFailure(i, i2, obj);
    }

    /* renamed from: a */
    public final void m6295a() {
        DecodeService decodeService = this.f13915c;
        if (decodeService != null) {
            decodeService.recycle();
            this.f13915c = null;
        }
        DocumentView documentView = this.f13916d;
        if (documentView != null) {
            documentView.onFinishTemporaryDetach();
            this.f13916d.destroyDrawingCache();
            this.f13916d = null;
        }
        this.f13917e = null;
        CurrentPageModel currentPageModel = this.f13918f;
        if (currentPageModel != null) {
            currentPageModel.removeEventListener(this);
            this.f13918f = null;
        }
        System.gc();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        if (this.f13920h.get() == 1) {
            new Handler().postDelayed(new RunnableC2439bj(this), 3000L);
        } else {
            this.f13920h.set(2);
        }
        super.onDestroyView();
    }
}
