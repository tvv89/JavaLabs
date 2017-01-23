package homework;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Volodymyr Tymchuk on 22.01.2017 for JavaLabs.
 */
public class Main {
    //global attribute file name
    static  final String fileName = "Module_11/src/homework/words.in";

        /*
        --------------------
        -------Task#1-------
        --------------------
        You should create method which replace words in the File and returns String with replaced values
        a) read file, save to string var
        b) replace words
        c) return new string
        String replacer(Map<String, String> map)
        */

    public static String replacer(Map<String,String> map) throws IOException
    {

        BufferedReader br;
        StringBuilder sb;
        FileReader fileReader = null;
        try {
           //a) read file,
            fileReader = new FileReader(fileName);
            br = new BufferedReader(fileReader);
            sb = new StringBuilder();
            //save to string var
            String line = br.readLine();
            while (line != null) {
                sb.append(line+ " ");
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            return "file not found";
        }
        finally {
            if (fileReader!=null) fileReader.close();
        }

        //save to string var
        String allWords;
        try {
            allWords = sb.toString();
        }
        catch (NullPointerException e)
        {
            return "Empty file";
        }
       //b) replace words
        for (HashMap.Entry<String,String> e: map.entrySet()) {
            allWords = allWords.replace(e.getKey(),e.getValue());
        }

       // c) return new string
        return allWords;
    }

        /*
        --------------------
        -------Task#2-------
        --------------------
        You should create method which replace words in the File and rewrite File content with new values
        a) read file, save to string var
        b) replace words
        c) rewrite file with string
        File fileContentReplacer(Map<String, String> map)
        */
    public static File fileContentReplacer(Map<String,String> map) throws IOException
    {

        FileWriter fileWriter = null;
        try {
            /*
            a) read file, save to string var
            b) replace words

            Use DRY
             */
            String toWrite = replacer(map);
            fileWriter = new FileWriter(fileName);
            //c) rewrite file with string
            fileWriter.write(toWrite);
        } catch (IOException e) {
            System.out.println("some problem with write file");
        }
        finally {
            if (fileWriter != null) fileWriter.close();
        }
        //return this file
        File res = new File(fileName);
        return res;
    }

    /*
    --------------------
    -------Task#3-------
    --------------------
    You should create method which replace words in the File and write result to existing File content
    a) read file, save to string var
    b) replace words
    c) add string to the existing file content
    File fileContentMerger(Map<String, String> map)
    */
    public static File fileContentMerger(Map<String,String> map) throws IOException
    {
        FileWriter fileWriter = null;
        try {
            /*
            a) read file, save to string var
            b) replace words
             */
            String toWrite = replacer(map);
            //c) add string to the existing file content
            //true - inr FileWriter
            fileWriter = new FileWriter(fileName,true);
            fileWriter.write(System.lineSeparator());
            fileWriter.write(toWrite);
        } catch (IOException e) {
            System.out.println("some problem with write file");
        }
        finally {
            if (fileWriter != null) fileWriter.close();
        }
        File res = new File(fileName);
        //return this file
        return res;
    }

        /*
        --------------------
        -------Task#4-------
        --------------------
        Check if file contains particular word. Pring 0 if no. Print number n which equals number of times it is contained in the file
        a) read file, save to string var
        b) calculate how many time the word occurs
        c) print result
        int checkWord(String word)
        Write this task with usual try and try with resources (two versions)
        */
    public static int checkWord(String word) throws IOException
    {

        BufferedReader br;
        StringBuilder sb;
        FileReader fileReader = null;
        //a) read file, save to string var
        try {
            fileReader = new FileReader(fileName);
            br = new BufferedReader(fileReader);
            sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line+ " ");
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            return 0;
        }
        finally {
            if (fileReader!=null) fileReader.close();
        }

        String allWords;
        try {
            allWords = sb.toString();
        }
        catch (NullPointerException e)
        {
            return 0;
        }

        //b) calculate how many time the word occurs
        int count = 0;
        for (String i:allWords.split(" ")) {
            if (i.equals(word)) count++ ;
        }

        return count;
    }

    //try with resources
    public static int checkWord2(String word) throws IOException
    {

        BufferedReader br;
        StringBuilder sb;
        // a) read file, save to string var
        try (FileReader fileReader = new FileReader(fileName)) {
            br = new BufferedReader(fileReader);
            sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line + " ");
                line = br.readLine();
            }
        }

        String allWords;
        try {
            allWords = sb.toString();
        }
        catch (NullPointerException e)
        {
            return 0;
        }
        //b) calculate how many time the word occurs
        int count = 0;
        for (String i:allWords.split(" ")) {
            if (i.equals(word)) count++ ;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {

        Map<String,String> newMap = new HashMap<>();
        newMap.put("world","Space");
        /*
        --------------------
        -------Task#1-------
        --------------------
         */
        System.out.println(replacer(newMap));

        /*
        --------------------
        -------Task#2-------
        --------------------
        */
        System.out.println(fileContentReplacer(newMap).toString() + " was changed");

        /*
        --------------------
        -------Task#3-------
        --------------------
        */
        System.out.println(fileContentMerger(newMap).toString() + " was changed");

        /*
        --------------------
        -------Task#4-------
        --------------------
        */
        String word = "hello";
        System.out.println(word + " was in file " + checkWord(word) +" times (try-catch-finally)");
        System.out.println(word + " was in file " + checkWord(word) +" times (try-with-recourse)");




    }
}
