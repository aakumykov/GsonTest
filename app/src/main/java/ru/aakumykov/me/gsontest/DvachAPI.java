package ru.aakumykov.me.gsontest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.aakumykov.me.gsontest.models.Board;

public interface DvachAPI {

    // https://2ch.hk/sex/catalog.json

    @GET("/{board_name}/catalog.json")
    Call<Board> getData(@Path("board_name") String board_name);

}
