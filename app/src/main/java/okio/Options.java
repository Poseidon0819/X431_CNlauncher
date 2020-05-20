package okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b4, code lost:
        continue;
     */
    /* renamed from: of */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static okio.Options m182of(okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Options.m182of(okio.ByteString[]):okio.Options");
    }

    private static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6;
        int i7;
        Buffer buffer2;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (list.get(i8).size() < i) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i2);
        ByteString byteString2 = list.get(i3 - 1);
        int i9 = -1;
        if (i == byteString.size()) {
            i9 = list2.get(i2).intValue();
            int i10 = i2 + 1;
            byteString = list.get(i10);
            i4 = i10;
        } else {
            i4 = i2;
        }
        if (byteString.getByte(i) != byteString2.getByte(i)) {
            int i11 = 1;
            for (int i12 = i4 + 1; i12 < i3; i12++) {
                if (list.get(i12 - 1).getByte(i) != list.get(i12).getByte(i)) {
                    i11++;
                }
            }
            long intCount = j + intCount(buffer) + 2 + (i11 * 2);
            buffer.writeInt(i11);
            buffer.writeInt(i9);
            for (int i13 = i4; i13 < i3; i13++) {
                byte b = list.get(i13).getByte(i);
                if (i13 == i4 || b != list.get(i13 - 1).getByte(i)) {
                    buffer.writeInt(b & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            int i14 = i4;
            while (i14 < i3) {
                byte b2 = list.get(i14).getByte(i);
                int i15 = i14 + 1;
                int i16 = i15;
                while (true) {
                    if (i16 >= i3) {
                        i6 = i3;
                        break;
                    } else if (b2 != list.get(i16).getByte(i)) {
                        i6 = i16;
                        break;
                    } else {
                        i16++;
                    }
                }
                if (i15 == i6 && i + 1 == list.get(i14).size()) {
                    buffer.writeInt(list2.get(i14).intValue());
                    i7 = i6;
                    buffer2 = buffer3;
                } else {
                    buffer.writeInt((int) ((intCount(buffer3) + intCount) * (-1)));
                    i7 = i6;
                    buffer2 = buffer3;
                    buildTrieRecursive(intCount, buffer3, i + 1, list, i14, i6, list2);
                }
                buffer3 = buffer2;
                i14 = i7;
            }
            Buffer buffer4 = buffer3;
            buffer.write(buffer4, buffer4.size());
            return;
        }
        int min = Math.min(byteString.size(), byteString2.size());
        int i17 = 0;
        for (int i18 = i; i18 < min && byteString.getByte(i18) == byteString2.getByte(i18); i18++) {
            i17++;
        }
        long intCount2 = 1 + j + intCount(buffer) + 2 + i17;
        buffer.writeInt(-i17);
        buffer.writeInt(i9);
        int i19 = i;
        while (true) {
            i5 = i + i17;
            if (i19 >= i5) {
                break;
            }
            buffer.writeInt(byteString.getByte(i19) & 255);
            i19++;
        }
        if (i4 + 1 == i3) {
            if (i5 != list.get(i4).size()) {
                throw new AssertionError();
            }
            buffer.writeInt(list2.get(i4).intValue());
            return;
        }
        Buffer buffer5 = new Buffer();
        buffer.writeInt((int) ((intCount(buffer5) + intCount2) * (-1)));
        buildTrieRecursive(intCount2, buffer5, i5, list, i4, i3, list2);
        buffer.write(buffer5, buffer5.size());
    }

    @Override // java.util.AbstractList, java.util.List
    public final ByteString get(int i) {
        return this.byteStrings[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }
}
