package net.yorkjr.jareau.mapper;

import net.yorkjr.jareau.pojo.course.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lijunbo on 15/1/17.
 */
public interface CourseMapper {
    @Select("select * from course where course_id = #{courseId}")
    Course getCourseById(@Param("courseId") long courseId);

    @Select("select * from course")
    List<Course> getAllCourses();

    void createCourse(Course course);
}
