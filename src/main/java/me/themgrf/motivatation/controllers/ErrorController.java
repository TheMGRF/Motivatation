package me.themgrf.motivatation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController extends ControllerBase implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model) {
        model = super.setup(model);

        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    @Override
    public String getPageName() {
        return "Motivatation | 404 - Page Not Found";
    }
}
