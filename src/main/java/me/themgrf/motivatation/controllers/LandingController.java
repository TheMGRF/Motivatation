package me.themgrf.motivatation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController extends ControllerBase {

    @GetMapping("/")
    public String landing(Model model) {
        model = super.setup(model);

        return "landing";
    }

    @Override
    public String getPageName() {
        return "Motivitation";
    }
}
