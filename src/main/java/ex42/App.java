/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Pedro Henrique Sotto-Mayor Pereira da Silva
 */
package ex42;

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
        Scanner sc = new Scanner(new File ("exercise42_input.txt"));
        //set the delimiter
        sc.useDelimiter(Pattern.compile(",|\r\n"));
        //declare variables
        String first="";
        String last="";
        String[] ans = new String[2];
        int salary=0;
        //instantiate an object of Employee
        Employee employee = new Employee();
        //output the first 2 lines of the formatted table
        System.out.printf("%-10s %-10s %-7s\n","Last","First","Salary");
        System.out.println("____________________________\n");
        while (sc.hasNext()){
            //read the information for one employee
            last=sc.next();
            first=sc.next();
            salary=sc.nextInt();
            //set the employee information by calling the method of Employee class
            employee.setEmployee(first,last,salary);
            //print the formatted employee information
            System.out.printf("%-10s %-10s %-7d",employee.getLastName(), employee.getFirstName(), employee.getSalary());
            System.out.println("\n");
        }

    }
}