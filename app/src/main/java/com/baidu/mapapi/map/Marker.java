package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;
import com.itextpdf.text.pdf.ColumnText;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class Marker extends Overlay {

    /* renamed from: a */
    LatLng f5151a;

    /* renamed from: b */
    BitmapDescriptor f5152b;

    /* renamed from: c */
    float f5153c;

    /* renamed from: d */
    float f5154d;

    /* renamed from: e */
    boolean f5155e;

    /* renamed from: f */
    boolean f5156f;

    /* renamed from: g */
    float f5157g;

    /* renamed from: h */
    String f5158h;

    /* renamed from: i */
    int f5159i;

    /* renamed from: l */
    float f5162l;

    /* renamed from: m */
    int f5163m;

    /* renamed from: o */
    ArrayList<BitmapDescriptor> f5165o;

    /* renamed from: q */
    Animation f5167q;

    /* renamed from: u */
    Point f5171u;

    /* renamed from: j */
    boolean f5160j = false;

    /* renamed from: k */
    boolean f5161k = false;

    /* renamed from: n */
    boolean f5164n = false;

    /* renamed from: p */
    int f5166p = 20;

    /* renamed from: r */
    float f5168r = 1.0f;

    /* renamed from: s */
    float f5169s = 1.0f;

    /* renamed from: t */
    float f5170t = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Marker() {
        this.type = EnumC1214h.marker;
    }

    /* renamed from: a */
    private void m11156a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        int i;
        ArrayList arrayList2 = new ArrayList();
        Iterator<BitmapDescriptor> it = arrayList.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle2 = new Bundle();
            Bitmap bitmap = it.next().f4982a;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            bundle2.putByteArray("image_data", array);
            bundle2.putInt("image_width", bitmap.getWidth());
            bundle2.putInt("image_height", bitmap.getHeight());
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            messageDigest.update(array, 0, array.length);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            while (i < digest.length) {
                sb.append(Integer.toString((digest[i] & 255) + 256, 16).substring(1));
                i++;
            }
            bundle2.putString("image_hashcode", sb.toString());
            parcelItem.setBundle(bundle2);
            arrayList2.add(parcelItem);
        }
        if (arrayList2.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
            while (i < arrayList2.size()) {
                parcelItemArr[i] = (ParcelItem) arrayList2.get(i);
                i++;
            }
            bundle.putParcelableArray("icons", parcelItemArr);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    final Bundle mo11138a(Bundle bundle) {
        super.mo11138a(bundle);
        Bundle bundle2 = new Bundle();
        BitmapDescriptor bitmapDescriptor = this.f5152b;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.m11217b());
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f5151a);
        bundle.putInt("animatetype", this.f5163m);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("perspective", this.f5155e ? 1 : 0);
        bundle.putFloat("anchor_x", this.f5153c);
        bundle.putFloat("anchor_y", this.f5154d);
        bundle.putFloat("rotate", this.f5157g);
        bundle.putInt("y_offset", this.f5159i);
        bundle.putInt("isflat", this.f5160j ? 1 : 0);
        bundle.putInt("istop", this.f5161k ? 1 : 0);
        bundle.putInt("period", this.f5166p);
        bundle.putFloat("alpha", this.f5162l);
        bundle.putFloat("scaleX", this.f5168r);
        bundle.putFloat("scaleY", this.f5169s);
        Point point = this.f5171u;
        if (point != null) {
            bundle.putInt("fix_x", point.x);
            bundle.putInt("fix_y", this.f5171u.y);
        }
        bundle.putInt("isfixed", this.f5164n ? 1 : 0);
        ArrayList<BitmapDescriptor> arrayList = this.f5165o;
        if (arrayList != null && arrayList.size() > 0) {
            m11156a(this.f5165o, bundle);
        }
        bundle2.putBundle("param", bundle);
        return bundle;
    }

    public final void cancelAnimation() {
        Animation animation = this.f5167q;
        if (animation != null) {
            animation.bdAnimation.mo10828b();
        }
    }

    public final float getAlpha() {
        return this.f5162l;
    }

    public final float getAnchorX() {
        return this.f5153c;
    }

    public final float getAnchorY() {
        return this.f5154d;
    }

    public final Point getFixedPosition() {
        return this.f5171u;
    }

    public final BitmapDescriptor getIcon() {
        return this.f5152b;
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        return this.f5165o;
    }

    public final String getId() {
        return this.f5201v;
    }

    public final int getPeriod() {
        return this.f5166p;
    }

    public final LatLng getPosition() {
        return this.f5151a;
    }

    public final float getRotate() {
        return this.f5157g;
    }

    public final float getScale() {
        return this.f5170t;
    }

    public final float getScaleX() {
        return this.f5168r;
    }

    public final float getScaleY() {
        return this.f5169s;
    }

    public final String getTitle() {
        return this.f5158h;
    }

    public final int getYOffset() {
        return this.f5159i;
    }

    public final boolean isDraggable() {
        return this.f5156f;
    }

    public final boolean isFixed() {
        return this.f5164n;
    }

    public final boolean isFlat() {
        return this.f5160j;
    }

    public final boolean isPerspective() {
        return this.f5155e;
    }

    public final void setAlpha(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f > 1.0d) {
            this.f5162l = 1.0f;
            return;
        }
        this.f5162l = f;
        this.listener.mo11151b(this);
    }

    public final void setAnchor(float f, float f2) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f > 1.0f || f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f2 > 1.0f) {
            return;
        }
        this.f5153c = f;
        this.f5154d = f2;
        this.listener.mo11151b(this);
    }

    public final void setAnimateType(int i) {
        this.f5163m = i;
        this.listener.mo11151b(this);
    }

    public final void setAnimation(Animation animation) {
        if (animation != null) {
            this.f5167q = animation;
            this.f5167q.bdAnimation.mo10830a(this, animation);
        }
    }

    public final void setDraggable(boolean z) {
        this.f5156f = z;
        this.listener.mo11151b(this);
    }

    public final void setFixedScreenPosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("the screenPosition can not be null");
        }
        this.f5171u = point;
        this.f5164n = true;
        this.listener.mo11151b(this);
    }

    public final void setFlat(boolean z) {
        this.f5160j = z;
        this.listener.mo11151b(this);
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("marker's icon can not be null");
        }
        this.f5152b = bitmapDescriptor;
        this.listener.mo11151b(this);
    }

    public final void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        BitmapDescriptor bitmapDescriptor;
        if (arrayList == null) {
            throw new IllegalArgumentException("marker's icons can not be null");
        }
        if (arrayList.size() == 0) {
            return;
        }
        if (arrayList.size() == 1) {
            bitmapDescriptor = arrayList.get(0);
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == null || arrayList.get(i).f4982a == null) {
                    return;
                }
            }
            this.f5165o = (ArrayList) arrayList.clone();
            bitmapDescriptor = null;
        }
        this.f5152b = bitmapDescriptor;
        this.listener.mo11151b(this);
    }

    public final void setPeriod(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("marker's period must be greater than zero ");
        }
        this.f5166p = i;
        this.listener.mo11151b(this);
    }

    public final void setPerspective(boolean z) {
        this.f5155e = z;
        this.listener.mo11151b(this);
    }

    public final void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("marker's position can not be null");
        }
        this.f5151a = latLng;
        this.listener.mo11151b(this);
    }

    public final void setRotate(float f) {
        while (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f += 360.0f;
        }
        this.f5157g = f % 360.0f;
        this.listener.mo11151b(this);
    }

    public final void setScale(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        this.f5168r = f;
        this.f5169s = f;
        this.listener.mo11151b(this);
    }

    public final void setScaleX(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        this.f5168r = f;
        this.listener.mo11151b(this);
    }

    public final void setScaleY(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        this.f5169s = f;
        this.listener.mo11151b(this);
    }

    public final void setTitle(String str) {
        this.f5158h = str;
    }

    public final void setToTop() {
        this.f5161k = true;
        this.listener.mo11151b(this);
    }

    public final void setYOffset(int i) {
        this.f5159i = i;
        this.listener.mo11151b(this);
    }

    public final void startAnimation() {
        Animation animation = this.f5167q;
        if (animation != null) {
            animation.bdAnimation.mo10837a();
        }
    }
}
