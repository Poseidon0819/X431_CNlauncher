package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.o */
/* loaded from: classes.dex */
public final class ShopInfo extends AbstractC2709c {
    private String addressCity;
    private String addressLine1;
    private String addressLine2;
    private String addressProvince;
    private String company_address;
    private String company_fullname;
    private String email;
    private String fax;
    private String serial_number;
    private String shopPhoto;
    private String telephone;
    private String zipcode;

    public final String getSerial_number() {
        return this.serial_number;
    }

    public final void setSerial_number(String str) {
        this.serial_number = str;
    }

    public final String getCompany_fullname() {
        return this.company_fullname;
    }

    public final void setCompany_fullname(String str) {
        this.company_fullname = str;
    }

    public final String getCompany_address() {
        return this.company_address;
    }

    public final void setCompany_address(String str) {
        this.company_address = str;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public final void setTelephone(String str) {
        this.telephone = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getZipcode() {
        return this.zipcode;
    }

    public final void setZipcode(String str) {
        this.zipcode = str;
    }

    public final String getFax() {
        return this.fax;
    }

    public final void setFax(String str) {
        this.fax = str;
    }

    public final String getShopPhoto() {
        return this.shopPhoto;
    }

    public final void setShopPhoto(String str) {
        this.shopPhoto = str;
    }

    public final String getAddressLine1() {
        return this.addressLine1;
    }

    public final void setAddressLine1(String str) {
        this.addressLine1 = str;
    }

    public final String getAddressLine2() {
        return this.addressLine2;
    }

    public final void setAddressLine2(String str) {
        this.addressLine2 = str;
    }

    public final String getAddressCity() {
        return this.addressCity;
    }

    public final void setAddressCity(String str) {
        this.addressCity = str;
    }

    public final String getAddressProvince() {
        return this.addressProvince;
    }

    public final void setAddressProvince(String str) {
        this.addressProvince = str;
    }

    public final String toString() {
        return "ShopInfo{serial_number='" + this.serial_number + "', company_fullname='" + this.company_fullname + "', company_address='" + this.company_address + "', telephone='" + this.telephone + "', email='" + this.email + "', zipcode='" + this.zipcode + "', fax='" + this.fax + "', shopPhoto='" + this.shopPhoto + "', addressLine1='" + this.addressLine1 + "', addressLine2='" + this.addressLine2 + "', addressCity='" + this.addressCity + "', addressProvince='" + this.addressProvince + "'}";
    }
}
