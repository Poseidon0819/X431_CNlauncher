package com.cnlaunch.x431pro.activity.p217c;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import java.util.List;

/* compiled from: KeyboardUtil.java */
/* renamed from: com.cnlaunch.x431pro.activity.c.d */
/* loaded from: classes.dex */
final class C2007d implements KeyboardView.OnKeyboardActionListener {

    /* renamed from: a */
    final /* synthetic */ KeyboardUtil f11010a;

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onPress(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onRelease(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onText(CharSequence charSequence) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeUp() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2007d(KeyboardUtil keyboardUtil) {
        this.f11010a = keyboardUtil;
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onKey(int i, int[] iArr) {
        Editable text = this.f11010a.f11007e.getText();
        int selectionStart = this.f11010a.f11007e.getSelectionStart();
        if (i == -3) {
            this.f11010a.m7727a();
        } else if (i == -5) {
            if (text == null || text.length() <= 0 || selectionStart <= 0) {
                return;
            }
            text.delete(selectionStart - 1, selectionStart);
        } else if (i == -1) {
            try {
                KeyboardUtil keyboardUtil = this.f11010a;
                List<Keyboard.Key> keys = keyboardUtil.f11004b.getKeys();
                if (keyboardUtil.f11006d) {
                    keyboardUtil.f11006d = false;
                    for (Keyboard.Key key : keys) {
                        if (key.label != null && KeyboardUtil.m7726a(key.label.toString())) {
                            key.label = key.label.toString().toLowerCase();
                            key.codes[0] = key.codes[0] + 32;
                        }
                    }
                } else {
                    keyboardUtil.f11006d = true;
                    for (Keyboard.Key key2 : keys) {
                        if (key2.label != null && KeyboardUtil.m7726a(key2.label.toString())) {
                            key2.label = key2.label.toString().toUpperCase();
                            key2.codes[0] = key2.codes[0] - 32;
                        }
                    }
                }
                this.f11010a.f11003a.setKeyboard(this.f11010a.f11004b);
            } catch (Exception unused) {
            }
        } else if (i == -2) {
            if (this.f11010a.f11005c) {
                KeyboardUtil keyboardUtil2 = this.f11010a;
                keyboardUtil2.f11005c = false;
                keyboardUtil2.f11003a.setKeyboard(this.f11010a.f11004b);
                return;
            }
            this.f11010a.f11005c = true;
        } else if (i != -4) {
            if (i == 57419) {
                if (selectionStart > 0) {
                    this.f11010a.f11007e.setSelection(selectionStart - 1);
                }
            } else if (i == 57421) {
                if (selectionStart < this.f11010a.f11007e.length()) {
                    this.f11010a.f11007e.setSelection(selectionStart + 1);
                }
            } else if (i > 500) {
                try {
                    text.insert(selectionStart, KeyboardUtil.m7725b(String.valueOf(i)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                text.insert(selectionStart, Character.toString((char) i));
            }
        }
    }
}
