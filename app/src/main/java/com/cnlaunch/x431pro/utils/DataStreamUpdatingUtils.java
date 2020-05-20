package com.cnlaunch.x431pro.utils;

import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.DataStreamSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYMultipleSeriesRenderer;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.utils.p */
/* loaded from: classes.dex */
public abstract class DataStreamUpdatingUtils {
    /* renamed from: a */
    private static double m4883a(double d, double d2) {
        if (d2 <= 0.0d || d < 0.0d) {
            double abs = Math.abs(d2) + Math.abs(d);
            if (abs > 600000.0d) {
                if (abs < 1500000.0d) {
                    return 250000.0d;
                }
                return abs < 3000000.0d ? 500000.0d : 1000000.0d;
            } else if (abs > 60000.0d) {
                if (abs < 150000.0d) {
                    return 25000.0d;
                }
                return abs < 300000.0d ? 50000.0d : 100000.0d;
            } else if (abs > 6000.0d) {
                if (abs < 15000.0d) {
                    return 2500.0d;
                }
                return abs < 30000.0d ? 5000.0d : 10000.0d;
            } else if (abs > 600.0d) {
                if (abs < 1500.0d) {
                    return 250.0d;
                }
                if (abs < 3000.0d) {
                    return 500.0d;
                }
                return (d2 > 5000.0d && abs < 7500.0d) ? 1250.0d : 1000.0d;
            } else if (abs > 60.0d) {
                if (abs < 180.0d) {
                    return 30.0d;
                }
                return abs < 300.0d ? 50.0d : 100.0d;
            } else if (abs > 6.0d) {
                if (abs < 30.0d) {
                    return 5.0d;
                }
                return abs < 60.0d ? 10.0d : 20.0d;
            } else if (abs < 6.0d) {
                if (abs <= 1.0d) {
                    return 0.2d;
                }
                if (abs <= 2.0d) {
                    return 0.4d;
                }
                return abs <= 4.0d ? 0.8d : 1.0d;
            }
        } else if (d2 > 600000.0d) {
            if (d2 < 1500000.0d) {
                return 250000.0d;
            }
            return d2 < 3000000.0d ? 500000.0d : 1000000.0d;
        } else if (d2 > 60000.0d) {
            if (d2 < 150000.0d) {
                return 25000.0d;
            }
            return d2 < 300000.0d ? 50000.0d : 100000.0d;
        } else if (d2 > 6000.0d) {
            if (d2 < 15000.0d) {
                return 2500.0d;
            }
            return d2 < 30000.0d ? 5000.0d : 10000.0d;
        } else if (d2 > 600.0d) {
            if (d2 < 1500.0d) {
                return 250.0d;
            }
            if (d2 < 3000.0d) {
                return 500.0d;
            }
            return (d2 >= 5000.0d && d2 < 7500.0d) ? 1250.0d : 1000.0d;
        } else if (d2 > 60.0d) {
            if (d2 < 180.0d) {
                return 30.0d;
            }
            return d2 < 300.0d ? 50.0d : 100.0d;
        } else if (d2 > 6.0d) {
            if (d2 < 30.0d) {
                return 5.0d;
            }
            return d2 < 60.0d ? 10.0d : 20.0d;
        } else if (d2 < 6.0d) {
            if (d2 <= 1.0d) {
                return 0.2d;
            }
            if (d2 <= 2.0d) {
                return 0.4d;
            }
            return d2 <= 4.0d ? 0.8d : 1.0d;
        }
        return 1.0d;
    }

    /* renamed from: a */
    public static void m4880a(DataStreamSeriesRenderer dataStreamSeriesRenderer, XYSeries xYSeries, long j) {
        long j2;
        synchronized (xYSeries) {
            int xGridRange = dataStreamSeriesRenderer.getXGridRange();
            double minY = xYSeries.getMinY();
            double maxY = xYSeries.getMaxY();
            if (j > xGridRange) {
                dataStreamSeriesRenderer.setXAxisMin(j - j2);
                dataStreamSeriesRenderer.setXAxisMax(j);
            } else {
                dataStreamSeriesRenderer.setXAxisMin(0.0d);
                dataStreamSeriesRenderer.setXAxisMax(xGridRange);
            }
            double m4883a = m4883a(minY, maxY);
            if (maxY <= 0.0d || minY < 0.0d) {
                int i = 0;
                while (true) {
                    if (i > 6) {
                        break;
                    }
                    double abs = Math.abs(minY);
                    double d = i;
                    Double.isNaN(d);
                    double d2 = d * m4883a;
                    if (abs <= d2) {
                        double d3 = -d2;
                        double d4 = (6.0d * m4883a) + d3;
                        if (d4 < maxY) {
                            double d5 = m4883a * 3.0d;
                            d4 += d5;
                            d3 -= d5;
                        }
                        dataStreamSeriesRenderer.setYAxisMin(d3);
                        dataStreamSeriesRenderer.setYAxisMax(d4);
                    } else {
                        i++;
                    }
                }
            } else {
                dataStreamSeriesRenderer.setYAxisMin(0.0d);
                dataStreamSeriesRenderer.setYAxisMax(m4883a * 6.0d);
            }
            dataStreamSeriesRenderer.setYInnerLabels(5);
        }
    }

    /* renamed from: a */
    private static int m4882a(int i) {
        int i2 = i % 6 > 0 ? (i / 6) + 1 : i / 6;
        if (i2 > 10) {
            return 10;
        }
        return i2;
    }

    /* renamed from: b */
    public static void m4877b(DataStreamSeriesRenderer dataStreamSeriesRenderer, XYSeries xYSeries, long j) {
        long j2;
        int m4882a;
        int xGridRange = dataStreamSeriesRenderer.getXGridRange();
        if (j > xGridRange) {
            dataStreamSeriesRenderer.setXAxisMin(j - j2);
            dataStreamSeriesRenderer.setXAxisMax(j);
        } else {
            dataStreamSeriesRenderer.setXAxisMin(0.0d);
            dataStreamSeriesRenderer.setXAxisMax(xGridRange);
        }
        dataStreamSeriesRenderer.setYInnerLabels(m4882a((int) xYSeries.getMaxY()));
        dataStreamSeriesRenderer.setYAxisMin(0.0d);
        dataStreamSeriesRenderer.setYAxisMax(m4882a * 6);
    }

    /* renamed from: a */
    public static void m4878a(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, XYSeries xYSeries, long j, int i) {
        long j2;
        int m4882a;
        int xGridRange = xYMultipleSeriesRenderer.getXGridRange();
        if (j > xGridRange) {
            xYMultipleSeriesRenderer.setXAxisMin(j - j2);
            xYMultipleSeriesRenderer.setXAxisMax(j);
        } else {
            xYMultipleSeriesRenderer.setXAxisMin(0.0d, i);
            xYMultipleSeriesRenderer.setXAxisMax(xGridRange, i);
        }
        xYMultipleSeriesRenderer.setYInnerLabels(m4882a((int) xYSeries.getMaxY()), i);
        xYMultipleSeriesRenderer.setYAxisMin(0.0d, i);
        xYMultipleSeriesRenderer.setYAxisMax(m4882a * 6, i);
    }

    /* renamed from: a */
    public static void m4879a(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, XYSeries xYSeries, double d, int i) {
        synchronized (xYMultipleSeriesRenderer) {
            int xGridRange = xYMultipleSeriesRenderer.getXGridRange();
            double minY = xYSeries.getMinY();
            double maxY = xYSeries.getMaxY();
            double d2 = xGridRange;
            if (d > d2) {
                Double.isNaN(d2);
                xYMultipleSeriesRenderer.setXAxisMin(d - d2, i);
                xYMultipleSeriesRenderer.setXAxisMax(d, i);
            } else {
                xYMultipleSeriesRenderer.setXAxisMin(0.0d, i);
                xYMultipleSeriesRenderer.setXAxisMax(d2, i);
            }
            double m4883a = m4883a(minY, maxY);
            if (maxY <= 0.0d || minY < 0.0d) {
                int i2 = 0;
                while (true) {
                    if (i2 > 6) {
                        break;
                    }
                    double abs = Math.abs(minY);
                    double d3 = i2;
                    Double.isNaN(d3);
                    double d4 = d3 * m4883a;
                    if (abs <= d4) {
                        double d5 = -d4;
                        double d6 = (6.0d * m4883a) + d5;
                        if (d6 < maxY) {
                            double d7 = m4883a * 3.0d;
                            d6 += d7;
                            d5 -= d7;
                        }
                        xYMultipleSeriesRenderer.setYAxisMin(d5, i);
                        xYMultipleSeriesRenderer.setYAxisMax(d6, i);
                    } else {
                        i2++;
                    }
                }
            } else {
                xYMultipleSeriesRenderer.setYAxisMin(0.0d, i);
                xYMultipleSeriesRenderer.setYAxisMax(m4883a * 6.0d, i);
            }
        }
    }

    /* renamed from: a */
    public static void m4881a(XYSeries xYSeries, Map<String, Integer> map, double d, String str) {
        if (!map.containsKey(str)) {
            int size = map.size() + 1;
            map.put(str, Integer.valueOf(size));
            xYSeries.add(d, size);
            return;
        }
        xYSeries.add(d, map.get(str).intValue());
    }
}
