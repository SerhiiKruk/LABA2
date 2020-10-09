package com.company;
import org.testng.Assert;
import org.testng.annotations.Test;
import  org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.*;

public class MainTest {
    public  MainTest testclass;

    @BeforeClass
    public static void setupBeforeClass() {
        System.out.print("Before Class");
    }

    @BeforeMethod
    public void setupBefore() throws Exception {
        testclass = new MainTest ();
        System.out.print("Before Method");
    }
    @Test(groups= {"First"})
    public void splitOnWordsTest() throws Exception {
        String text = "junit67java]test/.,program238false";
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("junit");
        temp.add("java");
        temp.add("test");
        temp.add("program");
        temp.add("false");
        Assert.assertEquals(Main.splitLine(text), temp);
    }
    @Test(groups= {"First"})
    public void checkVowelsTest1() throws Exception {
        String all_vowels = "AEUIYOaeuioy";
        List<Character> vowels = new ArrayList<Character>() {
        };
        char[] var3 = all_vowels.toCharArray();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char ch = var3[var5];
            vowels.add(ch);
        }

        String temp = "AggEra";
        Assert.assertFalse(Main.checkWord(temp, vowels));
    }

    @Test(groups= {"Second"})
    public void checkVowelsTest2() throws Exception {
        String all_vowels = "AEUIYOaeuioy";
        List<Character> vowels = new ArrayList<Character>() {
        };
        char[] var3 = all_vowels.toCharArray();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char ch = var3[var5];
            vowels.add(ch);
        }

        String temp = "AggEe";
        Assert.assertTrue(Main.checkWord(temp, vowels));
    }
    @Test(groups= {"Second"})
    public void checkSplitLine() throws Exception {
        String text = "-0g98gth7546//*/-*-3234567890";
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("gth");
        Assert.assertNotSame(temp, Main.splitLine(text));
    }
}