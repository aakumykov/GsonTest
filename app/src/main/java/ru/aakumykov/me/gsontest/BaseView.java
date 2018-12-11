package ru.aakumykov.me.gsontest;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ru.aakumykov.me.gsontest.utils.MyUtils;

@SuppressLint("Registered")
public class BaseView extends AppCompatActivity implements iBaseView {

    private final static String TAG = "BaseView";


    @Override
    public void setPageTitle(int titleId) {
        String title = getResources().getString(titleId);
        setPageTitle(title);
    }

    @Override
    public void setPageTitle(String title) {
        String fullTitle = getString(R.string.fullTitle, title);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar)
            actionBar.setTitle(fullTitle);
    }

}
