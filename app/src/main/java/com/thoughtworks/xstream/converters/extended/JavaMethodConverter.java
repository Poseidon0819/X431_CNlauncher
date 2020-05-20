package com.thoughtworks.xstream.converters.extended;

import com.itextpdf.text.html.HtmlTags;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class JavaMethodConverter implements Converter {
    private final SingleValueConverter javaClassConverter;

    public JavaMethodConverter(ClassLoaderReference classLoaderReference) {
        this(new JavaClassConverter(classLoaderReference));
    }

    public JavaMethodConverter(ClassLoader classLoader) {
        this(new ClassLoaderReference(classLoader));
    }

    protected JavaMethodConverter(SingleValueConverter singleValueConverter) {
        this.javaClassConverter = singleValueConverter;
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Method.class) || cls.equals(Constructor.class);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        if (obj instanceof Method) {
            Method method = (Method) obj;
            marshalMethod(hierarchicalStreamWriter, this.javaClassConverter.toString(method.getDeclaringClass()), method.getName(), method.getParameterTypes());
            return;
        }
        Constructor constructor = (Constructor) obj;
        marshalMethod(hierarchicalStreamWriter, this.javaClassConverter.toString(constructor.getDeclaringClass()), null, constructor.getParameterTypes());
    }

    private void marshalMethod(HierarchicalStreamWriter hierarchicalStreamWriter, String str, String str2, Class[] clsArr) {
        hierarchicalStreamWriter.startNode(HtmlTags.CLASS);
        hierarchicalStreamWriter.setValue(str);
        hierarchicalStreamWriter.endNode();
        if (str2 != null) {
            hierarchicalStreamWriter.startNode("name");
            hierarchicalStreamWriter.setValue(str2);
            hierarchicalStreamWriter.endNode();
        }
        hierarchicalStreamWriter.startNode("parameter-types");
        for (Class cls : clsArr) {
            hierarchicalStreamWriter.startNode(HtmlTags.CLASS);
            hierarchicalStreamWriter.setValue(this.javaClassConverter.toString(cls));
            hierarchicalStreamWriter.endNode();
        }
        hierarchicalStreamWriter.endNode();
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        try {
            boolean equals = unmarshallingContext.getRequiredType().equals(Method.class);
            hierarchicalStreamReader.moveDown();
            Class cls = (Class) this.javaClassConverter.fromString(hierarchicalStreamReader.getValue());
            hierarchicalStreamReader.moveUp();
            String str = null;
            if (equals) {
                hierarchicalStreamReader.moveDown();
                str = hierarchicalStreamReader.getValue();
                hierarchicalStreamReader.moveUp();
            }
            hierarchicalStreamReader.moveDown();
            ArrayList arrayList = new ArrayList();
            while (hierarchicalStreamReader.hasMoreChildren()) {
                hierarchicalStreamReader.moveDown();
                arrayList.add(this.javaClassConverter.fromString(hierarchicalStreamReader.getValue()));
                hierarchicalStreamReader.moveUp();
            }
            Class<?>[] clsArr = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
            hierarchicalStreamReader.moveUp();
            if (equals) {
                return cls.getDeclaredMethod(str, clsArr);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (NoSuchMethodException e) {
            throw new ConversionException(e);
        }
    }
}
