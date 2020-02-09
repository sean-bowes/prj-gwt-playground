package com.koisoftware.monet.client.app.ui.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created by sb90320 on 11/2/2014.
 */
public interface MonetDetailViewImages extends ClientBundle {
    public MonetDetailViewImages INSTANCE = GWT.create(MonetDetailViewImages.class);

    @Source("images/header-banner.jpg")
    ImageResource headerBackGroundPanel();
}
