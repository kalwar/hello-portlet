package com.packtpub.learnvaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class HelloPortletUI extends UI {

	@Override
	protected void init(VaadinRequest request) {

		setContent(new HelloScreen());
	}
}