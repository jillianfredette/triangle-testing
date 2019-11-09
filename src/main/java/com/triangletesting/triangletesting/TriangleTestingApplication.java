package com.triangletesting.triangletesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class TriangleTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriangleTestingApplication.class, args);
		
		Scanner StdIn = new Scanner(System.in);

		//get choice (1 or 2)
        int choice = getChoice(StdIn);

		//create triangle
        Triangle triangle = createTriangle(choice, StdIn);
	}

	//method to get the choice of input (sides or points)
	public static int getChoice(Scanner StdIn){

        System.out.println("Choices for triangle creation:");
        System.out.println("1. Enter the lengths of the three sides");
        System.out.println("2. Enter the three Cartesian points of the triangle");

        System.out.println("Enter either '1' or '2' for your selection, then press Enter");

	    int choice = 0;

        while(!(choice == 1 || choice == 2)) {
            String choiceInput = StdIn.nextLine();
            try {
                choice = Integer.parseInt(choiceInput);
                if (!(choice == 1 || choice == 2)) {
                    throw new Exception("Wrong number");
                }

            } catch (Exception e) {
                System.out.println("Incorrect input format, please try again");
                System.out.println("Enter either '1' or '2' for your selection, then press Enter");
            }
        }

        return choice;
    }

    //method to create the triangle
    public static Triangle createTriangle(int choice, Scanner StdIn){
	    if(choice == 1) return createTriangleSides(StdIn);
	    else if(choice == 2) return createTrianglePoints(StdIn);
	    return null;
    }

    //method to create the triangle with sides
    public static Triangle createTriangleSides(Scanner StdIn){
        Triangle triangle;
        double[] sides = new double[3];
	    int i = 0;
        System.out.println("Enter the length of the sides of the triangle one at a time, pressing Enter between sides.");
        while (i < 3) {
            String sideEntry = StdIn.nextLine();
            try {
                sides[i] = Double.parseDouble(sideEntry);
                i++;
            } catch (Exception e) {
                System.out.println("Incorrect input format, please try again");
                System.out.println("Enter the length of the sides of the triangle one at a time, pressing Enter between sides.");
            }
        }
        try{
            triangle = new Triangle(sides[0], sides[1], sides[2]);
            triangle.printType();
            return triangle;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //method to create the triangle with points
    public static Triangle createTrianglePoints(Scanner StdIn){
	    int i = 0;
        double[] pointEntry = new double[6];
        Point[] points = new Point[3];
        Triangle triangle;

        System.out.println("Enter the points of the triangle, separating x and y coordinates by spaces ('x y'). " +
                "Press Enter after each point");
        while (i < 6) {
            String pointinput = StdIn.nextLine();
            try {
                String[] strs = pointinput.trim().split("\\s+");
                double x = Double.parseDouble(strs[0]);
                double y = Double.parseDouble(strs[1]);
                pointEntry[i] = x;
                pointEntry[i+1] = y;
                i+=2;
            } catch (Exception e) {
                System.out.println("Incorrect input format, please try again");
                System.out.println("Enter the points of the triangle, separating x and y coordinates by spaces ('x y'). " +
                        "Press Enter after each point");
            }
        }
        //create points & then create triangle
        int j = 0;
        for(int k = 0; k < 6; k+=2){
            points[j] = new Point(pointEntry[k],pointEntry[k+1]);
            j++;
        }

        try{
            triangle = new Triangle(points[0], points[1], points[2]);
            triangle.printType();
            return triangle;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
