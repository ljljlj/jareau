package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.pojo.Section;
import net.yorkjr.jareau.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by lijunbo on 15/1/10.
 */
@Controller
@RequestMapping("/section")
@SessionAttributes
public class SectionController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value="/{sectionId}")
    public String showSection(@PathVariable("sectionId") int sectionId, ModelMap model) {
        Section section = courseService.getSection(sectionId);
        model.addAttribute("section", section);
        return "section/section";
    }
}
