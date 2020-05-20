package com.mopub.nativeads;

import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import org.jivesoftware.smackx.FormField;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PositioningRequest extends JsonRequest<MoPubNativeAdPositioning.MoPubClientPositioning> {
    @Override // com.mopub.volley.toolbox.JsonRequest, com.mopub.volley.Request
    public /* bridge */ /* synthetic */ void deliverResponse(Object obj) {
        super.deliverResponse((MoPubNativeAdPositioning.MoPubClientPositioning) obj);
    }

    public PositioningRequest(String str, Response.Listener<MoPubNativeAdPositioning.MoPubClientPositioning> listener, Response.ErrorListener errorListener) {
        super(0, str, null, listener, errorListener);
    }

    @Override // com.mopub.volley.toolbox.JsonRequest, com.mopub.volley.Request
    public final Response<MoPubNativeAdPositioning.MoPubClientPositioning> parseNetworkResponse(NetworkResponse networkResponse) {
        if (networkResponse.statusCode != 200) {
            return Response.error(new VolleyError(networkResponse));
        }
        if (networkResponse.data.length == 0) {
            return Response.error(new VolleyError("Empty positioning response", new JSONException("Empty response")));
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers)));
            String optString = jSONObject.optString("error", null);
            if (optString != null) {
                if (optString.equalsIgnoreCase("WARMING_UP")) {
                    throw new MoPubNetworkError(MoPubNetworkError.Reason.WARMING_UP);
                }
                throw new JSONException(optString);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(FormField.TYPE_FIXED);
            JSONObject optJSONObject = jSONObject.optJSONObject("repeating");
            if (optJSONArray == null && optJSONObject == null) {
                throw new JSONException("Must contain fixed or repeating positions");
            }
            MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning = new MoPubNativeAdPositioning.MoPubClientPositioning();
            if (optJSONArray != null) {
                m2104a(optJSONArray, moPubClientPositioning);
            }
            if (optJSONObject != null) {
                int i = optJSONObject.getInt("interval");
                if (i < 2 || i > 65536) {
                    throw new JSONException("Invalid interval " + i + " in JSON response");
                }
                moPubClientPositioning.enableRepeatingPositions(i);
            }
            return Response.success(moPubClientPositioning, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (MoPubNetworkError e) {
            return Response.error(e);
        } catch (UnsupportedEncodingException e2) {
            return Response.error(new VolleyError("Couldn't parse JSON from Charset", e2));
        } catch (JSONException e3) {
            return Response.error(new VolleyError("JSON Parsing Error", e3));
        }
    }

    /* renamed from: a */
    private static void m2104a(JSONArray jSONArray, MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            int optInt = jSONObject.optInt("section", 0);
            if (optInt < 0) {
                throw new JSONException("Invalid section " + optInt + " in JSON response");
            }
            if (optInt <= 0) {
                int i2 = jSONObject.getInt("position");
                if (i2 < 0 || i2 > 65536) {
                    throw new JSONException("Invalid position " + i2 + " in JSON response");
                }
                moPubClientPositioning.addFixedPosition(i2);
            }
        }
    }
}
