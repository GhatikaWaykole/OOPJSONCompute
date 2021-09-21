package com.example.ObjectJSONProgram;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class JsonWrite {
    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
       System.out.println("welcome to the JSON compute");
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\PC\\IdeaProjects\\OOPJSONProgram\\src\\data.json");
        //java object variable
        Object obj = jsonParser.parse(reader); //this is main object contain i.e which contain JSONPARSER, JSONOBJECT,JSONARRAY
        //JSON object after typecasting
        JSONObject inventoryObj = (JSONObject) obj;
        JSONArray array = (JSONArray) inventoryObj.get("inventory detail");

        for (int i = 0; i < array.size(); i++) {
            JSONObject inventory = (JSONObject)array.get(i);
            String name = (String) inventory.get("name");
            double weight = Double.parseDouble(inventory.get("weight").toString());
            double priceKg = Double.parseDouble(inventory.get("priceKg").toString());

            System.out.println("inventory detail");
            System.out.println("name" + name);
            System.out.println("weight" + weight);
            System.out.println("priceKg" + priceKg);
        }
    }
}
