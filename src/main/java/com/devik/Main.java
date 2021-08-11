package com.devik;

import antlr.JsonLexer;
import antlr.JsonParser;
import json.JsonObject;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String json_string= """
                {
                  "name": "name",
                  "age": 50,
                  "address": {
                    "vill": "village",
                    "tehsil": "tehsil",
                    "dis": "District",
                    "pin": 780968
                  }
                }
                """;
        JsonObject obj=JsonObject.getFromString(json_string);
//        System.out.println(obj);
        System.out.println(obj);
        System.out.println(obj.getObject("address"));
    }
}
