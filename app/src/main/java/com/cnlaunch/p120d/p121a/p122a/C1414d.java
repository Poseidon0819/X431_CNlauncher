package com.cnlaunch.p120d.p121a.p122a;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamDriver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XmlMananger.java */
/* renamed from: com.cnlaunch.d.a.a.d */
/* loaded from: classes.dex */
public final class C1414d extends XStream {

    /* renamed from: a */
    final /* synthetic */ XmlMananger f6752a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1414d(XmlMananger xmlMananger, HierarchicalStreamDriver hierarchicalStreamDriver) {
        super(hierarchicalStreamDriver);
        this.f6752a = xmlMananger;
    }

    @Override // com.thoughtworks.xstream.XStream
    public final MapperWrapper wrapMapper(MapperWrapper mapperWrapper) {
        return new C1415e(this, mapperWrapper);
    }
}
