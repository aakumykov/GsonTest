package ru.aakumykov.me.gsontest.BoardsList;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Optional;
import ru.aakumykov.me.gsontest.BaseView;
import ru.aakumykov.me.gsontest.R;
import ru.aakumykov.me.gsontest.models.BoardsList.BoardsTOCItem;
import ru.aakumykov.me.gsontest.services.DvachService;
import ru.aakumykov.me.gsontest.services.iDvachService;

public class BoardsListView extends BaseView {

    private iDvachService dvachService;
    private List<BoardsTOCItem> list;
    private BoardsListAdapter listAdapter;
    @BindView(R.id.listView) ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boards_list_activity);
        ButterKnife.bind(this);

        showProgressMessage(R.string.BOARDS_LIST_loading_list);

        dvachService = DvachService.getInstance();
        list = new ArrayList<>();
        listAdapter = new BoardsListAdapter(this, R.layout.boards_list_item, list);
        listView.setAdapter(listAdapter);

        loadList();
    }

    @OnItemClick(R.id.listView)
    void onItemClick(int position) {

    }


    private void loadList() {
        list.clear();
        listAdapter.clear();

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
        for (Map.Entry entry : tocMap.entrySet()) {
            String boardName = entry.getKey().toString();
            List<BoardsTOCItem> list = (List<BoardsTOCItem>) entry.getValue();
            for (int i=0; i<list.size(); i++) {
                BoardsTOCItem boardsTOCItem = list.get(i);
                this.list.add(boardsTOCItem);
            }
        }
        listAdapter.notifyDataSetChanged();
    }
}
