package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.basic.ByteConverter;
import com.thoughtworks.xstream.core.util.Base64Encoder;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class EncodedByteArrayConverter implements Converter, SingleValueConverter {
    private static final Base64Encoder base64 = new Base64Encoder();
    private static final ByteConverter byteConverter = new ByteConverter();

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.isArray() && cls.getComponentType().equals(Byte.TYPE);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(toString(obj));
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String value = hierarchicalStreamReader.getValue();
        if (!hierarchicalStreamReader.hasMoreChildren()) {
            return fromString(value);
        }
        return unmarshalIndividualByteElements(hierarchicalStreamReader, unmarshallingContext);
    }

    private Object unmarshalIndividualByteElements(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        ArrayList<Byte> arrayList = new ArrayList();
        int i = 0;
        boolean z = true;
        while (true) {
            if (!z && !hierarchicalStreamReader.hasMoreChildren()) {
                break;
            }
            hierarchicalStreamReader.moveDown();
            arrayList.add(byteConverter.fromString(hierarchicalStreamReader.getValue()));
            hierarchicalStreamReader.moveUp();
            z = false;
        }
        byte[] bArr = new byte[arrayList.size()];
        for (Byte b : arrayList) {
            bArr[i] = b.byteValue();
            i++;
        }
        return bArr;
    }

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        return base64.encode((byte[]) obj);
    }

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        return base64.decode(str);
    }
}
