import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
//This class creates the pizza that is delivered to the user
public class LittleCeaserDeliveryPizza {
	
	//This block creates the attributes needed for the program
	private int time = (int)(20*Math.random()+15);
	private Font myFont = new Font("Arial", Font.BOLD, 30);
	
	//This is the constructor, it has a boolean array as its parameters
	public LittleCeaserDeliveryPizza(boolean [] toppings) {	
		
		//This block creates the frame, panel and labels needed for the delivery program
		JFrame frame = new JFrame(time+" minutes later...");
		JPanel panel = new JPanel();
		JLabel lblPizza = new JLabel();
		JLabel lblMushrooms = new JLabel();
		JLabel lblGreenPeppers = new JLabel();
		JLabel lblOnions = new JLabel();
		JLabel lblHotPeppers = new JLabel();
		JLabel lblPepperoni = new JLabel();
		JLabel lblBacon = new JLabel();
		JLabel lblTomatoes = new JLabel();
		JLabel lblExtraCheese = new JLabel();
		JLabel lblTime = new JLabel("The delivery time was "+time+" minutes");
		JLabel lblDelivery = new JLabel("Congratulations! Your pizza is free!");
		panel.setLayout(null);
		
		
		//If the customer ordered a pizza with mushrooms, mushrooms will appear on the pizza
		if (toppings[0]) {
			ImageIcon imgMushroom = new ImageIcon("mushroom.png");
			lblMushrooms.setIcon(imgMushroom);
			lblMushrooms.setBounds(130,280,150,150);
			panel.add(lblMushrooms);
		}
		
		//If the customer ordered a pizza with green peppers, mushrooms will appear on the green peppers
		if (toppings[1]) {
			ImageIcon imgGreenPeppers = new ImageIcon("greenPepper.png");
			lblGreenPeppers.setIcon(imgGreenPeppers);
			lblGreenPeppers.setBounds(150,150,150,150);
			panel.add(lblGreenPeppers);
		}
		
		//If the customer ordered a pizza with onions, onions will appear on the pizza
		if (toppings[2]) {
			ImageIcon imgOnions = new ImageIcon("onion.png");
			lblOnions.setIcon(imgOnions);
			lblOnions.setBounds(375,170,150,150);
			panel.add(lblOnions);
		}
		
		//If the customer ordered a pizza with hot peppers, hot peppers will appear on the pizza
		if (toppings[3]) {
			ImageIcon imgHotPeppers = new ImageIcon("hotPepper.png");
			lblHotPeppers.setIcon(imgHotPeppers);
			lblHotPeppers.setBounds(175,325,150,150);
			panel.add(lblHotPeppers);
		}
		
		//If the customer ordered a pizza with pepperoni, pepperoni will appear on the pizza
		if (toppings[4]) {
			ImageIcon imgPepperoni = new ImageIcon("pepperoni.png");
			lblPepperoni.setIcon(imgPepperoni);
			lblPepperoni.setBounds(360,285,150,150);
			panel.add(lblPepperoni);
		}
		
		//If the customer ordered a pizza with bacon, bacon will appear on the pizza
		if (toppings[5]) {
			ImageIcon imgBacon = new ImageIcon("bacon.png");
			lblBacon.setIcon(imgBacon);
			lblBacon.setBounds(260,210,150,150);
			panel.add(lblBacon);
		}
		
		//If the customer ordered a pizza with tomatoes, tomatoes will appear on the pizza
		if (toppings[6]) {
			ImageIcon imgTomatoes = new ImageIcon("tomato.png");
			lblTomatoes.setIcon(imgTomatoes);
			lblTomatoes.setBounds(285,120,150,150);
			panel.add(lblTomatoes);
		}
		
		//If the customer ordered a pizza with extra cheese, extra cheese will appear on the pizza
		if (toppings[7]) {
			ImageIcon imgExtraCheese= new ImageIcon("cheese.png");
			lblExtraCheese.setIcon(imgExtraCheese);
			lblExtraCheese.setBounds(280,380,150,150);
			panel.add(lblExtraCheese);
		}
		
		//This creates the pizza image icon, and adds it to the label. The label is then added to the panel
		ImageIcon imgPizza = new ImageIcon("pizza.png");
		lblPizza.setIcon(imgPizza);
		lblPizza.setBounds(95,25,600,600);
		panel.add(lblPizza);
		
		//This creates the label which displays the delivery time and adds it to the panel
		lblTime.setFont(myFont);
		lblTime.setBounds(80,-50,600,150);
		panel.add(lblTime);
		
		//If the delivery time is greater than thirty minutes, this block add the label thats says the pizza is free to the panel
		if (time >=30) {
			lblDelivery.setFont(myFont);
			lblDelivery.setForeground(Color.GREEN);
			lblDelivery.setBounds(65,0,600,150);
			panel.add(lblDelivery);
		}
		
		//This block sets the conditions for the frame
		frame.setContentPane(panel);
		frame.setBounds(250,50,650,600);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
