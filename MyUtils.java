/*
 * Name: Thomas C.
 * Section Letter: CS 2 Summer 2022
 * Assignment #: Assignment 5
 * Description: MyUtils class that is necessary for completing the 
 * 			    Game of Life assignment.
 * Classname: MyUtils
 * Date: 7/7/2022 (Extension 3, see email)
 */

package DragonFractal;

import java.util.*;
import java.io.*;

public class MyUtils {
	
	/*
	 * Reads from a file
	 * 
	 * @param f: the file that needs to be read
	 * @return scan: the scanner object for reading
	 */
	public static Scanner readFile(File f) {
		Scanner scan = null;
		
		//try catch block to catch any potential file reading errors
		try {
			scan = new Scanner(f);
		} 
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		} 
		
		return scan;
	}
		
	/*
	 * Writes the desired string to the file
	 * 
	 * @param f: the file that needs to be written to
	 * @param str: the string that is to be written into the file
	 * @return writer: the filewriter object
	 */
	public static FileWriter writeFile(File f, String str) {
		FileWriter writer = null;
		
		//try catch block to catch any potential file writing errors
		try {
			writer = new FileWriter(f);
			writer.write(str);
		} 
		
		catch(IOException e){
			e.printStackTrace();
		}
		
		return writer;
	}
}