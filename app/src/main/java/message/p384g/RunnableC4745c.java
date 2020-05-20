package message.p384g;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogTracker.java */
/* renamed from: message.g.c */
/* loaded from: classes2.dex */
public final class RunnableC4745c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f24045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4745c(String str) {
        this.f24045a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File file;
        File file2;
        File file3;
        File file4;
        File file5;
        File file6;
        File file7;
        file = LogTracker.f24041c;
        if (!file.mkdirs()) {
            file7 = LogTracker.f24041c;
            if (!file7.isDirectory()) {
                return;
            }
        }
        String str = this.f24045a;
        file2 = LogTracker.f24043e;
        LogTracker.m232a(str, file2, true);
        file3 = LogTracker.f24043e;
        if (LogTracker.m235a(file3)) {
            file4 = LogTracker.f24043e;
            file5 = LogTracker.f24042d;
            LogTracker.m234a(file4, file5);
            file6 = LogTracker.f24043e;
            LogTracker.m232a("", file6, false);
        }
    }
}
