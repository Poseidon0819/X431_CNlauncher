package com.cnlaunch.x431pro.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/* renamed from: com.cnlaunch.x431pro.utils.v */
/* loaded from: classes.dex */
public final class PrintInfoProperties {

    /* renamed from: b */
    private static PrintInfoProperties f15942b = new PrintInfoProperties();

    /* renamed from: a */
    private Properties f15943a = new Properties();

    /* renamed from: c */
    private File f15944c = new File(PathUtils.m4846j(), "shopInfo.properties");

    private PrintInfoProperties() {
        try {
            if (this.f15944c.exists()) {
                return;
            }
            this.f15944c.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static PrintInfoProperties m4838a() {
        return f15942b;
    }

    /* renamed from: a */
    public final String m4837a(String str) {
        try {
            this.f15943a.load(new InputStreamReader(new FileInputStream(this.f15944c), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.f15943a.getProperty(str) == null ? "" : this.f15943a.getProperty(str);
    }

    /* renamed from: a */
    public final void m4836a(String str, String str2) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(this.f15944c), "utf-8");
            this.f15943a.setProperty(str, str2);
            this.f15943a.store(outputStreamWriter, str2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
