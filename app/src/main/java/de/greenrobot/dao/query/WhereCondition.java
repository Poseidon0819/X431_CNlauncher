package de.greenrobot.dao.query;

import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public interface WhereCondition {
    void appendTo(StringBuilder sb, String str);

    void appendValuesTo(List<Object> list);

    /* loaded from: classes2.dex */
    public static abstract class AbstractCondition implements WhereCondition {
        protected final boolean hasSingleValue;
        protected final Object value;
        protected final Object[] values;

        public AbstractCondition() {
            this.hasSingleValue = false;
            this.value = null;
            this.values = null;
        }

        public AbstractCondition(Object obj) {
            this.value = obj;
            this.hasSingleValue = true;
            this.values = null;
        }

        public AbstractCondition(Object[] objArr) {
            this.value = null;
            this.hasSingleValue = false;
            this.values = objArr;
        }

        @Override // de.greenrobot.dao.query.WhereCondition
        public void appendValuesTo(List<Object> list) {
            if (this.hasSingleValue) {
                list.add(this.value);
            }
            Object[] objArr = this.values;
            if (objArr != null) {
                for (Object obj : objArr) {
                    list.add(obj);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PropertyCondition extends AbstractCondition {

        /* renamed from: op */
        public final String f23928op;
        public final Property property;

        private static Object checkValueForType(Property property, Object obj) {
            if (obj != null && obj.getClass().isArray()) {
                throw new DaoException("Illegal value: found array, but simple object required");
            }
            if (property.type == Date.class) {
                if (obj instanceof Date) {
                    return Long.valueOf(((Date) obj).getTime());
                }
                if (obj instanceof Long) {
                    return obj;
                }
                throw new DaoException("Illegal date value: expected java.util.Date or Long for value ".concat(String.valueOf(obj)));
            }
            if (property.type == Boolean.TYPE || property.type == Boolean.class) {
                if (obj instanceof Boolean) {
                    return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                }
                if (obj instanceof Number) {
                    int intValue = ((Number) obj).intValue();
                    if (intValue != 0 && intValue != 1) {
                        throw new DaoException("Illegal boolean value: numbers must be 0 or 1, but was ".concat(String.valueOf(obj)));
                    }
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if ("TRUE".equalsIgnoreCase(str)) {
                        return 1;
                    }
                    if ("FALSE".equalsIgnoreCase(str)) {
                        return 0;
                    }
                    throw new DaoException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insesnsitive), but was ".concat(String.valueOf(obj)));
                }
            }
            return obj;
        }

        private static Object[] checkValuesForType(Property property, Object[] objArr) {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = checkValueForType(property, objArr[i]);
            }
            return objArr;
        }

        public PropertyCondition(Property property, String str) {
            this.property = property;
            this.f23928op = str;
        }

        public PropertyCondition(Property property, String str, Object obj) {
            super(checkValueForType(property, obj));
            this.property = property;
            this.f23928op = str;
        }

        public PropertyCondition(Property property, String str, Object[] objArr) {
            super(checkValuesForType(property, objArr));
            this.property = property;
            this.f23928op = str;
        }

        @Override // de.greenrobot.dao.query.WhereCondition
        public void appendTo(StringBuilder sb, String str) {
            if (str != null) {
                sb.append(str);
                sb.append('.');
            }
            sb.append('\'');
            sb.append(this.property.columnName);
            sb.append('\'');
            sb.append(this.f23928op);
        }
    }

    /* loaded from: classes2.dex */
    public static class StringCondition extends AbstractCondition {
        protected final String string;

        public StringCondition(String str) {
            this.string = str;
        }

        public StringCondition(String str, Object obj) {
            super(obj);
            this.string = str;
        }

        public StringCondition(String str, Object... objArr) {
            super(objArr);
            this.string = str;
        }

        @Override // de.greenrobot.dao.query.WhereCondition
        public void appendTo(StringBuilder sb, String str) {
            sb.append(this.string);
        }
    }
}
