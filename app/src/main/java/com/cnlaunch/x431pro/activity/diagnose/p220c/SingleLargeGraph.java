package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.android.widget.MeasureSubject;
import com.cnlaunch.android.widget.SlideGaugeLayout;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p112a.DataStreamGraphicalView;
import com.cnlaunch.p112a.p113a.AbstractChart;
import com.cnlaunch.p112a.p113a.DataStreamChart;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.DataStreamSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYSeriesRenderer;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DiagnoseGraphTouchUtil;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ReferenceLineLayer;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.DataStreamUpdatingUtils;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.t */
/* loaded from: classes.dex */
public final class SingleLargeGraph implements View.OnClickListener, DiagnoseGraphTouchUtil.InterfaceC2096a, ReferenceLineLayer.InterfaceC2098a {

    /* renamed from: G */
    private long f11797G;

    /* renamed from: c */
    public double f11800c;

    /* renamed from: d */
    public double f11801d;

    /* renamed from: e */
    public InterfaceC2099a f11802e;

    /* renamed from: g */
    private Context f11804g;

    /* renamed from: h */
    private RelativeLayout f11805h;

    /* renamed from: j */
    private DataStreamSeriesRenderer f11807j;

    /* renamed from: k */
    private XYSeries f11808k;

    /* renamed from: l */
    private AbstractChart f11809l;

    /* renamed from: m */
    private DataStreamGraphicalView f11810m;

    /* renamed from: n */
    private MediaPlayer f11811n;

    /* renamed from: o */
    private ChartWrapper f11812o;

    /* renamed from: p */
    private ReferenceLineLayer f11813p;

    /* renamed from: q */
    private SlideGaugeLayout f11814q;

    /* renamed from: r */
    private boolean f11815r;

    /* renamed from: s */
    private TextView f11816s;

    /* renamed from: t */
    private TextView f11817t;

    /* renamed from: u */
    private TextView f11818u;

    /* renamed from: v */
    private TextView f11819v;

    /* renamed from: w */
    private double f11820w;

    /* renamed from: x */
    private double f11821x;

    /* renamed from: a */
    public boolean f11798a = false;

    /* renamed from: b */
    public boolean f11799b = false;

    /* renamed from: i */
    private int[] f11806i = {30, 60, 20, 60};

    /* renamed from: y */
    private final int f11822y = 1;

    /* renamed from: z */
    private final int f11823z = 2;

    /* renamed from: A */
    private String f11791A = "";

    /* renamed from: B */
    private String f11792B = "";

    /* renamed from: C */
    private String f11793C = "";

    /* renamed from: D */
    private String f11794D = "";

    /* renamed from: E */
    private boolean f11795E = false;

    /* renamed from: F */
    private Handler f11796F = new HandlerC2100u(this);

    /* renamed from: f */
    public int f11803f = -1;

    /* compiled from: SingleLargeGraph.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.t$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2099a {
        /* renamed from: a */
        void mo6316a(boolean z);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DiagnoseGraphTouchUtil.InterfaceC2096a
    /* renamed from: a */
    public final void mo7337a(boolean z) {
    }

    /* renamed from: a */
    public final void m7345a() {
        if (true == this.f11795E) {
            return;
        }
        DiagnoseGraphTouchUtil diagnoseGraphTouchUtil = new DiagnoseGraphTouchUtil();
        diagnoseGraphTouchUtil.f11753a = 10.0f;
        diagnoseGraphTouchUtil.f11755c = this.f11807j;
        diagnoseGraphTouchUtil.f11754b = this;
        this.f11805h.setOnTouchListener(diagnoseGraphTouchUtil);
        this.f11795E = true;
    }

    /* renamed from: a */
    private void m7343a(double d, boolean z) {
        double parseDouble = Double.parseDouble(this.f11813p.f11770a.format(d));
        if (this.f11799b && z) {
            double d2 = this.f11801d;
            if (parseDouble <= d2) {
                parseDouble = d2;
            }
        }
        this.f11800c = parseDouble;
        this.f11813p.m7361a((MeasureSubject) this.f11812o, 1, parseDouble);
        this.f11813p.m7362a((MeasureSubject) this.f11812o, parseDouble, 1);
    }

    /* renamed from: b */
    private void m7335b(double d, boolean z) {
        double parseDouble = Double.parseDouble(this.f11813p.f11770a.format(d));
        if (this.f11799b && z) {
            double d2 = this.f11800c;
            if (parseDouble >= d2) {
                parseDouble = d2;
            }
        }
        this.f11801d = parseDouble;
        this.f11813p.m7361a((MeasureSubject) this.f11812o, 2, parseDouble);
        this.f11813p.m7362a((MeasureSubject) this.f11812o, parseDouble, 2);
    }

    /* renamed from: e */
    private void m7331e() {
        this.f11792B = this.f11804g.getResources().getString(R.string.setMaxMin_max) + " : " + this.f11813p.f11770a.format(this.f11800c) + ", " + this.f11804g.getResources().getString(R.string.setMaxMin_min) + " : " + this.f11813p.f11770a.format(this.f11801d);
        this.f11818u.setText(this.f11799b ? this.f11792B : "");
    }

    /* renamed from: a */
    public final void m7344a(double d, double d2) {
        if (this.f11815r) {
            this.f11813p.m7359a(true);
        }
        m7343a(d, false);
        m7335b(d2, false);
        this.f11813p.m7363a(this.f11812o, d, d2);
        this.f11799b = true;
        m7331e();
        this.f11796F.sendEmptyMessage(0);
    }

    public SingleLargeGraph(Context context, RelativeLayout relativeLayout) {
        this.f11804g = context;
        this.f11806i[0] = (int) C2778n.m4897d(this.f11804g);
        String m9584b = PreferencesManager.m9595a(context).m9584b("productType", "");
        if (m9584b.equals("ScanPad071") || m9584b.equals("X431Pro") || m9584b.equals("X431V")) {
            if (Build.VERSION.SDK_INT < 19) {
                this.f11806i[0] = 45;
            } else {
                this.f11806i[0] = 40;
            }
        } else if (m9584b.equals("XPDIII") || m9584b.equals("Maximus2") || m9584b.equals("X-431 PAD II") || m9584b.equals("X431Pro4")) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.f11806i[0] = 45;
            }
        } else {
            m9584b.equals("MaxGo");
        }
        this.f11805h = relativeLayout;
        View findViewById = this.f11805h.findViewById(R.id.title_contrain);
        int[] iArr = this.f11806i;
        findViewById.setPadding(iArr[1], 0, iArr[3], 0);
        this.f11816s = (TextView) this.f11805h.findViewById(R.id.tv_name);
        this.f11817t = (TextView) this.f11805h.findViewById(R.id.tv_unit);
        this.f11819v = (TextView) this.f11805h.findViewById(R.id.tv_currentValue);
        this.f11818u = (TextView) this.f11805h.findViewById(R.id.showMaxMinValue);
        this.f11807j = new DataStreamSeriesRenderer();
        this.f11808k = new XYSeries("");
        this.f11807j.setBackgroundColor(-1);
        this.f11807j.setApplyBackgroundColor(true);
        this.f11807j.setAxisTitleTextSize(16.0f);
        this.f11807j.setChartTitleTextSize(16.0f);
        this.f11807j.setLabelsTextSize(15.0f);
        this.f11807j.setLegendTextSize(15.0f);
        this.f11807j.setPointSize(5.0f);
        this.f11807j.setMargins(this.f11806i);
        this.f11807j.setDynamicShowOverrideText(true);
        this.f11807j.setAxesColor(Color.argb(this.f11804g.getResources().getInteger(R.integer.graph_axes_alpha), this.f11804g.getResources().getInteger(R.integer.graph_axes_red), this.f11804g.getResources().getInteger(R.integer.graph_axes_green), this.f11804g.getResources().getInteger(R.integer.graph_axes_blue)));
        this.f11807j.setLabelsColor(-16777216);
        this.f11807j.setGridColor(Color.argb(this.f11804g.getResources().getInteger(R.integer.graph_grid_alpha), this.f11804g.getResources().getInteger(R.integer.graph_grid_red), this.f11804g.getResources().getInteger(R.integer.graph_grid_green), this.f11804g.getResources().getInteger(R.integer.graph_grid_blue)));
        this.f11807j.setYLabelsColor(Color.argb(this.f11804g.getResources().getInteger(R.integer.graph_XLables_alpha), this.f11804g.getResources().getInteger(R.integer.graph_XLables_red), this.f11804g.getResources().getInteger(R.integer.graph_XLables_green), this.f11804g.getResources().getInteger(R.integer.graph_XLables_blue)));
        this.f11807j.setXLabelsColor(Color.argb(this.f11804g.getResources().getInteger(R.integer.graph_YLables_alpha), this.f11804g.getResources().getInteger(R.integer.graph_YLables_red), this.f11804g.getResources().getInteger(R.integer.graph_YLables_green), this.f11804g.getResources().getInteger(R.integer.graph_YLables_blue)));
        this.f11807j.setShowGrid(true);
        this.f11807j.setYLabelsAlign(Paint.Align.RIGHT);
        this.f11807j.setYLabels(6);
        this.f11807j.setYInnerLabels(5);
        this.f11807j.setYLabelsAngle(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        this.f11807j.setYLabelFormat(numberFormat);
        this.f11807j.setShowTickMarks(false);
        NumberFormat numberFormat2 = NumberFormat.getInstance();
        numberFormat2.setMaximumFractionDigits(0);
        this.f11807j.setXLabelFormat(numberFormat2);
        this.f11807j.setXLabels(9);
        this.f11807j.setXLabelsAngle(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.f11807j.setXAxisMin(0.0d);
        DataStreamSeriesRenderer dataStreamSeriesRenderer = this.f11807j;
        GraphConfiguration.m5385a();
        dataStreamSeriesRenderer.setXAxisMax(180.0d);
        this.f11807j.setXGridRange(GraphConfiguration.m5385a());
        this.f11807j.setYAxisMin(0.0d);
        this.f11807j.setYAxisMax(1500.0d);
        this.f11807j.setShowLegend(false);
        XYSeriesRenderer xYSeriesRenderer = new XYSeriesRenderer();
        xYSeriesRenderer.setShowLegendItem(false);
        xYSeriesRenderer.setLineWidth(3.0f);
        this.f11807j.addSeriesRenderer(xYSeriesRenderer);
        this.f11821x = this.f11807j.getYAxisMin();
        this.f11820w = this.f11807j.getYAxisMax();
        this.f11805h.setOnClickListener(this);
        this.f11809l = new DataStreamChart(this.f11807j, this.f11808k);
        this.f11810m = new DataStreamGraphicalView(context, this.f11809l);
        this.f11812o = new ChartWrapper(this.f11810m, this.f11807j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.currentValue_contrain);
        this.f11805h.addView(this.f11810m, layoutParams);
        this.f11814q = (SlideGaugeLayout) LayoutInflater.from(context).inflate(R.layout.layer_reference_line, (ViewGroup) null);
        SlideGaugeLayout slideGaugeLayout = this.f11814q;
        int[] iArr2 = this.f11806i;
        slideGaugeLayout.setPadding(iArr2[1], 0, iArr2[3], 0);
        this.f11805h.addView(this.f11814q, layoutParams);
        this.f11814q.setMeasureSubject(this.f11812o);
        this.f11813p = new ReferenceLineLayer(this.f11814q);
        this.f11813p.f11771b = this;
        this.f11811n = MediaPlayer.create(this.f11804g, (int) R.raw.waring);
    }

    /* renamed from: b */
    public final void m7336b() {
        this.f11805h.setVisibility(0);
        InterfaceC2099a interfaceC2099a = this.f11802e;
        if (interfaceC2099a != null) {
            interfaceC2099a.mo6316a(true);
        }
        this.f11796F.sendEmptyMessage(0);
        this.f11809l.startTimer();
    }

    /* renamed from: c */
    public final void m7333c() {
        this.f11805h.setVisibility(8);
        synchronized (this.f11808k) {
            this.f11808k.clear();
        }
        this.f11810m.m9673a();
        this.f11796F.removeMessages(0);
        this.f11809l.stopRefreshTimer();
        InterfaceC2099a interfaceC2099a = this.f11802e;
        if (interfaceC2099a != null) {
            interfaceC2099a.mo6316a(false);
        }
    }

    /* renamed from: d */
    public final boolean m7332d() {
        return this.f11805h.getVisibility() == 0;
    }

    /* renamed from: a */
    public final void m7341a(int i, int i2, boolean z) {
        this.f11803f = i;
        this.f11807j.getSeriesRendererAt(0).setColor(i2);
        this.f11807j.getYLabelMap().clear();
        this.f11807j.setXGridRange(GraphConfiguration.m5385a());
        this.f11815r = z;
        this.f11813p.m7359a(false);
        this.f11792B = "";
        this.f11818u.setText(this.f11792B);
        this.f11799b = false;
    }

    /* renamed from: a */
    public final void m7338a(List<BasicDataStreamBean> list, long j, SerializableMap serializableMap) {
        String trim;
        int i;
        int i2;
        synchronized (this.f11808k) {
            this.f11797G = j;
            int xGridRange = this.f11807j.getXGridRange();
            long j2 = xGridRange;
            long j3 = (this.f11797G > j2 ? 1 : (this.f11797G == j2 ? 0 : -1)) > 0 ? this.f11797G - j2 : 0L;
            this.f11808k.clear();
            if (list != null && !list.isEmpty()) {
                List<BasicDataStreamBean> m5099a = MeasureConversion.m5099a(C2744aa.m5158d(this.f11804g), list);
                this.f11793C = m5099a.get(m5099a.size() - 1).getValue();
                this.f11793C = this.f11793C.replace("\n", "").replace("\r", "");
                this.f11819v.setText(this.f11793C);
                String unit = m5099a.get(m5099a.size() - 1).getUnit();
                if (!unit.equals("   ")) {
                    unit = unit.trim();
                }
                if (!unit.isEmpty()) {
                    unit = "(" + unit + ")";
                }
                this.f11794D = unit;
                if (serializableMap != null) {
                    if (serializableMap.getMap() != null) {
                        trim = serializableMap.getMap().get(m5099a.get(0).getTitle()).trim();
                    } else {
                        trim = m5099a.get(0).getTitle().trim();
                    }
                } else {
                    trim = m5099a.get(0).getTitle().trim();
                }
                this.f11791A = trim;
                this.f11816s.setText(trim);
                this.f11817t.setText(unit);
                if (unit.isEmpty()) {
                    Map<String, Integer> yLabelMap = this.f11807j.getYLabelMap();
                    int size = m5099a.size();
                    for (int i3 = size > xGridRange ? size - xGridRange : 0; i3 < size; i3++) {
                        DataStreamUpdatingUtils.m4881a(this.f11808k, yLabelMap, (i3 + j3) - i2, m5099a.get(i3).getValue());
                    }
                    DataStreamUpdatingUtils.m4877b(this.f11807j, this.f11808k, this.f11797G);
                } else {
                    int size2 = m5099a.size();
                    for (int i4 = size2 > xGridRange ? size2 - xGridRange : 0; i4 < size2; i4++) {
                        if (m5099a.get(i4).getDbValue().isNaN()) {
                            this.f11808k.add((i4 + j3) - i, 0.0d);
                        } else {
                            this.f11808k.add((i4 + j3) - i, m5099a.get(i4).getDbValue().doubleValue());
                        }
                    }
                    if (m5099a.size() != 0 && this.f11799b) {
                        try {
                            double doubleValue = Double.valueOf(m5099a.get(m5099a.size() - 1).getValue()).doubleValue();
                            if (doubleValue > this.f11800c || doubleValue < this.f11801d) {
                                this.f11811n.start();
                            }
                        } catch (NumberFormatException unused) {
                            this.f11811n.start();
                        }
                    }
                    DataStreamUpdatingUtils.m4880a(this.f11807j, this.f11808k, this.f11797G);
                    if (this.f11799b && (this.f11820w != this.f11807j.getYAxisMax() || this.f11821x != this.f11807j.getYAxisMin())) {
                        m7344a(this.f11800c, this.f11801d);
                        this.f11820w = this.f11807j.getYAxisMax();
                        this.f11821x = this.f11807j.getYAxisMin();
                    }
                }
                int i5 = this.f11804g.getResources().getDisplayMetrics().widthPixels;
                int[] iArr = this.f11806i;
                int i6 = (i5 - iArr[1]) - iArr[3];
                if (this.f11819v.getMeasuredWidth() + this.f11817t.getMeasuredWidth() > i6) {
                    this.f11817t.setVisibility(8);
                    this.f11819v.setText(this.f11793C + this.f11794D);
                } else {
                    this.f11817t.setVisibility(0);
                    this.f11819v.setText(this.f11793C);
                }
                this.f11816s.measure(-2, -2);
                int measuredWidth = this.f11816s.getMeasuredWidth();
                if (!this.f11799b) {
                    this.f11818u.setText("");
                }
                this.f11818u.measure(-2, -2);
                if (measuredWidth + this.f11818u.getMeasuredWidth() > i6) {
                    this.f11816s.setVisibility(8);
                    TextView textView = this.f11818u;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f11791A);
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb.append(this.f11799b ? this.f11792B : "");
                    textView.setText(sb.toString());
                } else {
                    this.f11818u.setText(this.f11799b ? this.f11792B : "");
                    this.f11816s.setVisibility(0);
                }
                this.f11810m.m9673a();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f11798a || this.f11799b) {
            return;
        }
        m7333c();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ReferenceLineLayer.InterfaceC2098a
    /* renamed from: a */
    public final void mo7342a(int i, double d) {
        if (i == 1) {
            m7343a(d, true);
        } else if (i == 2) {
            m7335b(d, true);
        }
        m7331e();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DiagnoseGraphTouchUtil.InterfaceC2096a
    /* renamed from: a */
    public final void mo7340a(View view) {
        if (this.f11798a || this.f11799b) {
            return;
        }
        m7333c();
    }
}
