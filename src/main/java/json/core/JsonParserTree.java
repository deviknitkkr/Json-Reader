package json.core;

import antlr.JsonLexer;
import antlr.JsonParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.io.InputStream;

public class JsonParserTree {

    public static JsonParser.ObjectContext getJsonObjectFromFile(String file_path) {

        try {
            return getJsonObject(CharStreams.fromFileName(file_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonParser.ObjectContext getJsonObjectFromString(String str) {
        return getJsonObject(CharStreams.fromString(str));
    }

    public static JsonParser.ArrayContext getJsonArrayFromStream(InputStream inputStream) {
        try {
            return getJsonArray(CharStreams.fromStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonParser.ArrayContext getJsonArrayFromFile(String file_path) {

        try {
            return getJsonArray(CharStreams.fromFileName(file_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonParser.ArrayContext getJsonArrayFromString(String str) {
        return getJsonArray(CharStreams.fromString(str));
    }

    public static JsonParser.ObjectContext getJsonObjectFromStream(InputStream inputStream) {
        try {
            return getJsonObject(CharStreams.fromStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static JsonParser.ObjectContext getJsonObject(CharStream stream) {
        JsonLexer lexer = new JsonLexer(stream);
        JsonParser parser = new JsonParser(new CommonTokenStream(lexer));
        return parser.object();
    }

    private static JsonParser.ArrayContext getJsonArray(CharStream stream) {
        JsonLexer lexer = new JsonLexer(stream);
        JsonParser parser = new JsonParser(new CommonTokenStream(lexer));
        return parser.array();
    }
}
