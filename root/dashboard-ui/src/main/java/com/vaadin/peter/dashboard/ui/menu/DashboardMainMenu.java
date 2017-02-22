package com.vaadin.peter.dashboard.ui.menu;

import com.vaadin.peter.dashboard.ui.IsComponent;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;

/**
 * DashboardMainMenu is the interface defining the base type of any main menu
 * used in the Dashboard.
 * 
 * @author Peter / Vaadin
 */
public interface DashboardMainMenu extends IsComponent<CssLayout> {

	/**
	 * Adds new item to this {@link DashboardMainMenu} with given details.
	 * 
	 * @param translationKey
	 * @param navigationTarget
	 *            name of the view bean into which the menu item should navigate
	 *            the user into
	 * @return {@link MainMenuItem} handle that can be used for removing or
	 *         changing the status of the menu item.
	 */
	default MainMenuItem addItem(String translationKey, String navigationTarget) {
		return this.addItem(translationKey, null, navigationTarget);
	}

	/**
	 * Adds new item to this {@link DashboardMainMenu} with given details.
	 * 
	 * @param translationKey
	 * @param icon
	 * @param navigationTarget
	 *            name of the view bean into which the menu item should navigate
	 *            the user into
	 * @return {@link MainMenuItem} handle that can be used for removing or
	 *         changing the status of the menu item.
	 */
	MainMenuItem addItem(String translationKey, Resource icon, String navigationTarget);

	/**
	 * Removes given {@link MainMenuItem} from this menu
	 * 
	 * @param item
	 * @return true if item was removed, false otherwise.
	 */
	boolean removeItem(MainMenuItem item);

	/**
	 * MainMenuItem describes a handle for accessing added {@link MainMenuItem}s
	 */
	public interface MainMenuItem extends IsComponent<Button> {
	}
}
