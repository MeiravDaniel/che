/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.part.widgets.listtab;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.Presentation;

import javax.validation.constraints.NotNull;

/**
 * @author Roman Nikitenko
 */
public class ListItemActionWidget extends Composite implements ListItem<Action> {

    interface ListItemActionWidgetUiBinder extends UiBinder<Widget, ListItemActionWidget> {
    }

    private static final ListItemActionWidgetUiBinder UI_BINDER = GWT.create(ListItemActionWidgetUiBinder.class);

    private Action action;

    @UiField
    FlowPanel iconPanel;

    @UiField
    Label title;

    private ActionDelegate delegate;

    public ListItemActionWidget(@NotNull Action action) {
        initWidget(UI_BINDER.createAndBindUi(this));
        this.action = action;
        Presentation presentation = action.getTemplatePresentation();

//        Widget icon = action.getTemplatePresentation().getImageResource();
//        if (icon != null) {
//            iconPanel.add(icon);
//        }
        title.setText(presentation.getText());

        addDomHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (delegate != null) {
                    delegate.onItemClicked(ListItemActionWidget.this);
                }
            }
        }, ClickEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void setDelegate(ActionDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Action getData() {
        return action;
    }
}
