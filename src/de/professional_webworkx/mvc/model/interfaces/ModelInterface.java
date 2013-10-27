package de.professional_webworkx.mvc.model.interfaces;

import de.professional_webworkx.mvc.view.interfaces.ViewObserver;

public interface ModelInterface {

	public abstract void register(ViewObserver observer);
	public abstract void unregister(ViewObserver observer);
}
