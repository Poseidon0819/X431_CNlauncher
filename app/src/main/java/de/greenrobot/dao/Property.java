package de.greenrobot.dao;

import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.WhereCondition;
import java.util.Collection;

/* loaded from: classes2.dex */
public class Property {
    public final String columnName;
    public final String name;
    public final int ordinal;
    public final boolean primaryKey;
    public final Class<?> type;

    public Property(int i, Class<?> cls, String str, boolean z, String str2) {
        this.ordinal = i;
        this.type = cls;
        this.name = str;
        this.primaryKey = z;
        this.columnName = str2;
    }

    /* renamed from: eq */
    public WhereCondition m321eq(Object obj) {
        return new WhereCondition.PropertyCondition(this, "=?", obj);
    }

    public WhereCondition notEq(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<>?", obj);
    }

    public WhereCondition like(String str) {
        return new WhereCondition.PropertyCondition(this, " LIKE ?", str);
    }

    public WhereCondition between(Object obj, Object obj2) {
        return new WhereCondition.PropertyCondition(this, " BETWEEN ? AND ?", new Object[]{obj, obj2});
    }

    /* renamed from: in */
    public WhereCondition m317in(Object... objArr) {
        StringBuilder sb = new StringBuilder(" IN (");
        SqlUtils.appendPlaceholders(sb, objArr.length).append(')');
        return new WhereCondition.PropertyCondition(this, sb.toString(), objArr);
    }

    /* renamed from: in */
    public WhereCondition m318in(Collection<?> collection) {
        return m317in(collection.toArray());
    }

    public WhereCondition notIn(Object... objArr) {
        StringBuilder sb = new StringBuilder(" NOT IN (");
        SqlUtils.appendPlaceholders(sb, objArr.length).append(')');
        return new WhereCondition.PropertyCondition(this, sb.toString(), objArr);
    }

    public WhereCondition notIn(Collection<?> collection) {
        return notIn(collection.toArray());
    }

    /* renamed from: gt */
    public WhereCondition m319gt(Object obj) {
        return new WhereCondition.PropertyCondition(this, ">?", obj);
    }

    /* renamed from: lt */
    public WhereCondition m315lt(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<?", obj);
    }

    /* renamed from: ge */
    public WhereCondition m320ge(Object obj) {
        return new WhereCondition.PropertyCondition(this, ">=?", obj);
    }

    /* renamed from: le */
    public WhereCondition m316le(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<=?", obj);
    }

    public WhereCondition isNull() {
        return new WhereCondition.PropertyCondition(this, " IS NULL");
    }

    public WhereCondition isNotNull() {
        return new WhereCondition.PropertyCondition(this, " IS NOT NULL");
    }
}
