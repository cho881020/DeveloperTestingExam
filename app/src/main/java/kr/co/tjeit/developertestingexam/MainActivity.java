package kr.co.tjeit.developertestingexam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.developertestingexam.util.ContextUtil;
import kr.co.tjeit.developertestingexam.util.ServerUtil;

public class MainActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button loginbtn;
    private android.widget.Button signupBtn;

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
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (idEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                if (pwEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }

                ServerUtil.sign_in(mContext, idEdt.getText().toString(), pwEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (json.getBoolean("result")) {
                                JSONObject user = json.getJSONObject("user");

                                Toast.makeText(mContext, user.getString("user_id") + "님이 로그인했습니다.", Toast.LENGTH_SHORT).show();

                                ContextUtil.login(mContext, new User(user.getInt("id"), user.getString("user_id"), user.getString("name")));
                            }
                            else {
                                Toast.makeText(mContext, "로그인에 실패했습니다. 아이디와 페스워드를 입력하세요.", Toast.LENGTH_SHORT).show();
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
        this.signupBtn = (Button) findViewById(R.id.signupBtn);
        this.loginbtn = (Button) findViewById(R.id.loginbtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
