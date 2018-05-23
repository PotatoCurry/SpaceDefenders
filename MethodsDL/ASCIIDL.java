// Damian Lall
// This file contains several useful methods I often use in my own programs.

// Damian Lall
// This file contains several useful methods I often use in my own programs.

/*/
 * This code is provided without charge, and is redistributable with the condition that it remains in its original state with no modifications.
 * In addition, this code is distributed without any warranty, including those of merchantability or fitness for a particular purpose.
/*/

package MethodsDL;

public class ASCIIDL extends MethodsDL {
	
    public static void Info() {
        System.out.println("Author: " + author);
        Delay(250);
        System.out.println("Version: " + version);
        Delay(250);
        System.out.println("Main Class: MethodsDL");
        Delay(250);
        System.out.println("Other Classes: MathDL");
    }
    
    public static void Commands() {
        System.out.println("Info(): Provides general information regarding the ASCIIDL class.");
        System.out.println("Commands(): Provides a list of ASCIIDL commands and their uses.");
        System.out.println("ASCII(String text, boolean slow): Displays the inputted text as large ASCII-based characters.");
    }
    
	private static String level1 = "";
	private static String level2 = "";
	private static String level3 = "";
	private static String level4 = "";
	private static String level5 = "";
	private static String level6 = "";
    
    //Menus
	    public static void ASCII(String text, boolean slow) {
	        char[] textArray = text.toUpperCase().toCharArray();
	        
	        level1 = "";
	        level2 = "";
	        level3 = "";
	        level4 = "";
	        level5 = "";
	        level6 = "";
	        
	        //Draw/Find
	    	for (int i = 0; i < textArray.length; i++) {
	    		switch (textArray[i]) {
	    		case '1': drawOne();
	        	break;
	        	case '2': drawTwo();
	        	break;
	        	case '3': drawThree();
	        	break;
	        	case '4': drawFour();
	        	break;
	        	case '5': drawFive();
	        	break;
	        	case '6': drawSix();
	        	break;
	        	case '7': drawSeven();
	        	break;
	        	case '8': drawEight();
	        	break;
	        	case '9': drawNine();
	        	break;
	        	case 'A': drawA();
	        	break;
	        	case 'B': drawB();
	        	break;
	        	case 'C': drawC();
	        	break;
	        	case 'D': drawD();
	        	break;
	        	case 'E': drawE();
	        	break;
	        	case 'F': drawF();
	        	break;
	        	case 'G': drawG();
	        	break;
	        	case 'H': drawH();
	        	break;
	        	case 'I': drawI();
	        	break;
	        	case 'J': drawJ();
	        	break;
	        	case 'K': drawK();
	        	break;
	        	case 'L': drawL();
	        	break;
	        	case 'M': drawM();
	        	break;
	        	case 'N': drawN();
	        	break;
	        	case 'O': drawO();
	        	break;
	        	case 'P': drawP();
	        	break;
	        	case 'Q': drawQ();
	        	break;
	        	case 'R': drawR();
	        	break;
	        	case 'S': drawS();
	        	break;
	        	case 'T': drawT();
	        	break;
	        	case 'U': drawU();
	        	break;
	        	case 'V': drawV();
	        	break;
	        	case 'W': drawW();
	        	break;
	        	case 'X': drawX();
	        	break;
	        	case 'Y': drawY();
	        	break;
	        	case 'Z': drawZ();
	        	break;
	        	case ' ': drawSpace();
	        	break;
	        	case '.': drawPeriod();
	        	break;
	        	case '!': drawExclamation();
	        	break;
	        	case '?': drawQuestion();
	        	break;
	        	case ',': drawComma();
	        	break;
	        	case '\'': drawApostrophe();
	        	break;
	        	case '=': drawEquals();
	        	break;
	        	case '<': drawLess();
	        	break;
	        	case '>': drawMore();
	        	break;
	        	case '/': drawForward();
	        	break;
	        	case '\\': drawBack();
	        	break;
	        	case ':': drawColon();
	        	break;
	        	case ';': drawSemicolon();
	        	break;
	        	case '(': drawOpenParenthesis();
	        	break;
	        	case ')': drawCloseParenthesis();
	        	break;
	        	case '\"': drawQuotes();
	        	break;
	        	case '@': drawAt();
	        	break;
	        	case '#': drawNumber();
	        	break;
	        	case '$': drawDollar();
	        	break;
	        	case '%': drawPercent();
	        	break;
	        	case '^': drawUp();
	        	break;
	        	case '&': drawAnd();
	        	break;
	        	case '*': drawAsterisk();
	        	break;
	        	default: System.out.println("Error - Invalid Charachter");
	        	}
	    	}
	    	
	    	if (level1.length() > 79) {
	    		level1 = level1.substring(0, 79);
	    		level2 = level2.substring(0, 79);
	    		level3 = level3.substring(0, 79);
	    		level4 = level4.substring(0, 79);
	    		level5 = level5.substring(0, 79);
	    		level6 = level6.substring(0, 79);
	    	}	    	
			
	    	//Print Levels
                if (slow) {
                    Delay(200);
                    System.out.println(level1);
                    Delay(200);
                    System.out.println(level2);
                    Delay(200);
                    System.out.println(level3);
                    Delay(200);
                    System.out.println(level4);
                    Delay(200);
                    System.out.println(level5);
                    Delay(200);
                    System.out.println(level6);
                } else {
                    System.out.println(level1);
                    System.out.println(level2);
                    System.out.println(level3);
                    System.out.println(level4);
                    System.out.println(level5);
                    System.out.println(level6);
                }
            }
		
    //Numbers
	    private static void drawOne() {
	    	level1 += " __ ";
	    	level2 += "/_ |";
	    	level3 += " | |";
	    	level4 += " | |";
	    	level5 += " | |";
	    	level6 += " |_|";
	    }
	    
	    private static void drawTwo() {
	    	level1 += " ___  ";
	    	level2 += "|__ \\ ";
	    	level3 += "   ) |";
	    	level4 += "  / / ";
	    	level5 += " / /_ ";
	    	level6 += "|____|";
	    }
	    
	    private static void drawThree() {
	    	level1 += " ____  ";
	    	level2 += "|___ \\ ";
	    	level3 += "  __) |";
	    	level4 += " |__ < ";
	    	level5 += " ___) |";
	    	level6 += "|____/ ";
	    }
	    
	    private static void drawFour() {
	    	level1 += " _  _   ";
	    	level2 += "| || |  ";
	    	level3 += "| || |_ ";
	    	level4 += "|__   _|";
	    	level5 += "   | |  ";
	    	level6 += "   |_|  ";
	    }
	    
	    private static void drawFive() {
	    	level1 += " _____ ";
	    	level2 += "| ____|";
	    	level3 += "| |__  ";
	    	level4 += "|___ \\ ";
	    	level5 += " ___) |";
	    	level6 += "|____/ ";
	    }
	    
	    private static void drawSix() {
	    	level1 += "   __  ";
	    	level2 += "  / /  ";
	    	level3 += " / /_  ";
	    	level4 += "| '_ \\ ";
	    	level5 += "| (_) |";
	    	level6 += " \\___/ ";
	    }
	    
	    private static void drawSeven() {
	    	level1 += " ______ ";
	    	level2 += "|____  |";
	    	level3 += "    / / ";
	    	level4 += "   / /  ";
	    	level5 += "  / /   ";
	    	level6 += " /_/    ";
	    }
	    
	    private static void drawEight() {
	    	level1 += "  ___  ";
	    	level2 += " / _ \\ ";
	    	level3 += "| (_) |";
	    	level4 += " > _ < ";
	    	level5 += "| (_) |";
	    	level6 += " \\___/ ";
	    }
	    
	    private static void drawNine() {
	    	level1 += "  ___  ";
	    	level2 += " / _ \\ ";
	    	level3 += "| (_) |";
	    	level4 += " \\__, |";
	    	level5 += "   / / ";
	    	level6 += "  /_/  ";
	    }
	    
    
    //Letters
	    private static void drawA() {
	    	level1 += "          ";
	    	level2 += "    /\\    ";
	    	level3 += "   /  \\   ";
	    	level4 += "  / /\\ \\  ";
	    	level5 += " / ____ \\ ";
	    	level6 += "/_/    \\_\\";
	    }
	    
	    private static void drawB() {
	    	level1 += " ____  ";
	    	level2 += "|  _ \\ ";
	    	level3 += "| |_) |";
	    	level4 += "|  _ < ";
	    	level5 += "| |_) |";
	    	level6 += "|____/ ";
	    }
	    
	    private static void drawC() {
	    	level1 += "  _____ ";
	    	level2 += " / ____|";
	    	level3 += "| |     ";
	    	level4 += "| |     ";
	    	level5 += "| |____ ";
	    	level6 += " \\_____|";
	    }
	    
	    private static void drawD() {
	    	level1 += " _____  ";
	    	level2 += "|  __ \\ ";
	    	level3 += "| |  | |";
	    	level4 += "| |  | |";
	    	level5 += "| |__| |";
	    	level6 += "|_____/ ";
	    }
	    
	    private static void drawE() {
	    	level1 += " ______ ";
	    	level2 += "|  ____|";
	    	level3 += "| |__   ";
	    	level4 += "|  __|  ";
	    	level5 += "| |____ ";
	    	level6 += "|______|";
	    }
	    
	    private static void drawF() {
	    	level1 += " ______ ";
	    	level2 += "|  ____|";
	    	level3 += "| |__   ";
	    	level4 += "|  __|  ";
	    	level5 += "| |     ";
	    	level6 += "|_|     ";
	    }
	    
	    private static void drawG() {
	    	level1 += "  _____ ";
	    	level2 += " / ____|";
	    	level3 += "| |  __ ";
	    	level4 += "| | |_ |";
	    	level5 += "| |__| |";
	    	level6 += " \\_____|";
	    }
	    
	    private static void drawH() {
	    	level1 += " _    _ ";
	    	level2 += "| |  | |";
	    	level3 += "| |__| |";
	    	level4 += "|  __  |";
	    	level5 += "| |  | |";
	    	level6 += "|_|  |_|";
	    }
	    
	    private static void drawI() {
	    	level1 += " _____ ";
	    	level2 += "|_   _|";
	    	level3 += "  | |  ";
	    	level4 += "  | |  ";
	    	level5 += " _| |_ ";
	    	level6 += "|_____|";
	    }
	    
	    private static void drawJ() {
	    	level1 += "      _ ";
	    	level2 += "     | |";
	    	level3 += "     | |";
	    	level4 += " _   | |";
	    	level5 += "| |__| |";
	    	level6 += " \\____/ ";
	    }
	    
	    private static void drawK() {
	    	level1 += " _  __";
	    	level2 += "| |/ /";
	    	level3 += "| ' / ";
	    	level4 += "|  <  ";
	    	level5 += "| . \\ ";
	    	level6 += "|_|\\_\\";
	    }
	    
	    private static void drawL() {
	    	level1 += " _      ";
	    	level2 += "| |     ";
	    	level3 += "| |     ";
	    	level4 += "| |     ";
	    	level5 += "| |____ ";
	    	level6 += "|______|";
	    }
	    
	    private static void drawM() {
	    	level1 += " __  __ ";
	    	level2 += "|  \\/  |";
	    	level3 += "| \\  / |";
	    	level4 += "| |\\/| |";
	    	level5 += "| |  | |";
	    	level6 += "|_|  |_|";
	    }
	    
	    private static void drawN() {
	    	level1 += " _   _ ";
	    	level2 += "| \\ | |";
	    	level3 += "|  \\| |";
	    	level4 += "| . ` |";
	    	level5 += "| |\\  |";
	    	level6 += "|_| \\_|";
	    }
	    
	    private static void drawO() {
	    	level1 += "  ____  ";
	    	level2+= " / __ \\ ";
	    	level3+= "| |  | |";
	    	level4+= "| |  | |";
	    	level5+= "| |__| |";
	    	level6+= " \\____/ ";
	    }
	    
	    private static void drawP() {
	    	level1 += " _____  ";
	    	level2+= "|  __ \\ ";
	    	level3+= "| |__) |";
	    	level4+= "|  ___/ ";
	    	level5+= "| |     ";
	    	level6+= "|_|     ";
	    }
	    
	    private static void drawQ() {
	    	level1 += "  ____  ";
	    	level2 += " / __ \\ ";
	    	level3+= "| |  | |";
	    	level4+= "| |  | |";
	    	level5+= "| |__| |";
	    	level6+= " \\___\\_\\";
	    }
	    
	    private static void drawR() {
	    	level1 += " _____  ";
	    	level2 += "|  __ \\ ";
	    	level3 += "| |__) |";
	    	level4 += "|  _  / ";
	    	level5 += "| | \\ \\ ";
	    	level6 += "|_|  \\_\\";
	    }
	    
	    private static void drawS() {
	    	level1 += "  _____ ";
	    	level2 += " / ____|";
	    	level3 += "| (___  ";
	    	level4 += " \\___ \\ ";
	    	level5 += " ____) |";
	    	level6 += "|_____/ ";
	    }
	    
	    private static void drawT() {
	    	level1 += " _______ ";
	    	level2 += "|__   __|";
	    	level3 += "   | |   ";
	    	level4 += "   | |   ";
	    	level5 += "   | |   ";
	    	level6 += "   |_|   ";
	    }
	    
	    private static void drawU() {
	    	level1 += " _    _ ";
	    	level2 += "| |  | |";
	    	level3 += "| |  | |";
	    	level4 += "| |  | |";
	    	level5 += "| |__| |";
	    	level6 += " \\____/ ";
	    }
	    
	    private static void drawV() {
	    	level1 += "__      __";
	    	level2 += "\\ \\    / /";
	    	level3 += " \\ \\  / / ";
	    	level4 += "  \\ \\/ /  ";
	    	level5 += "   \\  /   ";
	    	level6 += "    \\/    ";
	    }
	    
	    private static void drawW() {
	    	level1 += "__          __";
	    	level2 += "\\ \\        / /";
	    	level3 += " \\ \\  /\\  / / ";
	    	level4 += "  \\ \\/  \\/ /  ";
	    	level5 += "   \\  /\\  /   ";
	    	level6 += "    \\/  \\/    ";
	    }
	    
	    private static void drawX() {
	    	level1 += "__   __";
	    	level2 += "\\ \\ / /";
	    	level3 += " \\ ' / ";
	    	level4 += "  > <  ";
	    	level5 += " / . \\ ";
			level6 += "/_/ \\_\\";
	    }
	    
	    private static void drawY() {
	    	level1 += "__     __";
	    	level2 += "\\ \\   / /";
	    	level3 += " \\ \\_/ / ";
	    	level4 += "  \\   /  ";
	    	level5 += "   | |   ";
	    	level6 += "   |_|   ";
	    }
	    
	    private static void drawZ() {
	    	level1 += " ______";
	    	level2 += "|___  /";
	    	level3 += "   / / ";
	    	level4 += "  / /  ";
	    	level5 += " / /__ ";
	    	level6 += "/_____|";
	    }
	    
	    
	 //Symbols
	    private static void drawSpace() {
	    	level1 += "       ";
	    	level2 += "       ";
	    	level3 += "       ";
	    	level4 += "       ";
	    	level5 += "       ";
	    	level6 += "       ";
	    }
	    
	    private static void drawPeriod() {
	    	level1 += "   ";
	    	level2 += "   ";
	    	level3 += "   ";
	    	level4 += "   ";
	    	level5 += " _ ";
	    	level6 += "(_)";
	    }
	    
	    private static void drawExclamation() {
	    	level1 += " _ ";
	    	level2 += "| |";
	    	level3 += "| |";
	    	level4 += "| |";
	    	level5 += "|_|";
	    	level6 += "(_)";
	    }
	    
	    private static void drawQuestion() {
	    	level1 += " ___  ";
	    	level2 += "|__ \\ ";
	    	level3 += "   ) |";
	    	level4 += "  / / ";
	    	level5 += " |_|  ";
	    	level6 += " (_)  ";
	    }
	    
	    private static void drawComma() {
	    	level1 += "   ";
	    	level2 += "   ";
	    	level3 += "   ";
	    	level4 += " _ ";
	    	level5 += "( )";
	    	level6 += "|/ ";
	    }
	    
	    private static void drawApostrophe() {
	    	level1 += " _ ";
	    	level2 += "( )";
	    	level3 += "|/ ";
	    	level4 += "   ";
	    	level5 += "   ";
	    	level6 += "   ";
	    }
	    
	    private static void drawEquals() {
	    	level1 += "        ";
	    	level2 += " ______ ";
	    	level3 += "|______|";
	    	level4 += " ______ ";
	    	level5 += "|______|";
	    	level6 += "        ";
	    }
	    
	    private static void drawLess() {
	    	level1 += "   __";
	    	level2 += "  / /";
	    	level3 += " / / ";
	    	level4 += "< <  ";
	    	level5 += " \\ \\ ";
	    	level6 += "  \\_\\";
	    }
	    
	    private static void drawMore() {
	    	level1 += "__   ";
	    	level2 += "\\ \\  ";
	    	level3 += " \\ \\ ";
	    	level4 += "  > >";
	    	level5 += " / / ";
	    	level6 += "/_/  ";
	    }
	    
	    private static void drawForward() {
	    	level1 += "     __";
	    	level2 += "    / /";
	    	level3 += "   / / ";
	    	level4 += "  / /  ";
	    	level5 += " / /   ";
	    	level6 += "/_/    ";
	    }
	    
	    private static void drawBack() {
	    	level1 += "__     ";
	    	level2 += "\\ \\    ";
	    	level3 += " \\ \\   ";
	    	level4 += "  \\ \\  ";
	    	level5 += "   \\ \\ ";
	    	level6 += "    \\_\\";
	    }
	    
	    private static void drawColon() {
	    	level1 += " _ ";
	    	level2 += "(_)";
	    	level3 += "   ";
	    	level4 += " _ ";
	    	level5 += "(_)";
	    	level6 += "   ";
	    }
	    
	    private static void drawSemicolon() {
	    	level1 += " _ ";
	    	level2 += "(_)";
	    	level3 += "   ";
	    	level4 += " _ ";
	    	level5 += "( )";
	    	level6 += "|/ ";
	    }
	    
	    private static void drawOpenParenthesis() {
	    	level1 += "  __";
	    	level2 += " / /";
	    	level3 += "| | ";
	    	level4 += "| | ";
	    	level5 += "| | ";
	    	level6 += " \\_\\";
	    }
	    
	    private static void drawCloseParenthesis() {
	    	level1 += "__  ";
	    	level2 += "\\ \\ ";
	    	level3 += " | |";
	    	level4 += " | |";
	    	level5 += " | |";
	    	level6 += "/_/ ";
	    }
	    
	    private static void drawQuotes() {
	    	level1 += " _ _ ";
	    	level2 += "( | )";
	    	level3 += " V V ";
	    	level4 += "     ";
	    	level5 += "     ";
	    	level6 += "     ";
	    }
	    
	    private static void drawAt() {
	    	level1 += "   ____  ";
	    	level2 += "  / __ \\ ";
	    	level3 += " / / _` |";
	    	level4 += "| | (_| |";
	    	level5 += " \\ \\__,_|";
	    	level6 += "  \\____/ ";
	    }
	    
	    private static void drawNumber() {
	    	level1 += "   _  _   ";
	    	level2 += " _| || |_ ";
	    	level3 += "|_  __  _|";
	    	level4 += " _| || |_ ";
	    	level5 += "|_  __  _|";
	    	level6 += "  |_||_|  ";
	    }
	    
	    private static void drawDollar() {
	    	level1 += "  _  ";
	    	level2 += " | | ";
	    	level3 += "/ __)";
	    	level4 += "\\__ \\";
	    	level5 += "(   /";
	    	level6 += " |_| ";
	    }
	    
	    private static void drawPercent() {
	    	level1 += " _   __";
	    	level2 += "(_) / /";
	    	level3 += "   / / ";
	    	level4 += "  / /  ";
	    	level5 += " / / _ ";
	    	level6 += "/_/ (_)";
	    }
	    
	    private static void drawUp() {
	    	level1 += "  /  \\  ";
	    	level2 += " / /\\ \\ ";
	    	level3 += "/_/  \\_\\";
	    	level4 += "        ";
	    	level5 += "        ";
	    	level6 += "        ";
	    }
	    
	    private static void drawAnd() {
	    	level1 += "        ";
	    	level2 += "  ___   ";
	    	level3 += " ( _ )  ";
	    	level4 += " / _ \\/\\";
	    	level5 += "| (_>  <";
	    	level6 += " \\___/\\/";
	    }
	    
	    private static void drawAsterisk() {
	    	level1 += "    _    ";
	    	level2 += " /\\| |/\\ ";
	    	level3 += " \\     / ";
	    	level4 += "|_     _|";
	    	level5 += " /     \\ ";
	    	level6 += " \\/|_|\\/ ";
	    }
}