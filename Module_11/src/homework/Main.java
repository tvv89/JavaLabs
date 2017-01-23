package homework;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Volodymyr Tymchuk on 22.01.2017 for JavaLabs.
 */
public class Main {
    static  final String fileName = "Module_11/src/homework/words.in";

        /*
        --------------------
        -------Task#1-------
        --------------------
        */
    public static String replacer(Map<String,String> map) throws IOException
    {

        BufferedReader br;
        StringBuilder sb;
        FileReader fileReader = null;
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
            return "file not found";
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
            return "Empty file";
        }

        for (HashMap.Entry<String,String> e: map.entrySet()) {
            allWords = allWords.replace(e.getKey(),e.getValue());
        }


    return allWords;
    }

        /*
        --------------------
        -------Task#2-------
        --------------------
        */
    public static File fileContentReplacer(Map<String,String> map) throws IOException
    {

        FileWriter fileWriter = null;
        try {
            String toWrite = replacer(map);
            fileWriter = new FileWriter(fileName);
            fileWriter.write(toWrite);
        } catch (IOException e) {
            System.out.println("some problem with write file");
        }
        finally {
            if (fileWriter != null) fileWriter.close();
        }
        File res = new File(fileName);
        return res;
    }

    public static void main(String[] args) throws IOException {

        Map<String,String> newMap = new HashMap<>();
        newMap.put("world","MIR");
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








    }
}
