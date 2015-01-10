package net.yorkjr.jareau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tylaar on 15/1/5.
 */
@Controller
@RequestMapping("/welcome")
public class HealthController {

    NumberFinder finder;

    @Autowired
    public HealthController(NumberFinder finder) {
        this.finder = finder;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello world");
        return "welcome";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String printNumber(@PathVariable int id, ModelMap model) {
        model.addAttribute("message", String.valueOf(id));
        return "welcome";
    }

}
