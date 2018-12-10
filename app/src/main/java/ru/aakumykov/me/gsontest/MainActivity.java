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
import ru.aakumykov.me.gsontest.models.Board;
import ru.aakumykov.me.gsontest.models.BoardInTOC;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tocButton) Button tocButton;
    @BindView(R.id.boardButton) Button boardButton;

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

    @OnClick(R.id.tocButton)
    void TOC() {

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

        Type mapTypeToken = new TypeToken<Map<String, List<BoardInTOC>>>() {}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Boolean.class, booleanAsIntAdapter);

        Gson gson = gsonBuilder.create();

        Map<Integer, BoardInTOC> mapItemsDes = gson.fromJson(json, mapTypeToken);
    }

    @OnClick(R.id.boardButton)
    void board() {
        String json = "{\n" +
                "  \"Board\": \"sex\",\n" +
                "  \"BoardInfo\": \"Это доска для совершеннолетних. Посты и треды с указанием возраста <18 лет будут удалены. Конференция доски в Телеграме - <a href=\\\"https://t.me/joinchat/B1LyW1HGaKG5Fjc478wcfQ\\\">@ru2chsex</a>\",\n" +
                "  \"BoardInfoOuter\": \"секс, отношения, еот, еок, биопроблемы\",\n" +
                "  \"BoardName\": \"Секс и отношения\",\n" +
                "  \"advert_bottom_image\": \"/banners/ZCSESUwahz7ezOa0.jpg\",\n" +
                "  \"advert_bottom_link\": \"/banners/ZCSESUwahz7ezOa0/\",\n" +
                "  \"advert_mobile_image\": \"/banners/S4BcqS4adse3B2Cb.jpg\",\n" +
                "  \"advert_mobile_link\": \"/banners/S4BcqS4adse3B2Cb/\",\n" +
                "  \"advert_top_image\": \"/banners/bDpQCWt8xPTuC43S.jpg\",\n" +
                "  \"advert_top_link\": \"/banners/bDpQCWt8xPTuC43S/\",\n" +
                "  \"board_banner_image\": \"/ololo/gd_1.gif\",\n" +
                "  \"board_banner_link\": \"gd\",\n" +
                "  \"bump_limit\": 500,\n" +
                "  \"default_name\": \"Аноним\",\n" +
                "  \"enable_dices\": 0,\n" +
                "  \"enable_flags\": 0,\n" +
                "  \"enable_icons\": 0,\n" +
                "  \"enable_images\": 1,\n" +
                "  \"enable_likes\": 0,\n" +
                "  \"enable_names\": 0,\n" +
                "  \"enable_oekaki\": 0,\n" +
                "  \"enable_posting\": 1,\n" +
                "  \"enable_sage\": 1,\n" +
                "  \"enable_shield\": 0,\n" +
                "  \"enable_subject\": 1,\n" +
                "  \"enable_thread_tags\": 1,\n" +
                "  \"enable_trips\": 0,\n" +
                "  \"enable_video\": 1,\n" +
                "  \"filter\": \"standart\",\n" +
                "  \"max_comment\": 15000,\n" +
                "  \"max_files_size\": 40960,\n" +
                "  \"news_abu\": [\n" +
                "    {\n" +
                "      \"date\": \"02/12/16\",\n" +
                "      \"num\": 54946,\n" +
                "      \"subject\": \"Конкурс визуальных новелл доски /ruvn/\",\n" +
                "      \"views\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"15/11/16\",\n" +
                "      \"num\": 53612,\n" +
                "      \"subject\": \"**НОВЫЙ ФУНКЦИОНАЛ** - Стикеры\",\n" +
                "      \"views\": 37753\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"09/10/16\",\n" +
                "      \"num\": 52084,\n" +
                "      \"subject\": \"Открыта доска /int/ - International, давайте расскажем о ней!\",\n" +
                "      \"views\": 33177\n" +
                "    }\n" +
                "  ],\n" +
                "  \"threads\": [\n" +
                "    {\n" +
                "      \"banned\": 0,\n" +
                "      \"closed\": 0,\n" +
                "      \"comment\": \"FAQ сексача - https://goo.gl/67TwA6 <br>\\\\r\\\\nИТТ ты можешь задавать любые вопросы, касающиеся данной тематики; для тредов про ЕОТ, длину хуя, личных драм, безотказных техник пикапа и идеальных моделей поведения — весь остальной /sex/ в твоём полном распоряжении. Срачи, разборки, детектирование шлюх и т.д. просьба перекатывать за пределы треда, будьте людьми, окда.<br><br>• Советы короткостволам, исповедь девственника, вопросы альфачам, ЕОТ - всё здесь. Не лезьте со своими биопроблемами в другие разделы.<br>• Реквесты фото - в этом треде, чатики трипфаги вниманиебляди и асечки-писечки - <strong><a href=\\\"http://t.me/joinchat/B1LyWxBwYouLwm2zKQweLQ\\\">http://t.me/joinchat/B1LyWxBwYouLwm2zKQweLQ</a></strong><br>• Реквесты порнухи, поиски порноактрисы, порнороликов - в /e/\",\n" +
                "      \"date\": \"31/05/17 Срд 07:56:00\",\n" +
                "      \"email\": \"\",\n" +
                "      \"endless\": 1,\n" +
                "      \"files\": [\n" +
                "        {\n" +
                "          \"displayname\": \"in-defense-of-c[...].png\",\n" +
                "          \"fullname\": \"in-defense-of-comprehensive-sex-education-l-qdoaxm.png\",\n" +
                "          \"height\": 337,\n" +
                "          \"md5\": \"8ecf5fe9e121089c0c2d3aafe4762587\",\n" +
                "          \"name\": \"14962065603890.png\",\n" +
                "          \"nsfw\": 0,\n" +
                "          \"path\": \"/sex/src/3779016/14962065603890.png\",\n" +
                "          \"size\": 357,\n" +
                "          \"thumbnail\": \"/sex/thumb/3779016/14962065603890s.jpg\",\n" +
                "          \"tn_height\": 140,\n" +
                "          \"tn_width\": 250,\n" +
                "          \"type\": 2,\n" +
                "          \"width\": 600\n" +
                "        }\n" +
                "      ],\n" +
                "      \"files_count\": 28,\n" +
                "      \"lasthit\": 1544408380,\n" +
                "      \"name\": \"Аноним\",\n" +
                "      \"num\": \"3779016\",\n" +
                "      \"op\": 0,\n" +
                "      \"parent\": \"0\",\n" +
                "      \"posts_count\": 500,\n" +
                "      \"sticky\": 1,\n" +
                "      \"subject\": \"СЕКСАЧ ОБРАЗОВАТЕЛЬНЫЙ №12\",\n" +
                "      \"tags\": \"faq\",\n" +
                "      \"timestamp\": 1496206560,\n" +
                "      \"trip\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"banned\": 0,\n" +
                "      \"closed\": 0,\n" +
                "      \"comment\": \"В тред приглашаются господа <strong>23+</strong> левела. И особенно наши старшие товарищи - <em><strong>олдфаги-маги</strong></em>.<br>Рассказываем, почему такое произошло. Обвиняем маму и бабушку.<br>Плачем со своих короткостволов. <span class=\\\"u\\\">Гоняем социоблядей</span> в треде.<br>Продолжаем воротить ебало от всратых жирух. Ждём <em><strong>ту самую</strong></em>, которая подарит нам счастье.<br><span class=\\\"u\\\">Шлюхи - не наш метод!</span><br>Помогаем друг другу пережить боль и страдания. Здесь тебя <strong>всегда</strong> готовы выслушать, каким бы ты ни был.<span class=\\\"spoiler\\\"> Если ты не нормис конечно же.</span><br><br><strong>НЕ. КОРМИТЕ. НОРМИСОВ.</strong><br><br>Тред переписи листвы: <a href=\\\"/sex/res/5013213.html#5013213\\\" class=\\\"post-reply-link\\\" data-thread=\\\"5013213\\\" data-num=\\\"5013213\\\">>>5013213 (OP)</a><br><br>Прошлый тред: <a href=\\\"/sex/res/5015614.html#5015614\\\" class=\\\"post-reply-link\\\" data-thread=\\\"5015614\\\" data-num=\\\"5015614\\\">>>5015614 (OP)</a>\",\n" +
                "      \"date\": \"10/12/18 Пнд 01:28:24\",\n" +
                "      \"email\": \"\",\n" +
                "      \"endless\": 0,\n" +
                "      \"files\": [\n" +
                "        {\n" +
                "          \"displayname\": \"769.jpg\",\n" +
                "          \"fullname\": \"769.jpg\",\n" +
                "          \"height\": 1000,\n" +
                "          \"md5\": \"b7c074686d74b883a12d182252f17e31\",\n" +
                "          \"name\": \"15443945052660.jpg\",\n" +
                "          \"nsfw\": 0,\n" +
                "          \"path\": \"/sex/src/5016858/15443945052660.jpg\",\n" +
                "          \"size\": 225,\n" +
                "          \"thumbnail\": \"/sex/thumb/5016858/15443945052660s.jpg\",\n" +
                "          \"tn_height\": 250,\n" +
                "          \"tn_width\": 250,\n" +
                "          \"type\": 1,\n" +
                "          \"width\": 1000\n" +
                "        }\n" +
                "      ],\n" +
                "      \"files_count\": 14,\n" +
                "      \"lasthit\": 1544408738,\n" +
                "      \"name\": \"Аноним\",\n" +
                "      \"num\": \"5016858\",\n" +
                "      \"op\": 0,\n" +
                "      \"parent\": \"0\",\n" +
                "      \"posts_count\": 88,\n" +
                "      \"sticky\": 0,\n" +
                "      \"subject\": \"Листва Тред #68\",\n" +
                "      \"tags\": \"virgin\",\n" +
                "      \"timestamp\": 1544394504,\n" +
                "      \"trip\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"banned\": 0,\n" +
                "      \"closed\": 0,\n" +
                "      \"comment\": \"<strong>В тред призываются аноны, которые пробовали эту штуку</strong><br><br>Сап, вот надумал прикупить себе пикрил. Кто-нибудь юзал? Расскажите, стоящая покупка? Денег на неё не жалко, то есть оцениваем исключительно с точки зрения качества товара. Буду благодарен за ответы.\",\n" +
                "      \"date\": \"07/12/18 Птн 23:49:01\",\n" +
                "      \"email\": \"mailto:FLESHLIGHT\",\n" +
                "      \"endless\": 0,\n" +
                "      \"files\": [\n" +
                "        {\n" +
                "          \"displayname\": \"41zLul5R3TL.SY3[...].jpg\",\n" +
                "          \"fullname\": \"41zLul5R3TL.SY355.jpg\",\n" +
                "          \"height\": 355,\n" +
                "          \"md5\": \"feef9b0c7e1c6593efdb5e583fd3f640\",\n" +
                "          \"name\": \"15442157419600.jpg\",\n" +
                "          \"nsfw\": 0,\n" +
                "          \"path\": \"/sex/src/5007779/15442157419600.jpg\",\n" +
                "          \"size\": 14,\n" +
                "          \"thumbnail\": \"/sex/thumb/5007779/15442157419600s.jpg\",\n" +
                "          \"tn_height\": 250,\n" +
                "          \"tn_width\": 250,\n" +
                "          \"type\": 1,\n" +
                "          \"width\": 355\n" +
                "        }\n" +
                "      ],\n" +
                "      \"files_count\": 1,\n" +
                "      \"lasthit\": 1544250792,\n" +
                "      \"name\": \"Аноним\",\n" +
                "      \"num\": \"5007779\",\n" +
                "      \"op\": 0,\n" +
                "      \"parent\": \"0\",\n" +
                "      \"posts_count\": 11,\n" +
                "      \"sticky\": 0,\n" +
                "      \"subject\": \"В тред призываются аноны, которые пробовали\",\n" +
                "      \"tags\": \"\",\n" +
                "      \"timestamp\": 1544215741,\n" +
                "      \"trip\": \"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"top\": [\n" +
                "    {\n" +
                "      \"board\": \"2d\",\n" +
                "      \"info\": \"Щитпостинг, обсуждение вайфу, аватарки и прочее. Анимешный /b/, постинг 3d не приветствуется.\",\n" +
                "      \"name\": \"Аниме/Беседка\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"board\": \"wwe\",\n" +
                "      \"info\": \"Доска, посвященная рестлингу: WWE, NXT, TNA, ROH, NJPW, Lucha Underground и многое другое\",\n" +
                "      \"name\": \"WorldWide Wrestling Universe\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"board\": \"ch\",\n" +
                "      \"info\": \"Уютные чатики и конфочки\",\n" +
                "      \"name\": \"Чатики и конфочки\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"board\": \"int\",\n" +
                "      \"info\": \"This board focuses on international friendship and cultural exchange.\",\n" +
                "      \"name\": \"International\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"board\": \"ruvn\",\n" +
                "      \"info\": \"\",\n" +
                "      \"name\": \"Российские визуальные новеллы\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"board\": \"math\",\n" +
                "      \"info\": \"Доска о модулях над кольцами, пучках на многообразиях и гомологиях с когомологиями.\",\n" +
                "      \"name\": \"Математика\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

//        Type mapTypeToken = new TypeToken<Map<String, List<BoardInTOC>>>() {}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Boolean.class, booleanAsIntAdapter);

        Gson gson = gsonBuilder.create();

        Board board = gson.fromJson(json, Board.class);
    }
}
