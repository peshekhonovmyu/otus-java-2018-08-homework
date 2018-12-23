package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;
import ru.otus.tests.FactorialTests;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class TestRunner {

    public static void runTestFromClass(Class<?> claszz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Object t;

        int testPassed = 0;
        int testFailed = 0;

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
            for (Method test : testMethods) {
                try {
                    if (beforeTest != null) {
                        beforeTest.invoke(t);
                    }
                    test.invoke(t);
                    testPassed++;
                    if (afterTest != null) {
                        afterTest.invoke(t);
                    }
                } catch (Exception e) {
                    testFailed++;
                }
            }
        }
        System.out.println("Results of testing:");
        System.out.println("Test passed = " + testPassed);
        System.out.println("Test failed = " + testFailed);
    }

    public static void runTestFromPackage(String packageName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class<?> clazz;
        Path pathToPackage = Paths.get("").toAbsolutePath().getParent()
                .resolve("HW104\\src\\")
                .resolve(packageName.replace(".", "\\"));
        File[] testFiles = pathToPackage.toFile().listFiles();
        for (File testFile : testFiles) {
            clazz = Class.forName(packageName + "." + testFile.getName().replace(".java", ""));
            TestRunner.runTestFromClass(clazz);
        }
    }
}