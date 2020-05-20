package com.itextpdf.text;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.Barcode128;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class SpecialSymbol {
    public static char getCorrespondingSymbol(char c) {
        switch (c) {
            case 913:
                return 'A';
            case 914:
                return 'B';
            case 915:
                return 'G';
            case 916:
                return 'D';
            case 917:
                return 'E';
            case 918:
                return 'Z';
            case 919:
                return 'H';
            case 920:
                return 'Q';
            case 921:
                return 'I';
            case 922:
                return 'K';
            case 923:
                return 'L';
            case 924:
                return 'M';
            case 925:
                return 'N';
            case 926:
                return 'X';
            case 927:
                return 'O';
            case 928:
                return 'P';
            case 929:
                return 'R';
            default:
                switch (c) {
                    case 931:
                        return 'S';
                    case 932:
                        return 'T';
                    case 933:
                        return 'U';
                    case 934:
                        return 'F';
                    case 935:
                        return 'C';
                    case 936:
                        return 'Y';
                    case 937:
                        return 'W';
                    default:
                        switch (c) {
                            case 945:
                                return 'a';
                            case 946:
                                return 'b';
                            case 947:
                                return Barcode128.START_A;
                            case 948:
                                return Barcode128.CODE_AC_TO_B;
                            case 949:
                                return Barcode128.CODE_BC_TO_A;
                            case 950:
                                return 'z';
                            case 951:
                                return Barcode128.START_B;
                            case 952:
                                return 'q';
                            case 953:
                                return Barcode128.START_C;
                            case 954:
                                return 'k';
                            case 955:
                                return 'l';
                            case 956:
                                return 'm';
                            case 957:
                                return 'n';
                            case 958:
                                return 'x';
                            case 959:
                                return 'o';
                            case 960:
                                return 'p';
                            case 961:
                                return 'r';
                            case 962:
                                return 'V';
                            case 963:
                                return 's';
                            case 964:
                                return 't';
                            case 965:
                                return 'u';
                            case 966:
                                return Barcode128.FNC1_INDEX;
                            case 967:
                                return Barcode128.CODE_AB_TO_C;
                            case 968:
                                return 'y';
                            case 969:
                                return 'w';
                            default:
                                return TokenParser.f24154SP;
                        }
                }
        }
    }

    public static int index(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (getCorrespondingSymbol(str.charAt(i)) != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static Chunk get(char c, Font font) {
        char correspondingSymbol = getCorrespondingSymbol(c);
        if (correspondingSymbol == ' ') {
            return new Chunk(String.valueOf(c), font);
        }
        return new Chunk(String.valueOf(correspondingSymbol), new Font(Font.FontFamily.SYMBOL, font.getSize(), font.getStyle(), font.getColor()));
    }
}
