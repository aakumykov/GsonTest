package ru.aakumykov.me.gsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.aakumykov.me.gsontest.models.Board;
import ru.aakumykov.me.gsontest.models.BoardsTOC;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.o2jButton) Button o2jButton;
    @BindView(R.id.j2oButton) Button j2oButton;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.o2jButton)
    void object2json() {

    }

    @OnClick(R.id.j2oButton)
    void json2object() {

        String json = "{\n" +
                "  \"Взрослым\": [\n" +
                "    {\n" +
                "      \"bump_limit\": 500,\n" +
                "      \"category\": \"Взрослым\",\n" +
                "      \"default_name\": \"Аноним\",\n" +
                "      \"enable_dices\": 0,\n" +
                "      \"enable_flags\": 0,\n" +
                "      \"enable_icons\": 0,\n" +
                "      \"enable_likes\": 0,\n" +
                "      \"enable_names\": 1,\n" +
                "      \"enable_oekaki\": 0,\n" +
                "      \"enable_posting\": 1,\n" +
                "      \"enable_sage\": 1,\n" +
                "      \"enable_shield\": 0,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"fag\",\n" +
                "      \"name\": \"Фагготрия\",\n" +
                "      \"pages\": 7,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"bump_limit\": 500,\n" +
                "      \"category\": \"Взрослым\",\n" +
                "      \"default_name\": \"уточка\",\n" +
                "      \"enable_dices\": 0,\n" +
                "      \"enable_flags\": 0,\n" +
                "      \"enable_icons\": 0,\n" +
                "      \"enable_likes\": 0,\n" +
                "      \"enable_names\": 1,\n" +
                "      \"enable_oekaki\": 0,\n" +
                "      \"enable_posting\": 1,\n" +
                "      \"enable_sage\": 1,\n" +
                "      \"enable_shield\": 0,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 1,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"fg\",\n" +
                "      \"name\": \"Трапы\",\n" +
                "      \"pages\": 10,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Type mapTypeToken = new TypeToken<Map<String, List<Board>>>() {}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Boolean.class, booleanAsIntAdapter);

        Gson gson = gsonBuilder.create();

        Map<Integer, Board> mapItemsDes = gson.fromJson(json, mapTypeToken);
    }
}
