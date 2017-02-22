package com.vaadin.peter.dashboard;

import com.vaadin.peter.dashboard.ui.DashboardHeader;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CssLayout;

@SpringComponent
@UIScope
public class TestHeader extends CssLayout implements DashboardHeader {

	public TestHeader() {
		setWidth(100, Unit.PERCENTAGE);
		setHeight(50, Unit.PIXELS);
	}

	@Override
	public CssLayout asComponent() {
		return this;
	}

}
