package com.packtpub.learnvaadin;

import static javax.portlet.PortletMode.EDIT;
import static javax.portlet.PortletMode.VIEW;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.vaadin.server.VaadinPortletSession;
import com.vaadin.server.VaadinPortletSession.PortletListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings({ "serial", "deprecation" })
public class HelloScreen extends CustomComponent implements PortletListener {

	private Button button = new Button("Click Me");

	public HelloScreen() {

		final VerticalLayout layout = new VerticalLayout();

		layout.setMargin(true);

		setCompositionRoot(layout);

		button.addClickListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {

				layout.addComponent(new Label("Thank you for clicking"));
			}
		});

		layout.addComponent(button);

		if (VaadinSession.getCurrent() instanceof VaadinPortletSession) {

			VaadinPortletSession portletSession = (VaadinPortletSession) VaadinSession.getCurrent();

			portletSession.addPortletListener(this);
		}
	}

	@Override
	public void handleRenderRequest(RenderRequest request, RenderResponse response, UI uI) {

		PortletMode mode = request.getPortletMode();

		if (mode == VIEW) {

			button.setVisible(false);

		} else if (mode == EDIT) {

			button.setVisible(true);
		}
	}

	@Override
	public void handleActionRequest(ActionRequest request, ActionResponse response, UI uI) {
	}

	@Override
	public void handleEventRequest(EventRequest request, EventResponse response, UI uI) {
	}

	@Override
	public void handleResourceRequest(ResourceRequest request, ResourceResponse response, UI uI) {
	}
}
