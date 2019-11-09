package com.triangletesting.triangletesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class TriangleTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriangleTestingApplication.class, args);


		Scanner StdIn = new Scanner(System.in);



		double[] sides = new double[3];
		double[] pointentry = new double[6];
		Point[] points = new Point[3];
		int i = 0;
		int tries = 0;
		Triangle triangle;

		int choice = 0;
		System.out.println("Choices for triangle creation:");
		System.out.println("1. Enter the lengths of the three sides");
		System.out.println("2. Enter the three Cartesian points of the triangle");

		System.out.println("Enter either '1' or '2' for your selection, then press Enter");


		//get choice (1 or 2)
		while(!(choice == 1 || choice == 2)) {
			String choiceinput = StdIn.nextLine();
			try {
				choice = Integer.parseInt(choiceinput);
				if (!(choice == 1 || choice == 2)) {
					throw new Exception("Wrong number");
				}

			} catch (Exception e) {
				if (tries > 3) {
					System.out.println("Too many incorrect inputs, ending program.");
					System.exit(0);
				}
				System.out.println("Incorrect input format, please try again");
				tries++;
			}
		}

		tries = 0;
		//create triangle with side lengths
		if(choice == 1) {
			System.out.println("Enter the length of the sides of the triangle one at a time, pressing Enter between sides.");
			while (i < 3) {
				String sideinput = StdIn.nextLine();
				try {
					sides[i] = Double.parseDouble(sideinput);
					i++;
				} catch (Exception e) {
					if (tries > 3) {
						System.out.println("Too many incorrectly formatted inputs, ending program.");
						System.exit(0);
					}
					System.out.println("Incorrect input format, please try again");
					tries++;
				}
			}
			//Arrays.sort(sides);
			try{
				triangle = new Triangle(sides[0], sides[1], sides[2]);
				triangle.printType();
			}
			catch (Exception e){
				System.out.println(e);
			}
		}

		tries = 0;
		//create triangle with points
		if(choice == 2) {
			System.out.println("Enter the points of the triangle, separating x and y coordinates by spaces ('x y'). " +
					"Press Enter after each point");
			while (i < 6) {
				String pointinput = StdIn.nextLine();
				try {
					String[] strs = pointinput.trim().split("\\s+");
					double x = Double.parseDouble(strs[0]);
					double y = Double.parseDouble(strs[1]);
					pointentry[i] = x;
					pointentry[i+1] = y;
					i+=2;
				} catch (Exception e) {
					if (tries > 3) {
						System.out.println("Too many incorrectly formatted inputs, ending program.");
						System.exit(0);
					}
					System.out.println("Incorrect input format, please try again");
					tries++;
				}
			}
			//create points & then create triangle
			int j = 0;
			for(int k = 0; k < 6; k+=2){
				points[j] = new Point(pointentry[k],pointentry[k+1]);
				j++;
			}

			try{
				triangle = new Triangle(points[0], points[1], points[2]);

				triangle.printType();
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
	}
}
