/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Pedro Henrique Sotto-Mayor Pereira da Silva
 */
package ex43;

import java.util.Scanner;

import java.io.File;
import java.io.*;

public class App
{
    static class Website{
        //private fields
        private String name;
        private String author;

        public Website() {
            //constructor
            this.name="name";
            this.author="author";
        }

        public void setWebsite(String name, String author){
            //set website name and author
            this.name=name;
            this.author=author;
        }

        public String getName(){
            //return name of the website
            return this.name;
        }

        public String getAuthor(){
            //return Author of the website
            return this.author;
        }


    }

    public static void main( String[] args ) {
        Scanner sc= new Scanner(System.in);
        //instantiate an object for Website class
        Website website = new Website();
        //create variables
        String html="";
        String web="";
        String author="";
        char javaScript='y';
        char css='y';
        //ask for the website name, author, folder for JavaScript, and folder for CSS
        System.out.print("Site name: ");
        web=sc.nextLine();
        System.out.print("Author: ");
        author=sc.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        javaScript=sc.next().charAt(0);
        System.out.print("Do you want a folder for CSS? ");
        css=sc.next().charAt(0);
        //set the author and website names by calling the method of Website class
        website.setWebsite(web, author);
        //create a directory for the website name
        File directory = new File("./website/"+website.getName());
        directory.mkdirs();
        System.out.print("Created ./website/" + website.getName());
        //create an index.html file
        File f = new File("./website/" + website.getName() + "/index.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            //set the header to the name of the website and meta to the author
            html= "<div><h1>" + website.getName() + "</h1><meta name=\"" + website.getAuthor() + "\"></meta></div>";
            bw.write(html);
            bw.close();
            System.out.print("\nCreated ./website/" + website.getName() + "/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //if the user wants a folder for javaScript, create it
        if(javaScript=='y'){
            File javaScr = new File("./website/"+website.getName()+"/js/");
            javaScr.mkdirs();
            System.out.print("\nCreated ./website/" + website.getName() + "/js/");
        }
        //if the user wants a folder for css, create it
        if(css=='y'){
            File cs = new File("./website/"+website.getName()+"/css/");
            cs.mkdirs();
            System.out.print("\nCreated ./website/" + website.getName() + "/css/");
        }
    }
}