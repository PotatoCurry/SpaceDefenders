// Damian Lall
// This file contains several useful methods I often use in my own programs.

/*/
 * This code is provided without charge, and is redistributable with the condition that it remains in its original state with no modifications.
 * In addition, this code is distributed without any warranty, including those of merchantability or fitness for a particular purpose.
/*/

package MethodsDL;

import java.io.*;
import java.util.*;

public class FileDL extends MethodsDL {
    
    public static void Info() {
        System.out.println("Author: " + author);
        Delay(250);
        System.out.println("Version: " + version);
        Delay(250);
        System.out.println("Main Class: MethodsDL");
    }
    
    public static void Commands() {
        System.out.println("Info(): Provides general information regarding the MathDL class.");
        System.out.println("Commands(): Provides a list of MathDL commands and their uses.");
        System.out.println("PrintFile(File file): Prints the complete contents of a file.");
    }
    /*
	public static void PrintFile(File file) throws Exception {
    	while (file.hasNext()) {
    		System.out.println(file.nextLine());
        }
    }
	*/
	public static void PrintFile(String fileName) throws Exception {
		Scanner file = new Scanner(new File(fileName));
    	while (file.hasNext()) {
    		System.out.println(file.nextLine());
        }
    }  
}