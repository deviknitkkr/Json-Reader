package json;

import antlr.JsonParser;

import java.util.List;
import java.util.stream.Collectors;

public class JsonArray {

    private List<Object> list;

    public JsonArray(JsonParser.ArrayContext ctx){
        list =ctx.value().stream().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return list.stream().map(x->x.toString()).collect(Collectors.joining(",","[","]"));
    }
}
