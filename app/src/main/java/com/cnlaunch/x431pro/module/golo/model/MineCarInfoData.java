package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.m */
/* loaded from: classes.dex */
public final class MineCarInfoData extends AbstractC2709c {
    private static final long serialVersionUID = 8721514011967154782L;
    private String car_brand_vin;
    private String car_displacement;
    private String car_gearbox_type;
    private String car_producing_year;
    private String car_series_name;
    private String car_type_id;
    private String mine_car_plate_num;

    public final String getMine_car_plate_num() {
        return this.mine_car_plate_num;
    }

    public final void setMine_car_plate_num(String str) {
        this.mine_car_plate_num = str;
    }

    public final String getCar_series_name() {
        return this.car_series_name;
    }

    public final void setCar_series_name(String str) {
        this.car_series_name = str;
    }

    public final String getCar_type_id() {
        return this.car_type_id;
    }

    public final void setCar_type_id(String str) {
        this.car_type_id = str;
    }

    public final String getCar_producing_year() {
        return this.car_producing_year;
    }

    public final void setCar_producing_year(String str) {
        this.car_producing_year = str;
    }

    public final String getCar_brand_vin() {
        return this.car_brand_vin;
    }

    public final void setCar_brand_vin(String str) {
        this.car_brand_vin = str;
    }

    public final String getCar_gearbox_type() {
        return this.car_gearbox_type;
    }

    public final void setCar_gearbox_type(String str) {
        this.car_gearbox_type = str;
    }

    public final String getCar_displacement() {
        return this.car_displacement;
    }

    public final void setCar_displacement(String str) {
        this.car_displacement = str;
    }
}
