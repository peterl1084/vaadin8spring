package com.vaadin.peter.dashboard.ui.test;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.peter.dashboard.ui.menu.ShowInMenu;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

@SpringView(name = "")
@ShowInMenu(icon = VaadinIcons.ROCKET, order = 0, translationKey = "test")
public class TestView extends CssLayout implements View {

	@Autowired
	private Grid<TestBean> testBeanGrid;

	public TestView() {
		setSizeFull();
	}

	@PostConstruct
	protected void initialize() {
		testBeanGrid.setSizeFull();
		addComponent(testBeanGrid);

		TestBean a = new TestBean("Mr", "Vaadin", LocalDate.of(2000, 1, 1));
		TestBean b = new TestBean("Mr", "GWT", LocalDate.of(2000, 1, 1));

		testBeanGrid.setItems(a, b);
		testBeanGrid.setSelectionMode(SelectionMode.SINGLE);

		testBeanGrid.getEditor().setEnabled(true);
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
