package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/{courseId}/del")
    public String deleteCourse(@PathVariable("courseId") int courseId, ModelMap model) {
        courseService.deleteCourse(courseId);
        return "redirect:/course";
    }

    @RequestMapping(value="/{courseId}/edit")
    public String editCourse(@PathVariable("courseId") int courseId, ModelMap model) {
        Course course = courseService.getCourse(courseId);
        model.addAttribute("course", course);
        return "course/edit";
    }

    @RequestMapping(value="/{courseId}/update")
    public String updateCourse(@ModelAttribute("course") Course course) {
        courseService.updateCourse(course);
        return "redirect:/course/" + course.getCourseId();
    }

    @RequestMapping
    public String showCourses(ModelMap model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "course/courses";
    }

    @RequestMapping(value = "/new")
    public String newCourse() {
        return "course/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doAddCourse(@ModelAttribute("course") Course course) {
        courseService.createCourse(course);
        return "redirect:/course/" + course.getCourseId();
    }
}
