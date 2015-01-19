package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.CourseCategory;
import net.yorkjr.jareau.service.CourseService;
import net.yorkjr.jareau.service.exceptions.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("course", courseService.getCourse(courseId));
        model.addAttribute("error", "");
        model.addAttribute("categories", courseService.listCourseCategory());
        return "course/edit";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String updateCourse(@ModelAttribute("course") Course course, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("error", result.getAllErrors().toString());
            return "course/edit";
        }
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
    public String newCourse(ModelMap model) {
        model.addAttribute("categories", courseService.listCourseCategory());
        return "course/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doAddCourse(@ModelAttribute("course") Course course) {
        courseService.createCourse(course);
        return "redirect:/course/" + course.getCourseId();
    }

    @RequestMapping(value = "/category")
    public String viewCourseCategories(ModelMap model) {
        model.addAttribute("courseCategories", courseService.listCourseCategory());
        return "course/course_category";
    }

    @RequestMapping(value = "/category/{categoryId}/del")
    public String delCourseCategory(@PathVariable("categoryId") int categoryId) {
        courseService.deleteCourseCategory(categoryId);
        return "redirect:/course/category";
    }

    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    public String createCourseCategory(@ModelAttribute("category") CourseCategory category) {
        try {
            courseService.createCourseCategory(category.getCourseCategoryName());
        } catch (AlreadyExistsException e) {

        }
        return "redirect:/course/category";
    }
}
