package kr.co.tjeit.developertestingexam.util;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by KJ_Studio on 2015-12-24.
 */
public class ServerUtil {

//    서버와 통신을 하기 위한 ip주소
    private final static String BASE_URL = "http://13.124.238.13/";

    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }



    public static void sign_in(final Context context, final String id, final String pw, final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/sign_in";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("user_id", id); // 사용자가 입력하는 아이디. (cho881020)
        data.put("password", pw);

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


    public static void getAllStores(final Context context, final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/getAllStores";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
//        data.put("user_id", id); // 사용자가 입력하는 아이디. (cho881020)
//        data.put("password", pw);

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


    public static void getStoreInfo(final Context context, final int storeId, final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/getStoreInfo";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("store_id", storeId+""); // 사용자가 입력하는 아이디. (cho881020)
//        data.put("password", pw);

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


    public static void checkDuplId(final Context context, final String id, final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/checkDuplId";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("user_id", id);

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


//    서버에 주문 넣기.

    public static void makeOrder(final Context context, final int user_id, final int store_id, final int seat_id, final String orderJson, final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/makeOrder";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("user_id", user_id+"");
        data.put("store_id", store_id+"");
        data.put("seat_id", seat_id+"");
        data.put("orderJson", orderJson);

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


//    내 주문 목록 가져오기.

    public static void getMyOrders(final Context context, final int user_id, final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/getMyOrders";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("user_id", user_id+"");

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
