package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public Main() {
    }

    public static Boolean checkWord(String word, List<Character> vowels) {
        Double word_half = Math.floor((double)word.length() / 2.0D);
        Integer count_vowels = 0;

        for(int i = 0; i < word.length(); ++i) {
            if (vowels.contains(word.charAt(i))) {
                count_vowels = count_vowels + 1;
            }

            if ((double)count_vowels > word_half) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<String> splitLine(String line) {
        String temp = "";
        ArrayList<String> res = new ArrayList();

        for(int i = 0; i < line.length(); ++i) {
            if (Character.isLetter(line.charAt(i))) {
                temp = temp + line.charAt(i);
            } else if (temp != "") {
                res.add(temp);
                temp = "";
            }
        }

        if (temp != "") {
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        try {
            FileReader file = new FileReader("java.txt");
            BufferedReader varRead = new BufferedReader(file);
            String all_vowels = "AEUIYOaeuioy";
            List<Character> vowels = new ArrayList<Character>() {
            };
            char[] var5 = all_vowels.toCharArray();
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                char ch = var5[var7];
                vowels.add(ch);
            }

            ArrayList words = new ArrayList();

            String line;
            while((line = varRead.readLine()) != null) {
                ArrayList<String> line_split = splitLine(line);

                for(int i = 0; i < line_split.size(); ++i) {
                    String word = (String)line_split.get(i);
                    if (word.length() > 30) {
                        word = word.substring(0, 29);
                    }

                    if (checkWord(word, vowels) && !words.contains(line_split.get(i))) {
                        words.add((String)line_split.get(i));
                    }
                }
            }

            System.out.println("Result");
            Iterator var14 = words.iterator();

            while(var14.hasNext()) {
                String word = (String)var14.next();
                System.out.println(word);
            }
        } catch (FileNotFoundException var10) {
            System.out.println("No such file");
        }

    }
}
