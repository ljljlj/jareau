package net.yorkjr.jareau.service;

import net.yorkjr.jareau.mapper.CourseMapper;
import net.yorkjr.jareau.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lijunbo on 15/1/17.
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course getCourse(int courseId) {
        return courseMapper.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }
}
