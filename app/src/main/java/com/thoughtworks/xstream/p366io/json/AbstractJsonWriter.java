package com.thoughtworks.xstream.p366io.json;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.p366io.AbstractWriter;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import com.thoughtworks.xstream.p366io.naming.NoNameCoder;
import java.io.Externalizable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.thoughtworks.xstream.io.json.AbstractJsonWriter */
/* loaded from: classes2.dex */
public abstract class AbstractJsonWriter extends AbstractWriter {
    public static final int DROP_ROOT_MODE = 1;
    public static final int EXPLICIT_MODE = 4;
    public static final int IEEE_754_MODE = 8;
    private static final Set NUMBER_TYPES = new HashSet(Arrays.asList(Byte.TYPE, Byte.class, Short.TYPE, Short.class, Integer.TYPE, Integer.class, Long.TYPE, Long.class, Float.TYPE, Float.class, Double.TYPE, Double.class, BigInteger.class, BigDecimal.class));
    private static final int STATE_END_ATTRIBUTES = 32;
    private static final int STATE_END_ELEMENTS = 256;
    private static final int STATE_END_OBJECT = 2;
    private static final int STATE_NEXT_ATTRIBUTE = 16;
    private static final int STATE_NEXT_ELEMENT = 128;
    private static final int STATE_ROOT = 1;
    private static final int STATE_SET_VALUE = 512;
    private static final int STATE_START_ATTRIBUTES = 8;
    private static final int STATE_START_ELEMENTS = 64;
    private static final int STATE_START_OBJECT = 4;
    public static final int STRICT_MODE = 2;
    private int expectedStates;
    private int mode;
    private FastStack stack;

    /* renamed from: com.thoughtworks.xstream.io.json.AbstractJsonWriter$Type */
    /* loaded from: classes2.dex */
    public static class Type {
        public static Type NULL = new Type();
        public static Type STRING = new Type();
        public static Type NUMBER = new Type();
        public static Type BOOLEAN = new Type();
    }

    protected abstract void addLabel(String str);

    protected abstract void addValue(String str, Type type);

    protected abstract void endArray();

    protected abstract void endObject();

    protected abstract void nextElement();

    protected abstract void startArray();

    protected abstract void startObject();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.thoughtworks.xstream.io.json.AbstractJsonWriter$StackElement */
    /* loaded from: classes2.dex */
    public static class StackElement {
        int status;
        final Class type;

        public StackElement(Class cls, int i) {
            this.type = cls;
            this.status = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException */
    /* loaded from: classes2.dex */
    public static class IllegalWriterStateException extends IllegalStateException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public IllegalWriterStateException(int r3, int r4, java.lang.String r5) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Cannot turn from state "
                r0.<init>(r1)
                java.lang.String r3 = getState(r3)
                r0.append(r3)
                java.lang.String r3 = " into state "
                r0.append(r3)
                java.lang.String r3 = getState(r4)
                r0.append(r3)
                if (r5 != 0) goto L1f
                java.lang.String r3 = ""
                goto L29
            L1f:
                java.lang.String r3 = " for property "
                java.lang.String r4 = java.lang.String.valueOf(r5)
                java.lang.String r3 = r3.concat(r4)
            L29:
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.p366io.json.AbstractJsonWriter.IllegalWriterStateException.<init>(int, int, java.lang.String):void");
        }

        private static String getState(int i) {
            if (i != 4) {
                if (i != 8) {
                    if (i != 16) {
                        if (i != 32) {
                            if (i != 64) {
                                if (i != 128) {
                                    if (i != 256) {
                                        if (i != 512) {
                                            switch (i) {
                                                case 1:
                                                    return "ROOT";
                                                case 2:
                                                    return "END_OBJECT";
                                                default:
                                                    throw new IllegalArgumentException("Unknown state provided: " + i + ", cannot create message for IllegalWriterStateException");
                                            }
                                        }
                                        return "SET_VALUE";
                                    }
                                    return "END_ELEMENTS";
                                }
                                return "NEXT_ELEMENT";
                            }
                            return "START_ELEMENTS";
                        }
                        return "END_ATTRIBUTES";
                    }
                    return "NEXT_ATTRIBUTE";
                }
                return "START_ATTRIBUTES";
            }
            return "START_OBJECT";
        }
    }

    public AbstractJsonWriter() {
        this(new NoNameCoder());
    }

    public AbstractJsonWriter(int i) {
        this(i, new NoNameCoder());
    }

    public AbstractJsonWriter(NameCoder nameCoder) {
        this(0, nameCoder);
    }

    public AbstractJsonWriter(int i, NameCoder nameCoder) {
        super(nameCoder);
        this.stack = new FastStack(16);
        this.mode = (i & 4) > 0 ? 4 : i;
        this.stack.push(new StackElement(null, 1));
        this.expectedStates = 4;
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractWriter, com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriter
    public void startNode(String str, Class cls) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        FastStack fastStack = this.stack;
        fastStack.push(new StackElement(cls, ((StackElement) fastStack.peek()).status));
        handleCheckedStateTransition(4, str, null);
        this.expectedStates = 661;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void startNode(String str) {
        startNode(str, null);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        handleCheckedStateTransition(16, str, str2);
        this.expectedStates = 661;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        Class cls = ((StackElement) this.stack.peek()).type;
        if ((cls == Character.class || cls == Character.TYPE) && "".equals(str)) {
            str = "\u0000";
        }
        handleCheckedStateTransition(512, null, str);
        this.expectedStates = 129;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void endNode() {
        int size = this.stack.size();
        int i = size > 2 ? 128 : 1;
        handleCheckedStateTransition(i, null, null);
        this.stack.pop();
        ((StackElement) this.stack.peek()).status = i;
        this.expectedStates = 4;
        if (size > 2) {
            this.expectedStates |= 129;
        }
    }

    private void handleCheckedStateTransition(int i, String str, String str2) {
        StackElement stackElement = (StackElement) this.stack.peek();
        if ((this.expectedStates & i) == 0) {
            throw new IllegalWriterStateException(stackElement.status, i, str);
        }
        stackElement.status = handleStateTransition(stackElement.status, i, str, str2);
    }

    private int handleStateTransition(int i, int i2, String str, String str2) {
        String str3;
        String str4;
        int size = this.stack.size();
        Class cls = ((StackElement) this.stack.peek()).type;
        boolean z = false;
        boolean z2 = size > 1 && isArray(cls);
        if (size > 1 && isArray(((StackElement) this.stack.get(size - 2)).type)) {
            z = true;
        }
        if (i == 4) {
            if (i2 != 1 && i2 != 4) {
                if (i2 == 8) {
                    if ((this.mode & 4) != 0) {
                        startArray();
                    }
                    return i2;
                } else if (i2 == 16) {
                    if ((this.mode & 4) == 0 && z2) {
                        return 4;
                    }
                    handleStateTransition(handleStateTransition(i, 8, null, null), 16, str, str2);
                    return i2;
                } else if (i2 != 128 && i2 != 512) {
                    throw new IllegalWriterStateException(i, i2, str);
                }
            }
            if (z && (this.mode & 4) == 0) {
                str3 = null;
            } else {
                str3 = null;
                handleStateTransition(handleStateTransition(i, 8, null, null), 32, null, null);
            }
            if (i2 != 1) {
                if (i2 == 4) {
                    handleStateTransition(64, 4, str, str3);
                } else if (i2 != 128) {
                    if (i2 == 512) {
                        handleStateTransition(64, 512, str3, str2);
                    }
                }
                return i2;
            }
            handleStateTransition(handleStateTransition(64, 512, str3, str3), i2, str3, str3);
            return i2;
        }
        if (i != 8) {
            if (i != 16) {
                if (i == 32) {
                    if (i2 == 2) {
                        handleStateTransition(handleStateTransition(64, 256, null, null), 2, null, null);
                    } else if (i2 == 64) {
                        if ((this.mode & 4) == 0) {
                            nextElement();
                        }
                    } else {
                        throw new IllegalWriterStateException(i, i2, str);
                    }
                    return i2;
                }
                if (i != 64) {
                    if (i != 128) {
                        if (i == 256) {
                            if (i2 == 2) {
                                if ((this.mode & 4) != 0) {
                                    endArray();
                                    endArray();
                                    endObject();
                                }
                                return i2;
                            }
                            throw new IllegalWriterStateException(i, i2, str);
                        } else if (i == 512) {
                            if (i2 == 1) {
                                handleStateTransition(handleStateTransition(handleStateTransition(i, 256, null, null), 2, null, null), 1, null, null);
                                return i2;
                            } else if (i2 == 128) {
                                handleStateTransition(handleStateTransition(i, 256, null, null), 2, null, null);
                                return i2;
                            } else if (i2 == 256) {
                                if ((this.mode & 4) == 0 && z2) {
                                    endArray();
                                }
                                return i2;
                            } else {
                                throw new IllegalWriterStateException(i, i2, str);
                            }
                        } else {
                            switch (i) {
                                case 1:
                                    if (i2 == 4) {
                                        handleStateTransition(64, 4, str, null);
                                        return i2;
                                    }
                                    throw new IllegalWriterStateException(i, i2, str);
                                case 2:
                                    if (i2 == 1) {
                                        if (((this.mode & 1) == 0 || size > 2) && (this.mode & 4) == 0) {
                                            endObject();
                                        }
                                        return i2;
                                    } else if (i2 == 4) {
                                        handleStateTransition(handleStateTransition(i, 128, null, null), 4, str, null);
                                        return i2;
                                    } else if (i2 == 128) {
                                        nextElement();
                                        return i2;
                                    } else {
                                        throw new IllegalWriterStateException(i, i2, str);
                                    }
                                default:
                                    throw new IllegalWriterStateException(i, i2, str);
                            }
                        }
                    } else if (i2 == 4) {
                        nextElement();
                        if (!z && (this.mode & 4) == 0) {
                            addLabel(encodeNode(str));
                            if ((this.mode & 4) == 0 && z2) {
                                startArray();
                            }
                            return i2;
                        }
                    } else {
                        if (i2 != 128) {
                            if (i2 != 256) {
                                switch (i2) {
                                    case 1:
                                        handleStateTransition(handleStateTransition(i, 2, null, null), 1, null, null);
                                        return i2;
                                    case 2:
                                        break;
                                    default:
                                        throw new IllegalWriterStateException(i, i2, str);
                                }
                            } else {
                                if ((this.mode & 4) == 0 && z2) {
                                    endArray();
                                }
                                return i2;
                            }
                        }
                        handleStateTransition(handleStateTransition(i, 256, null, null), 2, null, null);
                        if ((this.mode & 4) == 0 && !z2) {
                            endObject();
                        }
                        return i2;
                    }
                }
                if (i2 == 4) {
                    if ((this.mode & 1) == 0 || size > 2) {
                        if (!z || (this.mode & 4) != 0) {
                            if (!"".equals(str2)) {
                                startObject();
                            }
                            addLabel(encodeNode(str));
                        }
                        if ((this.mode & 4) != 0) {
                            startArray();
                        }
                    }
                    if ((this.mode & 4) == 0 && z2) {
                        startArray();
                    }
                    return i2;
                } else if (i2 == 128 || i2 == 256) {
                    if ((this.mode & 4) == 0) {
                        if (z2) {
                            endArray();
                        } else {
                            endObject();
                        }
                    }
                    return i2;
                } else if (i2 == 512) {
                    if ((this.mode & 2) == 0 || size != 2) {
                        if (str2 == null) {
                            if (cls == Mapper.Null.class) {
                                addValue("null", Type.NULL);
                            } else if ((this.mode & 4) == 0 && !z2) {
                                startObject();
                                endObject();
                            }
                        } else if ((this.mode & 8) != 0 && (cls == Long.TYPE || cls == Long.class)) {
                            long parseLong = Long.parseLong(str2);
                            if (parseLong > 9007199254740992L || parseLong < -9007199254740992L) {
                                addValue(str2, Type.STRING);
                            } else {
                                addValue(str2, getType(cls));
                            }
                        } else {
                            addValue(str2, getType(cls));
                        }
                        return i2;
                    }
                    throw new ConversionException("Single value cannot be root element");
                } else {
                    throw new IllegalWriterStateException(i, i2, str);
                }
            }
        } else if (i2 == 16) {
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                sb.append((this.mode & 4) == 0 ? "@" : "");
                sb.append(str);
                String sb2 = sb.toString();
                startObject();
                addLabel(encodeAttribute(sb2));
                addValue(str2, Type.STRING);
            }
            return i2;
        }
        if (i2 != 1) {
            if (i2 != 4) {
                if (i2 == 16) {
                    if (!z2 || (this.mode & 4) != 0) {
                        nextElement();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append((this.mode & 4) == 0 ? "@" : "");
                        sb3.append(str);
                        addLabel(encodeAttribute(sb3.toString()));
                        addValue(str2, Type.STRING);
                    }
                    return i2;
                } else if (i2 == 32) {
                    if ((this.mode & 4) != 0) {
                        if (i == 16) {
                            endObject();
                        }
                        endArray();
                        nextElement();
                        startArray();
                    }
                    return i2;
                } else if (i2 == 128) {
                    handleStateTransition(handleStateTransition(i, 32, null, null), 2, null, null);
                    return i2;
                } else if (i2 != 512) {
                    throw new IllegalWriterStateException(i, i2, str);
                }
            }
            int handleStateTransition = handleStateTransition(handleStateTransition(i, 32, null, null), 64, null, null);
            if (i2 == 2) {
                handleStateTransition(handleStateTransition(handleStateTransition, 512, null, null), 2, null, null);
            } else if (i2 == 4) {
                handleStateTransition(handleStateTransition, 4, str, (this.mode & 4) == 0 ? "" : null);
            } else if (i2 == 512) {
                if ((this.mode & 4) == 0) {
                    addLabel(encodeNode("$"));
                    str4 = null;
                } else {
                    str4 = null;
                }
                handleStateTransition(handleStateTransition, 512, str4, str2);
                if ((this.mode & 4) == 0) {
                    endObject();
                }
            }
            return i2;
        }
        handleStateTransition(handleStateTransition(handleStateTransition(i, 32, null, null), 2, null, null), 1, null, null);
        return i2;
    }

    protected Type getType(Class cls) {
        return cls == Mapper.Null.class ? Type.NULL : (cls == Boolean.class || cls == Boolean.TYPE) ? Type.BOOLEAN : NUMBER_TYPES.contains(cls) ? Type.NUMBER : Type.STRING;
    }

    protected boolean isArray(Class cls) {
        if (cls != null) {
            return cls.isArray() || Collection.class.isAssignableFrom(cls) || Externalizable.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls);
        }
        return false;
    }
}
