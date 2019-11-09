package com.triangletesting.triangletesting;

import org.junit.jupiter.api.Test;

import java.lang.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTestingApplicationTest extends TriangleTestingApplication{


    @Test
    void GetChoiceTest1() {
        String choiceEntry = "1";
        Scanner testScanner = new Scanner(choiceEntry);
        assertEquals(1, getChoice(testScanner));
    }
    @Test
    void GetChoiceTest2() {
        String choiceEntry = "2";
        Scanner testScanner = new Scanner(choiceEntry);
        assertEquals(2, getChoice(testScanner));
    }

    @Test
    void GetChoiceTest3() {
        String choiceEntry = "3";
        Scanner testScanner = new Scanner(choiceEntry);
        assertThrows(Exception.class, () -> {getChoice(testScanner);});
    }

    @Test
    void TestCreateTriangle1() throws Exception {
        int choice = 1;
        String nullString = "2\n2\n3\n";
        Scanner testScanner = new Scanner(nullString);
        assertEquals(new Triangle(2,2,3).getType(),createTriangle(choice, testScanner).getType());
    }

    @Test
    void TestCreateTriangle2() throws Exception {
        int choice = 2;
        String nullString = "1 1\n2 2\n1 2\n";
        Scanner testScanner = new Scanner(nullString);
        assertTrue(createTriangle(choice, testScanner).getType().equals("Right Isosceles"));
    }

    @Test
    void TestCreateTriangle3() throws Exception {
        int choice = 3;
        String nullString = "";
        Scanner testScanner = new Scanner(nullString);
        assertTrue(createTriangle(choice, testScanner) == null);
    }

    @Test
    void TestCreateTriangleSides1() {
        String inputString = "2\n2\nA\n";
        Scanner testScanner = new Scanner(inputString);
        assertThrows(Exception.class, () -> {createTriangleSides(testScanner);});
    }

    @Test
    void TestCreateTriangleSides2() {
        String inputString = "2\n1\n1\n";
        Scanner testScanner = new Scanner(inputString);
        assertTrue(createTriangleSides(testScanner) == null);
    }

    @Test
    void TestCreateTrianglePoints1() {
        String inputString = "1 1\n2 2\n2 A\n";
        Scanner testScanner = new Scanner(inputString);
        assertThrows(Exception.class, () -> {createTrianglePoints(testScanner);});
    }

    @Test
    void TestCreateTrianglePoints2() {
        String inputString = "1 1\n1 1\n1 1\n";
        Scanner testScanner = new Scanner(inputString);
        assertTrue(createTrianglePoints(testScanner) == null);
    }
}