//package ru.aakumykov.me.gsontest;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonDeserializationContext;
//import com.google.gson.JsonDeserializer;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParseException;
//import com.google.gson.JsonSerializationContext;
//import com.google.gson.JsonSerializer;
//
//import java.lang.reflect.Type;
//
//public class CatConverter implements
//        JsonSerializer<Cat>,
//        JsonDeserializer<Cat>
//{
//    @Override
//    public JsonElement serialize(Cat src, Type typeOfSrc, JsonSerializationContext context) {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("name", src.getName());
//        jsonObject.addProperty("age", src.getAge());
//        jsonObject.addProperty("color", src.getColor());
//        jsonObject.addProperty("fleas", src.getFleas().toString());
//        return jsonObject;
//    }
//
//    @Override
//    public Cat deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        JsonObject object = json.getAsJsonObject();
//        String name = object.get("name").getAsString();
//        int age = object.get("age").getAsInt();
//        String color = object.get("color").getAsString();
//        JsonArray fleasArray = object.get("fleas").getAsJsonArray();
//
////        for (int i=0; i<fleasArray.size(); i++) {
////            Flea flea = fleasArray.get(i).
////        }
//    }
//}
