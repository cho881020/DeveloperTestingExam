package kr.co.tjeit.developertestingexam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class LoginActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button loginBtn;
    private android.widget.ImageView facebookLogin;
    private android.widget.ImageView kakaoLogin;
    private android.widget.ImageView LineLogin;
    private android.widget.TextView signupBtn;
    private ImageView mainImage;
    private TextView sinInWithTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signupBtn = (TextView) findViewById(R.id.signupBtn);
        this.LineLogin = (ImageView) findViewById(R.id.LineLogin);
        this.kakaoLogin = (ImageView) findViewById(R.id.kakaoLogin);
        this.facebookLogin = (ImageView) findViewById(R.id.facebookLogin);
        this.sinInWithTxt = (TextView) findViewById(R.id.sinInWithTxt);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.mainImage = (ImageView) findViewById(R.id.mainImage);


    }
}


