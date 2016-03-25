package ru.technotrack.hw1;

import android.util.Log;
import junit.framework.TestCase;
import java.util.HashMap;
import java.util.Map;

public class CorrectResultsTest extends TestCase {
    private TextGenerator textGenerator;
    Map<Integer, String> tests;
    protected void setUp() {
        textGenerator = new TextGenerator();
        tests = new HashMap<>();
        tests.put(3, "три ");
        tests.put(11, "одиннадцать ");
        tests.put(100, "сто ");
        tests.put(156, "сто пятьдесят шесть ");
        tests.put(500, "пятьсот ");
        tests.put(2000, "две тысячи ");
        tests.put(2016, "две тысячи шестьнадцать ");
        tests.put(132007, "сто тридцать две тысячи семь ");
        tests.put(600000, "шестьсот тысяч ");
        tests.put(808006, "восемьсот восемь тысяч шесть ");
        tests.put(990011, "девятьсот девяносто тысяч одиннадцать ");
        tests.put(999999, "девятьсот девяносто девять тысяч девятьсот девяносто девять ");
        tests.put(1000000, "один миллион ");
    }

    public void testAdd() {
        for (Map.Entry<Integer, String> ent : tests.entrySet()) {
            if (!textGenerator.generate(ent.getKey()).equals(ent.getValue())) {
                Log.d("HW1.logs", "Failed on " + Integer.toString(ent.getKey()) + ", got: \n" +
                        textGenerator.generate(ent.getKey()) + "\n while expecting: \n" + ent.getValue());
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
}
