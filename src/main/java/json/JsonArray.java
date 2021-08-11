package json;

import antlr.JsonLexer;
import antlr.JsonParser;
import json.core.JsonParserTree;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class JsonArray {

    private List<Object> list;

    public JsonArray(JsonParser.ArrayContext ctx){
        list =ctx.value().stream().collect(Collectors.toList());
    }

    public JsonArray(String file_path){
        this(JsonParserTree.getJsonArrayFromFile(file_path));
    }

    public JsonArray(InputStream inputStream){
        this(JsonParserTree.getJsonArrayFromStream(inputStream));
    }

    public static JsonArray getFromString(String str){
        return new JsonArray(JsonParserTree.getJsonArrayFromString(str));
    }

    public String get(int index){
        return ((JsonParser.ValueContext)list.get(index)).getText();
    }

    public List<String>getAll(){
        return list.stream().map(x->((JsonParser.ValueContext)x).getText()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return getAll().toString();
    }
}
