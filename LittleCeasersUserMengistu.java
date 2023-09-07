import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
public class LittleCeasersUserMengistu implements WindowListener{
//Little Ceaser's Program
//Programmed by Caleb Mengistu on June 14 2023
//This program's function is to take a user's pizza order, and deliver the pizza to the user
//This program takes input from the user regarding the pizza's size, the pizza's toppings, and the beverages
//When the user presses the calculate button, it calculates and displays the subtotal cost, the delivery fee, the tax, and the grand total
//When the user presses the checkout button, it asks the user to pay, and delivers the pizza
	
	public static void main(String[] args) {
		new LittleCeasersUserMengistu();
	}
	
	public LittleCeasersUserMengistu() {
		//This block creates the frame, panel and labels used in the program. The labels are in the user class because they are unaltered.
		JFrame frame = new JFrame("Little Ceaser's");
		JPanel panel = new JPanel(); 
		JLabel lblLogo = new JLabel();
		JLabel lblPayment = new JLabel();
		JLabel lblSubTotal = new JLabel("SUBTOTAL:");
		JLabel lblDeliveryFee = new JLabel("DELIVERY FEE:");
		JLabel lblTax = new JLabel("HST:");
		JLabel lblGrandTotal = new JLabel("GRAND TOTAL:");
		JLabel lblToppingsNum = new JLabel("First three (3) toppings are free!");
		panel.setLayout(null);
		frame.addWindowListener(this);
		
		//This block calls the demo class used in this program. It adds the components of the other class to the user class, and gives the demo class access to the frame
		LittleCeasersDemo lcd = new LittleCeasersDemo();
		lcd.addComponents(panel);
		lcd.getFrame(frame);
		
		//This block adds the images labels to the panel
		ImageIcon imgLogo = new ImageIcon("logo.png");
		lblLogo.setIcon(imgLogo);
		lblLogo.setBounds(60,-25,600,200);
		panel.add(lblLogo);
		ImageIcon imgPayment = new ImageIcon("payment.png");
		lblPayment.setIcon(imgPayment);
		lblPayment.setBounds(30,340,100,200);
		panel.add(lblPayment);
		
		//This block adds the text labels to the panel
		lblToppingsNum.setBounds(205,270,250,30);
		panel.add(lblToppingsNum);
		lblSubTotal.setBounds(200,370,100,30);
		panel.add(lblSubTotal);
		lblDeliveryFee.setBounds(200,405,100,30);
		panel.add(lblDeliveryFee);
		lblTax.setBounds(200,440,100,30);
		panel.add(lblTax);
		lblGrandTotal.setBounds(200,475,100,30);
		panel.add(lblGrandTotal);
		
		//This block sets the conditions for the frame
		frame.setContentPane(panel);
		frame.setBounds(250,50,650,600);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void windowOpened (WindowEvent e) {
		
	}
	
	//This method is when the window is closed, and prompts the user, asking them if they want to exit
	public void windowClosing (WindowEvent e) {
		if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?" , "Little Ceaser's", JOptionPane.YES_NO_OPTION)== 0) {
			JOptionPane.showMessageDialog(null, "Thank you for choosing Little Ceaser's", "Little Ceaser's", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	public void windowClosed (WindowEvent e) {
		
	}
	
	public void windowActivated (WindowEvent e) {
		
	}
	
	public void windowDeactivated (WindowEvent e) {
		
	}
	
	public void windowIconified (WindowEvent e) {
		
	}
	
	public void windowDeiconified (WindowEvent e) {
		
	}
}
