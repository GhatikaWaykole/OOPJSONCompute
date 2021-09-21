package com.example.ObjectJSONProgram;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class JsonWrite {
    public static Scanner scanner = new Scanner(System.in);
    //JSONArray to add the JSONObject data
    public static JSONArray stockList = new JSONArray();
    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        System.out.println("stock market data");
        getData();
    }
        private static void getData() {
            System.out.println("Enter the choice 1.Add stock 2.Print stock report 3, exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStock();
                    break;
                case 2:
                    printStock();
                    break;
            }
    }
    /* JSONParser to give the json file data
    * json path given in filereader parser
     */
        public static void printStock () {
            System.out.println("stock data");
            JSONParser jsonParser = new JSONParser();
            try {
                JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("C:\\Users\\PC\\IdeaProjects\\OOPJSONProgram\\src\\market.json"));
                for (int i = 0; i < jsonArray.size(); i++) {
                    System.out.println("stock data");
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    String name = (String) jsonObject.get("name");
                    double price = (double) jsonObject.get("price");
                    long noOfShares = (long) jsonObject.get("noOfShares");
                    System.out.println("name" + name);
                    System.out.println("noOfShares" + noOfShares);
                    System.out.println("price" + price);
                }
            } catch (FileNotFoundException e) {
                System.out.println("file not appear");
            } catch (IOException e) {
                System.out.println("file IO Exception");
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
            getData();

        }
        public static void addStock() {
            System.out.println("Add the stock");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the stock name");
            String stockName = scanner.nextLine();
            System.out.println("Enter the price");
            double price = scanner.nextDouble();
            System.out.println("Enter the noOfStock");
            int noOfShares = scanner.nextInt();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", stockName);
            jsonObject.put("noOfShares", noOfShares);
            jsonObject.put("price", price);
            stockList.add(jsonObject);
            double result = price * noOfShares;
            System.out.println("stock value"+result);
            try {
                FileWriter fileWriter = new FileWriter("C:\\Users\\PC\\IdeaProjects\\OOPJSONProgram\\src\\market.json");
                fileWriter.write(stockList.toJSONString());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Add" + jsonObject);
            getData();
        }
    }
