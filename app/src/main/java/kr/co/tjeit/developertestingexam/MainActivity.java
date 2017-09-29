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

    private EditText idEdt;
    private EditText pwEdt;
    private Button loginBtn;
    private TextView signupBtn;

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
                ServerUtil.sign_in(mContext, idEdt.getText().toString(),
                        pwEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
//                      서버에서 로그인 성공 응답이 온다면 다음화면 진행
//                        실패 응답이 온다면 안내 메세지를 토스트로.
//                        => 상황판단을 하고 구별된행동을 하면 1번 요구사항(테스팅항목) 마무리.

                                try {
                                    if (json.getBoolean("result")) {

                                        User loginUser = User.getUserFromJson(json.getJSONObject("user"));

                                        Toast.makeText(mContext, "로그인한사람 :" + loginUser.getName(), Toast.LENGTH_SHORT).show();
                                        ContextUtil.login(mContext, loginUser);

                                        Intent intent = new Intent(mContext, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(mContext, "로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
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
