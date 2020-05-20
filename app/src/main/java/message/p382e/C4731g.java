package message.p382e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cnlaunch.p167h.C1673a;
import message.XConnectionHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoloService.java */
/* renamed from: message.e.g */
/* loaded from: classes2.dex */
public final class C4731g extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ GoloService f23995a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4731g(GoloService goloService) {
        this.f23995a = goloService;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                GoloService.m271g();
                C1673a.m8965a().m8964a("NetWork is Connected -> logining");
                return;
            }
            XConnectionHelper m313a = XConnectionHelper.m313a();
            m313a.f23932a.execute(new RunnableC4732h(this));
        }
    }
}
