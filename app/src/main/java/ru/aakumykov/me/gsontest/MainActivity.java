package ru.aakumykov.me.gsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.aakumykov.me.gsontest.models.Board.Board;
import ru.aakumykov.me.gsontest.models.BoardsList.BoardsTOCItem;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.boardsListButton) Button tocButton;
    @BindView(R.id.boardButton) Button boardButton;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.boardsListButton)
    void getBoardsList() {

    }

    @OnClick(R.id.boardButton)
    void getBoard() {
    }
}
