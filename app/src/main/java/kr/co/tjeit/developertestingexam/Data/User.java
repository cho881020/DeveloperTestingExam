package kr.co.tjeit.developertestingexam.Data;

/**
 * Created by the on 2017-09-29.
 */

public class User {

    private int id; // 서버용 id
    private String user_id; // 사용자 아이디
    private String user_pw; // 사용자 비밀번호
    private String user_name; // 사용자 이름
    private String user_Phone; // 사용자 비밀번호

    public User() {
    }

    public User(int id, String user_id, String user_pw, String user_name, String user_Phone) {
        this.id = id;
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.user_Phone = user_Phone;
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

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }
}
