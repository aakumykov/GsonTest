package ru.aakumykov.me.gsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.aakumykov.me.gsontest.models.Board;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cat2jsonButton) Button cat2jsonButton;
    @BindView(R.id.json2catButton) Button json2catButton;

    private Cat catObject;
    private String catString;

    private String boardString;
    private Board boardObject;

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

        catObject = new Cat();
        catObject.setName("Мурзик");
        catObject.setAge(9);
        catObject.setColor("чёрный");

        Flea[] fleas = {
                new Flea("Блоха Маруся", 1),
                new Flea("Блох Петя", 2)
        };

        catObject.setFleas(fleas);

        Map<String,Kitten> kittenMap = new HashMap<>();
        kittenMap.put("котёнок-1", new Kitten("котёнок Муризик"));
        kittenMap.put("котёнок-2", new Kitten("котёнок Федик"));

        catObject.setKittenMap(kittenMap);
    }

    @OnClick(R.id.cat2jsonButton)
    void cat2json() {
        if (null != catObject) {
            GsonBuilder gsonBuilder1 = new GsonBuilder();
            Gson gson1 = gsonBuilder1.create();
            catString = gson1.toJson(catObject);
            Log.i("GSON", catString);
        }
    }

    @OnClick(R.id.json2catButton)
    void json2cat() {
        if (!TextUtils.isEmpty(catString)) {
            GsonBuilder gsonBuilder2 = new GsonBuilder();
            Gson gson2 = gsonBuilder2.create();
            catObject = gson2.fromJson(catString, Cat.class);
            Log.i("GSON", catObject.toString());
        }
    }

    @OnClick(R.id.json2boardButton)
    void json2board() {
        String json = "{\n" +
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
                "    }";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Boolean.class, booleanAsIntAdapter)
                .registerTypeAdapter(boolean.class, booleanAsIntAdapter)
                .create();

        this.boardObject = gson.fromJson(json, Board.class);
    }

    @OnClick(R.id.board2jsonButton)
    void board2json() {
        if (null != boardObject) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Boolean.class, booleanAsIntAdapter)
                    .registerTypeAdapter(boolean.class, booleanAsIntAdapter)
                    .create();

            this.boardString = gson.toJson(this.boardObject);
        }
    }
}
