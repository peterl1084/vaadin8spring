package com.vaadin.peter.dashboard.ui.menu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vaadin.icons.VaadinIcons;

/**
 * @ShowInMenu is an annotation used in all such view definitions that are to be
 *             listed in the {@link DashboardMainMenu} as menu items.
 * @author Peter / Vaadin
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ShowInMenu {

	/**
	 * @return full key to the property name describing the name of the menu
	 *         item.
	 */
	String translationKey();

	/**
	 * @return VaadinIcon used as menu item's icon.
	 */
	VaadinIcons icon();

	/**
	 * @return the position number of this menu item.
	 */
	int order();
}
