package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.Section;
import net.yorkjr.jareau.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/new")
    public String newSection(@RequestParam("courseId") int courseId, ModelMap model) {
        Section section = new Section();
        section.setCourseId(courseId);
        Course course = courseService.getCourse(courseId);

        model.addAttribute("section", section);
        model.addAttribute("course", course);

        return "section/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doAddCourse(@ModelAttribute("section") Section section) {
        courseService.createSection(section);
        return "redirect:/course/" + section.getCourseId();
    }
}
