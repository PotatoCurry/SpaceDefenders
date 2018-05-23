// Damian Lall
// This file contains several useful methods I often use in my own programs.

/*/
 * This code is provided without charge, and is redistributable with the condition that it remains in its original state with no modifications.
 * In addition, this code is distributed without any warranty, including those of merchantability or fitness for a particular purpose.
/*/

package MethodsDL;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

//Generic Useful Methods
public class MethodsDL {
    
    public static void main(String args[]) {
        System.out.println();
    }
    
    static final String author = "Damian Lall";
    static final double version = 1.5;
    public static void Info() {
        System.out.println("Author: " + author);
        Delay(250);
        System.out.println("Version: " + version);
        Delay(250);
        System.out.println("Subclasses: MathDL, ASCIIDL, FileDL");
    }
    
    public static void Commands() {
        System.out.println("Info(): Provides general information regarding the MethodsDL class.");
        System.out.println("Commands(): Provides a list of MethodsDL commands and their uses.");
        System.out.println("Delay(int delayTime): Delays the program for the specified number of milliseconds.");
        System.out.println("Random(int min, int max): ");
    }
    
    public static void Delay(int delayTime) {
        try {
            TimeUnit.MILLISECONDS.sleep(delayTime);
        } catch (InterruptedException ex) {
	    Logger.getLogger(MethodsDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int Random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}