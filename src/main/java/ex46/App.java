/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Pedro Henrique Sotto-Mayor Pereira da Silva
 */
package ex46;

import java.util.*;
import java.io.IOException;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App
{
    public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map)
    {
        //Method returning an ascending sorted Map based on values
        //Extends comparator class that compares values for two keys
        Comparator<K> valueComparator = new Comparator<K>() {
            //return comparison results of two keys
            public int compare(K k1, K k2)
            {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };
        //Sorted map generated with Comparator
        Map<K, V> sortedMap = new TreeMap<K, V>(valueComparator);
        sortedMap.putAll(map);
        //return the Map
        return sortedMap;
    }

    static class Phrase{
        //private fields
        private String phrase;

        public Phrase() {
            //constructor
            this.phrase="phrase";
        }

        public void setPhrase(String phrase){
            //set website name and author
            this.phrase=phrase;
        }

        public String getPhrase(){
            //return name of the website
            return this.phrase;
        }


    }

    public static void main( String[] args ) {
        try {
            //instantiate a Phrase object
            Phrase phrase = new Phrase();
            //instantiate a file class and read the content
            String content = new Scanner(new File("exercise46_input.txt")).useDelimiter("\\Z").next();
            //declare variables
            String word = "";
            String star="";
            String format ="";
            //lower case the content of the file
            content=content.toLowerCase();
            //set the Phrase by calling Phrase class
            phrase.setPhrase(content);
            //read each word
            Pattern pttrn = Pattern.compile("[a-z]+");
            Matcher mtchr = pttrn.matcher(phrase.getPhrase());
            //create a TreeMap of type String,Integer
            TreeMap<String, Integer> freq = new TreeMap<>();
            //find the next word in the String
            while(mtchr.find()){
                //key of the map is the word and value is the number of times it appears in the file
                //If the word exists, increment the value in <key,value>
                //If the word does not exist, create a <key,1> for it
                word = mtchr.group();
                if (freq.containsKey(word)) {
                    freq.computeIfPresent(word, (w, c) -> Integer.valueOf(c.intValue() + 1));
                }
                else {
                    freq.computeIfAbsent(word, (w) -> Integer.valueOf(1));
                }
            }
            //format the output
            format = "%-15s: %s%n";
            //sort the map by value by calling the valueSort function
            freq= (TreeMap<String, Integer>) valueSort(freq);
            //convert map to a type that can be iterated -> to array
            Set<Map.Entry<String,Integer>> entrySet = freq.entrySet();
            Map.Entry<String,Integer>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);
            //create a variable to hold the size - 1 of the array for iteration
            int j = entrySet.size()-1;
            //iterate the array, producing '*' for how many times the word appears and store in 'star'
            //print the formatted output and decrease j
            while(j>=0){
                for(int i=0; i < entryArray[j].getValue();i++){
                    star=star.concat("*");
                }
                System.out.printf(format, entryArray[j].getKey(), star);
                star="";
                j--;
            }
        }
        catch (IOException xIo) {
            xIo.printStackTrace();
        }
    }
}