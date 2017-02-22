package com.vaadin.peter.dashboard.ui.menu;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.peter.dashboard.I18NProvider;
import com.vaadin.peter.dashboard.NavigationManager;
import com.vaadin.peter.dashboard.ui.DashboardTheme;
import com.vaadin.server.Resource;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * SimpleDashboardMenu
 * 
 * @author peterl1084
 *
 */
class SimpleDashboardMenu extends CssLayout implements DashboardMainMenu {

	@Autowired
	private NavigationManager navigationManager;

	private Button logo;
	private CssLayout menuItemContainer;

	public SimpleDashboardMenu() {
		setPrimaryStyleName(ValoTheme.MENU_ROOT);
		setStyleName(DashboardTheme.MenuStyles.MAIN_MENU);

		logo = new Button();
		logo.setPrimaryStyleName(ValoTheme.MENU_LOGO);


		menuItemContainer = new CssLayout();
		menuItemContainer.setStyleName(ValoTheme.MENU_PART);

		addComponents(logo, menuItemContainer);
	}

	@Override
	public void attach() {
		super.attach();
		UI ui = getUI();

		if (ui == null) {
			ui = UI.getCurrent();
		}

		if (ui == null) {
			throw new IllegalStateException("Could not find UI instance when attaching the menu");
		}

		Responsive.makeResponsive(ui);
		ui.addStyleName(ValoTheme.UI_WITH_MENU);
	}

	@Override
	public CssLayout asComponent() {
		return this;
	}

	@Override
	public MainMenuItem addItem(String translationKey, Resource icon, String navigationTarget) {
		SimpleMainMenuItem menuItem = new SimpleMainMenuItem(translationKey, icon, navigationTarget);
		menuItemContainer.addComponent(menuItem);

		return menuItem;
	}

	@Override
	public boolean removeItem(MainMenuItem item) {
		if (item == null) {
			return false;
		}

		if (menuItemContainer.getComponentIndex(item.asComponent()) != -1) {
			menuItemContainer.removeComponent(item.asComponent());
			return true;
		}

		return false;
	}

	private class SimpleMainMenuItem extends Button implements MainMenuItem {

		public SimpleMainMenuItem(String translationKey, Resource icon, String navigationTarget) {
			super(I18NProvider.get(translationKey), icon);
			setPrimaryStyleName(ValoTheme.MENU_ITEM);

			addClickListener(e -> navigationManager.navigateTo(navigationTarget));
		}

		@Override
		public Button asComponent() {
			return this;
		}
	}
}
