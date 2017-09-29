package kr.co.tjeit.developertestingexam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                if (idEdt.getText().toString().equals("")&&pwEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "아이디와 페스워드를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(mContext, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
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
