/*Group 6: Ian Lee, Samantha Mac, Abishan Shanmushesan
Monday May 15th 2023
ICS3U1-05 Mrs. Biswas

'Pair' Laptop Store Page

This laptop survey page will ask the user a 5 questions to determine a recommended laptop for you. 
We will ask questions about the brand you may be looking for and the possible specs that come with the laptop. 

This file uses: 
-Arrays
-Radio Buttons
-Panel
-Labels
-ActionListener

Areas of Concern: The actual survey page may not be big enough

Contribution to Assignment: 
Survey.java
Laptop Class.java
I completed 100% of this page. 
*/

import java.util.Arrays;
import java.awt.*;
import javax.swing.*;

public class Survey extends JFrame {

	private JPanel panel;
	private JPanel brandpanel, pricepanel, gpupanel, ssdpanel, rampanel;
	private JLabel brandLabel, priceLabel, gpuLabel, ssdLabel, ramLabel;
	private JRadioButton[] brandButtons, priceButtons, gpuButtons, ssdButtons, ramButtons;
	private JButton submitButton;
	static String[] selections;

	// Menu Bar
	JPanel menuBar;
	JButton logoButton;
	JButton inventoryButton;
	JButton surveyButton;

	public Survey(Laptop[] laptopArray, Laptop[] chosenLaptops) {
		// Set up the JFrame
		setTitle("Survey");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(2560, 1600);

		// Set up the JPanel
		panel = new JPanel(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));

		// 2. MENU BAR PANEL
		menuBar = new JPanel();
		menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));
		menuBar.setAlignmentX(LEFT_ALIGNMENT);
		// Add menu panel to frame
		panel.add(menuBar);

		// Create logo button
		// That restarts program
		Icon logoImg = new ImageIcon("images/logo.png");
		logoButton = new JButton(logoImg);
		logoButton.setBorder(null);
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
			new Inventory(laptopArray);
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

		// Add widgets to panel
		menuBar.add(logoButton);
		menuBar.add(inventoryButton);
		menuBar.add(surveyButton);

		brandpanel = new JPanel(new FlowLayout());
		pricepanel = new JPanel(new FlowLayout());
		gpupanel = new JPanel(new FlowLayout());
		ssdpanel = new JPanel(new FlowLayout());
		rampanel = new JPanel(new FlowLayout());

		//Title label 
		JLabel titlelabel = new JLabel("      We Have What What You Want");
		titlelabel.setFont(new Font("Arial", Font.BOLD, 36));
		titlelabel.setForeground(new java.awt.Color(62, 50, 168));
		panel.add(titlelabel);

		//Subtitle Label
		JLabel subtitlelabel = new JLabel("      What Are You Looking For?");
		subtitlelabel.setFont(new Font("Arial", Font.BOLD, 24));

		panel.add(subtitlelabel);

		//Brand Label
		brandLabel = new JLabel("     Select a brand:");
		brandLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		//Price Label
		priceLabel = new JLabel("     Select a price range:");
		priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		//GPU Label
		gpuLabel = new JLabel("     Select the GPU Brand: ");
		gpuLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		//SSD Label
		ssdLabel = new JLabel("     Select the Storage Laptop Size: ");
		ssdLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		//RAM Label
		ramLabel = new JLabel("     Select the Memory/RAM Laptop Size: ");
		ramLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		// Create array
		brandButtons = new JRadioButton[8];
		priceButtons = new JRadioButton[4];
		gpuButtons = new JRadioButton[4];
		ssdButtons = new JRadioButton[4];
		ramButtons = new JRadioButton[4];
		submitButton = new JButton("Submit");

		// Create the brand buttons
		brandButtons[0] = new JRadioButton("Asus");
		brandButtons[1] = new JRadioButton("Acer");
		brandButtons[2] = new JRadioButton("Lenovo");
		brandButtons[3] = new JRadioButton("MSI");
		brandButtons[4] = new JRadioButton("Samsung");
		brandButtons[5] = new JRadioButton("Dell");
		brandButtons[6] = new JRadioButton("HP");
		brandButtons[7] = new JRadioButton("Apple");

		// Create the price buttons
		priceButtons[0] = new JRadioButton("Budget ($0-$499)");
		priceButtons[1] = new JRadioButton("Medium ($500-$999)");
		priceButtons[2] = new JRadioButton("High-end ($1000-$1999)");
		priceButtons[3] = new JRadioButton("Ultra ($2000+)");

		// Create the CPU buttons
		gpuButtons[0] = new JRadioButton("NVIDIA");
		gpuButtons[1] = new JRadioButton("AMD");
		gpuButtons[2] = new JRadioButton("Intel");
		gpuButtons[3] = new JRadioButton("Apple");

		// Create the SSD Buttons
		ssdButtons[0] = new JRadioButton("Small (Under 100 GBs)");
		ssdButtons[1] = new JRadioButton("Medium (128 GBs)");
		ssdButtons[2] = new JRadioButton("High-End (256GBs or 512GBs)");
		ssdButtons[3] = new JRadioButton("Ultra (1000GBs+)");

		// Create the RAM Buttons
		ramButtons[0] = new JRadioButton("Small (4GBs)");
		ramButtons[1] = new JRadioButton("Medium (8GBs)");
		ramButtons[2] = new JRadioButton("High-End (16GBs)");
		ramButtons[3] = new JRadioButton("Ultra (16GBs+)");

		// Add the brand buttons to a ButtonGroup
		ButtonGroup brandGroup = new ButtonGroup();
		for (int i = 0; i < brandButtons.length; i++) {
			brandGroup.add(brandButtons[i]);
			brandButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
		}

		// Add the price buttons to a ButtonGroup
		ButtonGroup priceGroup = new ButtonGroup();
		for (int i = 0; i < priceButtons.length; i++) {
			priceGroup.add(priceButtons[i]);
			priceButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
		}

		// Add the CPU buttons to a ButtonGroup
		ButtonGroup cpuGroup = new ButtonGroup();
		for (int i = 0; i < gpuButtons.length; i++) {
			cpuGroup.add(gpuButtons[i]);
			gpuButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
		}

		// Add the SSD buttons to a ButtonGroup
		ButtonGroup ssdGroup = new ButtonGroup();
		for (int i = 0; i < ssdButtons.length; i++) {
			ssdGroup.add(ssdButtons[i]);
			ssdButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
		}

		// Add the RAM buttons to a Button Group
		ButtonGroup ramGroup = new ButtonGroup();
		for (int i = 0; i < ramButtons.length; i++) {
			ramGroup.add(ramButtons[i]);
			ramButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
		}

		// Add the components to the panel
		panel.add(brandLabel);
		for (int i = 0; i < brandButtons.length; i++) {
			brandpanel.add(brandButtons[i]);
			panel.add(brandpanel);

		}
		panel.add(priceLabel);
		for (int i = 0; i < priceButtons.length; i++) {
			pricepanel.add(priceButtons[i]);
			panel.add(pricepanel);
		}

		panel.add(gpuLabel);
		for (int i = 0; i < gpuButtons.length; i++) {
			gpupanel.add(gpuButtons[i]);
			panel.add(gpupanel);
		}

		panel.add(ssdLabel);
		for (int i = 0; i < ssdButtons.length; i++) {
			ssdpanel.add(ssdButtons[i]);
			panel.add(ssdpanel);
		}

		panel.add(ramLabel);
		for (int i = 0; i < ramButtons.length; i++) {
			rampanel.add(ramButtons[i]);
			panel.add(rampanel);
		}

		panel.add(submitButton);

		// Add an ActionListener to the submit button to store the user's selections in
		// an array
		submitButton.addActionListener(e -> {
			String brand = "";
			String price = "";
			String gpu = "";
			String ssd = "";
			String ram = "";

			// Stores selected Brand
			for (int i = 0; i < brandButtons.length; i++) {
				if (brandButtons[i].isSelected()) {
					brand = brandButtons[i].getText();
					break;
				}
			}

			// Stores Selected price
			for (int i = 0; i < priceButtons.length; i++) {
				if (priceButtons[i].isSelected()) {
					price = priceButtons[i].getText();
					break;
				}
			}

			// Stores selected CPU
			for (int i = 0; i < gpuButtons.length; i++) {
				if (gpuButtons[i].isSelected()) {
					gpu = gpuButtons[i].getText();
					break;
				}
			}

			// Stores Selected SSD
			for (int i = 0; i < ssdButtons.length; i++) {
				if (ssdButtons[i].isSelected()) {
					ssd = ssdButtons[i].getText();
					break;
				}
			}

			// Stores Selected RAM
			for (int i = 0; i < ramButtons.length; i++) {
				if (ramButtons[i].isSelected()) {
					ram = ramButtons[i].getText();
					break;
				}
			}

			String[] selections = { brand, price, gpu, ssd, ram };

			// Not really needed but its there for you to see
			System.out.println("User selections: " + Arrays.toString(selections));
			this.dispose();
			ResultsApplication.afterSubmit(selections, FileInput.laptopArray, chosenLaptops);
		});

		// Add the panel to the JFrame
		add(panel);

		// Show the JFrame
		setVisible(true);
	}

	public static void main(String[] args) {
		Survey survey = new Survey(null, null);
	}
}