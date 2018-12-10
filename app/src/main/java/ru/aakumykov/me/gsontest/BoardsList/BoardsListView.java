package ru.aakumykov.me.gsontest.BoardsList;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.aakumykov.me.gsontest.BaseView;
import ru.aakumykov.me.gsontest.R;
import ru.aakumykov.me.gsontest.models.BoardsList.BoardsTOCItem;
import ru.aakumykov.me.gsontest.services.DvachService;
import ru.aakumykov.me.gsontest.services.iDvachService;

public class BoardsListView extends BaseView {

    @BindView(R.id.listView) ListView listView;
    @BindView(R.id.button) Button button;

    private iDvachService dvachService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        showProgressMessage(R.string.BOARDS_LIST_loading_list);

        dvachService = DvachService.getInstance();
    }

    @OnClick(R.id.button)
    void loadList() {

        dvachService.getBoardsList(new iDvachService.TOCReadCallbacks() {
            @Override
            public void onTOCReadSuccess(Map<String, List<BoardsTOCItem>> tocMap) {
                hideProgressMessage();
                displayList(tocMap);
            }

            @Override
            public void onTOCReadFail(String errorMsg) {
                showErrorMsg(R.string.BOARDS_LIST_error_loading_list, errorMsg);
            }
        });
    }

    private void displayList(Map<String, List<BoardsTOCItem>> tocMap) {

    }
}
