package ru.technotrack.hw1;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class TextGenerator {
    private String [] mNumerals = {"один ", "два ", "три ", "четыре ", "пять ", "шесть ", "семь ", "восемь ", "девять "};
    private String [] wNumerals = {"одна ", "две ", "три ", "четыре ", "пять ", "шесть ", "семь ", "восемь ", "девять "};
    private String [] decades = {"двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "};
    private String [] hundreds = {"сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "};
    private Map<Integer, String> exceptions; //названия чисел от 10 до 19

    private String parseNumerals(int number, Boolean m) throws IllegalArgumentException{
        //переводит 3 цифры в соответсвующую строку. Если m == true, то используется м. род (один, два), иначе - женский (одна, две)
        if (number < 1 || number > 999) {
            throw new IllegalArgumentException("Argument should between 1 and 999.");
        } else {
            //Log.d("HW1.logs", "parsing numerals: " + Integer.toString(number));

            String s = "";
            //сотни
            if (number > 99) {
                s += hundreds[number / 100 - 1];
            }
            //если оставшаяся часть от 10 до 19, до добавляем соответствующую строку в ответ и выводим
            if (exceptions.containsKey(number % 100)) {
                s += exceptions.get(number % 100);
                return s;
            }
            //иначе добавляем десятки
            if (number > 9 && number / 10 % 10 > 0) {
                s += decades[(number / 10 % 10) - 2];
            }
            //единицы с учетом рода
            if (number % 10 > 0) {
                if (m) {
                    s += mNumerals[(number % 10) - 1];
                } else {
                    s += wNumerals[(number % 10) - 1];
                }
            }
            return s;
        }
    }
    public String generate (int number) {
        Log.d("HW1.logs", "generating string for " + Integer.toString(number));
        String s = "";
        //выделяем часть соотвествующую миллионам
        if (number > 999999) {
            s += parseNumerals(number / 1000000, true);
            switch(number / 1000000 % 10) {
                case 1:
                    s += "миллион ";
                    break;
                case 2:
                case 3:
                case 4:
                    s += "миллиона ";
                    break;
                default:
                    s += "миллионов ";
            }
        }
        //тысячи
        if (number > 999 && number % 1000000 / 1000 != 0) {
            s += parseNumerals(number % 1000000 / 1000, false);
            switch(number / 1000 % 10) {
                case 1:
                    s += "тысяча ";
                    break;
                case 2:
                case 3:
                case 4:
                    s += "тысячи ";
                    break;
                default:
                    s += "тысяч ";
            }
        }
        //первые 3 разряда
        if (number % 1000 > 0) {
            s += parseNumerals(number % 1000, true);
        }
        return s;
    }

    public TextGenerator() {
        //заполняем исключения
        exceptions = new HashMap<>();
        exceptions.put(10, "десять ");
        exceptions.put(11, "одиннадцать ");
        exceptions.put(12, "двенадцать ");
        exceptions.put(13, "тринадцать ");
        exceptions.put(14, "четырнадцать ");
        exceptions.put(15, "пятнадцать ");
        exceptions.put(16, "шестьнадцать ");
        exceptions.put(17, "семнадцать ");
        exceptions.put(18, "восемнадцать ");
        exceptions.put(19, "девятнадцать ");
    }
}
