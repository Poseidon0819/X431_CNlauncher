package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/* loaded from: classes2.dex */
public class ISO8601GregorianCalendarConverter extends AbstractSingleValueConverter {
    private static final DateTimeFormatter[] formattersUTC = {ISODateTimeFormat.dateTime(), ISODateTimeFormat.dateTimeNoMillis(), ISODateTimeFormat.basicDateTime(), ISODateTimeFormat.basicOrdinalDateTime(), ISODateTimeFormat.basicOrdinalDateTimeNoMillis(), ISODateTimeFormat.basicTime(), ISODateTimeFormat.basicTimeNoMillis(), ISODateTimeFormat.basicTTime(), ISODateTimeFormat.basicTTimeNoMillis(), ISODateTimeFormat.basicWeekDateTime(), ISODateTimeFormat.basicWeekDateTimeNoMillis(), ISODateTimeFormat.ordinalDateTime(), ISODateTimeFormat.ordinalDateTimeNoMillis(), ISODateTimeFormat.time(), ISODateTimeFormat.timeNoMillis(), ISODateTimeFormat.tTime(), ISODateTimeFormat.tTimeNoMillis(), ISODateTimeFormat.weekDateTime(), ISODateTimeFormat.weekDateTimeNoMillis()};
    private static final DateTimeFormatter[] formattersNoUTC = {ISODateTimeFormat.basicDate(), ISODateTimeFormat.basicOrdinalDate(), ISODateTimeFormat.basicWeekDate(), ISODateTimeFormat.date(), ISODateTimeFormat.dateHour(), ISODateTimeFormat.dateHourMinute(), ISODateTimeFormat.dateHourMinuteSecond(), ISODateTimeFormat.dateHourMinuteSecondFraction(), ISODateTimeFormat.dateHourMinuteSecondMillis(), ISODateTimeFormat.hour(), ISODateTimeFormat.hourMinute(), ISODateTimeFormat.hourMinuteSecond(), ISODateTimeFormat.hourMinuteSecondFraction(), ISODateTimeFormat.hourMinuteSecondMillis(), ISODateTimeFormat.ordinalDate(), ISODateTimeFormat.weekDate(), ISODateTimeFormat.year(), ISODateTimeFormat.yearMonth(), ISODateTimeFormat.yearMonthDay(), ISODateTimeFormat.weekyear(), ISODateTimeFormat.weekyearWeek(), ISODateTimeFormat.weekyearWeekDay()};

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(GregorianCalendar.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        int i = 0;
        int i2 = 0;
        while (true) {
            DateTimeFormatter[] dateTimeFormatterArr = formattersUTC;
            if (i2 < dateTimeFormatterArr.length) {
                try {
                    GregorianCalendar gregorianCalendar = dateTimeFormatterArr[i2].parseDateTime(str).toGregorianCalendar();
                    gregorianCalendar.setTimeZone(TimeZone.getDefault());
                    return gregorianCalendar;
                } catch (IllegalArgumentException unused) {
                    i2++;
                }
            } else {
                String id = TimeZone.getDefault().getID();
                while (true) {
                    DateTimeFormatter[] dateTimeFormatterArr2 = formattersNoUTC;
                    if (i < dateTimeFormatterArr2.length) {
                        try {
                            GregorianCalendar gregorianCalendar2 = dateTimeFormatterArr2[i].withZone(DateTimeZone.forID(id)).parseDateTime(str).toGregorianCalendar();
                            gregorianCalendar2.setTimeZone(TimeZone.getDefault());
                            return gregorianCalendar2;
                        } catch (IllegalArgumentException unused2) {
                            i++;
                        }
                    } else {
                        throw new ConversionException("Cannot parse date ".concat(String.valueOf(str)));
                    }
                }
            }
        }
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        return new DateTime(obj).toString(formattersUTC[0]);
    }
}
