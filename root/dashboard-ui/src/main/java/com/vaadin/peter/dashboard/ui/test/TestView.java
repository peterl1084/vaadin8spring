package com.vaadin.peter.dashboard.ui.test;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.peter.dashboard.ui.menu.ShowInMenu;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

@SpringView(name = "")
@ShowInMenu(icon = VaadinIcons.ROCKET, order = 0, translationKey = "test")
public class TestView extends CssLayout implements View {

	public TestView() {
		Label label = new Label(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi gravida rhoncus ultricies. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque elit velit, convallis consectetur sapien a, efficitur elementum lacus. Donec ut pretium mi. Vivamus accumsan nec nunc quis mattis. Maecenas dapibus eleifend augue, vitae dictum ante. Nulla tempor imperdiet suscipit. Nunc auctor gravida bibendum. Curabitur ullamcorper vulputate orci, quis eleifend eros efficitur ac. Fusce commodo aliquet bibendum. Suspendisse ac velit velit. Aliquam tempus felis sem. Aenean tortor nunc, fermentum in nisl et, pellentesque suscipit massa. Nulla mattis augue enim. Praesent eu est libero. Nulla lorem nisl, dapibus vel pellentesque ac, cursus id magna. Sed vitae dignissim ipsum. Integer feugiat ultrices enim sed lacinia. Nunc blandit facilisis sapien sit amet pulvinar. Praesent nec libero tincidunt, tincidunt odio quis, rutrum sem. Morbi dictum justo metus. In efficitur, risus sed sodales mollis, dolor justo tincidunt felis, a dapibus lacus mauris ut metus. Aenean quis suscipit mi. Curabitur id sem scelerisque, ultrices nulla eu, laoreet leo. Duis bibendum, erat id aliquet aliquam, nisl velit auctor ipsum, ut molestie quam erat id justo. Cras ac mi mattis, consectetur sapien ut, suscipit ex. Donec id turpis iaculis, mattis mi a, elementum felis. Sed vitae venenatis dui. Duis scelerisque sem congue venenatis tempus. Duis volutpat magna mattis tortor venenatis mattis. Morbi cursus suscipit risus, eu consequat lectus commodo sed. In hac habitasse platea dictumst. Donec sed luctus velit, dapibus commodo metus. Nam eu erat cursus, luctus eros nec, porttitor felis. Quisque auctor tincidunt purus id ultricies. Proin hendrerit quis magna eget egestas. Nulla facilisi. Sed vehicula sit amet nulla eget volutpat. Fusce convallis, sem vel porttitor euismod, dui neque placerat risus, id bibendum mauris nisl vitae sapien. Sed eu interdum elit. Nulla finibus, orci nec laoreet efficitur, ligula tortor venenatis metus, non euismod eros tellus consequat nulla. Integer a faucibus risus. Praesent viverra congue leo id dictum. Mauris consectetur arcu vel risus egestas posuere. Vestibulum mollis sem elementum tellus pharetra aliquam. Mauris accumsan cursus lacus, nec varius lectus tincidunt sit amet. In maximus at felis nec posuere. Donec ultricies magna ac lorem fermentum congue. Nunc ut tortor sed nibh lacinia vestibulum vel a dui.");
		label.setWidth(100, Unit.PERCENTAGE);
		addComponent(label);
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
