package de.professional_webworkx.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.professional_webworkx.mvc.model.DataModelBean;
import de.professional_webworkx.mvc.view.InputView;
import de.professional_webworkx.mvc.view.SliderView;

public class Controller {

	private InputView view;
	private SliderView sliderView;
	private DataModelBean modelBean;
	
	private JButton updateTemperature;
	
	public Controller() {
		this.view 		= new InputView(this);
		this.sliderView	= new SliderView();
		this.modelBean	= new DataModelBean();
		
		registerActionListener();
		registerObserver();
	}

	private void registerObserver() {
		modelBean.register(view);
		modelBean.register(sliderView);
	}

	private void registerActionListener() {
		
		this.updateTemperature = view.getUpdateTemperature();
		this.updateTemperature.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double newTemperature = 0.0;
				try {
					newTemperature = Double.parseDouble(view.getInput().getText());
				} catch (NumberFormatException ex) {
					modelBean.setTemperature(0.0);
				}
				modelBean.setTemperature(newTemperature);
			}
		});
		
		
		final JSlider slider = sliderView.getSlider();
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				modelBean.setTemperature(value);
			}
		});
	}
}
