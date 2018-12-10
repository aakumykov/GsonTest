package ru.aakumykov.me.gsontest.services;

import java.util.List;
import java.util.Map;

import ru.aakumykov.me.gsontest.models.Board.Board;
import ru.aakumykov.me.gsontest.models.BoardsList.BoardsTOCItem;

public interface iDvachService {

    void getBoardsList(TOCReadCallbacks callbacks);

    void getBoard(String boardName, BoardReadCallbacks callbacks);

    interface TOCReadCallbacks {
        void onTOCReadSuccess(Map<String, List<BoardsTOCItem>> tocMap);
        void onTOCReadFail(String errorMsg);
    }

    interface BoardReadCallbacks {
        void onBardReadSuccess(Board board);
        void onBoardReadFail(String errorMsg);
    }
}