package ru.otus;

import tests.FactorialTests;

import java.lang.reflect.InvocationTargetException;

public class MainHW104 {

    public static void main(String args[])throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        TestRunner.runTest(FactorialTests.class);
    }
}
