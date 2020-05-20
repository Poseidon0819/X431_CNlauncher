package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.activity.golo.others.CarTeamObject;
import com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import com.cnlaunch.x431pro.utils.C2744aa;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.f */
/* loaded from: classes.dex */
public class FriendInfo extends AbstractC2709c implements InfaceItemInfo {
    private static final long serialVersionUID = -4888369022641658248L;
    private String face_thumb;
    private String face_url;

    /* renamed from: id */
    private Long f15541id;
    private boolean isFriend;
    private String lastText;
    private Long lastTime;
    private String nick_name;
    private int noRead;
    private String public_id;
    private String public_name;
    private String r_type;
    private String rename;
    private String roles;
    private Integer sex;
    private String signature;
    private String sortKey;
    private String user_id;
    private String user_name;

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public int getSrcType() {
        return 1;
    }

    public FriendInfo() {
        this.noRead = 0;
        this.isFriend = true;
    }

    public FriendInfo(Long l) {
        this.noRead = 0;
        this.isFriend = true;
        this.f15541id = l;
    }

    public FriendInfo(Long l, String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Long l2, int i) {
        this.noRead = 0;
        this.isFriend = true;
        this.f15541id = l;
        this.user_id = str;
        this.user_name = str2;
        this.nick_name = str3;
        this.rename = str4;
        this.signature = str5;
        this.sex = num;
        this.sortKey = str6;
        this.public_id = str7;
        this.public_name = str8;
        this.r_type = str9;
        this.roles = str10;
        this.face_url = str11;
        this.face_thumb = str12;
        this.lastText = str13;
        this.lastTime = l2;
        this.noRead = i;
    }

    public Long getId() {
        return this.f15541id;
    }

    public void setId(Long l) {
        this.f15541id = l;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public String getNick_name() {
        return this.nick_name;
    }

    public void setNick_name(String str) {
        this.nick_name = str;
    }

    public String getRename() {
        return this.rename;
    }

    public void setRename(String str) {
        this.rename = str;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer num) {
        this.sex = num;
    }

    public String getSortKey() {
        return this.sortKey;
    }

    public void setSortKey(String str) {
        this.sortKey = str;
    }

    public String getPublic_id() {
        return this.public_id;
    }

    public void setPublic_id(String str) {
        this.public_id = str;
    }

    public String getPublic_name() {
        return this.public_name;
    }

    public void setPublic_name(String str) {
        this.public_name = str;
    }

    public String getR_type() {
        return this.r_type;
    }

    public void setR_type(String str) {
        this.r_type = str;
    }

    public String getRoles() {
        return this.roles;
    }

    public int getIntRoles() {
        try {
            return Integer.parseInt(this.roles);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setRoles(String str) {
        this.roles = str;
    }

    public String getFace_url() {
        return this.face_url;
    }

    public void setFace_url(String str) {
        this.face_url = str;
    }

    public String getFace_thumb() {
        return this.face_thumb;
    }

    public void setFace_thumb(String str) {
        this.face_thumb = str;
    }

    public String getFaceUrl() {
        return getFace_thumb();
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public String getName() {
        return C2744aa.m5178a(getNick_name()) ? getNick_name() : getUser_name();
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public String getUserID() {
        return getUser_id();
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public boolean isFriend() {
        return this.isFriend;
    }

    public Long getLastTime() {
        return this.lastTime;
    }

    public void setLastTime(Long l) {
        this.lastTime = l;
    }

    public String getLastText() {
        return this.lastText;
    }

    public void setLastText(String str) {
        this.lastText = str;
    }

    public int getNoRead() {
        return this.noRead;
    }

    public void setNoRead(int i) {
        this.noRead = i;
    }

    public boolean isCarTeam() {
        return CarTeamObject.m6965a(this.user_id);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.others.InfaceItemInfo
    public void setFriend(boolean z) {
        this.isFriend = z;
    }
}
