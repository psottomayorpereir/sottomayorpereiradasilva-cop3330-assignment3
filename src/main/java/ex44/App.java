/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Pedro Henrique Sotto-Mayor Pereira da Silva
 */
package ex44;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class App
{

    static class Product{
        //private fields
        private String name;
        private double price;
        private int quantity;

        public Product() {
            //constructor
            this.name="name";
            this.price=0.0;
            this.quantity=0;
        }

        public void setProduct(String name, double price, int quantity){
            this.name=name;
            this.price=price;
            this.quantity=quantity;
        }

        public String getName(){
            //return name of the website
            return this.name;
        }

        public double getPrice(){
            //return Author of the website
            return this.price;
        }

        public int getQuantity(){
            //return Author of the website
            return this.quantity;
        }

    }

    public static void main( String[] args ) throws Exception
    {
        String path = "exercise44_input.json";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> price = new ArrayList<String>();
        ArrayList<String> quantity = new ArrayList<String>();
        String word="";
        int size=0;

        Gson gson = new Gson();

        Object json = gson.fromJson(bufferedReader, Object.class);

        String content=json.toString();

        System.out.println(content);

        Pattern pttrn = Pattern.compile("[a-z|A-Z]+");
        Matcher mtchr = pttrn.matcher(content);
        while(mtchr.find()){
            word = mtchr.group();
            names.add(word);
        }
        System.out.println(names);
        size=names.toArray().length;
        //while(size>0){
            names.remove("{");
            names.remove("products");
            //names.remove("]");
            //names.remove("quantity");
            //size--;
        //}
        System.out.println(names);
        size=names.toArray().length;


    }
}