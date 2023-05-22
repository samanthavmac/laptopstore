/* SAMANTHA MAC
 * TEAM 6; Samantha Mac, Ian Lee, Abishan Shanmuhesan
 * May 15, 2023
 * ICS3U1
 * 
 * RESULTS APPLICATION CLASS (BACKEND)
 * 
 * DESCRIPTION: This file compares user survey results
 * to the laptop inventory and selects the top 3
 * more similar laptops. Also, opens GUI frames accordingly.
 * 
 * MAJOR SKILLS
 * Arrays, sorting arrays, if statements,
 * passing parameters between files,
 * value-returning methods, for loops,
 * if statements
 * 
 * CONTRIBUTION (for this file): 100% by Sam
 * 
 * AREAS OF CONCERN
 * None.
 * 
 * ADDED FEATURES
 * None.
 * 
 */ 

// Import statements
import java.util.Arrays;
import java.util.Comparator;

// Public class that handles backend
public class ResultsApplication {
	// Create an array that will store
	// three recommended laptops
	public static Laptop[] chosenLaptops = new Laptop[3];

	public static void main(String[] args) {
		// Create method that can be called
		// on from any file by invoking ResultsApplication.start()
		start();		
	}
	
	public static void start() {
		// Create instance of FileInput
		FileInput laptopArray = new FileInput(); 
		// Invoke method to fill array with laptop objects
		laptopArray.fillInventory();
		// Open survey frame
		new Survey(FileInput.laptopArray, chosenLaptops);	
	}
	
	// Method runs when survey is completed
	// Pass arrays as parameter
	public static void afterSubmit(String[] selections, Laptop[] laptopArray, Laptop[] chosenLaptops) {
		// Create array that track which laptop
		// is most similar
		int[] scoreArray = new int[24];
		
		// Declare int that tracks number of
		// similarities between each laptop and user input
		int count;
		
		// Create for loop that compares each laptop to survey results	
		for (int i = 0; i < FileInput.laptopArray.length; i++) {
			// Reset count to 0
			count = 0;
			
			// If brand matches
			if (selections[0].equalsIgnoreCase(FileInput.laptopArray[i].getBrand())) {
				// Increase count if true
				count++;
			}
			
			// If price matches
			// Check what survey radio button was selected
			if (selections[1].equalsIgnoreCase("Budget ($0-$499)")) {
				// Then check if user input is within numerical range
				if ((FileInput.laptopArray[i].getCost() >= 0) && (FileInput.laptopArray[i].getCost() < 500)) {
					count++;
				}
			}
			else if (selections[1].equalsIgnoreCase("Medium ($500-$999)")) {
				if ((FileInput.laptopArray[i].getCost() >= 500) && (FileInput.laptopArray[i].getCost() < 1000)) {
					count++;
				}
			}
			else if (selections[1].equalsIgnoreCase("High-end ($1000-$1999)")) {
				if ((FileInput.laptopArray[i].getCost() >= 1000) && (FileInput.laptopArray[i].getCost() < 2000)) {
					count++;
				}
			}
			else {
				if ((FileInput.laptopArray[i].getCost() >= 2000)) {
					count++;
				}
			}
			
			// If GPU matches
			if (selections[2].equalsIgnoreCase(FileInput.laptopArray[i].getGpu())) {
				count++;
			}
			
			// If SSD amount matches
			if (selections[3].equalsIgnoreCase("Small (Under 100 GBs)")) {
				if ((FileInput.laptopArray[i].getSsd() >= 0) && (FileInput.laptopArray[i].getSsd() < 100)) {
					count++;
				}
			}
			else if (selections[3].equalsIgnoreCase("Medium (128 GBs)")) {
				if (FileInput.laptopArray[i].getSsd() == 128) {
					count++;
				}
			}
			else if (selections[3].equalsIgnoreCase("High-End (256GBs or 512GBs)")) {
				if ((FileInput.laptopArray[i].getSsd() == 256) || (FileInput.laptopArray[i].getSsd() == 512)) {
					count++;
				}
			}
			else {
				if ((FileInput.laptopArray[i].getSsd() >= 1000)) {
					count++;
				}
			}
			
			// If RAM matches
			if (selections[4].equalsIgnoreCase("Small (4GBs)")) {
				if (FileInput.laptopArray[i].getRam() == 4) {
					count++;
				}
			}
			else if (selections[4].equalsIgnoreCase("Medium (8GBs)")) {
				if (FileInput.laptopArray[i].getRam() == 8) {
					count++;
				}
			}
			else if (selections[4].equalsIgnoreCase("High-End (16GBs)")) {
				if (FileInput.laptopArray[i].getRam() == 16) {
					count++;
				}
			}
			else {
				if ((FileInput.laptopArray[i].getRam() > 16)) {
					count++;
				}
			}
			
			FileInput.laptopArray[i].setScore(count);
		}

		// Sort array by lowest to highest "score"/count
		sortByScore(FileInput.laptopArray);
		// Assign value of laptop with index 21-23 to
		// array of chosen laptops
		getChosenLaptops(FileInput.laptopArray);
		// Open results frame with recommendations
		new ResultsFrame(chosenLaptops);
	}
	
	// Method to sort by score
	public static void sortByScore(Laptop[] laptopArray) {
		// Sort the array by score
		Arrays.sort(FileInput.laptopArray, Comparator.comparing(Laptop::getScore));
	}
	
	// Store selected laptops in new array
	public static Laptop[] getChosenLaptops(Laptop[] laptopArray) {
		chosenLaptops[0] = FileInput.laptopArray[23];
		chosenLaptops[1] = FileInput.laptopArray[22];
		chosenLaptops[2] = FileInput.laptopArray[21];
		// Return new array values
		return chosenLaptops;
	}
}
