/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Pedro Henrique Sotto-Mayor Pereira da Silva
 */
package ex44;

import java.util.Scanner;

import java.io.File;
import java.util.regex.Pattern;

public class App
{
    static class Employee{
        //private fields
        private String last;
        private String first;
        private String[] ans;
        private int salary;

        public Employee() {
            //constructor
            this.last="";
            this.first="";
            this.ans = new String[2];
            this.salary=0;
        }


        public void setEmployee(String first, String last, int salary){
            //set Employee information
            this.first=first;
            this.last=last;
            this.salary=salary;
        }

        public String getFirstName(){
            //return first name of Employee
            return this.first;
        }

        public String getLastName(){
            //return last name of Employee
            return this.last;
        }

        public int getSalary(){
            //return salary of Employee
            return this.salary;
        }


    }

    public static void main( String[] args ) throws Exception
    {
        //instantiate the file class
        Scanner sc = new Scanner(new File ("exercise44_input.txt"));


    }
}