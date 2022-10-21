/*
 * Name: Thomas C.
 * Section Letter: CS 2 Summer 2022
 * Assignment #: Assignment 6
 * Description: Generating a Heighway Dragon curve from a string in Drawing Panel
 * Classname: DragonGenerate
 * Date: 7/8/2022
 */

package DragonFractal;

import java.util.*;
import java.io.*;
import java.awt.*;

public class DragonGenerate {
	
	//instance vars
	private static int fractalSize;
	private static int panelSize;
	
	//required instance vars
	private static int minDragonSize = 1;
	private static int maxDragonSize = 25;
	private static int minPanelSize = 100;
	private static int maxPanelSize = 2000;
	private static String baseOutputName = "dragon";
	private static String baseExtensionName = ".txt";

	
	/*
	 * Main method. Calls userInput, generateDragon, writeFile and drawDragon methods to gather
	 * information from user, to generate the string for the dragon's creation, to write that
	 * information to the file and to finally draw the dragon curve on a drawing panel
	 */
	public static void main(String[] args) {
		userInput();
		
		//specification says i should assume all files are already in same package
		File file = new File(baseOutputName + Integer.toString(fractalSize) + baseExtensionName);
		
		generateDragon(fractalSize);
		MyUtils.writeFile(file, generateDragon(fractalSize));
		System.out.println();

		System.out.println("Path generated, writing to file " + file.toString());
		System.out.println("Drawing curve...");
		
		drawDragon();
	}
	
	/*
	 * Method to display initial information and to gather user input. If user input
	 * is faulty, then the method will reprompt the user until requirements are met.
	 */
	public static void userInput() {
		System.out.println("This program will generate a fractal called the Dragon Curve \nfirst explored by John Heighway, "
				+ "Bruce Banks, and William Harter \nat NASA in the 1960's");
		System.out.println();
		
		boolean isFinished = false;
		while (isFinished == false) {
			System.out.print("Enter the level of fractal you'd like to see (1-25): ");
			
			String input = scan().nextLine();
			
			try {
				fractalSize = Integer.parseInt(input);
				
				if (fractalSize < minDragonSize || fractalSize > maxDragonSize) {
					System.out.println("Your number needs to be between 1 and 25.");
				} else {
					isFinished = true;
				}

			} catch(NumberFormatException e) {
				System.out.println("You must enter an *integer* between 1 and 25.");
			}
		}
		
		isFinished = false;
		while (isFinished == false) {
			System.out.print("Enter the size of your drawing panel, in pixels (100-2000): ");
			
			String input = scan().nextLine();
			
			try {
				panelSize = Integer.parseInt(input);
				
				if (panelSize < minPanelSize || fractalSize > maxPanelSize) {
					System.out.println("Your number needs to be between 100 and 2000.");
				} else {
					isFinished = true;
				}

			} catch(NumberFormatException e) {
				System.out.println("You must enter an *integer* between 100 and 2000.");
			}	
		}
	}
	
	/*
	 * Creates scanner object for user input
	 * 
	 * @return scan: the scanner object
	 */
	public static Scanner scan() {
		Scanner scan = new Scanner(System.in);
		return scan;
	}
	
	/*
	 * Generates the reverse complement for the last string that it gets recursively.
	 * 
	 * @param lastString: the last string of the call stack
	 * @return newStr: the reverse complement of the last string
	 */
	public static String complement(String lastString)  {
		String newStr = "";
	    char letter = '\0'; //a null char?
	      
	    for (int i = lastString.length() - 1; i >= 0; i--) {
	    	letter = lastString.charAt(i);
	         
	        if (letter == 'L') {
	        	newStr += 'R';
	        	
	        } else if (letter == 'R') {
	            newStr += 'L';
	        }
	      }

	      return newStr;
	   }
	
	/*
	 * Generates the dragon curve string to determine how the curve grows.
	 * 
	 * @param size: the size of the dragon (fractalSize)
	 * @return concatenate: the concatenated version of the reverse complements
	 */
	public static String generateDragon(int size) {
		
		String concatenate	= "";
				
		if (size == 1) {
			return "R";

		} else {
			String previous = generateDragon(size - 1); //recursive part
			String nextComplement = complement(previous); //calls complement each time which makes the call stack
			concatenate = previous + "R" + nextComplement;
			System.out.print(concatenate);
		}
		
		return concatenate;
	}

	/*
	 * Draws the dragon on the drawing panel with the use of the string
	 * generated by the generateDragon method. 
	 */
	public static void drawDragon() { 
	    //DragonDraw draw = new DragonDraw(panelSize);
		//draw.drawCurve(baseOutputName + Integer.toString(fractalSize) + baseExtensionName);
	}
}