package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.widget.sortlistview.CharacterParser;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.k */
/* loaded from: classes.dex */
public class GoloRemoteOrderInfo extends CustomerInfo {
    private static final long serialVersionUID = 2479528789903457316L;
    private String auto_code;
    private String auto_logos;
    private String car_id;
    private Long created;
    private Long db_id;
    private String description;
    private String diagType;
    private String face_thumb;
    private String face_url;

    /* renamed from: id */
    private String f15542id;
    private Boolean isRead;
    private String mine_car_plate_num;
    private String online_status;
    private String serial_no;
    private String signature;
    private String sortKey;
    private String status;

    public GoloRemoteOrderInfo() {
        this.isRead = Boolean.FALSE;
        this.diagType = "";
    }

    public GoloRemoteOrderInfo(Long l) {
        this.isRead = Boolean.FALSE;
        this.diagType = "";
        setDb_id(l);
    }

    public GoloRemoteOrderInfo(Long l, String str, String str2, String str3, String str4, Long l2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Boolean bool, String str17) {
        this.isRead = Boolean.FALSE;
        this.diagType = "";
        setDb_id(l);
        setId(str);
        this.car_id = str2;
        this.description = str3;
        this.status = str4;
        this.created = l2;
        this.auto_code = str5;
        this.mine_car_plate_num = str6;
        setUser_id(str7);
        setUser_name(str8);
        setNick_name(str9);
        this.face_url = str10;
        this.face_thumb = str11;
        this.auto_logos = str12;
        this.online_status = str13;
        this.signature = str14;
        this.sortKey = str15;
        this.serial_no = str16;
        this.isRead = bool;
        setDiagType(str17);
    }

    public String getCar_id() {
        return this.car_id;
    }

    public void setCar_id(String str) {
        this.car_id = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    @Override // com.cnlaunch.x431pro.module.golo.model.CustomerInfo
    public String getStatus() {
        return this.status;
    }

    @Override // com.cnlaunch.x431pro.module.golo.model.CustomerInfo
    public void setStatus(String str) {
        this.status = str;
    }

    public Long getCreated() {
        return this.created;
    }

    public void setCreated(Long l) {
        this.created = l;
    }

    public String getAuto_code() {
        return this.auto_code;
    }

    public void setAuto_code(String str) {
        this.auto_code = str;
    }

    public String getMine_car_plate_num() {
        return this.mine_car_plate_num;
    }

    public void setMine_car_plate_num(String str) {
        this.mine_car_plate_num = str;
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

    public String getAuto_logos() {
        return this.auto_logos;
    }

    public void setAuto_logos(String str) {
        this.auto_logos = str;
    }

    public String getOnline_status() {
        return this.online_status;
    }

    public void setOnline_status(String str) {
        this.online_status = str;
    }

    @Override // com.cnlaunch.x431pro.module.golo.model.CustomerInfo
    public String getSignature() {
        return this.signature;
    }

    @Override // com.cnlaunch.x431pro.module.golo.model.CustomerInfo
    public void setSignature(String str) {
        this.signature = str;
    }

    @Override // com.cnlaunch.x431pro.module.golo.model.CustomerInfo
    public String getSortKey() {
        return this.sortKey;
    }

    @Override // com.cnlaunch.x431pro.module.golo.model.CustomerInfo
    public void setSortKey(String str) {
        this.sortKey = str;
    }

    public String getSerial_no() {
        return this.serial_no;
    }

    public void setSerial_no(String str) {
        this.serial_no = str;
    }

    @Override // com.cnlaunch.x431pro.module.golo.model.CustomerInfo
    public Boolean getIsRead() {
        return this.isRead;
    }

    @Override // com.cnlaunch.x431pro.module.golo.model.CustomerInfo
    public void setIsRead(Boolean bool) {
        this.isRead = bool;
    }

    public String toString() {
        return "GoloRemoteOrderInfo [id=" + getDb_id() + ", car_id=" + this.car_id + ", description=" + this.description + ", status=" + this.status + ", created=" + this.created + ", auto_code=" + this.auto_code + ", mine_car_plate_num=" + this.mine_car_plate_num + ", face_url=" + this.face_url + ", face_thumb=" + this.face_thumb + ", auto_logos=" + this.auto_logos + "]";
    }

    public static void filledData(List<GoloRemoteOrderInfo> list, List<GoloRemoteOrderInfo> list2) {
        if (list == null) {
            return;
        }
        for (GoloRemoteOrderInfo goloRemoteOrderInfo : list) {
            String nick_name = isNotNull(goloRemoteOrderInfo.getNick_name()) ? goloRemoteOrderInfo.getNick_name() : goloRemoteOrderInfo.getUser_name();
            if (nick_name != null) {
                String m4390a = CharacterParser.m4391a().m4390a(nick_name);
                if (m4390a == null || "".equals(m4390a)) {
                    if (goloRemoteOrderInfo.getAuto_code().length() > 0) {
                        goloRemoteOrderInfo.setSortKey("Z");
                    } else {
                        goloRemoteOrderInfo.setSortKey("#");
                    }
                    list2.add(goloRemoteOrderInfo);
                } else {
                    String upperCase = m4390a.substring(0, 1).toUpperCase();
                    if (upperCase.matches("[A-Z]")) {
                        goloRemoteOrderInfo.setSortKey(upperCase);
                    } else {
                        goloRemoteOrderInfo.setSortKey("#");
                    }
                    list2.add(goloRemoteOrderInfo);
                }
            }
        }
    }

    public static void filledData(List<GoloRemoteOrderInfo> list) {
        if (list == null) {
            return;
        }
        for (GoloRemoteOrderInfo goloRemoteOrderInfo : list) {
            String nick_name = isNotNull(goloRemoteOrderInfo.getNick_name()) ? goloRemoteOrderInfo.getNick_name() : goloRemoteOrderInfo.getUser_name();
            if (nick_name != null) {
                String m4390a = CharacterParser.m4391a().m4390a(nick_name);
                if (m4390a == null || "".equals(m4390a)) {
                    if (goloRemoteOrderInfo.getAuto_code().length() > 0) {
                        goloRemoteOrderInfo.setSortKey("Z");
                    } else {
                        goloRemoteOrderInfo.setSortKey("#");
                    }
                } else {
                    String upperCase = m4390a.substring(0, 1).toUpperCase();
                    if (upperCase.matches("[A-Z]")) {
                        goloRemoteOrderInfo.setSortKey(upperCase);
                    } else {
                        goloRemoteOrderInfo.setSortKey("#");
                    }
                }
            }
        }
    }

    public String getId() {
        return this.f15542id;
    }

    public void setId(String str) {
        this.f15542id = str;
    }

    public Long getDb_id() {
        return this.db_id;
    }

    public void setDb_id(Long l) {
        this.db_id = l;
    }

    public String getDiagType() {
        return this.diagType;
    }

    public void setDiagType(String str) {
        this.diagType = str;
    }
}
