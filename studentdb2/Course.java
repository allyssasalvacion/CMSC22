package studentdb2;

import java.io.Serializable;

/**
 * Created by Allyssa Albores on 03/11/2016.
 */
public class Course implements Serializable{
    private String courseCode;
    private String courseDescription;

    public Course(String courseCode, String courseDescription) {
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }

    public String toString() {
        return "Course Code: " + courseCode + "\n" + "Course Description: " + courseDescription;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
