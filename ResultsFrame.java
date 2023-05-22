/* SAMANTHA MAC
 * TEAM 6; Samantha Mac, Ian Lee, Abishan Shanmuhesan
 * May 15, 2023
 * ICS3U1
 * 
 * RESULTS FRAME (GUI)
 * 
 * DESCRIPTION: This file displays the recommended
 * laptops, which users can add to the cart.
 * 
 * MAJOR SKILLS
 * Passing parameters between files,
 * value-returning methods, Swing widgets
 * (ie. JLabel, JButton, JPanel, ImageIcon),
 * nested panels and layout manager, formatting
 * using empty borders
 * 
 * CONTRIBUTION (for this file): 100% by Sam
 * 
 * AREAS OF CONCERN
 * To scroll smoothly, please click on the scroll
 * bar instead of the trackpad.
 * After clicking "Add to Cart", please wait 
 * for the program to load
 * 
 * ADDED FEATURES
 * Added a shopping cart feature,
 * added a redo quiz panel, added
 * a menu bar
 * 
 */ 

// Import statements
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

// Create GUI frame that displays recommendations
public class ResultsFrame extends JFrame implements ActionListener {
	Color darkGrey = new Color(128, 128, 128);
	Color tan = new Color(241, 239, 237);
	
	// Declare int that tracks current
	// laptop index being displayed
	public static int i;
	public static int starNum;
	
	// CART WINDOW
	public static CartFrame laptopWindow;
	// PANELS
	JPanel mainPanel;
	JPanel menuBar;
	JPanel headerPanel;
	JPanel allRecs;
	// Main recommendations
	JPanel aRec;
	JPanel aLeftCol;
	JPanel aRightCol;
	JPanel aDesc;
	JPanel aStarRow;
	JPanel aStatsRow1;
	JPanel aStatsRow2;
	JPanel aBox1;
	JPanel aBox2;
	JPanel aBox3;
	JPanel aBox4;
	JPanel aBox5;
	JPanel aButtonRow;
	// Secondary recommendations
	JPanel secondaryRecs;
	// Second recommendation
	JPanel bRec;
	JPanel bLeftCol;
	JPanel bRightCol;
	JPanel bDesc;
	JPanel bStarRow;
	JPanel bStatsRow;
	JPanel bBox1;
	JPanel bBox2;
	JPanel bBox3;
	JPanel bBox4;
	JPanel bBox5;
	JPanel bButtonRow;	
	// Third Recommendation
	JPanel cRec;
	JPanel cLeftCol;
	JPanel cRightCol;
	JPanel cDesc;
	JPanel cStarRow;
	JPanel cStatsRow;
	JPanel cBox1;
	JPanel cBox2;
	JPanel cBox3;
	JPanel cBox4;
	JPanel cBox5;
	JPanel cButtonRow;
	// Retake survey
	JPanel surveyPanel;
	
	// LABELS
	JLabel slogan1;
	JLabel slogan2;
	JLabel blurb1;
	JLabel blurb2;
	// Main recommendation
	JLabel aBrand;
	JLabel aModel;
	JLabel aRating;
	JLabel aCost;
	JLabel aCpuHeader;
	JLabel aCpu;
	JLabel aSsdHeader;
	JLabel aSsd;
	JLabel aRamHeader;
	JLabel aRam;
	JLabel aGpuHeader;
	JLabel aGpu;
	JLabel aDisplayHeader;
	JLabel aDisplay;
	// Second Recommendation
	JLabel bBrand;
	JLabel bModel;
	JLabel bRating;
	JLabel bCost;
	JLabel bCpuHeader;
	JLabel bCpu;
	JLabel bSsdHeader;
	JLabel bSsd;
	JLabel bRamHeader;
	JLabel bRam;
	JLabel bGpuHeader;
	JLabel bGpu;
	JLabel bDisplayHeader;
	JLabel bDisplay;
	// Third Recommendation
	JLabel cBrand;
	JLabel cModel;
	JLabel cRating;
	JLabel cCost;
	JLabel cCpuHeader;
	JLabel cCpu;
	JLabel cSsdHeader;
	JLabel cSsd;
	JLabel cRamHeader;
	JLabel cRam;
	JLabel cGpuHeader;
	JLabel cGpu;
	JLabel cDisplayHeader;
	JLabel cDisplay;
	// Retake survey
	JLabel retakeLabel;
	
	// BUTTONS
	// Menu bar
	JButton logoButton;
	JButton inventoryButton;
	JButton surveyButton;
	JButton cartButton;
	// Add cart buttons
	JButton aAddCartButton;
	JButton bAddCartButton;
	JButton cAddCartButton;
	// Retake survey button
	JButton retakeSurveyButton;
		
	// Create GUI frame that passes chosenLaptops arrays
	ResultsFrame(Laptop[] chosenLaptops) {
		// Open CartFrame then close it
		laptopWindow = new CartFrame(FileInput.laptopArray, ResultsApplication.chosenLaptops);
		laptopWindow.dispose();

		// 1. MAIN PANEL
		// Contains all panels
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.WHITE);

	
		// SCROLL PANE
		// Adds scroll bar
		JScrollPane scrPane = new JScrollPane(mainPanel);

		
		 // 2. MENU BAR PANEL
		menuBar = new JPanel();
		menuBar.setBackground(Color.WHITE);
		menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));
		menuBar.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		// Add menu panel to frame
		mainPanel.add(menuBar);
		
		// Create logo button
		// That restarts program
		Icon logoImg = new ImageIcon("images/logo.png");
		logoButton = new JButton(logoImg);
		logoButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
	    // Open inventory
		logoButton.addActionListener(e -> {
	    	this.dispose();
			new MainTitleFrame();
  		});
		
		// Inventory button
	    Icon invetoryButtonImg = new ImageIcon("images/inventoryImg.png");
	    inventoryButton = new JButton(invetoryButtonImg);
	    inventoryButton.setBorder(BorderFactory.createEmptyBorder(0, 720, 0, 0));
	    // Open inventory
	    inventoryButton.addActionListener(e -> {
	    	this.dispose();
			new Inventory(FileInput.laptopArray);
  		});
	    
	    // Survey button
	    Icon surveyButtonImg = new ImageIcon("images/surveyImg.png");
	    surveyButton = new JButton(surveyButtonImg);
	    surveyButton.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
	    // Retake survey
	    surveyButton.addActionListener(e -> {
	    	this.dispose();
			ResultsApplication.start();
  		});
 	 		
	    // Cart button
	    Icon cartButtonImg = new ImageIcon("images/cartImg.png");
	    cartButton = new JButton(cartButtonImg);
	    cartButton.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
	    // Display cart window when Cart button
	 	// is clicked
 		cartButton.addActionListener(e -> {
 			//this.dispose();
 			laptopWindow.setVisible(true); 
 		});
	 				
		// Add widgets to panel
		menuBar.add(logoButton);
		menuBar.add(inventoryButton);
		menuBar.add(surveyButton);
		menuBar.add(cartButton);
		
		
		// 3. LANDING PAGE
		// Panel containing text and image
		headerPanel = new JPanel();
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
		headerPanel.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0 ));
		headerPanel.setBackground(Color.WHITE);

		// Labels containing slogan
		slogan1 = new JLabel("Say hello to the laptops");
		slogan1.setAlignmentX(CENTER_ALIGNMENT);
		slogan1.setFont(new Font("Arial", Font.PLAIN, 42)); 
		slogan2 = new JLabel("curated for you.");
		slogan2.setAlignmentX(CENTER_ALIGNMENT);
		slogan2.setFont(new Font("Arial", Font.BOLD, 42));

		// Description of website
		blurb1 = new JLabel("We have compiled the results of your survey and have");
		blurb1.setFont(new Font("Arial", Font.PLAIN, 18)); 
		blurb1.setBorder(BorderFactory.createEmptyBorder(15, 0, 4, 0 ));
		blurb1.setAlignmentX(CENTER_ALIGNMENT);
		blurb2 = new JLabel("determined the top three laptops that fit your unique needs.");
		blurb2.setFont(new Font("Arial", Font.PLAIN, 18)); 
		blurb2.setAlignmentX(CENTER_ALIGNMENT);

		// Image of laptop for landing page
		JLabel headerImg = new JLabel();
		ImageIcon headerVisual = new ImageIcon("images/landingBackground.png");
		// Set label to icon
		headerImg.setIcon(headerVisual);
		headerImg.setAlignmentX(CENTER_ALIGNMENT);

		// Add panel to a panel
		mainPanel.add(headerPanel);
		// Add widgets
		headerPanel.add(slogan1);
		headerPanel.add(slogan2);
		
		headerPanel.add(blurb1);
		headerPanel.add(blurb2);
		
		headerPanel.add(headerImg);

		
		// ALL RECOMMENDATIONS PANEL
		allRecs = new JPanel();
		allRecs.setBackground(Color.WHITE);
		allRecs.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		allRecs.setLayout(new BoxLayout(allRecs, BoxLayout.Y_AXIS)); // to create horizontal flow
		// Add to main panel
		mainPanel.add(allRecs);
		
		
		// 4. FIRST RECOMMENDATION
		// Set laptop index to 0
		i = 0;
				
		// Create JPanel with an image as the background
		aRec = new JPanel();
		aRec.setLayout(new BoxLayout(aRec, BoxLayout.X_AXIS));
		aRec.setBackground(tan);
		aRec.setBorder(BorderFactory.createEmptyBorder(20, 45, 40, 45));
		
		// Left col with image
		aLeftCol = new JPanel();
		aLeftCol.setLayout(new BoxLayout(aLeftCol, BoxLayout.Y_AXIS));
		aLeftCol.setBackground(tan);
		// Create image widget
		JLabel aImage = new JLabel();
		ImageIcon aProduct = new ImageIcon("images/laptop" + chosenLaptops[i].getId() + ".png");
		aImage.setIcon(aProduct);

		// Right col with specs
		aRightCol = new JPanel();
		aRightCol.setLayout(new BoxLayout(aRightCol, BoxLayout.Y_AXIS));
		aRightCol.setBackground(tan);
		aRightCol.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 100));
		
		// Create panel to hold brand, model, cost
		aDesc = new JPanel();
		aDesc.setLayout(new BoxLayout(aDesc, BoxLayout.Y_AXIS));
		aDesc.setBackground(tan);
		aDesc.setAlignmentX(LEFT_ALIGNMENT);
		
		// Display brand
		aBrand = new JLabel(chosenLaptops[i].getBrand());
		aBrand.setFont(new Font("Arial", Font.PLAIN, 16)); 
		// Display model
		aModel = new JLabel(chosenLaptops[i].getModel());
		aModel.setFont(new Font("Arial", Font.BOLD, 36)); 
		
		// Display rating
		// Create panel to hold stars
		aStarRow = new JPanel();
		aStarRow.setLayout(new BoxLayout(aStarRow, BoxLayout.X_AXIS));
		aStarRow.setAlignmentX(LEFT_ALIGNMENT);
		// Calculate rating out of 5
		starNum = ((int)(chosenLaptops[i].getRating() / 2) + 1);
		// Use for loop to print number of stars
		for (int s = 0; s < starNum; s++) {
			// Create image widget for each star
			JLabel star = new JLabel();
			ImageIcon starImg = new ImageIcon("images/starImg.png");
			star.setIcon(starImg);
			star.setBorder(BorderFactory.createEmptyBorder(5, 0, 30, 10 ));
			// Add star to row panel
			aStarRow.add(star);
		}
		
		// Display cost
		String aPrice = Double.toString(chosenLaptops[i].getCost()); // convert double to string
		aCost = new JLabel("$" + aPrice);
		aCost.setForeground(darkGrey);
		aCost.setFont(new Font("Arial", Font.PLAIN, 20)); 
		
		// Display more detailed specs
		aStatsRow1 = new JPanel();
		aStatsRow1.setLayout(new BoxLayout(aStatsRow1, BoxLayout.X_AXIS));
		aStatsRow1.setBackground(tan);
		aStatsRow1.setAlignmentX(LEFT_ALIGNMENT);
		aStatsRow1.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0 ));
		
		// Box A containing CPU
		aBox1 = new JPanel();
		aBox1.setLayout(new BoxLayout(aBox1, BoxLayout.Y_AXIS));
		aBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		aBox1.setBackground(tan);
		// CPU header
		aCpuHeader = new JLabel("CPU");
		aCpuHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		aCpuHeader.setForeground(darkGrey);
		// CPU data
		aCpu = new JLabel(chosenLaptops[0].getCpu());
		aCpu.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Box B containing SSD
		aBox2 = new JPanel();
		aBox2.setLayout(new BoxLayout(aBox2, BoxLayout.Y_AXIS));
		aBox2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		aBox2.setBackground(tan);
		// SSD header
		aSsdHeader = new JLabel("SSD");
		aSsdHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		aSsdHeader.setForeground(darkGrey);
		// SSD data
		String aSsdConvert = Integer.toString(chosenLaptops[0].getSsd()); // convert double to string
		aSsd = new JLabel(aSsdConvert + "GB");
		aSsd.setFont(new Font("Arial", Font.PLAIN, 16)); 

		// Box C containing ram
		aBox3 = new JPanel();
		aBox3.setLayout(new BoxLayout(aBox3, BoxLayout.Y_AXIS));
		aBox3.setBackground(tan);
		// RAM header
		aRamHeader = new JLabel("RAM");
		aRamHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		aRamHeader.setForeground(darkGrey);
		// RAM amount
		String aRamConvert = Double.toString(chosenLaptops[0].getRam()); // convert double to string
		aRam = new JLabel(aRamConvert + "GB");
		aRam.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Create a second row of tech specs with
		// same format
		aStatsRow2 = new JPanel();
		aStatsRow2.setLayout(new BoxLayout(aStatsRow2, BoxLayout.X_AXIS));
		aStatsRow2.setBackground(tan);
		aStatsRow2.setAlignmentX(LEFT_ALIGNMENT);
		aStatsRow2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0 ));
		
		// Box D containing GPU
		aBox4 = new JPanel();
		aBox4.setLayout(new BoxLayout(aBox4, BoxLayout.Y_AXIS));
		aBox4.setBackground(tan);
		aBox4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		// GPU header
		aGpuHeader = new JLabel("GPU");
		aGpuHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		aGpuHeader.setForeground(Color.GRAY);
		// GPU data
		aGpu = new JLabel(chosenLaptops[i].getGpu());
		aGpu.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Box E containing display size
		aBox5 = new JPanel();
		aBox5.setLayout(new BoxLayout(aBox5, BoxLayout.Y_AXIS));
		aBox5.setBackground(tan);
		// Display size header
		aDisplayHeader = new JLabel("Display Size");
		aDisplayHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		aDisplayHeader.setForeground(Color.GRAY);
		// Display size data
		String aDisplayConvert = Double.toString(chosenLaptops[i].getDisplay()); // convert double to string
		aDisplay = new JLabel(aDisplayConvert + "\"");
		aDisplay.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Button row
		aButtonRow = new JPanel();
		aButtonRow.setLayout(new BoxLayout(aButtonRow, BoxLayout.X_AXIS));
		aButtonRow.setBackground(tan);
		aButtonRow.setAlignmentX(LEFT_ALIGNMENT);
		aButtonRow.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0 ));
		
		// Create button to add item to cart
	    Icon addCartButtonImage = new ImageIcon("images/addCartImg.png");
		aAddCartButton = new JButton(addCartButtonImage);
		aAddCartButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30 ));
		
		aAddCartButton.addActionListener(e -> {
			// Reset i to 0
			i = 0;
			// Invoke addItem method and update cart
			CartFrame.addItem(FileInput.laptopArray, ResultsApplication.chosenLaptops);
		});
		
		// Add panel to larger panel
		allRecs.add(aRec);
		
		// Add widgets
		aRec.add(aLeftCol);
		aRec.add(aRightCol);
		
		aLeftCol.add(aImage);

		aRightCol.add(aDesc);
		aRightCol.add(aStatsRow1);
		aRightCol.add(aStatsRow2);
		aRightCol.add(aButtonRow);

		
		aDesc.add(aBrand);
		aDesc.add(aModel);
		aDesc.add(aStarRow);
		aDesc.add(aCost);

		aStatsRow1.add(aBox1);
		aStatsRow1.add(aBox2);
		aStatsRow1.add(aBox3);
		
		aStatsRow2.add(aBox4);
		aStatsRow2.add(aBox5);

		aBox1.add(aCpuHeader);
		aBox1.add(aCpu);
		
		aBox2.add(aSsdHeader);
		aBox2.add(aSsd);
		
		aBox3.add(aRamHeader);
		aBox3.add(aRam);
		
		aBox4.add(aGpuHeader);
		aBox4.add(aGpu);
		
		aBox5.add(aDisplayHeader);
		aBox5.add(aDisplay);
		
		aButtonRow.add(aAddCartButton);
	
		// RETAKE SURVEY
		// Create empty panel to hold coloured panel
		JPanel surveyHolder = new JPanel();
		surveyHolder.setLayout(new BoxLayout(surveyHolder, BoxLayout.X_AXIS));
		surveyHolder.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		surveyHolder.setBackground(Color.WHITE);
		surveyHolder.setAlignmentY(TOP_ALIGNMENT);
		// Add panel to empty panel
		allRecs.add(surveyHolder);
		
		// Create panel to hold all elements related
		// to survey retake
		surveyPanel = new JPanel();
		surveyPanel.setLayout(new BoxLayout(surveyPanel, BoxLayout.X_AXIS));
		surveyPanel.setBorder(BorderFactory.createEmptyBorder(40, 145, 40, 145));
		surveyPanel.setBackground(tan);
		
		// Image of laptop
		JLabel Image = new JLabel();
		Image.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
		ImageIcon Product = new ImageIcon("images/laptop0C.png");
		Image.setIcon(Product);
		
		// Label
		retakeLabel = new JLabel("Not what you're looking for? Retake our survey.");
		retakeLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
		
		// Add button to retake quiz
		ImageIcon retakeSurveyImg = new ImageIcon("images/retakeQuiz.png");
	    retakeSurveyButton = new JButton(retakeSurveyImg);
	    retakeSurveyButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0 ));
	    // When this button is clicked
	    // open survey
	    retakeSurveyButton.addActionListener(e -> {
			this.dispose();
			ResultsApplication.start();
		});
		// Add panel to larger panel
		surveyHolder.add(surveyPanel);
		// Add widgets
		surveyPanel.add(Image);
		surveyPanel.add(retakeLabel);
		surveyPanel.add(retakeSurveyButton);
		
		
		// 5. SECONDARY RECOMMENDATIONS
		secondaryRecs = new JPanel();
		secondaryRecs.setLayout(new BoxLayout(secondaryRecs, BoxLayout.X_AXIS));
		secondaryRecs.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		secondaryRecs.setBackground(Color.WHITE);
		allRecs.add(secondaryRecs);
		
		// 5A. SECOND RECOMMENDATION
		// Update laptop index to 1
		i = 1;
		
		// Create empty panel to hold coloured panels
		JPanel bRecHolder = new JPanel();
		bRecHolder.setLayout(new BoxLayout(bRecHolder, BoxLayout.X_AXIS));
		bRecHolder.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
		bRecHolder.setBackground(Color.WHITE);
		bRecHolder.setAlignmentY(TOP_ALIGNMENT);
		secondaryRecs.add(bRecHolder);
		
		// Create panel for second recommendation
		bRec = new JPanel();
		bRec.setLayout(new BoxLayout(bRec, BoxLayout.Y_AXIS));
		bRec.setBackground(tan);
		bRec.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));
		bRec.setAlignmentY(TOP_ALIGNMENT);
		
		// Left col with image
		bLeftCol = new JPanel();
		bLeftCol.setLayout(new BoxLayout(bLeftCol, BoxLayout.Y_AXIS));
		bLeftCol.setBackground(tan);
		// Create image widget
		JLabel bImage = new JLabel();
		ImageIcon bProduct = new ImageIcon("images/laptop" + chosenLaptops[i].getId() + "B.png");
		bImage.setIcon(bProduct);

		// Right col with specs
		bRightCol = new JPanel();
		bRightCol.setLayout(new BoxLayout(bRightCol, BoxLayout.Y_AXIS));
		bRightCol.setBackground(tan);
		bRightCol.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 100));
		
		// Create panel to hold brand, model, cost
		bDesc = new JPanel();
		bDesc.setLayout(new BoxLayout(bDesc, BoxLayout.Y_AXIS));
		bDesc.setBackground(tan);
		bDesc.setAlignmentX(LEFT_ALIGNMENT);
		
		// Display brand
		bBrand = new JLabel(chosenLaptops[i].getBrand());
		bBrand.setFont(new Font("Arial", Font.PLAIN, 16)); 
		// Display model
		bModel = new JLabel(chosenLaptops[i].getModel());
		bModel.setFont(new Font("Arial", Font.BOLD, 24)); 
		
		// Display rating
		// Create panel to hold stars
		bStarRow = new JPanel();
		bStarRow.setLayout(new BoxLayout(bStarRow, BoxLayout.X_AXIS));
		bStarRow.setAlignmentX(LEFT_ALIGNMENT);
		// Calculate rating out of 5
		starNum = ((int)(chosenLaptops[i].getRating() / 2) + 1);
		// Use for loop to print number of stars
		for (int s = 0; s < starNum; s++) {
			// Create image widget for each star
			JLabel star = new JLabel();
			ImageIcon starImg = new ImageIcon("images/starImg.png");
			star.setIcon(starImg);
			star.setBorder(BorderFactory.createEmptyBorder(5, 0, 30, 10 ));
			// Add star to row panel
			bStarRow.add(star);
		}
				
		// Display cost
		String bPrice = Double.toString(chosenLaptops[i].getCost()); // convert double to string
		bCost = new JLabel("$" + bPrice);
		bCost.setForeground(darkGrey);
		bCost.setFont(new Font("Arial", Font.PLAIN, 20)); 
		
		// Display more detailed specs
		bStatsRow = new JPanel();
		bStatsRow.setLayout(new BoxLayout(bStatsRow, BoxLayout.Y_AXIS));
		bStatsRow.setBackground(tan);
		bStatsRow.setAlignmentX(LEFT_ALIGNMENT);
		bStatsRow.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0 ));
		
		// Box A containing CPU
		bBox1 = new JPanel();
		bBox1.setLayout(new BoxLayout(bBox1, BoxLayout.Y_AXIS));
		bBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		bBox1.setBackground(tan);
		// CPU header
		bCpuHeader = new JLabel("CPU");
		bCpuHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		bCpuHeader.setForeground(darkGrey);
		// CPU data
		bCpu = new JLabel(chosenLaptops[i].getCpu());
		bCpu.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Box B containing SSD
		bBox2 = new JPanel();
		bBox2.setLayout(new BoxLayout(bBox2, BoxLayout.Y_AXIS));
		bBox2.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		bBox2.setBackground(tan);
		// SSD header
		bSsdHeader = new JLabel("SSD");
		bSsdHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		bSsdHeader.setForeground(darkGrey);
		// SSD data
		String SsdConvert = Integer.toString(chosenLaptops[i].getSsd()); // convert double to string
		bSsd = new JLabel(SsdConvert + "GB");
		bSsd.setFont(new Font("Arial", Font.PLAIN, 16)); 

		// Box C containing ram
		bBox3 = new JPanel();
		bBox3.setLayout(new BoxLayout(bBox3, BoxLayout.Y_AXIS));
		bBox3.setBackground(tan);
		bBox3.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		// RAM header
		bRamHeader = new JLabel("RAM");
		bRamHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		bRamHeader.setForeground(darkGrey);
		// RAM amount
		String RamConvert = Double.toString(chosenLaptops[i].getRam()); // convert double to string
		bRam = new JLabel(RamConvert + "GB");
		bRam.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Box D containing GPU
		bBox4 = new JPanel();
		bBox4.setLayout(new BoxLayout(bBox4, BoxLayout.Y_AXIS));
		bBox4.setBackground(tan);
		bBox4.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		// GPU header
		bGpuHeader = new JLabel("GPU");
		bGpuHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		bGpuHeader.setForeground(Color.GRAY);
		// GOU data
		bGpu = new JLabel(chosenLaptops[i].getGpu());
		bGpu.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Box E containing display size
		bBox5 = new JPanel();
		bBox5.setLayout(new BoxLayout(bBox5, BoxLayout.Y_AXIS));
		bBox5.setBackground(tan);
		// Display size header
		bDisplayHeader = new JLabel("Display Size");
		bDisplayHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		bDisplayHeader.setForeground(Color.GRAY);
		// Display size data
		String DisplayConvert = Double.toString(chosenLaptops[i].getDisplay()); // convert double to string
		bDisplay = new JLabel(DisplayConvert + "\"");
		bDisplay.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// BUTTON ROW
		bButtonRow = new JPanel();
		bButtonRow.setLayout(new BoxLayout(bButtonRow, BoxLayout.X_AXIS));
		bButtonRow.setBackground(tan);
		bButtonRow.setAlignmentX(LEFT_ALIGNMENT);
		bButtonRow.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0 ));
		
	    addCartButtonImage = new ImageIcon("images/addCartImg.png");
		bAddCartButton = new JButton(addCartButtonImage);
		bAddCartButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30 ));
		
		// Run addItem method when this button
		// is clicked
		bAddCartButton.addActionListener(e -> {
			// Reset index to 1
			i = 1;
			// Invoke method to add item to cart
			CartFrame.addItem(FileInput.laptopArray, ResultsApplication.chosenLaptops);
		});
		
		
	    // Add panel to  panel
	    bRecHolder.add(bRec);
		
	    // Add widgets
		bRec.add(bLeftCol);
		bRec.add(bRightCol);
		
		bLeftCol.add(bImage);

		bRightCol.add(bDesc);
		bRightCol.add(bStatsRow);
		bRightCol.add(bButtonRow);

		
		bDesc.add(bBrand);
		bDesc.add(bModel);
		bDesc.add(bStarRow);
		bDesc.add(bCost);

		bStatsRow.add(bBox1);
		bStatsRow.add(bBox2);
		bStatsRow.add(bBox3);
		bStatsRow.add(bBox4);
		bStatsRow.add(bBox5);

		bBox1.add(bCpuHeader);
		bBox1.add(bCpu);
		
		bBox2.add(bSsdHeader);
		bBox2.add(bSsd);
		
		bBox3.add(bRamHeader);
		bBox3.add(bRam);
		
		bBox4.add(bGpuHeader);
		bBox4.add(bGpu);
		
		bBox5.add(bDisplayHeader);
		bBox5.add(bDisplay);
		
		bButtonRow.add(bAddCartButton);
		
		
		// 5A. THIRD RECOMMENDATION
		// Update laptop index to 2
		i = 2;
		
		// Create empty panel to hold coloured panel
		JPanel cRecHolder = new JPanel();
		cRecHolder.setLayout(new BoxLayout(cRecHolder, BoxLayout.X_AXIS));
		cRecHolder.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
		cRecHolder.setBackground(Color.WHITE);
		cRecHolder.setAlignmentY(TOP_ALIGNMENT);
		secondaryRecs.add(cRecHolder);
		
		// Create panel for third recommendation
		cRec = new JPanel();
		cRec.setLayout(new BoxLayout(cRec, BoxLayout.Y_AXIS));
		cRec.setBackground(tan);
		cRec.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));
		cRec.setAlignmentY(TOP_ALIGNMENT);
		
		// Left col with image
		cLeftCol = new JPanel();
		cLeftCol.setLayout(new BoxLayout(cLeftCol, BoxLayout.Y_AXIS));
		cLeftCol.setBackground(tan);
		// Create image widget
		JLabel cImage = new JLabel();
		ImageIcon cProduct = new ImageIcon("images/laptop" + chosenLaptops[i].getId() + "b.png");
		cImage.setIcon(cProduct);

		// Right col with specs
		cRightCol = new JPanel();
		cRightCol.setLayout(new BoxLayout(cRightCol, BoxLayout.Y_AXIS));
		cRightCol.setBackground(tan);
		cRightCol.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 100));
		
		// Create panel to hold brand, model, cost
		cDesc = new JPanel();
		cDesc.setLayout(new BoxLayout(cDesc, BoxLayout.Y_AXIS));
		cDesc.setBackground(tan);
		cDesc.setAlignmentX(LEFT_ALIGNMENT);
		
		// Display rating
		// Create panel to hold stars
		cStarRow = new JPanel();
		cStarRow.setLayout(new BoxLayout(cStarRow, BoxLayout.X_AXIS));
		cStarRow.setAlignmentX(LEFT_ALIGNMENT);
		// Calculate rating out of 5
		starNum = ((int)(chosenLaptops[i].getRating() / 2) + 1);
		// Use for loop to print number of stars
		for (int s = 0; s < starNum; s++) {
			// Create image widget for each star
			JLabel star = new JLabel();
			ImageIcon starImg = new ImageIcon("images/starImg.png");
			star.setIcon(starImg);
			star.setBorder(BorderFactory.createEmptyBorder(5, 0, 30, 10 ));
			// Add star to row panel
			cStarRow.add(star);
		}
							
		// Display brand
		cBrand = new JLabel(chosenLaptops[i].getBrand());
		cBrand.setFont(new Font("Arial", Font.PLAIN, 16)); 
		// Display model
		cModel = new JLabel(chosenLaptops[i].getModel());
		cModel.setFont(new Font("Arial", Font.BOLD, 24)); 
		// Display cost
		String cPrice = Double.toString(chosenLaptops[i].getCost()); // convert double to string
		cCost = new JLabel("$" + cPrice);
		cCost.setForeground(darkGrey);
		cCost.setFont(new Font("Arial", Font.PLAIN, 20)); 
		
		// Display more detailed specs
		cStatsRow = new JPanel();
		cStatsRow.setLayout(new BoxLayout(cStatsRow, BoxLayout.Y_AXIS));
		cStatsRow.setBackground(tan);
		cStatsRow.setAlignmentX(LEFT_ALIGNMENT);
		cStatsRow.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0 ));
		
		// Box A containing CPU
		cBox1 = new JPanel();
		cBox1.setLayout(new BoxLayout(cBox1, BoxLayout.Y_AXIS));
		cBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		cBox1.setBackground(tan);
		// CPU header
		cCpuHeader = new JLabel("CPU");
		cCpuHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		cCpuHeader.setForeground(darkGrey);
		// CPU data
		cCpu = new JLabel(chosenLaptops[i].getCpu());
		cCpu.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Box B containing SSD
		cBox2 = new JPanel();
		cBox2.setLayout(new BoxLayout(cBox2, BoxLayout.Y_AXIS));
		cBox2.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		cBox2.setBackground(tan);
		// SSD header
		cSsdHeader = new JLabel("SSD");
		cSsdHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		cSsdHeader.setForeground(darkGrey);
		// SSD data
		String cSsdConvert = Integer.toString(chosenLaptops[i].getSsd()); // convert double to string
		cSsd = new JLabel(cSsdConvert + "GB");
		cSsd.setFont(new Font("Arial", Font.PLAIN, 16)); 

		// Box C containing ram
		cBox3 = new JPanel();
		cBox3.setLayout(new BoxLayout(cBox3, BoxLayout.Y_AXIS));
		cBox3.setBackground(tan);
		cBox3.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		// RAM header
		cRamHeader = new JLabel("RAM");
		cRamHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		cRamHeader.setForeground(darkGrey);
		// RAM amount
		String cRamConvert = Double.toString(chosenLaptops[i].getRam()); // convert double to string
		cRam = new JLabel(cRamConvert + "GB");
		cRam.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Box D containing GPU
		cBox4 = new JPanel();
		cBox4.setLayout(new BoxLayout(cBox4, BoxLayout.Y_AXIS));
		cBox4.setBackground(tan);
		cBox4.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		// GPU header
		cGpuHeader = new JLabel("GPU");
		cGpuHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		cGpuHeader.setForeground(Color.GRAY);
		// GPU data
		cGpu = new JLabel(chosenLaptops[i].getGpu());
		cGpu.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Box E containing display size
		cBox5 = new JPanel();
		cBox5.setLayout(new BoxLayout(cBox5, BoxLayout.Y_AXIS));
		cBox5.setBackground(tan);
		// Display size header
		cDisplayHeader = new JLabel("Display Size");
		cDisplayHeader.setFont(new Font("Arial", Font.PLAIN, 14)); 
		cDisplayHeader.setForeground(Color.GRAY);
		// Display size data
		String cDisplayConvert = Double.toString(chosenLaptops[i].getDisplay()); // convert double to string
		cDisplay = new JLabel(cDisplayConvert + "\"");
		cDisplay.setFont(new Font("Arial", Font.PLAIN, 16)); 
		
		// Button row
		cButtonRow = new JPanel();
		cButtonRow.setLayout(new BoxLayout(cButtonRow, BoxLayout.X_AXIS));
		cButtonRow.setBackground(tan);
		cButtonRow.setAlignmentX(LEFT_ALIGNMENT);
		cButtonRow.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0 ));
		
		// Create button that adds item to carts
	    addCartButtonImage = new ImageIcon("images/addCartImg.png");
		cAddCartButton = new JButton(addCartButtonImage);
		cAddCartButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30 ));
		
		// Run addItem method when this button
		// is clicked
		cAddCartButton.addActionListener(e -> {
			// Reset index to 2
			i = 2;
			// Invoke method to add new item to cart
			CartFrame.addItem(FileInput.laptopArray, ResultsApplication.chosenLaptops);
		});
		
	    // Add sub panel to larger panel
	    cRecHolder.add(cRec);
	    
		// Add widgets
		cRec.add(cLeftCol);
		cRec.add(cRightCol);
		
		cLeftCol.add(cImage);

		cRightCol.add(cDesc);
		cRightCol.add(cStatsRow);
		cRightCol.add(cButtonRow);

		
		cDesc.add(cBrand);
		cDesc.add(cModel);
		cDesc.add(cStarRow);
		cDesc.add(cCost);

		cStatsRow.add(cBox1);
		cStatsRow.add(cBox2);
		cStatsRow.add(cBox3);
		cStatsRow.add(cBox4);
		cStatsRow.add(cBox5);

		cBox1.add(cCpuHeader);
		cBox1.add(cCpu);
		
		cBox2.add(cSsdHeader);
		cBox2.add(cSsd);
		
		cBox3.add(cRamHeader);
		cBox3.add(cRam);
		
		cBox4.add(cGpuHeader);
		cBox4.add(cGpu);
		
		cBox5.add(cDisplayHeader);
		cBox5.add(cDisplay);
		
		cButtonRow.add(cAddCartButton);
		
		// Add widgets to frame
		this.add(scrPane);
		
		// FRAME CREATION
		this.setTitle("The Perfect Pair for You"); // sets title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes app
		this.setSize(2560, 1600); //sets the x-dimension and y-dimension of the this
		this.setVisible(true); 
	}

	
	// Allows GUI frame to run
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
