package com.vaadin.peter.dashboard.ui.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

/**
 * DashboardMenuConfiguration is a Spring configuration bean that defines all
 * {@link DashboardMainMenu} related configuration.
 * 
 * @author Peter / Vaadin
 */
@Configuration
public class DashboardMenuConfiguration {

	@Autowired
	private ApplicationContext appContext;

	@Bean
	@UIScope
	@ConditionalOnMissingBean
	protected DashboardMainMenu configureDashboardMainMenu() {
		DashboardMainMenu mainMenu = new SimpleDashboardMenu();

		findMenuItemsToConfigure().forEach(menuItem -> {
			mainMenu.addItem(menuItem.getTranslationKey(), menuItem.getIcon(), menuItem.getNavigationTarget());
		});

		return mainMenu;
	}

	protected List<MenuItemConfiguration> findMenuItemsToConfigure() {
		return Arrays.asList(appContext.getBeanNamesForType(View.class)).stream().map(viewBeanName -> {
			Optional<ShowInMenu> menuDescriptor = Optional
					.ofNullable(appContext.findAnnotationOnBean(viewBeanName, ShowInMenu.class));
			Optional<SpringView> viewDescriptor = Optional
					.ofNullable(appContext.findAnnotationOnBean(viewBeanName, SpringView.class));

			if (menuDescriptor.isPresent() && viewDescriptor.isPresent()) {
				return new MenuItemConfiguration(menuDescriptor.get(), viewDescriptor.get());
			}

			return null;
		}).filter(Objects::nonNull).sorted().collect(Collectors.toList());
	}

	private static class MenuItemConfiguration implements Comparable<MenuItemConfiguration> {
		private ShowInMenu menuDescriptor;
		private SpringView viewDescriptor;

		public MenuItemConfiguration(ShowInMenu menuDescriptor, SpringView viewDescriptor) {
			this.menuDescriptor = Objects.requireNonNull(menuDescriptor);
			this.viewDescriptor = Objects.requireNonNull(viewDescriptor);
		}

		@Override
		public int compareTo(MenuItemConfiguration other) {
			return this.menuDescriptor.order() - other.menuDescriptor.order();
		}

		public VaadinIcons getIcon() {
			return menuDescriptor.icon();
		}

		public String getTranslationKey() {
			return menuDescriptor.translationKey();
		}

		public String getNavigationTarget() {
			return viewDescriptor.name();
		}
	}
}
