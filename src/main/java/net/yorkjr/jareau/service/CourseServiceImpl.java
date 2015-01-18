package net.yorkjr.jareau.service;

import net.yorkjr.jareau.dao.SectionDao;
import net.yorkjr.jareau.mapper.CourseMapper;
import net.yorkjr.jareau.pojo.Course;
import net.yorkjr.jareau.pojo.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lijunbo on 15/1/17.
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private SectionDao sectionDao;

    @Override
    public Course getCourse(int courseId) {
        return courseMapper.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }

    @Override
    public Section getSection(int sectionId) {
        return sectionDao.get(sectionId);
    }
}
