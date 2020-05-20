package com.cnlaunch.x431pro.activity.help;

import android.content.res.AssetManager;
import com.itextpdf.text.Meta;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: com.cnlaunch.x431pro.activity.help.n */
/* loaded from: classes.dex */
public class stHelpDoc {

    /* renamed from: c */
    private static stHelpDoc f12841c;

    /* renamed from: a */
    private String f12842a;

    /* renamed from: b */
    private String f12843b;

    private stHelpDoc() {
    }

    /* renamed from: a */
    private void m6881a(Element element, String str, ArrayList<HelpFileInfo> arrayList) {
        Element element2;
        this.f12843b = element.getAttribute("title");
        String attribute = element.getAttribute("iconname");
        String replace = str.replace("\\", "/");
        String str2 = replace.substring(0, replace.lastIndexOf("/")) + "/" + attribute;
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                HelpFileInfo helpFileInfo = new HelpFileInfo();
                helpFileInfo.f12718a = this.f12843b;
                helpFileInfo.f12719b = str2;
                helpFileInfo.f12720c = ((Element) item).getAttribute("title");
                helpFileInfo.f12721d = str + "/" + element2.getAttribute("ref");
                arrayList.add(helpFileInfo);
            }
        }
    }

    /* renamed from: b */
    private void m6879b(Element element, String str, ArrayList<HelpFileInfo> arrayList) {
        String attribute = element.getAttribute("namespace");
        this.f12843b = attribute;
        this.f12842a = attribute;
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                HelpFileInfo helpFileInfo = new HelpFileInfo();
                helpFileInfo.f12718a = this.f12842a;
                Element element2 = (Element) item;
                helpFileInfo.f12720c = element2.getAttribute("name");
                helpFileInfo.f12721d = str + "/" + element2.getAttribute("ref");
                arrayList.add(helpFileInfo);
            }
        }
    }

    /* renamed from: a */
    public static stHelpDoc m6884a() {
        if (f12841c == null) {
            synchronized (stHelpDoc.class) {
                if (f12841c == null) {
                    f12841c = new stHelpDoc();
                }
            }
        }
        return f12841c;
    }

    /* renamed from: a */
    public static void m6883a(AssetManager assetManager, String str, ArrayList<HelpFileInfo> arrayList) {
        try {
            InputStream open = assetManager.open(str + "/index.xml");
            NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(open).getElementsByTagName("Q2As").item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if ((item instanceof Element) && item.getNodeName().equals("Q2A")) {
                    m6880a((Element) item, arrayList);
                }
            }
            open.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m6880a(Element element, ArrayList<HelpFileInfo> arrayList) {
        NodeList childNodes = element.getChildNodes();
        HelpFileInfo helpFileInfo = new HelpFileInfo();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                if (!item.getNodeName().equals("Question")) {
                    if (item.getNodeName().equals("Answer")) {
                        helpFileInfo.f12721d = item.getTextContent();
                    }
                } else {
                    helpFileInfo.f12720c = item.getTextContent();
                }
            }
        }
        arrayList.add(helpFileInfo);
    }

    /* renamed from: a */
    public final void m6882a(AssetManager assetManager, String str, ArrayList<HelpFileInfo> arrayList, ArrayList<HelpFileInfo> arrayList2) {
        try {
            InputStream open = assetManager.open(str + "/index.xml");
            NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(open).getElementsByTagName("filterSection").item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item instanceof Element) {
                    String nodeName = item.getNodeName();
                    if (nodeName.equals("sections")) {
                        m6881a((Element) item, str, arrayList2);
                    } else if (nodeName.equals(Meta.KEYWORDS)) {
                        m6879b((Element) item, str, arrayList);
                    }
                }
            }
            open.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
