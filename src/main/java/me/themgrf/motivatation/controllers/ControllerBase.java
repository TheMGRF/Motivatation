package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.AppInfo;
import me.themgrf.motivatation.util.Auth;
import org.springframework.ui.Model;

public abstract class ControllerBase {

    public Model setup(Model model) {
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", getPageName());
        model.addAttribute("loggedIn", Auth.isLoggedIn());

        return model;
    }

    public abstract String getPageName();

}
