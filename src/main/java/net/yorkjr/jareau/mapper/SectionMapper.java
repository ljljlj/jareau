package net.yorkjr.jareau.mapper;

import net.yorkjr.jareau.pojo.course.Section;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
public interface SectionMapper {
    @Select("select * from section where id = #{sectionId}")
    Section getSectionById(@Param("sectionId") int sectionId);

    @Select("select * from section where course_id = #{courseId}")
    List<Section> getSectionsByCourseId(@Param("courseId") int courseId);

    void createSection(Section section);
}
