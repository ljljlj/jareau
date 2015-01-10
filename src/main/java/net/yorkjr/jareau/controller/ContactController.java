package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.pojo.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tylaar on 15/1/10.
 */
@Controller
@RequestMapping("/contact")
@SessionAttributes
public class ContactController {
    @RequestMapping(value = "addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")Contact contact, BindingResult result) {
        System.out.println("receive post message to backend: " + contact.getFirstName() + " "
                + contact.getLastName());
        return "redirect:contacts.html";
    }

    @RequestMapping(value = "contacts")
    public ModelAndView showContact() {
        return new ModelAndView("contact", "command", new Contact());
    }
}
