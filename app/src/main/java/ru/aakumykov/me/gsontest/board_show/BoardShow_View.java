package ru.aakumykov.me.gsontest.board_show;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import ru.aakumykov.me.gsontest.BaseView;
import ru.aakumykov.me.gsontest.R;

public class BoardShow_View extends BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threads_list_activity);
        ButterKnife.bind(this);
    }
}
