package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;
import tests.FactorialTests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class TestRunner {

    public static void runTest(Class<?> claszz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Object t;

        Method[] methods = claszz.getMethods();
        Method beforeTest = null;
        Method afterTest = null;
        ArrayList<Method> testMethods = new ArrayList<Method>();

        for (Method method : methods) {
            method.setAccessible(true);

            if (method.isAnnotationPresent(After.class)) {
                afterTest = method;
            } else if (method.isAnnotationPresent(Before.class)) {
                beforeTest = method;
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }

        if (!testMethods.isEmpty()) {
            t = claszz.getDeclaredConstructor().newInstance();

            if (beforeTest != null) {
                beforeTest.invoke(t);
            }

            for (Method test : testMethods) {

                test.invoke(t);
            }

            if (afterTest != null) {
                afterTest.invoke(t);
            }
        }
    }
}
