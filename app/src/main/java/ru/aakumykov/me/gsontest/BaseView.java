package ru.aakumykov.me.gsontest;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ru.aakumykov.me.gsontest.utils.MyUtils;

public class BaseView extends AppCompatActivity {

    private final static String TAG = "BaseView";


    public void showProgressMessage(int messageId) {
        String message = getResources().getString(messageId);

        TextView messageView = findViewById(R.id.messageView);
        if (null != messageView) {
            messageView.setText(message);
            MyUtils.show(messageView);
        }

        ProgressBar progressBar = findViewById(R.id.progressBar);
        if (null != progressBar)
            MyUtils.show(progressBar);
    }

    public void hideProgressMessage() {

        TextView messageView = findViewById(R.id.messageView);
        if (null != messageView) {
            MyUtils.hide(messageView);
        }

        ProgressBar progressBar = findViewById(R.id.progressBar);
        if (null != progressBar)
            MyUtils.hide(progressBar);
    }


//    public void showProgressBar() {
//        ProgressBar progressBar = findViewById(R.id.progressBar);
//        if (null != progressBar)
//            MyUtils.show(progressBar);
//    }
//
//    public void hideProgressBar() {
//        ProgressBar progressBar = findViewById(R.id.progressBar);
//        if (null != progressBar)
//            MyUtils.hide(progressBar);
//    }


    public void showToast(int messageId) {
        String msg = getResources().getString(messageId);

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


    public void showErrorMsg(int messageId, String consoleErrorMsg) {
        String msg = getResources().getString(messageId);
        errorMsg(msg);
        Log.e(TAG, consoleErrorMsg);
    }

    private void errorMsg(String message) {

        TextView messageView = findViewById(R.id.messageView);
        if (null != messageView) {
            messageView.setText(message);
            messageView.setTextColor(getResources().getColor(R.color.colorAccent));
            MyUtils.show(messageView);
        }

        ProgressBar progressBar = findViewById(R.id.progressBar);
        if (null != progressBar)
            MyUtils.hide(progressBar);
    }
}
