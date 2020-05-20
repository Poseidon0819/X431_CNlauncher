package com.cnlaunch.p169im.p174db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.golo3.p165g.CommonUtils;
import com.unionpay.tsmservice.data.Constant;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import message.model.ChatMessage;

/* renamed from: com.cnlaunch.im.db.MessageDao */
/* loaded from: classes.dex */
public class MessageDao extends AbstractDao<ChatMessage, Long> {
    public static final String TABLENAME = "message";

    /* renamed from: com.cnlaunch.im.db.MessageDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: id */
        public static final Property f9210id = new Property(0, Long.class, "id", true, "id");
        public static final Property roomId = new Property(1, Integer.class, "roomId", false, "roomId");
        public static final Property roomType = new Property(2, String.class, "roomType", false, "roomType");
        public static final Property speakerId = new Property(3, Integer.class, "speakerId", false, "speakerId");
        public static final Property status = new Property(4, String.class, "status", false, "status");
        public static final Property flag = new Property(5, String.class, "flag", false, "flag");
        public static final Property time = new Property(6, Integer.class, "time", false, "time");
        public static final Property content = new Property(7, String.class, "content", false, "content");
        public static final Property expansion = new Property(8, String.class, "expansion", false, "expansion");
        public static final Property subType = new Property(9, Integer.class, "subType", false, "subType");
        public static final Property messageId = new Property(10, String.class, Constant.KEY_MESSAGE_ID, false, Constant.KEY_MESSAGE_ID);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, ChatMessage chatMessage) {
        ChatMessage chatMessage2 = chatMessage;
        sQLiteStatement.clearBindings();
        Long l = chatMessage2.f24056a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        if (!CommonUtils.m9149a(chatMessage2.f24057b)) {
            sQLiteStatement.bindString(Properties.roomId.ordinal + 1, chatMessage2.f24057b);
        }
        if (!CommonUtils.m9149a(chatMessage2.f24058c)) {
            sQLiteStatement.bindString(Properties.roomType.ordinal + 1, chatMessage2.f24058c);
        }
        if (!CommonUtils.m9149a(chatMessage2.f24060e)) {
            sQLiteStatement.bindString(Properties.speakerId.ordinal + 1, chatMessage2.f24060e);
        }
        if (!CommonUtils.m9149a(chatMessage2.f24061f)) {
            sQLiteStatement.bindString(Properties.status.ordinal + 1, chatMessage2.f24061f);
        }
        if (!CommonUtils.m9149a(chatMessage2.f24059d)) {
            sQLiteStatement.bindString(Properties.flag.ordinal + 1, chatMessage2.f24059d);
        }
        sQLiteStatement.bindString(Properties.time.ordinal + 1, String.valueOf(chatMessage2.f24062g));
        if (!CommonUtils.m9149a(chatMessage2.f24063h)) {
            sQLiteStatement.bindString(Properties.content.ordinal + 1, chatMessage2.f24063h);
        }
        if (!CommonUtils.m9149a(chatMessage2.f24064i)) {
            sQLiteStatement.bindString(Properties.expansion.ordinal + 1, chatMessage2.f24064i);
        }
        sQLiteStatement.bindString(Properties.subType.ordinal + 1, String.valueOf(chatMessage2.f24066k));
        if (CommonUtils.m9149a(chatMessage2.f24067l)) {
            return;
        }
        sQLiteStatement.bindString(Properties.messageId.ordinal + 1, chatMessage2.f24067l);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* bridge */ /* synthetic */ Long getKey(ChatMessage chatMessage) {
        ChatMessage chatMessage2 = chatMessage;
        if (chatMessage2 != null) {
            return chatMessage2.f24056a;
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, ChatMessage chatMessage, int i) {
        int i2 = i + 0;
        chatMessage.f24056a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(ChatMessage chatMessage, long j) {
        chatMessage.f24056a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public MessageDao(DaoConfig daoConfig, GoloDaoSession goloDaoSession) {
        super(daoConfig, goloDaoSession);
    }

    /* renamed from: a */
    public static void m8766a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE message(" + Properties.f9210id.columnName + " INTEGER PRIMARY KEY ," + Properties.roomId.columnName + " INTEGER," + Properties.roomType.columnName + " TEXT," + Properties.speakerId.columnName + " Integer," + Properties.status.columnName + " TEXT," + Properties.flag.columnName + " TEXT," + Properties.time.columnName + " INTEGER," + Properties.content.columnName + " TEXT," + Properties.expansion.columnName + " TEXT," + Properties.subType.columnName + " INTEGER," + Properties.messageId.columnName + " TEXT UNIQUE );");
        StringBuilder sb = new StringBuilder("create index if not exists message_roomid on message(");
        sb.append(Properties.roomId.columnName);
        sb.append(")");
        sQLiteDatabase.execSQL(sb.toString());
    }

    /* renamed from: b */
    public static void m8765b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS message");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ ChatMessage readEntity(Cursor cursor, int i) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.f24056a = Long.valueOf(cursor.getLong(Properties.f9210id.ordinal));
        chatMessage.f24057b = String.valueOf(cursor.getInt(Properties.roomId.ordinal));
        chatMessage.f24058c = cursor.getString(Properties.roomType.ordinal);
        chatMessage.f24060e = String.valueOf(cursor.getInt(Properties.speakerId.ordinal));
        chatMessage.f24061f = cursor.getString(Properties.status.ordinal);
        chatMessage.f24059d = cursor.getString(Properties.flag.ordinal);
        chatMessage.f24062g = Long.valueOf(cursor.getLong(Properties.time.ordinal));
        chatMessage.f24063h = cursor.getString(Properties.content.ordinal);
        chatMessage.f24064i = cursor.getString(Properties.expansion.ordinal);
        chatMessage.f24066k = Integer.valueOf(cursor.getInt(Properties.subType.ordinal));
        chatMessage.f24067l = cursor.getString(Properties.messageId.ordinal);
        return chatMessage;
    }
}
