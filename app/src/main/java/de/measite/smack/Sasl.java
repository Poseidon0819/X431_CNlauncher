package de.measite.smack;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.apache.harmony.javax.security.sasl.SaslClient;
import org.apache.harmony.javax.security.sasl.SaslException;
import org.apache.harmony.javax.security.sasl.SaslServer;
import org.apache.harmony.javax.security.sasl.SaslServerFactory;

/* loaded from: classes2.dex */
public class Sasl {
    private static final String CLIENTFACTORYSRV = "SaslClientFactory";
    public static final String MAX_BUFFER = "javax.security.sasl.maxbuffer";
    public static final String POLICY_FORWARD_SECRECY = "javax.security.sasl.policy.forward";
    public static final String POLICY_NOACTIVE = "javax.security.sasl.policy.noactive";
    public static final String POLICY_NOANONYMOUS = "javax.security.sasl.policy.noanonymous";
    public static final String POLICY_NODICTIONARY = "javax.security.sasl.policy.nodictionary";
    public static final String POLICY_NOPLAINTEXT = "javax.security.sasl.policy.noplaintext";
    public static final String POLICY_PASS_CREDENTIALS = "javax.security.sasl.policy.credentials";
    public static final String QOP = "javax.security.sasl.qop";
    public static final String RAW_SEND_SIZE = "javax.security.sasl.rawsendsize";
    public static final String REUSE = "javax.security.sasl.reuse";
    private static final String SERVERFACTORYSRV = "SaslServerFactory";
    public static final String SERVER_AUTH = "javax.security.sasl.server.authentication";
    public static final String STRENGTH = "javax.security.sasl.strength";

    public static Enumeration<SaslClientFactory> getSaslClientFactories() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(new SaslClientFactory(), new Object());
        return hashtable.keys();
    }

    public static Enumeration<SaslServerFactory> getSaslServerFactories() {
        return org.apache.harmony.javax.security.sasl.Sasl.getSaslServerFactories();
    }

    public static SaslServer createSaslServer(String str, String str2, String str3, Map<String, ?> map, CallbackHandler callbackHandler) throws SaslException {
        return org.apache.harmony.javax.security.sasl.Sasl.createSaslServer(str, str2, str3, map, callbackHandler);
    }

    public static SaslClient createSaslClient(String[] strArr, String str, String str2, String str3, Map<String, ?> map, CallbackHandler callbackHandler) throws SaslException {
        if (strArr == null) {
            throw new NullPointerException("auth.33");
        }
        SaslClientFactory nextElement = getSaslClientFactories().nextElement();
        String[] mechanismNames = nextElement.getMechanismNames(null);
        boolean z = false;
        if (mechanismNames != null) {
            boolean z2 = false;
            for (String str4 : mechanismNames) {
                int i = 0;
                while (true) {
                    if (i >= strArr.length) {
                        break;
                    } else if (str4.equals(strArr[i])) {
                        z2 = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            z = z2;
        }
        if (z) {
            return nextElement.createSaslClient(strArr, str, str2, str3, map, callbackHandler);
        }
        return null;
    }
}
