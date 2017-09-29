package kr.co.tjeit.developertestingexam.data;

import java.io.Serializable;

/**
 * Created by the on 2017-09-29.
 */

public class User implements Serializable {
    private int id;
    private String userId;
    private String name;

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
