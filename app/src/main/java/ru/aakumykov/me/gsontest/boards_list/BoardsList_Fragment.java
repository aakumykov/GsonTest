package ru.aakumykov.me.gsontest.boards_list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ru.aakumykov.me.gsontest.BaseFragment;
import ru.aakumykov.me.gsontest.R;

public class BoardsList_Fragment extends BaseFragment {

    private final static String TAG = "BoardsList_Fragment";

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.boards_list_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public View getView() {
        return null;
    }

    @Override
    public String getLogTag() {
        return TAG;
    }
}
