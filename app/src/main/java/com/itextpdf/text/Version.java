package com.itextpdf.text;

import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public final class Version {
    private static Version version;
    private String iText = "iText®";
    private String release = "5.3.2";
    private String key = null;
    private String iTextVersion = this.iText + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.release + " ©2000-2012 1T3XT BVBA";

    public static Version getInstance() {
        if (version == null) {
            version = new Version();
            try {
                Class<?> cls = Class.forName("com.itextpdf.license.LicenseKey");
                String[] strArr = (String[]) cls.getMethod("getLicenseeInfo", new Class[0]).invoke(cls.newInstance(), new Object[0]);
                if (strArr[3] != null && strArr[3].trim().length() > 0) {
                    version.key = strArr[3];
                } else {
                    version.key = "Trial version ";
                    if (strArr[5] == null) {
                        StringBuilder sb = new StringBuilder();
                        Version version2 = version;
                        sb.append(version2.key);
                        sb.append("unauthorised");
                        version2.key = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        Version version3 = version;
                        sb2.append(version3.key);
                        sb2.append(strArr[5]);
                        version3.key = sb2.toString();
                    }
                }
                if (strArr[4] != null && strArr[4].trim().length() > 0) {
                    version.iTextVersion = strArr[4];
                } else if (strArr[2] != null && strArr[2].trim().length() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    Version version4 = version;
                    sb3.append(version4.iTextVersion);
                    sb3.append(" (");
                    sb3.append(strArr[2]);
                    version4.iTextVersion = sb3.toString();
                    if (!version.key.toLowerCase().startsWith("trial")) {
                        StringBuilder sb4 = new StringBuilder();
                        Version version5 = version;
                        sb4.append(version5.iTextVersion);
                        sb4.append("; licensed version)");
                        version5.iTextVersion = sb4.toString();
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        Version version6 = version;
                        sb5.append(version6.iTextVersion);
                        sb5.append("; ");
                        sb5.append(version.key);
                        sb5.append(")");
                        version6.iTextVersion = sb5.toString();
                    }
                } else if (strArr[0] != null && strArr[0].trim().length() > 0) {
                    StringBuilder sb6 = new StringBuilder();
                    Version version7 = version;
                    sb6.append(version7.iTextVersion);
                    sb6.append(" (");
                    sb6.append(strArr[0]);
                    version7.iTextVersion = sb6.toString();
                    if (!version.key.toLowerCase().startsWith("trial")) {
                        StringBuilder sb7 = new StringBuilder();
                        Version version8 = version;
                        sb7.append(version8.iTextVersion);
                        sb7.append("; licensed version)");
                        version8.iTextVersion = sb7.toString();
                    } else {
                        StringBuilder sb8 = new StringBuilder();
                        Version version9 = version;
                        sb8.append(version9.iTextVersion);
                        sb8.append("; ");
                        sb8.append(version.key);
                        sb8.append(")");
                        version9.iTextVersion = sb8.toString();
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception unused) {
                StringBuilder sb9 = new StringBuilder();
                Version version10 = version;
                sb9.append(version10.iTextVersion);
                sb9.append(" (AGPL-version)");
                version10.iTextVersion = sb9.toString();
            }
        }
        return version;
    }

    public final String getProduct() {
        return this.iText;
    }

    public final String getRelease() {
        return this.release;
    }

    public final String getVersion() {
        return this.iTextVersion;
    }

    public final String getKey() {
        return this.key;
    }
}
