package com.thoughtworks.xstream.core.util;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;

/* loaded from: classes2.dex */
public class HierarchicalStreams {
    public static Class readClassType(HierarchicalStreamReader hierarchicalStreamReader, Mapper mapper) {
        String readClassAttribute = readClassAttribute(hierarchicalStreamReader, mapper);
        if (readClassAttribute == null) {
            return mapper.realClass(hierarchicalStreamReader.getNodeName());
        }
        return mapper.realClass(readClassAttribute);
    }

    public static String readClassAttribute(HierarchicalStreamReader hierarchicalStreamReader, Mapper mapper) {
        String aliasForSystemAttribute;
        String aliasForSystemAttribute2 = mapper.aliasForSystemAttribute("resolves-to");
        String attribute = aliasForSystemAttribute2 == null ? null : hierarchicalStreamReader.getAttribute(aliasForSystemAttribute2);
        return (attribute != null || (aliasForSystemAttribute = mapper.aliasForSystemAttribute(HtmlTags.CLASS)) == null) ? attribute : hierarchicalStreamReader.getAttribute(aliasForSystemAttribute);
    }
}
