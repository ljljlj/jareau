package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.Section;
import net.yorkjr.jareau.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/section")
@SessionAttributes
public class SectionController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value="/{sectionId}")
    public String showSection(@PathVariable("sectionId") int sectionId, ModelMap model) {
        Section section = courseService.getSection(sectionId);
        Course course = courseService.getCourse(section.getCourseId());
        List<Section> relatedSections = courseService.getSectionsByCourseId(section.getCourseId());
        model.addAttribute("section", section);
        model.addAttribute("relatedSections", relatedSections);
        model.addAttribute("course", course);
        return "section/section";
    }
}
