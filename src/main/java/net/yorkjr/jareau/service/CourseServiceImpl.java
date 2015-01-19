package net.yorkjr.jareau.service;

import net.yorkjr.jareau.mapper.CourseMapper;
import net.yorkjr.jareau.mapper.SectionMapper;
import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.Section;
import net.yorkjr.jareau.pojo.course.CourseCategory;
import net.yorkjr.jareau.service.exceptions.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lijunbo on 15/1/17.
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public Course getCourse(int courseId) {
        return courseMapper.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }

    @Override
    public void createCourse(Course course) {
        courseMapper.createCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseMapper.deleteCourse(courseId);
    }

    @Override
    public Section getSection(int sectionId) {
        return sectionMapper.getSectionById(sectionId);
    }

    @Override
    public void createSection(Section section) {
        sectionMapper.createSection(section);
    }

    @Override
    public List<Section> getSectionsByCourseId(int courseId) {
        return sectionMapper.getSectionsByCourseId(courseId);
    }

    public void createCourseCategory(String categoryName) throws AlreadyExistsException {
        try {
            courseMapper.createCourseCategory(categoryName);
        } catch (DuplicateKeyException e) {
            throw new AlreadyExistsException("Course category " + categoryName + " already exists.", e);
        }
    }

    @Override
    public void deleteCourseCategory(int categoryId) {
        courseMapper.deleteCourseCategory(categoryId);
    }

    @Override
    public List<CourseCategory> listCourseCategory() {
        return courseMapper.listCourseCategory();
    }
}
