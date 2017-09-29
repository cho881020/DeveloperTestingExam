package kr.co.tjeit.developertestingexam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by the on 2017-09-29.
 */

public abstract class BaseActivicy extends AppCompatActivity {

    Context mContext = this;

    public abstract void bindViews();
    public abstract void setupEvents();
    public abstract void setValues();
}
