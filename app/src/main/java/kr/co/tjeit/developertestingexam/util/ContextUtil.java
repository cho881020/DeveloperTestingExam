package kr.co.tjeit.developertestingexam.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import kr.co.tjeit.developertestingexam.data.User;

/**
 * Created by user on 2017-09-21.
 */

public class ContextUtil {

    private static final String prefName = "DeveloperTestingExampref";

//    1. 로그인
//    2. 로그아웃
//    3. 현재 로그인한 사람의 정보 추출
//     => 1) 로그인 상태 : 정보 (User) 리턴.  2) 비 로그인상태 : null

    private static final String USER_ID = "USER_ID"; // 디비에서 활용할 숫자 ID
    private static final String USER_INPUT_ID = "USER_INPUT_ID"; // 로그인할때 입력하는 아이디
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_BIRTHDAY = "USER_BIRTHDAY";
    private static final String USER_GENDER = "USER_GENDER";
    private static final String USER_PROFILE_URL = "USER_PROFILE_URL";
    private static final String USER_PHONENUM = "USER_PHONENUM";


//    1. 로그인 (결과를 저장하는) 기능
//     => 어떤 사람이 로그인 했는지 앱의 메모장에 기록 (Return : void)

    public static void login(Context context, User user) {

//        MODE_PRIVATE : 내 앱에서만 사용하는 모드.
//        Ex. 만약 Facebook 로그인기능처럼, 다른 앱에다 현재 로그인한 사람을 알려줘야한다면
//        => 그래도 MODE_PRIVATE. 예전버전에는 OPEN기능 있었음. 현재는 Deprecated. (폐기됨)
//        내 자료를 공유하고자 할때 사용하는 기능 : 컨텐트 프로바이더.

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

//        commit : 구버젼. 명령을 날리는 즉시 SAVE
//        apply : 신버젼. 명령을 날리면 백그라운드로 SAVE (딜레이)
//         => 커밋의 경우 앱의 성능에 영향을 미침. 대신, 100% 세이브 보장.
//         => Apply는 메인쓰레드를 사용하지 않음. 간혹 먹히지 않는 기계 / 버젼 / 경우.

        pref.edit().putInt(USER_ID, user.getId()).apply();
        pref.edit().putString(USER_INPUT_ID, user.getUserId()).apply();
        pref.edit().putString(USER_NAME, user.getName()).apply();
//        생년월일 따로 설명.

//        날짜를 지정된 양식의 String으로 변환해서 저장.

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String birthDaySaveString = sdf.format(user.getBirthDay().getTime());
        pref.edit().putString(USER_BIRTHDAY, birthDaySaveString).apply();

        pref.edit().putInt(USER_GENDER, user.getGender()).apply();
        pref.edit().putString(USER_PROFILE_URL, user.getProfileURL()).apply();
        pref.edit().putString(USER_PHONENUM, user.getPhoneNum()).apply();



    }

//    로그인한 사용자를 저장하는 기능 마물.

//    2. 로그아웃

    public static void logout(Context context) {

//        아무도 로그인하지 않으면 기본으로 가져오는 데이터로 값을 지정.

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);


        pref.edit().putInt(USER_ID, 0).apply();
        pref.edit().putString(USER_INPUT_ID, "").apply();
        pref.edit().putString(USER_NAME, "").apply();
        pref.edit().putString(USER_BIRTHDAY, "").apply();
        pref.edit().putInt(USER_GENDER, 0).apply();
        pref.edit().putString(USER_PROFILE_URL, "").apply();
        pref.edit().putString(USER_PHONENUM, "").apply();

    }

//    3. 현재 로그인한 사람의 정보

//      1. 사용자가 로그인한 상태 : loginUser 객체에 데이터 첨부
//      2. 비로그인상태 : loginUser => null

    public static User getLoginUserInfo(Context context) {
        User loginUser = new User();

//        로그인한 사람의 정보를 가공

//        로그인을 했는지 / 안했는지 판단 근거?
//        메모장에 저장된 사용자의 숫자 아이디가 1이상인가?
//         => 비로그인상태에서는 숫자 아이디를 0으로 저장.

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);


        if (pref.getInt(USER_ID, 0) >= 1) {
//            사용자의 숫자 아이디가 1이상이므로, 로그인이 되어있다고 판단.

            loginUser.setId(pref.getInt(USER_ID, 0));
            loginUser.setUserId(pref.getString(USER_INPUT_ID, ""));
            loginUser.setName(pref.getString(USER_NAME, ""));


//            가져올수있는데이터:String -> Calendar : SimpleDateFormat

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
            Calendar birthDay = Calendar.getInstance();

            try {
                Date birthDayDate = sdf.parse(pref.getString(USER_BIRTHDAY, ""));
                birthDay.setTime(birthDayDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            loginUser.setBirthDay(birthDay);

            loginUser.setGender(pref.getInt(USER_GENDER, 0));
            loginUser.setProfileURL(pref.getString(USER_PROFILE_URL, ""));
            loginUser.setPhoneNum(pref.getString(USER_PHONENUM, ""));

        }
        else {
//            사용자 숫자 아이디가 0이거나 그보다 작으므로, 로그아웃 상태라고 판단.
//            로그아웃일 경우 : 사용자 정보에 null
            loginUser = null;
        }


        return loginUser;
    }



}
