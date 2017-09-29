package kr.co.tjeit.developertestingexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.developertestingexam.data.User;
import kr.co.tjeit.developertestingexam.util.ContextUtil;
import kr.co.tjeit.developertestingexam.util.ServerUtil;

public class MainActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button loginBtn;
    private android.widget.TextView signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (idEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                ServerUtil.sign_in(mContext, idEdt.getText().toString(), pwEdt.getText().toString(),
                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
//                      서버에서 로그인 성공 응답이 온다면 다음화면 진행
//                        실패 응답이 온다면 안내 메세지를 토스트로.
//                        => 상황판단을 하고 구별된행동을 하면 1번 요구사항(테스팅항목) 마무리.

                                try {
                                    if (json.getBoolean("result")) {
                                        JSONObject user = json.getJSONObject("user");
                                        Toast.makeText(mContext, user.getString("name") + "님이 로그인 했습니다.", Toast.LENGTH_SHORT).show();
                                        ContextUtil.login(mContext, new User(user.getInt("id"), user.getString("user_id"),
                                                user.getString("name"), user.getString("birth_day"), user.getString("phone_num"), user.getInt("gender"), user.getString("profile_photo")));
                                    } else {
                                        Toast.makeText(mContext, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
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
        this.signupBtn = (TextView) findViewById(R.id.signupBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
