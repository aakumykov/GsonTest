package ru.aakumykov.me.gsontest.services;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.aakumykov.me.gsontest.interfaces.DvachAPI;
import ru.aakumykov.me.gsontest.models.Board.Board;
import ru.aakumykov.me.gsontest.models.BoardsList.BoardsTOCItem;


public class DvachService implements iDvachService {

    private static final String BASE_URL = "https://2ch.hk/";
    private static final TypeAdapter<Boolean> booleanAsIntAdapter = new TypeAdapter<Boolean>() {

        @Override public void write(JsonWriter out, Boolean value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(value);
            }
        }

        @Override public Boolean read(JsonReader in) throws IOException {
            JsonToken peek = in.peek();
            switch (peek) {
                case BOOLEAN:
                    return in.nextBoolean();
                case NULL:
                    in.nextNull();
                    return null;
                case NUMBER:
                    return in.nextInt() != 0;
                case STRING:
                    return Boolean.parseBoolean(in.nextString());
                default:
                    throw new IllegalStateException("Expected BOOLEAN or NUMBER but was " + peek);
            }
        }
    };
    private DvachAPI dvachAPI;


    /* Одиночка */
    private static volatile DvachService ourInstance;

    public synchronized static DvachService getInstance() {
        synchronized (DvachService.class) {
            if (null == ourInstance) ourInstance = new DvachService();
            return ourInstance;
        }
    }

    private DvachService() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Boolean.class, booleanAsIntAdapter)
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();

        dvachAPI = retrofit.create(DvachAPI.class);
    }
    /* Одиночка */


    @Override
    public void getBoardsList(final TOCReadCallbacks callbacks) {
        dvachAPI.getBoardsList().enqueue(new Callback<Map<String, List<BoardsTOCItem>>>() {
            @Override
            public void onResponse(@NonNull Call<Map<String, List<BoardsTOCItem>>> call,
                                   @NonNull Response<Map<String, List<BoardsTOCItem>>> response) {
                callbacks.onTOCReadSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Map<String, List<BoardsTOCItem>>> call, @NonNull Throwable t) {
                callbacks.onTOCReadFail(t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getBoard(String boardName, final BoardReadCallbacks callbacks) {
        dvachAPI.getBoard("sex").enqueue(new Callback<Board>() {
            @Override
            public void onResponse(@NonNull Call<Board> call, @NonNull Response<Board> response) {
                callbacks.onBardReadSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Board> call, @NonNull Throwable t) {
                callbacks.onBoardReadFail(t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
