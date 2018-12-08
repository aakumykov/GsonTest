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

    @BindView(R.id.cat2jsonButton) Button cat2jsonButton;
    @BindView(R.id.json2catButton) Button json2catButton;

    private String catString;
    private Cat catObject1;
    private Cat catObject2;

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

        KittenMap<String,Kitten> kittenMap = new KittenMap();

        catString = "{\n" +
                "\t\"age\": 0,\n" +
                "\t\"kittenMap\": {\n" +
                "\t\t\"список котят котят 1\": [\n" +
                "\t\t\t{\"name\":\"котёнок1.1\"},\n" +
                "\t\t\t{\"name\":\"котёнок1.2\"}\n" +
                "\t\t],\n" +
                "\t\t\"список котят котят 2\": [\n" +
                "\t\t\t{\"name\":\"котёнок2.1\"},\n" +
                "\t\t\t{\"name\":\"котёнок2.2\"}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "}";

        catObject1 = new Cat();

        Map<String,List<Kitten>> kittenMap = new HashMap<>();

        kittenMap.put("список котят котят 1",
                new ArrayList<Kitten>(
                        Arrays.asList(
                                new Kitten("котёнок1.1"),
                                new Kitten("котёнок1.2")
                        )
                )
        );

        kittenMap.put("список котят котят 2",
                new ArrayList<Kitten>(
                        Arrays.asList(
                                new Kitten("котёнок2.1"),
                                new Kitten("котёнок2.2")
                        )
                )
        );

        catObject1.setKittenMap(kittenMap);
    }


    @OnClick(R.id.cat2jsonButton)
    void cat2json() {
        if (null != catObject1) {
            GsonBuilder gsonBuilder1 = new GsonBuilder();
            Gson gson1 = gsonBuilder1.create();
            catString = gson1.toJson(catObject1);
            Log.i("GSON", catString);
        }
    }

    @OnClick(R.id.json2catButton)
    void json2cat() {
        if (!TextUtils.isEmpty(catString)) {
            GsonBuilder gsonBuilder2 = new GsonBuilder();
            Gson gson2 = gsonBuilder2.create();
            catObject2 = gson2.fromJson(catString, Cat.class);
            Log.i("GSON", catObject1.toString());
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


    @OnClick(R.id.json2boardsTOCButton)
    void json2boardsTOC(){
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
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 1,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"fur\",\n" +
                "      \"name\": \"Фурри\",\n" +
                "      \"pages\": 10,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"gg\",\n" +
                "      \"name\": \"Хорошие девушки\",\n" +
                "      \"pages\": 8,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"ga\",\n" +
                "      \"name\": \"Геи\",\n" +
                "      \"pages\": 7,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"h\",\n" +
                "      \"name\": \"Хентай\",\n" +
                "      \"pages\": 10,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"ho\",\n" +
                "      \"name\": \"Прочий хентай\",\n" +
                "      \"pages\": 10,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"bump_limit\": 500,\n" +
                "      \"category\": \"Взрослым\",\n" +
                "      \"default_name\": \"Аноним\",\n" +
                "      \"enable_dices\": 0,\n" +
                "      \"enable_flags\": 0,\n" +
                "      \"enable_icons\": 0,\n" +
                "      \"enable_likes\": 0,\n" +
                "      \"enable_names\": 0,\n" +
                "      \"enable_oekaki\": 0,\n" +
                "      \"enable_posting\": 1,\n" +
                "      \"enable_sage\": 1,\n" +
                "      \"enable_shield\": 0,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 1,\n" +
                "      \"enable_trips\": 0,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"sex\",\n" +
                "      \"name\": \"Секс и отношения\",\n" +
                "      \"pages\": 7,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 0\n" +
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"fet\",\n" +
                "      \"name\": \"Фетиш\",\n" +
                "      \"pages\": 10,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"e\",\n" +
                "      \"name\": \"Extreme Pron\",\n" +
                "      \"pages\": 10,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"hc\",\n" +
                "      \"name\": \"Hardcore\",\n" +
                "      \"pages\": 10,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
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
                "      \"enable_shield\": 1,\n" +
                "      \"enable_subject\": 1,\n" +
                "      \"enable_thread_tags\": 0,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"guro\",\n" +
                "      \"name\": \"Шок-контент\",\n" +
                "      \"pages\": 20,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    },\n" +
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
                "      \"enable_thread_tags\": 1,\n" +
                "      \"enable_trips\": 1,\n" +
                "      \"icons\": [],\n" +
                "      \"id\": \"vape\",\n" +
                "      \"name\": \"Электронные сигареты\",\n" +
                "      \"pages\": 20,\n" +
                "      \"sage\": 1,\n" +
                "      \"tripcodes\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Boolean.class, booleanAsIntAdapter)
                .registerTypeAdapter(boolean.class, booleanAsIntAdapter)
                .create();

        BoardsTOC boardsTOC = gson.fromJson(json, BoardsTOC.class);
    }
}
