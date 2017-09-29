package kr.co.tjeit.developertestingexam;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by joeun on 2017-09-29.
 */

public class User implements Serializable {

    private int id;
    private String userId;
    private String name;

    public static User getUserFromJson(JSONObject jsonObject) {
        User tempUser = new User();
        try {
            tempUser.setId(jsonObject.getInt("id"));
            tempUser.setUserId(jsonObject.getString("user_id"));
            tempUser.setName(jsonObject.getString("name"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tempUser;
    }

    public User() {

    }

    public User(int id, String userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
