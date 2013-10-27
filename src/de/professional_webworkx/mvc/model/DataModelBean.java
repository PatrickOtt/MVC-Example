package de.professional_webworkx.mvc.model;

import java.util.ArrayList;
import java.util.List;

import de.professional_webworkx.mvc.model.interfaces.ModelInterface;
import de.professional_webworkx.mvc.view.interfaces.ViewObserver;

public class DataModelBean implements ModelInterface {

	private double temperature;

	// List of Observers 
	private List<ViewObserver> observers = new ArrayList<ViewObserver>();
	public DataModelBean() {
		
	}
	
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		updateObserver();
	}

	@Override
	public void register(ViewObserver observer) {
		if(!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void unregister(ViewObserver observer) {
		if(observers.contains(observer)) {
			observers.remove(observer);
		}
	}
	
	public void updateObserver() {
		for(ViewObserver vo : observers) {
			vo.update(temperature);
		}
	}
	
}
