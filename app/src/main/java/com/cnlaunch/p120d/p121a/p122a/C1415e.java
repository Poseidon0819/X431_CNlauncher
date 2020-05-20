package com.cnlaunch.p120d.p121a.p122a;

import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/* compiled from: XmlMananger.java */
/* renamed from: com.cnlaunch.d.a.a.e */
/* loaded from: classes.dex */
final class C1415e extends MapperWrapper {

    /* renamed from: a */
    final /* synthetic */ C1414d f6753a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1415e(C1414d c1414d, Mapper mapper) {
        super(mapper);
        this.f6753a = c1414d;
    }

    @Override // com.thoughtworks.xstream.mapper.MapperWrapper, com.thoughtworks.xstream.mapper.Mapper
    public final boolean shouldSerializeMember(Class cls, String str) {
        if (cls == Object.class) {
            return false;
        }
        return super.shouldSerializeMember(cls, str);
    }
}
