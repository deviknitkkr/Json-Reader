package json;

import antlr.JsonParser;
import json.core.InvalidCastException;
import json.core.JsonParserTree;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonObject {

    private final Map<String, Object> map;

    private JsonObject(JsonParser.ObjectContext ctx) {
        map = ctx.pair().stream().collect(Collectors.toMap(pairContext -> {
            String key = pairContext.key().getText();
            return key.substring(1, key.length() - 1);
        }, JsonParser.PairContext::value));
    }

    public JsonObject(String file_name) {
        this(JsonParserTree.getJsonObjectFromFile(file_name));
    }

    public JsonObject(InputStream inputStream) {
        this(JsonParserTree.getJsonObjectFromStream(inputStream));
    }

    public static JsonObject getFromString(String str) {
        return new JsonObject(JsonParserTree.getJsonObjectFromString(str));
    }

    public String getString(String key) {
        Object value = map.get(key);
        if (value == null)
            return null;
        else if (JsonParser.ValueContext.class.isInstance(value)) {
            String str =((JsonParser.ValueContext)value).getText();
            return str.substring(1, str.length() - 1);
        } else
            throw new InvalidCastException("looking for Number but found other type object.");
    }

    public JsonObject getObject(String key) {
        if (map.get(key) == null)
            return null;
        return JsonObject.getFromString(((JsonParser.ValueContext)map.get(key)).getText());
    }

    public Number getNumber(String key) {
        if (map.get(key) == null)
            return null;
        return Double.parseDouble(((JsonParser.ValueContext)map.get(key)).getText());
    }

    public Boolean getBoolean(String key) {
        if (map.get(key) == null)
            return null;
        return Boolean.parseBoolean(((JsonParser.ValueContext)map.get(key)).getText());
    }

    public JsonArray getJsonArray(String key){
        if (map.get(key) == null)
            return null;
        else if (JsonParser.ArrayContext.class.isInstance(map.get(key)))
            return new JsonArray((JsonParser.ArrayContext)map.get(key));
        else
            throw new InvalidCastException("looking for Number but found other type object.");
    }

    public boolean add(String key, Object obj) {
        if (map.get(key) != null)
            return false;

        map.put(key, obj);
        return true;
    }

    public void addForcefully(String key, Object obj) {
        map.put(key, obj);
    }

    public boolean exists(String key) {
        return map.get(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return map.entrySet().stream().map(entry->{
            if(String.class.isInstance(entry.getValue()))
                return "\""+entry.getKey()+"\":\""+((JsonParser.ValueContext)entry.getValue()).getText()+"\"";
            else if(JsonParser.ObjectContext.class.isInstance(entry.getValue()))
                return "\""+entry.getKey()+"\":"+new JsonObject((JsonParser.ObjectContext)entry.getValue()).toString();
            else if(JsonParser.ArrayContext.class.isInstance(entry.getValue()))
                return "\""+entry.getKey()+"\":"+new JsonArray((JsonParser.ArrayContext)entry.getValue()).toString();
            return ""+entry.getKey()+"\":"+((JsonParser.ValueContext)entry.getValue()).getText();
        }).collect(Collectors.joining(",", "{", "}"));

    }
}
