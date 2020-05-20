package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.util.CustomObjectInputStream;
import com.thoughtworks.xstream.core.util.CustomObjectOutputStream;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import java.io.Externalizable;
import java.io.IOException;
import java.io.NotActiveException;
import java.io.ObjectInputValidation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes2.dex */
public class ExternalizableConverter implements Converter {
    private final ClassLoaderReference classLoaderReference;
    private Mapper mapper;

    public ExternalizableConverter(Mapper mapper, ClassLoaderReference classLoaderReference) {
        this.mapper = mapper;
        this.classLoaderReference = classLoaderReference;
    }

    public ExternalizableConverter(Mapper mapper, ClassLoader classLoader) {
        this(mapper, new ClassLoaderReference(classLoader));
    }

    public ExternalizableConverter(Mapper mapper) {
        this(mapper, ExternalizableConverter.class.getClassLoader());
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return Externalizable.class.isAssignableFrom(cls);
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public void marshal(Object obj, final HierarchicalStreamWriter hierarchicalStreamWriter, final MarshallingContext marshallingContext) {
        try {
            CustomObjectOutputStream customObjectOutputStream = CustomObjectOutputStream.getInstance(marshallingContext, new CustomObjectOutputStream.StreamCallback() { // from class: com.thoughtworks.xstream.converters.reflection.ExternalizableConverter.1
                @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
                public void writeToStream(Object obj2) {
                    if (obj2 != null) {
                        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, ExternalizableConverter.this.mapper.serializedClass(obj2.getClass()), obj2.getClass());
                        marshallingContext.convertAnother(obj2);
                        hierarchicalStreamWriter.endNode();
                        return;
                    }
                    hierarchicalStreamWriter.startNode("null");
                    hierarchicalStreamWriter.endNode();
                }

                @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
                public void writeFieldsToStream(Map map) {
                    throw new UnsupportedOperationException();
                }

                @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
                public void defaultWriteObject() {
                    throw new UnsupportedOperationException();
                }

                @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
                public void flush() {
                    hierarchicalStreamWriter.flush();
                }

                @Override // com.thoughtworks.xstream.core.util.CustomObjectOutputStream.StreamCallback
                public void close() {
                    throw new UnsupportedOperationException("Objects are not allowed to call ObjectOutput.close() from writeExternal()");
                }
            });
            ((Externalizable) obj).writeExternal(customObjectOutputStream);
            customObjectOutputStream.popCallback();
        } catch (IOException e) {
            throw new ConversionException("Cannot serialize " + obj.getClass().getName() + " using Externalization", e);
        }
    }

    @Override // com.thoughtworks.xstream.converters.Converter
    public Object unmarshal(final HierarchicalStreamReader hierarchicalStreamReader, final UnmarshallingContext unmarshallingContext) {
        Class requiredType = unmarshallingContext.getRequiredType();
        try {
            Constructor declaredConstructor = requiredType.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            final Externalizable externalizable = (Externalizable) declaredConstructor.newInstance(null);
            CustomObjectInputStream customObjectInputStream = CustomObjectInputStream.getInstance(unmarshallingContext, new CustomObjectInputStream.StreamCallback() { // from class: com.thoughtworks.xstream.converters.reflection.ExternalizableConverter.2
                @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
                public Object readFromStream() {
                    hierarchicalStreamReader.moveDown();
                    Object convertAnother = unmarshallingContext.convertAnother(externalizable, HierarchicalStreams.readClassType(hierarchicalStreamReader, ExternalizableConverter.this.mapper));
                    hierarchicalStreamReader.moveUp();
                    return convertAnother;
                }

                @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
                public Map readFieldsFromStream() {
                    throw new UnsupportedOperationException();
                }

                @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
                public void defaultReadObject() {
                    throw new UnsupportedOperationException();
                }

                @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
                public void registerValidation(ObjectInputValidation objectInputValidation, int i) throws NotActiveException {
                    throw new NotActiveException("stream inactive");
                }

                @Override // com.thoughtworks.xstream.core.util.CustomObjectInputStream.StreamCallback
                public void close() {
                    throw new UnsupportedOperationException("Objects are not allowed to call ObjectInput.close() from readExternal()");
                }
            }, this.classLoaderReference);
            externalizable.readExternal(customObjectInputStream);
            customObjectInputStream.popCallback();
            return externalizable;
        } catch (IOException e) {
            throw new ConversionException("Cannot externalize " + requiredType.getClass(), e);
        } catch (ClassNotFoundException e2) {
            throw new ConversionException("Cannot externalize " + requiredType.getClass(), e2);
        } catch (IllegalAccessException e3) {
            throw new ConversionException("Cannot construct " + requiredType.getClass(), e3);
        } catch (InstantiationException e4) {
            throw new ConversionException("Cannot construct " + requiredType.getClass(), e4);
        } catch (NoSuchMethodException e5) {
            throw new ConversionException("Cannot construct " + requiredType.getClass() + ", missing default constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new ConversionException("Cannot construct " + requiredType.getClass(), e6);
        }
    }
}
