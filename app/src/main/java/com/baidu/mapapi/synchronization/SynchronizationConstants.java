package com.baidu.mapapi.synchronization;

/* loaded from: classes.dex */
public final class SynchronizationConstants {
    public static final int LBS_DRIVER_POSITION_FRESH_FREQUENCY_DEFAULT = 5;
    public static final int LBS_DRIVER_POSITION_FRESH_FREQUENCY_MAX = 30;
    public static final int LBS_DRIVER_POSITION_FRESH_FREQUENCY_MIN = 5;
    public static final int LBS_ERROR_CALCULATE_ROUTE_FAILED = 2001;
    public static final int LBS_ERROR_DISPLAYOPTIONS_INSTANCE_INVALID = 1004;
    public static final int LBS_ERROR_NO_BAIDUMAP = 1000;
    public static final int LBS_ERROR_ORDER_PARAM_INVALID = 1003;
    public static final int LBS_ERROR_ORDER_STATE_INVALID = 1002;
    public static final int LBS_ERROR_PASSENGER_NO_ORDERID = 1001;
    public static final int LBS_ERROR_QUERY_TRACK_ROUTE_FAILED = 2003;
    public static final int LBS_ERROR_QUERY_TRACK_ROUTE_SUCCESS = 2002;
    public static final int LBS_MAP_FROZEN_INTERVAL_DEFAULT = 10;
    public static final int LBS_MAP_FROZEN_INTERVAL_OPERATE_MAX = 30;
    public static final int LBS_MAP_FROZEN_INTERVAL_OPERATE_MIN = 10;
    public static final int LBS_MAP_FROZEN_INTERVAL_UNOPERATE_MIN = 5;
    public static final int LBS_MAP_FROZEN_INTERVAL__UNOPERATE_MAX = 30;
    public static final int LBS_ORDER_STATE_DELIVER_PASSENGER = 4;
    public static final int LBS_ORDER_STATE_ORDER_COMPLETE = 5;
    public static final int LBS_ORDER_STATE_PICK_UP_PASSENGER = 2;
    public static final int LBS_ORDER_STATE_READY_FOR_SERVICE = 1;
    public static final int LBS_ORDER_STATE_UNSPECIFIED = 0;
    public static final int LBS_ORDER_STATE_WAIT_PASSENGER = 3;
    public static final int LBS_ROUTE_WIDTH_DEFAULT = 22;
    public static final int LBS_ROUTE_WIDTH_MAX = 40;
    public static final int LBS_ROUTE_WIDTH_MIN = 5;
    public static final int LBS_STATUS_CODE_FINISHED_DEGRADED_DISPLAY = 3001;
    public static final int LBS_STATUS_CODE_START_DEGRADED_DISPLAY = 3000;
    public static final int LBS_STATUS_CODE_SUCCESS = 0;
    public static final String LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID = "DisplayOptions instance init null.";
    public static final String LBS_STATUS_MESSAGE_FINISHED_DEGRADED_DISPLAY = "Finished degraded display.";
    public static final String LBS_STATUS_MESSAGE_NO_BAIDUMAP = "BaiduMap is null.";
    public static final String LBS_STATUS_MESSAGE_NO_ORDERID = "OrderId is null.";
    public static final String LBS_STATUS_MESSAGE_ORDER_PARAM_INVALID = "Order param is invalid.";
    public static final String LBS_STATUS_MESSAGE_ORDER_STATE_INVALID = "Order state is invalid.";
    public static final String LBS_STATUS_MESSAGE_QUERY_TRACK_ROUTE_FAILED = "Query track route failed.";
    public static final String LBS_STATUS_MESSAGE_QUERY_TRACK_ROUTE_SUCCESS = "Query track route sucess.";
    public static final String LBS_STATUS_MESSAGE_ROUTE_PLAN_FAILED = "Route plan failed.";
    public static final String LBS_STATUS_MESSAGE_START_DEGRADED_DISPLAY = "Start degraded display.";
    public static final String LBS_STATUS_MESSAGE_SUCESS = "Handle successful";
    public static final int LBS_TRAFFIC_STATUS_CONGESTION = 3;
    public static final int LBS_TRAFFIC_STATUS_SEVERE_CONGESTION = 4;
    public static final int LBS_TRAFFIC_STATUS_SLOW = 2;
    public static final int LBS_TRAFFIC_STATUS_SMOOTH = 1;
    public static final int LBS_TRAFFIC_STATUS_UNKNOW = 0;
    public static final int ROUTE_ID_PASSENGER = 0;

    private SynchronizationConstants() {
    }
}
