package ru.aakumykov.me.gsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cat2jsonButton) Button cat2jsonButton;
    @BindView(R.id.json2catButton) Button json2catButton;

    private Cat catObject;
    private String catString;

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
}
