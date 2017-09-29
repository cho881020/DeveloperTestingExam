package kr.co.tjeit.developertestingexam.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by the on 2017-09-29.
 */
public class User implements Serializable {

    private int id; // 디비에서 날아오는 Primary Key ID
    private String userId; // 사용자가 로그인하려고 타이핑하는 아이디.
    private String name;
    private Calendar birthDay;
    private int gender;
    private String profileURL;
    private String phoneNum;


    //    사용자 객체를 파싱하는 일이 잦으므로 데이터클래스 내부에 static메쏘드를 이용하여 모듈화함.
    public static User getUserFromJson(JSONObject jsonObject) {
        User tempUser = new User();
        try {
            tempUser.setId(jsonObject.getInt("id"));
            tempUser.setUserId(jsonObject.getString("user_id"));
            tempUser.setName(jsonObject.getString("name"));
            tempUser.setProfileURL(jsonObject.getString("profile_photo"));

//          JSON에서 생일을 날려주는건 String. => JAVA에서 저장 : Calendar
//            String => Calendar 변환 : SimpleDateFormat

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Calendar => String 변환 : format
//            String => Calendar 변환 : parse
            Calendar userBirthDay = Calendar.getInstance();
            userBirthDay.setTime(sdf.parse(jsonObject.getString("birth_day")));

            tempUser.setBirthDay(userBirthDay);
            tempUser.setGender(jsonObject.getInt("gender"));
            tempUser.setPhoneNum(jsonObject.getString("phone_num"));

//            비밀번호는 절대 로컬에 저장하지 않음.
//            2가지 정보 무시 : OS, DeviceToken
//            상기한 2가지 정보는, 굳이 파싱할 필요 없이 로컬에서 획득 가능한 정보.
//            OS : 무조건 "Android"
//            DeviceToken : 폰에서 구글서버에 요청해서 받아온 자료 => 자체서버에 전송.

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return tempUser;
    }


    public User() {

    }

    public User(int id, String userId, String name, Calendar birthDay, int gender, String profileURL, String phoneNum) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.profileURL = profileURL;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Calendar birthDay) {
        this.birthDay = birthDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
