/* SAMANTHA MAC
 * TEAM 6; Samantha Mac, Ian Lee, Abishan Shanmuhesan
 * May 15, 2023
 * ICS3U1
 * 
 * CART FRAME (GUI)
 * 
 * DESCRIPTION: This file displays all of the
 * items that have been added to the cart.
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
 * Please do not add a new item to the cart,
 * while the cart frame is open. Once you open
 * the cart, press "Back To Shopping" and re-open
 * the cart once you have added the new items.
 * 
 * ADDED FEATURES
 * A shopping cart that remembers what items
 * have been added, an order summary
 * 
 */ 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

// Public class
public class CartFrame extends JFrame implements ActionListener {
	// Color selection
	public static Color tan = new Color(241, 239, 237);
	public static Color coolGrey = new Color(247, 247, 247);

	// Values for calculating totals
	// and costs
	public static double preTotal = 0;
	public static double shippingCost;
	public static double preTaxCost;
	public static double taxAmount;
	public static double orderCost;

	// Panels
	public static JPanel mainPanel;
	public static JPanel headerPanel;
	public static JPanel twoColPanel;
	public static JPanel leftColPanel;
	public static JPanel rightColPanel;
	public static JPanel summaryPanel;
	public static JPanel summaryDataPanel;
	public static JPanel summaryLeftPanel;
	public static JPanel summaryRightPanel;
	
	// Labels
	public static JLabel emptyCart;
	
	// Labels that are constantly updating
	public static JLabel subtotalData;
	public static JLabel shippingData;
	public static JLabel beforeTaxData;
	public static JLabel taxCollectedData;
	public static JLabel orderTotalData;
	
	// Buttons
	public static JButton continueShoppingButton;

	
	// Frame that has array parameters
	CartFrame(Laptop[] laptopArray, Laptop[] chosenLaptops) {
		
		// Create main panel that houses all panels
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0 ));
		mainPanel.setBackground(coolGrey);
		// Scroll pane that holds main panel
		JScrollPane scrPane = new JScrollPane(mainPanel);

		// Divide entire main panel
		// into two columns
		twoColPanel = new JPanel();
		twoColPanel.setLayout(new BoxLayout(twoColPanel, BoxLayout.X_AXIS));
		twoColPanel.setBackground(coolGrey);
		twoColPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		// Add to main panel
		mainPanel.add(twoColPanel);		
		
		// Left column
		leftColPanel = new JPanel();
		leftColPanel.setLayout(new BoxLayout(leftColPanel, BoxLayout.Y_AXIS));
		leftColPanel.setBackground(Color.WHITE);
		leftColPanel.setAlignmentY(TOP_ALIGNMENT);
		// Add to broader panel
		twoColPanel.add(leftColPanel);
		
		// Create header
		JLabel header = new JLabel("Cart");
		header.setFont(new Font("Arial", Font.BOLD, 36)); 
		header.setBorder(BorderFactory.createEmptyBorder(30, 40, 10, 0 ));
		header.setAlignmentX(LEFT_ALIGNMENT);
		// Add widgets
		leftColPanel.add(header);
		
		// Create button to continue shopping
		Icon continueShoppingImg = new ImageIcon("images/shopMore.png");
		continueShoppingButton = new JButton(continueShoppingImg);
		continueShoppingButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 0));
		// When continue shopping button is clicked
		continueShoppingButton.addActionListener(e -> {
			// Close current frame
			this.dispose();
		});
		// Add widgets
		leftColPanel.add(continueShoppingButton);
		
		// If cart is empty
		JLabel emptyCart = new JLabel();
		ImageIcon emptyCartIcon = new ImageIcon("images/emptyCart.png");
		Image emptyCartImg1 = emptyCartIcon.getImage();
		Image emptyCartImg2 = emptyCartImg1.getScaledInstance(500, 1, java.awt.Image.SCALE_SMOOTH);
		emptyCartIcon = new ImageIcon(emptyCartImg2);
		emptyCart.setIcon(emptyCartIcon);
		leftColPanel.add(emptyCart);
		
		// Right column
		rightColPanel = new JPanel();
		rightColPanel.setLayout(new BoxLayout(rightColPanel, BoxLayout.Y_AXIS));
		rightColPanel.setBackground(coolGrey);
		rightColPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0 ));
		rightColPanel.setAlignmentY(TOP_ALIGNMENT);
		// Add to broader panel
		twoColPanel.add(rightColPanel);

		// Panel to hold order summary
		summaryPanel = new JPanel();
		summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.X_AXIS));
		summaryPanel.setBackground(Color.WHITE);
		summaryPanel.setBorder(BorderFactory.createEmptyBorder(40, 25, 40, 25 ));
		// Add to right col
		rightColPanel.add(summaryPanel);
		
		// Left col for headers
		summaryLeftPanel = new JPanel();
		summaryLeftPanel.setLayout(new BoxLayout(summaryLeftPanel, BoxLayout.Y_AXIS));
		summaryLeftPanel.setBackground(Color.WHITE);
		summaryPanel.add(summaryLeftPanel);
		// Right cols to hold amounts
		summaryRightPanel = new JPanel();
		summaryRightPanel.setLayout(new BoxLayout(summaryRightPanel, BoxLayout.Y_AXIS));
		summaryRightPanel.setBackground(Color.WHITE);
		summaryRightPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0 ));
		summaryPanel.add(summaryRightPanel);
		
		// Labels in summary panel
		JLabel summaryHeader = new JLabel("Order Summary");
		summaryHeader.setFont(new Font("Arial", Font.BOLD, 20)); 
		summaryHeader.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0 ));
		summaryHeader.setAlignmentX(LEFT_ALIGNMENT);
		JLabel filler = new JLabel(" "); // filler to align text
		filler.setFont(new Font("Arial", Font.BOLD, 20)); 
		filler.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0 ));
		// Add labels to respective panels
		summaryLeftPanel.add(summaryHeader);
		summaryRightPanel.add(filler);
		
		// Left col headers
		// Subtotal header
		JLabel subtotal = new JLabel("Items:");
		subtotal.setFont(new Font("Arial", Font.PLAIN, 14)); 
		subtotal.setForeground(Color.GRAY); 
		subtotal.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0 ));
		// Shipping header
		JLabel shipping = new JLabel("Shipping & Handling:");
		shipping.setFont(new Font("Arial", Font.PLAIN, 14)); 
		shipping.setForeground(Color.GRAY); 
		shipping.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0 ));
		// Before tax header
		JLabel beforeTax = new JLabel("Before Tax:");
		beforeTax.setFont(new Font("Arial", Font.PLAIN, 14)); 
		beforeTax.setForeground(Color.GRAY); 
		beforeTax.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0 ));
		// Tax amount header
		JLabel taxCollected = new JLabel("Tax Collected:");
		taxCollected.setFont(new Font("Arial", Font.PLAIN, 14)); 
		taxCollected.setForeground(Color.GRAY); 
		taxCollected.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0 ));
		// Order total header
		JLabel orderTotal = new JLabel("Order Total:");
		orderTotal.setFont(new Font("Arial", Font.BOLD, 18)); 
		orderTotal.setForeground(Color.GRAY); 
		orderTotal.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0 ));

		// Right col amounts
		// Subtotal number label
		subtotalData = new JLabel("0");
		subtotalData.setFont(new Font("Arial", Font.PLAIN, 14)); 
		subtotalData.setAlignmentX(RIGHT_ALIGNMENT);
		subtotalData.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0 ));
		// Shipping number label
		shippingData = new JLabel("0.00");
		shippingData.setFont(new Font("Arial", Font.PLAIN, 14)); 
		shippingData.setAlignmentX(RIGHT_ALIGNMENT);
		shippingData.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0 ));
		// beforeTaxData number label
		beforeTaxData = new JLabel("0.00");
		beforeTaxData.setFont(new Font("Arial", Font.PLAIN, 14));
		beforeTaxData.setAlignmentX(RIGHT_ALIGNMENT);
		beforeTaxData.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0 ));
		// taxCollectedData number label
		taxCollectedData = new JLabel("0.00");
		taxCollectedData.setFont(new Font("Arial", Font.PLAIN, 14)); 
		taxCollectedData.setAlignmentX(RIGHT_ALIGNMENT);
		taxCollectedData.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0 ));
		// orderTotalData number label
		orderTotalData = new JLabel("0.00");
		orderTotalData.setFont(new Font("Arial", Font.PLAIN, 18)); 
		orderTotalData.setAlignmentX(RIGHT_ALIGNMENT);
		orderTotalData.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0 ));

		// Add labels to repsective panels
		// Left col
		summaryLeftPanel.add(subtotal);
		summaryLeftPanel.add(shipping);
		summaryLeftPanel.add(beforeTax);
		summaryLeftPanel.add(taxCollected);
		summaryLeftPanel.add(orderTotal);
		// Right col
		summaryRightPanel.add(subtotalData);
		summaryRightPanel.add(shippingData);
		summaryRightPanel.add(beforeTaxData);
		summaryRightPanel.add(taxCollectedData);
		summaryRightPanel.add(orderTotalData);

		// Add widgets to frame
		this.add(scrPane);
		
		// FRAME CREATION
		this.setTitle("Shopping Cart"); // sets title
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //closes app
		this.setSize(2560, 1600); //sets the x-dimension and y-dimension of the this
		this.setVisible(true); 
	}

	// Allows GUI frame to run
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	
	// Method that updates order summary and cart
	public static void addItem(Laptop[] laptopArray, Laptop[] chosenLaptops) {
		// Round amounts to 2 decimal places
		preTotal += chosenLaptops[ResultsFrame.i].getCost();
		shippingCost = Math.round((preTotal * 0.10) * 100.0) / 100.0;
		preTaxCost = Math.round((preTotal + shippingCost) * 100.0) / 100.0;
		taxAmount = Math.round((preTotal * .13) * 100.0) / 100.0;
		orderCost = Math.round((preTaxCost + taxAmount) * 100.0) / 100.0;
		
		// Create a new panel for each item
		JPanel itemPanel = new JPanel();
		itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.X_AXIS));
		itemPanel.setBackground(Color.WHITE);
		itemPanel.setAlignmentX(LEFT_ALIGNMENT);
		itemPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 50));
		
		// Create left col to hold image
		JPanel itemLeftPanel = new JPanel();
		itemLeftPanel.setLayout(new BoxLayout(itemLeftPanel, BoxLayout.Y_AXIS));
		itemLeftPanel.setBackground(Color.WHITE);
		itemLeftPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 7));
		itemPanel.add(itemLeftPanel);
		itemLeftPanel.setAlignmentY(BOTTOM_ALIGNMENT);
		// Create JLabel image that holds icon
		JLabel Image = new JLabel();
		ImageIcon Product = new ImageIcon("images/laptop" + chosenLaptops[ResultsFrame.i].getId() + "C.png");
		Image.setIcon(Product);
		itemLeftPanel.add(Image);
		
		// Create right col to hold item information
		JPanel itemRightPanel = new JPanel();
		itemRightPanel.setLayout(new BoxLayout(itemRightPanel, BoxLayout.Y_AXIS));
		itemRightPanel.setBackground(Color.WHITE);
		itemPanel.add(itemRightPanel);
		// Create label with information about each product
		String SsdConvert = Integer.toString(chosenLaptops[ResultsFrame.i].getSsd()); // convert double to string
		JLabel itemName = new JLabel(chosenLaptops[ResultsFrame.i].getBrand() + " " + chosenLaptops[ResultsFrame.i].getModel() 
				+ " " + SsdConvert + "GB");
		itemName.setFont(new Font("Arial", Font.PLAIN, 16)); 
		// Display cost
		String price1 = Double.toString(chosenLaptops[ResultsFrame.i].getCost()); // convert double to string
		JLabel cost1 = new JLabel("$" + price1);
		cost1.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));
		cost1.setFont(new Font("Arial", Font.BOLD, 16));
		cost1.setForeground(Color.GRAY);
		// Delivery date and health coverage
		JLabel additionalInfo = new JLabel();
		ImageIcon detailsIcon = new ImageIcon("images/additionalInfo.png");
		Image detailsImg1 = detailsIcon.getImage();
		Image detailsImg2 = detailsImg1.getScaledInstance(430, 145, java.awt.Image.SCALE_SMOOTH);
		detailsIcon = new ImageIcon(detailsImg2);
		additionalInfo.setIcon(detailsIcon);
		// Add widgets to panel
		itemRightPanel.add(itemName);
		itemRightPanel.add(cost1);
		itemRightPanel.add(additionalInfo);
		// Add entire row to left column
		leftColPanel.add(itemPanel);
		
		// UPDATE ORDER SUMMARY AMOUNTS
		double newPreTotal = Math.round((preTotal) * 100.0) / 100.0;
		// Update subtotal with new amount
		String preTotalConvert = Double.toString(newPreTotal);
		subtotalData.setText("$" + preTotalConvert);
		// Update shipping with new amount
		String shippingConvert = Double.toString(shippingCost);
		shippingData.setText("$" + shippingConvert);
		// Update pretax amount with new amount
		String preTaxConvert = Double.toString(preTaxCost);
		beforeTaxData.setText("$" + preTaxConvert);
		// Update tax amount with new amount
		String taxConvert = Double.toString(taxAmount);
		taxCollectedData.setText("$" + taxConvert);
		// Update order total with new amount
		String totalConvert = Double.toString(orderCost);
		orderTotalData.setText("$" + totalConvert);
	}
	

}
