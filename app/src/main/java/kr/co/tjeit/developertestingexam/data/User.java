package kr.co.tjeit.developertestingexam.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by user on 2017-09-18.
 */

public class User implements Serializable {

    private int id;
    private String userId;


    public static User getUserFromJson(JSONObject jsonObject) {
        User tempUser = new User();
        try {
            tempUser.setId(jsonObject.getInt("id"));
            tempUser.setUserId(jsonObject.getString("user_id"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tempUser;
    }


    public User() {

    }

    public User(int id, String userId, String name, Calendar birthDay, int gender, String profileURL, String phoneNum) {
        this.id = id;
        this.userId = userId;
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
}

