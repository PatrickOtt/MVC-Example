package de.professional_webworkx.mvc.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import de.professional_webworkx.mvc.view.interfaces.ViewObserver;

public class SliderView extends JFrame implements ViewObserver {

	private JSlider slider;
	
	public SliderView() {
		
		this.setTitle("SliderView");
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		slider = new JSlider(SwingConstants.HORIZONTAL, -10, 40, 5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(30);
		
		panel.add(slider);
		
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}
	@Override
	public void update(double temperature) {
		slider.setValue((int)temperature);
		
	}
	public JSlider getSlider() {
		return slider;
	}
	public void setSlider(JSlider slider) {
		this.slider = slider;
	}

	
}
