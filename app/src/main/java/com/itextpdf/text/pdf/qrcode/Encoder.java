package com.itextpdf.text.pdf.qrcode;

import com.itextpdf.text.pdf.qrcode.Version;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import org.codehaus.jackson.smile.SmileConstants;

/* loaded from: classes.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    private Encoder() {
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + 0 + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    public static void encode(String str, ErrorCorrectionLevel errorCorrectionLevel, QRCode qRCode) throws WriterException {
        encode(str, errorCorrectionLevel, null, qRCode);
    }

    public static void encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, Object> map, QRCode qRCode) throws WriterException {
        CharacterSetECI characterSetECIByName;
        String str2 = map == null ? null : (String) map.get(EncodeHintType.CHARACTER_SET);
        if (str2 == null) {
            str2 = DEFAULT_BYTE_MODE_ENCODING;
        }
        Mode chooseMode = chooseMode(str, str2);
        BitVector bitVector = new BitVector();
        appendBytes(str, chooseMode, bitVector, str2);
        initQRCode(bitVector.sizeInBytes(), errorCorrectionLevel, chooseMode, qRCode);
        BitVector bitVector2 = new BitVector();
        if (chooseMode == Mode.BYTE && !DEFAULT_BYTE_MODE_ENCODING.equals(str2) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2)) != null) {
            appendECI(characterSetECIByName, bitVector2);
        }
        appendModeInfo(chooseMode, bitVector2);
        appendLengthInfo(chooseMode.equals(Mode.BYTE) ? bitVector.sizeInBytes() : str.length(), qRCode.getVersion(), chooseMode, bitVector2);
        bitVector2.appendBitVector(bitVector);
        terminateBits(qRCode.getNumDataBytes(), bitVector2);
        BitVector bitVector3 = new BitVector();
        interleaveWithECBytes(bitVector2, qRCode.getNumTotalBytes(), qRCode.getNumDataBytes(), qRCode.getNumRSBlocks(), bitVector3);
        ByteMatrix byteMatrix = new ByteMatrix(qRCode.getMatrixWidth(), qRCode.getMatrixWidth());
        qRCode.setMaskPattern(chooseMaskPattern(bitVector3, qRCode.getECLevel(), qRCode.getVersion(), byteMatrix));
        MatrixUtil.buildMatrix(bitVector3, qRCode.getECLevel(), qRCode.getVersion(), qRCode.getMaskPattern(), byteMatrix);
        qRCode.setMatrix(byteMatrix);
        if (qRCode.isValid()) {
            return;
        }
        throw new WriterException("Invalid QR code: " + qRCode.toString());
    }

    static int getAlphanumericCode(int i) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    public static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return isOnlyDoubleByteKanji(str) ? Mode.KANJI : Mode.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (getAlphanumericCode(charAt) == -1) {
                return Mode.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        if (z2) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int chooseMaskPattern(BitVector bitVector, ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) throws WriterException {
        int i2 = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            MatrixUtil.buildMatrix(bitVector, errorCorrectionLevel, i, i4, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i2) {
                i3 = i4;
                i2 = calculateMaskPenalty;
            }
        }
        return i3;
    }

    private static void initQRCode(int i, ErrorCorrectionLevel errorCorrectionLevel, Mode mode, QRCode qRCode) throws WriterException {
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(mode);
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionForNumber = Version.getVersionForNumber(i2);
            int totalCodewords = versionForNumber.getTotalCodewords();
            Version.ECBlocks eCBlocksForLevel = versionForNumber.getECBlocksForLevel(errorCorrectionLevel);
            int totalECCodewords = eCBlocksForLevel.getTotalECCodewords();
            int numBlocks = eCBlocksForLevel.getNumBlocks();
            int i3 = totalCodewords - totalECCodewords;
            if (i3 >= i + 3) {
                qRCode.setVersion(i2);
                qRCode.setNumTotalBytes(totalCodewords);
                qRCode.setNumDataBytes(i3);
                qRCode.setNumRSBlocks(numBlocks);
                qRCode.setNumECBytes(totalECCodewords);
                qRCode.setMatrixWidth(versionForNumber.getDimensionForVersion());
                return;
            }
        }
        throw new WriterException("Cannot find proper rs block info (input data too big?)");
    }

    static void terminateBits(int i, BitVector bitVector) throws WriterException {
        int i2 = i << 3;
        if (bitVector.size() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitVector.size() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && bitVector.size() < i2; i3++) {
            bitVector.appendBit(0);
        }
        int size = bitVector.size() % 8;
        if (size > 0) {
            int i4 = 8 - size;
            for (int i5 = 0; i5 < i4; i5++) {
                bitVector.appendBit(0);
            }
        }
        if (bitVector.size() % 8 != 0) {
            throw new WriterException("Number of bits is not a multiple of 8");
        }
        int sizeInBytes = i - bitVector.sizeInBytes();
        for (int i6 = 0; i6 < sizeInBytes; i6++) {
            if (i6 % 2 == 0) {
                bitVector.appendBits(SmileConstants.TOKEN_MISC_SHARED_STRING_LONG, 8);
            } else {
                bitVector.appendBits(17, 8);
            }
        }
        if (bitVector.size() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
            return;
        }
        iArr[0] = i10;
        iArr2[0] = i12;
    }

    static void interleaveWithECBytes(BitVector bitVector, int i, int i2, int i3, BitVector bitVector2) throws WriterException {
        if (bitVector.sizeInBytes() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i, i2, i3, i7, iArr, iArr2);
            ByteArray byteArray = new ByteArray();
            byteArray.set(bitVector.getArray(), i4, iArr[0]);
            ByteArray generateECBytes = generateECBytes(byteArray, iArr2[0]);
            arrayList.add(new BlockPair(byteArray, generateECBytes));
            i5 = Math.max(i5, byteArray.size());
            i6 = Math.max(i6, generateECBytes.size());
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new WriterException("Data bytes does not match offset");
        }
        for (int i8 = 0; i8 < i5; i8++) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                ByteArray dataBytes = ((BlockPair) arrayList.get(i9)).getDataBytes();
                if (i8 < dataBytes.size()) {
                    bitVector2.appendBits(dataBytes.m2709at(i8), 8);
                }
            }
        }
        for (int i10 = 0; i10 < i6; i10++) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                ByteArray errorCorrectionBytes = ((BlockPair) arrayList.get(i11)).getErrorCorrectionBytes();
                if (i10 < errorCorrectionBytes.size()) {
                    bitVector2.appendBits(errorCorrectionBytes.m2709at(i10), 8);
                }
            }
        }
        if (i == bitVector2.sizeInBytes()) {
            return;
        }
        throw new WriterException("Interleaving error: " + i + " and " + bitVector2.sizeInBytes() + " differ.");
    }

    static ByteArray generateECBytes(ByteArray byteArray, int i) {
        int size = byteArray.size();
        int[] iArr = new int[size + i];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = byteArray.m2709at(i2);
        }
        new ReedSolomonEncoder(GF256.QR_CODE_FIELD).encode(iArr, i);
        ByteArray byteArray2 = new ByteArray(i);
        for (int i3 = 0; i3 < i; i3++) {
            byteArray2.set(i3, iArr[size + i3]);
        }
        return byteArray2;
    }

    static void appendModeInfo(Mode mode, BitVector bitVector) {
        bitVector.appendBits(mode.getBits(), 4);
    }

    static void appendLengthInfo(int i, int i2, Mode mode, BitVector bitVector) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(Version.getVersionForNumber(i2));
        int i3 = (1 << characterCountBits) - 1;
        if (i > i3) {
            throw new WriterException(i + "is bigger than" + i3);
        }
        bitVector.appendBits(i, characterCountBits);
    }

    static void appendBytes(String str, Mode mode, BitVector bitVector, String str2) throws WriterException {
        if (mode.equals(Mode.NUMERIC)) {
            appendNumericBytes(str, bitVector);
        } else if (mode.equals(Mode.ALPHANUMERIC)) {
            appendAlphanumericBytes(str, bitVector);
        } else if (mode.equals(Mode.BYTE)) {
            append8BitBytes(str, bitVector, str2);
        } else if (mode.equals(Mode.KANJI)) {
            appendKanjiBytes(str, bitVector);
        } else {
            throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
        }
    }

    static void appendNumericBytes(String str, BitVector bitVector) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int charAt = str.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bitVector.appendBits((charAt * 100) + ((str.charAt(i + 1) - '0') * 10) + (str.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bitVector.appendBits((charAt * 10) + (str.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bitVector.appendBits(charAt, 4);
                }
            }
        }
    }

    static void appendAlphanumericBytes(String str, BitVector bitVector) throws WriterException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(str.charAt(i));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int alphanumericCode2 = getAlphanumericCode(str.charAt(i2));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitVector.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i += 2;
            } else {
                bitVector.appendBits(alphanumericCode, 6);
                i = i2;
            }
        }
    }

    static void append8BitBytes(String str, BitVector bitVector, String str2) throws WriterException {
        try {
            byte[] bytes = str.getBytes(str2);
            for (byte b : bytes) {
                bitVector.appendBits(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    static void appendKanjiBytes(String str, BitVector bitVector) throws WriterException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                int i3 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i3 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitVector.appendBits(((i3 >> 8) * 192) + (i3 & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitVector bitVector) {
        bitVector.appendBits(Mode.ECI.getBits(), 4);
        bitVector.appendBits(characterSetECI.getValue(), 8);
    }
}
