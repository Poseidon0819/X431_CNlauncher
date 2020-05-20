package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p218a.CarIconAdapter;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.widget.a.cx */
/* loaded from: classes.dex */
public final class VinScanSelectVehieclesDialog extends BaseDialog {

    /* renamed from: a */
    Context f16393a;

    /* renamed from: b */
    private View f16394b;

    /* renamed from: c */
    private GridView f16395c;

    public VinScanSelectVehieclesDialog(Context context, List<CarIcon> list, AdapterView.OnItemClickListener onItemClickListener) {
        super(context);
        this.f16394b = null;
        this.f16393a = null;
        this.f16393a = context;
        if (DiagnoseConstants.isCloudDiagnose) {
            setTitle(R.string.cloud_vin_select);
        } else {
            setTitle(R.string.vin_select);
        }
        this.f16394b = LayoutInflater.from(context).inflate(R.layout.vinscan_car_select, (ViewGroup) null);
        m4712g();
        this.f16395c = (GridView) this.f16394b.findViewById(R.id.gridview);
        CarIconAdapter carIconAdapter = new CarIconAdapter(context);
        carIconAdapter.m7522a(list);
        this.f16395c.setAdapter((ListAdapter) carIconAdapter);
        this.f16395c.setOnItemClickListener(onItemClickListener);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16394b;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Log.d("yhx", "vinDialog onKeyDown enter.");
        if (i == 4 && keyEvent.getAction() == 0) {
            dismiss();
            return true;
        }
        return false;
    }
}
