package com.triangletesting.triangletesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void constructorTest1() throws Exception {
        Triangle triangleTester = new Triangle(2, 2, 2);
        assertTrue(triangleTester.getType().contains("Equilateral"));
    }

    @Test
    void constructorTest2() throws Exception {
        Triangle triangleTester = new Triangle(3, 4, 5);
        assertTrue(triangleTester.getType().contains("Scalene"));
    }

    @Test
    void constructorTest3() throws Exception {
        assertThrows(Exception.class, () -> {new Triangle(1, 0, 1);});
    }

    @Test
    void constructorTest4() throws Exception {
        assertThrows(Exception.class, () -> {new Triangle(1, 1, 0);});
    }

    @Test
    void constructorTest5() throws Exception {
        assertThrows(Exception.class, () -> {new Triangle(1, 2, 1);});
    }

    @Test
    void constructorTest6() throws Exception {
        assertThrows(Exception.class, () -> {new Triangle(1, 1, 2);});
    }

    @Test
    void constructorTest7() throws Exception {
        Triangle triangleTester = new Triangle(2, 2, 1);
        assertTrue(triangleTester.getType().contains("Isosceles"));
    }

    @Test
    void getAreaTest() {
    }
}