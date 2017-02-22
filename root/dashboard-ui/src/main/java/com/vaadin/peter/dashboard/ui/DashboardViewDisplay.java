package com.vaadin.peter.dashboard.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.peter.dashboard.ui.menu.DashboardMainMenu;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ValoTheme;

@SpringViewDisplay
public class DashboardViewDisplay extends CssLayout implements ViewDisplay, IsComponent<CssLayout> {

	private CssLayout contentArea;

	private Panel viewArea;

	public DashboardViewDisplay() {
		setSizeFull();

		setPrimaryStyleName(DashboardTheme.ViewDisplayStyles.VIEW_DISPLAY);

		contentArea = new CssLayout();
		contentArea.setPrimaryStyleName(DashboardTheme.ViewDisplayStyles.CONTENT_AREA);

		viewArea = new Panel();
		viewArea.setPrimaryStyleName(DashboardTheme.ViewDisplayStyles.VIEW_PANEL);
		viewArea.setStyleName(ValoTheme.PANEL_BORDERLESS);
		viewArea.setSizeUndefined();
		viewArea.setHeight(100, Unit.PERCENTAGE);

		contentArea.addComponent(viewArea);

		addComponent(contentArea);
	}

	@Override
	public void showView(View view) {
		if (view instanceof IsComponent) {
			viewArea.setContent(IsComponent.class.cast(view).asComponent());
		} else if (view instanceof Component) {
			viewArea.setContent(Component.class.cast(view));
		} else {
			throw new UnsupportedOperationException("Got view of type " + view.getClass().getCanonicalName()
					+ " which is not a component and does not implement " + IsComponent.class.getCanonicalName());
		}
	}

	@Autowired(required = false)
	public void setHeader(DashboardHeader header) {
		contentArea.addComponentAsFirst(header.asComponent());
	}

	@Autowired(required = false)
	public void setMainMenu(DashboardMainMenu mainMenu) {
		addComponentAsFirst(mainMenu.asComponent());
	}

	@Override
	public CssLayout asComponent() {
		return this;
	}
}
