/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Pedro Henrique Sotto-Mayor Pereira da Silva
 */
package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    static class OutputFile{
        //private fields
        private String filename;

        public OutputFile() {
            //constructor
            this.filename="exercise45_output.txt";
        }

        public void setOutputFile(String filename){
            //set phrase
            this.filename=filename;
        }

        public String getOutputFile(){
            //return phrase
            return this.filename;
        }


    }

        public static void main( String[] args ) throws Exception {
        Scanner scan= new Scanner(System.in);
        //instantiate the file class
        Scanner sc = new Scanner(new File("exercise45_input.txt"));
        //instantiate scanner to read file
        StringBuffer buffer = new StringBuffer();
        //instantiate an object for OutputFile class
        OutputFile filename = new OutputFile();
        //declare variables
        String fileContents="";
        String outputFile="";
        //read file and append to buffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        fileContents = buffer.toString();
        sc.close();
        //replace 'utilize' with 'use'
        fileContents = fileContents.replaceAll("utilize", "use");
        //ask for an output filename
        System.out.print("Enter an output filename: ");
        outputFile= scan.nextLine();
        filename.setOutputFile(outputFile);
        //instantiate file writer class
        FileWriter writer = new FileWriter(filename.getOutputFile());
        writer.append(fileContents);
        writer.flush();
        System.out.print(filename.getOutputFile() + " file created");

    }
}