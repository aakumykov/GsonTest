package ru.aakumykov.me.gsontest;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.aakumykov.me.gsontest.models.Board.Board;
import ru.aakumykov.me.gsontest.models.BoardsList.BoardsTOCItem;

public interface DvachAPI {

    @GET("/makaba/mobile.fcgi?task=get_boards")
    Call<Map<String, List<BoardsTOCItem>>> getBoardsList();

    @GET("/{board_name}/catalog.json")
    Call<Board> getBoard(@Path("board_name") String board_name);

}
