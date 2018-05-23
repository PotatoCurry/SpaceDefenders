// Damian Lall
// This file contains several useful methods I often use in my own programs.

/*/
 * This code is provided without charge, and is redistributable with the condition that it remains in its original state with no modifications.
 * In addition, this code is distributed without any warranty, including those of merchantability or fitness for a particular purpose.
/*/

package MethodsDL;

public class MathDL extends MethodsDL {
    
    public static void Info() {
        System.out.println("Author: " + author);
        Delay(250);
        System.out.println("Version: " + version);
        Delay(250);
        System.out.println("Main Class: MethodsDL");
        Delay(250);
        System.out.println("Other Classes: ASCIIDL");
    }
    
    //Unfinished List
    public static void Commands() {
        System.out.println("Info(): Provides general information regarding the MathDL class.");
        System.out.println("Commands(): Provides a list of MathDL commands and their uses.");
        System.out.println("CircleArea(double radius): Finds the area of a circle with the given radius.");
        System.out.println("RectangleArea(double length, double width): Finds the area of a rectangle with the given length and width.");
    }
    
    //Areas
	public static double CircleArea(double radius) {
            double circleArea = Math.PI * (radius * radius);
            return circleArea;
        }
	    
	public static double RectangleArea(double length, double width) {
	    double rectangleArea = length * width;
	    return rectangleArea;
	}
    
    //Volumes
        public static double ConeVolume(double radius, double height) {
	    double coneVolume = (1.0/3.0) * (Math.PI * (radius * radius)) * height;
	    return coneVolume;
	}
	    
	public static double CylinderVolume(double radius, double height) {
	    double cylinderVolume = (Math.PI * (radius * radius)) * height;
	    return cylinderVolume;
	}
	    
	public static double RectangularPrismVolume(double length, double width, double height) {
	    double prismVolume = length * width * height;
	    return prismVolume;
	}
	    
	public static double SphereVolume(double radius) {
	    double SphereVolume  = (Math.PI * (radius * radius * radius)) * (4.0/3.0);
	    return SphereVolume;
	}
    
    //Other 
	public static double PointDistance(double x1, double y1, double x2, double y2) {
	    double pointDistance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	    return pointDistance;
	    }
	    
	public static double NumberAverage(int intCount, double[] numList) {
	    double numSum = 0;
	    for (int i = 0; i <= numList.length; i++) {
	    	numSum += numList[i];
	    }
	    double numAverage = numSum / intCount;
	    return numAverage;
	}
	    
}