package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import message.p381d.FaceProvider;

/* renamed from: com.cnlaunch.im.widget.InputText */
/* loaded from: classes.dex */
public class InputText extends EditText {

    /* renamed from: a */
    private InterfaceC1761a f9399a;

    /* renamed from: b */
    private ClipboardManager f9400b;

    /* renamed from: com.cnlaunch.im.widget.InputText$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1761a {
    }

    public InputText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClipboardManager getClipboard() {
        if (this.f9400b == null) {
            this.f9400b = (ClipboardManager) getContext().getSystemService("clipboard");
        }
        return this.f9400b;
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i == 16908322) {
            super.onTextContextMenuItem(i);
            Editable editableText = getEditableText();
            if (editableText != null) {
                int selectionStart = getSelectionStart();
                setText(FaceProvider.m296a(getContext(), editableText.toString(), getTextSize()));
                setSelection(selectionStart);
                return true;
            }
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new C1762b(super.onCreateInputConnection(editorInfo));
    }

    /* renamed from: com.cnlaunch.im.widget.InputText$b */
    /* loaded from: classes.dex */
    class C1762b extends InputConnectionWrapper {
        public C1762b(InputConnection inputConnection) {
            super(inputConnection, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67 && InputText.this.f9399a != null) {
                InterfaceC1761a unused = InputText.this.f9399a;
                return true;
            }
            return super.sendKeyEvent(keyEvent);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int i, int i2) {
            if (i == 1 && i2 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
            return super.deleteSurroundingText(i, i2);
        }
    }

    public void setDelKeyEventListener(InterfaceC1761a interfaceC1761a) {
        this.f9399a = interfaceC1761a;
    }
}
