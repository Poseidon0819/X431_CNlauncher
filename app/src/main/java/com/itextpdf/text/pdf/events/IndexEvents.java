package com.itextpdf.text.pdf.events;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class IndexEvents extends PdfPageEventHelper {
    private Map<String, Integer> indextag = new TreeMap();
    private long indexcounter = 0;
    private List<Entry> indexentry = new ArrayList();
    private Comparator<Entry> comparator = new Comparator<Entry>() { // from class: com.itextpdf.text.pdf.events.IndexEvents.1
        @Override // java.util.Comparator
        public int compare(Entry entry, Entry entry2) {
            if (entry.getIn1() == null || entry2.getIn1() == null) {
                return 0;
            }
            int compareToIgnoreCase = entry.getIn1().compareToIgnoreCase(entry2.getIn1());
            if (compareToIgnoreCase != 0 || entry.getIn2() == null || entry2.getIn2() == null) {
                return compareToIgnoreCase;
            }
            int compareToIgnoreCase2 = entry.getIn2().compareToIgnoreCase(entry2.getIn2());
            return (compareToIgnoreCase2 != 0 || entry.getIn3() == null || entry2.getIn3() == null) ? compareToIgnoreCase2 : entry.getIn3().compareToIgnoreCase(entry2.getIn3());
        }
    };

    @Override // com.itextpdf.text.pdf.PdfPageEventHelper, com.itextpdf.text.pdf.PdfPageEvent
    public void onGenericTag(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        this.indextag.put(str, Integer.valueOf(pdfWriter.getPageNumber()));
    }

    public Chunk create(String str, String str2, String str3, String str4) {
        Chunk chunk = new Chunk(str);
        StringBuilder sb = new StringBuilder("idx_");
        long j = this.indexcounter;
        this.indexcounter = 1 + j;
        sb.append(j);
        String sb2 = sb.toString();
        chunk.setGenericTag(sb2);
        chunk.setLocalDestination(sb2);
        this.indexentry.add(new Entry(str2, str3, str4, sb2));
        return chunk;
    }

    public Chunk create(String str, String str2) {
        return create(str, str2, "", "");
    }

    public Chunk create(String str, String str2, String str3) {
        return create(str, str2, str3, "");
    }

    public void create(Chunk chunk, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("idx_");
        long j = this.indexcounter;
        this.indexcounter = 1 + j;
        sb.append(j);
        String sb2 = sb.toString();
        chunk.setGenericTag(sb2);
        chunk.setLocalDestination(sb2);
        this.indexentry.add(new Entry(str, str2, str3, sb2));
    }

    public void create(Chunk chunk, String str) {
        create(chunk, str, "", "");
    }

    public void create(Chunk chunk, String str, String str2) {
        create(chunk, str, str2, "");
    }

    public void setComparator(Comparator<Entry> comparator) {
        this.comparator = comparator;
    }

    public List<Entry> getSortedEntries() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < this.indexentry.size(); i++) {
            Entry entry = this.indexentry.get(i);
            String key = entry.getKey();
            Entry entry2 = (Entry) hashMap.get(key);
            if (entry2 != null) {
                entry2.addPageNumberAndTag(entry.getPageNumber(), entry.getTag());
            } else {
                entry.addPageNumberAndTag(entry.getPageNumber(), entry.getTag());
                hashMap.put(key, entry);
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, this.comparator);
        return arrayList;
    }

    /* loaded from: classes.dex */
    public class Entry {
        private String in1;
        private String in2;
        private String in3;
        private String tag;
        private List<Integer> pagenumbers = new ArrayList();
        private List<String> tags = new ArrayList();

        public Entry(String str, String str2, String str3, String str4) {
            this.in1 = str;
            this.in2 = str2;
            this.in3 = str3;
            this.tag = str4;
        }

        public String getIn1() {
            return this.in1;
        }

        public String getIn2() {
            return this.in2;
        }

        public String getIn3() {
            return this.in3;
        }

        public String getTag() {
            return this.tag;
        }

        public int getPageNumber() {
            Integer num = (Integer) IndexEvents.this.indextag.get(this.tag);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }

        public void addPageNumberAndTag(int i, String str) {
            this.pagenumbers.add(Integer.valueOf(i));
            this.tags.add(str);
        }

        public String getKey() {
            return this.in1 + "!" + this.in2 + "!" + this.in3;
        }

        public List<Integer> getPagenumbers() {
            return this.pagenumbers;
        }

        public List<String> getTags() {
            return this.tags;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.in1);
            stringBuffer.append(TokenParser.f24154SP);
            stringBuffer.append(this.in2);
            stringBuffer.append(TokenParser.f24154SP);
            stringBuffer.append(this.in3);
            stringBuffer.append(TokenParser.f24154SP);
            for (int i = 0; i < this.pagenumbers.size(); i++) {
                stringBuffer.append(this.pagenumbers.get(i));
                stringBuffer.append(TokenParser.f24154SP);
            }
            return stringBuffer.toString();
        }
    }
}
