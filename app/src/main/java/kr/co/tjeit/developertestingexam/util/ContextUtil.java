package kr.co.tjeit.developertestingexam.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import kr.co.tjeit.developertestingexam.User;

/**
 * Created by user on 2017-09-21.
 */

public class ContextUtil {

    private static final String prefName = "RestaurantPref";

    private static final String USER_ID = "USER_ID"; // 디비에서 활용할 숫자 ID
    private static final String USER_INPUT_ID = "USER_INPUT_ID"; // 로그인할때 입력하는 아이디
    private static final String USER_NAME = "USER_NAME";

    public static void login(Context context, User user) {

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(USER_ID, user.getId()).apply();
        pref.edit().putString(USER_INPUT_ID, user.getUserId()).apply();
        pref.edit().putString(USER_NAME, user.getName()).apply();

    }

    public static void logout(Context context) {

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);


        pref.edit().putInt(USER_ID, 0).apply();
        pref.edit().putString(USER_INPUT_ID, "").apply();
        pref.edit().putString(USER_NAME, "").apply();

    }

    public static User getLoginUserInfo(Context context) {
        User loginUser = new User();

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);


        if (pref.getInt(USER_ID, 0) >= 1) {

            loginUser.setId(pref.getInt(USER_ID, 0));
            loginUser.setUserId(pref.getString(USER_INPUT_ID, ""));
            loginUser.setName(pref.getString(USER_NAME, ""));
        }
        else {
            loginUser = null;
        }


        return loginUser;
    }
}
