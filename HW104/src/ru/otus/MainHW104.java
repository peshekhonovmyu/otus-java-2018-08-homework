package ru.otus;

import ru.otus.tests.FactorialTests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MainHW104 {

    public static void main(String args[])throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        TestRunner.runTestFromClass(FactorialTests.class);
        TestRunner.runTestFromPackage("ru.otus.tests");
    }
}
