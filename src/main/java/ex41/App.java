/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Pedro Henrique Sotto-Mayor Pereira da Silva
 */
package ex41;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.*;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.io.PrintWriter;

public class App
{
    static class Name{
        //private fields
        private String name;

        public Name() {
            //constructor
            this.name="";
        }

        public void setFirstLast(String name){
            //set name
            this.name=name;
        }

        public String getName(){
            //return name
            return this.name;
        }

    }

    public static void main( String[] args ) throws IOException
    {
        //instantiate the file class
        Scanner sc = new Scanner(new File("exercise41_input.txt"));
        //set delimiter to read file
        sc.useDelimiter(Pattern.compile(", |\r\n"));
        //create variables
        List<String> names_list=new ArrayList<String>();
        String full_name="";
        int count=0;
        //instantiate an object of Name
        Name name = new Name();
        //read each line of the fil
        while (sc.hasNextLine()){
            full_name=sc.nextLine();
            //set name of the person by calling the method of Name class
            name.setFirstLast(full_name);
            //add the name to a list of names
            names_list.add(name.getName());
            //improve count of people
            count++;
        }
        //sort the array in alphabetical order
        Collections.sort(names_list);
        //write the output to an output file named exercise41_output.txt
        PrintWriter out = new PrintWriter("exercise41_output.txt");
        out.printf("Total of %d names", count);
        out.println("\n________________");
        for (String array:names_list) {
            out.println(array);
        }
        out.close();
        System.out.println("Output file named exercise41_output.txt was generated");
    }
}
