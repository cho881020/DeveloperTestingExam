package kr.co.tjeit.developertestingexam.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by the on 2017-09-29.
 */

public class User implements Serializable {
    private int id;
    private String userId;
    private String userName;


    public static User getUserFromJsonObject(JSONObject json) {
        User tempUser = new User();
        try {
            tempUser.setId(json.getInt("id"));
            tempUser.setUserId(json.getString("user_id"));
            tempUser.setUserName(json.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return tempUser;

    }

    public User() {
    }

    public User(int id, String userId, String userName) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
