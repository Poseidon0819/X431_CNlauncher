package de.greenrobot.dao.test;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;

/* loaded from: classes2.dex */
public abstract class AbstractDaoSessionTest<A extends Application, T extends AbstractDaoMaster, S extends AbstractDaoSession> extends DbTest<A> {
    protected T daoMaster;
    private final Class<T> daoMasterClass;
    protected S daoSession;

    public AbstractDaoSessionTest(Class<T> cls) {
        this(cls, true);
    }

    public AbstractDaoSessionTest(Class<T> cls, boolean z) {
        super(z);
        this.daoMasterClass = cls;
    }

    public AbstractDaoSessionTest(Class<A> cls, Class<T> cls2, boolean z) {
        super(cls, z);
        this.daoMasterClass = cls2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // de.greenrobot.dao.test.DbTest
    public void setUp() {
        super.setUp();
        try {
            this.daoMaster = this.daoMasterClass.getConstructor(SQLiteDatabase.class).newInstance(this.f23929db);
            this.daoMasterClass.getMethod("createAllTables", SQLiteDatabase.class, Boolean.TYPE).invoke(null, this.f23929db, Boolean.FALSE);
            this.daoSession = (S) this.daoMaster.newSession();
        } catch (Exception e) {
            throw new RuntimeException("Could not prepare DAO session test", e);
        }
    }
}
