package com.cnlaunch.p169im.p180j;

import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p164f.MessageEventCodeManager;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p178h.GoloOBManager;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* compiled from: ReceiveMessageTask.java */
/* renamed from: com.cnlaunch.im.j.d */
/* loaded from: classes.dex */
public final class RunnableC1748d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ReceiveMessageTask f9296a;

    public RunnableC1748d(ReceiveMessageTask receiveMessageTask) {
        this.f9296a = receiveMessageTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f9296a.f24000b.m218a() == 9) {
                GoloDBManager.m8756a(ApplicationConfig.f7802a).m8753a(this.f9296a.f24000b, PreferencesManager.m9595a(ApplicationConfig.f7802a).m9591a("user_id"));
                GoloOBManager m8721a = GoloOBManager.m8721a();
                this.f9296a.f24000b.m192p();
                m8721a.m8717b();
                if (this.f9296a.f24000b.m199i() == 1) {
                    this.f9296a.m263d(new ChatMessage(this.f9296a.f24000b.m211b(), this.f9296a.f24000b.f24060e));
                    this.f9296a.m8708a();
                    ((MessageEventCodeManager) Singlton.m9123a(MessageEventCodeManager.class)).m9126a(Opcodes.I2B, new Object[0]);
                    return;
                }
                return;
            }
            if ((this.f9296a.f24000b.f24058c.equals(MessageParameters.EnumC4721a.single.name()) ? MessageParameters.EnumC4721a.single : MessageParameters.EnumC4721a.group).equals(MessageParameters.EnumC4721a.single)) {
                this.f9296a.m264d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
