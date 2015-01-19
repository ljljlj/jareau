package net.yorkjr.jareau.service;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.Section;
import net.yorkjr.jareau.pojo.course.CourseCategory;
import net.yorkjr.jareau.service.exceptions.AlreadyExistsException;

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

    /** Course Section **/
    Section getSection(int sectionId);
    void createSection(Section section);
    List<Section> getSectionsByCourseId(int courseId);

    /** Course Category **/
    void createCourseCategory(String categoryName) throws AlreadyExistsException;
    void deleteCourseCategory(int categoryId);
    List<CourseCategory> listCourseCategory();
}
