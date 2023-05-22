/* SAMANTHA MAC
 * TEAM 6; Samantha Mac, Ian Lee, Abishan Shanmuhesan
 * May 15, 2023
 * ICS3U1
 * 
 * FILE INPUT CLASS
 * 
 * DESCRIPTION: This file reads data from the 
 * Laptop.txt file and allows programmers to
 * store it in an array and display/sort that
 * array
 * 
 * MAJOR SKILLS
 * Importing txt file, using Scanner to read txt file,
 * try and catch blocks/exceptions, delimiters to separate
 * strings, for loop, arrays consisting of objects, 
 * 
 * CONTRIBUTION (for this file): 100% by Sam
 * 
 * AREAS OF CONCERN
 * None.
 * 
 * SCROLL TO BOTTOM FOR ADDED FEATURES
 */ 

// Import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Public class
public class FileInput {
	// Create an array to hold laptop objects
	static Laptop[] laptopArray = new Laptop[24];
	
	// Main method
	public static void main(String[] args) {
		// Create Scanner object
		Scanner sc = new Scanner(System.in);	
		// Fill array with laptop objects
		fillInventory();
		displayArray();
	}
	
	// Create method that reads txt file
	public static void fillInventory() {
		// If txt file exists/ is accessible
		try {
			// Read txt using Scanner
			Scanner inputFile = new Scanner(new File("data/Laptop.txt"));
			// Delimit to read each line of the txt file
			inputFile.useDelimiter(",|\r\n");
			// Use a for loop to read and assign the value of each field
			// of each laptop object
			for(int index = 0; index < laptopArray.length; index++) {
				// Store value in corresponding var
				String brand = inputFile.next();
				String model = inputFile.next();
				String type = inputFile.next();
				double sale = inputFile.nextDouble();
				double cost = inputFile.nextDouble();
				String os = inputFile.next();
				String cpu = inputFile.next();
				String gpu = inputFile.next();
				int ssd = inputFile.nextInt();
				int ram = inputFile.nextInt();
				double weight = inputFile.nextDouble();
				int usb = inputFile.nextInt();
				String resolution = inputFile.next();
				double display = inputFile.nextDouble();
				int score = inputFile.nextInt();
				double rating = inputFile.nextDouble();
				int id = inputFile.nextInt();
				String source = inputFile.nextLine();

				
				// Create a Laptop object in the laptopArray
				// with the above values passed as parameters
				laptopArray[index] = new Laptop(brand, model, type, sale, cost, os, 
						cpu, gpu, ssd, ram, weight, usb, resolution, display, score, rating, id, source);
			}
			// Close file
			inputFile.close();
			
		} catch (FileNotFoundException e) {
			// Print if txt file not found
			System.out.println("File error");
		}
		
	}
	
	// print title
	public static void displayHeader() {
		System.out.println("LAPTOP INVENTORY");
		System.out.println("===================="
				+ "=================\n");
	}
	
	// Print array
	public static void displayArray() {
		// Sort the array alphabetically
		Arrays.sort(laptopArray, Comparator.comparing(Laptop::getModel));
		// Use enhanced for loop to print each hero
		for (Laptop laptop : laptopArray) {
			// Print each one as loop cycles
			System.out.println(laptop);
		}
	}
}

//ADDED FEATURES
/* I used to have a method that allowed programmers
* to display a specific property of a specific laptop object
* (Ex. brand of laptop #5). However, I moved that method
* to my individual file as the method needs to be modified
* for certain uses. I will provide my team mates with the method
* in a separate file.
*/

//This is the code
//			public static Laptop[] getChosenLaptops(int[] indexes) {
//				Laptop[] chosenLaptops = new Laptop[indexes.length];
//				
//				int count = 0;
//				
//				for (int i=0; i<indexes.length; i++)  {
//					for (int k=0; k<FileInput.laptopArray.length; k++) {
//						if (indexes[i]==k) {
//							chosenLaptops[count] = FileInput.laptopArray[k];
//						}
//					}
//					count++;
//				} 
//				
//				return chosenLaptops;
//			}
