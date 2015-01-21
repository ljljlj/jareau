package net.yorkjr.jareau.mapper;

import net.yorkjr.jareau.pojo.course.Course;
import net.yorkjr.jareau.pojo.course.Program;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lijunbo on 15/1/21.
 */
public interface ProgramMapper {
    @Select("select * from program where program_id = #{programId}")
    Program getProgram(@Param("programId") int programId);

    @Insert("insert into program (program_name) values (#{programName})")
    void createProgram(Program program);

    @Select("select * from program")
    List<Program> listProgram();

    @Delete("delete from program where program_id = #{programId}")
    void deleteProgram(@Param("programId") int programId);

    @Delete("delete from program_course_map where program_id = #{programId}")
    void removeProgramMap(@Param("programId") int programId);

    @Insert("insert into program_course_map (program_id, course_id) values (#{programId}, #{courseId})")
    void addCourseToProgram(@Param("programId") int programId, @Param("courseId") int courseId);

    @Delete("delete from program_course_map where program_id = #{programId} and course_id = #{courseId}")
    void removeCourseFromProgram(@Param("programId") int programId, @Param("courseId") int courseId);

    @Select("select * from course where course_id in (select course_id from program_course_map where program_id=#{programId})")
    List<Course> listCourseOfProgram(@Param("programId") int programId);

    @Select("select * from course where course_id not in (select course_id from program_course_map where program_id=#{programId})")
    List<Course> listCourseOfNotProgram(@Param("programId") int programId);
}
