import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Flyer {

	public static void main(String[] args) {

		Flyer startProgram = new Flyer();
		startProgram.createAirplaneData();

		AirplaneQuestions myQuestions = new AirplaneQuestions();

		Frame frame = new Frame("Engine Type");
		Label label = new Label("Choose your Engine");
		Choice choice = new Choice();
		frame.add(label);
		frame.add(choice);
		choice.add("Jet");
		choice.add("Propeller");
		Button button = new Button("Submit");
		frame.add(button);
		frame.setLayout(new FlowLayout());
		frame.setLocation(250, 250);
		frame.setSize(300, 100);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Frame frame1 = new Frame("Number of Engines");
		Label label1 = new Label("Choose your number of Engines");
		Choice choice1 = new Choice();
		frame1.add(label1);
		frame1.add(choice1);
		choice1.add("1");
		choice1.add("2");
		frame1.setLayout(new FlowLayout());
		frame1.setLocation(250, 250);
		frame1.setSize(300, 100);
		frame1.setVisible(false);
		Button button2 = new Button("Submit");
		frame1.add(button2);
		frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Frame frame2 = new Frame("Engine Location");
		Label label2 = new Label("Choose your engine location");
		Choice choice2 = new Choice();
		frame2.add(label2);
		frame2.add(choice2);
		choice2.add("Nose");
		choice2.add("Tail");
		choice2.add("Body");
		Button button3 = new Button("Submit");
		frame2.add(button3);
		frame2.setLayout(new FlowLayout());
		frame2.setLocation(250, 250);
		frame2.setSize(300, 100);
		frame2.setVisible(false);
		frame2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});


		
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildButtonActionPerformed(e);
			}

			private void buildButtonActionPerformed(ActionEvent e) {
				if(choice.getSelectedItem().equals("Jet")) {
					frame.setVisible(false);
					frame1.setVisible(true);
					
				} else {
					frame.setVisible(false);
					frame1.setVisible(true);
				}
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildButtonActionPerformed(e);
			}

			private void buildButtonActionPerformed(ActionEvent e) {
				if(choice1.getSelectedItem().equals("2")) {
					frame.setVisible(false);
					frame1.setVisible(false);
					frame2.setVisible(true);
					
				} else {
					frame1.setVisible(false);
					frame2.setVisible(true);
				}
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildButtonActionPerformed(e);
			}

			private void buildButtonActionPerformed(ActionEvent e) {
				if(choice.getSelectedItem().equals("Jet") && choice1.getSelectedItem().equals("1") && choice2.getSelectedItem().equals("Body")) {
					frame2.setVisible(false);
					JOptionPane.showMessageDialog(null, "Your plane is a F16 or a F35");
				}
				
				else if(choice.getSelectedItem().equals("Jet") && choice2.getSelectedItem().equals("Body") && (choice1.getSelectedItem().equals("2"))) {
					frame2.setVisible(false);
					JOptionPane.showMessageDialog(null, "List of planes with these settings: F15, F18, and a F22");
				}
				else if(choice.getSelectedItem().equals("Propeller") && choice2.getSelectedItem().equals("Tail") && (choice1.getSelectedItem().equals("2"))) {
					frame2.setVisible(false);
					JOptionPane.showMessageDialog(null, "Your plane is a A10");
				} else {
					frame2.setVisible(false);
					not();
				}
			}
		});


	}
	
	static void not() {
		JOptionPane.showMessageDialog(null, "We don't have that plane in our database");
	}

	private void createAirplaneData() {
		AirplaneData F15 = new AirplaneData();
		F15.setEngineType("jet");
		F15.setEngineNumber(2);
		F15.setEngineLocation("body");

		AirplaneData F16 = new AirplaneData();
		F16.setEngineType("jet");
		F16.setEngineNumber(1);
		F16.setEngineLocation("body");

		AirplaneData F18 = new AirplaneData();
		F18.setEngineType("jet");
		F18.setEngineNumber(2);
		F18.setEngineLocation("body");

		AirplaneData F22 = new AirplaneData();
		F22.setEngineType("jet");
		F22.setEngineNumber(2);
		F22.setEngineLocation("body");

		AirplaneData F35 = new AirplaneData();
		F35.setEngineType("jet");
		F35.setEngineNumber(1);
		F35.setEngineLocation("body");

		AirplaneData A10 = new AirplaneData();
		A10.setEngineType("propeller");
		A10.setEngineNumber(2);
		A10.setEngineLocation("tail");

	}

}
