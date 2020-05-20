package de.greenrobot.dao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes2.dex */
public final class FastCursor implements Cursor {
    private final int count;
    private int position;
    private final CursorWindow window;

    public FastCursor(CursorWindow cursorWindow) {
        this.window = cursorWindow;
        this.count = cursorWindow.getNumRows();
    }

    @Override // android.database.Cursor
    public final int getCount() {
        return this.window.getNumRows();
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return this.position;
    }

    @Override // android.database.Cursor
    public final boolean move(int i) {
        return moveToPosition(this.position + i);
    }

    @Override // android.database.Cursor
    public final boolean moveToPosition(int i) {
        if (i < 0 || i >= this.count) {
            return false;
        }
        this.position = i;
        return true;
    }

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        this.position = 0;
        return this.count > 0;
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        int i = this.count;
        if (i > 0) {
            this.position = i - 1;
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToNext() {
        int i = this.position;
        if (i < this.count - 1) {
            this.position = i + 1;
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        int i = this.position;
        if (i > 0) {
            this.position = i - 1;
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        return this.position == 0;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        return this.position == this.count - 1;
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final int getColumnIndex(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final String getColumnName(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final String[] getColumnNames() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final int getColumnCount() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final byte[] getBlob(int i) {
        return this.window.getBlob(this.position, i);
    }

    @Override // android.database.Cursor
    public final String getString(int i) {
        return this.window.getString(this.position, i);
    }

    @Override // android.database.Cursor
    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final short getShort(int i) {
        return this.window.getShort(this.position, i);
    }

    @Override // android.database.Cursor
    public final int getInt(int i) {
        return this.window.getInt(this.position, i);
    }

    @Override // android.database.Cursor
    public final long getLong(int i) {
        return this.window.getLong(this.position, i);
    }

    @Override // android.database.Cursor
    public final float getFloat(int i) {
        return this.window.getFloat(this.position, i);
    }

    @Override // android.database.Cursor
    public final double getDouble(int i) {
        return this.window.getDouble(this.position, i);
    }

    @Override // android.database.Cursor
    public final boolean isNull(int i) {
        return this.window.isNull(this.position, i);
    }

    @Override // android.database.Cursor
    public final void deactivate() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final boolean requery() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final void registerContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final void unregisterContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final boolean getWantsAllOnMoveCalls() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final Bundle getExtras() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final Bundle respond(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public final int getType(int i) {
        throw new UnsupportedOperationException();
    }
}
