package com.mopub.common.event;

import com.mopub.common.event.BaseEvent;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes.dex */
public class ErrorEvent extends BaseEvent {

    /* renamed from: a */
    private final String f20178a;

    /* renamed from: b */
    private final String f20179b;

    /* renamed from: c */
    private final String f20180c;

    /* renamed from: d */
    private final String f20181d;

    /* renamed from: e */
    private final String f20182e;

    /* renamed from: f */
    private final String f20183f;

    /* renamed from: g */
    private final Integer f20184g;

    /* synthetic */ ErrorEvent(Builder builder, byte b) {
        this(builder);
    }

    private ErrorEvent(Builder builder) {
        super(builder);
        this.f20178a = builder.f20185a;
        this.f20179b = builder.f20186b;
        this.f20180c = builder.f20187c;
        this.f20181d = builder.f20188d;
        this.f20182e = builder.f20189e;
        this.f20183f = builder.f20190f;
        this.f20184g = builder.f20191g;
    }

    public String getErrorExceptionClassName() {
        return this.f20178a;
    }

    public String getErrorMessage() {
        return this.f20179b;
    }

    public String getErrorStackTrace() {
        return this.f20180c;
    }

    public String getErrorFileName() {
        return this.f20181d;
    }

    public String getErrorClassName() {
        return this.f20182e;
    }

    public String getErrorMethodName() {
        return this.f20183f;
    }

    public Integer getErrorLineNumber() {
        return this.f20184g;
    }

    @Override // com.mopub.common.event.BaseEvent
    public String toString() {
        String baseEvent = super.toString();
        return baseEvent + "ErrorEvent\nErrorExceptionClassName: " + getErrorExceptionClassName() + "\nErrorMessage: " + getErrorMessage() + "\nErrorStackTrace: " + getErrorStackTrace() + "\nErrorFileName: " + getErrorFileName() + "\nErrorClassName: " + getErrorClassName() + "\nErrorMethodName: " + getErrorMethodName() + "\nErrorLineNumber: " + getErrorLineNumber() + "\n";
    }

    /* loaded from: classes.dex */
    public static class Builder extends BaseEvent.Builder {

        /* renamed from: a */
        private String f20185a;

        /* renamed from: b */
        private String f20186b;

        /* renamed from: c */
        private String f20187c;

        /* renamed from: d */
        private String f20188d;

        /* renamed from: e */
        private String f20189e;

        /* renamed from: f */
        private String f20190f;

        /* renamed from: g */
        private Integer f20191g;

        public Builder(BaseEvent.Name name, BaseEvent.Category category, double d) {
            super(BaseEvent.ScribeCategory.EXCHANGE_CLIENT_ERROR, name, category, d);
        }

        public Builder withErrorExceptionClassName(String str) {
            this.f20185a = str;
            return this;
        }

        public Builder withErrorMessage(String str) {
            this.f20186b = str;
            return this;
        }

        public Builder withErrorStackTrace(String str) {
            this.f20187c = str;
            return this;
        }

        public Builder withErrorFileName(String str) {
            this.f20188d = str;
            return this;
        }

        public Builder withErrorClassName(String str) {
            this.f20189e = str;
            return this;
        }

        public Builder withErrorMethodName(String str) {
            this.f20190f = str;
            return this;
        }

        public Builder withErrorLineNumber(Integer num) {
            this.f20191g = num;
            return this;
        }

        public Builder withException(Exception exc) {
            this.f20185a = exc.getClass().getName();
            this.f20186b = exc.getMessage();
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            this.f20187c = stringWriter.toString();
            if (exc.getStackTrace().length > 0) {
                this.f20188d = exc.getStackTrace()[0].getFileName();
                this.f20189e = exc.getStackTrace()[0].getClassName();
                this.f20190f = exc.getStackTrace()[0].getMethodName();
                this.f20191g = Integer.valueOf(exc.getStackTrace()[0].getLineNumber());
            }
            return this;
        }

        @Override // com.mopub.common.event.BaseEvent.Builder
        public ErrorEvent build() {
            return new ErrorEvent(this, (byte) 0);
        }
    }
}
