package message.p381d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.p134f.C1473a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

@SuppressLint({"NewApi"})
/* renamed from: message.d.a */
/* loaded from: classes2.dex */
public final class FaceProvider {
    /* renamed from: a */
    public static SpannableStringBuilder m296a(Context context, String str, float f) {
        Drawable drawable;
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            Matcher matcher = Pattern.compile("\\[@([0-9]{3})]").matcher(str);
            String[] stringArray = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_name);
            String[] stringArray2 = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_value);
            while (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    if (i >= stringArray.length) {
                        break;
                    } else if (stringArray[i].equals(group)) {
                        int identifier = ApplicationConfig.f7803b.getIdentifier(Uri.parse(stringArray2[i]).getLastPathSegment().split("\\.")[0], "drawable", ApplicationConfig.f7804c);
                        if (Build.VERSION.SDK_INT > 15) {
                            drawable = context.getResources().getDrawableForDensity(identifier, Opcodes.ISHL);
                        } else {
                            drawable = context.getResources().getDrawable(identifier);
                        }
                        if (drawable != null) {
                            int i2 = ((int) f) * 2;
                            drawable.setBounds(0, 0, i2, i2);
                            spannableStringBuilder.setSpan(new ImageSpan(drawable, 0), matcher.start(), matcher.end(), 33);
                        }
                    } else {
                        i++;
                    }
                }
            }
            return spannableStringBuilder;
        } catch (Exception e) {
            e.printStackTrace();
            return new SpannableStringBuilder();
        }
    }

    /* renamed from: a */
    public static ArrayList<Map<String, Object>> m297a(int i, int i2) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        String[] stringArray = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_name);
        String[] stringArray2 = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_value);
        while (i <= i2) {
            if (i < stringArray.length && i < stringArray2.length) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", stringArray[i]);
                hashMap.put("value", Integer.valueOf(ApplicationConfig.f7803b.getIdentifier(Uri.parse(stringArray2[i]).getLastPathSegment().split("\\.")[0], "drawable", ApplicationConfig.f7804c)));
                arrayList.add(hashMap);
            }
            i++;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("name", "del");
        hashMap2.put("value", Integer.valueOf(C1473a.C1475b.face_del));
        arrayList.add(hashMap2);
        return arrayList;
    }

    /* renamed from: b */
    public static ArrayList<Map<String, Object>> m295b(int i, int i2) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        String[] stringArray = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_goose_name);
        String[] stringArray2 = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_goose_value);
        while (i <= i2) {
            if (i < stringArray.length && i < stringArray2.length) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", stringArray[i]);
                hashMap.put("value", Integer.valueOf(ApplicationConfig.f7803b.getIdentifier(Uri.parse(stringArray2[i]).getLastPathSegment().split("\\.")[0], "drawable", ApplicationConfig.f7804c)));
                arrayList.add(hashMap);
            }
            i++;
        }
        return arrayList;
    }

    /* renamed from: c */
    public static ArrayList<Map<String, Object>> m294c(int i, int i2) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        String[] stringArray = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_gay_name);
        String[] stringArray2 = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_gay_value);
        while (i <= i2) {
            if (i < stringArray.length && i < stringArray2.length) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", stringArray[i]);
                hashMap.put("value", Integer.valueOf(ApplicationConfig.f7803b.getIdentifier(Uri.parse(stringArray2[i]).getLastPathSegment().split("\\.")[0], "drawable", ApplicationConfig.f7804c)));
                arrayList.add(hashMap);
            }
            i++;
        }
        return arrayList;
    }

    /* renamed from: d */
    public static ArrayList<String> m293d(int i, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] stringArray = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_gay_text);
        while (i <= i2) {
            if (i < stringArray.length) {
                arrayList.add(stringArray[i]);
            }
            i++;
        }
        return arrayList;
    }

    /* renamed from: e */
    public static ArrayList<Map<String, Object>> m292e(int i, int i2) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        String[] stringArray = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_car_name);
        String[] stringArray2 = ApplicationConfig.f7803b.getStringArray(C1473a.C1474a.face_car_value);
        while (i <= i2) {
            if (i < stringArray.length && i < stringArray2.length) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", stringArray[i]);
                hashMap.put("value", Integer.valueOf(ApplicationConfig.f7803b.getIdentifier(Uri.parse(stringArray2[i]).getLastPathSegment().split("\\.")[0], "drawable", ApplicationConfig.f7804c)));
                arrayList.add(hashMap);
            }
            i++;
        }
        return arrayList;
    }

    /* renamed from: f */
    public static ArrayList<Map<String, Object>> m291f(int i, int i2) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        arrayList2.add("add");
        arrayList3.add("add");
        File[] listFiles = new File(Environment.getExternalStorageDirectory() + "/cnlaunch/golo3/" + ApplicationConfig.m9181a() + "/customface/").listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                arrayList3.add(file.getAbsolutePath());
                arrayList2.add(file.getName());
            }
        }
        while (i <= i2) {
            if (i < arrayList2.size() && i < arrayList3.size()) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", arrayList2.get(i));
                hashMap.put("value", arrayList3.get(i));
                arrayList.add(hashMap);
            }
            i++;
        }
        return arrayList;
    }
}
