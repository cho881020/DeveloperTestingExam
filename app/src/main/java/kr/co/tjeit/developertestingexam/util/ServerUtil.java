package kr.co.tjeit.developertestingexam.util;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import kr.co.tjeit.developertestingexam.util.AsyncHttpRequest;

/**
 * Created by the on 2017-09-29.
 */

public class ServerUtil {

    private final static String BASE_URL = "http://13.124.238.13/";

    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }

    public static void sign_in(final Context context, final String id, final String pw, final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/sign_in";

        Map<String, String> data = new HashMap<String, String>();
        data.put("user_id", id);
        data.put("password", pw);
        data.put("os", "Android");

        AsyncHttpRequest.post(context, url,  data, false, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                Log.i("RESPONSE", response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }
}
