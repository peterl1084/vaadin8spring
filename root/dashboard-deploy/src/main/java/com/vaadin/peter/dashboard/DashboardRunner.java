package com.vaadin.peter.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vaadin.peter.addon.beangrid.EnableBeanGrid;
import com.vaadin.peter.addon.beangrid.GridConfigurationProvider;

@SpringBootApplication
public class DashboardRunner extends SpringBootServletInitializer {

	@Configuration
	@EnableBeanGrid
	public class DashboardConfiguration {

	}

	public static void main(final String[] args) {
		SpringApplication.run(DashboardRunner.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(DashboardRunner.class);
	}

	@Bean
	public GridConfigurationProvider provideGridConfiguration() {
		return new GridConfigurationProvider() {

			@Override
			public String resolveTranslationKey(String key) {
				return key;
			}
		};
	}
}
