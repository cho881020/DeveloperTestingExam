package kr.co.tjeit.developertestingexam.util;

import android.content.Context;
import android.content.SharedPreferences;
import kr.co.tjeit.developertestingexam.data.User;

public class ContextUtil {

    private static final String prefName = "testPref";


    private static final String USER_ID = "USER_ID"; // 디비에서 활용할 숫자 ID
    private static final String USER_INPUT_ID = "USER_INPUT_ID"; // 로그인할때 입력하는 아이디



//    1. 로그인 (결과를 저장하는) 기능
//     => 어떤 사람이 로그인 했는지 앱의 메모장에 기록 (Return : void)

    public static void login(Context context, User user) {

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(USER_ID, user.getId()).apply();
        pref.edit().putString(USER_INPUT_ID, user.getUserId()).apply();

    }



    public static void logout(Context context) {

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(USER_ID, 0).apply();
        pref.edit().putString(USER_INPUT_ID, "").apply();

    }


    public static User getLoginUserInfo(Context context) {
        User loginUser = new User();

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);


        if (pref.getInt(USER_ID, 0) >= 1) {
//            사용자의 숫자 아이디가 1이상이므로, 로그인이 되어있다고 판단.

            loginUser.setId(pref.getInt(USER_ID, 0));
            loginUser.setUserId(pref.getString(USER_INPUT_ID, ""));


        }
        else {

            loginUser = null;
        }

        return loginUser;
    }


}
