package ru.otus.tests;

import ru.otus.annotations.*;
import ru.otus.Factorial;

import static org.hamcrest.MatcherAssert.assertThat;

public class FactorialTests {

    Factorial f = new Factorial();

    @Before
    public void before() {
        System.out.println("Test started");
        f.res = 1;
    }

    @After
    public void after() {
        System.out.println("Test ended");
    }

    @Test
    public void testFactorial0() {
        assertThat("Test failed", f.factorial(0) == 1);
    }

    @Test
    public void testFactorial1() {
        assertThat("Test failed", f.factorial(1) == 1);
    }

    @Test
    public void testFactorial4() {
        assertThat("Test failed", f.factorial(4) == 24);
    }

    @Test
    public void testFactorialCorrect() {
        assertThat("Test failed", f.factorial(3) != 5);
    }
}
