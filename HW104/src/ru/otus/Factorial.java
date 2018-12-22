package ru.otus;

public class Factorial {

    public int res;

    public int factorial(int number) {

        while (number > 1) {
            res = res * number;
            number--;
        }
        return res;
    }

    ;


}
