package com.cnlaunch.x431pro.activity.bluetooth;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.physics.p197c.BluetoothListDto;

/* compiled from: BluetoothActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.a */
/* loaded from: classes.dex */
final class C1991a implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BluetoothActivity f10936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1991a(BluetoothActivity bluetoothActivity) {
        this.f10936a = bluetoothActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BluetoothListAdapter bluetoothListAdapter;
        this.f10936a.f10905s = true;
        bluetoothListAdapter = this.f10936a.f10896j;
        BluetoothActivity.m7801a(this.f10936a, (BluetoothListDto) bluetoothListAdapter.getItem(i));
    }
}
