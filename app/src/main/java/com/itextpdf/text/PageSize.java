package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class PageSize {
    public static final Rectangle LETTER = new RectangleReadOnly(612.0f, 792.0f);
    public static final Rectangle NOTE = new RectangleReadOnly(540.0f, 720.0f);
    public static final Rectangle LEGAL = new RectangleReadOnly(612.0f, 1008.0f);
    public static final Rectangle TABLOID = new RectangleReadOnly(792.0f, 1224.0f);
    public static final Rectangle EXECUTIVE = new RectangleReadOnly(522.0f, 756.0f);
    public static final Rectangle POSTCARD = new RectangleReadOnly(283.0f, 416.0f);

    /* renamed from: A0 */
    public static final Rectangle f19597A0 = new RectangleReadOnly(2384.0f, 3370.0f);

    /* renamed from: A1 */
    public static final Rectangle f19598A1 = new RectangleReadOnly(1684.0f, 2384.0f);

    /* renamed from: A2 */
    public static final Rectangle f19599A2 = new RectangleReadOnly(1191.0f, 1684.0f);

    /* renamed from: A3 */
    public static final Rectangle f19600A3 = new RectangleReadOnly(842.0f, 1191.0f);

    /* renamed from: A4 */
    public static final Rectangle f19601A4 = new RectangleReadOnly(595.0f, 842.0f);

    /* renamed from: A5 */
    public static final Rectangle f19602A5 = new RectangleReadOnly(420.0f, 595.0f);

    /* renamed from: A6 */
    public static final Rectangle f19603A6 = new RectangleReadOnly(297.0f, 420.0f);

    /* renamed from: A7 */
    public static final Rectangle f19604A7 = new RectangleReadOnly(210.0f, 297.0f);

    /* renamed from: A8 */
    public static final Rectangle f19605A8 = new RectangleReadOnly(148.0f, 210.0f);

    /* renamed from: A9 */
    public static final Rectangle f19606A9 = new RectangleReadOnly(105.0f, 148.0f);
    public static final Rectangle A10 = new RectangleReadOnly(73.0f, 105.0f);

    /* renamed from: B0 */
    public static final Rectangle f19607B0 = new RectangleReadOnly(2834.0f, 4008.0f);

    /* renamed from: B1 */
    public static final Rectangle f19608B1 = new RectangleReadOnly(2004.0f, 2834.0f);

    /* renamed from: B2 */
    public static final Rectangle f19609B2 = new RectangleReadOnly(1417.0f, 2004.0f);

    /* renamed from: B3 */
    public static final Rectangle f19610B3 = new RectangleReadOnly(1000.0f, 1417.0f);

    /* renamed from: B4 */
    public static final Rectangle f19611B4 = new RectangleReadOnly(708.0f, 1000.0f);

    /* renamed from: B5 */
    public static final Rectangle f19612B5 = new RectangleReadOnly(498.0f, 708.0f);

    /* renamed from: B6 */
    public static final Rectangle f19613B6 = new RectangleReadOnly(354.0f, 498.0f);

    /* renamed from: B7 */
    public static final Rectangle f19614B7 = new RectangleReadOnly(249.0f, 354.0f);

    /* renamed from: B8 */
    public static final Rectangle f19615B8 = new RectangleReadOnly(175.0f, 249.0f);

    /* renamed from: B9 */
    public static final Rectangle f19616B9 = new RectangleReadOnly(124.0f, 175.0f);
    public static final Rectangle B10 = new RectangleReadOnly(87.0f, 124.0f);
    public static final Rectangle ARCH_E = new RectangleReadOnly(2592.0f, 3456.0f);
    public static final Rectangle ARCH_D = new RectangleReadOnly(1728.0f, 2592.0f);
    public static final Rectangle ARCH_C = new RectangleReadOnly(1296.0f, 1728.0f);
    public static final Rectangle ARCH_B = new RectangleReadOnly(864.0f, 1296.0f);
    public static final Rectangle ARCH_A = new RectangleReadOnly(648.0f, 864.0f);
    public static final Rectangle FLSA = new RectangleReadOnly(612.0f, 936.0f);
    public static final Rectangle FLSE = new RectangleReadOnly(648.0f, 936.0f);
    public static final Rectangle HALFLETTER = new RectangleReadOnly(396.0f, 612.0f);
    public static final Rectangle _11X17 = new RectangleReadOnly(792.0f, 1224.0f);
    public static final Rectangle ID_1 = new RectangleReadOnly(242.65f, 153.0f);
    public static final Rectangle ID_2 = new RectangleReadOnly(297.0f, 210.0f);
    public static final Rectangle ID_3 = new RectangleReadOnly(354.0f, 249.0f);
    public static final Rectangle LEDGER = new RectangleReadOnly(1224.0f, 792.0f);
    public static final Rectangle CROWN_QUARTO = new RectangleReadOnly(535.0f, 697.0f);
    public static final Rectangle LARGE_CROWN_QUARTO = new RectangleReadOnly(569.0f, 731.0f);
    public static final Rectangle DEMY_QUARTO = new RectangleReadOnly(620.0f, 782.0f);
    public static final Rectangle ROYAL_QUARTO = new RectangleReadOnly(671.0f, 884.0f);
    public static final Rectangle CROWN_OCTAVO = new RectangleReadOnly(348.0f, 527.0f);
    public static final Rectangle LARGE_CROWN_OCTAVO = new RectangleReadOnly(365.0f, 561.0f);
    public static final Rectangle DEMY_OCTAVO = new RectangleReadOnly(391.0f, 612.0f);
    public static final Rectangle ROYAL_OCTAVO = new RectangleReadOnly(442.0f, 663.0f);
    public static final Rectangle SMALL_PAPERBACK = new RectangleReadOnly(314.0f, 504.0f);
    public static final Rectangle PENGUIN_SMALL_PAPERBACK = new RectangleReadOnly(314.0f, 513.0f);
    public static final Rectangle PENGUIN_LARGE_PAPERBACK = new RectangleReadOnly(365.0f, 561.0f);
    public static final Rectangle LETTER_LANDSCAPE = new RectangleReadOnly(612.0f, 792.0f, 90);
    public static final Rectangle LEGAL_LANDSCAPE = new RectangleReadOnly(612.0f, 1008.0f, 90);
    public static final Rectangle A4_LANDSCAPE = new RectangleReadOnly(595.0f, 842.0f, 90);

    public static Rectangle getRectangle(String str) {
        String upperCase = str.trim().toUpperCase();
        int indexOf = upperCase.indexOf(32);
        if (indexOf == -1) {
            try {
                return (Rectangle) PageSize.class.getDeclaredField(upperCase.toUpperCase()).get(null);
            } catch (Exception unused) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("can.t.find.page.size.1", upperCase));
            }
        }
        try {
            return new Rectangle(Float.parseFloat(upperCase.substring(0, indexOf)), Float.parseFloat(upperCase.substring(indexOf + 1)));
        } catch (Exception e) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("1.is.not.a.valid.page.size.format.2", upperCase, e.getMessage()));
        }
    }
}
