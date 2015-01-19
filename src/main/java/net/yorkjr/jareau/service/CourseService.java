package net.yorkjr.jareau.service;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.Section;

import java.util.List;

/**
 * Created by lijunbo on 15/1/17.
 */
public interface CourseService {
    Course getCourse(int courseId);
    List<Course> getAllCourses();
    void createCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
    Section getSection(int sectionId);
    List<Section> getSectionsByCourseId(int courseId);
}
