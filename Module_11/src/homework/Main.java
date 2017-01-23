package homework;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Volodymyr Tymchuk on 22.01.2017 for JavaLabs.
 */
public class Main {
    public static String replacer(Map<String,String> map) throws IOException
    {
        BufferedReader br;
        try {
            FileReader fileReader = new FileReader("Module_11/src/homework/words.in");
            br = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            return "file not found";
        }

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line+ " ");
            line = br.readLine();
        }
        String allWords = sb.toString();
        for (HashMap.Entry<String,String> e: map.entrySet()) {
            allWords = allWords.replace(e.getKey(),e.getValue());
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Module_11/src/homework/words.in");
            fileWriter.write(allWords);
        } catch (IOException e) {
            return "some problem with write file";
        }
        finally {
            if (fileWriter != null) fileWriter.close();
        }

    return allWords;
    }

    public static void main(String[] args) throws IOException {

        /*
        --------------------
        -------Task#1-------
        --------------------
         */
        Map<String,String> newMap = new HashMap<>();
        newMap.put("world","MIR");
        System.out.println(replacer(newMap));







    }
}
