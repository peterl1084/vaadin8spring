package com.vaadin.peter.dashboard.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
@Widgetset("com.vaadin.peter.dashboard.widgetset.DashboardWidgetset")
@Theme("dashboard")
public class DashboardUI extends UI {

	@Override
	protected void init(VaadinRequest request) {

	}
}
