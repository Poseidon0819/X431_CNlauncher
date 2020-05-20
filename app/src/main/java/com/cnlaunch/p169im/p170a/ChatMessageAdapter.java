package com.cnlaunch.p169im.p170a;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.golo3.p154a.C1551a;
import com.cnlaunch.golo3.p154a.p156b.C1580e;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.DateUtil;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.GoloApplication;
import com.cnlaunch.p169im.p171b.MessageComparator;
import com.cnlaunch.p169im.p173d.GoloHandler;
import com.cnlaunch.p169im.widget.CornerImage;
import com.cnlaunch.p169im.widget.DiversifyImageView;
import com.cnlaunch.p169im.widget.GoloProgress;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import message.model.ChatMessage;
import message.p378a.MessageParameters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.im.a.a */
/* loaded from: classes.dex */
public final class ChatMessageAdapter extends BaseAdapter {

    /* renamed from: A */
    private String f8913A;

    /* renamed from: B */
    private String f8914B;

    /* renamed from: C */
    private C1580e f8915C;

    /* renamed from: D */
    private C1580e f8916D;

    /* renamed from: E */
    private C1551a f8917E;

    /* renamed from: a */
    public ArrayList<ChatMessage> f8918a;

    /* renamed from: b */
    public final int f8919b;

    /* renamed from: c */
    public final int f8920c;

    /* renamed from: d */
    public final int f8921d;

    /* renamed from: e */
    public final int f8922e;

    /* renamed from: f */
    public final int f8923f;

    /* renamed from: g */
    public final int f8924g;

    /* renamed from: h */
    public final int f8925h;

    /* renamed from: i */
    public final int f8926i;

    /* renamed from: j */
    public final int f8927j;

    /* renamed from: k */
    public final int f8928k;

    /* renamed from: l */
    public final int f8929l;

    /* renamed from: m */
    public final int f8930m;

    /* renamed from: n */
    public final int f8931n;

    /* renamed from: o */
    public final int f8932o;

    /* renamed from: p */
    public final int f8933p;

    /* renamed from: q */
    public final int f8934q;

    /* renamed from: r */
    public final int f8935r;

    /* renamed from: s */
    public final int f8936s;

    /* renamed from: t */
    public final int f8937t;

    /* renamed from: u */
    private GoloHandler f8938u;

    /* renamed from: v */
    private Context f8939v;

    /* renamed from: w */
    private String f8940w;

    /* renamed from: x */
    private int f8941x;

    /* renamed from: y */
    private Map<String, Object> f8942y;

    /* renamed from: z */
    private Map<String, String> f8943z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8921a() {
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 19;
    }

    public ChatMessageAdapter(Context context, ArrayList<ChatMessage> arrayList, GoloHandler goloHandler, C1551a c1551a) {
        this.f8919b = 0;
        this.f8920c = 1;
        this.f8921d = 2;
        this.f8922e = 3;
        this.f8923f = 4;
        this.f8924g = 5;
        this.f8925h = 6;
        this.f8926i = 7;
        this.f8927j = 8;
        this.f8928k = 9;
        this.f8929l = 10;
        this.f8930m = 11;
        this.f8931n = 12;
        this.f8932o = 13;
        this.f8933p = 14;
        this.f8934q = 15;
        this.f8935r = 16;
        this.f8936s = 17;
        this.f8937t = 18;
        this.f8917E = c1551a;
        this.f8915C = GoloApplication.m8923b();
        this.f8916D = GoloApplication.m8922c();
        this.f8918a = arrayList;
        ArrayList<ChatMessage> arrayList2 = this.f8918a;
        if (arrayList2 == null) {
            this.f8918a = new ArrayList<>();
        } else {
            Collections.sort(arrayList2, new MessageComparator());
        }
        this.f8938u = goloHandler;
        this.f8939v = context;
        this.f8940w = ApplicationConfig.m9181a();
        this.f8941x = 16;
        this.f8942y = new HashMap();
        this.f8943z = new HashMap();
        this.f8913A = UserFaceUtils.m9114a(PreferencesManager.m9595a(context).m9591a("user_id"), null, PreferencesManager.m9595a(context).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2");
    }

    public ChatMessageAdapter(Context context, ArrayList<ChatMessage> arrayList, GoloHandler goloHandler, C1551a c1551a, String str) {
        this(context, arrayList, goloHandler, c1551a);
        this.f8914B = str;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<ChatMessage> arrayList = this.f8918a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public final ChatMessage getItem(int i) {
        return this.f8918a.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        ChatMessage chatMessage = this.f8918a.get(i);
        JSONObject m192p = chatMessage.m192p();
        if (chatMessage != null) {
            String str = chatMessage.f24060e;
            if (str != null && str.equals(this.f8940w)) {
                switch (chatMessage.m218a()) {
                    case 1:
                        if (m192p.has("milestone") || m192p.has("lanetrack") || m192p.has("itinerary")) {
                            return 14;
                        }
                        if (chatMessage.m192p().has(HtmlTags.FACE)) {
                            return 16;
                        }
                        if (m192p.has("activity") || m192p.has("check_report") || m192p.has("check_appraisal") || m192p.has("package_services") || m192p.has("group_id") || m192p.has("upgrade") || m192p.has("reservation_diag")) {
                            return 18;
                        }
                        if (m192p.has("news")) {
                            try {
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            return new JSONArray(m192p.getString("news")).length() > 1 ? 12 : 11;
                        }
                        return 5;
                    case 2:
                        return 6;
                    case 3:
                    case 6:
                    case 7:
                        return 7;
                    case 4:
                        return 9;
                    case 5:
                        return 8;
                    case 8:
                        return 10;
                    case 10:
                    case 13:
                        return 5;
                    case 12:
                        try {
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        return new JSONArray(m192p.getString("news")).length() > 1 ? 12 : 11;
                }
            }
            switch (chatMessage.m218a()) {
                case 1:
                    if (m192p.has("milestone") || m192p.has("lanetrack") || m192p.has("itinerary")) {
                        return 13;
                    }
                    if (m192p.has(HtmlTags.FACE)) {
                        return 15;
                    }
                    if (m192p.has("activity") || m192p.has("check_report") || m192p.has("check_appraisal") || m192p.has("package_services") || m192p.has("group_id") || m192p.has("upgrade") || m192p.has("reservation_diag")) {
                        return 17;
                    }
                    if (m192p.has("news")) {
                        try {
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        return new JSONArray(m192p.getString("news")).length() > 1 ? 12 : 11;
                    }
                    return 0;
                case 2:
                    return 1;
                case 3:
                case 6:
                case 7:
                    return 2;
                case 4:
                    return 4;
                case 5:
                    return 3;
                case 8:
                    return 10;
                case 10:
                case 13:
                    return 0;
                case 12:
                    try {
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    return new JSONArray(m192p.getString("news")).length() > 1 ? 12 : 11;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static void m8919a(View view, int i) {
        View findViewById = view.findViewById(R.id.chat_item_text);
        View findViewById2 = view.findViewById(R.id.chat_item_voice);
        View findViewById3 = view.findViewById(R.id.chat_item_media);
        View findViewById4 = view.findViewById(R.id.chat_item_card);
        View findViewById5 = view.findViewById(R.id.chat_item_map);
        View findViewById6 = view.findViewById(R.id.chat_item_milestone);
        View findViewById7 = view.findViewById(R.id.chat_item_face);
        View findViewById8 = view.findViewById(R.id.chat_item_match);
        boolean z = false;
        m8918a(findViewById, i == 0 || i == 5);
        m8918a(findViewById2, i == 1 || i == 6);
        m8918a(findViewById3, i == 2 || i == 7);
        m8918a(findViewById4, i == 3 || i == 8);
        m8918a(findViewById5, i == 4 || i == 9);
        m8918a(findViewById6, i == 13 || i == 14);
        m8918a(findViewById7, i == 15 || i == 16);
        m8918a(findViewById8, (i == 17 || i == 18) ? true : true);
    }

    /* renamed from: a */
    private static void m8917a(C1677b c1677b, View view) {
        c1677b.f8946a = (DiversifyImageView) view.findViewById(R.id.chat_item_head);
        c1677b.f8954i = (ImageView) view.findViewById(R.id.chat_item_head_leader);
        c1677b.f8947b = (TextView) view.findViewById(R.id.chat_item_time);
        c1677b.f8948c = (TextView) view.findViewById(R.id.chat_item_nickname);
        c1677b.f8959n = (ImageView) view.findViewById(R.id.chat_item_carlogo);
        c1677b.f8961p = (TextView) view.findViewById(R.id.chat_item_carlogo_text);
        c1677b.f8949d = (GoloProgress) view.findViewById(R.id.chat_item_progress);
        c1677b.f8950e = (ImageView) view.findViewById(R.id.chat_item_error);
        c1677b.f8952g = view.findViewById(R.id.chat_content);
    }

    /* renamed from: a */
    private void m8915a(C1677b c1677b, ChatMessage chatMessage, int i) {
        m8918a(c1677b.f8947b, i == 0 || Math.abs(chatMessage.f24062g.longValue() - this.f8918a.get(i + (-1)).f24062g.longValue()) > 300000);
        m8918a(c1677b.f8949d, chatMessage.f24061f.equals(ChatMessage.EnumC4748b.init.name()));
        m8918a(c1677b.f8950e, chatMessage.f24061f.equals(ChatMessage.EnumC4748b.failed.name()));
        c1677b.f8950e.setOnClickListener(new View$OnClickListenerC1682f(this, i));
        String str = chatMessage.f24060e;
        if (!MessageParameters.f23940e.equals(str) && !MessageParameters.f23939d.equals(str)) {
            if (c1677b.f8946a != null) {
                c1677b.f8946a.getHead().setImageResource(R.drawable.square_default_head);
            }
            if (!chatMessage.f24058c.equals(MessageParameters.EnumC4721a.group.name())) {
                if (c1677b.f8948c != null) {
                    c1677b.f8948c.setVisibility(8);
                }
                if (c1677b.f8959n != null) {
                    c1677b.f8959n.setVisibility(8);
                }
                c1677b.f8961p.setVisibility(8);
                if (str.equals(ApplicationConfig.m9181a())) {
                    String str2 = this.f8913A;
                    if (str2 == null || "".equals(str2) || "null".equals(str2)) {
                        c1677b.f8946a.getHead().setImageResource(R.drawable.square_default_head);
                    } else {
                        this.f8917E.m9255a(c1677b.f8946a.getHead(), str2, this.f8915C);
                    }
                } else if (TextUtils.isEmpty(this.f8914B) || "null".equals(this.f8914B)) {
                    c1677b.f8946a.getHead().setImageResource(R.drawable.square_default_head);
                } else {
                    this.f8917E.m9255a(c1677b.f8946a.getHead(), this.f8914B, this.f8915C);
                }
            }
        }
        c1677b.f8946a.getHead().setOnClickListener(new View$OnClickListenerC1683g(this));
        c1677b.f8947b.setText(DateUtil.m9145a(chatMessage.f24062g.longValue()));
        c1677b.f8952g.setOnClickListener(new View$OnClickListenerC1676a(i));
        c1677b.f8952g.setOnLongClickListener(new View$OnLongClickListenerC1684h(this, i));
        if ((getItemViewType(i) == 0 || getItemViewType(i) == 5) && c1677b.f8957l != null) {
            c1677b.f8957l.setOnLongClickListener(new View$OnLongClickListenerC1685i(this, i));
        }
    }

    /* renamed from: a */
    private void m8914a(C1677b c1677b, ChatMessage chatMessage, boolean z) {
        if (chatMessage.m218a() == 6) {
            c1677b.f8953h.setVisibility(8);
            ImageView imageView = (ImageView) c1677b.f8951f.findViewById(R.id.chat_item_other_file);
            imageView.setVisibility(0);
            c1677b.f8951f.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            if (chatMessage.m203e() != null && !"".equals(chatMessage.m203e()) && !"null".equals(chatMessage.m203e())) {
                c1677b.f8956k.setText(chatMessage.m203e());
                m8912a(chatMessage.m203e(), imageView);
            } else {
                c1677b.f8956k.setText("");
                imageView.setImageResource(R.drawable.icon_file_other);
            }
            if (z) {
                c1677b.f8951f.setBackgroundResource(R.drawable.chat_activity_list_item_out);
                return;
            } else {
                c1677b.f8951f.setBackgroundResource(R.drawable.chat_activity_list_item_in);
                return;
            }
        }
        try {
            ((ImageView) c1677b.f8951f.findViewById(R.id.chat_item_other_file)).setVisibility(8);
            c1677b.f8956k.setText("");
            c1677b.f8951f.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            c1677b.f8951f.setBackgroundResource(0);
            if (c1677b.f8953h != null) {
                c1677b.f8953h.setVisibility(0);
                ((CornerImage) c1677b.f8953h).m8700a();
                this.f8916D.f7745f = this.f8939v.getResources().getDrawable(R.drawable.share_none_image);
                if (z) {
                    if (chatMessage.m204d() == null) {
                        this.f8917E.m9255a(c1677b.f8953h, chatMessage.m197k(), this.f8916D);
                        c1677b.f8953h.requestLayout();
                    }
                    this.f8917E.m9255a(c1677b.f8953h, chatMessage.m204d(), this.f8916D);
                    c1677b.f8953h.requestLayout();
                }
                if (chatMessage.m211b() != null && HtmlTags.FACE.equals(chatMessage.m211b())) {
                    this.f8917E.m9255a(c1677b.f8953h, chatMessage.m207c(), this.f8916D);
                    c1677b.f8953h.requestLayout();
                }
                this.f8917E.m9255a(c1677b.f8953h, chatMessage.m204d(), this.f8916D);
                c1677b.f8953h.requestLayout();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m8916a(C1677b c1677b, ChatMessage chatMessage) {
        c1677b.f8957l.setTextSize(2, this.f8941x);
        c1677b.f8957l.setText(chatMessage.m211b());
        if (chatMessage.m192p().has("itinerary")) {
            try {
                chatMessage.m192p().getJSONObject("itinerary").getString(VastExtensionXmlManager.TYPE).equals("2");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m8918a(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChatMessageAdapter.java */
    /* renamed from: com.cnlaunch.im.a.a$b */
    /* loaded from: classes.dex */
    public static class C1677b {

        /* renamed from: a */
        DiversifyImageView f8946a;

        /* renamed from: b */
        TextView f8947b;

        /* renamed from: c */
        TextView f8948c;

        /* renamed from: d */
        GoloProgress f8949d;

        /* renamed from: e */
        ImageView f8950e;

        /* renamed from: f */
        View f8951f;

        /* renamed from: g */
        View f8952g;

        /* renamed from: h */
        ImageView f8953h;

        /* renamed from: i */
        ImageView f8954i;

        /* renamed from: j */
        DiversifyImageView f8955j;

        /* renamed from: k */
        TextView f8956k;

        /* renamed from: l */
        TextView f8957l;

        /* renamed from: m */
        ImageView f8958m;

        /* renamed from: n */
        ImageView f8959n;

        /* renamed from: o */
        Button f8960o;

        /* renamed from: p */
        TextView f8961p;

        C1677b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChatMessageAdapter.java */
    /* renamed from: com.cnlaunch.im.a.a$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC1676a implements View.OnClickListener {

        /* renamed from: b */
        private int f8945b;

        View$OnClickListenerC1676a(int i) {
            this.f8945b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Message obtain = Message.obtain();
            view.getId();
            obtain.what = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_OPTIONS_NULL;
            obtain.obj = Integer.valueOf(this.f8945b);
            ChatMessageAdapter.this.f8938u.sendMessage(obtain);
        }
    }

    /* renamed from: a */
    public final void m8911a(ArrayList<ChatMessage> arrayList, boolean z) {
        if (arrayList == null) {
            return;
        }
        if (this.f8918a == null) {
            this.f8918a = new ArrayList<>();
        }
        this.f8918a.addAll(arrayList);
        Collections.sort(this.f8918a, new MessageComparator());
        if (z) {
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    private static void m8912a(String str, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            if (!lowerCase.endsWith(".txt") && !lowerCase.endsWith(".doc") && !lowerCase.endsWith(".log")) {
                if (!lowerCase.endsWith(".jpg") && !lowerCase.endsWith(".png") && !lowerCase.endsWith(".bmp")) {
                    if (lowerCase.endsWith(".x431")) {
                        imageView.setImageResource(R.drawable.icon_file_x431);
                        return;
                    } else {
                        imageView.setImageResource(R.drawable.icon_file_other);
                        return;
                    }
                }
                imageView.setImageResource(R.drawable.icon_file_img);
                return;
            }
            imageView.setImageResource(R.drawable.icon_file_txt);
        } catch (Exception e) {
            Log.e("Sanda", "setFileImage" + e.toString());
            imageView.setImageResource(R.drawable.icon_file_other);
        }
    }

    /* renamed from: b */
    public final ChatMessage m8910b(int i) {
        try {
            if (this.f8918a == null || this.f8918a.size() <= 0) {
                return null;
            }
            ChatMessage chatMessage = this.f8918a.get(i);
            if (chatMessage.m218a() == 10) {
                String m211b = chatMessage.m211b();
                StringBuilder sb = new StringBuilder();
                sb.append(new JSONObject());
                chatMessage.f24063h = sb.toString();
                chatMessage.m217a(1);
                chatMessage.m214a("text", (Object) m211b);
            }
            chatMessage.f24062g = Long.valueOf(System.currentTimeMillis() + MessageParameters.f23943h);
            Collections.sort(this.f8918a, new MessageComparator());
            notifyDataSetChanged();
            return chatMessage;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public final boolean m8908c(int i) {
        try {
            if (this.f8918a == null || this.f8918a.size() <= 0) {
                return false;
            }
            ChatMessage chatMessage = this.f8918a.get(i);
            return !chatMessage.f24060e.equalsIgnoreCase(chatMessage.f24057b);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x0690 A[Catch: Exception -> 0x07b1, TryCatch #5 {Exception -> 0x07b1, blocks: (B:4:0x0007, B:5:0x000b, B:26:0x0155, B:27:0x015a, B:38:0x0231, B:40:0x0237, B:41:0x0252, B:43:0x0257, B:45:0x0277, B:46:0x0287, B:48:0x0293, B:49:0x02a3, B:50:0x02ae, B:80:0x03ac, B:81:0x03b5, B:83:0x03c1, B:85:0x03cc, B:84:0x03c7, B:86:0x03d4, B:88:0x03e0, B:90:0x03eb, B:89:0x03e6, B:92:0x03f3, B:94:0x03fb, B:98:0x041d, B:99:0x047d, B:101:0x0483, B:103:0x0489, B:105:0x048f, B:106:0x04eb, B:112:0x0503, B:114:0x0528, B:116:0x0535, B:118:0x053b, B:120:0x054b, B:122:0x055d, B:124:0x056e, B:126:0x0576, B:130:0x0598, B:123:0x0564, B:135:0x0612, B:136:0x061d, B:137:0x0625, B:139:0x0630, B:141:0x063c, B:142:0x0640, B:143:0x0647, B:145:0x0650, B:148:0x065d, B:150:0x067b, B:152:0x0690, B:154:0x069f, B:155:0x06a9, B:156:0x06b0, B:149:0x066f, B:157:0x06b7, B:158:0x06c0, B:172:0x06fb, B:173:0x0700, B:174:0x0703, B:176:0x0731, B:178:0x0743, B:179:0x0780, B:183:0x07ad, B:110:0x04fe, B:134:0x060d, B:29:0x015f, B:30:0x017a, B:31:0x018a, B:32:0x01a5, B:33:0x01b2, B:34:0x01c1, B:35:0x01db, B:36:0x01fe, B:37:0x0223, B:7:0x0011, B:8:0x0023, B:9:0x0035, B:10:0x0047, B:11:0x0059, B:12:0x006b, B:13:0x007d, B:14:0x008c, B:15:0x009b, B:16:0x00aa, B:17:0x00bc, B:18:0x00ce, B:19:0x00e0, B:20:0x00f1, B:21:0x0102, B:22:0x0113, B:23:0x0123, B:24:0x0134, B:25:0x0145, B:51:0x02b1, B:53:0x02bd, B:54:0x02ee, B:56:0x02f1, B:58:0x02f9, B:75:0x038e, B:77:0x0392, B:78:0x03a5, B:59:0x0317, B:61:0x031b, B:63:0x031e, B:65:0x0326, B:66:0x0343, B:68:0x0347, B:70:0x034a, B:72:0x0352, B:73:0x036f, B:74:0x0372, B:159:0x06c3, B:163:0x06d6, B:165:0x06e3, B:167:0x06e7, B:168:0x06f0), top: B:199:0x0007, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x06b0 A[Catch: Exception -> 0x07b1, TryCatch #5 {Exception -> 0x07b1, blocks: (B:4:0x0007, B:5:0x000b, B:26:0x0155, B:27:0x015a, B:38:0x0231, B:40:0x0237, B:41:0x0252, B:43:0x0257, B:45:0x0277, B:46:0x0287, B:48:0x0293, B:49:0x02a3, B:50:0x02ae, B:80:0x03ac, B:81:0x03b5, B:83:0x03c1, B:85:0x03cc, B:84:0x03c7, B:86:0x03d4, B:88:0x03e0, B:90:0x03eb, B:89:0x03e6, B:92:0x03f3, B:94:0x03fb, B:98:0x041d, B:99:0x047d, B:101:0x0483, B:103:0x0489, B:105:0x048f, B:106:0x04eb, B:112:0x0503, B:114:0x0528, B:116:0x0535, B:118:0x053b, B:120:0x054b, B:122:0x055d, B:124:0x056e, B:126:0x0576, B:130:0x0598, B:123:0x0564, B:135:0x0612, B:136:0x061d, B:137:0x0625, B:139:0x0630, B:141:0x063c, B:142:0x0640, B:143:0x0647, B:145:0x0650, B:148:0x065d, B:150:0x067b, B:152:0x0690, B:154:0x069f, B:155:0x06a9, B:156:0x06b0, B:149:0x066f, B:157:0x06b7, B:158:0x06c0, B:172:0x06fb, B:173:0x0700, B:174:0x0703, B:176:0x0731, B:178:0x0743, B:179:0x0780, B:183:0x07ad, B:110:0x04fe, B:134:0x060d, B:29:0x015f, B:30:0x017a, B:31:0x018a, B:32:0x01a5, B:33:0x01b2, B:34:0x01c1, B:35:0x01db, B:36:0x01fe, B:37:0x0223, B:7:0x0011, B:8:0x0023, B:9:0x0035, B:10:0x0047, B:11:0x0059, B:12:0x006b, B:13:0x007d, B:14:0x008c, B:15:0x009b, B:16:0x00aa, B:17:0x00bc, B:18:0x00ce, B:19:0x00e0, B:20:0x00f1, B:21:0x0102, B:22:0x0113, B:23:0x0123, B:24:0x0134, B:25:0x0145, B:51:0x02b1, B:53:0x02bd, B:54:0x02ee, B:56:0x02f1, B:58:0x02f9, B:75:0x038e, B:77:0x0392, B:78:0x03a5, B:59:0x0317, B:61:0x031b, B:63:0x031e, B:65:0x0326, B:66:0x0343, B:68:0x0347, B:70:0x034a, B:72:0x0352, B:73:0x036f, B:74:0x0372, B:159:0x06c3, B:163:0x06d6, B:165:0x06e3, B:167:0x06e7, B:168:0x06f0), top: B:199:0x0007, inners: #0, #1, #2, #3, #4 }] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r25, android.view.View r26, android.view.ViewGroup r27) {
        /*
            Method dump skipped, instructions count: 2136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p169im.p170a.ChatMessageAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
