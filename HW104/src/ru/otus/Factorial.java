package ru.otus;

public class Factorial {

    public int res;

    public int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        while (number > 1) {
            res = res * number;
            number--;
        }
        return res;
    }

    ;


}
