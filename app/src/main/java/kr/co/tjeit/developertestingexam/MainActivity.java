package kr.co.tjeit.developertestingexam;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import kr.co.tjeit.developertestingexam.data.User;
import kr.co.tjeit.developertestingexam.util.ServerUtil;

public class MainActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    public static User getUserFromJsonObject(JSONObject json) {
//        매번 파싱하기 매우 귀찮다.
        final User tempUser = new User();
//        json을 파싱해서, tempUser의 내용물로 채워주기.
        try {
            tempUser.setId(json.getInt("id"));
            tempUser.setUserId(json.getString("user_id"));
            tempUser.setUserName(json.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tempUser;

    }

    @Override
    public void setupEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServerUtil.sign_in(mContext, idEdt.getText().toString(), pwEdt.getText().toString(),
                        new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (json.getBoolean("result")) {
                                User loginuser = User.getUserFromJsonObject(json.getJSONObject("user"));
                                String loginSuccess = String.format(Locale.KOREA, "%s님이 로그인 했습니다.", loginuser.getUserName());
                                Toast.makeText(mContext, loginSuccess, Toast.LENGTH_SHORT).show();
                            }
                            else {
                                String loginFailed = String.format(Locale.KOREA, "로그인에 실패했습니다. 아이디와 비밀번호를 확인해 주세요.");
                                Toast.makeText(mContext, loginFailed, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
