package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes.dex */
public final class BidiOrder {

    /* renamed from: AL */
    public static final byte f19657AL = 4;

    /* renamed from: AN */
    public static final byte f19658AN = 11;

    /* renamed from: B */
    public static final byte f19659B = 15;

    /* renamed from: BN */
    public static final byte f19660BN = 14;

    /* renamed from: CS */
    public static final byte f19661CS = 12;

    /* renamed from: EN */
    public static final byte f19662EN = 8;

    /* renamed from: ES */
    public static final byte f19663ES = 9;

    /* renamed from: ET */
    public static final byte f19664ET = 10;

    /* renamed from: L */
    public static final byte f19665L = 0;
    public static final byte LRE = 1;
    public static final byte LRO = 2;
    public static final byte NSM = 13;

    /* renamed from: ON */
    public static final byte f19666ON = 18;
    public static final byte PDF = 7;

    /* renamed from: R */
    public static final byte f19667R = 3;
    public static final byte RLE = 5;
    public static final byte RLO = 6;

    /* renamed from: S */
    public static final byte f19668S = 16;
    public static final byte TYPE_MAX = 18;
    public static final byte TYPE_MIN = 0;

    /* renamed from: WS */
    public static final byte f19669WS = 17;
    private byte[] embeddings;
    private byte[] initialTypes;
    private byte paragraphEmbeddingLevel;
    private byte[] resultLevels;
    private byte[] resultTypes;
    private int textLength;
    private static final byte[] rtypes = new byte[65536];
    private static char[] baseTypes = {0, '\b', 14, '\t', '\t', 16, '\n', '\n', 15, 11, 11, 16, '\f', '\f', 17, TokenParser.f24151CR, TokenParser.f24151CR, 15, 14, 27, 14, 28, 30, 15, 31, 31, 16, TokenParser.f24154SP, TokenParser.f24154SP, 17, '!', TokenParser.DQUOTE, 18, '#', '%', '\n', '&', '*', 18, SignatureVisitor.EXTENDS, SignatureVisitor.EXTENDS, '\n', ',', ',', '\f', SignatureVisitor.SUPER, SignatureVisitor.SUPER, '\n', '.', '.', '\f', '/', '/', '\t', '0', '9', '\b', ':', ':', '\f', ';', '@', 18, 'A', 'Z', 0, '[', '`', 18, 'a', 'z', 0, '{', '~', 18, 127, 132, 14, 133, 133, 15, 134, 159, 14, 160, 160, '\f', 161, 161, 18, 162, 165, '\n', 166, 169, 18, 170, 170, 0, 171, 175, 18, 176, 177, '\n', 178, 179, '\b', 180, 180, 18, 181, 181, 0, 182, 184, 18, 185, 185, '\b', 186, 186, 0, 187, 191, 18, 192, 214, 0, 215, 215, 18, 216, 246, 0, 247, 247, 18, 248, 696, 0, 697, 698, 18, 699, 705, 0, 706, 719, 18, 720, 721, 0, 722, 735, 18, 736, 740, 0, 741, 749, 18, 750, 750, 0, 751, 767, 18, 768, 855, TokenParser.f24151CR, 856, 860, 0, 861, 879, TokenParser.f24151CR, 880, 883, 0, 884, 885, 18, 886, 893, 0, 894, 894, 18, 895, 899, 0, 900, 901, 18, 902, 902, 0, 903, 903, 18, 904, 1013, 0, 1014, 1014, 18, 1015, 1154, 0, 1155, 1158, TokenParser.f24151CR, 1159, 1159, 0, 1160, 1161, TokenParser.f24151CR, 1162, 1417, 0, 1418, 1418, 18, 1419, 1424, 0, 1425, 1441, TokenParser.f24151CR, 1442, 1442, 0, 1443, 1465, TokenParser.f24151CR, 1466, 1466, 0, 1467, 1469, TokenParser.f24151CR, 1470, 1470, 3, 1471, 1471, TokenParser.f24151CR, 1472, 1472, 3, 1473, 1474, TokenParser.f24151CR, 1475, 1475, 3, 1476, 1476, TokenParser.f24151CR, 1477, 1487, 0, 1488, 1514, 3, 1515, 1519, 0, 1520, 1524, 3, 1525, 1535, 0, 1536, 1539, 4, 1540, 1547, 0, 1548, 1548, '\f', 1549, 1549, 4, 1550, 1551, 18, 1552, 1557, TokenParser.f24151CR, 1558, 1562, 0, 1563, 1563, 4, 1564, 1566, 0, 1567, 1567, 4, 1568, 1568, 0, 1569, 1594, 4, 1595, 1599, 0, 1600, 1610, 4, 1611, 1624, TokenParser.f24151CR, 1625, 1631, 0, 1632, 1641, 11, 1642, 1642, '\n', 1643, 1644, 11, 1645, 1647, 4, 1648, 1648, TokenParser.f24151CR, 1649, 1749, 4, 1750, 1756, TokenParser.f24151CR, 1757, 1757, 4, 1758, 1764, TokenParser.f24151CR, 1765, 1766, 4, 1767, 1768, TokenParser.f24151CR, 1769, 1769, 18, 1770, 1773, TokenParser.f24151CR, 1774, 1775, 4, 1776, 1785, '\b', 1786, 1805, 4, 1806, 1806, 0, 1807, 1807, 14, 1808, 1808, 4, 1809, 1809, TokenParser.f24151CR, 1810, 1839, 4, 1840, 1866, TokenParser.f24151CR, 1867, 1868, 0, 1869, 1871, 4, 1872, 1919, 0, 1920, 1957, 4, 1958, 1968, TokenParser.f24151CR, 1969, 1969, 4, 1970, 2304, 0, 2305, 2306, TokenParser.f24151CR, 2307, 2363, 0, 2364, 2364, TokenParser.f24151CR, 2365, 2368, 0, 2369, 2376, TokenParser.f24151CR, 2377, 2380, 0, 2381, 2381, TokenParser.f24151CR, 2382, 2384, 0, 2385, 2388, TokenParser.f24151CR, 2389, 2401, 0, 2402, 2403, TokenParser.f24151CR, 2404, 2432, 0, 2433, 2433, TokenParser.f24151CR, 2434, 2491, 0, 2492, 2492, TokenParser.f24151CR, 2493, 2496, 0, 2497, 2500, TokenParser.f24151CR, 2501, 2508, 0, 2509, 2509, TokenParser.f24151CR, 2510, 2529, 0, 2530, 2531, TokenParser.f24151CR, 2532, 2545, 0, 2546, 2547, '\n', 2548, 2560, 0, 2561, 2562, TokenParser.f24151CR, 2563, 2619, 0, 2620, 2620, TokenParser.f24151CR, 2621, 2624, 0, 2625, 2626, TokenParser.f24151CR, 2627, 2630, 0, 2631, 2632, TokenParser.f24151CR, 2633, 2634, 0, 2635, 2637, TokenParser.f24151CR, 2638, 2671, 0, 2672, 2673, TokenParser.f24151CR, 2674, 2688, 0, 2689, 2690, TokenParser.f24151CR, 2691, 2747, 0, 2748, 2748, TokenParser.f24151CR, 2749, 2752, 0, 2753, 2757, TokenParser.f24151CR, 2758, 2758, 0, 2759, 2760, TokenParser.f24151CR, 2761, 2764, 0, 2765, 2765, TokenParser.f24151CR, 2766, 2785, 0, 2786, 2787, TokenParser.f24151CR, 2788, 2800, 0, 2801, 2801, '\n', 2802, 2816, 0, 2817, 2817, TokenParser.f24151CR, 2818, 2875, 0, 2876, 2876, TokenParser.f24151CR, 2877, 2878, 0, 2879, 2879, TokenParser.f24151CR, 2880, 2880, 0, 2881, 2883, TokenParser.f24151CR, 2884, 2892, 0, 2893, 2893, TokenParser.f24151CR, 2894, 2901, 0, 2902, 2902, TokenParser.f24151CR, 2903, 2945, 0, 2946, 2946, TokenParser.f24151CR, 2947, 3007, 0, 3008, 3008, TokenParser.f24151CR, 3009, 3020, 0, 3021, 3021, TokenParser.f24151CR, 3022, 3058, 0, 3059, 3064, 18, 3065, 3065, '\n', 3066, 3066, 18, 3067, 3133, 0, 3134, 3136, TokenParser.f24151CR, 3137, 3141, 0, 3142, 3144, TokenParser.f24151CR, 3145, 3145, 0, 3146, 3149, TokenParser.f24151CR, 3150, 3156, 0, 3157, 3158, TokenParser.f24151CR, 3159, 3259, 0, 3260, 3260, TokenParser.f24151CR, 3261, 3275, 0, 3276, 3277, TokenParser.f24151CR, 3278, 3392, 0, 3393, 3395, TokenParser.f24151CR, 3396, 3404, 0, 3405, 3405, TokenParser.f24151CR, 3406, 3529, 0, 3530, 3530, TokenParser.f24151CR, 3531, 3537, 0, 3538, 3540, TokenParser.f24151CR, 3541, 3541, 0, 3542, 3542, TokenParser.f24151CR, 3543, 3632, 0, 3633, 3633, TokenParser.f24151CR, 3634, 3635, 0, 3636, 3642, TokenParser.f24151CR, 3643, 3646, 0, 3647, 3647, '\n', 3648, 3654, 0, 3655, 3662, TokenParser.f24151CR, 3663, 3760, 0, 3761, 3761, TokenParser.f24151CR, 3762, 3763, 0, 3764, 3769, TokenParser.f24151CR, 3770, 3770, 0, 3771, 3772, TokenParser.f24151CR, 3773, 3783, 0, 3784, 3789, TokenParser.f24151CR, 3790, 3863, 0, 3864, 3865, TokenParser.f24151CR, 3866, 3892, 0, 3893, 3893, TokenParser.f24151CR, 3894, 3894, 0, 3895, 3895, TokenParser.f24151CR, 3896, 3896, 0, 3897, 3897, TokenParser.f24151CR, 3898, 3901, 18, 3902, 3952, 0, 3953, 3966, TokenParser.f24151CR, 3967, 3967, 0, 3968, 3972, TokenParser.f24151CR, 3973, 3973, 0, 3974, 3975, TokenParser.f24151CR, 3976, 3983, 0, 3984, 3991, TokenParser.f24151CR, 3992, 3992, 0, 3993, 4028, TokenParser.f24151CR, 4029, 4037, 0, 4038, 4038, TokenParser.f24151CR, 4039, 4140, 0, 4141, 4144, TokenParser.f24151CR, 4145, 4145, 0, 4146, 4146, TokenParser.f24151CR, 4147, 4149, 0, 4150, 4151, TokenParser.f24151CR, 4152, 4152, 0, 4153, 4153, TokenParser.f24151CR, 4154, 4183, 0, 4184, 4185, TokenParser.f24151CR, 4186, 5759, 0, 5760, 5760, 17, 5761, 5786, 0, 5787, 5788, 18, 5789, 5905, 0, 5906, 5908, TokenParser.f24151CR, 5909, 5937, 0, 5938, 5940, TokenParser.f24151CR, 5941, 5969, 0, 5970, 5971, TokenParser.f24151CR, 5972, 6001, 0, 6002, 6003, TokenParser.f24151CR, 6004, 6070, 0, 6071, 6077, TokenParser.f24151CR, 6078, 6085, 0, 6086, 6086, TokenParser.f24151CR, 6087, 6088, 0, 6089, 6099, TokenParser.f24151CR, 6100, 6106, 0, 6107, 6107, '\n', 6108, 6108, 0, 6109, 6109, TokenParser.f24151CR, 6110, 6127, 0, 6128, 6137, 18, 6138, 6143, 0, 6144, 6154, 18, 6155, 6157, TokenParser.f24151CR, 6158, 6158, 17, 6159, 6312, 0, 6313, 6313, TokenParser.f24151CR, 6314, 6431, 0, 6432, 6434, TokenParser.f24151CR, 6435, 6438, 0, 6439, 6443, TokenParser.f24151CR, 6444, 6449, 0, 6450, 6450, TokenParser.f24151CR, 6451, 6456, 0, 6457, 6459, TokenParser.f24151CR, 6460, 6463, 0, 6464, 6464, 18, 6465, 6467, 0, 6468, 6469, 18, 6470, 6623, 0, 6624, 6655, 18, 6656, 8124, 0, 8125, 8125, 18, 8126, 8126, 0, 8127, 8129, 18, 8130, 8140, 0, 8141, 8143, 18, 8144, 8156, 0, 8157, 8159, 18, 8160, 8172, 0, 8173, 8175, 18, 8176, 8188, 0, 8189, 8190, 18, 8191, 
    8191, 0, 8192, 8202, 17, 8203, 8205, 14, 8206, 8206, 0, 8207, 8207, 3, 8208, 8231, 18, 8232, 8232, 17, 8233, 8233, 15, 8234, 8234, 1, 8235, 8235, 5, 8236, 8236, 7, 8237, 8237, 2, 8238, 8238, 6, 8239, 8239, 17, 8240, 8244, '\n', 8245, 8276, 18, 8277, 8278, 0, 8279, 8279, 18, 8280, 8286, 0, 8287, 8287, 17, 8288, 8291, 14, 8292, 8297, 0, 8298, 8303, 14, 8304, 8304, '\b', 8305, 8307, 0, 8308, 8313, '\b', 8314, 8315, '\n', 8316, 8318, 18, 8319, 8319, 0, 8320, 8329, '\b', 8330, 8331, '\n', 8332, 8334, 18, 8335, 8351, 0, 8352, 8369, '\n', 8370, 8399, 0, 8400, 8426, TokenParser.f24151CR, 8427, 8447, 0, 8448, 8449, 18, 8450, 8450, 0, 8451, 8454, 18, 8455, 8455, 0, 8456, 8457, 18, 8458, 8467, 0, 8468, 8468, 18, 8469, 8469, 0, 8470, 8472, 18, 8473, 8477, 0, 8478, 8483, 18, 8484, 8484, 0, 8485, 8485, 18, 8486, 8486, 0, 8487, 8487, 18, 8488, 8488, 0, 8489, 8489, 18, 8490, 8493, 0, 8494, 8494, '\n', 8495, 8497, 0, 8498, 8498, 18, 8499, 8505, 0, 8506, 8507, 18, 8508, 8511, 0, 8512, 8516, 18, 8517, 8521, 0, 8522, 8523, 18, 8524, 8530, 0, 8531, 8543, 18, 8544, 8591, 0, 8592, 8721, 18, 8722, 8723, '\n', 8724, 9013, 18, 9014, 9082, 0, 9083, 9108, 18, 9109, 9109, 0, 9110, 9168, 18, 9169, 9215, 0, 9216, 9254, 18, 9255, 9279, 0, 9280, 9290, 18, 9291, 9311, 0, 9312, 9371, '\b', 9372, 9449, 0, 9450, 9450, '\b', 9451, 9751, 18, 9752, 9752, 0, 9753, 9853, 18, 9854, 9855, 0, 9856, 9873, 18, 9874, 9887, 0, 9888, 9889, 18, 9890, 9984, 0, 9985, 9988, 18, 9989, 9989, 0, 9990, 9993, 18, 9994, 9995, 0, 9996, 10023, 18, 10024, 10024, 0, 10025, 10059, 18, 10060, 10060, 0, 10061, 10061, 18, 10062, 10062, 0, 10063, 10066, 18, 10067, 10069, 0, 10070, 10070, 18, 10071, 10071, 0, 10072, 10078, 18, 10079, 10080, 0, 10081, 10132, 18, 10133, 10135, 0, 10136, 10159, 18, 10160, 10160, 0, 10161, 10174, 18, 10175, 10191, 0, 10192, 10219, 18, 10220, 10223, 0, 10224, 11021, 18, 11022, 11903, 0, 11904, 11929, 18, 11930, 11930, 0, 11931, 12019, 18, 12020, 12031, 0, 12032, 12245, 18, 12246, 12271, 0, 12272, 12283, 18, 12284, 12287, 0, 12288, 12288, 17, 12289, 12292, 18, 12293, 12295, 0, 12296, 12320, 18, 12321, 12329, 0, 12330, 12335, TokenParser.f24151CR, 12336, 12336, 18, 12337, 12341, 0, 12342, 12343, 18, 12344, 12348, 0, 12349, 12351, 18, 12352, 12440, 0, 12441, 12442, TokenParser.f24151CR, 12443, 12444, 18, 12445, 12447, 0, 12448, 12448, 18, 12449, 12538, 0, 12539, 12539, 18, 12540, 12828, 0, 12829, 12830, 18, 12831, 12879, 0, 12880, 12895, 18, 12896, 12923, 0, 12924, 12925, 18, 12926, 12976, 0, 12977, 12991, 18, 12992, 13003, 0, 13004, 13007, 18, 13008, 13174, 0, 13175, 13178, 18, 13179, 13277, 0, 13278, 13279, 18, 13280, 13310, 0, 13311, 13311, 18, 13312, 19903, 0, 19904, 19967, 18, 19968, 42127, 0, 42128, 42182, 18, 42183, 64284, 0, 64285, 64285, 3, 64286, 64286, TokenParser.f24151CR, 64287, 64296, 3, 64297, 64297, '\n', 64298, 64310, 3, 64311, 64311, 0, 64312, 64316, 3, 64317, 64317, 0, 64318, 64318, 3, 64319, 64319, 0, 64320, 64321, 3, 64322, 64322, 0, 64323, 64324, 3, 64325, 64325, 0, 64326, 64335, 3, 64336, 64433, 4, 64434, 64466, 0, 64467, 64829, 4, 64830, 64831, 18, 64832, 64847, 0, 64848, 64911, 4, 64912, 64913, 0, 64914, 64967, 4, 64968, 65007, 0, 65008, 65020, 4, 65021, 65021, 18, 65022, 65023, 0, 65024, 65039, TokenParser.f24151CR, 65040, 65055, 0, 65056, 65059, TokenParser.f24151CR, 65060, 65071, 0, 65072, 65103, 18, 65104, 65104, '\f', 65105, 65105, 18, 65106, 65106, '\f', 65107, 65107, 0, 65108, 65108, 18, 65109, 65109, '\f', 65110, 65118, 18, 65119, 65119, '\n', 65120, 65121, 18, 65122, 65123, '\n', 65124, 65126, 18, 65127, 65127, 0, 65128, 65128, 18, 65129, 65130, '\n', 65131, 65131, 18, 65132, 65135, 0, 65136, 65140, 4, 65141, 65141, 0, 65142, 65276, 4, 65277, 65278, 0, 65279, 65279, 14, 65280, 65280, 0, 65281, 65282, 18, 65283, 65285, '\n', 65286, 65290, 18, 65291, 65291, '\n', 65292, 65292, '\f', 65293, 65293, '\n', 65294, 65294, '\f', 65295, 65295, '\t', 65296, 65305, '\b', 65306, 65306, '\f', 65307, 65312, 18, 65313, 65338, 0, 65339, 65344, 18, 65345, 65370, 0, 65371, 65381, 18, 65382, 65503, 0, 65504, 65505, '\n', 65506, 65508, 18, 65509, 65510, '\n', 65511, 65511, 0, 65512, 65518, 18, 65519, 65528, 0, 65529, 65531, 14, 65532, 65533, 18, 65534, 65535, 0};

    private static boolean isWhitespace(byte b) {
        if (b == 14 || b == 17) {
            return true;
        }
        switch (b) {
            case 1:
            case 2:
                return true;
            default:
                switch (b) {
                    case 5:
                    case 6:
                    case 7:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private static byte typeForLevel(int i) {
        return (i & 1) == 0 ? (byte) 0 : (byte) 3;
    }

    public BidiOrder(byte[] bArr) {
        this.paragraphEmbeddingLevel = (byte) -1;
        validateTypes(bArr);
        this.initialTypes = (byte[]) bArr.clone();
        runAlgorithm();
    }

    public BidiOrder(byte[] bArr, byte b) {
        this.paragraphEmbeddingLevel = (byte) -1;
        validateTypes(bArr);
        validateParagraphEmbeddingLevel(b);
        this.initialTypes = (byte[]) bArr.clone();
        this.paragraphEmbeddingLevel = b;
        runAlgorithm();
    }

    public BidiOrder(char[] cArr, int i, int i2, byte b) {
        this.paragraphEmbeddingLevel = (byte) -1;
        this.initialTypes = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.initialTypes[i3] = rtypes[cArr[i + i3]];
        }
        validateParagraphEmbeddingLevel(b);
        this.paragraphEmbeddingLevel = b;
        runAlgorithm();
    }

    public static final byte getDirection(char c) {
        return rtypes[c];
    }

    private void runAlgorithm() {
        byte[] bArr = this.initialTypes;
        this.textLength = bArr.length;
        this.resultTypes = (byte[]) bArr.clone();
        if (this.paragraphEmbeddingLevel == -1) {
            determineParagraphEmbeddingLevel();
        }
        int i = this.textLength;
        this.resultLevels = new byte[i];
        int i2 = 0;
        setLevels(0, i, this.paragraphEmbeddingLevel);
        determineExplicitEmbeddingLevels();
        this.textLength = removeExplicitCodes();
        byte b = this.paragraphEmbeddingLevel;
        while (true) {
            int i3 = this.textLength;
            if (i2 < i3) {
                byte b2 = this.resultLevels[i2];
                byte typeForLevel = typeForLevel(Math.max((int) b, (int) b2));
                int i4 = i2 + 1;
                while (i4 < this.textLength && this.resultLevels[i4] == b2) {
                    i4++;
                }
                byte typeForLevel2 = typeForLevel(Math.max((int) (i4 < this.textLength ? this.resultLevels[i4] : this.paragraphEmbeddingLevel), (int) b2));
                int i5 = i2;
                int i6 = i4;
                resolveWeakTypes(i5, i6, b2, typeForLevel, typeForLevel2);
                resolveNeutralTypes(i5, i6, b2, typeForLevel, typeForLevel2);
                resolveImplicitLevels(i5, i6, b2, typeForLevel, typeForLevel2);
                b = b2;
                i2 = i4;
            } else {
                this.textLength = reinsertExplicitCodes(i3);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:
        r5.paragraphEmbeddingLevel = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void determineParagraphEmbeddingLevel() {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            int r2 = r5.textLength
            r3 = -1
            if (r1 >= r2) goto L17
            byte[] r2 = r5.resultTypes
            r2 = r2[r1]
            if (r2 == 0) goto L18
            r4 = 4
            if (r2 == r4) goto L18
            r4 = 3
            if (r2 != r4) goto L14
            goto L18
        L14:
            int r1 = r1 + 1
            goto L2
        L17:
            r2 = -1
        L18:
            if (r2 != r3) goto L1d
            r5.paragraphEmbeddingLevel = r0
            return
        L1d:
            if (r2 != 0) goto L22
            r5.paragraphEmbeddingLevel = r0
            return
        L22:
            r0 = 1
            r5.paragraphEmbeddingLevel = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BidiOrder.determineParagraphEmbeddingLevel():void");
    }

    private void determineExplicitEmbeddingLevels() {
        this.embeddings = processEmbeddings(this.resultTypes, this.paragraphEmbeddingLevel);
        for (int i = 0; i < this.textLength; i++) {
            byte b = this.embeddings[i];
            if ((b & 128) != 0) {
                b = (byte) (b & Byte.MAX_VALUE);
                this.resultTypes[i] = typeForLevel(b);
            }
            this.resultLevels[i] = b;
        }
    }

    private int removeExplicitCodes() {
        int i = 0;
        for (int i2 = 0; i2 < this.textLength; i2++) {
            byte b = this.initialTypes[i2];
            if (b != 1 && b != 5 && b != 2 && b != 6 && b != 7 && b != 14) {
                byte[] bArr = this.embeddings;
                bArr[i] = bArr[i2];
                byte[] bArr2 = this.resultTypes;
                bArr2[i] = bArr2[i2];
                byte[] bArr3 = this.resultLevels;
                bArr3[i] = bArr3[i2];
                i++;
            }
        }
        return i;
    }

    private int reinsertExplicitCodes(int i) {
        int i2;
        int length = this.initialTypes.length;
        while (true) {
            length--;
            i2 = 1;
            if (length < 0) {
                break;
            }
            byte b = this.initialTypes[length];
            if (b == 1 || b == 5 || b == 2 || b == 6 || b == 7 || b == 14) {
                this.embeddings[length] = 0;
                this.resultTypes[length] = b;
                this.resultLevels[length] = -1;
            } else {
                i--;
                byte[] bArr = this.embeddings;
                bArr[length] = bArr[i];
                byte[] bArr2 = this.resultTypes;
                bArr2[length] = bArr2[i];
                byte[] bArr3 = this.resultLevels;
                bArr3[length] = bArr3[i];
            }
        }
        byte[] bArr4 = this.resultLevels;
        if (bArr4[0] == -1) {
            bArr4[0] = this.paragraphEmbeddingLevel;
        }
        while (true) {
            byte[] bArr5 = this.initialTypes;
            if (i2 < bArr5.length) {
                byte[] bArr6 = this.resultLevels;
                if (bArr6[i2] == -1) {
                    bArr6[i2] = bArr6[i2 - 1];
                }
                i2++;
            } else {
                return bArr5.length;
            }
        }
    }

    private static byte[] processEmbeddings(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        byte[] bArr3 = new byte[62];
        byte b2 = b;
        byte b3 = b2;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            bArr2[i4] = b2;
            byte b4 = bArr[i4];
            if (b4 != 15) {
                switch (b4) {
                    default:
                        switch (b4) {
                            case 7:
                                if (i > 0) {
                                    i--;
                                    break;
                                } else if (i2 <= 0 || b3 == 61) {
                                    if (i3 > 0) {
                                        i3--;
                                        b2 = bArr3[i3];
                                        b3 = (byte) (b2 & Byte.MAX_VALUE);
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    i2--;
                                    break;
                                }
                        }
                    case 1:
                    case 2:
                        if (i == 0) {
                            byte b5 = (b4 == 5 || b4 == 6) ? (byte) ((b3 + 1) | 1) : (byte) ((b3 + 2) & (-2));
                            if (b5 < 62) {
                                bArr3[i3] = b2;
                                i3++;
                                b2 = (b4 == 2 || b4 == 6) ? (byte) (b5 | 128) : b5;
                                bArr2[i4] = b2;
                                b3 = b5;
                                break;
                            } else if (b3 == 60) {
                                i2++;
                                break;
                            }
                        }
                        i++;
                        break;
                }
            } else {
                bArr2[i4] = b;
                b2 = b;
                b3 = b2;
                i = 0;
                i2 = 0;
                i3 = 0;
            }
        }
        return bArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
        r8.resultTypes[r11] = 11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void resolveWeakTypes(int r9, int r10, byte r11, byte r12, byte r13) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BidiOrder.resolveWeakTypes(int, int, byte, byte, byte):void");
    }

    private void resolveNeutralTypes(int i, int i2, byte b, byte b2, byte b3) {
        byte b4;
        int i3 = i;
        while (i3 < i2) {
            byte b5 = this.resultTypes[i3];
            if (b5 == 17 || b5 == 18 || b5 == 15 || b5 == 16) {
                int findRunLimit = findRunLimit(i3, i2, new byte[]{15, 16, f19669WS, 18});
                byte b6 = 3;
                if (i3 == i) {
                    b4 = b2;
                } else {
                    b4 = this.resultTypes[i3 - 1];
                    if (b4 != 0 && b4 != 3) {
                        if (b4 == 11) {
                            b4 = 3;
                        } else if (b4 == 8) {
                            b4 = 3;
                        }
                    }
                }
                if (findRunLimit == i2) {
                    b6 = b3;
                } else {
                    byte b7 = this.resultTypes[findRunLimit];
                    if (b7 == 0 || b7 == 3 || (b7 != 11 && b7 != 8)) {
                        b6 = b7;
                    }
                }
                if (b4 != b6) {
                    b4 = typeForLevel(b);
                }
                setTypes(i3, findRunLimit, b4);
                i3 = findRunLimit;
            }
            i3++;
        }
    }

    private void resolveImplicitLevels(int i, int i2, byte b, byte b2, byte b3) {
        if ((b & 1) != 0) {
            while (i < i2) {
                if (this.resultTypes[i] != 3) {
                    byte[] bArr = this.resultLevels;
                    bArr[i] = (byte) (bArr[i] + 1);
                }
                i++;
            }
            return;
        }
        while (i < i2) {
            byte b4 = this.resultTypes[i];
            if (b4 != 0) {
                if (b4 == 3) {
                    byte[] bArr2 = this.resultLevels;
                    bArr2[i] = (byte) (bArr2[i] + 1);
                } else {
                    byte[] bArr3 = this.resultLevels;
                    bArr3[i] = (byte) (bArr3[i] + 2);
                }
            }
            i++;
        }
    }

    public final byte[] getLevels() {
        return getLevels(new int[]{this.textLength});
    }

    public final byte[] getLevels(int[] iArr) {
        validateLineBreaks(iArr, this.textLength);
        byte[] bArr = (byte[]) this.resultLevels.clone();
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = this.initialTypes[i2];
            if (b == 15 || b == 16) {
                bArr[i2] = this.paragraphEmbeddingLevel;
                for (int i3 = i2 - 1; i3 >= 0 && isWhitespace(this.initialTypes[i3]); i3--) {
                    bArr[i3] = this.paragraphEmbeddingLevel;
                }
            }
        }
        int i4 = 0;
        while (i < iArr.length) {
            int i5 = iArr[i];
            for (int i6 = i5 - 1; i6 >= i4 && isWhitespace(this.initialTypes[i6]); i6--) {
                bArr[i6] = this.paragraphEmbeddingLevel;
            }
            i++;
            i4 = i5;
        }
        return bArr;
    }

    public final int[] getReordering(int[] iArr) {
        validateLineBreaks(iArr, this.textLength);
        return computeMultilineReordering(getLevels(iArr), iArr);
    }

    private static int[] computeMultilineReordering(byte[] bArr, int[] iArr) {
        int[] iArr2 = new int[bArr.length];
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = iArr[i];
            byte[] bArr2 = new byte[i3 - i2];
            System.arraycopy(bArr, i2, bArr2, 0, bArr2.length);
            int[] computeReordering = computeReordering(bArr2);
            for (int i4 = 0; i4 < computeReordering.length; i4++) {
                iArr2[i2 + i4] = computeReordering[i4] + i2;
            }
            i++;
            i2 = i3;
        }
        return iArr2;
    }

    private static int[] computeReordering(byte[] bArr) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = i;
        }
        int i2 = 0;
        byte b = 63;
        for (byte b2 : bArr) {
            if (b2 > i2) {
                i2 = b2;
            }
            if ((b2 & 1) != 0 && b2 < b) {
                b = b2;
            }
        }
        while (i2 >= b) {
            int i3 = 0;
            while (i3 < length) {
                if (bArr[i3] >= i2) {
                    int i4 = i3 + 1;
                    while (i4 < length && bArr[i4] >= i2) {
                        i4++;
                    }
                    for (int i5 = i4 - 1; i3 < i5; i5--) {
                        int i6 = iArr[i3];
                        iArr[i3] = iArr[i5];
                        iArr[i5] = i6;
                        i3++;
                    }
                    i3 = i4;
                }
                i3++;
            }
            i2--;
        }
        return iArr;
    }

    public final byte getBaseLevel() {
        return this.paragraphEmbeddingLevel;
    }

    private int findRunLimit(int i, int i2, byte[] bArr) {
        int i3;
        int i4 = i - 1;
        while (true) {
            i4++;
            if (i4 < i2) {
                byte b = this.resultTypes[i4];
                while (i3 < bArr.length) {
                    i3 = b != bArr[i3] ? i3 + 1 : 0;
                }
                return i4;
            }
            return i2;
        }
    }

    private int findRunStart(int i, byte[] bArr) {
        int i2;
        while (true) {
            i--;
            if (i >= 0) {
                byte b = this.resultTypes[i];
                while (i2 < bArr.length) {
                    i2 = b != bArr[i2] ? i2 + 1 : 0;
                }
                return i + 1;
            }
            return 0;
        }
    }

    private void setTypes(int i, int i2, byte b) {
        while (i < i2) {
            this.resultTypes[i] = b;
            i++;
        }
    }

    private void setLevels(int i, int i2, byte b) {
        while (i < i2) {
            this.resultLevels[i] = b;
            i++;
        }
    }

    private static void validateTypes(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("types.is.null", new Object[0]));
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] < 0 || bArr[i] > 18) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.type.value.at.1.2", String.valueOf(i), String.valueOf((int) bArr[i])));
            }
        }
        for (int i2 = 0; i2 < bArr.length - 1; i2++) {
            if (bArr[i2] == 15) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("b.type.before.end.of.paragraph.at.index.1", i2));
            }
        }
    }

    private static void validateParagraphEmbeddingLevel(byte b) {
        if (b != -1 && b != 0 && b != 1) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.paragraph.embedding.level.1", b));
        }
    }

    private static void validateLineBreaks(int[] iArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < iArr.length) {
            int i4 = iArr[i2];
            if (i4 <= i3) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.linebreak.1.at.index.2", String.valueOf(i4), String.valueOf(i2)));
            }
            i2++;
            i3 = i4;
        }
        if (i3 != i) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("last.linebreak.must.be.at.1", i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    static {
        int i = 0;
        while (true) {
            char[] cArr = baseTypes;
            if (i >= cArr.length) {
                return;
            }
            int i2 = i + 1;
            char c = cArr[i2];
            int i3 = i2 + 1;
            byte b = (byte) cArr[i3];
            for (char c2 = cArr[i]; c2 <= c; c2++) {
                rtypes[c2] = b;
            }
            i = i3 + 1;
        }
    }
}
