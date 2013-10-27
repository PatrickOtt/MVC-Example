package de.professional_webworkx.mvc.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.nio.ByteOrder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.professional_webworkx.mvc.controller.Controller;
import de.professional_webworkx.mvc.view.interfaces.ViewObserver;

public class InputView extends JFrame implements ViewObserver {

	private Controller controller;
	private JTextField temperature;
	private JButton updateTemperature;
	private JTextField input;
	
	public InputView(final Controller controller) {
		this.controller = controller;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 480);
		JPanel panel 	= new JPanel(new BorderLayout());
		JPanel p1		= new JPanel(new GridLayout(0, 2));
		input = new JTextField();
		p1.add(input);
		updateTemperature = new JButton("Speichern");
		p1.add(updateTemperature);
		
		temperature = new JTextField(10);
		panel.add(p1, BorderLayout.NORTH);
		panel.add(temperature, BorderLayout.SOUTH);
		
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void update(double temperature) {
		this.temperature.setText(temperature + "°C");
	}

	public JTextField getTemperature() {
		return temperature;
	}

	public void setTemperature(JTextField temperature) {
		this.temperature = temperature;
	}

	public JButton getUpdateTemperature() {
		return updateTemperature;
	}

	public JTextField getInput() {
		return input;
	}

	public void setInput(JTextField input) {
		this.input = input;
	}
	
}
