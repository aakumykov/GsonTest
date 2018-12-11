package ru.aakumykov.me.gsontest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import ru.aakumykov.me.gsontest.utils.MyUtils;

public abstract class BaseFragment extends Fragment implements iBaseFragment {

    public abstract View getView();
    public abstract String getLogTag();


    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public void showProgressMessage(int messageId) {
        String message = getResources().getString(messageId);

        TextView messageView = getView().findViewById(R.id.messageView);
        if (null != messageView) {
            messageView.setText(message);
            MyUtils.show(messageView);
        }

        ProgressBar progressBar = getView().findViewById(R.id.progressBar);
        if (null != progressBar)
            MyUtils.show(progressBar);
    }

    public void hideProgressMessage() {

        TextView messageView = getView().findViewById(R.id.messageView);
        if (null != messageView) {
            MyUtils.hide(messageView);
        }

        ProgressBar progressBar = getView().findViewById(R.id.progressBar);
        if (null != progressBar)
            MyUtils.hide(progressBar);
    }


    public void showToast(int messageId) {
        String msg = getResources().getString(messageId);

        Toast toast = Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


    public void showErrorMsg(int messageId, String consoleErrorMsg) {
        String msg = getResources().getString(messageId);
        errorMsg(msg);
        Log.e(getLogTag(), consoleErrorMsg);
    }

    private void errorMsg(String message) {

        TextView messageView = getView().findViewById(R.id.messageView);
        if (null != messageView) {
            messageView.setText(message);
            messageView.setTextColor(getResources().getColor(R.color.colorAccent));
            MyUtils.show(messageView);
        }

        ProgressBar progressBar = getView().findViewById(R.id.progressBar);
        if (null != progressBar)
            MyUtils.hide(progressBar);
    }

}
