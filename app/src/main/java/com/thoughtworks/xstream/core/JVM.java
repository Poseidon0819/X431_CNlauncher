package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.reflection.FieldDictionary;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.util.DependencyInjectionFactory;
import com.thoughtworks.xstream.core.util.PresortedMap;
import com.thoughtworks.xstream.core.util.PresortedSet;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessControlException;
import java.text.AttributedString;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public class JVM implements Caching {
    private static final float DEFAULT_JAVA_VERSION = 1.4f;
    private static final boolean canAllocateWithUnsafe;
    private static final boolean canParseUTCDateFormat;
    private static final boolean isAWTAvailable;
    private static final boolean isSQLAvailable;
    private static final boolean isSwingAvailable;
    private static final boolean optimizedTreeMapPutAll;
    private static final boolean optimizedTreeSetAddAll;
    private static final Class reflectionProviderType;
    private static final boolean reverseFieldOrder = false;
    private ReflectionProvider reflectionProvider;
    private static final String vendor = System.getProperty("java.vm.vendor");
    private static final float majorJavaVersion = getMajorJavaVersion();

    public static boolean reverseFieldDefinition() {
        return false;
    }

    @Override // com.thoughtworks.xstream.core.Caching
    public void flushCache() {
    }

    static {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Class<PureJavaReflectionProvider> loadClassForName;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Method declaredMethod = cls.getDeclaredMethod("allocateInstance", Class.class);
            declaredMethod.setAccessible(true);
            z = declaredMethod.invoke(obj, Broken.class) != null;
        } catch (Error unused) {
            z = false;
        } catch (Exception unused2) {
            z = false;
        }
        canAllocateWithUnsafe = z;
        Comparator comparator = new Comparator() { // from class: com.thoughtworks.xstream.core.JVM.1
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                throw new RuntimeException();
            }
        };
        PresortedMap presortedMap = new PresortedMap(comparator);
        presortedMap.put("one", null);
        presortedMap.put("two", null);
        try {
            new TreeMap(comparator).putAll(presortedMap);
            z2 = true;
        } catch (RuntimeException unused3) {
            z2 = false;
        }
        optimizedTreeMapPutAll = z2;
        PresortedSet presortedSet = new PresortedSet(comparator);
        presortedSet.addAll(presortedMap.keySet());
        try {
            new TreeSet(comparator).addAll(presortedSet);
            z3 = true;
        } catch (RuntimeException unused4) {
            z3 = false;
        }
        optimizedTreeSetAddAll = z3;
        try {
            new SimpleDateFormat("z").parse("UTC");
            z4 = true;
        } catch (ParseException unused5) {
            z4 = false;
        }
        canParseUTCDateFormat = z4;
        isAWTAvailable = loadClassForName("java.awt.Color", false) != null;
        isSwingAvailable = loadClassForName("javax.swing.LookAndFeel", false) != null;
        isSQLAvailable = loadClassForName("java.sql.Date") != null;
        Class<PureJavaReflectionProvider> cls2 = PureJavaReflectionProvider.class;
        if (canUseSun14ReflectionProvider() && (loadClassForName = loadClassForName("com.thoughtworks.xstream.converters.reflection.Sun14ReflectionProvider")) != null) {
            try {
                DependencyInjectionFactory.newInstance(loadClassForName, null);
                cls2 = loadClassForName;
            } catch (ObjectAccessException unused6) {
            }
        }
        reflectionProviderType = cls2;
    }

    /* loaded from: classes2.dex */
    static class Broken {
        Broken() {
            throw new UnsupportedOperationException();
        }
    }

    private static final float getMajorJavaVersion() {
        try {
            if (isAndroid()) {
                return 1.5f;
            }
            return Float.parseFloat(System.getProperty("java.specification.version"));
        } catch (NumberFormatException unused) {
            return DEFAULT_JAVA_VERSION;
        }
    }

    public static boolean is14() {
        return majorJavaVersion >= DEFAULT_JAVA_VERSION;
    }

    public static boolean is15() {
        return majorJavaVersion >= 1.5f;
    }

    public static boolean is16() {
        return majorJavaVersion >= 1.6f;
    }

    public static boolean is17() {
        return majorJavaVersion >= 1.7f;
    }

    public static boolean is18() {
        return majorJavaVersion >= 1.8f;
    }

    private static boolean isIBM() {
        return vendor.indexOf("IBM") != -1;
    }

    private static boolean isAndroid() {
        return vendor.indexOf("Android") != -1;
    }

    public static Class loadClassForName(String str) {
        return loadClassForName(str, true);
    }

    public Class loadClass(String str) {
        return loadClassForName(str, true);
    }

    public static Class loadClassForName(String str, boolean z) {
        try {
            return Class.forName(str, z, JVM.class.getClassLoader());
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (LinkageError unused2) {
            return null;
        }
    }

    public Class loadClass(String str, boolean z) {
        return loadClassForName(str, z);
    }

    public static ReflectionProvider newReflectionProvider() {
        return (ReflectionProvider) DependencyInjectionFactory.newInstance(reflectionProviderType, null);
    }

    public static ReflectionProvider newReflectionProvider(FieldDictionary fieldDictionary) {
        return (ReflectionProvider) DependencyInjectionFactory.newInstance(reflectionProviderType, new Object[]{fieldDictionary});
    }

    public static Class getStaxInputFactory() throws ClassNotFoundException {
        if (is16()) {
            if (isIBM()) {
                return Class.forName("com.ibm.xml.xlxp.api.stax.XMLInputFactoryImpl");
            }
            return Class.forName("com.sun.xml.internal.stream.XMLInputFactoryImpl");
        }
        return null;
    }

    public static Class getStaxOutputFactory() throws ClassNotFoundException {
        if (is16()) {
            if (isIBM()) {
                return Class.forName("com.ibm.xml.xlxp.api.stax.XMLOutputFactoryImpl");
            }
            return Class.forName("com.sun.xml.internal.stream.XMLOutputFactoryImpl");
        }
        return null;
    }

    public synchronized ReflectionProvider bestReflectionProvider() {
        Class loadClassForName;
        if (this.reflectionProvider == null) {
            try {
                String str = canUseSun14ReflectionProvider() ? "com.thoughtworks.xstream.converters.reflection.Sun14ReflectionProvider" : null;
                if (str != null && (loadClassForName = loadClassForName(str)) != null) {
                    this.reflectionProvider = (ReflectionProvider) loadClassForName.newInstance();
                }
            } catch (IllegalAccessException | InstantiationException | AccessControlException unused) {
            }
            if (this.reflectionProvider == null) {
                this.reflectionProvider = new PureJavaReflectionProvider();
            }
        }
        return this.reflectionProvider;
    }

    private static boolean canUseSun14ReflectionProvider() {
        return canAllocateWithUnsafe && is14();
    }

    public static boolean isAWTAvailable() {
        return isAWTAvailable;
    }

    public boolean supportsAWT() {
        return isAWTAvailable;
    }

    public static boolean isSwingAvailable() {
        return isSwingAvailable;
    }

    public boolean supportsSwing() {
        return isSwingAvailable;
    }

    public static boolean isSQLAvailable() {
        return isSQLAvailable;
    }

    public boolean supportsSQL() {
        return isSQLAvailable;
    }

    public static boolean hasOptimizedTreeSetAddAll() {
        return optimizedTreeSetAddAll;
    }

    public static boolean hasOptimizedTreeMapPutAll() {
        return optimizedTreeMapPutAll;
    }

    public static boolean canParseUTCDateFormat() {
        return canParseUTCDateFormat;
    }

    public static void main(String[] strArr) {
        boolean z;
        String str;
        Field[] declaredFields = AttributedString.class.getDeclaredFields();
        int i = 0;
        while (true) {
            if (i >= declaredFields.length) {
                z = false;
                break;
            } else if (declaredFields[i].getName().equals("text")) {
                z = i > 3;
            } else {
                i++;
            }
        }
        if (z) {
            Field[] declaredFields2 = JVM.class.getDeclaredFields();
            int i2 = 0;
            while (true) {
                if (i2 >= declaredFields2.length) {
                    break;
                } else if (declaredFields2[i2].getName().equals("reflectionProvider")) {
                    z = i2 > 2;
                } else {
                    i2++;
                }
            }
        }
        String str2 = null;
        try {
            str = getStaxInputFactory().getName();
        } catch (ClassNotFoundException e) {
            str = e.getMessage();
        } catch (NullPointerException unused) {
            str = null;
        }
        try {
            getStaxOutputFactory().getName();
        } catch (ClassNotFoundException e2) {
            str2 = e2.getMessage();
            System.out.println("XStream JVM diagnostics");
            System.out.println("java.specification.version: " + System.getProperty("java.specification.version"));
            System.out.println("java.specification.vendor: " + System.getProperty("java.specification.vendor"));
            System.out.println("java.specification.name: " + System.getProperty("java.specification.name"));
            System.out.println("java.vm.vendor: " + vendor);
            System.out.println("java.vendor: " + System.getProperty("java.vendor"));
            System.out.println("java.vm.name: " + System.getProperty("java.vm.name"));
            System.out.println("Version: " + majorJavaVersion);
            System.out.println("XStream support for enhanced Mode: " + canUseSun14ReflectionProvider());
            System.out.println("Supports AWT: " + isAWTAvailable());
            System.out.println("Supports Swing: " + isSwingAvailable());
            System.out.println("Supports SQL: " + isSQLAvailable());
            System.out.println("Standard StAX XMLInputFactory: ".concat(String.valueOf(str)));
            System.out.println("Standard StAX XMLOutputFactory: ".concat(String.valueOf(str2)));
            System.out.println("Optimized TreeSet.addAll: " + hasOptimizedTreeSetAddAll());
            System.out.println("Optimized TreeMap.putAll: " + hasOptimizedTreeMapPutAll());
            System.out.println("Can parse UTC date format: " + canParseUTCDateFormat());
            System.out.println("Reverse field order detected (only if JVM class itself has been compiled): ".concat(String.valueOf(z)));
        } catch (NullPointerException unused2) {
            System.out.println("XStream JVM diagnostics");
            System.out.println("java.specification.version: " + System.getProperty("java.specification.version"));
            System.out.println("java.specification.vendor: " + System.getProperty("java.specification.vendor"));
            System.out.println("java.specification.name: " + System.getProperty("java.specification.name"));
            System.out.println("java.vm.vendor: " + vendor);
            System.out.println("java.vendor: " + System.getProperty("java.vendor"));
            System.out.println("java.vm.name: " + System.getProperty("java.vm.name"));
            System.out.println("Version: " + majorJavaVersion);
            System.out.println("XStream support for enhanced Mode: " + canUseSun14ReflectionProvider());
            System.out.println("Supports AWT: " + isAWTAvailable());
            System.out.println("Supports Swing: " + isSwingAvailable());
            System.out.println("Supports SQL: " + isSQLAvailable());
            System.out.println("Standard StAX XMLInputFactory: ".concat(String.valueOf(str)));
            System.out.println("Standard StAX XMLOutputFactory: ".concat(String.valueOf(str2)));
            System.out.println("Optimized TreeSet.addAll: " + hasOptimizedTreeSetAddAll());
            System.out.println("Optimized TreeMap.putAll: " + hasOptimizedTreeMapPutAll());
            System.out.println("Can parse UTC date format: " + canParseUTCDateFormat());
            System.out.println("Reverse field order detected (only if JVM class itself has been compiled): ".concat(String.valueOf(z)));
        }
    }
}
