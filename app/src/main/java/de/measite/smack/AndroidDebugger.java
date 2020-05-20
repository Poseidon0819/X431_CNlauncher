package de.measite.smack;

import android.util.Log;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.ObservableReader;
import org.jivesoftware.smack.util.ObservableWriter;
import org.jivesoftware.smack.util.ReaderListener;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.WriterListener;

/* loaded from: classes2.dex */
public class AndroidDebugger implements SmackDebugger {
    public static boolean printInterpreted = false;
    private Connection connection;
    private Reader reader;
    private ReaderListener readerListener;
    private Writer writer;
    private WriterListener writerListener;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("hh:mm:ss aaa");
    private PacketListener listener = null;
    private ConnectionListener connListener = null;

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public PacketListener getWriterListener() {
        return null;
    }

    public AndroidDebugger(Connection connection, Writer writer, Reader reader) {
        this.connection = null;
        this.connection = connection;
        this.writer = writer;
        this.reader = reader;
        createDebug();
    }

    private void createDebug() {
        ObservableReader observableReader = new ObservableReader(this.reader);
        this.readerListener = new ReaderListener() { // from class: de.measite.smack.AndroidDebugger.1
            @Override // org.jivesoftware.smack.util.ReaderListener
            public void read(String str) {
            }
        };
        observableReader.addReaderListener(this.readerListener);
        ObservableWriter observableWriter = new ObservableWriter(this.writer);
        this.writerListener = new WriterListener() { // from class: de.measite.smack.AndroidDebugger.2
            @Override // org.jivesoftware.smack.util.WriterListener
            public void write(String str) {
            }
        };
        observableWriter.addWriterListener(this.writerListener);
        this.reader = observableReader;
        this.writer = observableWriter;
        this.listener = new PacketListener() { // from class: de.measite.smack.AndroidDebugger.3
            @Override // org.jivesoftware.smack.PacketListener
            public void processPacket(Packet packet) {
                if (AndroidDebugger.printInterpreted) {
                    Log.d("SMACK", AndroidDebugger.this.dateFormatter.format(new Date()) + " RCV PKT (" + AndroidDebugger.this.connection.hashCode() + "): " + packet.toXML());
                }
            }
        };
        this.connListener = new ConnectionListener() { // from class: de.measite.smack.AndroidDebugger.4
            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosed() {
                Log.d("SMACK", AndroidDebugger.this.dateFormatter.format(new Date()) + " Connection closed (" + AndroidDebugger.this.connection.hashCode() + ")");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosedOnError(Exception exc) {
                Log.d("SMACK", AndroidDebugger.this.dateFormatter.format(new Date()) + " Connection closed due to an exception (" + AndroidDebugger.this.connection.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectionFailed(Exception exc) {
                Log.d("SMACK", AndroidDebugger.this.dateFormatter.format(new Date()) + " Reconnection failed due to an exception (" + AndroidDebugger.this.connection.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectionSuccessful() {
                Log.d("SMACK", AndroidDebugger.this.dateFormatter.format(new Date()) + " Connection reconnected (" + AndroidDebugger.this.connection.hashCode() + ")");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectingIn(int i) {
                Log.d("SMACK", AndroidDebugger.this.dateFormatter.format(new Date()) + " Connection (" + AndroidDebugger.this.connection.hashCode() + ") will reconnect in " + i);
            }
        };
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public Reader newConnectionReader(Reader reader) {
        ((ObservableReader) this.reader).removeReaderListener(this.readerListener);
        ObservableReader observableReader = new ObservableReader(reader);
        observableReader.addReaderListener(this.readerListener);
        this.reader = observableReader;
        return this.reader;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public Writer newConnectionWriter(Writer writer) {
        ((ObservableWriter) this.writer).removeWriterListener(this.writerListener);
        ObservableWriter observableWriter = new ObservableWriter(writer);
        observableWriter.addWriterListener(this.writerListener);
        this.writer = observableWriter;
        return this.writer;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public void userHasLogged(String str) {
        boolean equals = "".equals(StringUtils.parseName(str));
        StringBuilder sb = new StringBuilder("User logged (");
        sb.append(this.connection.hashCode());
        sb.append("): ");
        sb.append(equals ? "" : StringUtils.parseBareAddress(str));
        sb.append("@");
        sb.append(this.connection.getServiceName());
        sb.append(":");
        sb.append(this.connection.getPort());
        String sb2 = sb.toString();
        Log.d("SMACK", sb2 + "/" + StringUtils.parseResource(str));
        this.connection.addConnectionListener(this.connListener);
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public Reader getReader() {
        return this.reader;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public Writer getWriter() {
        return this.writer;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public PacketListener getReaderListener() {
        return this.listener;
    }
}
