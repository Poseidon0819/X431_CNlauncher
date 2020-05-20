package com.cnlaunch.x431pro.module.p243b.p244a;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.module.b.a.b */
/* loaded from: classes.dex */
public final class BrowserWebSitesList extends AbstractC2709c {
    private static final long serialVersionUID = 5364742902707154145L;
    private ArrayList<BrowserWebSiteInfo> list = new ArrayList<>();

    public BrowserWebSitesList() {
        BrowserWebSiteInfo browserWebSiteInfo = new BrowserWebSiteInfo();
        browserWebSiteInfo.setImageResid(R.drawable.web1);
        browserWebSiteInfo.setWebSite("http://www.alldatapro.com/alldata/PRO~OF1");
        this.list.add(browserWebSiteInfo);
        BrowserWebSiteInfo browserWebSiteInfo2 = new BrowserWebSiteInfo();
        browserWebSiteInfo2.setImageResid(R.drawable.web1);
        browserWebSiteInfo2.setWebSite("https://www.autodata-online.net/Online/Login/AutodataLogon.aspx");
        this.list.add(browserWebSiteInfo2);
        BrowserWebSiteInfo browserWebSiteInfo3 = new BrowserWebSiteInfo();
        browserWebSiteInfo3.setImageResid(R.drawable.web1);
        browserWebSiteInfo3.setWebSite("http://www.google.com");
        this.list.add(browserWebSiteInfo3);
        BrowserWebSiteInfo browserWebSiteInfo4 = new BrowserWebSiteInfo();
        browserWebSiteInfo4.setImageResid(R.drawable.web1);
        browserWebSiteInfo4.setWebSite("http://www.iatn.net");
        this.list.add(browserWebSiteInfo4);
        BrowserWebSiteInfo browserWebSiteInfo5 = new BrowserWebSiteInfo();
        browserWebSiteInfo5.setImageResid(R.drawable.web1);
        browserWebSiteInfo5.setWebSite("http://www.identifix.com");
        this.list.add(browserWebSiteInfo5);
        BrowserWebSiteInfo browserWebSiteInfo6 = new BrowserWebSiteInfo();
        browserWebSiteInfo6.setImageResid(R.drawable.web1);
        browserWebSiteInfo6.setWebSite("http://www.launchtechusa.com");
        this.list.add(browserWebSiteInfo6);
        BrowserWebSiteInfo browserWebSiteInfo7 = new BrowserWebSiteInfo();
        browserWebSiteInfo7.setImageResid(R.drawable.web1);
        browserWebSiteInfo7.setWebSite("http://www.ondemand5.com");
        this.list.add(browserWebSiteInfo7);
        BrowserWebSiteInfo browserWebSiteInfo8 = new BrowserWebSiteInfo();
        browserWebSiteInfo8.setImageResid(R.drawable.web1);
        browserWebSiteInfo8.setWebSite("http://www.shopkey5.com");
        this.list.add(browserWebSiteInfo8);
    }

    public final ArrayList<BrowserWebSiteInfo> getList() {
        return this.list;
    }
}
