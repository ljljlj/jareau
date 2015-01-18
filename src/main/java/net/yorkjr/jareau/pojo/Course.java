package net.yorkjr.jareau.pojo;


import javax.persistence.*;
import java.util.List;

/**
 * Created by lijunbo on 15/1/10.
 */
@Entity
@Table(name = "course")
public class Course {

    int courseId;
    String courseName;
    String teacher;
    //String details;

    private List<Section> sections;

    @Id
    @Column(name = "course_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /*
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }*/

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    @OrderBy("sectionOrder ASC")
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
