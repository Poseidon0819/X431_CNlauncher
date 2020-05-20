package com.mopub.mobileads;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.VastResource;
import com.mopub.mobileads.util.XmlUtils;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* loaded from: classes.dex */
public class VastXmlManagerAggregator extends AsyncTask<String, Void, VastVideoConfig> {
    public static final String ADS_BY_AD_SLOT_ID = "adsBy";
    public static final String SOCIAL_ACTIONS_AD_SLOT_ID = "socialActions";

    /* renamed from: a */
    private static final List<String> f20487a = Arrays.asList("video/mp4", "video/3gpp");

    /* renamed from: b */
    private final WeakReference<InterfaceC3737b> f20488b;

    /* renamed from: c */
    private final double f20489c;

    /* renamed from: d */
    private final int f20490d;

    /* renamed from: e */
    private final Context f20491e;

    /* renamed from: f */
    private int f20492f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.VastXmlManagerAggregator$a */
    /* loaded from: classes.dex */
    public enum EnumC3736a {
        LANDSCAPE,
        PORTRAIT
    }

    /* renamed from: com.mopub.mobileads.VastXmlManagerAggregator$b */
    /* loaded from: classes.dex */
    interface InterfaceC3737b {
        void onAggregationComplete(VastVideoConfig vastVideoConfig);
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(VastVideoConfig vastVideoConfig) {
        VastVideoConfig vastVideoConfig2 = vastVideoConfig;
        InterfaceC3737b interfaceC3737b = this.f20488b.get();
        if (interfaceC3737b != null) {
            interfaceC3737b.onAggregationComplete(vastVideoConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VastXmlManagerAggregator(InterfaceC3737b interfaceC3737b, double d, int i, Context context) {
        Preconditions.checkNotNull(interfaceC3737b);
        Preconditions.checkNotNull(context);
        this.f20488b = new WeakReference<>(interfaceC3737b);
        this.f20489c = d;
        this.f20490d = i;
        this.f20491e = context.getApplicationContext();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        Networking.getUserAgent(this.f20491e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public VastVideoConfig doInBackground(String... strArr) {
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return null;
        }
        try {
            return m2327a(strArr[0], new ArrayList());
        } catch (Exception e) {
            MoPubLog.m2497d("Unable to generate VastVideoConfig.", e);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        InterfaceC3737b interfaceC3737b = this.f20488b.get();
        if (interfaceC3737b != null) {
            interfaceC3737b.onAggregationComplete(null);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private VastVideoConfig m2327a(String str, List<VastTracker> list) {
        boolean z;
        VastVideoConfig m2327a;
        VastVideoConfig m2332a;
        Preconditions.checkNotNull(str, "vastXml cannot be null");
        Preconditions.checkNotNull(list, "errorTrackers cannot be null");
        VastXmlManager vastXmlManager = new VastXmlManager();
        try {
            Preconditions.checkNotNull(str, "xmlString cannot be null");
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setCoalescing(true);
            vastXmlManager.f20573a = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader("<MPMoVideoXMLDocRoot>" + str.replaceFirst("<\\?.*\\?>", "") + "</MPMoVideoXMLDocRoot>")));
            List<VastAdXmlManager> m2288a = vastXmlManager.m2288a();
            Context context = this.f20491e;
            if (!m2288a.isEmpty() || vastXmlManager.m2287b() == null) {
                z = false;
            } else {
                TrackingRequest.makeVastTrackingHttpRequest(Collections.singletonList(vastXmlManager.m2287b()), this.f20492f > 0 ? VastErrorCode.NO_ADS_VAST_RESPONSE : VastErrorCode.UNDEFINED_ERROR, null, null, context);
                z = true;
            }
            if (z) {
                return null;
            }
            for (VastAdXmlManager vastAdXmlManager : m2288a) {
                if (m2328a(XmlUtils.getAttributeValue(vastAdXmlManager.f20520a, "sequence"))) {
                    Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(vastAdXmlManager.f20520a, "InLine");
                    VastInLineXmlManager vastInLineXmlManager = firstMatchingChildNode != null ? new VastInLineXmlManager(firstMatchingChildNode) : null;
                    if (vastInLineXmlManager != null && (m2332a = m2332a(vastInLineXmlManager, list)) != null) {
                        m2329a(vastXmlManager, m2332a);
                        return m2332a;
                    }
                    Node firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(vastAdXmlManager.f20520a, "Wrapper");
                    VastWrapperXmlManager vastWrapperXmlManager = firstMatchingChildNode2 != null ? new VastWrapperXmlManager(firstMatchingChildNode2) : null;
                    if (vastWrapperXmlManager != null) {
                        ArrayList arrayList = new ArrayList(list);
                        arrayList.addAll(vastWrapperXmlManager.m2311b());
                        String m2330a = m2330a(vastWrapperXmlManager, arrayList);
                        if (m2330a != null && (m2327a = m2327a(m2330a, arrayList)) != null) {
                            m2327a.addImpressionTrackers(vastWrapperXmlManager.m2312a());
                            for (VastLinearXmlManager vastLinearXmlManager : vastWrapperXmlManager.m2310c()) {
                                m2331a(vastLinearXmlManager, m2327a);
                            }
                            m2333a(vastWrapperXmlManager, m2327a);
                            List<VastCompanionAdXmlManager> d = vastWrapperXmlManager.m2309d();
                            if (!m2327a.hasCompanionAd()) {
                                m2327a.setVastCompanionAd(m2325a(d, EnumC3736a.LANDSCAPE), m2325a(d, EnumC3736a.PORTRAIT));
                            } else {
                                VastCompanionAdConfig vastCompanionAd = m2327a.getVastCompanionAd(2);
                                VastCompanionAdConfig vastCompanionAd2 = m2327a.getVastCompanionAd(1);
                                if (vastCompanionAd != null && vastCompanionAd2 != null) {
                                    for (VastCompanionAdXmlManager vastCompanionAdXmlManager : d) {
                                        if (!((TextUtils.isEmpty(vastCompanionAdXmlManager.f20527b.m2377a()) && TextUtils.isEmpty(vastCompanionAdXmlManager.f20527b.m2375c()) && TextUtils.isEmpty(vastCompanionAdXmlManager.f20527b.m2376b())) ? false : true)) {
                                            vastCompanionAd.addClickTrackers(vastCompanionAdXmlManager.m2304d());
                                            vastCompanionAd.addCreativeViewTrackers(vastCompanionAdXmlManager.m2303e());
                                            vastCompanionAd2.addClickTrackers(vastCompanionAdXmlManager.m2304d());
                                            vastCompanionAd2.addCreativeViewTrackers(vastCompanionAdXmlManager.m2303e());
                                        }
                                    }
                                }
                            }
                            if (m2327a.getSocialActionsCompanionAds().isEmpty()) {
                                m2327a.setSocialActionsCompanionAds(m2322b(d));
                            }
                            m2329a(vastXmlManager, m2327a);
                            return m2327a;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            MoPubLog.m2497d("Failed to parse VAST XML", e);
            TrackingRequest.makeVastTrackingHttpRequest(list, VastErrorCode.XML_PARSING_ERROR, null, null, this.f20491e);
            return null;
        }
    }

    /* renamed from: a */
    private VastVideoConfig m2332a(VastInLineXmlManager vastInLineXmlManager, List<VastTracker> list) {
        VastLinearXmlManager next;
        String m2326a;
        Preconditions.checkNotNull(vastInLineXmlManager);
        Preconditions.checkNotNull(list);
        Iterator<VastLinearXmlManager> it = vastInLineXmlManager.m2310c().iterator();
        do {
            if (!it.hasNext()) {
                return null;
            }
            next = it.next();
            ArrayList arrayList = new ArrayList();
            Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(next.f20531a, "MediaFiles");
            if (firstMatchingChildNode != null) {
                for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "MediaFile")) {
                    arrayList.add(new VastMediaXmlManager(node));
                }
            }
            m2326a = m2326a(arrayList);
        } while (m2326a == null);
        VastVideoConfig vastVideoConfig = new VastVideoConfig();
        vastVideoConfig.addImpressionTrackers(vastInLineXmlManager.m2312a());
        m2331a(next, vastVideoConfig);
        Node firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(next.f20531a, "VideoClicks");
        vastVideoConfig.setClickThroughUrl(firstMatchingChildNode2 != null ? XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode2, "ClickThrough")) : null);
        vastVideoConfig.setNetworkMediaFileUrl(m2326a);
        List<VastCompanionAdXmlManager> d = vastInLineXmlManager.m2309d();
        vastVideoConfig.setVastCompanionAd(m2325a(d, EnumC3736a.LANDSCAPE), m2325a(d, EnumC3736a.PORTRAIT));
        vastVideoConfig.setSocialActionsCompanionAds(m2322b(d));
        list.addAll(vastInLineXmlManager.m2311b());
        vastVideoConfig.addErrorTrackers(list);
        m2333a(vastInLineXmlManager, vastVideoConfig);
        return vastVideoConfig;
    }

    /* renamed from: a */
    private static void m2333a(VastBaseInLineWrapperXmlManager vastBaseInLineWrapperXmlManager, VastVideoConfig vastVideoConfig) {
        VastExtensionParentXmlManager m2308e;
        Preconditions.checkNotNull(vastBaseInLineWrapperXmlManager);
        Preconditions.checkNotNull(vastVideoConfig);
        if (vastVideoConfig.getVideoViewabilityTracker() == null && (m2308e = vastBaseInLineWrapperXmlManager.m2308e()) != null) {
            ArrayList<VastExtensionXmlManager> arrayList = new ArrayList();
            List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(m2308e.f20404a, "Extension");
            if (matchingChildNodes != null) {
                for (Node node : matchingChildNodes) {
                    arrayList.add(new VastExtensionXmlManager(node));
                }
            }
            for (VastExtensionXmlManager vastExtensionXmlManager : arrayList) {
                if ("MoPub".equals(XmlUtils.getAttributeValue(vastExtensionXmlManager.f20405a, VastExtensionXmlManager.TYPE))) {
                    Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(vastExtensionXmlManager.f20405a, VastExtensionXmlManager.VIDEO_VIEWABILITY_TRACKER);
                    VideoViewabilityTracker videoViewabilityTracker = null;
                    if (firstMatchingChildNode != null) {
                        VideoViewabilityTrackerXmlManager videoViewabilityTrackerXmlManager = new VideoViewabilityTrackerXmlManager(firstMatchingChildNode);
                        Integer m2317a = videoViewabilityTrackerXmlManager.m2317a();
                        Integer m2316b = videoViewabilityTrackerXmlManager.m2316b();
                        String nodeValue = XmlUtils.getNodeValue(videoViewabilityTrackerXmlManager.f20497a);
                        if (m2317a != null && m2316b != null && !TextUtils.isEmpty(nodeValue)) {
                            videoViewabilityTracker = new VideoViewabilityTracker(m2317a.intValue(), m2316b.intValue(), nodeValue);
                        }
                    }
                    vastVideoConfig.setVideoViewabilityTracker(videoViewabilityTracker);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private String m2330a(VastWrapperXmlManager vastWrapperXmlManager, List<VastTracker> list) {
        String m2289f = vastWrapperXmlManager.m2289f();
        if (m2289f == null) {
            return null;
        }
        try {
            return m2323b(m2289f);
        } catch (Exception e) {
            MoPubLog.m2497d("Failed to follow VAST redirect", e);
            if (list.isEmpty()) {
                return null;
            }
            TrackingRequest.makeVastTrackingHttpRequest(list, VastErrorCode.WRAPPER_TIMEOUT, null, null, this.f20491e);
            return null;
        }
    }

    /* renamed from: a */
    private static void m2331a(VastLinearXmlManager vastLinearXmlManager, VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(vastLinearXmlManager, "linearXmlManager cannot be null");
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        vastVideoConfig.addAbsoluteTrackers(vastLinearXmlManager.m2299b());
        vastVideoConfig.addFractionalTrackers(vastLinearXmlManager.m2302a());
        vastVideoConfig.addPauseTrackers(vastLinearXmlManager.m2297c());
        vastVideoConfig.addResumeTrackers(vastLinearXmlManager.m2296d());
        vastVideoConfig.addCompleteTrackers(vastLinearXmlManager.m2301a("complete"));
        vastVideoConfig.addCloseTrackers(vastLinearXmlManager.m2295e());
        vastVideoConfig.addSkipTrackers(vastLinearXmlManager.m2301a("skip"));
        vastVideoConfig.addClickTrackers(vastLinearXmlManager.m2294f());
        if (vastVideoConfig.getSkipOffsetString() == null) {
            vastVideoConfig.setSkipOffset(vastLinearXmlManager.m2293g());
        }
        if (vastVideoConfig.getVastIconConfig() == null) {
            vastVideoConfig.setVastIconConfig(m2321c(vastLinearXmlManager.m2292h()));
        }
    }

    /* renamed from: a */
    private static void m2329a(VastXmlManager vastXmlManager, VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(vastXmlManager, "xmlManager cannot be null");
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        vastVideoConfig.addImpressionTrackers(vastXmlManager.m2286c());
        if (vastVideoConfig.getCustomCtaText() == null) {
            vastVideoConfig.setCustomCtaText(vastXmlManager.m2285d());
        }
        if (vastVideoConfig.getCustomSkipText() == null) {
            vastVideoConfig.setCustomSkipText(vastXmlManager.m2284e());
        }
        if (vastVideoConfig.getCustomCloseIconUrl() == null) {
            vastVideoConfig.setCustomCloseIconUrl(vastXmlManager.m2283f());
        }
        if (vastVideoConfig.isCustomForceOrientationSet()) {
            return;
        }
        vastVideoConfig.setCustomForceOrientation(vastXmlManager.m2282g());
    }

    @VisibleForTesting
    /* renamed from: a */
    private String m2326a(List<VastMediaXmlManager> list) {
        Preconditions.checkNotNull(list, "managers cannot be null");
        Iterator it = new ArrayList(list).iterator();
        double d = Double.POSITIVE_INFINITY;
        String str = null;
        while (it.hasNext()) {
            VastMediaXmlManager vastMediaXmlManager = (VastMediaXmlManager) it.next();
            String attributeValue = XmlUtils.getAttributeValue(vastMediaXmlManager.f20535a, VastExtensionXmlManager.TYPE);
            String nodeValue = XmlUtils.getNodeValue(vastMediaXmlManager.f20535a);
            if (!f20487a.contains(attributeValue) || nodeValue == null) {
                it.remove();
            } else {
                Integer attributeValueAsInt = XmlUtils.getAttributeValueAsInt(vastMediaXmlManager.f20535a, "width");
                Integer attributeValueAsInt2 = XmlUtils.getAttributeValueAsInt(vastMediaXmlManager.f20535a, "height");
                if (attributeValueAsInt != null && attributeValueAsInt.intValue() > 0 && attributeValueAsInt2 != null && attributeValueAsInt2.intValue() > 0) {
                    double m2334a = m2334a(attributeValueAsInt.intValue(), attributeValueAsInt2.intValue());
                    if (m2334a < d) {
                        d = m2334a;
                        str = nodeValue;
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x015c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e A[SYNTHETIC] */
    @com.mopub.common.VisibleForTesting
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.mopub.mobileads.VastCompanionAdConfig m2325a(java.util.List<com.mopub.mobileads.VastCompanionAdXmlManager> r26, com.mopub.mobileads.VastXmlManagerAggregator.EnumC3736a r27) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastXmlManagerAggregator.m2325a(java.util.List, com.mopub.mobileads.VastXmlManagerAggregator$a):com.mopub.mobileads.VastCompanionAdConfig");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0010 A[SYNTHETIC] */
    @com.mopub.common.VisibleForTesting
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.String, com.mopub.mobileads.VastCompanionAdConfig> m2322b(java.util.List<com.mopub.mobileads.VastCompanionAdXmlManager> r17) {
        /*
            java.lang.String r0 = "managers cannot be null"
            r1 = r17
            com.mopub.common.Preconditions.checkNotNull(r1, r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Iterator r1 = r17.iterator()
        L10:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lac
            java.lang.Object r2 = r1.next()
            com.mopub.mobileads.al r2 = (com.mopub.mobileads.VastCompanionAdXmlManager) r2
            java.lang.Integer r3 = r2.m2307a()
            java.lang.Integer r4 = r2.m2306b()
            if (r3 == 0) goto L10
            if (r4 == 0) goto L10
            org.w3c.dom.Node r5 = r2.f20526a
            java.lang.String r6 = "adSlotID"
            java.lang.String r5 = com.mopub.mobileads.util.XmlUtils.getAttributeValue(r5, r6)
            java.lang.String r6 = "adsBy"
            boolean r6 = r6.equals(r5)
            r7 = 10
            r8 = 50
            if (r6 == 0) goto L59
            int r6 = r3.intValue()
            r9 = 25
            if (r6 < r9) goto L10
            int r6 = r3.intValue()
            r9 = 75
            if (r6 > r9) goto L10
            int r6 = r4.intValue()
            if (r6 < r7) goto L10
            int r6 = r4.intValue()
            if (r6 <= r8) goto L7b
            goto L10
        L59:
            java.lang.String r6 = "socialActions"
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L10
            int r6 = r3.intValue()
            if (r6 < r8) goto L10
            int r6 = r3.intValue()
            r9 = 150(0x96, float:2.1E-43)
            if (r6 > r9) goto L10
            int r6 = r4.intValue()
            if (r6 < r7) goto L10
            int r6 = r4.intValue()
            if (r6 > r8) goto L10
        L7b:
            com.mopub.mobileads.VastResourceXmlManager r6 = r2.f20527b
            com.mopub.mobileads.at$b r7 = com.mopub.mobileads.VastResource.EnumC3754b.HTML_RESOURCE
            int r8 = r3.intValue()
            int r9 = r4.intValue()
            com.mopub.mobileads.at r13 = com.mopub.mobileads.VastResource.fromVastResourceXmlManager(r6, r7, r8, r9)
            if (r13 == 0) goto L10
            com.mopub.mobileads.VastCompanionAdConfig r6 = new com.mopub.mobileads.VastCompanionAdConfig
            int r11 = r3.intValue()
            int r12 = r4.intValue()
            java.lang.String r14 = r2.m2305c()
            java.util.List r15 = r2.m2304d()
            java.util.List r16 = r2.m2303e()
            r10 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r0.put(r5, r6)
            goto L10
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastXmlManagerAggregator.m2322b(java.util.List):java.util.Map");
    }

    @VisibleForTesting
    /* renamed from: c */
    private static VastIconConfig m2321c(List<VastIconXmlManager> list) {
        VastResource.EnumC3754b[] values;
        VastResource fromVastResourceXmlManager;
        Preconditions.checkNotNull(list, "managers cannot be null");
        ArrayList<VastIconXmlManager> arrayList = new ArrayList(list);
        for (VastResource.EnumC3754b enumC3754b : VastResource.EnumC3754b.values()) {
            for (VastIconXmlManager vastIconXmlManager : arrayList) {
                Integer m2387a = vastIconXmlManager.m2387a();
                Integer m2386b = vastIconXmlManager.m2386b();
                if (m2387a != null && m2387a.intValue() > 0 && m2387a.intValue() <= 300 && m2386b != null && m2386b.intValue() > 0 && m2386b.intValue() <= 300 && (fromVastResourceXmlManager = VastResource.fromVastResourceXmlManager(vastIconXmlManager.f20406a, enumC3754b, m2387a.intValue(), m2386b.intValue())) != null) {
                    return new VastIconConfig(vastIconXmlManager.m2387a().intValue(), vastIconXmlManager.m2386b().intValue(), vastIconXmlManager.m2385c(), vastIconXmlManager.m2384d(), fromVastResourceXmlManager, vastIconXmlManager.m2383e(), vastIconXmlManager.m2382f(), vastIconXmlManager.m2381g());
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private double m2334a(int i, int i2) {
        double d = i;
        double d2 = i2;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (d / d2) / this.f20489c;
        double d4 = i * i2;
        double d5 = this.f20490d;
        Double.isNaN(d4);
        Double.isNaN(d5);
        return (Math.abs(Math.log(d3)) * 70.0d) + (Math.abs(Math.log(d4 / d5)) * 30.0d);
    }

    /* renamed from: a */
    private static boolean m2328a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    /* renamed from: b */
    private String m2323b(String str) throws IOException {
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        Preconditions.checkNotNull(str);
        int i = this.f20492f;
        BufferedInputStream bufferedInputStream2 = null;
        if (i < 10) {
            this.f20492f = i + 1;
            try {
                httpURLConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
            try {
                String fromStream = Strings.fromStream(bufferedInputStream);
                Streams.closeStream(bufferedInputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return fromStream;
            } catch (Throwable th4) {
                bufferedInputStream2 = bufferedInputStream;
                th = th4;
                Streams.closeStream(bufferedInputStream2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
        return null;
    }
}
