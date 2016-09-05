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

import org.eclipse.che.ide.api.mvp.View;

import javax.validation.constraints.NotNull;

/**
 * @author Dmitry Shnurenko
 * @author Vitaliy Guliy
 */
public interface ListItem<T> extends View<ListItem.ActionDelegate> {

    /** Returns associated data. */
    T getData();

    interface ActionDelegate {
        /**
         * Handle clicking on list item
         * @param listItem
         */
        void onItemClicked(@NotNull ListItem listItem);

        /**
         * Handle clicking on close icon
         * @param listItem
         */
        void onCloseButtonClicked(@NotNull ListItem listItem);
    }
}
