package ru.aakumykov.me.gsontest.models;

import java.util.List;
import java.util.Map;

public class BoardsTOC {

    private Map<String,List<Board>> boardsMap;

    public BoardsTOC() {}

    public Map<String, List<Board>> getBoardsMap() {
        return boardsMap;
    }

    public void setBoardsMap(Map<String, List<Board>> boardsMap) {
        this.boardsMap = boardsMap;
    }
}
