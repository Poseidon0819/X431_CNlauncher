package com.thoughtworks.xstream;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.p366io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.xml.XppDriver;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes2.dex */
public class XStreamer {
    public String toXML(XStream xStream, Object obj) throws ObjectStreamException {
        StringWriter stringWriter = new StringWriter();
        try {
            toXML(xStream, obj, stringWriter);
            return stringWriter.toString();
        } catch (ObjectStreamException e) {
            throw e;
        } catch (IOException e2) {
            throw new ConversionException("Unexpeced IO error from a StringWriter", e2);
        }
    }

    public void toXML(XStream xStream, Object obj, Writer writer) throws IOException {
        ObjectOutputStream createObjectOutputStream = new XStream().createObjectOutputStream(writer);
        try {
            createObjectOutputStream.writeObject(xStream);
            createObjectOutputStream.flush();
            xStream.toXML(obj, writer);
        } finally {
            createObjectOutputStream.close();
        }
    }

    public Object fromXML(String str) throws ClassNotFoundException, ObjectStreamException {
        try {
            return fromXML(new StringReader(str));
        } catch (ObjectStreamException e) {
            throw e;
        } catch (IOException e2) {
            throw new ConversionException("Unexpeced IO error from a StringReader", e2);
        }
    }

    public Object fromXML(HierarchicalStreamDriver hierarchicalStreamDriver, String str) throws ClassNotFoundException, ObjectStreamException {
        try {
            return fromXML(hierarchicalStreamDriver, new StringReader(str));
        } catch (ObjectStreamException e) {
            throw e;
        } catch (IOException e2) {
            throw new ConversionException("Unexpeced IO error from a StringReader", e2);
        }
    }

    public Object fromXML(Reader reader) throws IOException, ClassNotFoundException {
        return fromXML(new XppDriver(), reader);
    }

    public Object fromXML(HierarchicalStreamDriver hierarchicalStreamDriver, Reader reader) throws IOException, ClassNotFoundException {
        XStream xStream = new XStream(hierarchicalStreamDriver);
        HierarchicalStreamReader createReader = hierarchicalStreamDriver.createReader(reader);
        ObjectInputStream createObjectInputStream = xStream.createObjectInputStream(createReader);
        try {
            ObjectInputStream createObjectInputStream2 = ((XStream) createObjectInputStream.readObject()).createObjectInputStream(createReader);
            Object readObject = createObjectInputStream2.readObject();
            createObjectInputStream2.close();
            return readObject;
        } finally {
            createObjectInputStream.close();
        }
    }
}
