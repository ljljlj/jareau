package net.yorkjr.jareau.mapper;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.CourseCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lijunbo on 15/1/17.
 */
public interface CourseMapper {
    @Select("select * from course where course_id = #{courseId}")
    Course getCourseById(@Param("courseId") int courseId);

    @Select("select * from course")
    List<Course> getAllCourses();

    void createCourse(Course course);

    void updateCourse(Course course);

    @Delete("delete from course where course_id=#{courseId}")
    void deleteCourse(int courseId);

    /** Course Category **/

    @Insert("insert into course_category (course_category_name) values (#{category})")
    void createCourseCategory(@Param("category") String category);

    @Select("select * from course_category")
    List<CourseCategory> listCourseCategory();

    @Delete("delete from course_category where course_category_id = #{categoryId}")
    void deleteCourseCategory(@Param("categoryId") int categoryId);
}
