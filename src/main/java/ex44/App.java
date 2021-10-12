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
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class App
{

    static class Product {

        @SerializedName("products")
        @Expose
        //private fields
        private List<Product__1> products;

        public Product(){
            //constructor
            this.products=null;
        }

        public List<Product__1> getProducts() {
            //get List
            return products;
        }

        public void setProducts(List<Product__1> products) {
            //set List
            this.products = products;
        }

    }

    public class Product__1 {

        //private fields
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;

        public Product__1(){
            //constructor
            this.name="";
            this.price=0.0;
            this.quantity=0;
        }

        public String getName() {
            //get product name
            return name;
        }

        public void setName(String name) {
            //set product name
            this.name = name;
        }

        public Double getPrice() {
            //get product price
            return price;
        }

        public void setPrice(Double price) {
            //set product price
            this.price = price;
        }

        public Integer getQuantity() {
            //get product quantity
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            //set product quantity
            this.quantity = quantity;
        }

    }

    public static void main( String[] args ) throws Exception
    {
        //Scanner and BufferedReader
        Scanner sc= new Scanner(System.in);
        BufferedReader br =null;
        //declare variables
        String word="";
        boolean answer=false;
        Gson gson = new Gson();
        br=new BufferedReader((new FileReader("exercise44_input.json")));
        Product product = gson.fromJson(br, Product.class);
        //check if the list exists
        if(product!=null){
            //while the user does not enter a product name in the inventory, keep asking for the name
            while(answer==false){
                //ask user to input product name
                System.out.print("What is the product name? ");
                word=sc.nextLine();
                //'iterate' the list
                //if product found, print its name,price,and quantity. End while loop
                //if not found,show a sorry message, and keep doing the while loop
                for(Product__1 t : product.getProducts()){
                    if(word.equals(t.getName())){
                        System.out.println("Name: "+t.getName()+"\nPrice: "+t.getPrice()+"\nQuantity: "+t.getQuantity());
                        answer=true;
                    }
                }
                if(answer==false){
                    System.out.println("Sorry, that product was not found in our inventory.");
                }
            }
        }
    }
}