package net.yorkjr.jareau.pojo.course;

/**
 * A section/class period of a course
 */
public class Section {

    private int id;
    private int courseId;
    private int sectionOrder;
    private int duration;
    private String name;
    private String description;
    private String videoId;
    private String details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public int getSectionOrder() {
        return sectionOrder;
    }

    public void setSectionOrder(int sectionOrder) {
        this.sectionOrder = sectionOrder;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * @return section duration, in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration section duration, in minutes
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
