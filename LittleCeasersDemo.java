import java.awt.Color;

import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;
//This is the demo class, which has the components of the panel that are altered by the user
public class LittleCeasersDemo implements ActionListener{
	//This block creates the components used in the program. They are in the demo class because they are altered by the user
	JFrame frame;
	JPanel sizePanel, toppingsPanel, beveragesPanel;
	JRadioButton rbSmall, rbMedium, rbLarge, rbParty;
	JComboBox<Integer> cbCoke, cbSprite, cbOrange, cbRootBeer;
	JCheckBox [] chkToppings = {createCheckBox("Mushrooms"), createCheckBox("Green Peppers"), createCheckBox("Onions"), createCheckBox("Hot Peppers"), createCheckBox("Pepperoni"), createCheckBox("Bacon"), createCheckBox("Tomatoes"), createCheckBox("Extra Cheese")};
	boolean [] toppingTypes = {false,false,false,false,false,false,false,false};
	JLabel lblSize, lblToppings, lblBeverages, lblsubTotal, lblDelivery, lblTax, lblGrandTotal, lblCoke, lblSprite, lblOrange, lblRootBeer;
	JButton btnCalculate, btnClear, btnCheckout, btnExit;
	NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.CANADA);
	private int toppings = 0;
	private Integer [] beverages = {0,1,2,3,4,5,6};
	ButtonGroup buttons = new ButtonGroup();
	private double sizeTotal=0, toppingsTotal=0, deliveryTotal, beveragesTotal=0, total, grandTotal;
	ImageIcon icon = new ImageIcon ("icon.png");
	ImageIcon money = new ImageIcon ("dollars.jpg");
	
	public LittleCeasersDemo() {
		//This block creates the radiobuttons using the createRadioButton method
		rbSmall = createRadioButton("Small");
		rbMedium = createRadioButton("Medium");
		rbLarge = createRadioButton("Large");
		rbParty = createRadioButton("Party");		
		
		//This block creates the sizePanel and adds the radiobuttons to it
		sizePanel = createPanel (15,135,110,"SIZE");
		sizePanel.add(rbSmall);
		sizePanel.add(rbMedium);
		sizePanel.add(rbLarge);
		sizePanel.add(rbParty);
		
		//This block creates the toppingsPanel and adds the checkBoxes to it
		toppingsPanel = createPanel (170,135,250,"TOPPINGS");
		toppingsPanel.add(chkToppings[0]);
		toppingsPanel.add(chkToppings[1]);
		toppingsPanel.add(chkToppings[2]);
		toppingsPanel.add(chkToppings[3]);
		chkToppings[4].setBounds(310,159,100,15);
		chkToppings[5].setBounds(310,182,100,15);
		chkToppings[6].setBounds(310,205,100,15);
		chkToppings[7].setBounds(310,228,100,15);

		//This block creates the beveragesPanel and adds the labels to it. It also adds the comboboxes using the createComboBox method
		beveragesPanel = createPanel (460,135,165,"BEVERAGES");
		lblCoke = createLabel(480,150,"Coke",false);
		lblSprite = createLabel(480,178,"Sprite",false);
		lblOrange = createLabel(480,206,"Orange",false);
		lblRootBeer = createLabel(480,234,"Root Beer",false);
		cbCoke = createComboBox(beverages,150);
		cbSprite = createComboBox(beverages,180);
		cbOrange = createComboBox(beverages,210);
		cbRootBeer = createComboBox(beverages,240);
		
		//This block creates the labels which display the price of the separate components of the pizza
		lblSize = createLabel(20,300,null,true);
		lblToppings = createLabel(250,300,null,true);
		lblBeverages = createLabel(495,300,null,true);
		
		//This block adds the buttons need to perform the programs functions
		btnCalculate = createButton(365,"CALCULATE");
		btnClear = createButton(405,"CLEAR");
		btnCheckout = createButton(445,"CHECKOUT");
		btnExit = createButton(485,"EXIT");
		
		//This block creates the labels that display the fees and grand total
		lblsubTotal = createLabel(305,375,null,true);
		lblDelivery = createLabel(305,410,null,true);
		lblTax = createLabel(305,445,null,true);
		lblGrandTotal = createLabel(305,480,null,true);
		
		//This block adds the radiobuttons to the buttons group
		buttons.add(rbSmall);
		buttons.add(rbMedium);
		buttons.add(rbLarge);
		buttons.add(rbParty);
	}
	
	//This method adds all of the components to the panel in the parameters
	public void addComponents(JPanel p) {
		p.add(sizePanel);
		p.add(toppingsPanel);
		p.add(beveragesPanel);
		p.add(lblSize);
		p.add(lblToppings);
		p.add(lblBeverages);
		p.add(chkToppings[4]);
		p.add(chkToppings[5]);
		p.add(chkToppings[6]);
		p.add(chkToppings[7]);
		p.add(lblCoke);
		p.add(lblSprite);
		p.add(lblOrange);
		p.add(lblRootBeer);
		p.add(btnCalculate);
		p.add(btnClear);
		p.add(btnCheckout);
		p.add(btnExit);
		p.add(cbCoke);
		p.add(cbOrange);
		p.add(cbRootBeer);
		p.add(cbSprite);
		p.add(lblsubTotal);
		p.add(lblDelivery);
		p.add(lblTax);
		p.add(lblGrandTotal);
	}
	
	//This method gets the frame from the user class
	public void getFrame(JFrame frame) {
		this.frame = frame;
	}
	
	//This method creates radiobuttons
	public JRadioButton createRadioButton(String title) {
		JRadioButton rb = new JRadioButton(title);
		rb.addActionListener(this);
		return rb;
	}
	
	//This method creates checkboxes
	public JCheckBox createCheckBox(String title) {
		JCheckBox chk = new JCheckBox(title);
		chk.addActionListener(this);
		return chk;
	}
	
	//This method creates labels
	public JLabel createLabel(int x, int y, String title, boolean type) {
		JLabel lbl = new JLabel(title);
		lbl.setBounds(x,y,100,25);
		if (type) {
			lbl.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			lbl.setOpaque(true);
			lbl.setHorizontalAlignment(JLabel.CENTER);
		}	
		return lbl;
	}
	
	//This method creates comboboxes
	public JComboBox<Integer> createComboBox(Integer[] array, int y) {
		JComboBox<Integer> cb = new JComboBox<Integer>(array);
		cb.setBounds(550,y,65,20);
		cb.addActionListener(this);
		return cb;
	}
	
	//This method creates buttons
	public JButton createButton(int y, String title) {
		JButton btn = new JButton(title);
		btn.setBounds(485,y,120,30);
		btn.addActionListener(this);
		return btn;
	}
	
	//This method creates panels
	public JPanel createPanel (int x, int y, int w, String title) {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setBounds(x,y,w,135);
		p.setBorder(BorderFactory.createTitledBorder(title));
		p.setOpaque(false);
		return p;
	}
	
	//When an action listener object is selected, this method runs
	public void actionPerformed(ActionEvent e) {
		//When a radiobuttons is selected, the price of the pizza is updated based on which size was chosen
		if (e.getSource() instanceof JRadioButton) {
			if (e.getSource() == rbSmall) {
				sizeTotal = 7.99;
				lblSize.setText(currency.format(sizeTotal));
			}				
			else if (e.getSource() == rbMedium) {
				sizeTotal = 8.99;
				lblSize.setText(currency.format(sizeTotal));
			}
			else if (e.getSource() == rbLarge) {
				sizeTotal = 9.99;
				lblSize.setText(currency.format(sizeTotal));
			}
			else {
				sizeTotal = 10.99;
				lblSize.setText(currency.format(sizeTotal));
			}
		}
		
		//When a checkbox is selected, the price of the toppings is updated based on how many toppings were ordered
		else if (e.getSource() instanceof JCheckBox) {
			for (int i = 0; i < chkToppings.length; i++) {
				if (e.getSource() == chkToppings[i]) 
					if (chkToppings[i].isSelected()) {
						toppings++;
						toppingTypes[i] = true;
					}
					else {
						toppings--;
						toppingTypes[i] = false;
					}
			}
			if (toppings > 3) {
				toppingsTotal = toppings -3;
				lblToppings.setText(currency.format(toppingsTotal));
			}
			else {
				toppingsTotal = 0;
				lblToppings.setText(null);	
			}
		}
		
		//When a combobox is selected, the price of the beverages is updated based on how many beverages were ordered
		else if (e.getSource() instanceof JComboBox) {
			beveragesTotal = 0.99*((int)cbCoke.getSelectedItem()+(int)cbSprite.getSelectedItem()+(int)cbOrange.getSelectedItem()+(int)cbRootBeer.getSelectedItem());
			lblBeverages.setText(currency.format(beveragesTotal));
		}
		
		
		else {
			//If the clear button is selected, then everything on the panel is reverted to its original state
			if (e.getSource() == btnClear) {
				buttons.clearSelection();
				for (int i = 0; i < chkToppings.length; i++) {
					chkToppings[i].setSelected(false);
					toppingTypes[i] = false;
				}
				cbCoke.setSelectedIndex(0);
				cbSprite.setSelectedIndex(0);
				cbOrange.setSelectedIndex(0);
				cbRootBeer.setSelectedIndex(0);
				lblSize.setText(null);
				lblToppings.setText(null);
				lblBeverages.setText(null);
				lblsubTotal.setText(null);
				lblDelivery.setText(null);
				lblTax.setText(null);
				lblGrandTotal.setText(null);
				lblDelivery.setBackground(Color.WHITE);
				toppings = 0;
				sizeTotal=0; 
				toppingsTotal=0; 
				beveragesTotal=0;
				total=0;
			}
			
			//If the exit button is chosen then it will prompt the user with a message making sure if they want to exit
			else if (e.getSource() == btnExit){
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?" , "Little Ceaser's", JOptionPane.YES_NO_OPTION)== 0) {
					JOptionPane.showMessageDialog(null, "Thank you for choosing Little Ceaser's", "Little Ceaser's", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
			
			//This else statement includes both the calculate and checkout button, because the final cost must be calculated before you checkout
			else {
				
				//This calculates and printsthe final cost
				if (sizeTotal > 0){
					total = sizeTotal+ toppingsTotal+ beveragesTotal;
					lblsubTotal.setText(currency.format(total));
					if (total > 15) {
						lblDelivery.setBackground(Color.GREEN);
						lblDelivery.setText("FREE");
						deliveryTotal = 0;
					}
					else {
						lblDelivery.setBackground(Color.WHITE);
						lblDelivery.setText(currency.format(3));
						deliveryTotal = 3;
					}
					lblTax.setText(currency.format(total*0.13));
					grandTotal = total*1.13 + deliveryTotal;
					lblGrandTotal.setText(currency.format(grandTotal));
					
					//When the checkout button is selected, it will confirm the order, ask for a type of payment, and call the method that delivers the pizza
					if(e.getSource() == btnCheckout) {
						if (JOptionPane.showConfirmDialog(null,"Is this order correct?" , "Little Ceaser's", JOptionPane.YES_NO_OPTION)== 0) {
							String [] options = {"Interac","MasterCard","Visa"};
							int again;
							//System.out.print(JOptionPane.showOptionDialog(null, "How would you like to pay?\nThe total is: "+currency.format(grandTotal), "Little Ceasers", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, money, options, options[1]));
							do {
								again = JOptionPane.showOptionDialog(null, "How would you like to pay?\nThe total is: "+currency.format(grandTotal), "Little Ceasers", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, money, options, options[1]);
							}
							while(again == -1);
							JOptionPane.showMessageDialog(null, "Thank you for ordering from Little Ceaser's\nYour pizza will be delivered in 30 minutes or less or its free!", "Little Ceaser's", 0, icon);
							frame.setVisible(false);
							new LittleCeaserDeliveryPizza(toppingTypes);
						}
					}
				}
				
				//This occurs if the user did not enter a pizza size
				else {
					JOptionPane.showMessageDialog(null, "Your order could not be completed!\nPlease select a pizza size.", "Little Ceaser's", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
