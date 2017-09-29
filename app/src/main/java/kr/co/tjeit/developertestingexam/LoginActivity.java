package kr.co.tjeit.developertestingexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.developertestingexam.Util.ServerUtil;

public class LoginActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button signUpBtn;
    private android.widget.Button idpwFindBtn;
    private android.widget.Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 아이디/비밀번호 입력칸이 빈칸인지 아닌지 판별코드
                boolean check_id = !idEdt.getText().toString().equals("");
                if (!check_id){
                    Toast.makeText(mContext, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                boolean check_pw = !pwEdt.getText().toString().equals("");
                if (!check_pw){
                    Toast.makeText(mContext, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                }

                // 아이디와 비밀번호가 빈칸이 아닐시 서버로그인 시도
                if (check_id && check_pw){
                    ServerUtil.sign_in(mContext, idEdt.getText().toString(), pwEdt.getText().toString(),
                            new ServerUtil.JsonResponseHandler() {
                                @Override
                                public void onResponse(JSONObject json) {
                                    try {
                                        // 로그인시도 결과가 true일경우 로그인성공 Toast를 띄우고 MainActiity로 이동
                                        if (json.getBoolean("result")){
                                            Toast.makeText(mContext, "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                            Intent myIntent = new Intent(mContext, MainActivity.class);
                                            startActivity(myIntent);
                                        }else {
                                            // 아닐경우 아이디와 비밀번호를 확인해달라는 Toast를 띄움
                                            Toast.makeText(mContext, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            });
                }
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.idpwFindBtn = (Button) findViewById(R.id.idpwFindBtn);
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);

    }
}
