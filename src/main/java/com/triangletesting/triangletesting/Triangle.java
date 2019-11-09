package com.triangletesting.triangletesting;
import java.util.Arrays;

public class Triangle {

    String type;
    double sidea, sideb, sidec;

    //constructor for sides
    public Triangle(double a, double b, double c) throws Exception{

        //check for non-negative sides
        if(a <= 0 || b <= 0 || c <= 0){
            throw new Exception("All sides of a triangle must be positive, no triangle was created.");
        }

        //check for a valid triangle
        if((a+b <= c ) || (b+c <= a) || (a+c <= b)){
            throw new Exception("These three side lengths do not create a valid triangle, no triangle was created.");
        }

        double[] sides = {a,b,c};
        Arrays.sort(sides);

        sidea = sides[0];
        sideb = sides[1];
        sidec = sides[2];

        type = "";

        //determine triangle type
        if(Math.abs(Math.pow(sidea, 2.0)+Math.pow(sideb, 2.0) - Math.pow(sidec, 2.0)) < 0.00001){
            type = type + "Right ";
        }
        if(sidea == sideb && sideb == sidec){
            type = type + "Equilateral";
        }
        else if(sidea == sideb || sideb == sidec){
            type = type + "Isosceles";
        }
        else{
            type = type + "Scalene";
        }

    }

    //constructor for points, finds the lengths of the three sides from the points and calls the side constructor
    public Triangle(Point a, Point b, Point c) throws Exception {
        this(Math.sqrt(Math.pow((b.getX()-a.getX()),2)+Math.pow((b.getY()-a.getY()),2)),
                Math.sqrt(Math.pow((a.getX()-c.getX()),2)+Math.pow((a.getY()-c.getY()),2)),
                Math.sqrt(Math.pow((c.getX()-b.getX()),2)+Math.pow((c.getY()-b.getY()),2)));
    }

    //function to print the triangle type
    public void printType(){
        System.out.println("\nTriangle type is: " + type);
    }

    public String getType(){
        return type;
    }

    //function to get the area of the triangle
    public double getArea(){
        double s = (sidea+sideb+sidec)/2;
        double area = Math.sqrt(s*(s-sidea)*(s-sideb)*(s-sidec));

        return area;
    }
}
