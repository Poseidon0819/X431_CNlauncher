package com.thoughtworks.xstream.converters.extended;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.mapper.DynamicProxyMapper;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class DynamicProxyConverter implements Converter {
    private ClassLoaderReference classLoaderReference;
    private Mapper mapper;
    private static final Field HANDLER = Fields.locate(Proxy.class, InvocationHandler.class, false);
    private static final InvocationHandler DUMMY = new InvocationHandler() { // from class: com.thoughtworks.xstream.converters.extended.DynamicProxyConverter.1
        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return null;
        }
    };

    public DynamicProxyConverter(Mapper mapper) {
        this(mapper, DynamicProxyConverter.class.getClassLoader());
    }

    public DynamicProxyConverter(Mapper mapper, ClassLoaderReference classLoaderReference) {
        this.classLoaderReference = classLoaderReference;
        this.mapper = mapper;
    }

    public DynamicProxyConverter(Mapper mapper, ClassLoader classLoader) {
        this(mapper, new ClassLoaderReference(classLoader));
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(DynamicProxyMapper.DynamicProxy.class) || Proxy.isProxyClass(cls);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
        addInterfacesToXml(obj, hierarchicalStreamWriter);
        hierarchicalStreamWriter.startNode("handler");
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute(HtmlTags.CLASS);
        if (aliasForSystemAttribute != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(invocationHandler.getClass()));
        }
        marshallingContext.convertAnother(invocationHandler);
        hierarchicalStreamWriter.endNode();
    }

    private void addInterfacesToXml(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter) {
        Class<?>[] interfaces;
        for (Class<?> cls : obj.getClass().getInterfaces()) {
            hierarchicalStreamWriter.startNode("interface");
            hierarchicalStreamWriter.setValue(this.mapper.serializedClass(cls));
            hierarchicalStreamWriter.endNode();
        }
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Class cls;
        String aliasForSystemAttribute;
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (!hierarchicalStreamReader.hasMoreChildren()) {
                cls = null;
                break;
            }
            hierarchicalStreamReader.moveDown();
            String nodeName = hierarchicalStreamReader.getNodeName();
            if (nodeName.equals("interface")) {
                arrayList.add(this.mapper.realClass(hierarchicalStreamReader.getValue()));
            } else if (nodeName.equals("handler") && (aliasForSystemAttribute = this.mapper.aliasForSystemAttribute(HtmlTags.CLASS)) != null) {
                cls = this.mapper.realClass(hierarchicalStreamReader.getAttribute(aliasForSystemAttribute));
                break;
            }
            hierarchicalStreamReader.moveUp();
        }
        if (cls == null) {
            throw new ConversionException("No InvocationHandler specified for dynamic proxy");
        }
        Class[] clsArr = new Class[arrayList.size()];
        arrayList.toArray(clsArr);
        Object newProxyInstance = HANDLER != null ? Proxy.newProxyInstance(this.classLoaderReference.getReference(), clsArr, DUMMY) : null;
        InvocationHandler invocationHandler = (InvocationHandler) unmarshallingContext.convertAnother(newProxyInstance, cls);
        hierarchicalStreamReader.moveUp();
        Field field = HANDLER;
        if (field != null) {
            Fields.write(field, newProxyInstance, invocationHandler);
            return newProxyInstance;
        }
        return Proxy.newProxyInstance(this.classLoaderReference.getReference(), clsArr, invocationHandler);
    }
}
