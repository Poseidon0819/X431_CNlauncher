package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

/* loaded from: classes2.dex */
public class BitSetConverter implements Converter {
    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(BitSet.class);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        BitSet bitSet = (BitSet) obj;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        for (int i = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                if (z) {
                    stringBuffer.append(',');
                } else {
                    z = true;
                }
                stringBuffer.append(i);
            }
        }
        hierarchicalStreamWriter.setValue(stringBuffer.toString());
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        BitSet bitSet = new BitSet();
        StringTokenizer stringTokenizer = new StringTokenizer(hierarchicalStreamReader.getValue(), ",", false);
        while (stringTokenizer.hasMoreTokens()) {
            bitSet.set(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return bitSet;
    }
}
