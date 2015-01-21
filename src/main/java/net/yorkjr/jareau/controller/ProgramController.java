package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.Program;
import net.yorkjr.jareau.service.CourseService;
import net.yorkjr.jareau.service.exceptions.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;;

/**
 * Created by lijunbo on 15/1/21.
 */
@Controller
@RequestMapping("/program")
@SessionAttributes
public class ProgramController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/{programId}")
    public String showProgram(@PathVariable("programId") int programId, ModelMap model) {
        model.addAttribute("program", courseService.getProgram(programId));
        model.addAttribute("selectedCourses", courseService.listCourseOfProgram(programId));
        model.addAttribute("availableCourses", courseService.listCourseOfNotProgram(programId));
        return "program/program";
    }

    @RequestMapping
    public String showPrograms(ModelMap model) {
        model.addAttribute("programs", courseService.listProgram());
        return "program/programs";
    }

    @RequestMapping(value = "/{programId}/del")
    public String delProgram(@PathVariable("programId") int programId) {
        courseService.deleteProgram(programId);
        return "redirect:/program";
    }

    @RequestMapping(value = "/{programId}/add_course", method = RequestMethod.POST)
    public String addCourse(@PathVariable("programId") int programId, @ModelAttribute("course") Course course) {
        courseService.addCourseToProgram(programId, course.getCourseId());
        return "redirect:/program/" + programId;
    }

    @RequestMapping(value = "/{programId}/{courseId}/remove")
    public String addCourse(@PathVariable("programId") int programId, @PathVariable("courseId") int courseId) {
        courseService.removeCourseFromProgram(programId, courseId);
        return "redirect:/program/" + programId;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProgram(@ModelAttribute("program") Program program) {
        try {
            courseService.createProgram(program);
        } catch (AlreadyExistsException e) {
            //TODO
        }
        return "redirect:/program";
    }
}
