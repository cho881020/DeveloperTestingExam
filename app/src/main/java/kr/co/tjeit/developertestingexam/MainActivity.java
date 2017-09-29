package kr.co.tjeit.developertestingexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                    Toast.makeText(mContext, "아이디를 입력하여주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (pwEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "비밀번호를 입력하여주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                ServerUtil.sign_in(mContext, idEdt.getText().toString(),
                        pwEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {


                                try {
                                    if (json.getBoolean("result")) {
                                        User loginUser = User.getUserFromJson(json.getJSONObject("user"));
                                        ContextUtil.login(mContext, loginUser);
                                        Toast.makeText(mContext, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
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
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
