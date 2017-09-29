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
    private static User loginUser = null;

    private static final String prefName = "DeveloperTest";

    private static final String ID = "ID";
    private static final String USER_ID = "USER_ID";
    private static final String USER_NAME = "USER_NAME";

    public static void login(Context context, User loginUser) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(ID, loginUser.getId()).commit();
        pref.edit().putString(USER_ID, loginUser.getUserId()).commit();
        pref.edit().putString(USER_NAME, loginUser.getName()).commit();

    }

    public static User getLoginUser(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        if (pref.getString(USER_ID, "").equals("")) {
//            로그인이 안된 상태
            loginUser = null;
        } else {
            loginUser = new User();
            loginUser.setId(pref.getInt(ID, 0));
            loginUser.setUserId(pref.getString(USER_ID, ""));
            loginUser.setName(pref.getString(USER_NAME, ""));
        }


        return loginUser;
    }
}