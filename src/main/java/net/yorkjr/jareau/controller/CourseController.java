package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.pojo.Course;
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
@RequestMapping("/course")
@SessionAttributes
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value="/{courseId}")
    public String showCourse(@PathVariable("courseId") int courseId, ModelMap model) {
        Course course = courseService.getCourse(courseId);
        model.addAttribute("course", course);
        return "course/course";
    }

    @RequestMapping
    public String showCourses(ModelMap model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "course/courses";
    }
}
