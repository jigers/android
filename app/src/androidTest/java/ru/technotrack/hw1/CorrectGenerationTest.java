package ru.technotrack.hw1;

import junit.framework.TestCase;

public class CorrectGenerationTest extends TestCase {
    private TextGenerator textGenerator;
    protected void setUp() {
        textGenerator = new TextGenerator();
    }
    public void testAdd() {
        for (int i = 1; i < 1000001; i++) {
            textGenerator.generate(i);
        }
    }
}