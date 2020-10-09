package com.company;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import java.util.ArrayList;
import java.util.List;

public class ParameterTest {
    @Parameters({ "fInput", "fExpected"})

    @Test
    public void checkVowels(String fInput, Boolean fExpected) {
        String all_vowels = "AEUIYOaeuioy";
        List<Character> vowels = new ArrayList<Character>(){};
        for(char ch : all_vowels.toCharArray())
        {
            vowels.add(ch);
        }
        Assert.assertEquals(fExpected, Main.checkWord(fInput, vowels));
    }



}