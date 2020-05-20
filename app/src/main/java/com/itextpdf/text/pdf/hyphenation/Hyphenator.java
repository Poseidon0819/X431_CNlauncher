package com.itextpdf.text.pdf.hyphenation;

import com.itextpdf.text.pdf.BaseFont;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Hashtable;
import org.jivesoftware.smack.packet.PrivacyItem;

/* loaded from: classes.dex */
public class Hyphenator {
    private static final String defaultHyphLocation = "com/itextpdf/text/pdf/hyphenation/hyph/";
    private HyphenationTree hyphenTree;
    private int pushCharCount;
    private int remainCharCount;
    private static Hashtable<String, HyphenationTree> hyphenTrees = new Hashtable<>();
    private static String hyphenDir = "";

    public Hyphenator(String str, String str2, int i, int i2) {
        this.hyphenTree = null;
        this.remainCharCount = 2;
        this.pushCharCount = 2;
        this.hyphenTree = getHyphenationTree(str, str2);
        this.remainCharCount = i;
        this.pushCharCount = i2;
    }

    public static HyphenationTree getHyphenationTree(String str, String str2) {
        String str3;
        if (str2 == null || str2.equals(PrivacyItem.PrivacyRule.SUBSCRIPTION_NONE)) {
            str3 = str;
        } else {
            str3 = str + "_" + str2;
        }
        if (hyphenTrees.containsKey(str3)) {
            return hyphenTrees.get(str3);
        }
        if (hyphenTrees.containsKey(str)) {
            return hyphenTrees.get(str);
        }
        HyphenationTree resourceHyphenationTree = getResourceHyphenationTree(str3);
        if (resourceHyphenationTree == null) {
            resourceHyphenationTree = getFileHyphenationTree(str3);
        }
        if (resourceHyphenationTree != null) {
            hyphenTrees.put(str3, resourceHyphenationTree);
        }
        return resourceHyphenationTree;
    }

    public static HyphenationTree getResourceHyphenationTree(String str) {
        try {
            InputStream resourceStream = BaseFont.getResourceStream(defaultHyphLocation + str + ".xml");
            if (resourceStream == null && str.length() > 2) {
                resourceStream = BaseFont.getResourceStream(defaultHyphLocation + str.substring(0, 2) + ".xml");
            }
            if (resourceStream == null) {
                return null;
            }
            HyphenationTree hyphenationTree = new HyphenationTree();
            hyphenationTree.loadSimplePatterns(resourceStream);
            return hyphenationTree;
        } catch (Exception unused) {
            return null;
        }
    }

    public static HyphenationTree getFileHyphenationTree(String str) {
        try {
            if (hyphenDir == null) {
                return null;
            }
            String str2 = hyphenDir;
            File file = new File(str2, str + ".xml");
            FileInputStream fileInputStream = file.canRead() ? new FileInputStream(file) : null;
            if (fileInputStream == null && str.length() > 2) {
                String str3 = hyphenDir;
                File file2 = new File(str3, str.substring(0, 2) + ".xml");
                if (file2.canRead()) {
                    fileInputStream = new FileInputStream(file2);
                }
            }
            if (fileInputStream == null) {
                return null;
            }
            HyphenationTree hyphenationTree = new HyphenationTree();
            hyphenationTree.loadSimplePatterns(fileInputStream);
            return hyphenationTree;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Hyphenation hyphenate(String str, String str2, String str3, int i, int i2) {
        HyphenationTree hyphenationTree = getHyphenationTree(str, str2);
        if (hyphenationTree == null) {
            return null;
        }
        return hyphenationTree.hyphenate(str3, i, i2);
    }

    public static Hyphenation hyphenate(String str, String str2, char[] cArr, int i, int i2, int i3, int i4) {
        HyphenationTree hyphenationTree = getHyphenationTree(str, str2);
        if (hyphenationTree == null) {
            return null;
        }
        return hyphenationTree.hyphenate(cArr, i, i2, i3, i4);
    }

    public void setMinRemainCharCount(int i) {
        this.remainCharCount = i;
    }

    public void setMinPushCharCount(int i) {
        this.pushCharCount = i;
    }

    public void setLanguage(String str, String str2) {
        this.hyphenTree = getHyphenationTree(str, str2);
    }

    public Hyphenation hyphenate(char[] cArr, int i, int i2) {
        HyphenationTree hyphenationTree = this.hyphenTree;
        if (hyphenationTree == null) {
            return null;
        }
        return hyphenationTree.hyphenate(cArr, i, i2, this.remainCharCount, this.pushCharCount);
    }

    public Hyphenation hyphenate(String str) {
        HyphenationTree hyphenationTree = this.hyphenTree;
        if (hyphenationTree == null) {
            return null;
        }
        return hyphenationTree.hyphenate(str, this.remainCharCount, this.pushCharCount);
    }

    public static String getHyphenDir() {
        return hyphenDir;
    }

    public static void setHyphenDir(String str) {
        hyphenDir = str;
    }
}
