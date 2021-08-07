package com.devik;

import antlr.JsonLexer;
import antlr.JsonParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CharStream stream=new ANTLRFileStream("test.Json");
        JsonLexer lexer=new JsonLexer(stream);
        JsonParser parser=new JsonParser(new CommonTokenStream(lexer));
        parser.addParseListener(new JsonCustomListener());
        parser.program();
    }
}
