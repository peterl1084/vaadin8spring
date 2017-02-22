package com.vaadin.peter.dashboard.ui;

import com.vaadin.ui.Component;

/**
 * IsComponent is a role interface describing that the implementor can safely be
 * cast to Vaadin component. The purpose of this interface is to mark types
 * which are accessible as components but don't want to expose the Vaadin
 * Component API directly.
 * 
 * @author Peter / Vaadin
 *
 * @param <C>
 *            type of the Component
 */
public interface IsComponent<C extends Component> {

	/**
	 * @return this same object as Vaadin Component of type C.
	 */
	C asComponent();
}
