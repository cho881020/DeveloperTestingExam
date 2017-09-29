package kr.co.tjeit.developertestingexam.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-09-18.
 */

public class User implements Serializable {
    int id;
    String user_id;
    String name;
    String birthDay;
    String phoneNum;
    int gender;
    String profileURL;

    public User() {
    }

    public User(int id, String user_id, String name, String birthDay, String phoneNum, int gender, String profileURL) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.birthDay = birthDay;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.profileURL = profileURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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

}
