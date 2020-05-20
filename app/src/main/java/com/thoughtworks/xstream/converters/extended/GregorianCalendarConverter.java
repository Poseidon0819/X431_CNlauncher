package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class GregorianCalendarConverter implements Converter {
    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(GregorianCalendar.class);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) obj;
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, "time", Long.TYPE);
        hierarchicalStreamWriter.setValue(String.valueOf(gregorianCalendar.getTime().getTime()));
        hierarchicalStreamWriter.endNode();
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, "timezone", String.class);
        hierarchicalStreamWriter.setValue(gregorianCalendar.getTimeZone().getID());
        hierarchicalStreamWriter.endNode();
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String id;
        hierarchicalStreamReader.moveDown();
        long parseLong = Long.parseLong(hierarchicalStreamReader.getValue());
        hierarchicalStreamReader.moveUp();
        if (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            id = hierarchicalStreamReader.getValue();
            hierarchicalStreamReader.moveUp();
        } else {
            id = TimeZone.getDefault().getID();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone(id));
        gregorianCalendar.setTime(new Date(parseLong));
        return gregorianCalendar;
    }
}
