package com.example;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

@WicketHomePage
@MountPath("home")
@AuthorizeInstantiation("USER")
public class HomePage extends BasePage {
    public HomePage(PageParameters parameters) {
        super(parameters);
    }
}
