package tests;

import ru.otus.annotations.*;
import ru.otus.Factorial;

public class FactorialTests {

    Factorial f = new Factorial();

    @Before
    public void before() {
        System.out.print("Test started");
        f.res = 1;
    }

    @Before
    public void after() {
        System.out.print("Test ended");
    }

    @Test
    public void test1() {
        f.factorial(3);
        System.out.print("Test passed! ");
    }

    @Test
    public void test2() {
        f.factorial(3);
        System.out.print("Test passed! ");
    }

}
