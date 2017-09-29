package kr.co.tjeit.developertestingexam.data;

import java.io.Serializable;

/**
 * Created by the on 2017-09-29.
 */

public class User implements Serializable {
    private int id;
    private String userId;
    private String userName;

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
