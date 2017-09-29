package kr.co.tjeit.developertestingexam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
