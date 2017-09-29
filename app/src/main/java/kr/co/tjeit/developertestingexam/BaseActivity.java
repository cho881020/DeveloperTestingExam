package kr.co.tjeit.developertestingexam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tjoeun on 2017-09-29.
 */

public abstract class BaseActivity extends AppCompatActivity {
    Context mContext = this;
    public abstract void setupEvents();
    public abstract void setupValues();
    public abstract void bindViews();

}
