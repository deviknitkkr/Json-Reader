package com.devik;

import antlr.JsonLexer;
import antlr.JsonParser;
import json.JsonArray;
import json.JsonObject;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        String json_string= """
//                {
//                  "name": "name",
//                  "age": 50,
//                  "married": false,
//                  "address": {
//                    "vill": "village",
//                    "tehsil": "tehsil",
//                    "dis": "District",
//                    "pin": 780968
//                  },
//                  "subjects":["english",  "hindi"]
//                }
//                """;
//        JsonObject obj=JsonObject.getFromString(json_string);
        JsonObject obj=new JsonObject("test.Json");
        System.out.println(obj);
        System.out.println(obj.getObject("address"));
        System.out.println(obj.getNumber("age"));
        System.out.println(obj.getJsonArray("subjects"));
        System.out.println("_________________________________________________________________________________");


        String json_array= """
                ["english","hindi","urdu"]
                """;

        JsonArray arr=JsonArray.getFromString(json_array);
        System.out.println(arr.get(0));
    }
}
