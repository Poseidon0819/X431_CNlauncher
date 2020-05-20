package message.xmpp.p385iq;

import org.jivesoftware.smack.packet.AbstractC4971IQ;

/* renamed from: message.xmpp.iq.ActivityIQ */
/* loaded from: classes2.dex */
public class ActivityIQ extends AbstractC4971IQ {
    public static final int ACTIVITY_APPLY = 1;
    public static final int ACTIVITY_REPLAY = 2;
    public static final int APPLY_GROUP = 11;
    public static final int CAR_GROUP_NOTI = 21;
    public static final int GROUP_ATTITUDE = 4;
    public static final int GROUP_REPLY = 3;
    public static final int INVITE_GROUP = 12;
    public static final int LAUNCH_PACKAGE = 36;
    public static final int MAINTENANCE = 32;
    public static final int NEW_BIND_CUSTOMERS = 38;
    public static final int NEW_CONSUMER_RECORDS = 39;
    public static final int ORDER_FORM = 31;
    public static final int REMIND_CUSTOMERS = 34;
    public static final int RESERVATION_DIAG = 33;
    public static final int ROSE_PINK = 35;
    public static final int SHOP_EMERGENCY = 40;
    public static final int UPDATE_GROUP_NICKNAME = 13;
    private String activity_type;
    private String event_id;
    private String gid;
    private String nickname;
    private String post_id;
    private String ring;
    private String text;
    private AbstractC4971IQ.Type type = AbstractC4971IQ.Type.NOTICE;
    private String uid;

    @Override // org.jivesoftware.smack.packet.AbstractC4971IQ
    public String getChildElementXML() {
        return null;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public void setPost_id(String str) {
        this.post_id = str;
    }

    public String getRing() {
        return this.ring;
    }

    public void setRing(String str) {
        this.ring = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    @Override // org.jivesoftware.smack.packet.AbstractC4971IQ
    public AbstractC4971IQ.Type getType() {
        return this.type;
    }

    @Override // org.jivesoftware.smack.packet.AbstractC4971IQ
    public void setType(AbstractC4971IQ.Type type) {
        this.type = type;
    }

    public String getEvent_id() {
        return this.event_id;
    }

    public void setEvent_id(String str) {
        this.event_id = str;
    }

    public String getActivityType() {
        return this.activity_type;
    }

    public void setActivityType(String str) {
        this.activity_type = str;
    }
}
