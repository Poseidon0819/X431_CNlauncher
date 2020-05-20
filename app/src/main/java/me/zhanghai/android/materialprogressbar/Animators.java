package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import com.itextpdf.text.pdf.ColumnText;
import me.zhanghai.android.materialprogressbar.Interpolators;
import me.zhanghai.android.materialprogressbar.internal.ObjectAnimatorCompat;

/* loaded from: classes2.dex */
class Animators {
    private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X;
    private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X;
    private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X;
    private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X;

    private Animators() {
    }

    static {
        Path path = new Path();
        PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X = path;
        path.moveTo(-522.6f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.rCubicTo(48.89972f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 166.02657f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 301.2173f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.rCubicTo(197.58128f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 420.9827f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 420.9827f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        Path path2 = new Path();
        PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X = path2;
        path2.moveTo(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.1f);
        PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.lineTo(1.0f, 0.8268492f);
        PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.lineTo(2.0f, 0.1f);
        Path path3 = new Path();
        PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X = path3;
        path3.moveTo(-197.6f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.rCubicTo(14.28182f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 85.07782f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 135.54689f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.rCubicTo(54.26191f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 90.42461f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 168.24332f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.rCubicTo(144.72154f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 316.40982f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 316.40982f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        Path path4 = new Path();
        PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X = path4;
        path4.moveTo(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.1f);
        PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.lineTo(1.0f, 0.5713795f);
        PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.lineTo(2.0f, 0.90995026f);
        PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.lineTo(3.0f, 0.1f);
    }

    public static Animator createIndeterminateHorizontalRect1(Object obj) {
        ObjectAnimator ofFloat = ObjectAnimatorCompat.ofFloat(obj, "translateX", (String) null, PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X);
        ofFloat.setDuration(2000L);
        ofFloat.setInterpolator(Interpolators.INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.INSTANCE);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimatorCompat.ofFloat(obj, (String) null, "scaleX", PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X);
        ofFloat2.setDuration(2000L);
        ofFloat2.setInterpolator(Interpolators.INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.INSTANCE);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public static Animator createIndeterminateHorizontalRect2(Object obj) {
        ObjectAnimator ofFloat = ObjectAnimatorCompat.ofFloat(obj, "translateX", (String) null, PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X);
        ofFloat.setDuration(2000L);
        ofFloat.setInterpolator(Interpolators.INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.INSTANCE);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimatorCompat.ofFloat(obj, (String) null, "scaleX", PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X);
        ofFloat2.setDuration(2000L);
        ofFloat2.setInterpolator(Interpolators.INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.INSTANCE);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public static Animator createIndeterminate(Object obj) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(obj, "trimPathStart", ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.75f);
        ofFloat.setDuration(1333L);
        ofFloat.setInterpolator(Interpolators.TRIM_PATH_START.INSTANCE);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(obj, "trimPathEnd", ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.75f);
        ofFloat2.setDuration(1333L);
        ofFloat2.setInterpolator(Interpolators.TRIM_PATH_END.INSTANCE);
        ofFloat2.setRepeatCount(-1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(obj, "trimPathOffset", ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.25f);
        ofFloat3.setDuration(1333L);
        ofFloat3.setInterpolator(Interpolators.LINEAR.INSTANCE);
        ofFloat3.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    public static Animator createIndeterminateRotation(Object obj) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(obj, "rotation", ColumnText.GLOBAL_SPACE_CHAR_RATIO, 720.0f);
        ofFloat.setDuration(6665L);
        ofFloat.setInterpolator(Interpolators.LINEAR.INSTANCE);
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }
}
